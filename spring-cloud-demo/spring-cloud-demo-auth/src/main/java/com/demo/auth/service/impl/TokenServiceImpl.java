package com.demo.auth.service.impl;

import com.demo.auth.mapper.UserMapper;
import com.demo.auth.service.TokenService;
import com.demo.auth.util.TokenUtils;
import com.demo.commons.domain.Commons;
import com.demo.commons.domain.Token;
import com.demo.commons.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 14:56
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenUtils tokenUtils;


    @Override
    public Token authLogin(String username, String password) {
        //登录
        User user = userMapper.login(username);
        //判断相关重要数据
        if (user == null) {
            throw new RuntimeException(Commons.USER_NOT_FOUND);
        } else if (!user.getPassword().equals(password)) {
            throw new RuntimeException(Commons.PASSWORD_ERROR);
        }
        //密码置空
        user.setPassword(null);
        //获取token
        return tokenUtils.createToken(user);
    }

    @Override
    public String grantTypeCode(String buildName) {
        return null;
    }

    @Override
    public Token refreshToken(String accessToken, String refreshTokenStr) {
        return tokenUtils.refreshToken(accessToken, refreshTokenStr);
    }
}
