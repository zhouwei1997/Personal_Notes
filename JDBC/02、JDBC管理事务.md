# JDBC控制事务

1. 事务：一个包含多个步骤的业务操作，如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败

2. 操作：

   1. 开启事务
   2. 提交事务
   3. 回滚事务

3. 使用Connection对象来管理事务

   1. 开启事务：setAutoCommit(boolean
     autoCommit)：调用该方法设置参数为false，即开启事务
     1. 在执行SQL之前开启事务
   2. 提交事务：commit()
      1. 当所有SQL都执行完后提交事务
   3. 回滚事务：rollback() 
      1. 在catch中回滚事务

