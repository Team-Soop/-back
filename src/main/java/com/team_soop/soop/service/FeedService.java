package com.team_soop.soop.service;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
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
    // 좋아요 취소
    public void unLikeFeed(int userId, int feedId) {
        feedMapper.deleteFeedLike(FeedLike.builder().userId(userId).feedId(feedId).build());
    }

    // 좋아요 get
    public LikeStatus getLikeStatus(int userId, int feedId) {
        return feedMapper.getLikeStatus(userId, feedId);
    }

    // 댓글 작성
    @ParamsPrintAspect
    @Transactional(rollbackFor = Exception.class)
    public void saveFeedComment(SaveFeedCommentReqDto saveFeedCommentReqDto, int userId) {
        saveFeedCommentReqDto.setCommentUserId(userId);
        FeedComment feedComment = saveFeedCommentReqDto.toFeedComment();
        feedMapper.saveFeedComment(feedComment);
    }

    // 댓글 리스트 조회
    @Transactional(rollbackFor = Exception.class)
    public List<SearchFeedCommentRespDto> searchFeedComment(int feedId) {
        List<FeedComment> feedComments = feedMapper.searchFeedComment(feedId);

        List<SearchFeedCommentRespDto> SearchFeedCommentRespDto = new ArrayList<>();

        for(FeedComment feedComment : feedComments){
            SearchFeedCommentRespDto.add(feedComment.toSearchFeedCommentRespDto());
        }

        return SearchFeedCommentRespDto;
    }

    // 댓글 수정
    @Transactional(rollbackFor = Exception.class)
    public void updateComment(UpdateFeedCommentReqDto updateFeedCommentReqDto) {
        feedMapper.modifyComment(updateFeedCommentReqDto.toFeedComment());
    }

    // 댓글 삭제
    @ParamsPrintAspect
    @Transactional(rollbackFor = Exception.class)
    public void deleteComment(int commentId, int userId) {
        feedMapper.deleteComment(commentId, userId);
    }

    // 마이페이지 피드 조회
    public List<SearchFeedRespDto> mypageSearchFeeds(int userId) {
        List<FeedList> feedLists = feedMapper.mypageSearchFeeds(userId);
        List<SearchFeedRespDto> searchFeedRespDtos = new ArrayList<>();
        for (FeedList feedList : feedLists) {
            searchFeedRespDtos.add(feedList.searchFeedRespDto());
        }
        return searchFeedRespDtos;
    }

    // 마이페이지 피드 삭제
    public int deleteMypageFeed(int feedId) {
        return feedMapper.deleteFeed(feedId);
    }

    // 마이페이지 피드 수정
//    public void updateFeed(UpdateMypageFeedReqDto updateMypageFeedReqDto) {
//        feedMapper.updateFeed(updateMypageFeedReqDto.toMypageFeed());
//
//        if(updateMypageFeedReqDto.getFeedImgUrls().size() != 0) {
//            feedMapper.saveFeedImgUrl(feed.getFeedId(), saveFeedReqDto.getFeedImgUrls());
//        }
//    }




















}
