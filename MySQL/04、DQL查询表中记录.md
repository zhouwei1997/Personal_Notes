# DQL查询表中的记录

## 语法

```sql
select 
	字段1，字段2 …… 字段n
from
	表名列表
where 
	条件列表
group by
	分组字段
having
	分组后的条件
order by
	排序
limit
	分页限定;
```

## 基础查询

### 多个字段查询

```sql
select 字段名1,字段名2 …… 字段名n from 表名;

select name,age from student;
```

注意事项

1. 如果查询所有的字段，则可以使用* 代替字段列表

### 去重查询

关键字：distinct

```mysql
#查询学生来自于那些地方
select address from student;

#去掉程序的记录
select distinct address from student;
```

### 计算列

1. 一般可以使用四则运算计算一些列的值（一般只会计算数值型的计算）

2. ifnull(表达式1，表达式2) ：null参与的运算，计算结果都为null

   1. 表达式1：那个字段需要判断是否为null
   2. 表达式2：如果该字段为null后的替换值

   ```sql
   -- 给所有的数学家5分
   select math+5 from student；
   -- 查询math+English的和
   select *,(math+english) as 总成绩 from student;
   ```

### 起别名

关键字：AS

1. AS关键字在使用的时候也可以省略

   ```mysql
   #使用别名
   select name as 姓名,age as 年龄 from student;
   #表使用别名
   select st.name as 姓名,age as 年龄 from student as st;
   ```

## 条件查询

1. where字句后跟条件

2. 运算符

   ​	\>、<、<=、>=、=、<>

   ​	BETWEEN...AND

   ​	IN（集合）

   ​	LINK：模糊查询

   ​		占位符：

   ​				_：单个任意字符

   ​				%：多个任意字符

   ​		IS NULL

   ​		and 或 &&

   ​		or 或 ||

   ​		not 或 ！

   ```mysql
   -- 查询年龄大于20岁
   SELECT * FROM student WHERE age > 20;
   SELECT * FROM student WHERE age >= 20;
   -- 查询年龄等于20岁
   SELECT * FROM student WHERE age = 20;
   -- 查询年龄不等于20岁
   SELECT * FROM student WHERE age != 20;
   SELECT * FROM student WHERE age <> 20;
   -- 查询年龄大于等于20 小于等于30
   SELECT * FROM student WHERE age >= 20 &&  age <=30;
   SELECT * FROM student WHERE age >= 20 AND  age <=30;
   SELECT * FROM student WHERE age BETWEEN 20 AND 30;
   -- 查询年龄22岁，18岁，25岁的信息
   SELECT * FROM student WHERE age = 22 OR age = 18 OR age = 25
   SELECT * FROM student WHERE age IN (22,18,25);
   -- 查询英语成绩为null
   SELECT * FROM student WHERE english = NULL; -- 不对的。null值不能使用 = （!=） 判断
   SELECT * FROM student WHERE english IS NULL;
   -- 查询英语成绩不为null
   SELECT * FROM student WHERE english  IS NOT NULL;
   ```

   

