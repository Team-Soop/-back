package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveStudyGroupReqDto;
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

    @ParamsPrintAspect
    @PostMapping("/save")
    public ResponseEntity<?> saveStudyGroup(@RequestBody SaveStudyGroupReqDto saveStudyGroupReqDto) {
        studyGroupService.saveStudyGroup(saveStudyGroupReqDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/boardlist")
    public ResponseEntity<?> searchStudyGroupList() {
        System.out.println(studyGroupService.searchStudyGroupList());
        return ResponseEntity.ok(null);
    }
}