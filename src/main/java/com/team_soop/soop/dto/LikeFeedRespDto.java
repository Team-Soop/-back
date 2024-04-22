package com.team_soop.soop.dto;

import com.team_soop.soop.entity.FeedLike;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LikeFeedRespDto {
    private int feedId;
    private int userId;

    }

