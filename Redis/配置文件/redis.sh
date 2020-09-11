 #!/bin/sh

# Redis 开机自启动的脚本

#开机启动脚本
PATH=/usr/local/bin:/sbin:/usr/bin:/bin

#端口号
REDISPORT=6379
EXEC=/usr/local/redis-6.0.6/bin/redis-server
REDIS_CLI=/usr/local/redis-6.0.6/bin/redis-cli
PIDFILE=/var/run/redis.pid
CONF=/usr/local/redis-6.0.6/etc/redis.conf

case "$1" in
    start)
        if [ -f $PIDFILE ]
        then
            echo "$PIDFILE exists,process is already running or crashed"
        else
            echo "Starting Redis server ..."
            $EXEC $CONF
        fi
        if [ "$?"="0" ]
        then
            echo "Redis is running..."
        fi
        ;;
    stop)
        if [ -f $PIDFILE ]
        then
            echo "$PIDFILE does not exist, process is not running"
        else
            PID=$(cat $PIDFILE)
                echo "Stopping ..."
                $REDIS_CLI -p $REDISPORT SHUTDOWN
                while [ -x ${PIDFILE} ]
               do
                    echo "Waiting for Redis to shutdown ..."
                    sleep 1
                done
                echo "Redis stopped"
        fi
        ;;
    restart|force-reload)
        ${0} stop
        ${0} start
        ;;
    *)
    echo "Usage: /etc/init.d/redis {start|stop|restart|force-reload}" >&2
        exit 1
    esac
