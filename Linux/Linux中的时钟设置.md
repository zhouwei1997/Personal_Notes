# Linux时钟
Linux中的时钟分为硬件时钟和系统时钟两种
1、硬件时钟即BIOS时钟，就是CMOS设置时能看到的时间
2、系统时钟即Linux系统Kernel时间

## 硬件时钟
1、查看硬件时钟
	

```powershell
hwclock --show
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729100746352.png)

2、设置硬件时间
	该种方式设置的硬件时间在系统重启后会被还原为BIOS默认的时间
	

```powershell
hwclock --set --date="09/18/17 10:23:34"
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729101102855.png)
3、设置系统时间与硬件时间同步

```powershell
hwclock --hctosys
```
4、保存时钟

```powershell
clock -w
```

## 系统时间
1、查看系统时间

```powershell
#查看系统时间使用date指令来查看
date 
```
2、设置系统时间

```powershell
#使用该方式设置的系统时间只是临时性的，在系统重启后会还原为默认的系统时间
date -s "2019/06/12 12:22:34"
```
3、永久设置系统时间
如果需要永久的设置系统时间，则需要先修改硬件时间，然后通过系统时间和硬件时间同步，从而达到修改系统时间的目的

