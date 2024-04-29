package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchWaitingMemberRespDto {
    private int waitingId;
    private int studyId;
    private int userId;
    private String nickname;
    private String applyMessage;
    private LocalDateTime createDate;
}
