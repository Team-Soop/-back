package com.team_soop.soop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudyOptionReqDto {
    private String title;
    private List<Integer> categories;
}
