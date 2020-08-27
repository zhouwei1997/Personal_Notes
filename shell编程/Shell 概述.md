# Shell 概述

Shell是操作系统的最外层，Shell可以合并编程语言以控制进程和文件，以及启动和控制其他程序，Shell通过提示输入，向操作系统解释该输入，然后处理来自操作系统的任何结果输出来管理用户和操作系统之间的交互，简单来说，Shell就是一个用户和操作系统之间的命令解释器。

Shell是用户与Linux操作系统之间沟通的桥梁。用户可以输入命令指令，又可以利用Shell脚本编程去运行。

## Shell分类

常见的Shell种类：Bourne Shell（/usr/bin/sh或者/bin/sh）、Bourne Again Shell（/bin/bash）、C Shell（/usr/bin/csh）、K Shell（/usr/bin/ksh）、Shell for Root（/sbin/sh）等。最常用的shell是Bash，也就是Bourne Again Shell（/bin/bash），由于易用和免费，Bash在日常工作中被广泛应用，也是大多数Linux系统默认的Shell。

查看Linux支持的Shell 

```shell
vim /etc/shells

/bin/sh
/bin/bash
/usr/bin/sh
/usr/bin/bash
```

## 第一个Shell程序

```shell
#!/bin/bash
 
# @author：恒宇
# @date：2020/8/27 11:00
# @description：第一个shell程序

#在/tmp目录下新建20200827目录
mkdir -p /tmp/20200827
#打印一行信息
echo "Hello World."
```

