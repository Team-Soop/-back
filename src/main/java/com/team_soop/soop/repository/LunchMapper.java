package com.team_soop.soop.repository;

import com.team_soop.soop.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LunchMapper {

    // 런치 게시물
    public int saveLunch(Lunch lunch);
    public int saveLunchImgUrl(@Param("lunchId") int lunchId, @Param("lunchImgUrls") List<String> lunchImgUrls);
    public int saveLunchCategory(@Param("lunchId") int lunchId, @Param("lunchCategories") List<String> lunchCategories);
    public List<LunchList> searchLunchList();

    // 런치 좋아요, 추천
    public int saveLunchLike(LunchLike lunchLike);
    public LikeStatus getLikeLunchStatus(@Param("userId") int userId, @Param("lunchId") int lunchId);
    public int deleteLunchLike(LunchLike lunchLike);

    // 런치 댓글
    public int saveLunchComment(LunchComment lunchComment);
    public List <LunchComment> searchLunchComment(int detailLunchId);
    public int modifyComment(LunchComment lunchComment);
    public int deleteComment(int commentId);

    // 마이페이지 런치
    public List<LunchList> myPageSearchLunch(int userId);

}

