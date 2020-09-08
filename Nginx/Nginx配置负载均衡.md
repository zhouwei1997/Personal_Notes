# 负载均衡配置
1、在upstream节点下配置http/https节点
```powershell
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


