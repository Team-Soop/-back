package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchLunchRespDto;
import com.team_soop.soop.dto.SearchScheduleRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LunchList {
        private int lunchId;
        private int userId;
        private String lunchTitle;
        private String lunchContent;
        private String lunchPlaceName;
        private double lunchPlaceX;
        private double lunchPlaceY;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;

        private List<LunchImgUrl> lunchImgUrls;
        private List<LunchLike> lunchLikes;
        private List<LunchCategory> lunchCategoryNames;
        private List<LunchComment> lunchComments;





}
