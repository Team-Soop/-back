package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Feed;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class SaveFeedReqDto {
    private int userId;
    @Pattern(regexp = "(<p>(?:[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9\\n]*)</p>)+", message = "게시글을 작성해주세요.")
    private String feedContent;
    private List<String> feedImgUrls;

    public Feed toFeed() {
        return Feed.builder()
                .userId(userId)
                .feedContent(feedContent)
                .build();
    }



}




