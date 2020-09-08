# 开放，关闭端口

```powershell
#开放tcp的3306端口，--permanent表示永久开放
firewall-cmd --zone=public --add-port=3306/tcp --permanent
#关闭tcp的3306端口
firewall-cmd --zone=public --remove-port=3306/tcp --permanent
#是配置生效，如果不执行该步骤，开放和关闭端口操作不会生效
firewall-cmd --reload
```

# 查看防火墙所有开放的端口

```powershell
firewall-cmd --zone=public --list-ports
```

# 开启、关闭、查看防火墙

```powershell
#开启防火墙
systemctl start firewalld.service
#关闭防火墙
systemctl stop firewalld.service
#查看防火墙的状态
systemctl status firewalld.service
firewall-cmd --state
```

# 查看监听端口

```powershell
#查看3306端口的
netstat -lnpt 3306
```

# 检查端口被那个进程所占用

```powershell
#检查5672端口被那个进程所占用
netstat -lnpt | grep 5672
```

# 查看进程的详细信息

```powershell
#查看进程号为6832的详细信息
ps 6832
```

# 终止进程

```powershell
终止进程号为6832的进程
kill -9 6832
```

