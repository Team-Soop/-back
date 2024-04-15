package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LunchLike {
    private int lunchLikeId;
    private int LunchId;
    private int LunchLikeUserId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
