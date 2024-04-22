package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Lunch;
import com.team_soop.soop.entity.LunchComment;
import com.team_soop.soop.entity.LunchList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LunchMapper {
    public int saveLunch(Lunch lunch);
    public int saveLunchImgUrl(@Param("lunchId") int lunchId, @Param("lunchImgUrls") List<String> lunchImgUrls);
    public int saveLunchCategory(@Param("lunchId") int lunchId, @Param("lunchCategories") List<String> lunchCategories);
    public int saveLunchComment(LunchComment lunchComment);
    public List<LunchList> searchLunchList();
    public List <LunchComment> searchLunchComment(int detailLunchId);
    public int modifyComment(LunchComment lunchComment);
    public int deleteComment(int commentId);
}
