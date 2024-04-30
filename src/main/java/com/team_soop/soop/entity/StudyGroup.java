package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchStudyGroupListRespDto;
import com.team_soop.soop.dto.SearchStudyGroupRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyGroup {
    private int studyId;
    private int managerUserId;
    private String studyTitle;
    private String studyContent;
    private String studySkills;
    private LocalDateTime studyPeriodEnd;
    private LocalDateTime contentCreateTime;
    private int memberCount;
    private int studyMemberLimited;
    private int timeCount;
    private int waitingMemberCount;
    private User userInfo;

    public SearchStudyGroupListRespDto toSearchStudyGroupListRespDto(){
        return SearchStudyGroupListRespDto.builder()
                .studyId(studyId)
                .studyTitle(studyTitle)
                .studySkills(studySkills)
                .memberCount(memberCount)
                .studyMemberLimited(studyMemberLimited)
                .timeCount(timeCount)
                .userId(userInfo.getUserId())
                .nickname(userInfo.getNickname())
                .profileImgUrl(userInfo.getProfileImgUrl())
                .build();
    }

    public SearchStudyGroupRespDto toSearchStudyGroupRespDto(){
        return SearchStudyGroupRespDto.builder()
                .studyId(studyId)
                .managerUserId(managerUserId)
                .studyTitle(studyTitle)
                .studyContent(studyContent)
                .studySkills(studySkills)
                .studyPeriodEnd(studyPeriodEnd)
                .contentCreateTime(contentCreateTime)
                .studyMemberLimited(studyMemberLimited)
                .memberCount(memberCount)
                .timeCount(timeCount)
                .waitingMemberCount(waitingMemberCount)
                .nickName(userInfo.getNickname())
                .profileImgUrl(userInfo.getProfileImgUrl())
                .build();
    }
}