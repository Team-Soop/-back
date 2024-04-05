package com.team_soop.soop.service;

import com.team_soop.soop.dto.AddScheduleReqDto;
import com.team_soop.soop.repository.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
