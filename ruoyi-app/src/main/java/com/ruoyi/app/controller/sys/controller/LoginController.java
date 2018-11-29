package com.ruoyi.app.controller.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.app.common.annotation.PassToken;
import com.ruoyi.app.common.base.BaseController;
import com.ruoyi.app.common.exception.UnauthorizedException;
import com.ruoyi.app.common.page.PageData;
import com.ruoyi.app.common.util.JwtUtil;
import com.ruoyi.app.controller.sys.entity.User;
import com.ruoyi.app.controller.sys.service.impl.UserService;

@RestController
public class LoginController extends BaseController
{
    @Autowired
    UserService userService;

    @PassToken
    @PostMapping("/login")
    public PageData login(@RequestBody User loginUser)
    {
        User user = userService.findByUsername(loginUser.getUsername());
        // 这里是演示，正式使用要加密
        if (user.getPassword().equals(loginUser.getPassword()))
        {
            return PageData.success(JwtUtil.sign(loginUser.getUsername(), loginUser.getPassword()));
        }
        else
        {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/getUserId")
    public PageData getUserId()
    {
        return PageData.success(getCurrentUserId());
    }
}