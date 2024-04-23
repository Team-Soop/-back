package com.team_soop.soop.service;

import com.team_soop.soop.dto.*;
import com.team_soop.soop.entity.*;
import com.team_soop.soop.repository.FeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {

    @Autowired
    private FeedMapper feedMapper;

    // 피드 POST
    @Transactional(rollbackFor = Exception.class)
    public void saveFeed(SaveFeedReqDto saveFeedReqDto) {

        Feed feed = saveFeedReqDto.toFeed();

        feedMapper.saveFeed(feed);

        if(saveFeedReqDto.getFeedImgUrls().size() != 0) {
            feedMapper.saveFeedImgUrl(feed.getFeedId(), saveFeedReqDto.getFeedImgUrls());
        }

    }
    // 피드 전체 GET
    public List<SearchFeedRespDto> searchFeeds() {
        List<FeedList> feedLists = feedMapper.searchFeeds();
        List<SearchFeedRespDto> searchFeedRespDtos = new ArrayList<>();
        for (FeedList feedList : feedLists) {
            searchFeedRespDtos.add(feedList.searchFeedRespDto());
        }
        return searchFeedRespDtos;
    }
    // 좋아요 등록
    public void likeFeed(int userId, int feedId) {
        feedMapper.saveFeedLike(FeedLike.builder().userId(userId).feedId(feedId).build());
    }

    public void unLikeFeed(int userId, int feedId) {
        feedMapper.deleteFeedLike(FeedLike.builder().userId(userId).feedId(feedId).build());
    }

    // 좋아요 get
    public LikeStatus getLikeStatus(int userId, int feedId) {
        return feedMapper.getLikeStatus(userId, feedId);
    }

    // 댓글 작성
    @Transactional(rollbackFor = Exception.class)
    public void saveFeedComment(SaveFeedCommentReqDto saveFeedCommentReqDto) {
        FeedComment feedComment = saveFeedCommentReqDto.toFeedComment();

        feedMapper.saveFeedComment(feedComment);
    }


}
