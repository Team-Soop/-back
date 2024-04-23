package com.team_soop.soop.dto;

import com.team_soop.soop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudyGroupListRespDto {
    private int studyId;
    private String studyTitle;
    private String studySkills;
    private int memberCount;
    private int studyMemberLimited;
    private Date periodEndDDay;
    private int userId;
    private String nickname;
    private String profileImgUrl;
}