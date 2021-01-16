package com.demo.dao.controller;

import com.demo.commons.domain.Result;
import com.demo.commons.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/15
 * @time: 10:10
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping("/isPermit/{username}")
    public Result isPermit(@PathVariable String username) {
        System.out.println("username");
        return ResultUtils.success(true);
    }
}
