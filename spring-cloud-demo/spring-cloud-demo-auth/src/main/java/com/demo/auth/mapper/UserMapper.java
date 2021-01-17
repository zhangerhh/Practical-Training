package com.demo.auth.mapper;

import com.demo.commons.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 登录
     *
     * @param username 用户名
     * @return user
     */
    User login(String username);

    /** 查找用户角色 **/
    String findRoleByUser(String username);

}



