package com.demo.zuul.config;

import com.alibaba.fastjson.JSON;
import com.demo.commons.domain.Token;
import com.demo.commons.domain.User;
import com.demo.commons.utils.RedisUtils;
import com.demo.commons.utils.ResultUtils;
import com.demo.zuul.service.daoserverfeignservice.RoleService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/15
 * @time: 8:54
 */
@Component
public class AuthZuulFilter extends ZuulFilter {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String url = request.getRequestURL().toString();
        boolean isStatic = url.contains("static");
        boolean isAuth = url.contains("authToken");
        return !isStatic && !isAuth;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String tokenStr = request.getParameter("token");
        if (!StringUtils.isEmpty(tokenStr)) {
            Token token = (Token) redisUtils.getValue(tokenStr);
            if (token != null) {
                User user = token.getUser();
                Boolean isPermit = (Boolean) roleService.isPermit(user.getUsername()).getData();
                if (isPermit) RequestContext.getCurrentContext().setSendZuulResponse(isPermit);
                return null;
            }
        }
        RequestContext.getCurrentContext().getResponse().setContentType("text/plain;charset=utf-8");
        RequestContext.getCurrentContext().setSendZuulResponse(false);
        RequestContext.getCurrentContext().setResponseStatusCode(403);
        RequestContext.getCurrentContext().setResponseBody(JSON.toJSONString(ResultUtils.fail("无权访问", null)));
        return null;
    }
}
