package com.team_soop.soop.jwt;

import com.team_soop.soop.entity.User;
import com.team_soop.soop.repository.UserMapper;
import com.team_soop.soop.security.PrincipalUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.security.Key;
import java.util.Collection;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {

    private final Key key;
    private UserMapper userMapper;

    // 생성자 정의
    public JwtProvider(
            @Value("${jwt.secret}") String secret,
            @Autowired UserMapper userMapper) {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.userMapper = userMapper;
    }

    // 새로운 토큰 생성
    public String generateToken (User user) {
        int userId = user.getUserId();
        String username = user.getUsername();
        String nickname = user.getNickname();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 19));

        String accessToken = Jwts.builder()
                .claim("userId", userId)
                .claim("username", username)
                .claim("nickname", nickname)
                .claim("authorities", authorities)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return accessToken;
    }

    // 토큰 번호 앞 Bearer 제거
    public String removeBearer(String token) {
        if(!StringUtils.hasText(token)) {
            return null;
        }
        return token.substring("Bearer ".length());
    }

    // 토큰을 secret yaml 에서 지정한 key로 만들었는지 확인
    // 토큰 유효성 검사
    public Claims getClaims(String token) {
        Claims claims = null;

        claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    // DB에 이 토큰을 가진 user정보가 존재하는지
    // 찾아온 USER 객체를 PrincipalUser로 변경해서 올리기
    public Authentication getAuthentication(Claims claims) {
        String username = claims.get("username").toString();
        User user = userMapper.findUserByUsername(username);
        if(user == null) {
            // 토큰은 유효하지만 DB에서 USER정보가 삭제되었을 경우
            return null;
        }
        PrincipalUser principalUser = user.toPrincipalUser();
        return new UsernamePasswordAuthenticationToken(principalUser, principalUser.getPassword(), principalUser.getAuthorities());
    }

    // 5분안에 인증해야되는 토큰 발행
    // 5분 뒤에 인증 누르면 유효하지 않은 토큰 받음
    public String generateAuthMailToken(int userId, String toMailAddress) {
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 5));
        return Jwts.builder()
                .claim("userId", userId)
                .claim("toMailAddress", toMailAddress)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
