package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchLunchCommentRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LunchComment {
    private int lunchCommentId;
    private int lunchId;
    private int lunchCommentUserId;
    private String lunchCommentContent;
    private String lunchCommentNickName;
    private String lunchCommentUserProfileImgUrl;
    private int totalCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public SearchLunchCommentRespDto toSearchLunchCommentRespDto() {
        return SearchLunchCommentRespDto.builder()
                .lunchCommentId(lunchCommentId)
                .lunchId(lunchId)
                .lunchCommentUserId(lunchCommentUserId)
                .lunchCommentContent(lunchCommentContent)
                .lunchCommentNickName(lunchCommentNickName)
                .lunchCommentUserProfileImgUrl(lunchCommentUserProfileImgUrl)
                .totalCount(totalCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
