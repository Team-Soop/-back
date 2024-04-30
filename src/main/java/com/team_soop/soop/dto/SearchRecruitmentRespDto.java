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
public class SearchRecruitmentRespDto {
    private int recruitmentId;
    private int studyId;
    private int userId;
    private String nickname;
    private String profileImgUrl;
    private LocalDateTime createDate;
}
