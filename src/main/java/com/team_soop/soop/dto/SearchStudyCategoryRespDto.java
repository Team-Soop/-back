package com.team_soop.soop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchStudyCategoryRespDto {
    private int studyCategoryId;
    private String studyCategoryName;
}
