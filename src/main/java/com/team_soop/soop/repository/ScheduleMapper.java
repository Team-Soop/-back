package com.team_soop.soop.repository;

import com.team_soop.soop.dto.SearchScheduleRespDto;
import com.team_soop.soop.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    public int addSchedule(Schedule schedule);
    public List<Schedule> searchAllSchedule();
}
