package com.ruoyi.app.common.base;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.app.common.interceptor.AuthenticationInterceptor;
import com.ruoyi.app.common.page.ResultData;
import com.ruoyi.app.common.page.PageDomain;
import com.ruoyi.app.common.page.PageSupport;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.StringUtils;

/**
 * web层通用数据处理
 */
public class BaseController
{
    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = PageSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 封装分页数据
     * @param list
     * @return
     * @author zmr
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected ResultData getDataPage(List<?> list)
    {
        ResultData rspData = new ResultData();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(int code, String message)
    {
        return AjaxResult.error(code, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    public static long getCurrentUserId()
    {
        Long userId = (Long) PageSupport.getRequest().getAttribute(AuthenticationInterceptor.USER_KEY);
        if (null == userId)
        {
            userId = 0l;
        }
        return userId;
    }
}
