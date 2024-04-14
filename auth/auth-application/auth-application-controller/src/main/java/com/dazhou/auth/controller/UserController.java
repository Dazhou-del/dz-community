package com.dazhou.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-14 17:25
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    // 测试登录，浏览器访问： http://localhost:2510/user/doLogin
    @RequestMapping("doLogin")
    public SaResult  doLogin(String username, String password) {
        // 第1步，先登录上
        StpUtil.login(10001);
        // 第2步，获取 Token  相关参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 第3步，返回给前端
        return SaResult.data(tokenInfo);
    }

    // 查询登录状态，浏览器访问： http://localhost:2510/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}

