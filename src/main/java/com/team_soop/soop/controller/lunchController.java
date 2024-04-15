package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveLunchReqDto;
import com.team_soop.soop.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/serach")
    public ResponseEntity<?> searchLunch() {

        return ResponseEntity.ok(null);
    }

}
