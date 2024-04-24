package com.team_soop.soop.dto;

import com.team_soop.soop.entity.LunchCategory;
import com.team_soop.soop.entity.LunchComment;
import com.team_soop.soop.entity.LunchImgUrl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchLunchRespDto {
    private int lunchId;
    private int userId;
    private String lunchTitle;
    private String lunchContent;
    private String lunchPlaceName;
    private double lunchPlaceX;
    private double lunchPlaceY;
    private String lunchPlaceUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String nickName;
    private String profileImgUrl;

    private List<String> lunchImgUrls;
    private List<String> lunchCategoryNames;
}
