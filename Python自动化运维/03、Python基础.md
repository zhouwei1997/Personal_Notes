# Python基础

## 基础

### 变量名

Python的变量名可以是数字、字母和下划线。

```
1.数字不能开头
2.变量不能是用关键字 'and', 'as', 'assert', 'break', 'class', 'continue', 'def', 'del', 'elif', 'else', 'except', 'exec', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'not', 'or', 'pass', 'print', 'raise', 'return', 'try', 'while', 'with', 'yield'
3.最好不要和Python内置的东西重复
```

```python
a12_b1 = "欲练此功避险asdfasdfasdfasdfasdfasdfasdfasdf子宫..."
print(a12_b1)
print(a12_b1)
print(a12_b1)

print("欲练此功避险子宫...")
print("欲练此功避险子宫...")
print("欲练此功避险子宫...")
```

### 条件语句

#### if条件语句

##### if基本语句

```
if 条件：
	内部代码块
else：
	内部代码块
```

```python
if 1==1:
    print("欢迎进入")
    print("谢谢")
else:
    print("错误")
```

##### if嵌套语句

```python
if 1==1:
    if 2==2:
        print("欢迎进入")
        print("谢谢")
    else:
        print("错误1")
else:
    print("错误")
```

##### if elif

```
if 条件1：
	代码块
elif 条件2：
	代码块
elif 条件3:
	代码块
else
	代码块
print('end')
```



## 循环语句

### while循环

```python
#求1-100的所有数的和
n = 1
s = 0
while n < 101:
	s = s + n						
	n = n + 1
print(s)
```







