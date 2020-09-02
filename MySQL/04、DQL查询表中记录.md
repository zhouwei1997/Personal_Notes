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
   -- 查询姓马的
   select * from student where name like '马%';
   -- 查询第二个字是化的人
   select * from student where name like '_马%';
   ```

   

## 排序查询

1. 语法：order by 子句

   ```mysql
   order by 排序字段1 排序方式1,排序字段2 排序方式2 ……
   ```

2. 排序方式

   1. ASC：升序，默认的排序方式
   2. DESC：降序

   ```sql
   -- 按照数学成绩排名，如果数学成绩一样，则按照英语成绩排名
   SELECT * FROM student ORDER BY math ASC，English ASC;
   ```

3. 注意事项：

   1. 如果有多个排序条件，则当前边的条件值一样时，才会判断第二条件

## 聚合查询

将一列数据作为一个整体，进行纵向计算

1. count：计算个数

   1. 一般选择费控的列：主键
   2. count(*)

2. max：计算最大值

3. min：计算最小值

4. sum：求和

5. avg：计算平均值

   ```mysql
   select count(name) from student;
   
   select count(ifnull(english,0)) from student;
   ```

6. 注意事项

   1. 聚合函数的计算会排除null值

## 分组查询

1. 语法：group by 分组字段

   ```sql
   -- 性别分组，分别查询男，女同学的平均分
   select sex,avg(math+english) from student group by sex;
   
   -- 按照性别分组，分别查询男，女同学的平均分，人数  要求：分数低于70的人，不参与分组，分组之后，人数要大于2人
   select sex,avg(math+english),count(id) from student where math>70 group by sex having count(id)>2;
   ```

2. 注意事项

   1. 分组之后查询的字段：分组字段、聚合函数
   2. where和having的区别
      1. where在分组之前进行限定，如果不满足条件，则不参与分组。having在分组之后进行限定，如果不满足结果，则不会被查询出来
      2. where后不可以跟聚合函数，having可以进行聚合函数判断

## 分页查询



1. 语法：limit 开始的索引，每页查询的条数

   ```mysql
   -- 每页显示3条记录
   select * from student limit 0,3;-- 第一页
   select * from student limit 3,3;-- 第二页
   ```

2. 公式：开始的索引 = （当前的页码 - 1）* 每页显示的条数

