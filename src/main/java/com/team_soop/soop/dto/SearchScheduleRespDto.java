package com.team_soop.soop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchScheduleRespDto {
    private int classScheduleId;
    private String classScheduleTitle;
    private String classScheduleTeacher;
    private int classLocationId;
    private String classLocationName;
    private String classLocationUrl;
    private String classScheduleStartDate;
    private String classScheduleEndDate;
}