# Shell变量

Shell编程语言是非类型的解释型语言，不需要事先声明一个变量。Shell给一个变量赋值实际上就是定义了这个变量，在Linux支持的所有shell中，都可以使用赋值符号（=）为变量赋值

## Shell变量分类

Shell变量分为两种，局部变量和环境变量

### 局部变量

局部变量在在创建他们的Shell脚本中使用

```shell
a = 123
```



### 环境变量

环境变量则是在创建他们的Shell脚本中使用及派生出来的任意子进程中使用

#### 常见的系统变量

$0：当前脚本的名称

$n：当前脚本的第n个参数，n=1,2......9

$*：当前脚本的所有参数（不包括程序本身）

$#：当前脚本的参数个数（不包括程序本身）

$？：命令或程序执行后的状态，一般返回0表示执行成功

$UID：当前用户的ID

$PWD：当前所在的目录

## 企业实战菜单系列

```shell
#!/bin/bash
 
# @author：恒宇
# @date：2020/8/27 11:41
# @description：自动安装httpd

echo -e '\033[32m-----------------------\033[0m'
FILES=httpd-2.2.31.tar.bz2
URL=http://mirrors.cnnic.cn/apache/httpd/
PREFIX=/usr/local/apache2/
echo -e "\033[36mPlease Select Install Menu:\033[0m"
echo
echo "01)、官方下载 $FILES"
echo "02)、解压$FILES 源码包."
echo "03)、编译安装Httpd服务器."
echo "04)、启动HTTPD服务器."
echo -e '\033[32m-----------------------\033[0m'
sleep 20
echo Done
```

