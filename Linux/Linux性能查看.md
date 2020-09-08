# CPU性能查看
1、查看物理CPU个数
	

```powershell
cat /proc/cpuinfo |grep "physical id"|sort|uniq|wc -l
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729144152118.png)
2、查看每个物理CPU中的核心数
	

```powershell
cat /proc/cpuinfo |grep "cpu cores"|wc -l
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729144252781.png)
3、逻辑CPU个数
	

```powershell
cat /proc/cpuinfo |grep "processor" |wc -l
#逻辑CPU个数=物理CPU个数 * 核心数
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729144416793.png)

# 内存查看
1、查看内存使用情况

```powershell
free -m
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072914464669.png)

# 硬盘查看
1、查看硬盘及分区信息

```powershell
fdisk -l
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729144726663.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)

2、查看文件系统的磁盘空间占用情况

```powershell
du -h
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729144801899.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)
3、查看磁盘的IO性能

```powershell
#每两秒显示一次，一共显示五次
iostat 2 5
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729144912675.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)

# 文件限制
1、查看当前用户的文件数限制

```powershell
ulimit -n
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729145012705.png)
2、查看系统级别的文件限制

```powershell
sysctl -a
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072914543353.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729145442737.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)

3、修改打开最大文件数
	一般情况下操作系统的最大文件数是根据硬件资源计算出来的，如果需要强行修改最大打开文件数可以通过`ulimit -n 19999`来修改，但是这种修改方式只是对当前进程有效，如果需要永久修改则需要修改/etc/security/limits.conf（重启后生效）
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729145715351.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)
4、查看所有进程的文件打开数
	

```powershell
lsof |wc -l
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729145804611.png)
5、查看某个进程打开的文件数

```powershell
lsof -p pid |wc -l
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729145840620.png)
6、查看系统中各个进程分别打开了多少句柄数

```powershell
losf -n|awk '{print $2}'|sort|uniq -c|sort -nr|more
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729145948317.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NjMzOTcz,size_16,color_FFFFFF,t_70)

