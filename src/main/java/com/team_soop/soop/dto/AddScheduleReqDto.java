package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Schedule;
import lombok.Data;

@Data
public class AddScheduleReqDto {
    private String classTitle;
    private String classTeacherName;
    private int classLocationId;
    private String classStartDate;
    private String classEndDate;

    public Schedule toEntity() {
        return Schedule.builder()
                .classTitle(classTitle)
                .classTeacherName(classTeacherName)
                .classLocationId(classLocationId)
                .classStartDate(classStartDate)
                .classEndDate(classEndDate)
                .build();
    }
}
