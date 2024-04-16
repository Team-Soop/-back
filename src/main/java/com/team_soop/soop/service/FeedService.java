package com.team_soop.soop.service;

import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.dto.SearchFeedRespDto;
import com.team_soop.soop.dto.UpdateFeedReqDto;
import com.team_soop.soop.entity.Feed;
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


    @Transactional(rollbackFor = Exception.class)
    public void saveFeed(SaveFeedReqDto saveFeedReqDto) {

        Feed feed = saveFeedReqDto.toFeed();

        feedMapper.saveFeed(feed);
        feedMapper.saveFeedImgUrl(feed.getFeedId(), saveFeedReqDto.getFeedImgUrls());
    }


//    public TestFeedRespDto searchTestFeed() {
//        return feedMapper.searchTestFeed().testFeedRespDto();
//    }
//
//}
    public List<SearchFeedRespDto> searchFeeds() {
        List<FeedList> feedLists = feedMapper.searchFeeds();
        List<SearchFeedRespDto> searchFeedRespDtos = new ArrayList<>();
        for (FeedList feedList : feedLists) {
            searchFeedRespDtos.add(feedList.searchFeedRespDto());
        }
        return searchFeedRespDtos;
    }

    public void updateFeed(UpdateFeedReqDto updateFeedReqDto) {

    }

}
