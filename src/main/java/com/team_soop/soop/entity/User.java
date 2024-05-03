package com.team_soop.soop.entity;

import com.team_soop.soop.dto.SearchUserRespDto;
import com.team_soop.soop.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String username;
    private String nickname;
    private String password;
    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String profileImgUrl;
    private int roleId;

    private List<RoleRegister> roleRegisters;
    private List<OAuth2> oAuth2s;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(RoleRegister roleRegister : roleRegisters) {
            authorities.add(new SimpleGrantedAuthority(roleRegister.getRole().getRoleName()));
        }

        return authorities;
//        return roleRegisters.stream()
//                .map(roleRegister ->
//                        new SimpleGrantedAuthority(roleRegister.getRole().getRoleName()))
//                .collect(Collectors.toList());
    }

    public PrincipalUser toPrincipalUser() {
        return PrincipalUser.builder()
                .userId(userId)
                .username(username)
                .nickname(nickname)
                .name(name)
                .email(email)
                .authorities(getAuthorities())
                .build();
    }








}
