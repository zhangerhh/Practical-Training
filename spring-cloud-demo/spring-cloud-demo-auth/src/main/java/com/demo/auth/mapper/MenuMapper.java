package com.demo.auth.mapper;

import com.demo.commons.domain.Permission_Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    /**  **/
    Permission_Menu findMenuByPermission(String permission_id);
}
