package com.team_soop.soop.service;

import com.team_soop.soop.dto.*;
import com.team_soop.soop.entity.RecruitmentMember;
import com.team_soop.soop.entity.StudyCategory;
import com.team_soop.soop.entity.StudyGroup;
import com.team_soop.soop.entity.WaitingMember;
import com.team_soop.soop.exception.SaveException;
import com.team_soop.soop.repository.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public int saveStudyGroup(SaveStudyGroupReqDto saveStudyGroupReqDto) {
        return studyMapper.saveStudyGroup(saveStudyGroupReqDto.toEntity());
    }

    public List<SearchStudyGroupListRespDto> searchStudyGroupList() {
        List<StudyGroup> studyGroupList = studyMapper.searchStudyGroupList();
        List<SearchStudyGroupListRespDto> searchStudyGroupListRespDtos = new ArrayList<>();

        for (StudyGroup studyGroup : studyGroupList) {
            searchStudyGroupListRespDtos.add(studyGroup.toSearchStudyGroupListRespDto());
        }
        return searchStudyGroupListRespDtos;
    }

    public List<SearchStudyGroupListRespDto> mySearchStudyGroupList(int userId) {
        List<StudyGroup> studyGroupList = studyMapper.mySearchStudyGroupList(userId);
        List<SearchStudyGroupListRespDto> searchStudyGroupListRespDtos = new ArrayList<>();

        for (StudyGroup studyGroup : studyGroupList) {
            searchStudyGroupListRespDtos.add(studyGroup.toSearchStudyGroupListRespDto());
        }
        return searchStudyGroupListRespDtos;
    }

    public SearchStudyGroupRespDto searchStudyGroup(int studyId) {
        return studyMapper.searchStudyGroup(studyId).toSearchStudyGroupRespDto();
    }

    public int updateStudyGroup(int studyId, UpdateStudyGroupReqDto updateStudyGroupReqDto){
        return studyMapper.updateStudyGroup(updateStudyGroupReqDto.toEntity(studyId));
    }

    public int deleteStudyGroup(int studyId) {
        return studyMapper.deleteStudyGroup(studyId);
    }

    public List<SearchWaitingMemberRespDto> searchWaitingMember(int studyId) {
        List<SearchWaitingMemberRespDto> searchWaitingMemberRespDtos = new ArrayList<>();
        List<WaitingMember> waitingMembers = studyMapper.searchWaitingMember(studyId);

        for(WaitingMember waitingMember : waitingMembers) {
            searchWaitingMemberRespDtos.add(waitingMember.toSearchWaitingMemberRespDto());
        }

        return searchWaitingMemberRespDtos;
    }

    public List<SearchRecruitmentRespDto> searchRecruitmentMember(int studyId) {
        List<SearchRecruitmentRespDto> searchRecruitmentRespDtos = new ArrayList<>();
        List<RecruitmentMember> recruitmentMembers = studyMapper.searchRecruitmentMember(studyId);

        for(RecruitmentMember recruitmentMember : recruitmentMembers) {
            searchRecruitmentRespDtos.add(recruitmentMember.toSearchRecruitmentRespDto());
        }

        return searchRecruitmentRespDtos;
    }

    public int saveWaitingMember(SaveWaitingMemberReqDto saveWaitingMemberReqDto) {
        return studyMapper.saveWaitingMember(saveWaitingMemberReqDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void admissionWaitingMember(AdmissionWaitingMemberReqDto admissionWaitingMemberReqDto) {
        int saveCount = 0;
        WaitingMember waitingmember = admissionWaitingMemberReqDto.toEntity();

        saveCount += studyMapper.admissionWaitingMember(waitingmember.getWaitingId());
        saveCount += studyMapper.saveRecruitmentMember(waitingmember);

        if (saveCount < 2) {
            throw new SaveException();
        }
    }

    public void refuseWaitingMember(int waitingId) {
        studyMapper.refuseWaitingMember(waitingId);
    }

    public void deleteRecruitmentMember(int recruitmentId){
        studyMapper.deleteRecruitmentMember(recruitmentId);
    }
}
