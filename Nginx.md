# Nginx

## Nginx的安装

1. 确认系统中是否安装了gcc、pcre-devel、zlib-devel、openssl-devel

    ```shell
    rpm -qa|grep gcc
    rpm -qa|grep pcre-devel
    rpm -qa|grep zlib-devel
    rpm -qa|grep openssl-devel
    ```

    如果没有安装则进行第二步，否则进入第三步

2. 使用yum安装gcc、pcre-devel、zlib-devel、openssl-devel

    ```shell
    yum install -y gcc、pcre-devel、zlib-devel、openssl-devel
    ```

3. 解压

    ```shell
    tar zxvf nginx-1.11.6.tar.gz
    ```

4. 进入解压目录并配置

    ```shell
    cd nginx-1.11.6
    ./configure --prefix=/usr/local/nginx
    ```

5. 编译安装

    ```shell
    make && make install
    ```

6. 编译完成后进入nginx的安装目录，启动nginx

    ```shell
    cd /usr/local/nginx/sbin
    ./nginx -s reload
    ```

## Nginx负载均衡配置

1. 在upstream节点下配置http/https节点

    ```conf
    upstream test_01{ #test_01为upstream的节点名称，可以自定义，但是需要和下面的proxy_pass对应
    	#weight参数表示权重，一般是根据服务器硬件的性能所配置，硬件条件越好，则权重越大
    	#weight参数也可以理解为轮询的次数
    	server 192.168.220.128 weight=5;
    	server 192.168.220.129 weight=2;
    	server 192.168.220.130 weight=3;
    }
    
    #不带参数的请求，包括restful风格的请求
    location / {
    	proxy_pass http://test_01;  #参数中的test_01与上面upstream中的test_01对应，当nginx获取到该值时，会自动转发给upstream test_01，再由upstream转发给server服务
    	root html;
    	index index.html index.htm
    }
    
    #静态文件配置
    location ~*\.(css|gif|png|jpeg|ico)${
    	root /opt/nginx/jingtaiwenjian;
    }
    
    #jsp类型的请求
    location ~\.jsp{
    	proxy_pass http://test_01；
    }
    ```

    

## 一台服务器上安装多个Nginx

1. 确认系统中是否安装了gcc、pcre-devel、zlib-devel、openssl-devel

    ```shell
    rpm -qa|grep gcc
    rpm -qa|grep pcre-devel
    rpm -qa|grep zlib-devel
    rpm -qa|grep openssl-devel
    ```

    如果没有安装则进行第二步，否则进入第三步

2. 使用yum安装gcc、pcre-devel、zlib-devel、openssl-devel

    ```shell
    yum install -y gcc、pcre-devel、zlib-devel、openssl-devel
    ```

3. 解压

    ```shell
    tar zxvf nginx-1.11.6.tar.gz
    ```

4. 进入解压目录并配置

    ```shell
    cd nginx-1.11.6
    
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

5. 编译安装

    ```shell
    make && make install
    ```

6. 编译完成后进入nginx的安装目录，启动nginx

    ```shell
    cd /usr/local/nginx/sbin
    ./nginx -s reload
    ```

