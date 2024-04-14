package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Lunch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LunchMapper {
    public int saveLunch(Lunch lunch);
    public int saveLunchImgUrl(@Param("lunchId") int lunchId, @Param("lunchImgUrls") List<String> lunchImgUrls);
    public int saveLunchCategory(@Param("lunchId") int lunchId, @Param("lunchCategories") List<String> lunchCategories);
}
