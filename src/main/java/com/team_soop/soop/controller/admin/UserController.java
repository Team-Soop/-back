package com.team_soop.soop.controller.admin;

import com.team_soop.soop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/ban")
    public ResponseEntity<?> userBan (@PathVariable int userId) {
        userService.UserBan(userId);
        return ResponseEntity.ok(null);
    }

//    @GetMapping("")

}
