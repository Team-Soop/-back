package com.team_soop.soop.controller;

import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/save")
public class SaveBoardController {

    @Autowired
    private BookMarkService bookMarkService;

    public int getUserId() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principalUser.getUserId();
    }

    @PostMapping("/{boardId}/{menuId}/board")
    public ResponseEntity<?> saveLunchBoard(@PathVariable int boardId, @PathVariable int menuId) {
        return ResponseEntity.ok(bookMarkService.saveBoard(getUserId(), boardId, menuId));
    }

    @DeleteMapping("/{boardId}/{menuId}/board")
    public ResponseEntity<?> deleteSaveLunchBoard(@PathVariable int boardId, @PathVariable int menuId) {
        return ResponseEntity.ok(bookMarkService.deleteSaveBoard(getUserId(), menuId, boardId));
    }

    @GetMapping("/{boardId}/{menuId}/board")
    public ResponseEntity<?> getSaveLunchBoard(@PathVariable int boardId, @PathVariable int menuId) {
        return ResponseEntity.ok(bookMarkService.getSaveBoardStatus(getUserId(), menuId, boardId));
    }

    @GetMapping("/boards")
    public ResponseEntity<?> getSavedBoards() {
        return ResponseEntity.ok(bookMarkService.getSaveBoardList(getUserId()));
    }

    @GetMapping("/lunch-boards")
    public ResponseEntity<?> getSavedLunchBoard() {
        return ResponseEntity.ok(null);
    }

}
