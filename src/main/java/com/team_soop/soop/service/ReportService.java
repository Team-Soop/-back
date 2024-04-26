package com.team_soop.soop.service;

import com.team_soop.soop.dto.SaveReportReqDto;
import com.team_soop.soop.dto.SearchReportReqDto;
import com.team_soop.soop.dto.SearchReportRespDto;
import com.team_soop.soop.entity.Report;
import com.team_soop.soop.exception.MenuCategoryException;
import com.team_soop.soop.repository.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    ReportMapper reportMapper;

    public void saveReport(SaveReportReqDto saveReportReqDto, int userId) {
        reportMapper.saveReport(saveReportReqDto.toReportEntity(userId));
    }


    public List<SearchReportRespDto> searchReport(SearchReportReqDto searchReportReqDto) {


        List<Report> reportList = reportMapper.searchReportList(searchReportReqDto.getMenuCategoryId());
        List<SearchReportRespDto> searchReportRespDtos = new ArrayList<>();

        for( Report report : reportList ) {
            searchReportRespDtos.add(report.toSearchReportRespDto());
        }

        return searchReportRespDtos;
    }



}
