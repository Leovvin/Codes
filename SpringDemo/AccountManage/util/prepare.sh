function startMysql(){
    sudo systemctl start mysqld
    mysqlstatus=$(systemctl status mysqld|grep running|wc -l)
    if [ $mysqlstatus -eq 1 ] ;then
        echo "mysql server is start success"
    else 
        echo "mysql server start failed"
    fi
}

mysqlstatus=$(systemctl status mysqld|grep running|wc -l)
if [ $mysqlstatus -eq 1 ] ;then
    echo "mysql server is running"
else 
    echo "start mysql server"
    startMysql
fi
