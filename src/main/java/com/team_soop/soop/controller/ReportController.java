package com.team_soop.soop.controller;

import com.team_soop.soop.dto.SaveReportReqDto;
import com.team_soop.soop.dto.SearchReportReqDto;
import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/save")
    public ResponseEntity<?> saveReport(@RequestBody SaveReportReqDto saveReportReqDto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        reportService.saveReport(saveReportReqDto, userId);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/search")
    public ResponseEntity<?> searchReport(SearchReportReqDto searchReportReqDto) {
        return ResponseEntity.ok(reportService.searchReport(searchReportReqDto));
    }

}
