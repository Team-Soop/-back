package com.team_soop.soop.dto;

import com.team_soop.soop.entity.StudyCategory;
import com.team_soop.soop.entity.StudyGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveStudyGroupReqDto {
    private int managerUserId;
    private String studyTitle;
    private String studyContent;
    private List<StudyCategory> studySkills;
    private int studyMemberLimited;
    private LocalDateTime studyPeriodEnd;

    public StudyGroup toEntity() {
        StringBuilder stringBuilder = new StringBuilder();
        for(StudyCategory studySkill : studySkills) {
            stringBuilder.append(studySkill.getStudyCategoryId());
            stringBuilder.append(",");
        }
        String studySkilsString = stringBuilder.substring(0, stringBuilder.length() - 1);

        return StudyGroup.builder()
                .managerUserId(managerUserId)
                .studyTitle(studyTitle)
                .studyContent(studyContent)
                .studySkills(studySkilsString)
                .studyMemberLimited(studyMemberLimited)
                .studyPeriodEnd(studyPeriodEnd)
                .build();
    }
}
