package com.team_soop.soop.service;

import com.team_soop.soop.dto.AddScheduleReqDto;
import com.team_soop.soop.dto.SearchScheduleRespDto;
import com.team_soop.soop.dto.UpdateScheduleReqDto;
import com.team_soop.soop.entity.Schedule;
import com.team_soop.soop.repository.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    public void addSchedule(List<AddScheduleReqDto> addScheduleReqDto) {
        for ( AddScheduleReqDto schedule : addScheduleReqDto) {
            scheduleMapper.addSchedule(schedule.toEntity());
        }
        return;
    }

    public List<SearchScheduleRespDto> searchAllSchedule () {
        List<Schedule> schedules = scheduleMapper.searchAllSchedule();
        List<SearchScheduleRespDto> searchScheduleRespDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            searchScheduleRespDtos.add(schedule.toSearchScheduleRespDto());
        }
        return searchScheduleRespDtos;
    }

    public void updateSchedule(UpdateScheduleReqDto updateScheduleReqDto) {
        scheduleMapper.updateSchedule(updateScheduleReqDto.toEntity());
        return;
    }

    public void deleteByClassScheduleId(int scheduleId) {
        scheduleMapper.deleteByClassScheduleId(scheduleId);
        return;
    }
}
