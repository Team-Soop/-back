package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LunchComment {
    private int lunchCommentId;
    private int lunchId;
    private int lunchCommentUserId;
    private String lunchCommentContent;
    private String lunchCommentNickName;
    private String lunchCommentUserProfileImgUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
