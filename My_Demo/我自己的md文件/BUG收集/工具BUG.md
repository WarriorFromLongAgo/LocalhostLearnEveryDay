# redis

1，(error) MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk. Comm
ands that may modify the data set are disabled. Please check Redis logs for details about the error.

```xml
原因
强制关闭Redis快照导致不能持久化。

进入服务器后
将stop-writes-on-bgsave-error设置为no

127.0.0.1:6379> config set stop-writes-on-bgsave-error no
```

2，Redis配置主从时报错“Could not connect to Redis at 192.168.0.50:6379: Connection refused not connected>

```
只执行这个会有默认端口，./redis-cli

./redis-cli -h 192.168.80.221 -p 6381
```

3，





# 项目管理工具BUG

# git 

1，$ git remote add origin https://github.com/WarriorFromLongAgo/11.git
	fatal: remote origin already exists.

```
$ git remote add origin https://github.com/WarriorFromLongAgo/11.git
fatal: remote origin already exists.

xuegao@DESKTOP-IHFOL0G MINGW64 /bin/sdsd
$ git remote rm origin

xuegao@DESKTOP-IHFOL0G MINGW64 /bin/sdsd
$ git remote add origin https://github.com/WarriorFromLongAgo/11.git

删除一次，然后就可以了
```

