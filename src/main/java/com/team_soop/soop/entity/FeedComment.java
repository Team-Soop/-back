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
    private int userId;
    private String feedCommentContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
