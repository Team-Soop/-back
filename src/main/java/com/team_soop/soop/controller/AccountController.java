package com.team_soop.soop.controller;


import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.aop.annotation.ValidAspect;
import com.team_soop.soop.dto.EditAccountReqDto;
import com.team_soop.soop.dto.EditPasswordReqDto;
import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.AccountService;
import com.team_soop.soop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 토큰이있다면 SecurityConfig Config 에있는 filter 들을 거쳐 이 Controller 가 실행됨
    // filter들을 거치면서 SecurityContextHolder 에 Authentication 에 들어있는 PrincipalUser 객체를 꺼내
    // response로 담아서 반환
    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return ResponseEntity.ok(principalUser);
    }

    @ValidAspect
    @PutMapping("/password")
    public ResponseEntity<?> editPassword(
            @Valid @RequestBody EditPasswordReqDto editPasswordReqDto,
            BindingResult bindingResult) {

        accountService.editPassword(editPasswordReqDto);
        return ResponseEntity.ok(true);
    }

    @ParamsPrintAspect
    @PutMapping("/edit")
    public ResponseEntity<?> editAccount(@RequestBody EditAccountReqDto editAccountReqDto) {
        System.out.println(editAccountReqDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("find/username/{username}")
    public ResponseEntity<?> duplicateUsernameCheck(@PathVariable String username) {
        return ResponseEntity.ok(accountService.duplicateUsernameCheck(username));
    }

}