package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.AddScheduleReqDto;
import com.team_soop.soop.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @ParamsPrintAspect
    @PostMapping()
    public ResponseEntity<?> addSchedule (@RequestBody List<AddScheduleReqDto> addScheduleReqDto) {
        scheduleService.addSchedule(addScheduleReqDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping()
    public ResponseEntity<?> searchSchedule () {
        return ResponseEntity.ok(scheduleService.searchAllSchedule());
    }
}
