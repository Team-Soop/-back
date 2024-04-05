package com.team_soop.soop.repository;

import com.team_soop.soop.entity.RoleRegister;
import com.team_soop.soop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);

    public int saveUser(User user);

    public RoleRegister findRoleRegisterByUserIdAndRoleId(@Param("userId") int userId, @Param("roleId") int roleId);

    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);

    public User findUserByOAuth2name(String oAuth2name);
}
