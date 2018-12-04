package com.ruoyi.app.controller.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.app.common.exception.UnauthorizedException;
import com.ruoyi.app.common.page.ResultData;
import com.ruoyi.app.common.util.JwtUtil;
import com.ruoyi.app.controller.sys.entity.AppUser;
import com.ruoyi.app.controller.sys.service.impl.UserService;

@RestController
public class WebController
{
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultData login(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        AppUser appuser = userService.findByUsername(username);
        if (appuser.getPassword().equals(password))
        {
            return ResultData.success(JwtUtil.sign(appuser.getUsername(), appuser.getPassword()));
        }
        else
        {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/article")
    public ResultData article()
    {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated())
        {
            return new ResultData(200, "You are already logged in", null);
        }
        else
        {
            return new ResultData(200, "You are guest", null);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResultData requireAuth()
    {
        return new ResultData(200, "You are authenticated", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResultData requireRole()
    {
        return new ResultData(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResultData requirePermission()
    {
        return new ResultData(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultData unauthorized()
    {
        return new ResultData(401, "Unauthorized", null);
    }
}