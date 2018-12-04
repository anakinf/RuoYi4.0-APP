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
import org.springframework.web.bind.annotation.PathVariable;
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
            return ResultData.successMsg("You are already logged in");
        }
        else
        {
            return ResultData.successMsg("You are guest");
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResultData requireAuth()
    {
        return ResultData.successMsg("You are authenticated");
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResultData requireRole()
    {
        return ResultData.successMsg("You are visiting require_role");
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResultData requirePermission()
    {
        return ResultData.successMsg("You are visiting permission require edit,view");
    }

    @RequestMapping(path = "/401/{message}")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultData unauthorized(@PathVariable(value = "message") String message)
    {
        return ResultData.eoror(401, message);
    }
}