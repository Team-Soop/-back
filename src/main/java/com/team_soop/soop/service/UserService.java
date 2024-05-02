package com.team_soop.soop.service;

import com.team_soop.soop.dto.SearchUserReqDto;
import com.team_soop.soop.dto.SearchUserRespDto;
import com.team_soop.soop.entity.User;
import com.team_soop.soop.exception.SaveException;
import com.team_soop.soop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public List<SearchUserRespDto> UserSearch(SearchUserReqDto searchUserReqDto) {
        List<SearchUserRespDto> searchUserRespDtos = new ArrayList<>();

        List<User> users = userMapper.findAllUser(
                searchUserReqDto.getRoleId(),
                searchUserReqDto.getSearchTypeId(),
                searchUserReqDto.getSearchText()
        );


        for(User user : users) {
            searchUserRespDtos.add(user.toSearchUserRespDtos());
        }

        return searchUserRespDtos;
    }

}
