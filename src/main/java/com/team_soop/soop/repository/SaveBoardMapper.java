package com.team_soop.soop.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SaveBoardMapper {
    public int saveLunchBoard(@Param("userId") int userId, @Param("boarId") int boarId, @Param("boardMenuId") int boardMenuId);
}
