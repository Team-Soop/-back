package com.team_soop.soop.dto;

import com.team_soop.soop.entity.FeedComment;
import lombok.Data;

@Data
public class UpdateFeedCommentReqDto {
    public int commentId;
    private int feedId;
    private int commentUserId;
    private String commentContent;

    public FeedComment toFeedComment() {
        return FeedComment.builder()
                .feedCommentId(commentId)
                .feedId(feedId)
                .feedCommentUserId(commentUserId)
                .feedCommentContent(commentContent)
                .build();
    }

}
