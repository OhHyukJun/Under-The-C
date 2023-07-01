#!/bin/sh

# mysql 데이터 디렉토리 초기화

if [ ! -d /var/lib/mysql/$MARIADB_DATABASE ]; then

	CREATE DATABASE DEEP_SEA ;

	create user '$MARIADB_USER'@'%' identified by '$MARIADB_ROOT_PASSWORD';
	grant all privileges on $MARIADB_DB.* to '$MARIADB_USER'@'%' identified by '$MARIADB_USER';
	flush privileges;

fi
# ForeGround로 실행한다.
/usr/bin/mysqld_safe --user=mysql --datadir=/var/lib/mysql/
