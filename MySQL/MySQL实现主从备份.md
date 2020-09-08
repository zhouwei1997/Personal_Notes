# 基本信息

主服务器：192.168.220.128    root    root
从服务器：192.168.220.129    root    root
主从数据库服务器版本：mysql 8.0.11

# 主从备份

## 主数据库服务器
1、修改数据库配置文件
	vim /etc/my.cnf
	在该文件下的[mysqld]节点下新增
	log-bin=mysql-bin
	server-id=1
2、在主节点上添加用于复制的从节点用户及其密码
	create user 'zhouwei'@'192.168.220.129' identified with mysql_native_password by 'zhouwei1997';
	grant replication slave on \*.* to 'zhouwei'@'192.168.220.129';
	flush privileges;

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728111824166.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)
3、获取主节点的当前binary log文件名和位置
	show master status;
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728111938711.png)

## 从数据库服务器
1、修改数据库配置文件
	vim /etc/my.cnf
	在该文件的[mysql]节点下新增
	server-id=2
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728112132634.png)
2、设置主节点配置
	CHANGE MASTER TO
	MASTER_HOST='192.168.220.130',
	MASTER_USER='zhouwei',
	MASTER_PASSWORD='zhouwei1997',
	MASTER_LOG_FILE='mysql-bin.000002',
	MASTER_LOG_POS=1168
3、查看主从同步状态
	show slave status\G;
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728112551984.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)4、开启主从复制
	start slave；
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728112906460.png)
5、查看主从同步状态
	show slave status \G;

