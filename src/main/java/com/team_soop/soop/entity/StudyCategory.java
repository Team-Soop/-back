package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchStudyCategoryRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyCategory {
    private int studyCategoryId;
    private String studyCategoryName;

    public SearchStudyCategoryRespDto toStudyCategoryRespDto() {
        return SearchStudyCategoryRespDto.builder()
                .studyCategoryId(studyCategoryId)
                .studyCategoryName(studyCategoryName)
                .build();
    }
}
