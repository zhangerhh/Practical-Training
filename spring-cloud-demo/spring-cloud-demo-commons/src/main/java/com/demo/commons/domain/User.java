package com.demo.commons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 10:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String realName;
    private String username;
    private String password;
    private String role;
    private List menu;
}
