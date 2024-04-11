package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchFeedRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedList {
    private int feedId;
    private int userId;
    private String profileImgUrl;
    private String username;
    private String feedContent;
    private List<String> feedImgUrl;
//    private int likeCount;
//    private int commentCount;

    private User user;

    public SearchFeedRespDto toSearchFeedRespDto() {

        return SearchFeedRespDto.builder()
                .feedId(getFeedId())
                .userId(getUserId())
                .profileImgUrl(user.getProfileImgUrl())
                .username(user.getUsername())
                .feedContent(getFeedContent())
                .feedImgUrls(getFeedImgUrl())
                .build();
    }

}
