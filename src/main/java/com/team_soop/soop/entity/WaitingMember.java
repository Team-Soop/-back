package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchWaitingMemberRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaitingMember {
    private int waitingId;
    private int studyId;
    private int userId;
    private String applyMessage;
    private LocalDateTime createDate;

    private User user;

    public SearchWaitingMemberRespDto toSearchWaitingMemberRespDto() {
        return SearchWaitingMemberRespDto.builder()
                .waitingId(waitingId)
                .studyId(studyId)
                .userId(userId)
                .nickname(user.getNickname())
                .applyMessage(applyMessage)
                .createDate(createDate)
                .build();
    }
}