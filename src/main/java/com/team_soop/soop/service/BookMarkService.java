package com.team_soop.soop.service;

import com.team_soop.soop.dto.SearchFeedRespDto;
import com.team_soop.soop.entity.FeedList;
import com.team_soop.soop.entity.SaveBoardStatus;
import com.team_soop.soop.repository.SaveBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMarkService {

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

    public List<SearchFeedRespDto> getSaveBoardList(int userId) {
        return saveBoardMapper.findFeedList(userId).stream().map(FeedList::searchFeedRespDto).collect(Collectors.toList());
    }

}
