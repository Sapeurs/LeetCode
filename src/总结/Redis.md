## 1、测试性能

redis-benchmark -h localhost -p 6379 -c 100 -n 100000

测试10万条请求

![image-20210402110025129](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210402110025129.png)

## 2、基础知识

Redis有16个数据库，默认使用第0个，使用select切换。

![image-20210402110520082](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210402110520082.png)

清除当前数据库 `flushdb`

![image-20210402110847857](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210402110847857.png)

清除全部数据库`flushall`

>Redi是单线程的

Redis是基于内存操作，CPU不是Redis性能瓶颈，而是机器的内存和网络带宽。

### Redis命令

setnx (set if not exist) 	# 不存在再设置值

mset k1 v1 k2 v2 k3 v3  # 同时设置多个值

msetnx k1 v1 k4 v4  #会失败，mset是一个原子性的操作，要么一起成功，要么一起失败。

![image-20210402145049388](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210402145049388.png)

### List

基本的数据类型

 在Redis里面，可以把list玩成 栈、队列、阻塞队列

![image-20210402151032772](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210402151032772.png)



![image-20210402151347776](D:\面试相关\Redis.assets\image-20210402151347776.png)



![image-20210402151455669](D:\面试相关\Redis.assets\image-20210402151455669.png)



![image-20210402151558092](D:\面试相关\Redis.assets\image-20210402151558092.png)

![image-20210402151753438](D:\面试相关\Redis.assets\image-20210402151753438.png)



![image-20210402152929374](D:\面试相关\Redis.assets\image-20210402152929374.png)

![image-20210402153118884](D:\面试相关\Redis.assets\image-20210402153118884.png)

![image-20210402153525688](D:\面试相关\Redis.assets\image-20210402153525688.png)

![image-20210402153823866](D:\面试相关\Redis.assets\image-20210402153823866.png)

 

### Set

set中的值是不能重复的

![image-20210402154428497](D:\面试相关\Redis.assets\image-20210402154428497.png)

![image-20210402154555998](D:\面试相关\Redis.assets\image-20210402154555998.png)

![image-20210402154728715](D:\面试相关\Redis.assets\image-20210402154728715.png)

![image-20210402154847395](D:\面试相关\Redis.assets\image-20210402154847395.png)

![image-20210402155002211](D:\面试相关\Redis.assets\image-20210402155002211.png)

![image-20210402155328689](D:\面试相关\Redis.assets\image-20210402155328689.png)

### Hash

Map集合，key-map! 时候的值是一个map集合



![image-20210403153641570](D:\面试相关\Redis.assets\image-20210403153641570.png)

![image-20210403153742092](D:\面试相关\Redis.assets\image-20210403153742092.png)



![image-20210403153846577](D:\面试相关\Redis.assets\image-20210403153846577.png)



![image-20210403153925982](D:\面试相关\Redis.assets\image-20210403153925982.png)



![image-20210403154916934](D:\面试相关\Redis.assets\image-20210403154916934.png)

![image-20210403154940783](D:\面试相关\Redis.assets\image-20210403154940783.png)



### Zset(有序集合)

在set的基础上，增加了一个值，set k1 v1  |  zset k1 score1 v1

![image-20210403155646816](D:\面试相关\Redis.assets\image-20210403155646816.png)

![image-20210403160219641](D:\面试相关\Redis.assets\image-20210403160219641.png)

![image-20210403160608477](D:\面试相关\Redis.assets\image-20210403160608477.png)

![image-20210403160627496](D:\面试相关\Redis.assets\image-20210403160627496.png)

![image-20210403160808188](D:\面试相关\Redis.assets\image-20210403160808188.png)

排行榜可以用zset来实现。

### 三种特殊数据类型

#### geospatial地理位置

![image-20210403164601444](D:\面试相关\Redis.assets\image-20210403164601444.png)



![image-20210403164732626](D:\面试相关\Redis.assets\image-20210403164732626.png)

![image-20210403165005731](D:\面试相关\Redis.assets\image-20210403165005731.png)

![image-20210403205912308](D:\面试相关\Redis.assets\image-20210403205912308.png)



### Hyperloglog

 基数：数据集中不重复元素的个数，可以接受误差。

> #### 简介

Redis  Hyperloglog 基数统计的算法！

网站的UV（一个人访问一个网站多次，但是还是算作一个人）

![image-20210403212903827](D:\面试相关\Redis.assets\image-20210403212903827.png)



### Bitmaps

![image-20210403213455266](D:\面试相关\Redis.assets\image-20210403213455266.png)

![image-20210403213535031](D:\面试相关\Redis.assets\image-20210403213535031.png)

![image-20210403213659273](D:\面试相关\Redis.assets\image-20210403213659273.png)

## 3、事务

