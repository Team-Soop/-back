package com.team_soop.soop.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudySearchOption {
    private String title;
    private List<Integer> categories;
}
