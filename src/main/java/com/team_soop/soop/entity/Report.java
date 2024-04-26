package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchReportRespDto;
import com.team_soop.soop.exception.MenuCategoryException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Report {
    private int reportId;
    private int menuCategoryId;
    private int boardId;
    private String reportCategories;
    private String reportContent;
    private int userId;
    private String userName;
    private String nickName;
    private String name;
    private LocalDateTime createDate;

    public SearchReportRespDto toSearchReportRespDto () {

        String boardName = "";

        switch (menuCategoryId) {
            case 1: boardName = "자유게시판";
                break;
            case 2: boardName = "스터디게시판";
                break;
            case 3: boardName = "점심추천게시판";
                break;
            default:
                throw new MenuCategoryException((Map.of("menuCategoryId", "맞는 메뉴아이디가 없습니다.")));
        }


        return SearchReportRespDto.builder()
                .reportId(reportId)
                .menuCategoryId(boardName)
                .boardId(boardId)
                .reportCategories(reportCategories)
                .reportContent(reportContent)
                .userId(userId)
                .userName(userName)
                .nickName(nickName)
                .name(name)
                .createDate(createDate)
                .build();
    }


}