Redis事务本质：一组命令的集合！一个事务中的所有命令都会被序列化，在事务执行过程中，会按照顺序执行！

一次性、顺序性、排他性！执行一系列的命令

Redis事务没有隔离级别的概念！

所有的命令在事务中，并没有直接被执行，只有发起执行命令的时候才会执行！Exec

Redis单条命令保证原子性，但是事务不保证原子性。

Redis的事务：

- 开启事务（multi）

- 命令入队

- 执行事务（exec）

  > 正常执行事务

![image-20210405143534960](D:\面试相关\Redis.assets\image-20210405143534960.png)

> 放弃事务

![image-20210405143851679](D:\面试相关\Redis.assets\image-20210405143851679.png)



> 编译型异常（代码有问题，命令有错），事务中的所有命令都不会被执行！



![image-20210405144346563](D:\面试相关\Redis.assets\image-20210405144346563.png)



> 运行时异常（1/0），如果事务队列中存在语法性错误，那么执行命令的时候，其它命令是可以正常执行的。

![image-20210405144532495](D:\面试相关\Redis.assets\image-20210405144532495.png)



> 监控  Watch

**悲观锁**

- 很悲观，认为什么时候都会出问题，无论做什么都加锁！

**乐观锁**

- 很乐观，认为什么时候都不会出问题，所以不会上锁。更新数据的时候去判断一下，在此期间是否有人修改过这个数据，使用version！
- 获取version
- 更新的时候比较version

> Redis监控测试

正常执行成功！

![image-20210405145317407](D:\面试相关\Redis.assets\image-20210405145317407.png)

测试多线程修改值，使用watch可以当做Redis的乐观锁操作

![image-20210405145702580](D:\面试相关\Redis.assets\image-20210405145702580.png)



如果修改失败，获取最新的值就好

![image-20210405145954076](D:\面试相关\Redis.assets\image-20210405145954076.png)





## 4、Jedis

> Jedis是Redis官方推荐的java连接开发工具。使用java操作Redis中间件。

> 测试

1、导入对应的依赖

2、编码测试

- 连接数据库
- 操作命令
- 断开连接

![image-20210405151204282](D:\面试相关\Redis.assets\image-20210405151204282.png)

![image-20210405151216717](D:\面试相关\Redis.assets\image-20210405151216717.png)

### 常用的API

String

List

Set

Hash

Zset

> 事务



### SpringBoot整合

SpringBoot操作数据：spring-data  jpa  jdbc  MongoDB Redis

springdata也是和springboot齐名的项目

说明：在Springboot2.x以后，原来使用的jedis被替换为了lettuce

jedis：采用的直连，多个线程操作的话是不安全的，如果想要避免不安全，使用jedis pool连接池，更像 BIO 模式

lettuce：采用netty，实例可以在多个线程中进行共享，不存在线程不安全的情况，可以减少线程数量。更像 NIO 模式

```java
@Bean
@ConditionalOnMissingBean(name = "redisTemplate")//我们可以自己定义一个redisTemplate来替换这个默认的。
public RedisTemplate<Object, Object> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
    //默认的RedisTemplate没有过多的设置，redis对象都是需要序列化的。
    //两个泛型都是Object, Object类型，我们使用需要强制转换<String, Object>
   RedisTemplate<Object, Object> template = new RedisTemplate<>();
   template.setConnectionFactory(redisConnectionFactory);
   return template;
}

@Bean
@ConditionalOnMissingBean//由于String类型时Redis中最常使用的类型，所以单独提出来一个bean
public StringRedisTemplate stringRedisTemplate(
      RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
   StringRedisTemplate template = new StringRedisTemplate();
   template.setConnectionFactory(redisConnectionFactory);
   return template;
}
```

> 整合测试

1、导入依赖

2、配置连接

3、测试

## 5、Redis.conf详解

通过配置文件启动Redis

> 单位

1.配置文件unit对大小写不敏感



> 包含

![image-20210406200048923](D:\面试相关\Redis.assets\image-20210406200048923.png)

> 网络

```bash
bind 127.0.0.1   #绑定的IP
protected-mode yes #保护模式
port 6379 #端口设置
```

> 通用配置

![image-20210406201002185](D:\面试相关\Redis.assets\image-20210406201002185.png)

> 快照

持久化，在规定的时间内，执行了多少次操作，则会持久化到文件.rdb .aof

如果没有持久化，那么数据断点即失。

![image-20210406201415823](D:\面试相关\Redis.assets\image-20210406201415823.png)



> 复制 REPLICATION



> 安全 SECURITY

可以设置Redis的密码，默认没有密码

![image-20210406201846319](D:\面试相关\Redis.assets\image-20210406201846319.png)

> 限制 CLIENTS

![image-20210406202343718](D:\面试相关\Redis.assets\image-20210406202343718.png)

