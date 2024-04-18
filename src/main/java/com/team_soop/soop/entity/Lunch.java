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
public class Lunch {
    private int lunchId;
    private int MenuCategoryId;
    private int userId;
    private String lunchTitle;
    private String lunchContent;
    private String lunchPlaceName;
    private double lunchPlaceX;
    private double lunchPlaceY;
    private String lunchPlaceUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
