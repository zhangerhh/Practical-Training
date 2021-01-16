package com.demo.commons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: DxlinY
 * @apiNote: token基础类
 * @date: 2021/1/14
 * @time: 9:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {

    private String token;
    private Long exp;
    private String refreshToken;
    private User user;

}
