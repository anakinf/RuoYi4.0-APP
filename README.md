## 平台简介

本项目FORK自  [若依/RuoYi](https://gitee.com/y_project/RuoYi)
暂时花了几分钟时间把自己整合过的功能传上来：
###### 多数据源切面
删了多数据源注解，改成根据方法名自动切换，默认主从分离（当然主从地址一样），当只有一个数据源的时候虽然会打印日志，实际主从还是同一个，膈应就自己改一下
###### 集成通用mapper
一开始想整合mybatis-plus，这玩意太重了，而且crud和本项目很多地方八字不合。mapper继承com.ruoyi.common.base.BaseMapper<T>后就可以策马奔腾啦，谁用谁知道
###### 控制台日志分等级彩色渲染和多环境修改
具体看logback-spring.xml和application.xml改动
###### 集成七牛云，阿里云，腾讯云OSS
- 先去七牛注册一下（推荐，10g免费空间）
- 详见sql/oss.sql,在上传页面配置好相关参数即可使用

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql)支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 在线构建器：拖动表单元素生成相应的HTML代码。
16. 连接池监视：监视当期系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。
## 在线体验
> admin/admin123

演示地址：http://ruoyi.vip  

文档地址：http://doc.ruoyi.vip

## 演示图

<table>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/25b5e333768d013d45a990c152dbe4d9d6e.jpg"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194326_GBIJ_1438828.png"/></td>
    </tr>
    <tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194443_Qyuq_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194501_U7gT_1438828.png"/></td>
    </tr>
    <tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194525_PApp_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194535_3EM0_1438828.png"/></td>
    </tr>
    <tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194612_kJ4F_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194623_YEXO_1438828.png"/></td>
    </tr>
	<tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132548_ne4U_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194643_MsxF_1438828.png"/></td>
    </tr>
	<tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194658_40L4_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/1005/194712_2ma3_1438828.png"/></td>
    </tr>
</table>


## 若依交流群

QQ群： [![加入QQ群](https://img.shields.io/badge/已满-1389287-blue.svg)](https://jq.qq.com/?_wv=1027&k=5HBAaYN)  [![加入QQ群](https://img.shields.io/badge/QQ群-1679294-blue.svg)](https://jq.qq.com/?_wv=1027&k=5cHeRVW) 点击按钮入群。