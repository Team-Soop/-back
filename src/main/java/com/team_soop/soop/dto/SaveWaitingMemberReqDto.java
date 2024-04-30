package com.team_soop.soop.dto;

import com.team_soop.soop.entity.WaitingMember;
import lombok.Data;

@Data
public class SaveWaitingMemberReqDto {
    private int studyId;
    private int userId;
    private String applyMessage;

    public WaitingMember toEntity() {
        return WaitingMember.builder()
                .studyId(studyId)
                .userId(userId)
                .applyMessage(applyMessage)
                .build();
    }
}
