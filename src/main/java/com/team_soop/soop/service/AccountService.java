package com.team_soop.soop.service;

import com.team_soop.soop.dto.EditPasswordReqDto;
import com.team_soop.soop.entity.User;
import com.team_soop.soop.exception.ValidException;
import com.team_soop.soop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public int duplicateUsernameCheck(String username) {
        User user = userMapper.findUserByUsername(username);
        if (user != null) {
            throw new ValidException(Map.of("usernameCheck", "이미 존재하는 아이디입니다."));
        }

        return 1;
    }


    // 바뀔 비밀번호 유효성 검사
    public void editPassword(EditPasswordReqDto editPasswordReqDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());

        if(!passwordEncoder.matches(editPasswordReqDto.getOldPassword(), user.getPassword())) {
            throw new ValidException(Map.of("oldPassword", "비밀번호 인증에 실패하였습니다.\n다시입력하세요."));
        }
        if(!editPasswordReqDto.getNewPassword().equals(editPasswordReqDto.getNewPasswordCheck())) {
            throw new ValidException(Map.of("newPasswordCheck", "새로운 비밀번호가 서로 일치하지 않습니다.\n다시입력하세요."));
        }
        if(passwordEncoder.matches(editPasswordReqDto.getNewPassword(), user.getPassword())) {
            throw new ValidException(Map.of("newPassword", "이전 비밀번호와 동일한 비밀번호는 사용하실 수 없습니다.\n다시입력하세요."));
        }

        user.setPassword(passwordEncoder.encode(editPasswordReqDto.getNewPassword()));
        userMapper.modifyPassword(user);
    }

}
