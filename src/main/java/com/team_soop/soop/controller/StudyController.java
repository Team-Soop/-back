package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveStudyGroupReqDto;
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

    @GetMapping("/search/waiting/{studyId}")
    public ResponseEntity<?> searchWaitingMember(@PathVariable int studyId) {
        System.out.println(studyId);
        return ResponseEntity.ok(null);
    }
}