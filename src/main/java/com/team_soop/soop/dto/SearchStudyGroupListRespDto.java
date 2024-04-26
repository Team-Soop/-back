package com.team_soop.soop.dto;

import com.team_soop.soop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudyGroupListRespDto {
    private int studyId;
    private String studyTitle;
    private List<Integer> studySkills;
    private int memberCount;
    private int studyMemberLimited;
    private int timeCount;
    private int userId;
    private String nickname;
    private String profileImgUrl;
}