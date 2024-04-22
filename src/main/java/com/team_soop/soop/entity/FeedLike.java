package com.team_soop.soop.entity;

import com.team_soop.soop.dto.LikeFeedRespDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedLike {
    private int feedLikeId;
    private int feedId;
    private int userId;
    private LocalDateTime createDate;

    public LikeFeedRespDto likeFeedRespDto() {
        return LikeFeedRespDto.builder()
                .feedId(feedId)
                .userId(userId)
                .build();
    }
}
