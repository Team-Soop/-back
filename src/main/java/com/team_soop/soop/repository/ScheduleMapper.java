package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {
    public int addSchedule(Schedule schedule);
}
