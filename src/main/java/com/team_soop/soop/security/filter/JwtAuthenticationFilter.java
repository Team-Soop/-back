package com.team_soop.soop.security.filter;

import com.team_soop.soop.jwt.JwtProvider;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends GenericFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Boolean isPermitAll = (Boolean) request.getAttribute("isPermitAll");

        if(!isPermitAll) {
            String accessToken = request.getHeader("Authorization");
            // Bearer가 제거된 완전한 토큰값
            String removedBearerToken = jwtProvider.removeBearer(accessToken);
            Claims claims = null;

            try {
                claims = jwtProvider.getClaims(removedBearerToken);
            } catch (Exception e) {
                response.sendError(HttpStatus.UNAUTHORIZED.value()); // 인증 실패 ( 토큰이 없을 시)
                return;
            }
            // DB에 이 토큰을 가진 user정보가 존재하는지
            // 찾아온 USER 객체를 PrincipalUser로 변경해서 authentication 에 올리기
            Authentication authentication = jwtProvider.getAuthentication(claims);

            if(authentication == null) {
                response.sendError(HttpStatus.UNAUTHORIZED.value());  //인증실패 (토큰은 있는데 DB에 user정보가 없을 시)
                return;
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // 전처리
        filterChain.doFilter(request, response);
        // 후처리

    }





}
