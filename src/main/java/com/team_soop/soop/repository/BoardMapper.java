package com.team_soop.soop.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 피드 게시판 삭제
    public int deleteFeedBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int deleteFeedCommentBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int deleteFeedImgUrlBoard(@Param("boardId") int boardId);
    public int deleteFeedLike(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);




    // 스터디 게시판 삭제
    public int  deleteStudyBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int  deleteStudyRecruitmentBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int  deleteStudyWaitingBoard(@Param("boardId") int boardId,@Param("userIds") List<Integer> userIds);


    // 점심 게시펀 삭제
    public int deleteLunchBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int deleteLunchCategoryBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int deleteLunchCommentBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int deleteLunchImgUrlBoard(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);
    public int deleteLunchLike(@Param("boardId") int boardId, @Param("userIds") List<Integer> userIds);

    // 즐겨찾기 게시판 삭제
    public int deleteSaveBoard(@Param("boardId") int boardId, @Param("menuId") int menuId, @Param("userIds") List<Integer> userIds);


}
