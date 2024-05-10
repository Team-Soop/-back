package com.team_soop.soop.repository;

import com.team_soop.soop.entity.FeedList;
import com.team_soop.soop.entity.SaveBoardStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SaveBoardMapper {
    public int saveAddBoard(@Param("userId") int userId, @Param("boarId") int boarId, @Param("boardMenuId") int boardMenuId);
    public SaveBoardStatus getSaveBoardStatus(@Param("userId") int userId, @Param("menuId") int menuId, @Param("lunchId") int lunchId);
    public int deleteSaveBoard(@Param("userId") int userId, @Param("menuId") int menuId, @Param("lunchId") int lunchId);
    public List<FeedList> findFeedList(@Param("userId") int userId);
}
