# JavaScript

## 概念

JavaScript是一门客户端脚本语言

- 运行在客户端浏览器中的。每一个浏览器都有JavaScript的解析引擎
- 脚本语言：不需要编译，直接就可以被浏览器解析执行

## 功能

1. 可以增强用户与HTML界面的交互过程，可以控制HTML元素，让页面有一些动态的效果，增强用户的体验

## 与HTML结合方式

1. 内部JS：
    1. 定义`<script>`，标签体内容就是js代码
2. 外部JS：
    1. 定义`<script>`，通过src属性引入外部的js文件
3. 注意：
    1. `<script>`可以定义在HTML页面的如何地方。但是定义的位置会影响执行的顺序
    2. `<script>`可以定义多个

## 数据类型

1. 原始数据类型：基本数据类型
    1. number：数字。整型/小数/NaN(一个不是数字的数字类型)
    2. string
    3. boolean
    4. null
    5. undefined：未定义。如果一个变量没有给初始化值，则会被默认赋值为undefined
2. 引用数据类型：对象

## 变量

变量：一小块存储数据的内存空间

> Java语言是强类型语言，而JavaScript是弱类型的语言

语法：

​	  var 变量名 = 初始化值；

```javascript
//定义变量
var a = 3
alter(a);//输出变量值
```

```javascript
//定义number类型
var num = 1;
var num2 = 1.2;
var num3 = NaN;

//输出到页面上
document.writer(num+"<br />");
document.writer(num2+"<br />");
document.writer(num3+"<br />");

//定义String类型
var str = "abc";
var str2 = "edf";
document.writer(str+"<br />");
document.writer(str2+"<br />");

//定义boolean类型
var flag = true;
document.writer(flag+"<br />");

//定义null
var obj = null;
var obj2 = undefined;
var obj3;
document.writer(obj+"<br />");
document.writer(obj2+"<br />");
document.writer(obj3+"<br />");
```

## 运算符

1. 一元运算符：只有一个运算数的运算符
2. 

## 流程控制语句



