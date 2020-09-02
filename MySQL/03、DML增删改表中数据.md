# DML增删改表中数据

## 添加数据

1. 语法

   ```sql
   insert into 表名(列名1,列名2,……,列名N) values(数据1,数据2,……,数据N);
   
   insert into stu(id,name,age) values(1,'张三',18);
   ```

2. 注意事项：

   1. 列名和数值的个数和类型要一一对应
   2. 如果表名后，不定义列名，则默认给所有列添加值
   3. 除了数字类型，其他类型需要引号包括

## 删除数据

1. 语法

   ```sql
   delete from 表名 [where 条件];
   
   #删除id=1的信息
   delete from stu where id = 1;
   ```

2. 清空表

   删除表后，再创建一个同样的空表

   ```sql
   truncate table 表名;
   
   truncate table stu;
   ```

3. 注意事项

   1. 如果不加条件，则删除表中所有记录

## 修改数据

1. 语法

   ```sql
   update 表名 set 列名1 = 值1 ，列名2 = 值2 ，…… 列名N = 值N [where 条件];
   
   update stu set age = 117 where id = 3;
   ```

2. 如果不加任何条件，则会将表中的记录全部修改