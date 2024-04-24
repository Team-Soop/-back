package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LunchLike {
    private int lunchLikeId;
    private int lunchId;
    private int userId;
    private LocalDateTime createDate;

}
