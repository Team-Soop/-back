package com.team_soop.soop.service;

import com.team_soop.soop.exception.SaveException;
import com.team_soop.soop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void UserBan(int userId) {
        int successCount = 0;
        successCount += userMapper.saveRole(userId, 5);
        if(successCount < 1) {
            throw new SaveException();
        }
    }

}
