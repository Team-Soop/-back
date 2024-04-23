package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchStudyGroupListRespDto;
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
    private int menuCategoryId;
    private int managerUserId;
    private String studyTitle;
    private String studyContent;
    private String studySkills;
    private int memberCount;
    private int studyMemberLimited;
    private LocalDateTime studyPeriodEnd;
    private User userInfo;

    public SearchStudyGroupListRespDto toSearchStudyGroupListRespDto(Date dDay){
        return SearchStudyGroupListRespDto.builder()
                .studyId(studyId)
                .studyTitle(studyTitle)
                .studySkills(studySkills)
                .memberCount(memberCount)
                .studyMemberLimited(studyMemberLimited)
                .periodEndDDay(dDay)
                .userId(userInfo.getUserId())
                .nickname(userInfo.getNickname())
                .profileImgUrl(userInfo.getProfileImgUrl())
                .build();
    }
}