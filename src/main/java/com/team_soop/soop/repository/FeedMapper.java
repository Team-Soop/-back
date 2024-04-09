package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Feed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedMapper {

    public int saveFeed(Feed feed);
    public int saveFeedImgUrl(@Param("feedId") int feedId, @Param("feedImgUrls") List<String> feedImgUrls);
    public List<Feed> getFeeds(
            @Param("feedId") int feedId,
            @Param("userId") int userId,
            @Param("feedContent") String feedContent,
            @Param("feedImgUrls") List<String> feedImgUrls);


}
