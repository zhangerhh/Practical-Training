package com.demo.auth.config;

import com.alibaba.fastjson.JSON;
import com.demo.commons.utils.ResultUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 15:45
 */
@Component
public class TokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String url = httpServletRequest.getRequestURL().toString();
        String grantType = url.substring(url.lastIndexOf("/") + 1);
        if (!url.contains("/auth/token")) {
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtils.notFound()));
        } else if (!grantType.equals("password") && !grantType.equals("code") && !grantType.equals("refresh_token")) {
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtils.grantTypeError()));
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
