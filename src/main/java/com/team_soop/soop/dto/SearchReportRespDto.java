package com.team_soop.soop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchReportRespDto {
    private int reportId;
    private String menuCategoryId;
    private int boardId;
    private String reportCategories;
    private String reportContent;
    private int userId;
    private String userName;
    private String nickName;
    private String name;
    private LocalDateTime createDate;

}
