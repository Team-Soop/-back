package com.team_soop.soop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedImgUrl {
    private int feedImgUrlId;
    private int feedId;
    private String feedImgUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}
