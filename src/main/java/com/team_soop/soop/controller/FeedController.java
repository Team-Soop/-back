package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @ParamsPrintAspect
    @PostMapping()
    public ResponseEntity<?> saveFeed(@RequestBody SaveFeedReqDto saveFeedReqDto) {
        feedService.saveFeed(saveFeedReqDto);

        return ResponseEntity.ok(null);
    }
}
