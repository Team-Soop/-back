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
public class LunchCategory {
    private int lunchCategoryId;
    private int lunchId;
    private String lunchCategoryName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
