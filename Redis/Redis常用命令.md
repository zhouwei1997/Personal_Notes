# Redis常用命令

## Redis存储数据的结构

```
#常用的五种数据结构
key-string ：一个key对应一个值
key-hash：一个key对应一个Map
key-list：一个key对应一个列表
key-set：一个key对应一个集合
key-zset：一个key对应一个有序的集合
#另外三种数据结构
HyperLogLog：计算近似值
GEO：地理位置
BIT：一般存储的也是一个字符串，存储的是一个byte[]
```

key-string：最常用的，一般用于存储一个值

key-hash：存储一个对象数据的

key-list：使用list结构实现栈和队列结构

key-set：交集，差集和并集的操作

key-zset：排行榜，积分操作

## string常用命令

```
#添加值
set key value
#取值
get key
#批量操作
mset key value [key value...]
#自增命令（自增1）
incr key
#自减命令（自减1）
decr key
#自增或自减指定数量
incrby key increment
decrby key increment
#设置值的同时，指定生存空间（每次想Redis中添加数据时，尽量都设置上生存时间）
setex key second value
#设置值，如果当前key不存在的话（如果这个key存在，不就行操作。如果这个值不存在，则和set命令一样）
setnx key value
#在key对应的value后，添加内容
append key value
#查看value字符串的长度
strlen key
```

## hash常用命令

```
#存储数据
hset key field value
#获取数据
hget key field
#批量操作
hmset key field value [field value field value ...]
hmget key field [field field ...]
#自增(指定自增的值,key的值可以是正值也可以是负值)
hincrby key field increment
#设置值（如果key和field不存在，则正常添加，否则不就行任何操作）
hsetnx key field value
#检查field是否存在
hexists key field
#删除key对应的某一个field，可以删除多个
hdel key field [filed ……]
#获取当前hash结构中的全部field和value
hgetall key
#获取当前hash结构中的全部field
hkeys key
#获取当前hash结构中全部的value
hvals key
#获取当前hash结构中的field的数量
```

## list常用命令

```
#存储数据（从左侧插入数据,或者右侧插入数据）
lpush key value [value ...]
rpush key value [value ...]
#存储数据（如果key不存在或者key不是list结构，不做任何操作）
lpushx key value [value ...]
rpushx key value [value ...]
#修改数据（在存储数据时，指定索引位置）
#该种方式存储数据会覆盖之前索引位置的数据
#如果index超出了整个列表的长度，也会失败
lset key index value
#弹栈方式获取数据（从左侧或者右侧弹出数据）
lpop key
rpop key
#获取指定索引范围内的数据（start从0开始，stop输入-1，代表最后一个，-2代表倒数第二个）
lrange key start stop
#获取指定索引位置的数据
lindex key index
#获取整个列表的长度
llen key
#删除列表中的数据（删除当前列表中的count个value值，）
#count > 0从右侧删除
#count < 0从左侧删除
#count == 0 删除列表中的全部value
lrem key count value
#保留列表中的数据（保留指定索引范围内的数据，超过整个索引范围会被移除）
ltrim key start stop
#将一个列表中最后的一个数据，插入到另外一个列表的头部位置                       
rpoplpush list1 list2
```

## set常用指令

```
#存储数据
sadd key member [member ...]
#获取数据（获取全部数据）
smembers key 
#随机获取一个数据(获取数据的同时会删除数据)
#count默认为1，代表弹出数据的数量
spop key [count]
#交集（取多个set集合交集）
sinter set1 set2 ...
#并集（获取全部集合中的数据）
sunion set1 set2 ...
#差集（获取多个集合中不一样的数据）
sdiff set1 set2 ...
#删除数据
srem key member [member ...]
#查看当前set集合中是否包含这个值
sismember key member
```

## zset集合中的常用指令

```
#添加数据(score必须是一个数值，member不允许重复)
zadd key score member [score member ...]
#修改member的分数(如果member是存在于key中的，则正常添加分数，如果member不存在，则这个命令相当于zadd指令)
zincrby key increment member
#查看指定的member分数
zscore key memebr
#获取zset中数据的数量
zcard key
#根据score的范围查询member的数量
zcount key min max
#删除zset中的成员
zrem key member [member ...]
#根据分数从小到大排序，获取指定范围内的数据(withsocres如果添加这个参数，那么会返回member对应的分数)
zrange key start stop [withsocres]
#根据分数从小到大排序，获取指定范围内的数据(withsocres如果添加这个参数，那么会返回member对应的分数)
zrevrange key start stop [withsocres]
#根据分数的范围获取数据
#withsocres代表同时返回socre
#添加limit就和MySQL一样
#如果不希望等于min或max的值被查询出来，可以采用“(”分数的方式
#最大值和最小值使用+inf和-inf来标识
zrangebyscore key min max [withsocres] [limit offset count]
#根据分数的范围获取数据
#withsocres代表同时返回socre
#添加limit就和MySQL一样
zrangebyscore key max min [withsocres] [limit offset count]
```

## key常用命令
```
#查看Redis中全部的key(pattern *)
key pattern
#查看某一个key是否存在
exists key
#删除key
del key [key ...]
#设置key的生存时间，单位为秒、毫秒，设置还能存活多久
expire key second
pexpire key milliseconds
#设置key的生存时间，单位为秒、毫秒，设置能存活的时间点
expireat key timestamp
pexoireat key milliseconds
#查看key的剩余生存时间，单位秒、毫秒
#如果返回是-2 代表当前key不存在
#如果返回是-1 代表当前key没有设置生存时间
ttl key
pttl key
#移除key的生存时间
#返回 1 移除成功
#返回 0 key不存在生存时间或key不存在
persist key
#选择操作的库
select 0~15
#移动key到另外一个库中
move key db
```

## 库的常用命令
```
#清空当前所在的数据库
flushdb
#清空全部数据库
flushall
#查看当前数据库中的key的数量
dbsize
#查看最后一次操作时间
lastsave
#实时监控Redis服务接受的目录，以日志的形式显示
monitor
```
