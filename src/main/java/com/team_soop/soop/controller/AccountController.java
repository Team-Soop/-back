package com.team_soop.soop.controller;


import com.team_soop.soop.security.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    // 토큰이있다면 SecurityConfig Config 에있는 filter 들을 거쳐 이 Controller 가 실행됨
    // filter들을 거치면서 SecurityContextHolder 에 Authentication 에 들어있는 PrincipalUser 객체를 꺼내
    // response로 담아서 반환
    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return ResponseEntity.ok(principalUser);
    }


}
