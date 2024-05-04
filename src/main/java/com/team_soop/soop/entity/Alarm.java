package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchAlarmListRespDto;
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
    private int alarmOrder; // 0 = 관리자 메시지, 1 = 유저 메시지

    private int toUserId;
    private int fromUserId;
    private String content;
    private LocalDateTime createDate;

    private User toUser;

    public SearchAlarmListRespDto toSearchAlarmListRespDto() {
        String setNickname;
        String setUserProfileImgUrl;

        switch (alarmOrder) {
            case 0:
                setNickname = "관리자";
                setUserProfileImgUrl = "https://firebasestorage.googleapis.com/v0/b/react-study-chan.appspot.com/o/soop%2Ffeed%2F18%2F1476778.png?alt=media&token=a7ca1d88-fcf2-4207-9444-b1ba5f9c3786";
                break;
            case 1:
                setNickname = toUser.getNickname();
                setUserProfileImgUrl = toUser.getProfileImgUrl();
                break;
            default:
                setNickname = "unknown";
                setUserProfileImgUrl = "";
        }
        return SearchAlarmListRespDto.builder()
                .alarmId(alarmId)
                .alarmOrder(alarmOrder)
                .toUserId(toUserId)
                .fromUserId(fromUserId)
                .fromUserNickname(setNickname)
                .fromUserProfileImgUrl(setUserProfileImgUrl)
                .alarmContent(content)
                .createDate(createDate)
                .build();
    }

}
