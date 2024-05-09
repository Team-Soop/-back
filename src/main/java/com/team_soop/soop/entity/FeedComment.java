package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedComment {
    private int feedCommentId;
    private int feedId;
    private int feedCommentUserId;
    private String feedCommentContent;
    private String feedCommentNickName;
    private String feedCommentUserProfileImgUrl;
    private int totalCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public SearchFeedCommentRespDto toSearchFeedCommentRespDto() {
        return SearchFeedCommentRespDto.builder()
                .feedCommentId(feedCommentId)
                .feedId(feedId)
                .feedCommentUserId(feedCommentUserId)
                .feedCommentContent(feedCommentContent)
                .feedCommentNickName(feedCommentNickName)
                .feedCommentUserProfileImgUrl(feedCommentUserProfileImgUrl)
                .totalCount(totalCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
