package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ValidAspect;
import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;


    @ValidAspect
    @PostMapping()
    public ResponseEntity<?> feedSave(@Valid @RequestBody SaveFeedReqDto saveFeedReqDto, BindingResult bindingResult) {
        feedService.saveFeed(saveFeedReqDto);

        return ResponseEntity.ok(true);
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> feedList() {

        return ResponseEntity.ok(feedService.searchFeeds());
    }

//    @PostMapping("/like/{feedId}")
//    public ResponseEntity<?> feedLike(@PathVariable int feedId) {
//
//        return null;
//    }
//
//    @DeleteMapping("/like/{feedId}")
//    public ResponseEntity<?> feedUnLike(@PathVariable int feedId) {
//
//        return null;
//    }

}
