package com.team_soop.soop.dto;

import com.team_soop.soop.entity.User;
import lombok.Data;

@Data
public class EditAccountReqDto {
    private int userId;
    private String username;
    private String nickname;
    private String name;
    private String email;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .username(username)
                .nickname(nickname)
                .name(name)
                .email(email)
                .build();
    }
}
