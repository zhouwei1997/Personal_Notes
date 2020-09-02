# awk指令

## 作用特点

1、排除信息

2、查询信息

3、统计信息

4、替换信息

## 语法格式

awk [参数] '模式-动作' 文件

## awk实际操作过程

### 准备测试环境 
```shell
cat awk_test.txt 
Zhang   Dandan      41117397	:250:100:175
Zhang   Xiaoyu      390320151	:155:90:201
Meng    Feixue      80042789	:250:60:50
Wu      Waiwai      70271111	:250:80:75
Liu     Bingbing    41117483	:250:100:175
Wang    Xiaoai      3515064655	:50:95:135
Zi      Gege        1986787350	:250:168:200
Li      Youjiu      918391635	:175:75:300
Lao     Nanhai      918391635	:250:100:175
```
### 命令查询信息的方法

#### 按照行号查询信息

```shell
#查询第二行的信息
awk 'NR==2' awk_test.txt
#查询第二行到第四行中间的内容
awk 'NR==2,NR==4' awk_test.txt
#查询第二行和第四行中间的内容
awk 'NR==2;NR==4' awk_test.txt
```

#### 按照字符查询信息

```shell
#查询出Xiaoyu的信息
awk '/Xiaoyu/' awk_test.txt
#查询出Xiaoyu到Bingbing的信息
awk '/Xiaoyu/,/Bingbing/' awk_test.txt
#查询出Xiaoyu和Bingbing的信息
awk '/Xiaoyu/;/Bingbing/' awk_test.txt
```

## 测试

```shell
#显示Xiaoyu的姓氏和ID号码
awk '/Xiaoyu/{print $1,$3}' awk_test.txt
#姓氏是Zhang的人，显示他的第二次捐款金额及他的名字
awk -F "[:]+" '$1~/Zhang/{print $1,$2,$5}' awk_test.txt
awk -F "[:]+" '$1~/Zhang/{print $1,$2,$(NF-1)}' awk_test.txt
#显示所有以41开头的ID号码的人全名和ID号码
awk '$3~/^41/{print $1,$2,$3}' awk_test.txt
#显示所有ID号码最后一位数字是1或5的人的全名
awk '$3~/1$|5$/{print $1,$2}' awk_test.txt|column -t
```

## awk命令中$符号用法
```
$1 $2 $3      取第几列信息
$NF           取最后一列
$(NF-n)       取倒数第几列
$0            取所有列的信息
```

## awk高级功能
1、对日志信息进行统计

2、对日志信息数值进行求和

3、进行排序分析

4、进行脚本编写（循环语句、判断语句）

## awk模式概念说明

### 普通的模式

1、正则表达式作为模式 
```shell
awk '/^oldboy/{print $1}'
```

2、利用比较匹配信息 
```
NR==2
NR>=2
NR<=2
```

3、NR==3,NR==10

### 特殊的模式

#### BEGIN{}
括号里面的内容会在awk读取文件之前执行
```shell
awk 'BEGIN{print "oldboy"}{print $0}' awk_test.txt
```
##### 作用
1、用于测试

2、用于计算

3、修改内置变量

#### END{}
括号里面内容会在awk读取文件之后执行
```shell
awk '{print $0}END{print "end of file"}' awk_test.txt
```
##### 作用
1、用于显示最终的结果

2、用于计算

```shell
#统计/etc/services文件中空行数量
awk '/^$/{i++}END{print i}' /etc/services
#统计/etc/services文件中#开头的行
awk '/^#/{i++}END{print i}' /etc/services
#统计系统中存在多少个虚拟用户 普通用户
#普通用户
awk '$NF~/bash/{i++}END{print i}' /etc/passwd
#虚拟用户
awk '$NF!~/bash/{i++}END{print i}' /etc/passwd
```