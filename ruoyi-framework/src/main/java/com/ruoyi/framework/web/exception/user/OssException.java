package com.ruoyi.framework.web.exception.user;

import com.ruoyi.framework.web.exception.base.BaseException;

/**
 * OSS信息异常类
 * 
 * @author ruoyi
 */
public class OssException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public OssException(String msg)
    {
        super("oss", new Object[]{msg});
    }
}
