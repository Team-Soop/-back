package com.team_soop.soop.dto;

import com.team_soop.soop.entity.FeedLike;
import lombok.Data;

@Data
public class SaveFeedLikeReqDto {
    private int feedId;
    private int userId;

    public FeedLike toEntity() {
        return FeedLike.builder()
                .feedId(feedId)
                .userId(userId)
                .build();
    }
}
