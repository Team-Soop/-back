package com.team_soop.soop.repository;

import com.team_soop.soop.dto.SearchStudyCategoryRespDto;
import com.team_soop.soop.entity.StudyCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapper {
    public List<StudyCategory> searchStudyCategories();

}
