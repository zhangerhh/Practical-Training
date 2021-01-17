package com.demo.auth.mapper;

import com.demo.commons.domain.Role_Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    /** 查找角色拥有权限 **/
    List<Role_Permission> findPermissionByRole(String role);
}
