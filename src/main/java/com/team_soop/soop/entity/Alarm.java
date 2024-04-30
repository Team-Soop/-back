package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alarm {
    private int alarmId;
    private int toUserId;
    private int fromUserId;
    private String content;
    private LocalDateTime createDate;
}
