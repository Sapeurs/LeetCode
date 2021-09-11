# Linux常用命令

## 1、cd命令

​	用于切换当前目录，如：
​	cd /root/Docements    ： 切换到目录/root/Docements

## 2、ls命令

用于查看文件与目录

## 3、grep命令

分析一行的信息，用于对一些命令的输出进行筛选加工等等

## 4、find命令

查找命令，基本语法   find [PATH] [option] [action]   

例如：

find / -name passwd # 查找文件名为passwd的文件
find . -perm 0755 # 查找当前目录中文件权限的0755的文件

## 5、cp命令

用于复制文件

例如 ：
cp -a file1 file2 #连同文件的所有特性把文件file1复制成文件file2

cp file1 file2 file3 dir #把文件file1、file2、file3复制到目录dir中

## 6、mv命令

用于移动文件、目录或者更改文件名

例如：
mv file1 file2 file3 dir # 把文件file1、file2、file3移动到目录dir中

mv file1 file2 # 把文件file1重命名为file2 

## 7、rm命令

用于删除文件或目录

例如：
rm -i file # 删除文件file，在删除之前会询问是否进行该操作

rm -rf dir # 强制删除目录dir中的所有文件

## 8、ps命令

用于将某个时间点的进程运行情况选取下来并输出

例如：

ps aux # 查看系统所有的进程数据
ps ax # 查看不与terminal有关的所有进程
ps -lA # 查看系统所有的进程数据

## 9、kill命令

用于删除执行中的程序或工作

## 10、killall命令

用于杀死一个进程，与 kill 不同的是它会杀死指定名字的所有进程。

## 11、file命令

用于辨识文件类型

例如：

```
file install.log
install.log: UTF-8 Unicode text
```

## 12、tar命令

用于对文件进行打包

压缩：tar -jcv -f filename.tar.bz2 要被处理的文件或目录名称
查询：tar -jtv -f filename.tar.bz2
解压：tar -jxv -f filename.tar.bz2 -C 欲解压缩的目录

## 13、cat命令

用于查看文本文件的内容

cat text  # 查看text文件中的内容

## 14、chgrp命令

用于改变文件所属用户组

例如：
chgrp users -R ./dir # 递归地把dir目录下中的所有文件和子目录下所有文件的用户组修改为users

## 15、chmod命令

用于改变文件的权限

例如：
chmod 0755 file # 把file的文件权限改变为-rxwr-xr-x

chmod g+w file # 向file的文件权限中加入用户组可写权限

## 16、vim命令

用于文本编辑

## 17、gcc命令

用于把C语言的源程序文件，编译成可执行程序

例如：
\# 把源文件test.c按照c99标准编译成可执行程序test
gcc -o test test.c -lm -std=c99
\#把源文件test.c转换为相应的汇编程序源文件test.s
gcc -S test.c

## 18、time命令

用于测算一个命令（即程序）的执行时间

例如：
time ./process
time ps aux

![image-20210401135542090](Linux常用命令.assets/image-20210401135542090.png)



在程序或命令运行结束后，在最后输出了三个时间，它们分别是：
user：用户CPU时间，命令执行完成花费的用户CPU时间，即命令在用户态中执行时间总和；
system：系统CPU时间，命令执行完成花费的系统CPU时间，即命令在核心态中执行时间总和；
real：实际时间，从command命令行开始执行到运行终止的消逝时间；

## 19、mkdir命令

用于建立目录

## 20、netstat命令

用于查看网络状态

## 21、free命令

用于显示内存状态。

free指令会显示内存的使用情况，包括实体内存，虚拟的交换文件内存，共享内存区段，以及系统核心使用的缓冲区等。

```shell
# free //显示内存使用信息
total   used   free   shared   buffers  cached
Mem:    254772 184568 70204 0  5692     89892
-/+  buffers/cache: 88984 165788
Swap: 524280 65116 459164
```

## 22、df命令

用于检查linux服务器的文件系统的磁盘空间占用情况。利用该命令来获取硬盘被占用了多少空间，目前还剩下多少空间等信息。

例如：

df -h # 查看当前目录磁盘使用情况

df -h /data/ # 查看指定目录磁盘使用情况

## 23、top命令

用于实时显示 process 的动态。

![image-20210401135230426](Linux常用命令.assets/image-20210401135230426.png)

cpu us : 用户空间cpu使用情况（用户态进程占比）
cpu sy：内核空间cpu使用情况（核心态进程占比）
load average：1分钟/5分钟/15分钟负载load平均值，跟着核系数变化，0表示正常，1表示cpu打满，1+代表等待阻塞
memory：free 空闲内存，used使用内存

## 24、wc命令

用于统计指定文件中的字节数、字数、行数

wc -l filename #查看文件里有多少行

wc -w filename #查看文件里有多少个word。

wc -c filename #查看文件字节数



## 25、tail命令

用于查看文件的内容，有一个常用的参数`-f`常用于查看正在改变的日志文件

例如

`tail -f filename`：将filename文件里的最尾部的内容显示在屏幕上，并且不断刷新

