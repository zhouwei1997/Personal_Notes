# CSS概述

### 概念

CSS：Cascading Style Sheets 层叠样式表

层叠：多个样式可以作用在同一个HTML的元素上，同时生效

## 好处

1. 功能强大
2. 将内容展示和样式控制分离
   1. 降低耦合度，解耦
   2. 让分工协作更加容易
   3. 提高开发效率

## CSS与HTML的结合方式

1. 内联样式

   1. 在标签内使用style属性指定CSS代码

      ```html
      <div style="color:red;">Hello CSS</div>
      ```

2. 内部样式

   1. 在head标签内，定义style标签，style标签的标签体内容就是CSS代码

      ```html
      <style>
          div{
              color:blue
          }
      </style>
      <div>Hello CSS</div>
      ```

3. 外部样式

   1. 定义CSS资源文件

   2. 在head标签内，定义link标签，引入外部的资源文件

      ```css
      # a.css文件
      div{
          color:green
      }
      ```

      ```html
      <link rel="styleheet" href="css/a.css">
      <div>Hello CSS</div>
      <div>Hello CSS</div>
      ```

      
## 语法格式

格式：

```css
选择器{
    属性名1：属性值1；
    属性名2：属性值2；
    ……
}
```

1. 选择器：筛选具有相似特征的元素
2. 注意：
   1. 每一对属性需要使用`;`隔开，最后一对属性可以不加
   2. 

​      