package com.team_soop.soop.service;

import com.team_soop.soop.dto.SearchStudyCategoryRespDto;
import com.team_soop.soop.entity.StudyCategory;
import com.team_soop.soop.repository.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
