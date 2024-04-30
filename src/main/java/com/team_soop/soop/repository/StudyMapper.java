package com.team_soop.soop.repository;

import com.team_soop.soop.dto.SearchStudyCategoryRespDto;
import com.team_soop.soop.entity.RecruitmentMember;
import com.team_soop.soop.entity.StudyCategory;
import com.team_soop.soop.entity.StudyGroup;
import com.team_soop.soop.entity.WaitingMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapper {
    public int saveStudyGroup(StudyGroup studyGroup);
    public int saveWaitingMember(WaitingMember waitingMember);
    public int saveRecruitmentMember(WaitingMember waitingMember);

    public int admissionWaitingMember(int waitingId);
    public int refuseWaitingMember(int waitingId);
    public int updateStudyGroup(StudyGroup studyGroup);

    public StudyGroup searchStudyGroup(int studyId);
    public List<StudyGroup> searchStudyGroupList();
    public List<StudyCategory> searchStudyCategories();
    public List<WaitingMember> searchWaitingMember(int studyId);
    public List<RecruitmentMember> searchRecruitmentMember(int studyId);

    public int deleteStudyGroup(int studyId);
    public int deleteRecruitmentMember(int recruitmentId);

}
