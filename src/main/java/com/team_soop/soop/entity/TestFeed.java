package com.team_soop.soop.entity;

import com.team_soop.soop.dto.TestFeedRespDto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestFeed {
    private int feedId;
    private int userId;
    private String profileImgUrl;
    private String username;
    private String feedContent;
    private List<FeedImgUrl> feedImgUrl;

    public TestFeedRespDto testFeedRespDto() {
        return TestFeedRespDto.builder()
                .feedId(feedId)
                .userId(userId)
                .profileImgUrl(profileImgUrl)
                .username(username)
                .feedContent(feedContent)
                .feedImgUrl(feedImgUrl.stream().map(FeedImgUrl::getFeedImgUrl).collect(Collectors.toList()))
                .build();
    }
}
