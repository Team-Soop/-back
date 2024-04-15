package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LunchImgUrl {
    private int lunchImgUrlId;
    private int lunchId;
    private String lunchImgUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
