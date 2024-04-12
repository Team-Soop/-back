package com.team_soop.soop.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestFeedRespDto {
    private int feedId;
    private int userId;
    private String profileImgUrl;
    private String username;
    private String feedContent;
    private List<String> feedImgUrl;


}
