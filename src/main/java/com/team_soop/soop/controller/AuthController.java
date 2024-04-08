package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.aop.annotation.ValidAspect;
import com.team_soop.soop.dto.OAuth2MergeReqDto;
import com.team_soop.soop.dto.OAuth2SignupReqDto;
import com.team_soop.soop.dto.SigninReqDto;
import com.team_soop.soop.dto.SignupReqDto;
import com.team_soop.soop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Value("${spring.security.oauth2.client.registration.kakao.clientId}")
    private String kakaoClientId;
    @Autowired
    private AuthService authService;

    @ParamsPrintAspect
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
        authService.signup(signupReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @ValidAspect
    @ParamsPrintAspect
    @PostMapping("/oauth2/signup")
    public ResponseEntity<?> oAuth2Signup(@Valid @RequestBody OAuth2SignupReqDto oAuth2SignupReqDto, BindingResult bindingResult) {
        authService.oAuth2Signup(oAuth2SignupReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninReqDto signinReqDto) {
        return ResponseEntity.ok(authService.signin(signinReqDto));
    }

    @ParamsPrintAspect
    @PostMapping("/oauth2/merge")
    public ResponseEntity<?> oAuth2Merge(@RequestBody OAuth2MergeReqDto oAuth2MergeReqDto) {
        authService.oAuth2Merge(oAuth2MergeReqDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/oauth2/logout")
    public ResponseEntity<?> oAuth2Logout(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=" + kakaoClientId + "&logout_redirect_uri=http://localhost:3000/auth/logout");
        return null;
    }



}
