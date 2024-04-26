package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SearchStudyGroupRespDto {
    private int studyId;
    private int managerUserId;
    private String studyTitle;
    private String studyContent;
    private List<Integer> studySkills;
    private LocalDateTime studyPeriodEnd;
    private LocalDateTime contentCreateTime;
    private int studyMemberLimited;
    private int memberCount;
    private int timeCount;
    private int waitingMemberCount;
    private String nickName;
    private String profileImgUrl;
}
