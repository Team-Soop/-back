package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SendAlarmReqDto;
import com.team_soop.soop.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    AlarmService alarmService;

    @ParamsPrintAspect
    @PostMapping("/send")
    public ResponseEntity<?> SendAlarm(@RequestBody SendAlarmReqDto sendAlarmReqDto) {
        alarmService.sendAlarmMessage(sendAlarmReqDto);
        return ResponseEntity.ok(null);
    }





}
