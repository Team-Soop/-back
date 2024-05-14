package com.team_soop.soop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchLunchCommentRespDto {
    private int lunchCommentId;
    private int lunchId;
    private int lunchCommentUserId;
    private String lunchCommentContent;
    private String lunchCommentNickName;
    private String lunchCommentUserProfileImgUrl;
    private int totalCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
