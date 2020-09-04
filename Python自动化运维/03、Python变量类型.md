# Python变量类型

## 变量赋值

Python中的变量赋值不需要类型声明。

每个变量在内存中创建，都包括变量的标识，名称和数据

每个变量在使用前度需要赋值

```python
counter = 100  #赋值整型变量
miles = 1000.0 #浮点型
name = "Join" #字符串
```

## 多个变量赋值

~~~python
#创建一个整型对象，值为1，三个变量分配到相同的内存空间上
a = b = c = 1
# 指定多个对象指定多个变量
a,b,c=1,2,"join"
~~~

## 标准数据类型

- Numbers（数字）

- String（字符串）

- List（列表）

- Tuple（元组）

- Dictionary（字典）

### 列表

列表用`[ ]`标识

列表中值的切割也可以使用变量`[头下标:尾下标]`，就可以截取相应的列表

从左到右索引默认0开始，从右到左索引默认-1开始，下表可以为空表示取到头或尾

~~~python
list = [ 'runoob', 786 , 2.23, 'john', 70.2 ]
tinylist = [123, 'john']
 
print list               # 输出完整列表
print list[0]            # 输出列表的第一个元素
print list[1:3]          # 输出第二个至第三个元素 
print list[2:]           # 输出从第三个开始至列表末尾的所有元素
print tinylist * 2       # 输出列表两次
print list + tinylist    # 打印组合的列表
~~~

### 元组

元组是另一种数据类型，类似于List

元组用`()`标识。内部元素用逗号隔开。但是元组不能二次赋值，相当于只读列表

~~~python
tuple = ( 'runoob', 786 , 2.23, 'john', 70.2 )
tinytuple = (123, 'john')
 
print tuple               # 输出完整元组
print tuple[0]            # 输出元组的第一个元素
print tuple[1:3]          # 输出第二个至第四个（不包含）的元素 
print tuple[2:]           # 输出从第三个开始至列表末尾的所有元素
print tinytuple * 2       # 输出元组两次
print tuple + tinytuple   # 打印组合的元组
~~~

### 字典

字典是除了列表以外在python中最灵活的内置数据结构类型，

列表是有序的对象集合，字典是无序的对象集合

列表和字典的区别在于：字典当中的元素是通过键来存取的，而不是通过偏移存取

字典用`{}`标识。字典由索引（key）和他对应的值value组成

~~~python
dict = {}
dict['one'] = "This is one"
dict[2] = "This is two"
 
tinydict = {'name': 'runoob','code':6734, 'dept': 'sales'}
 
 
print dict['one']          # 输出键为'one' 的值
print dict[2]              # 输出键为 2 的值
print tinydict             # 输出完整的字典
print tinydict.keys()      # 输出所有键
print tinydict.values()    # 输出所有值
~~~

## Python数据类型转换

|         函数         |                         描述                         |
| :------------------: | :--------------------------------------------------: |
|    int(x[,base])     |                  将x转换为一个整数                   |
|    long(x[,base])    |                 将x转换为一个长整数                  |
|       float(x)       |                 将x转换为一个浮点数                  |
| complex(real[,base]) |                     创建一个复数                     |
|        str(x)        |                 将对象x转换为字符串                  |
|       repr(x)        |              将对象x转换为表达式字符串               |
|      eval(str)       | 用来计算在字符串中有效的Python表达式，并返回一个对象 |
|       tuple(s)       |                将序列s转换为一个元组                 |
|       list(s)        |                将序列s转换为一个列表                 |
|        set(s)        |                    转换为可变集合                    |
|       dict(d)        |     创建一个字典。d必须为一个序列(key,value)元组     |
|     frozenset(s)     |                   转换为不可变集合                   |
|        chr(x)        |               将一个整数转换为一个字符               |
|      unichr(x)       |             将一个整数转换为Unicode字符              |
|        ord(x)        |              将一个字符转换为他的整数值              |
|        hex(x)        |            将一个整数转换为十六进制字符串            |
|        oct(x)        |           将一个整数转换为一个八进制字符串           |