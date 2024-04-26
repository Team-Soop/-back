package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Report;
import lombok.Data;

import java.util.List;

@Data
public class SaveReportReqDto {
    private int menuCategoryId;
    private int boardId;
    private List<Integer> reportCategories;
    private String reportContent;


    public Report toReportEntity(int userId) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int reportCategory : reportCategories) {
            stringBuilder.append(reportCategory);
            stringBuilder.append(",");
        }
        String reportCategoryString = stringBuilder.substring(0, stringBuilder.length() - 1);

        return Report.builder()
                .menuCategoryId(menuCategoryId)
                .boardId(boardId)
                .reportCategories(reportCategoryString)
                .reportContent(reportContent)
                .userId(userId)
                .build();
    }



}
