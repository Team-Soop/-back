package com.team_soop.soop.repository;

import com.team_soop.soop.entity.OAuth2;
import com.team_soop.soop.entity.RoleRegister;
import com.team_soop.soop.entity.SearchUser;
import com.team_soop.soop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);

    public int saveUser(User user);

    public RoleRegister findRoleRegisterByUserIdAndRoleId(@Param("userId") int userId, @Param("roleId") int roleId);

    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);

    public User findUserByOAuth2name(String oAuth2name);

    public int saveOAuth2(OAuth2 oAuth2);

    public int modifyPassword(User user);

    public List<SearchUser> findAllUser(
//            @Param("startIndex") int startIndex,
//            @Param("count") int count,
            @Param("roleId") int roleId,
            @Param("searchTypeId") int searchTypeId,
            @Param("searchText") String searchText);

    public int getUserCount(
            @Param("roleId") int roleId,
            @Param("searchTypeId") int searchTypeId,
            @Param("searchText") String searchText);


}
