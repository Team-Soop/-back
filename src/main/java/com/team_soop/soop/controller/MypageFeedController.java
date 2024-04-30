package com.team_soop.soop.controller;

import com.team_soop.soop.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/mypage/feed")
public class MypageFeedController {

    @Autowired
    private FeedService feedService;

    @ResponseBody
    @GetMapping("/{userId}")
    public ResponseEntity<?> mypageFeedList(@PathVariable int userId) {
        return ResponseEntity.ok(feedService.mypageSearchFeeds(userId));
    }

    @DeleteMapping("/{feedId}")
    public ResponseEntity<?> deleteFeed(@PathVariable int feedId) {

        return ResponseEntity.ok(feedService.deleteMypageFeed(feedId));
    }
}
