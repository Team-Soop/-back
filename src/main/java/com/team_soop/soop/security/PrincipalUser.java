package com.team_soop.soop.security;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Data
public class PrincipalUser implements UserDetails {

    private int userId;
    private String username;
//    private String nickname;
    private String name;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return "";
    }

    // 계정 사용기간 만료
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // 계정 잠금
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    // 비밀번호 사용기간 만료
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    // 계정 비활성화
    @Override
    public boolean isEnabled() {
        return false;
    }
}
