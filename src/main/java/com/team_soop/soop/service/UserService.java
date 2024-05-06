package com.team_soop.soop.service;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SearchReportReqDto;
import com.team_soop.soop.dto.SearchUserCountRespDto;
import com.team_soop.soop.dto.SearchUserReqDto;
import com.team_soop.soop.dto.SearchUserRespDto;
import com.team_soop.soop.entity.RoleRegister;
import com.team_soop.soop.entity.SearchUser;
import com.team_soop.soop.entity.User;
import com.team_soop.soop.exception.DeleteException;
import com.team_soop.soop.exception.SaveException;
import com.team_soop.soop.repository.BoardMapper;
import com.team_soop.soop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BoardService boardService;

    // 유저 권한 이용정지자
    @Transactional(rollbackFor = Exception.class)
    public void UserBan(int userId) {
        int successCount = 0;
        successCount += userMapper.saveRole(userId, 5);
        if(successCount < 1) {
            throw new SaveException();
        }
    }


    // 유저 검색
    public List<SearchUserRespDto> UserSearch(SearchUserReqDto searchUserReqDto) {
        List<SearchUserRespDto> SearchUserRespDtos = new ArrayList<>();
        int startIndex = (searchUserReqDto.getPage() - 1) * searchUserReqDto.getCount();


        List<SearchUser> searchUsers = userMapper.findAllUser(
                startIndex,
                searchUserReqDto.getCount(),
                searchUserReqDto.getRoleId(),
                searchUserReqDto.getSearchTypeId(),
                searchUserReqDto.getSearchText()
        );

        for(SearchUser searchUser : searchUsers) {
            SearchUserRespDtos.add(searchUser.toSearchUserRespDtos());
        }

        return SearchUserRespDtos;
    }

    // 유저 검색결과 총 갯 수
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


    // 유저 권한 변경
    @Transactional(rollbackFor = Exception.class)
    public void updateUserRole(int newRoleId, int oldRoleId, int userId) {
        RoleRegister roleRegister = userMapper.findRoleRegisterByUserIdAndRoleId(userId, newRoleId);

        // 이미 있는 권한인지 (유효성 검사)
        if(newRoleId == oldRoleId) {
            System.out.println("이미 등록된 권한입니다.");
        }

        // 있던 권한들 삭제
        int deleteSuccessCount = 0;
        deleteSuccessCount += userMapper.updateDeleteRole(userId);
        if(deleteSuccessCount == 0) {
            throw new DeleteException();
        }

        // 새로 바뀐 권한보다 낮은 권한들 까지 같이 넣기
        List<Integer> updateRoleIds = new ArrayList<>();
        for(int i = 1; i <= newRoleId; i++) {
            updateRoleIds.add(i);
        }

        // 권한들 넣기
        int SaveSuccessCount = 0;
        SaveSuccessCount += userMapper.updateSaveRoles(userId, updateRoleIds);
        if(SaveSuccessCount == 0) {
            throw new SaveException();
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteUsers (List<Integer> userIds) {
        int successCount = 0;
        successCount += boardService.deleteFeedBoard(0, userIds);
        successCount += boardService.deleteStudyBoard(0,userIds);
        successCount += boardService.deleteLunchBoard(0, userIds);
//

        System.out.println(successCount);
    }


}
