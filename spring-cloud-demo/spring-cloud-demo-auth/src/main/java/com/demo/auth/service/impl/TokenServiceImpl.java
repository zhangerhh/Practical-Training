package com.demo.auth.service.impl;

import com.demo.auth.mapper.MenuMapper;
import com.demo.auth.mapper.PermissionMapper;
import com.demo.auth.mapper.UserMapper;
import com.demo.auth.service.TokenService;
import com.demo.auth.util.TokenUtils;
import com.demo.commons.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private MenuMapper menuMapper;


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
        //授权
        List<String> menus = new ArrayList<>();
        String role = userMapper.findRoleByUser(username);
        List<Role_Permission> role_permissions = permissionMapper.findPermissionByRole(role);
        for(Role_Permission role_permission:role_permissions){
            Permission_Menu permission_menu = menuMapper.findMenuByPermission(role_permission.getPermission_id());
            menus.add(permission_menu.getMenu_id());
        }
        user.setMenu(menus);
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
