package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.aop.annotation.ValidAspect;
import com.team_soop.soop.dto.LikeFeedReqDto;
import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @ParamsPrintAspect
    @PostMapping("/like")
    public ResponseEntity<?> feedLike(@RequestBody LikeFeedReqDto likeFeedReqDto) {
        feedService.likeFeed(likeFeedReqDto);
        return ResponseEntity.ok(null);
    }

    @ParamsPrintAspect
    @DeleteMapping("/like")
    public ResponseEntity<?> feedUnLike(@RequestBody LikeFeedReqDto likeFeedReqDto) {
        feedService.unLikeFeed(likeFeedReqDto);
        return ResponseEntity.ok(null);
    }

    @ParamsPrintAspect
    @GetMapping("/like")
    @ResponseBody
    public ResponseEntity<?> feedLikeList() {

        return ResponseEntity.ok(feedService.searchLikeFeed());
    }

}
