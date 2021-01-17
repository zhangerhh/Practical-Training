package com.demo.auth.util;

import com.demo.commons.domain.Commons;
import com.demo.commons.domain.Token;
import com.demo.commons.domain.User;
import com.demo.commons.utils.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Component
public class TokenUtils {

    /**
     * 存储时间
     */
    private static final long DEAD_TIME = 1000 * 60 * 31;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 创建token
     *
     * @param user 传入的用户对象
     * @return token
     */
    public Token createToken(User user) {
        String tokenStr = createTokenStr(user);
        String refreshToken = MD5Encoder.encode((user.getUsername() + "@" + DateUtils.nowTime() + "#" + Commons.REFRESH_TOKEN_SECRET).substring(0, 16).getBytes());
        Token token = new Token(tokenStr, System.currentTimeMillis() + DEAD_TIME, refreshToken, user);

        redisUtils.storeValue(tokenStr, token, TimeUnit.MILLISECONDS, DEAD_TIME);
        return token;
    }


    /**
     * 刷新token
     *
     * @param accessToken  token字符串
     * @param refreshToken 刷新token 的字符串
     * @return token
     */
    public Token refreshToken(String accessToken, String refreshToken) {
        //获取未过期的token
        Token token = (Token) redisUtils.getValue(accessToken);
        if (token == null) return token;
        //判断refreshToken是否一致
        if (!StringUtils.isEmpty(refreshToken) && refreshToken.equals(token.getRefreshToken())) {
            //重新穿件token字符串
            String tokenStr = createTokenStr(token.getUser());
            //刷新token字符串
            token.setToken(tokenStr);
            //刷新过期时间
            token.setExp(System.currentTimeMillis() + DEAD_TIME);
            //重新存储
            redisUtils.storeValue(tokenStr, token, TimeUnit.MILLISECONDS, DEAD_TIME);
            //删除之前的token
            redisUtils.delByKey(accessToken);
        }
        return token;
    }

    /**
     * 鉴权
     *
     * @return boolean
     */
    public boolean accessToken(String accessToken, String role) {
        //获取未过期的token
        Token token = (Token) redisUtils.getValue(accessToken);
        if (token != null && token.getUser().getRole().equals(role)) {
            return true;
        }
        return false;
    }

    private String createTokenStr(User user) {
        return new String(
                Base64.getEncoder().encodeToString(
                        (user.getUsername() + "@" + DateUtils.nowTime() + " #" + Commons.SECRET + "$" + user.getRole()).getBytes())
        );
    }

}
