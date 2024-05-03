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
    private int alarmOrder;
    // 0 = 관리자 메시지, 1 = 유저 메시지
    private int toUserId;
    private int fromUserId;
    private String content;
    private LocalDateTime createDate;
    private User toUser;
}
