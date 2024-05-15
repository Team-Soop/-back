package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Lunch;
import com.team_soop.soop.exception.MenuCategoryException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class SaveLunchReqDto {
    private int userId;
    private String lunchTitle;
    private String lunchContent;
    private List<Integer> lunchCategories;
    private String placeName;
    private double placeX;
    private double placeY;
    private String placeUrl;
    private List<String> lunchImgUrls;


    public List<String> getCategoryName() {
        List<String> categoryNames = new ArrayList<>();

        for(int lunchCategory : lunchCategories) {
            switch (lunchCategory) {
                case 1: categoryNames.add("치킨");
                    break;
                case 2: categoryNames.add("한식");
                    break;
                case 3: categoryNames.add("카페ㆍ디저트");
                    break;
                case 4: categoryNames.add("중식");
                    break;
                case 5 : categoryNames.add("분식");
                    break;
                case 6 : categoryNames.add("샐러드");
                    break;
                case 7 : categoryNames.add("회ㆍ초밥");
                    break;
                case 8 : categoryNames.add("버거");
                    break;
                case 9 : categoryNames.add("일식ㆍ돈까스");
                    break;
                case 10 : categoryNames.add("피자ㆍ양식");
                    break;
                case 11 : categoryNames.add("고기구이");
                    break;
                case 12 : categoryNames.add("찜ㆍ탕");
                    break;
                default:
                    System.out.println("맞는 숫자가 없음");
                    throw new MenuCategoryException(Map.of("lunchCategory", "맞는 메뉴아이디가 없습니다."));
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
                .lunchPlaceUrl(placeUrl)
                .build();
    }


}
