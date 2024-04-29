package com.team_soop.soop.controller.admin;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.BoardDeleteDto;
import com.team_soop.soop.service.BoardService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardController {

    @Autowired
    BoardService boardService;

    @ParamsPrintAspect
    @DeleteMapping("/board/{menuCategoryName}/{boardId}/delete")
    public ResponseEntity<?> deleteBoard (@PathVariable String menuCategoryName, @PathVariable int boardId) {
        boardService.deleteBoard(menuCategoryName, boardId);
        return ResponseEntity.ok(null);
    }

}
