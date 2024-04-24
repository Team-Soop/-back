package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchFeedRespDto;
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
    private String lunchPlaceUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String nickName;
    // null 일 수 있음
    private String profileImgUrl;
    // null 일 수 있음
    private List<LunchImgUrl> lunchImgUrl;
    // null 일 수 있음
    private List<LunchCategory> lunchCategoryName;

    public List<String> toLunchImgUrl() {
        List<String> lunchImgUrls = new ArrayList<>();

        for(LunchImgUrl findLunchImgUrl : lunchImgUrl) {
            lunchImgUrls.add(findLunchImgUrl.getLunchImgUrl());
        }

        return lunchImgUrls;
    }

    public List<String> toLunchCategory() {
        List<String> lunchCategoryNames = new ArrayList<>();

        for(LunchCategory findLunchCategoryName : lunchCategoryName) {
            lunchCategoryNames.add(findLunchCategoryName.getLunchCategoryName());
        }

        return lunchCategoryNames;
    }


    public SearchLunchRespDto toSearchLunchRespDto() {
        return SearchLunchRespDto.builder()
                .lunchId(lunchId)
                .userId(userId)
                .lunchTitle(lunchTitle)
                .lunchContent(lunchContent)
                .lunchPlaceName(lunchPlaceName)
                .lunchPlaceX(lunchPlaceX)
                .lunchPlaceY(lunchPlaceY)
                .lunchPlaceUrl(lunchPlaceUrl)
                .createDate(createDate)
                .updateDate(updateDate)
                .nickName(nickName)
                .profileImgUrl(profileImgUrl)
                .lunchImgUrls(toLunchImgUrl())
                .lunchCategoryNames(toLunchCategory())
                .build();
    }







}
