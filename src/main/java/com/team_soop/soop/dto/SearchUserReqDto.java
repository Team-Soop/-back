package com.team_soop.soop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SearchUserReqDto {
    private int page;
    private int count;
    private int roleId;
    private int searchTypeId;
    private String searchText;
}
