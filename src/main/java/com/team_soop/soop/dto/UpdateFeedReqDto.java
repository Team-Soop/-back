package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Feed;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class UpdateFeedReqDto {
    public int feedId;
    private int userId;
    @Pattern(regexp = "<p>(?:(?!\\s)[\\p{L}0-9a-zA-Z])*?</p>", message = "게시글을 작성해주세요.")
    private String feedContent;
    private List<String> feedImgUrls;

    public Feed toFeed() {
        return Feed.builder()
                .feedId(feedId)
                .userId(userId)
                .feedContent(feedContent)
                .build();
    }
}
