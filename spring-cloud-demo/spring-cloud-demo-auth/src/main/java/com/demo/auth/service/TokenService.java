package com.demo.auth.service;

import com.demo.commons.domain.Token;

public interface TokenService {


    /**
     * 获取token授权
     *
     * @param username 用户名
     * @return token
     */
    Token authLogin(String username, String password);


    /**
     * 授权码模式
     *
     * @param buildName 平台凭证
     * @return 授权码code
     */
    String grantTypeCode(String buildName);


    /**
     * 刷新token
     *
     * @param refreshTokenStr
     * @param accessToken
     * @return
     */
    Token refreshToken(String accessToken, String refreshTokenStr);

}
