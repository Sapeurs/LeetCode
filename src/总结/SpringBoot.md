# SpringBoot

**优点**

1.快速构建项目：省略了繁琐且重复的 xml 配置，分分钟构建一个 web 工程； 
2.对主流开发框架的无配置集成：提供了很多 Starter 依赖包，开箱即用，无需多余配置； 
3.项目可独立运行：无需外部依赖 Servlet 容器； 
4.极大地提供了开发、部署效率； 
5.监控简单：提供了 actuator 包，可以使用它来对你的应用进行监控。 

## 一、SpringBoot常用注解

1.`@SpringBootApplication`

​	可以用作SpringBoot的启动

> @SpringBootApplication=@EnableAutoConfiguration+@ComponmentScan+@Configuration

```java
@SpringBootApplication(scanBasePackages = {"com.miaosha"})
```

自动扫描com.miaosha下的所有注入的类。

2.`@ResponseBody`

​	该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式，如json、xml等，通过Response响应给客户端。使用此注解此次请求将不再走视图处理器，而是直接将此响应结果写入到输入流中。

假如是字符串则直接将字符串写到客户端；假如是一个对象，此时会将对象转化为json串然后写到客户端

3.`@RestController`

​	相当于@ResponseBody+@Controller合在一起的作用

4.`@RequestParam`

​	对传入的url参数进行限制

5`@RequestBody`

​	主要用来接收前端传递给后端的json字符串中的数据。

​    一个请求，只有一个@RequestBody；一个请求，可以有多个@RequestParam。

## 二、SpringBoot自动装配原理

`@SpringBootApplication`等同于下面三个注解：

- `@SpringBootConfiguration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

其中`@EnableAutoConfiguration`是关键(启用自动配置)，内部实际上就去加载`META-INF/spring.factories`文件的信息，然后筛选出以`EnableAutoConfiguration`为key的数据，加载到IOC容器中，实现自动配置功能！

**总结**

（1）SpringBoot启动会加载大量的自动配置类

（2）我们看我们需要的功能有没有SpringBoot默认写好的自动配置类；

（3）我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件有，我们就不需要再来配置了）

（4）给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。



Spring Boot启动的时候会通过`@EnableAutoConfiguration`注解找到META-INF/spring.factories配置文件中的所有自动配置类，并对其进行加载，而这些自动配置类都是以AutoConfiguration结尾来命名的，它实际上就是一个JavaConfig形式的Spring容器配置类，它能通过以Properties结尾命名的类中取得在全局配置文件中配置的属性如：server.port，而XxxxProperties类是通过`@ConfigurationProperties`注解与全局配置文件中对应的属性进行绑定的。