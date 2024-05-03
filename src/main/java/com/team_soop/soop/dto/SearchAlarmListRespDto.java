package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchAlarmListRespDto {
    private int alarmId;
    private int alarmOrder;
    private int toUserId;
    private int fromUserId;
    private String fromUserNickname;
    private String fromUserProfileImgUrl;
    private String alarmContent;
    private LocalDateTime createDate;

}
