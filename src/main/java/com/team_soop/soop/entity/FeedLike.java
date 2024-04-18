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
    private Feed feedId;
    private User userId;
    private LocalDateTime createDate;

}
