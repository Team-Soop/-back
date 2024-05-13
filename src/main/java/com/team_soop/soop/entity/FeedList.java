package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchFeedRespDto;
import lombok.*;

import java.time.LocalDateTime;
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
    private String nickname;
    private String feedContent;
    private LocalDateTime createDate;
    private List<FeedImgUrl> feedImgUrl;
    private int feedLikeCount;
//    private List<FeedComment> feedComment;

    public SearchFeedRespDto searchFeedRespDto() {
        return SearchFeedRespDto.builder()
                .feedId(feedId)
                .userId(userId)
                .profileImgUrl(profileImgUrl)
                .nickname(nickname)
                .feedContent(feedContent)
                .createDate(createDate)
                .feedImgUrl(feedImgUrl.stream().map(FeedImgUrl::getFeedImgUrl).collect(Collectors.toList()))
                .build();
    }
}
