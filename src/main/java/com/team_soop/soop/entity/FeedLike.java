package com.team_soop.soop.entity;

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

}
