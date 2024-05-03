package com.team_soop.soop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchUserCountRespDto {
    private int totalCount;
    private int maxPageNumber;
}
