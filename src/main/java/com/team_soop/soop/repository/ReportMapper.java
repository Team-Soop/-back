package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    public int saveReport(Report report);
    public List<Report> searchAllReportList();
}
