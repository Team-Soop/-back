package com.team_soop.soop.service;

import com.team_soop.soop.entity.SaveBoardStatus;
import com.team_soop.soop.repository.SaveBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSaveService {

    @Autowired
    SaveBoardMapper saveBoardMapper;

    public int saveBoard(int userId, int boarId, int boardMenuId) {
        return saveBoardMapper.saveAddBoard(userId, boarId, boardMenuId);
    }

    public SaveBoardStatus getSaveBoardStatus(int userId, int menuId, int lunchId) {
        return saveBoardMapper.getSaveBoardStatus(userId, menuId, lunchId);
    }

    public int deleteSaveBoard(int userId, int menuId, int lunchId) {
        return saveBoardMapper.deleteSaveBoard(userId, menuId, lunchId);
    }

}
