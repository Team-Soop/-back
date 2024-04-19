package com.team_soop.soop.service;

import com.team_soop.soop.dto.LikeFeedReqDto;
import com.team_soop.soop.dto.LikeFeedRespDto;
import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.dto.SearchFeedRespDto;
import com.team_soop.soop.entity.Feed;
import com.team_soop.soop.entity.FeedLike;
import com.team_soop.soop.entity.FeedList;
import com.team_soop.soop.repository.FeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public void likeFeed(LikeFeedReqDto likeFeedReqDto) {
        feedMapper.saveFeedLike(likeFeedReqDto.toEntity());
    }

    public void unLikeFeed(LikeFeedReqDto likeFeedReqDto) {
        feedMapper.deleteFeedLike(likeFeedReqDto.toEntity());
    }

    public List<LikeFeedRespDto> searchLikeFeed() {
        List<FeedLike> feedLikes = feedMapper.getFeedLikes();
        List<LikeFeedRespDto> likeFeedRespDtos = new ArrayList<>();
        for (FeedLike feedLike : feedLikes) {
            likeFeedRespDtos.add((feedLike.likeFeedRespDto()));
        }
        return likeFeedRespDtos;
    }
}
