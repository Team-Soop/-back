package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchFeedRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feed {
    private int feedId;
    private int menuCategoryId;
    private int userId;
    private String feedContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
