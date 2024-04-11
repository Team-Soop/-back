package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SearchFeedRespDto {
    private int feedId;
    private int userId;
    private String profileImgUrl;
    private String username;
    private String feedContent;
    private List<String> feedImgUrls;
    private int likeCount;
    private int CommentCount;

}
