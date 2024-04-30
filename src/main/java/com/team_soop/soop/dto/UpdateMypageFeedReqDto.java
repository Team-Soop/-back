package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Feed;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class UpdateMypageFeedReqDto {
    private int userId;
    @NotBlank
    @Pattern(regexp = "(<p>(?:[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣\\s\\p{Punct}]+|<[^<>]+>)*</p>)+")
    private String feedContent;
    private List<String> feedImgUrls;

    public Feed toMypageFeed() {
        return Feed.builder()
                .userId(userId)
                .feedContent(feedContent)
                .build();
    }
}
