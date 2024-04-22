package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveLunchCommentReqDto;
import com.team_soop.soop.dto.SaveLunchReqDto;
import com.team_soop.soop.dto.UpdateLunchCommentReqDto;
import com.team_soop.soop.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lunch")
public class LunchController {

    @Autowired
    private LunchService lunchService;

    @PostMapping("/save")
    public ResponseEntity<?> lunchSave(@RequestBody SaveLunchReqDto saveLunchReqDto) {
        lunchService.saveLunch(saveLunchReqDto);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/comment/save")
    public ResponseEntity<?> lunchCommentSave(@RequestBody SaveLunchCommentReqDto saveLunchCommentReqDto) {
        lunchService.saveLunchComment(saveLunchCommentReqDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchLunch() {
        return ResponseEntity.ok(lunchService.searchLunchList());
    }


    @PostMapping("/comment/search")
    public ResponseEntity<?> searchLunchComment(@RequestParam int detailLunchId) {
        return ResponseEntity.ok(lunchService.searchLunchComment1(detailLunchId));
    }

    @PutMapping("/comment/update")
    public ResponseEntity<?> updateLunchComment (@RequestBody UpdateLunchCommentReqDto updateLunchCommentReqDto) {
        lunchService.updateComment(updateLunchCommentReqDto);
        return ResponseEntity.ok(true);
    }


    @DeleteMapping("/comment/delete/{commentId}")
    public ResponseEntity<?> deleteLunchComment (@PathVariable int commentId) {
        lunchService.deleteComment(commentId);
        return ResponseEntity.ok(true);
    }






}
