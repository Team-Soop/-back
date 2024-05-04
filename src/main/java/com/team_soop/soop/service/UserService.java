package com.team_soop.soop.service;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SearchReportReqDto;
import com.team_soop.soop.dto.SearchUserCountRespDto;
import com.team_soop.soop.dto.SearchUserReqDto;
import com.team_soop.soop.dto.SearchUserRespDto;
import com.team_soop.soop.entity.SearchUser;
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


    @ParamsPrintAspect
    public List<SearchUserRespDto> UserSearch(SearchUserReqDto searchUserReqDto) {
        List<SearchUserRespDto> SearchUserRespDtos = new ArrayList<>();
//        int startIndex = (searchUserReqDto.getPage() - 1) * searchUserReqDto.getCount();


        List<SearchUser> searchUsers = userMapper.findAllUser(
//                startIndex,
//                searchUserReqDto.getCount(),
                searchUserReqDto.getRoleId(),
                searchUserReqDto.getSearchTypeId(),
                searchUserReqDto.getSearchText()
        );

        for(SearchUser searchUser : searchUsers) {
            SearchUserRespDtos.add(searchUser.toSearchUserRespDtos());
        }

        return SearchUserRespDtos;
    }

    public SearchUserCountRespDto getUserCount(SearchUserReqDto searchUserReqDto) {
        int userCount = userMapper.getUserCount(
                searchUserReqDto.getRoleId(),
                searchUserReqDto.getSearchTypeId(),
                searchUserReqDto.getSearchText()
        );
        int manxPageNumber = (int) Math.ceil(((double) userCount) / searchUserReqDto.getCount());

        return SearchUserCountRespDto.builder()
                .totalCount(userCount)
                .maxPageNumber(manxPageNumber)
                .build();
    }

}
