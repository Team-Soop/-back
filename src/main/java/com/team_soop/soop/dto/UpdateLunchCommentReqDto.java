package com.team_soop.soop.dto;

import com.team_soop.soop.entity.LunchComment;
import lombok.Data;

@Data
public class UpdateLunchCommentReqDto {
    private int commentId;
    private int lunchId;
    private int commentUserId;
    private String commentContent;

    public LunchComment toLunchComment () {
        return LunchComment.builder()
                .lunchCommentId(commentId)
                .lunchId(lunchId)
                .lunchCommentUserId(commentUserId)
                .lunchCommentContent(commentContent)
                .build();
    }
}
