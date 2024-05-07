package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    public int saveReport(Report report);
    public List<Report> searchReportList(@Param("menuCategoryId") int menuCategoryId);
    public List<Report> searchReportCompleted(@Param("menuCategoryId") int menuCategoryId);
    public List<Report> searchReportListUser(@Param("menuCategoryId") int menuCategoryId, @Param("userId") int userId, @Param("boardId") int boardId);
    public void deleteReport(@Param("menuCategoryId") int menuCategoryId, @Param("boardId") int boardId);
    public void deleteReportFeed(@Param("menuCategoryId") int menuCategoryId, @Param("feedId") int feedId);
}
