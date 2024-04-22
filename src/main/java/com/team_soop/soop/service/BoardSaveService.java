package com.team_soop.soop.service;

import com.team_soop.soop.repository.SaveBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSaveService {

    @Autowired
    SaveBoardMapper saveBoardMapper;

    public int saveBoard(int userId, int boarId, int boardMenuId) {

        return saveBoardMapper.saveLunchBoard(userId, boarId, boardMenuId);

    }

}
