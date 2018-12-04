package com.ruoyi.app.controller.sys.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "app_user")
public class AppUser implements Serializable
{
    //
    private static final long serialVersionUID = -4387619029018315254L;

    @Id
    Long                      Id;

    private String            username;

    private String            password;

    private String            role;

    private String            permission;

    /**
     * 
     * @author zmr
     */
    public AppUser()
    {
        super();
    }

    /**
     * @param id
     * @param username
     * @param password
     * @param role
     * @param permission
     * @author zmr
     */
    public AppUser(Long id, String username, String password, String role, String permission)
    {
        super();
        Id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.permission = permission;
    }

    public Long getId()
    {
        return Id;
    }

    public void setId(Long id)
    {
        Id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }
}