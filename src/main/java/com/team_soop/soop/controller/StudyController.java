package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.AdmissionWaitingMemberReqDto;
import com.team_soop.soop.dto.SaveStudyGroupReqDto;
import com.team_soop.soop.dto.SaveWaitingMemberReqDto;
import com.team_soop.soop.dto.UpdateStudyGroupReqDto;
import com.team_soop.soop.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    StudyGroupService studyGroupService;

    @GetMapping("/category")
    public ResponseEntity<?> searchCategories() {
        return ResponseEntity.ok(studyGroupService.searchStudyCategory());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveStudyGroup(@RequestBody SaveStudyGroupReqDto saveStudyGroupReqDto) {
        studyGroupService.saveStudyGroup(saveStudyGroupReqDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/boardlist")
    public ResponseEntity<?> searchStudyGroupList() {
        return ResponseEntity.ok(studyGroupService.searchStudyGroupList());
    }

    @GetMapping("/board/{studyId}")
    public ResponseEntity<?> searchStudyGroup(@PathVariable int studyId) {
        return ResponseEntity.ok(studyGroupService.searchStudyGroup(studyId));
    }

    @PutMapping("/update/{studyId}")
    public ResponseEntity<?> updateStudyGroup(@PathVariable int studyId, @RequestBody UpdateStudyGroupReqDto updateStudyGroupReqDto){
        return ResponseEntity.ok(studyGroupService.updateStudyGroup(studyId, updateStudyGroupReqDto));
    }

    @DeleteMapping("/delete/{studyId}")
    public ResponseEntity<?> deleteStudyGroup(@PathVariable int studyId) {
        return ResponseEntity.ok(studyGroupService.deleteStudyGroup(studyId));
    }

    @GetMapping("/waiting/{studyId}")
    public ResponseEntity<?> searchWaitingMember(@PathVariable int studyId) {

        return ResponseEntity.ok(studyGroupService.searchWaitingMember(studyId));
    }

    @GetMapping("/recruitment/{studyId}")
    public ResponseEntity<?> searchRecruitment(@PathVariable int studyId) {
        return ResponseEntity.ok(studyGroupService.searchRecruitmentMember(studyId));
    }

    // waiting_member_tb 데이터 추가
    @PostMapping("/apply/period")
    public ResponseEntity<?> applyPeriod(@RequestBody SaveWaitingMemberReqDto saveWaitingMemberReqDto){
        return ResponseEntity.ok(studyGroupService.saveWaitingMember(saveWaitingMemberReqDto));
    }

    @ParamsPrintAspect
    @PutMapping("/admission")
    public ResponseEntity<?> admissionWaitingMember(@RequestBody AdmissionWaitingMemberReqDto admissionWaitingMemberReqDto) {
        studyGroupService.admissionWaitingMember(admissionWaitingMemberReqDto);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/refuse/{waitingId}")
    public ResponseEntity<?> refuseWaitingMember(@PathVariable int waitingId) {
        studyGroupService.refuseWaitingMember(waitingId);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/recruitment/{recruitmentId}")
    public ResponseEntity<?> deleteRecruitmentMember(@PathVariable int recruitmentId) {
        studyGroupService.deleteRecruitmentMember(recruitmentId);
        return ResponseEntity.ok(null);
    }
}