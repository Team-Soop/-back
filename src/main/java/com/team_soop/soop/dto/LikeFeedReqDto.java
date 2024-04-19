package com.team_soop.soop.dto;

import com.team_soop.soop.entity.FeedLike;
import lombok.Data;

@Data
public class LikeFeedReqDto {
    private int feedId;
    private int userId;

    public FeedLike toEntity() {
        return FeedLike.builder()
                .feedId(feedId)
                .userId(userId)
                .build();
    }
}
