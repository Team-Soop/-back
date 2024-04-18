package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchFeedRespDto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedList {
    private int feedId;
    private int userId;
    private String profileImgUrl;
    private String username;
    private String feedContent;
    private List<FeedImgUrl> feedImgUrl;
    private int feedLikeCount;
    private List<FeedComment> feedComment;

    public SearchFeedRespDto searchFeedRespDto() {
        return SearchFeedRespDto.builder()
                .feedId(feedId)
                .userId(userId)
                .profileImgUrl(profileImgUrl)
                .username(username)
                .feedContent(feedContent)
                .feedImgUrl(feedImgUrl.stream().map(FeedImgUrl::getFeedImgUrl).collect(Collectors.toList()))
                .feedComment(feedComment.stream().map(FeedComment::getFeedCommentContent).collect(Collectors.toList()))
                .build();
    }
}
