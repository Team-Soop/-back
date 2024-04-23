package com.team_soop.soop.controller;

import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/save")
public class BoardSaveController {

    @Autowired
    private BoardSaveService boardSaveService;

    @PostMapping("/{lunchId}/lunch/board")
    public ResponseEntity<?> saveLunchBoard(@PathVariable int lunchId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();

        boardSaveService.saveBoard(userId, lunchId, 2);
        return ResponseEntity.ok(null);
    }

}
