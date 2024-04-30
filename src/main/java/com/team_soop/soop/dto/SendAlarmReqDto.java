package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Alarm;
import lombok.Data;

@Data
public class SendAlarmReqDto {
    private int toUserId;
    private int fromUserId;
    private String content;

    public Alarm toAlarm() {
        return Alarm.builder()
                .toUserId(toUserId)
                .fromUserId(fromUserId)
                .content(content)
                .build();
    }
}
