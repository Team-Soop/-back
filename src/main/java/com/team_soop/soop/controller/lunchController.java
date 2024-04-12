package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveLunchReqDto;
import com.team_soop.soop.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lunch")
public class lunchController {

    @Autowired
    private LunchService lunchService;

    @PostMapping("/save")
    @ParamsPrintAspect
    public ResponseEntity<?> lunchSave(@RequestBody SaveLunchReqDto saveLunchReqDto) {
        lunchService.saveLunch(saveLunchReqDto);
        return ResponseEntity.ok(true);
    }

}
