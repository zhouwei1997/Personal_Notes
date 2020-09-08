# NTP服务器搭建

## 一、安装NTP服务
1、确认是否安装了NTP服务
	

```powershell
rpm -qa|grep ntp
#如果存在ntp服务则代表该设备已经安装了ntp服务
```
2、安装ntp服务

```powershell
yum -y install ntp
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072910251080.png)

## 修改NTP服务
1、修改/etc/ntp.conf配置文件

```powershell
vim /etc/ntp.conf
#新增以下代码
server 0.cn.pool.ntp.org iburst
server 1.cn.pool.ntp.org iburst
server 2.cn.pool.ntp.org iburst
server 3.cn.pool.ntp.org iburst
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729102721258.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)
2、启用ntp服务，并设置为开机自启动

```powershell
#开启ntp服务
systemctl start ntpd
systemctl enable ntpd
```
3、查看ntp服务是否同步

```powershell
ntpq -p
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729102901418.png)
4、开放ntp服务器的端口

```powershell
#ntp服务的端口为udp 123
firewall-cmd --zone=public --add-port=123/udp --permanent
firewall-cmd --reload
firewall-cmd --zone=public --list-ports
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072910315220.png)

# NTP客户端配置

## 一、安装
NTP客户端的安装方式与服务器端安装方式一致，可以直接参考服务器端安装

## 二、修改配置信息
1、修改ntp配置文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729103622219.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)
2、与ntp服务器进行同步操作

```powershell
#192.168.220.130  该地址是ntp服务器的地址
ntpdate -u 192.168.220.130
```
3、查看ntp同步状态

```powershell
ntpq -p
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072910392088.png)


