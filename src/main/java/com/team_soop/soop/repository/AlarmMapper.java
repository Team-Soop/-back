package com.team_soop.soop.repository;

import com.team_soop.soop.dto.SendAlarmReqDto;
import com.team_soop.soop.entity.Alarm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface AlarmMapper {
    public void sendReportAlarm(Alarm alarm);
}
