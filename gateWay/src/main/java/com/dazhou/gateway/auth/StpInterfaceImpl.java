package com.dazhou.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-14 21:25
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
//        在网关处集成ORM框架，直接从数据库查询数据
//        先从Redis中获取数据，获取不到时走ORM框架查询数据库
//        先从Redis中获取缓存数据，获取不到时走RPC调用子服务 (专门的权限数据提供服务) 获取
        List<String> permissionList = new LinkedList<>();
        permissionList.add("user:add");
        return permissionList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        List<String> roleList = new LinkedList<>();
        roleList.add("admin");
        return roleList;
    }

}
