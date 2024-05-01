package com.team_soop.soop.dto;

import com.team_soop.soop.entity.WaitingMember;
import lombok.Data;

@Data
public class AdmissionWaitingMemberReqDto {
    private int waitingId;
    private int studyId;
    private int userId;

    public WaitingMember toEntity () {
        return WaitingMember.builder()
                .waitingId(waitingId)
                .studyId(studyId)
                .userId(userId)
                .build();
    }
}
