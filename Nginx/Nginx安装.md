#  一、安装 
1、确认系统中是否安装了gcc、pcre-devel、zlib-devel、openssl-devel
```powershell
rpm -qa|grep gcc
rpm -qa|grep pcre-devel
rpm -qa|grep zlib-devel
rpm -qa|grep openssl-devel
```
如果没有安装则进行第二步，否则进入第三步
2、使用yum安装gcc、pcre-devel、zlib-devel、openssl-devel
```powershell
yum install -y gcc、pcre-devel、zlib-devel、openssl-devel
```
3、解压
```powershell
tar zxvf nginx-1.11.6.tar.gz
```
4、进入解压的目录
```powershell
cd nginx-1.11.6
```
5、配置
```powershell
./configure --prefix=/usr/local/nginx
```
6、编译安装
```powershell
make && make install
```
7、编译完成后进入nginx的安装目录，启动nginx
```powershell
cd /usr/local/nginx/sbin
./nginx -s reload
```

