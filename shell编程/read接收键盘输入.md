# read接收键盘输入

read [选项] [变量名]

选项：
- -p "提示信息" ：在等待read输入时，输出提示信息
- -t 秒数 ：read命令会一直等待用户输入，使用此选项可以指定等待时间
- -n 字符数 ：read命令只能接收指定字符数，就会执行
- -s : 隐藏输入的数据，适用于机密信息的输入

变量名：
- 变量名可以自定义，如果不指定变量名，会把输入保存到默认变量REPLY
- 如果只提供了一个变量名，则整个输入行赋予该变量
- 如果提供了一个以上变量名，则输入行分为若干字，一个接一个地赋予各个变量，而命令行上的最后一个变量取得剩余的所有字

```shell
#!/bin/bash
 
# @author：恒宇
# @date：2020/8/28 15:16
# @description：

#提示“请输入姓名”并等待30秒，把用户的输入保存到变量name中
read -t 30 -p "Please input your name:" name
#查看变量$name中是否保存了输入的信息
echo "Name is $name"

#提示“请输入年龄”并等待30秒，把用户的输入保存到变量age中
#年龄属于隐私，使用-s
read -s -t 30 -p "Please input your age:" age
#调整输出格式，如果不输出换行，一会的年龄输出不会换行
echo -e "\n"
echo "Age is $age"

read -n 1 -t 30 -p "Please select your gender[M/F]:" gender

echo -e "\n"

echo "Sex is $gender"
```