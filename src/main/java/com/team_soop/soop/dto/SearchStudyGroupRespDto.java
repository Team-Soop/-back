package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchStudyGroupRespDto {
    private int studyId;
    private int managerUserId;
    private String studyTitle;
    private String studyContent;
    private String studySkills;
    private LocalDateTime studyPeriodEnd;
    private LocalDateTime contentCreateTime;
    private int studyMemberLimited;
    private int memberCount;
    private int timeCount;
    private int waitingMemberCount;
    private String nickName;
    private String profileImgUrl;
}