> APPEND ONLY 模式   aof配置

![image-20210406203111477](D:\面试相关\Redis.assets\image-20210406203111477.png)



## 6、Redis持久化

### RDB(Redis DataBase)

> 什么是RDB

![image-20210407142803725](D:\面试相关\Redis.assets\image-20210407142803725.png)





> 触发机制

1.sava的规则满足的情况下，会自动触发rdb规则。

2.执行flushall命令，也会触发rdb。

3.退出Redis，也会产生rdb文件。

备份就会自动生成dump.rdb文件



> 如何恢复rdb文件

1、只需要将rdb文件放在Redis启动目录就可以，Redis启动的时候回自动检查dump.rdb，并恢复其中的数据。

2、查看需要存放的位置

![image-20210407142512976](D:\面试相关\Redis.assets\image-20210407142512976.png)



优点：

1、适合大规模的数据恢复

2、对数据完整性要求不高

缺点：

1、需要一定的时间间隔进程操作。如果Redis意外宕机，最后一次修改的数据就没有了

2、fork进程的时候，会占用一定的内存空间



### AOF（Append Only File）

> AOF是什么

将我们所有的命令都记录下来，恢复的时候就将这个文件再执行一遍。

![image-20210407144535213](D:\面试相关\Redis.assets\image-20210407144535213.png)

以日志的形式来记录每个写操作，将Redis执行过的所有指令记录下来（读操作不记录），只许追加文件但不可以改写文件，Redis启动时会读取该文件重新构建数据。

***AOF保存的是appendonly.aof文件***



![image-20210407143421871](D:\面试相关\Redis.assets\image-20210407143421871.png)

默认不开启，我们需要手动设置

重启Redis就可以生效。

如果aof文件有错误，这时候Redis是无法启动的，我们需要修复这个aof文件，Redis给我们提供了一个工具`redis-check-aof --fix`

![image-20210407144131145](D:\面试相关\Redis.assets\image-20210407144131145.png)

如果文件正常，重启就可以直接恢复了。





![image-20210407144326525](D:\面试相关\Redis.assets\image-20210407144326525.png)

优点：

1、每一次修改都同步，文件的完整性会更高。

2、每秒同步一次，可能会丢失一秒的数据。

3、从不同步，效率是最高的。

缺点：

1、相对于数据文件来说，aof远远大于rdb，修复的速度也比rdb慢。

2、aof运行效率低，所以Redis默认配置就是rdb持久化。

## 7、Redis主从复制



![image-20210407145632660](D:\面试相关\Redis.assets\image-20210407145632660.png)



![image-20210407145533193](D:\面试相关\Redis.assets\image-20210407145533193.png)



### 环境配置

只配置从库，不用配置主库

![image-20210407150440383](D:\面试相关\Redis.assets\image-20210407150440383.png)

复制3个配置文件，然后修改对应的信息

1、端口

2、pid名字

3、log文件名字

4、dump.rdb名字



***默认情况下，每台Redis服务器都是主节点。***



![image-20210407151126119](D:\面试相关\Redis.assets\image-20210407151126119.png)



![image-20210407151237436](D:\面试相关\Redis.assets\image-20210407151237436.png)



> 细节

主机可以写，从机不能写只能读，主机中的所有信息和数据，都会自动被从机保存。

![image-20210407151949751](D:\面试相关\Redis.assets\image-20210407151949751.png)





### 哨兵模式

![image-20210407154300693](D:\面试相关\Redis.assets\image-20210407154300693.png)





## 8、缓存穿透与雪崩



### 9、数据类型的底层实现及基本使用场景

1. String 底层采用**动态字符串(SDS)**实现

可以实现计数器，微信小程序中喜欢作者与踩一下，采用incrby xx即可

2. Hash 底层有**ziplist(压缩列表)**和**hashtable(哈希表)**两种实现

实现小型购物车，hlen获取商品总数，hgetall勾选所有商品

3. List 底层由**ziplist(压缩列表)**实现，如果数据多的话，会切换为**linkedList(链表)**

实现消息队列，微信订阅号中消息的推送、另外可以利用lrange命令，做基于Redis的分页功能

4. Set 底层由**intset(整数集合)和hashtable(哈希表)**实现，集合元素少的话用intset，否则用hashtable

可以获取交集，实现查找共同好友，共同关注

5. Zset 底层由**ziplist(压缩列表)**和**skiplist(跳表)**实现，元素少的话用ziplist，数据大的话用skiplist

可以实现排行榜功能，根据score进行排序，做范围查找、取 TOP N操作等

6. Bitmap

可以实现签到、打卡功能

7. Hyperloglog

基于loglog算法用于基数统计，可以实现网站访问量功能

8. GEO

实现定位功能，附近的人