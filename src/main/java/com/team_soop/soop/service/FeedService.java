package com.team_soop.soop.service;

import com.team_soop.soop.dto.SaveFeedReqDto;
import com.team_soop.soop.entity.Feed;
import com.team_soop.soop.repository.FeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void getFeed() {

    }

}
