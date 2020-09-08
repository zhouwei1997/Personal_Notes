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
