package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchRecruitmentRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentMember {
    private int recruitmentId;
    private int studyId;
    private int userId;
    private LocalDateTime createDate;

    private User user;

    public SearchRecruitmentRespDto toSearchRecruitmentRespDto() {
        return SearchRecruitmentRespDto.builder()
                .recruitmentId(recruitmentId)
                .studyId(studyId)
                .userId(userId)
                .nickname(user.getNickname())
                .profileImgUrl(user.getProfileImgUrl())
                .createDate(createDate)
                .build();
    }
}
