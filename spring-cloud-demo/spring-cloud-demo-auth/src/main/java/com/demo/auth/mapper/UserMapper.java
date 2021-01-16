package com.demo.auth.mapper;

import com.demo.commons.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 14:38
 */
@Repository
public interface UserMapper {

    /**
     * 登录
     *
     * @param username 用户名
     * @return user
     */
    User login(String username);

}



