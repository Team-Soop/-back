package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/mypage/lunch")
public class MyPageLunchController {

    @Autowired
    LunchService lunchService;

    @ParamsPrintAspect
    @GetMapping("/{userId}")
    public ResponseEntity<?> myPageLunchList(@PathVariable int userId) {
        return ResponseEntity.ok(lunchService.myPageSearchLunchs(userId));
    }

}
