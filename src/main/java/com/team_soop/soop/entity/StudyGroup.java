package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchStudyGroupListRespDto;
import com.team_soop.soop.dto.SearchStudyGroupRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    private User user;

    public List<Integer> toStudySkillsList(String studySkills) {
        List<String> studySkillsList = Arrays.asList(studySkills.split(","));
        List<Integer> studySkillsIntList = new ArrayList<>();

        for(String skill : studySkillsList) {
            studySkillsIntList.add(Integer.parseInt(skill));
        }

        return studySkillsIntList;
    }

    public SearchStudyGroupListRespDto toSearchStudyGroupListRespDto(){

        return SearchStudyGroupListRespDto.builder()
                .studyId(studyId)
                .studyTitle(studyTitle)
                .studySkills(toStudySkillsList(studySkills))
                .memberCount(memberCount)
                .studyMemberLimited(studyMemberLimited)
                .timeCount(timeCount)
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImgUrl(user.getProfileImgUrl())
                .build();
    }

    public SearchStudyGroupRespDto toSearchStudyGroupRespDto(){

        return SearchStudyGroupRespDto.builder()
                .studyId(studyId)
                .managerUserId(managerUserId)
                .studyTitle(studyTitle)
                .studyContent(studyContent)
                .studySkills(toStudySkillsList(studySkills))
                .studyPeriodEnd(studyPeriodEnd)
                .contentCreateTime(contentCreateTime)
                .studyMemberLimited(studyMemberLimited)
                .memberCount(memberCount)
                .timeCount(timeCount)
                .waitingMemberCount(waitingMemberCount)
                .nickName(user.getNickname())
                .profileImgUrl(user.getProfileImgUrl())
                .build();
    }
}