package com.demo.commons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DxlinY
 * @apiNote: 基础返回对象
 * @date: 2021/1/14
 * @time: 9:59
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;
}
