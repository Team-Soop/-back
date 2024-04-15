package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Feed;
import com.team_soop.soop.entity.FeedList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedMapper {

    public int saveFeed(Feed feed);
    public int saveFeedImgUrl(@Param("feedId") int feedId, @Param("feedImgUrls") List<String> feedImgUrls);
    public List<FeedList> searchFeeds();




}
