package com.team_soop.soop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchUserRespDto {
    private int userID;
    private String userName;
    private String nickName;
    private String name;
    private String email;
    private String roleNameKor;
    private LocalDateTime createDate;
}
