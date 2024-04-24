package com.team_soop.soop.service;

import com.team_soop.soop.dto.SaveStudyGroupReqDto;
import com.team_soop.soop.dto.SearchStudyCategoryRespDto;
import com.team_soop.soop.dto.SearchStudyGroupListRespDto;
import com.team_soop.soop.entity.StudyCategory;
import com.team_soop.soop.entity.StudyGroup;
import com.team_soop.soop.repository.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudyGroupService {

    @Autowired
    StudyMapper studyMapper;

    public List<SearchStudyCategoryRespDto> searchStudyCategory() {
        List<StudyCategory> studyCategories = studyMapper.searchStudyCategories();
        List<SearchStudyCategoryRespDto> searchStudyCategoryRespDtos = new ArrayList<>();

        for (StudyCategory studyCategory : studyCategories){
            searchStudyCategoryRespDtos.add(studyCategory.toStudyCategoryRespDto());
        }
        return searchStudyCategoryRespDtos;
    }

    public void saveStudyGroup(SaveStudyGroupReqDto saveStudyGroupReqDto) {
        studyMapper.saveStudyGroup(saveStudyGroupReqDto.toEntity());
    }

    public List<SearchStudyGroupListRespDto> searchStudyGroupList() {
        List<StudyGroup> studyGroupList = studyMapper.searchStudyGroupList();
        List<SearchStudyGroupListRespDto> searchStudyGroupListRespDtos = new ArrayList<>();

        for (StudyGroup studyGroup : studyGroupList) {
            searchStudyGroupListRespDtos.add(studyGroup.toSearchStudyGroupListRespDto());
        }
        return searchStudyGroupListRespDtos;
    }
}
