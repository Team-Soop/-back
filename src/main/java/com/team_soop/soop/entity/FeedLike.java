package com.team_soop.soop.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeedLike {
    private int feedLikeId;
    private int feedId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private Feed feed;
    private User user;

}
