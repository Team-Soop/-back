package com.team_soop.soop.service;

import com.team_soop.soop.dto.OAuth2MergeReqDto;
import com.team_soop.soop.dto.OAuth2SignupReqDto;
import com.team_soop.soop.dto.SigninReqDto;
import com.team_soop.soop.dto.SignupReqDto;
import com.team_soop.soop.entity.OAuth2;
import com.team_soop.soop.entity.User;
import com.team_soop.soop.exception.SaveException;
import com.team_soop.soop.jwt.JwtProvider;
import com.team_soop.soop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.prefs.BackingStoreException;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;

    @Transactional(rollbackFor = Exception.class)
    public void signup (SignupReqDto signupReqDto) {
        int successCount = 0;
        User user = signupReqDto.toEntity(passwordEncoder);

        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);

        if(successCount < 2) {
            throw new SaveException();
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void oAuth2Signup(OAuth2SignupReqDto oAuth2SignupReqDto) {
        int successCount = 0;
        User user = oAuth2SignupReqDto.toEntity(passwordEncoder);
        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);
        successCount += userMapper.saveOAuth2(oAuth2SignupReqDto.toOAuth2Entity(user.getUserId()));

        if(successCount < 3) {
            throw new SaveException();
        }
    }


    public String signin(SigninReqDto signinReqDto) {
        User user = userMapper.findUserByUsername(signinReqDto.getUsername());
        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if(!passwordEncoder.matches(signinReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }

        // 토큰 생성 메소드 generateToken()
        return jwtProvider.generateToken(user);
    }

    public void oAuth2Merge(OAuth2MergeReqDto oAuth2MergeReqDto) {
        User user = userMapper.findUserByUsername(oAuth2MergeReqDto.getUsername());

        System.out.println(oAuth2MergeReqDto);

        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if(!passwordEncoder.matches(oAuth2MergeReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }
        OAuth2 oAuth2 = OAuth2.builder()
                .oAuth2Name(oAuth2MergeReqDto.getOauth2Name())
                .userId(user.getUserId())
                .providerName(oAuth2MergeReqDto.getProviderName())
                .build();

        userMapper.saveOAuth2(oAuth2);
    }




}
