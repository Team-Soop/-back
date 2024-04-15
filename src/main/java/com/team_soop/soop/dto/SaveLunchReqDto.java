package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Lunch;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaveLunchReqDto {
    private int userId;
    private String lunchTitle;
    private String lunchContent;
    private List<Integer> lunchCategories;
    private String placeName;
    private double placeX;
    private double placeY;
    private List<String> lunchImgUrls;


    public List<String> getCategoryName() {
        List<String> categoryNames = new ArrayList<>();

        for(int lunchCategory : lunchCategories) {
            switch (lunchCategory) {
                case 1: categoryNames.add("중식");
                    break;
                case 2: categoryNames.add("일식");
                    break;
                case 3: categoryNames.add("한식");
                    break;
                case 4: categoryNames.add("매운거");
                    break;
                case 5 : categoryNames.add("느끼한거");
                    break;
                default:
                    System.out.println("맞는 숫자가 없음");
            }
        }

        return categoryNames;
    }


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
