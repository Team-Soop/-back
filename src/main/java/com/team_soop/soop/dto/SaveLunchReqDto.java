package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Lunch;
import lombok.Data;

import java.util.List;

@Data
public class SaveLunchReqDto {
    private int userId;
    private String lunchTitle;
    private String lunchContent;
    private List<String> lunchCategories;
    private String placeName;
    private double placeX;
    private double placeY;
    private List<String> lunchImgUrls;

    public Lunch toLunch() {
        return Lunch.builder()
                .userId(userId)
                .lunchTitle(lunchTitle)
                .lunchContent(lunchContent)
                .lunchPlaceName(placeName)
                .lunchPlaceX(placeX)
                .lunchPlaceY(placeY)
                .build();
    }


}
