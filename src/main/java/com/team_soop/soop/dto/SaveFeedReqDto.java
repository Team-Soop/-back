package com.team_soop.soop.dto;

import com.team_soop.soop.entity.Feed;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class SaveFeedReqDto {
    private int userId;
    // chat gpt: <p> 태그로 감싸는 문자열이 띄어쓰기나 공백을 제외한 모든 문자로만 구성되고, 중간에 다른 < > 태그가 들어와도 괜찮습니다.
    @Pattern(regexp = "(<p>(?:[^\\s<>]+|<[^<>]+>)*</p>)+")
    private String feedContent;
    private List<String> feedImgUrls;

    public Feed toFeed() {
        return Feed.builder()
                .userId(userId)
                .feedContent(feedContent)
                .build();
    }



}




