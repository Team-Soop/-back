package com.team_soop.soop.controller;


import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.service.BoardService;
import com.team_soop.soop.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/mypage/feed")
public class MypageFeedController {

    @Autowired
    private FeedService feedService;
    @Autowired
    private BoardService boardService;

    @ResponseBody
    @GetMapping("/{userId}")
    public ResponseEntity<?> mypageFeedList(@PathVariable int userId) {
        return ResponseEntity.ok(feedService.mypageSearchFeeds(userId));
    }

    @ParamsPrintAspect
    @DeleteMapping("/{menuCategoryName}/{feedId}/delete")
    public ResponseEntity<?> deleteFeed(@PathVariable String menuCategoryName, @PathVariable int feedId) {
        feedService.deleteBoard(menuCategoryName, feedId);
        System.out.println(menuCategoryName);
        System.out.println(feedId);
        return ResponseEntity.ok(null);
    }


}
