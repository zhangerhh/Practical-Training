package com.demo.auth.mapper;

import com.demo.commons.domain.Permission_Menu;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuMapper {
    /**  查找菜单**/
    Permission_Menu findMenuByPermission(String permission_id);
}
