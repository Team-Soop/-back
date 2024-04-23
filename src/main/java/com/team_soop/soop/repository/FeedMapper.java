package com.team_soop.soop.repository;

import com.team_soop.soop.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Mapper
public interface FeedMapper {

    // 피드 게시물
    public int saveFeed(Feed feed);
    public int saveFeedImgUrl(@Param("feedId") int feedId, @Param("feedImgUrls") List<String> feedImgUrls);
    public List<FeedList> searchFeeds();

    // 피드 좋아요
    public int saveFeedLike(FeedLike feedLike);
    public int deleteFeedLike(FeedLike feedLike);
    public LikeStatus getLikeStatus(@Param("userId") int userId, @Param("feedId") int feedId);

    // 피드 댓글
    public int saveFeedComment(FeedComment feedComment);
    public List<FeedComment> searchFeedComment(int feedId);
}
