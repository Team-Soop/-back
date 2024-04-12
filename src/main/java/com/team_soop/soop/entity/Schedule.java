package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchScheduleRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    private String classLocationColor;
    private String classLocationUrl;
    private String classScheduleStartDate;
    private String classScheduleEndDate;

    private ClassLocation classLocation;

    public SearchScheduleRespDto toSearchScheduleRespDto() {
        String startDate = classScheduleStartDate.substring(0, classScheduleStartDate.lastIndexOf("+"));
        String endDate = classScheduleEndDate.substring(0, classScheduleEndDate.lastIndexOf("+"));

        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        System.out.println();

        return SearchScheduleRespDto.builder()
                .classScheduleId(classScheduleId)
                .classScheduleTitle(classScheduleTitle)
                .classScheduleTeacher(classScheduleTeacher)
                .classLocationId(classLocationId)
                .classLocationName(classLocation.getClassLocationName())
                .classLocationColor(classLocation.getClassLocationColor())
                .classLocationUrl(classLocation.getClassLocationImgUrl())
                .classScheduleStartDate(startDateTime.plusHours(9).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .classScheduleEndDate(endDateTime.plusHours(9).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}