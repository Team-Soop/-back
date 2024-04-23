package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.aop.annotation.ValidAspect;
import com.team_soop.soop.dto.LikeFeedReqDto;
import com.team_soop.soop.dto.LikeFeedRespDto;
import com.team_soop.soop.dto.SaveFeedCommentReqDto;
import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @PostMapping("/{feedId}/like")
    public ResponseEntity<?> feedLike(@PathVariable int feedId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        feedService.likeFeed(userId, feedId);
        return ResponseEntity.ok(null);
    }

    @ParamsPrintAspect
    @DeleteMapping("/{feedId}/like")
    public ResponseEntity<?> feedUnLike(@PathVariable int feedId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        feedService.unLikeFeed(userId, feedId);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/{feedId}/like")
    public ResponseEntity<?> getFeedLike(@PathVariable int feedId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        return ResponseEntity.ok(feedService.getLikeStatus(userId, feedId));
    }

    // 댓글 등록
    @PostMapping("/comment/save")
    public ResponseEntity<?> feedCommentSave(@RequestBody SaveFeedCommentReqDto saveFeedCommentReqDto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        System.out.println(userId);

        feedService.saveFeedComment(saveFeedCommentReqDto, userId);

        return ResponseEntity.ok(true);
    }

    // 댓글 GET
    @GetMapping("/{feedId}/comment")
    public ResponseEntity<?> feedCommentSearch(@PathVariable int feedId) {
        return ResponseEntity.ok(feedService.searchFeedComment(feedId));
    }





}
