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
5、编译

```powershell
./configure \
--prefix=/usr/local/nginx2 \
--sbin-path=/usr/local/nginx2/sbin/nginx2 \
--conf-path=/usr/local/nginx2/conf/nginx.conf \
--error-log-path=/usr/local/nginx2/logs/error.log \
--http-log-path=/usr/local/nginx2/logs/access.log \
--pid-path=/usr/local/nginx2/logs/nginx2.pid \
--lock-path=/var/run/nginx2.lock \
--http-client-body-temp-path=/usr/local/nginx2/client_body_temp \
--http-proxy-temp-path=/usr/local/nginx2/proxy_temp \
--http-fastcgi-temp-path=/usr/local/nginx2/fastcgi_temp \
--http-uwsgi-temp-path=/usr/local/nginx2/uwsgi_temp \
--http-scgi-temp-path=/usr/local/nginx2/scgi_temp \
--user=nginx2 \
--group=nginx2 \
--with-pcre \
--with-http_v2_module \
--with-http_ssl_module \
--with-http_realip_module \
--with-http_addition_module \
--with-http_sub_module \
--with-http_dav_module \
--with-http_flv_module \
--with-http_mp4_module \
--with-http_gunzip_module \
--with-http_gzip_static_module \
--with-http_random_index_module \
--with-http_secure_link_module \
--with-http_stub_status_module \
--with-http_auth_request_module \
--with-mail \
--with-mail_ssl_module \
--with-file-aio \
--with-ipv6 \
--with-http_v2_module \
--with-threads \
--with-stream \
--with-stream_ssl_module
```
安装多个nginx则需要多次执行该步骤，但是每次执行的路径不一样
6、编译安装
```powershell
make && make install
```
7、编译完成后进入nginx的安装目录，启动nginx
```powershell
cd /usr/local/nginx/sbin
./nginx -s reload
```


