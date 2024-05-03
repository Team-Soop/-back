package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchUserRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchUser {
    private int userId;
    private String userName;
    private String nickName;
    private String password;
    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String profileImgUrl;
    private int roleId;


    public String getRoleNameKor() {
        String roleNameKor = "";

        switch (roleId) {
            case 1: roleNameKor = "임시회원";
                break;
            case 2: roleNameKor = "사용자";
                break;
            case 3: roleNameKor = "수강생";
                break;
            case 4: roleNameKor = "관리자";
                break;
            case 5 : roleNameKor = "이용정지자";
                break;
            default:
                System.out.println("맞는 숫자가 없음");
        }

        return roleNameKor;
    }



    public SearchUserRespDto toSearchUserRespDtos () {
        return SearchUserRespDto.builder()
                .userId(userId)
                .userName(userName)
                .nickName(nickName)
                .name(name)
                .email(email)
                .roleNameKor(getRoleNameKor())
                .profileImgUrl(profileImgUrl)
                .createDate(createDate)
                .build();
    }

}
