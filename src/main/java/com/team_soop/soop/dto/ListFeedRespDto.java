package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ListFeedRespDto {
    private int feedId;
    private int userId;
    private String feedContent;
    private List<String> feedImgUrls;

}
