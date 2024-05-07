package com.team_soop.soop.controller.admin;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SearchUserReqDto;
import com.team_soop.soop.entity.SearchUser;
import com.team_soop.soop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/ban")
    public ResponseEntity<?> userBan (@PathVariable int userId) {
        userService.UserBan(userId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/search")
    public ResponseEntity<?> userSearch (SearchUserReqDto searchUserReqDto) {
        return ResponseEntity.ok(userService.UserSearch(searchUserReqDto));
    }

    @GetMapping("/search/count")
    public ResponseEntity<?> getCount(SearchUserReqDto searchUserReqDto) {
        return ResponseEntity.ok(userService.getUserCount(searchUserReqDto));
    }


    @PostMapping("/{newRoleId}/{oldRoleId}/{userId}/update/role")
    public ResponseEntity<?> userAuthorityUpdate(@PathVariable int newRoleId, @PathVariable int oldRoleId, @PathVariable int userId) {
        userService.updateUserRole(newRoleId, oldRoleId, userId);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> userDelete(@RequestBody List<Integer> userIds) {
        userService.deleteUsers(userIds);
        return ResponseEntity.ok(true);
    }



}
