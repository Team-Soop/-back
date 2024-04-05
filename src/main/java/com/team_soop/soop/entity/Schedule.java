package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchScheduleRespDto;
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
    private String classScheduleTitle;
    private String classScheduleTeacher;
    private int classLocationId;
    private String classLocationName;
    private String classLocationUrl;
    private String classScheduleStartDate;
    private String classScheduleEndDate;

    private ClassLocation classLocation;

    public SearchScheduleRespDto toSearchScheduleRespDto() {
        return SearchScheduleRespDto.builder()
                .classScheduleId(classScheduleId)
                .classScheduleTitle(classScheduleTitle)
                .classScheduleTeacher(classScheduleTeacher)
                .classLocationId(classLocationId)
                .classLocationName(classLocation.getClassLocationName())
                .classLocationUrl(classLocation.getClassLocationImgUrl())
                .classScheduleStartDate(classScheduleStartDate)
                .classScheduleEndDate(classScheduleEndDate)
                .build();
    }
}
