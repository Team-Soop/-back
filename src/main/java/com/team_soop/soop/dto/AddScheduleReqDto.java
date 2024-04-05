package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Schedule;
import lombok.Data;

@Data
public class AddScheduleReqDto {
    private String classScheduleTitle;
    private String classScheduleTeacher;
    private int classLocationId;
    private String classScheduleStartDate;
    private String classScheduleEndDate;

    public Schedule toEntity() {
        return Schedule.builder()
                .classScheduleTitle(classScheduleTitle)
                .classScheduleTeacher(classScheduleTeacher)
                .classLocationId(classLocationId)
                .classScheduleStartDate(classScheduleStartDate)
                .classScheduleEndDate(classScheduleEndDate)
                .build();
    }
}
