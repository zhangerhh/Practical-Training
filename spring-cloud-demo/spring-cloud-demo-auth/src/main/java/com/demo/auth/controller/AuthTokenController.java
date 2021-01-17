package com.demo.auth.controller;

import com.demo.auth.service.TokenService;
import com.demo.commons.domain.Result;
import com.demo.commons.domain.Token;
import com.demo.commons.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthTokenController {
    @Autowired
    private TokenService tokenService;
    /** 登录认证 **/
    @RequestMapping(value = "/token/password", method = {RequestMethod.GET, RequestMethod.POST},produces = {"application/json;charset=utf-8"})
    public Result passwordGrantType(String username, String password) {
        try {
            Token token = tokenService.authLogin(username, password);
            return ResultUtils.success(token);
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            return ResultUtils.fail(errorMessage, null);
        }
    }

    /** token刷新 **/
    @RequestMapping(value = "/token/refresh_token", method = {RequestMethod.GET, RequestMethod.POST})
    public Result refreshToken(String accessToken, String refreshToken) {
        Token token = null;
        if ((token = tokenService.refreshToken(accessToken, refreshToken)) != null) {
            return ResultUtils.success(token);
        }
        return ResultUtils.fail(token);
    }
}



