# 增量备份脚本 

```powershell
#!/bin/bash

#定义用户名和密码
user=
userpassword=
#增量备份时复制mysql-bin.00000*的目标目录，提前手动创建这个目录
BakDir=/opt/backup/increment_backup/3306
#mysql的数据目录  
              
BinDir=/data/3306/log-bin                              
LogFile=/opt/backup/logs/3306/incremental_backup.log
#mysql的index文件路径
BinFile=/data/3306/log-bin/mysql-bin.index   
/usr/local/mysql/bin/mysqladmin -u$user -p$userpassword -S /usr/local/mysql/mysql_3306.sock flush-logs
#这个是用于产生新的mysql-bin.00000*文件
Counter=`wc -l $BinFile |awk '{print $1}'`
NextNum=0
#这个for循环用于比对$Counter,$NextNum这两个值来确定文件是不是存在或最新的
for file in `cat $BinFile`
do
    base=`basename $file`
    #basename用于截取mysql-bin.00000*文件名，去掉./mysql-bin.000005前面的./
    NextNum=`expr $NextNum + 1`
    if [ $NextNum -eq $Counter ]
    then
        echo $base skip! >> $LogFile
    else
        dest=$BakDir/$base
        if(test -e $dest)
        #test -e用于检测目标文件是否存在，存在就写exist!到$LogFile去
        then
            echo $base exist! >> $LogFile
        else
            cp $BinDir/$base $BakDir
            echo $base copying >> $LogFile
         fi
     fi
done
echo `date +"%Y年%m月%d日 %H:%M:%S"` $Next Bakup succ! >> $LogFile

```

# 全量备份脚本

```powershell
#!/bin/bash
#全量备份脚本

#定义用户名和密码
user=
userpassword=
#定义要备份的数据库
Database_1=pms1cj
Database_2=pms1yc
Database_3=xxl_job_cjwy
Database_4=xxl_job_ycbs
#定义完全备份文件存放路径
BakDir=/opt/backup/full_backup/3306
#定义日志文件
LogFile=/opt/backup/logs/3306/full_backup.log
Date=`date +%Y-%m-%d`
echo " " >> $LogFile
echo " " >> $LogFile
echo "--------------------" >> $LogFile
echo $(date +"%Y-%m-%d %H:%M:%S") 全量备份开始 >> $LogFile
echo "--------------------" >> $LogFile
cd $BakDir
DumpFile_1=$Database_1-$Date.sql
DumpFile_2=$Database_2-$Date.sql
DumpFile_3=$Database_3-$Date.sql
DumpFile_4=$Database_4-$Date.sql
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_1 备份开始 >> $LogFile
echo "------------" >> $LogFile
/usr/local/mysql/bin/mysqldump -u$user -p$userpassword -S /usr/local/mysql/mysql_3306.sock $Database_1 --flush-logs --delete-master-logs --single-transaction > $BakDir/$DumpFile_1
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_1 备份结束 >> $LogFile
echo "------------" >> $LogFile
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_2 备份开始 >> $LogFile
echo "------------" >> $LogFile
/usr/local/mysql/bin/mysqldump -u$user -p$userpassword -S /usr/local/mysql/mysql_3306.sock $Database_2 --flush-logs --delete-master-logs --single-transaction > $BakDir/$DumpFile_2
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_2 备份结束 >> $LogFile
echo "------------" >> $LogFile
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_3 备份开始 >> $LogFile
echo "------------" >> $LogFile
/usr/local/mysql/bin/mysqldump -u$user -p$userpassword -S /usr/local/mysql/mysql_3306.sock $Database_3 --flush-logs --delete-master-logs --single-transaction > $BakDir/$DumpFile_3
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_3 备份结束 >> $LogFile
echo "------------" >> $LogFile
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_4 备份开始 >> $LogFile
echo "------------" >> $LogFile
/usr/local/mysql/bin/mysqldump -u$user -p$userpassword -S /usr/local/mysql/mysql_3306.sock $Database_4 --flush-logs --delete-master-logs --single-transaction > $BakDir/$DumpFile_4
echo $(date +"%Y-%m-%d %H:%M:%S") $Database_4 备份结束 >> $LogFile
echo "------------" >> $LogFile
echo $(date +"%Y-%m-%d %H:%M:%S") 全量备份完成 >> $LogFile
echo $(date +"%Y-%m-%d %H:%M:%S") 备份完成，欢迎下次使用 >> $LogFile
```

# 开启定时任务
每天凌晨两点开启增量备份，每周日早上两点开启全量备份

```powershell
crontab -e
#按下i键进入编辑模式
#每个星期日凌晨2:00执行完全备份脚本
0 2 * * 0 /opt/backup/shell/3306/full_backup.sh >/dev/null 2>&1
#周一到周六凌晨2:00做增量备份
0 2 * * 1-7 /opt/backup/shell/3306/incremental_backup.sh >/dev/null 2>&1
#退出定时任务编辑
#重启定时任务
systemctl start crond
```





