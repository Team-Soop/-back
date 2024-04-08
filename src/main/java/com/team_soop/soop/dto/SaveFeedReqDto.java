package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Feed;
import lombok.Data;

import java.util.List;

@Data
public class SaveFeedReqDto {
    private int userId;
    private String feedContent;
    private List<String> feedImgUrls;

    public Feed toFeed() {
        return Feed.builder()
                .userId(userId)
                .feedContent(feedContent)
                .build();
    }





}




