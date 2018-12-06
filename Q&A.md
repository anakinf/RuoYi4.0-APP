### ruoyi常见问题
#### Q:jar运行方式没有问题，部署到tomcat出现404
###### A:多半是因为没有添加`RuoYiServletInitializer`类，建议同步最新代码或者添加该类

#### Q:有没有整合mybatis-plus，通用mapper，oss，jwt，shiro-redis的？
###### A:先去文档扩展里面看看，大多数已经在了，[http://doc.ruoyi.vip/#/standard/ry05](http://doc.ruoyi.vip/#/standard/ry05)

#### Q:类似`type=${@dict.getType('sys_normal_disable')}`的代码怎么直接调用service的
###### A:Thymeleaf可以通过@beanName访问Spring应用上下文中注册的bean
如` <div th:text="${@urlService.getApplicationUrl()}">...</div>`
在这个例子中，`@urlService`就是在上下文中注册的`Spring Bean`

```
@Configuration
public class MyConfiguration {
    @Bean(name = "urlService")
    public UrlService urlService() {
        return new FixedUrlService("somedomain.com/myapp"); // 一个实现
    }
}

public interface UrlService {
    String getApplicationUrl();
}
```

#### Q:提示`xx.table not exist`
###### A:一开始导入要执行2个sql文件，`ryxxx.sql`和`quartz.sql`