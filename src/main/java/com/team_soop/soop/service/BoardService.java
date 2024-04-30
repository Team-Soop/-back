package com.team_soop.soop.service;

import com.team_soop.soop.entity.Report;
import com.team_soop.soop.exception.DeleteException;
import com.team_soop.soop.exception.MenuCategoryException;
import com.team_soop.soop.repository.BoardMapper;
import com.team_soop.soop.repository.ReportMapper;
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
    public int deleteFeedBoard (int boardId) {
        int successCount = 0;
        successCount += boardMapper.deleteFeedBoard(boardId);
        successCount += boardMapper.deleteFeedCommentBoard(boardId);
        successCount += boardMapper.deleteFeedImgUrlBoard(boardId);
        successCount += boardMapper.deleteFeedLike(boardId);
        successCount += boardMapper.deleteSaveBoard(1, boardId);

        return successCount;
    }

    // 스터디 게시판 삭제
     public int deleteStudyBoard (int boardId) {
        int successCount = 0;
        successCount += boardMapper.deleteStudyBoard(boardId);
        successCount += boardMapper.deleteStudyRecruitmentBoard(boardId);
        successCount += boardMapper.deleteStudyWaitingBoard(boardId);

        return successCount;
    }

    // 점심 게시판 삭제
     public int deleteLunchBoard (int boardId) {
         int successCount = 0;
         successCount += boardMapper.deleteLunchBoard(boardId);
         successCount += boardMapper.deleteLunchCategoryBoard(boardId);
         successCount += boardMapper.deleteLunchCommentBoard(boardId);
         successCount += boardMapper.deleteLunchImgUrlBoard(boardId);
         successCount += boardMapper.deleteLunchLike(boardId);
         successCount += boardMapper.deleteSaveBoard(boardId, 3);

         return successCount;
     }


    @Transactional(rollbackFor = Exception.class)
    public void deleteBoard(String menuCategoryName, int boardId) {
        int successCount = 0;
        int menuCategoryId = 0;

        switch (menuCategoryName) {
            case "자유게시판":
                successCount = deleteFeedBoard(boardId);
                if(successCount < 1) {
                    throw new DeleteException();
                }
                menuCategoryId = 1;
                break;
            case "스터디게시판":
                successCount = deleteStudyBoard(boardId);
                if(successCount < 3) {
                    throw new DeleteException();
                }
                menuCategoryId = 2;
                break;
            case "점심추천게시판":
                successCount = deleteLunchBoard(boardId);
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
