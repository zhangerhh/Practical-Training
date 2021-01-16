package com.demo.zuul.service.daoserverfeignservice;

import com.demo.commons.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/15
 * @time: 10:20
 */
@FeignClient(value = "dao-server")
public interface RoleService {

    @GetMapping("/role/isPermit/{username}")
    public Result isPermit(@PathVariable String username);
}
