# sed指令

sed命令：字符流编辑工具

按照每行中的字符进行处理操作

## sed命令作用说明

1、擅长对行进行操作

2、擅长将文件的内容信息进行修改调整/删除

## 具体功能作用

1、文件中添加信息的能力

2、文件中删除信息的能力

3、文件中修改信息的能力

4、文件中查询信息的能力

## 语法格式

sed [OPTION]... {script-only-if-no-other-script} [input-file]... 

命令  参数              条件-处理                       处理文件信息

### sed命令的指令信息
```
p       print           输出信息 
i       insert          插入信息，在指定信息前面插入新的信息
a       append          附加信息，在指定信息后面附加新的信息
```

### sed命令的参数信息
```
-n     取消默认输出
-i     真实编辑文件（将内存中的信息覆盖到磁盘中）
-e     识别sed命令多个操作指令
-r     识别扩展正则
```

## 实践操作

创建测试环境 
```shell
cat > person.txt <<EOF
101,oldboy,CEO
102,zhaoyao,CTO
103,Alex,COO
104,YY,CFO
105,feixue,CIO
EOF
```

1、根据内容信息，输出单行内容
```shell
#将有oldboy行的信息找出来 
sed -n '/oldboy/p' person.txt
```
2、根据内容信息，输出多行内容（连续）
```shell
#将有oldboy到Alex行的信息都输出出来
sed -n '/oldboy/,/Alex/p' person.txt
```
3、根据内容信息，输出多行内容（不连续）
```shell
#将有oldboy和Alex行的信息都输出出来
sed -n '/oldboy/p;/Alex/p' person.txt
```
4、根据文件内容的行号进行查询
```shell
#显示单行信息，显示第三行信息
sed -n '3p' person.txt
#根据行号信息，输出多行内容(连续)
sed -n "1p,3p" person.txt
#根据行号信息，输出多行内容(不连续)
sed -n "1p;3p" person.txt
```
5、添加文件信息 
```shell
#在文件第一行添加信息
sed -i '1i100,oldgirl,UFO' person.txt
#在文件最后一行添加信息
sed -i '$a108,olddog,OOO' person.txt
```

```shell
#在第三行后面添加oldboy.txt信息
sed -i '3aoldboy.txt' person.txt
#在第二行前面添加oldboy.txt信息
sed -i '2ioldboy.txt' person.txt
#在有oldboy行的前面添加oldgirl信息，后面添加olddog信息
sed -i -e '/oldboy/ioldgirl' -e '/oldboy/aolddog' person.txt
```

6、sed命令删除信息
```shell
#删除文件中第三行的信息
sed -i '3d' person.txt
#删除文件中第二行到第六行内容
sed -i '2,6d' person.txt
```

```shell
#删除有oldboy信息的行
sed -i '/oldboy/d' person.txt
#删除第三行和第六行的信息
sed -i -e '2d' -e '6d' person.txt
sed -i '2d;6d' person.txt
```

7、利用sed命令取消空行显示
```shell
sed '/^$/d' person.txt
```

8、sed命令修改信息方法

sed 's#原有内容#修改后内容#g' 文件信息 
```shell
sed 's##oldgirl#old#g' person.txt
```
