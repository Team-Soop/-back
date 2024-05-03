package com.team_soop.soop.service;

import com.team_soop.soop.dto.SendAlarmReqDto;
import com.team_soop.soop.entity.Alarm;
import com.team_soop.soop.repository.AlarmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmService {

    @Autowired
    AlarmMapper alarmMapper;

    // 알람 보내기
    public void sendAlarmMessage(SendAlarmReqDto sendAlarmReqDto) {
        Alarm sendAlarm = sendAlarmReqDto.toAlarm();
        alarmMapper.sendReportAlarm(sendAlarm);
    }



}
