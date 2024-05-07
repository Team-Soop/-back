package com.team_soop.soop.service;

import com.team_soop.soop.entity.Report;
import com.team_soop.soop.exception.DeleteException;
import com.team_soop.soop.exception.MenuCategoryException;
import com.team_soop.soop.repository.BoardMapper;
import com.team_soop.soop.repository.ReportMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    ReportMapper reportMapper;

    // 자유게시판 삭제
    public int deleteFeedBoard (int boardId, List<Integer> userId) {
        int successCount = 0;
        successCount += boardMapper.deleteFeedBoard(boardId, userId);
        successCount += boardMapper.deleteFeedCommentBoard(boardId, userId);
        successCount += boardMapper.deleteFeedImgUrlBoard(boardId);
        successCount += boardMapper.deleteFeedLike(boardId, userId);
        successCount += boardMapper.deleteSaveBoard(boardId,1, userId);

        return successCount;
    }

    // 스터디 게시판 삭제
     public int deleteStudyBoard (int boardId, List<Integer> userIds) {
        int successCount = 0;
        successCount += boardMapper.deleteStudyBoard(boardId, userIds);
        successCount += boardMapper.deleteStudyRecruitmentBoard(boardId, userIds);
        successCount += boardMapper.deleteStudyWaitingBoard(boardId, userIds);

        return successCount;
    }

    // 점심 게시판 삭제
     public int deleteLunchBoard (int boardId, List<Integer> userIds) {
         int successCount = 0;
         successCount += boardMapper.deleteLunchBoard(boardId, userIds);
         successCount += boardMapper.deleteLunchCategoryBoard(boardId, userIds);
         successCount += boardMapper.deleteLunchCommentBoard(boardId, userIds);
         successCount += boardMapper.deleteLunchImgUrlBoard(boardId, userIds);
         successCount += boardMapper.deleteLunchLike(boardId, userIds);
         successCount += boardMapper.deleteSaveBoard(boardId, 3, null);

         return successCount;
     }


    @Transactional(rollbackFor = Exception.class)
    public void deleteBoard(String menuCategoryName, int boardId) {
        int successCount = 0;
        int menuCategoryId = 0;

        switch (menuCategoryName) {
            case "자유게시판":
                successCount = deleteFeedBoard(boardId, null);
                if(successCount < 1) {
                    throw new DeleteException();
                }
                menuCategoryId = 1;
                break;
            case "스터디게시판":
                successCount = deleteStudyBoard(boardId, null);
                if(successCount < 3) {
                    throw new DeleteException();
                }
                menuCategoryId = 2;
                break;
            case "점심추천게시판":
                successCount = deleteLunchBoard(boardId, null);
                if(successCount < 1) {
                    throw new DeleteException();
                }
                menuCategoryId = 3;
                break;
            default:
                throw new MenuCategoryException((Map.of("menuCategoryName", "맞는 메뉴이름이 없습니다.")));
        }

        // work bench 에 트리거를 걸어둬서 자동으로 report_completed 에 저장
        reportMapper.deleteReport(menuCategoryId, boardId);

    }





}
