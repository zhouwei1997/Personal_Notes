#!/bin/bash
#全量备份脚本
#需要指定相应的目录、my.cnf、sock等配置文件信息
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