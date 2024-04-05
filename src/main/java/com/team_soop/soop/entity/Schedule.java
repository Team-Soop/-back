package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {
    private int classScheduleId;
    private String classTitle;
    private String classTeacherName;
    private int classLocationId;
    private String classStartDate;
    private String classEndDate;
}
