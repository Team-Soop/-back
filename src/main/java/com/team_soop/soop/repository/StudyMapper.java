package com.team_soop.soop.repository;

import com.team_soop.soop.dto.SearchStudyCategoryRespDto;
import com.team_soop.soop.entity.StudyCategory;
import com.team_soop.soop.entity.StudyGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapper {
    public List<StudyCategory> searchStudyCategories();
    public int saveStudyGroup(StudyGroup studyGroup);
    public List<StudyGroup> searchStudyGroupList();
}
