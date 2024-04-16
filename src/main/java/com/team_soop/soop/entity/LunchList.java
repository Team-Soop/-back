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
    private String nickName;
    private String profileImgUrl;

    private List<LunchLikeUserId> lunchLikeUserId;
    private List<LunchImgUrl> lunchImgUrl;
    private List<LunchCategory> lunchCategoryName;

    public List<Integer> getLunchLikeUserIds() {
        List<Integer> lunchLikeUserIds = new ArrayList<>();

        for(LunchLikeUserId findLunchLikeUserId : lunchLikeUserId) {
            lunchLikeUserIds.add(findLunchLikeUserId.getLunchLikeUserId());
        }

        return lunchLikeUserIds;
    }

    public List<String> getLunchImgUrl() {
        List<String> lunchImgUrls = new ArrayList<>();

        for(LunchImgUrl findLunchImgUrl : lunchImgUrl) {
            lunchImgUrls.add(findLunchImgUrl.getLunchImgUrl());
        }

        return lunchImgUrls;
    }

//    public List<String> getLunchCategory







}
