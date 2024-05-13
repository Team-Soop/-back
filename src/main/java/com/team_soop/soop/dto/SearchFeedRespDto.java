package com.team_soop.soop.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchFeedRespDto {
    private int feedId;
    private int userId;
    private String profileImgUrl;
    private String nickname;
    private String feedContent;
    private LocalDateTime createDate;
    private List<String> feedImgUrl;


}
