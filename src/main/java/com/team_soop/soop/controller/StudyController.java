package com.team_soop.soop.controller;

import com.team_soop.soop.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    StudyGroupService studyGroupService;

    @GetMapping("/category")
    public ResponseEntity<?> searchCategories() {
        return ResponseEntity.ok(studyGroupService.searchStudyCategory());
    }
}
