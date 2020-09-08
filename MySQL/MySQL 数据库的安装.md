## rpm安装方式

1、下载所需的安装包

https://dev.mysql.com/downloads/mysql/
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200727150603437.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)


2、在/usr/local目录下新建mysql文件夹，跳转到mysql目录下使用rz命令上传第一步中下载的安装到到服务器上
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200727150627651.png)


3、解压：tar -xvf mysql-8.0.11-1.el7.x86_64.rpm-bundle.tar 
![在这里插入图片描述](https://img-blog.csdnimg.cn/202007271506391.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)


4、依次安装

rpm -ivh mysql-community-common-8.0.11-1.el7.x86_64.rpm 
rpm -ivh mysql-community-libs-8.0.11-1.el7.x86_64.rpm 
rpm -ivh mysql-community-client-8.0.11-1.el7.x86_64.rpm
rpm -ivh mysql-community-server-8.0.11-1.el7.x86_64.rpm

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200727150746665.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)


5、通过下列命令，完成对mysql数据库的初始化和相关配置操作
5.1、初始化数据库
mysqld --initialize
5.2、修改mysql目录的所属组和所属人
chown mysql:mysql /var/lib/mysql -R
5.3、开启mysql服务
systemctl start mysqld.service
5.4、设置开机自启动
systemctl enable mysqld
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200727150848894.png)
6、查看初始化密码
cat /var/log/mysqld.log | grep password
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200727151006892.png)
7、登录
	mysql -uroot -p
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728105727424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)输入第6步中的密码即可
8、修改root账户密码
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728105956655.png)
9、使用新密码登录
10、开启远程访问权限
create user 'root'@'%' identified with mysql_native_password by 'root';
grant all privileges on *.* to 'root'@'%' with grant option;
flush privileges;
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728110024199.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)

