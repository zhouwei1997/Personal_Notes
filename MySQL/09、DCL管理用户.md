# DCL管理用户

```mysql
#切换到mysql数据库
use mysql
#查询user表
select * from user；
#创建用户
create user '用户名'@'主机名' identified by '密码';

create user 'zhangsan'@'localhost' identified by '123';

# 删除用户
drop user '用户名'@'主机名';

drop user 'zhangsan'@'localhost';

#修改用户密码
update user set password = password('新密码') where user = '用户名';
set password for '用户名'@'主机名' = password('新密码');

update user set password = password('456') where user = 'zhangsan';
set password for 'zhangsan'@'localhost' = password('456');
```

