

# CentOS常用指令

## linux 基础指令集

mkdir --help 查看帮助

pwd 进入当前的文件夹
cd 
ls 显示所有文件s -a 显示所有文件，包括隐藏文件
ls -l 显示所有文件的详细信息	简写为ll
cd Doc 按下tab自动补全，仅限于虚拟机内部
cd .. 退回到上一级目录
cd /usr/etc 强制到达某个目录
cd root 进入root目录
cd - 到达上一次的目录

mkdir **** 创建一个文件
rmdir **** 删除一个文件，只能删除空的目录
mkdir -p aaa/bbb 创建多级目录

cat install.log	显示这个文件的所有信息，就是打开这个文件
more install.log 显示一屏
	1，然后按回车，一行行的往下走   
	2，按下空格，会显示一整屏幕
	3，按下 q 可以退出，Ctrl+c 也可以退出 
less 和more相同，但是可以使用滚轮上下

tail -10 install.log 显示最后10行的数据
tail -f install.log 可以动态的显示数据

./startup.sh 启动当前目录下的 这个文件

cp anaconda-ks.cfg aaa/ 将当前目录下的这个文件，转移到当前目录的 aaa目录下
cp anaconda-ks.cfg aaa/a.txt 将当前目录下的这个文件，转移到当前目录的aaa目录下，并且进行重命名操作
cp a.txt b.txt 复制a.txt为b.txt
mv a.txt /root/bb 剪切a.txt文件到，root目录的bb目录下
rm a.txt 删除a.txt，输入y确认删除。输入n不删除
rm -r bb 删除bb目录，会一个个的提示是否删除目录下的所有文件
rm -rf bb 不提示直接删除
rm -rf /* 删除目录下的所有文件

tar：一般压缩文件的后缀都是：tar.gz
	-c：创建一个新的tar的文件
	-v：显示运行过程的信息
	-f：指定文件名
	-z：调用gzip命令进行压缩
	-t：查看压缩文件的内容
	-x：解开tar文件
tar -cvf a.tar a.txt	将一个a.txt的文件 打包成 一个 a.tar 的文件
tar -cvf b.tar b/		将一个b/的文件夹 打包成 一个 a.tar 的文件
tar -zcvf b.tar b/		将一个b/的文件夹，打包压缩成一个压缩文件
tar -zxvf bbb.tar.gz 	解压bbb.tar.gz文件

tar -zxvf bbb.tar.gz -C ./cc	解压bbb.tar.gz文件，到当前目录下的./cc目录

find / -name "ins*"	查找文件以ins开头的文件

grep odd* anaconda-ks.cfg 查找文件中什么开头的文件
grep odd* anaconda-ks.cfg --color 查找文件中什么开头的文件，但是以高亮显示
grep odd* anaconda-ks.cfg --color -A 查找文件中什么开头的文件，但是以高亮显示，同时将下一行也显示

touch a.txt 创建一个文件

clear 清屏	Ctrl+l 

cat a.txt > aa.txt	读取a.txt文件，重定向到aa.txt，会自动的创建文件
如果执行两次，是覆盖
ifconfig >> aa.txt	将输出结果，覆盖到文件里面
'>     >>
一个是覆盖，两个是追加

ps -ef 查看所有正在运行的进程
kill -9 进程ID

管道：作用：将一个命令的输出，用作另一个命令的输入
ls --help | more 分页查看帮助



vim编辑器
1，命令行模式
2，插入模式
3，底行模式






## Linux 文件权限系统

分四个地方，当前用户的权限，当前组内用户的权限，其他组用户的权限
-rw-r--r--
drwxr-xr-x.
	1，-开头，代表是个文件；d开头，代表是个文件夹；l 开头，代表是个链接快捷方式等
	2，r 读，w 写，x 执行
chmod u=rwx, g=r, o=rx a.txt 
chmod u=rwx,g=r a.txt
chmod 755 a.txt



vim a.txt	进入命令行模式的a.txt文件
按下i进入插入模式，可以进入输入数据
然后按下esc退出插入模式，进入命令行模式
按下shift+:;，会输入:
然后按下wq，确认写入完成，并且退出，回到进入前的界面

vim a.txt	进入命令行模式的a.txt文件
按下i进入插入模式，可以进入输入数据
然后按下esc退出插入模式，进入命令行模式
按下shift+:;，会输入:
然后按下q!，不保存退出 

i	在当前位置插入
I	在当前行首插入
a	在当前位置后插入
A	在当前行尾插入
o	在当前行之后插入一行
O	在当前行之前插入一行

vim cc.txt 可以创建一个不存在的文件，并且写入

输入冒号。:/8080，可以查找当前打开的文件的，关于8080 的信息



##  Linux 网络操作命令

1，hostname	查看本地主机名称
	也可以修改，hostname fff
	但是仅仅只是临时修改，重启后无效，
	如果想要永久生效，需要修改配置文件
	/etc/sysconfig/network
2，ip地址的配置修改
	ifconfig eth0 192.168.80.129 修改ip	临时修改
	如果想要永久生效
	修改 /etc/sysconfig/network-scripts/ifcfg-eth0文件
3，域名的映射
	vim /etc/hosts	修改这个文件，添加一个映射地址
	service network status	查看指定服务的状态
	service network stop	停止指定服务
	service network start	启动指定服务
	service network restart	重启指定服务
	

	service --status-all	查看系统中所有后台服务
	netstat -nltp
	
	防火墙设置：根据配置文件 /etc/sysconfig/iptables	来控制本机的，出，入的网络访问行为
	service iptables status	查看防火墙的状态
	service iptables stop	关闭防火墙
	service iptables start	启动防火墙
	chkconfig iptables off	禁止防火墙自启

切换root用户	su  -
输入密码 123456

## Linux 安装软件

1，二进制发布包，软件针对具体平台编译发布，解压修改配置即可

​	yum -y install lrzsz

2，RPM包，软件按照redhat红帽，包管理工具规范RPM进行打包，需要获取到相应的软件RPM
	发布包，然后用RPM命令进行安装、
3，YUM在线安装
	软件已经按照RPM规范打包，但是发布在网络上的一些服务器上，可用yum在线安装服务器上的
	rpm软件，并且会自动解决软件安装过程中的库依赖问题
4，源码编译安装
	软件以源码工程的形式发布，需要获取到源码工程后，用相应的开发工具进行编译打包部署、	

5，查看CentOS的软件版本
	getconf LONG_BIT 查看软件版本

## 安装JDK

​	java -version 查看jdk的版本
​	rpm -qa | grep java	查看jdk的信息
​	rpm	-e --nodeps ******	卸载jdk
​	rpm -e --nodeps java-1.7.0-openjdk-1.7.0.45-2.4.3.3.el6.x86_64，卸载三个

	带gz解压
	tar -zxvf jdk-8u65-linux-x64.tar.gz 	解压jdk
	不带gz解压
	tar -xvf jdk-8u65-linux-x64.tar.gz 	解压jdk
	
	配置环境变量
	vim /etc/profile
	
	export JAVA_HOME=/usr/local/java/jdk1.8.0_65
	export JRE_HOME=/usr/local/java/jdk1.8.0_65/jre
	export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA HOME/jre/lib


​	
​	#set java environment
​	JAVA_HOME=/usr/local/ide/jdk1.8.0_65
​	CLASSPATH=.:$JAVA_HOME/lib.tools.jar
​	PATH=$JAVA_HOME/bin:$PATH
​	export JAVA_HOME CLASSPATH PATH


	source /etc/profile	重新加载文件
	
	java -version				查看jdk版本
	java version "1.8.0_65"
	Java(TM) SE Runtime Environment (build 1.8.0_65-b17)
	Java HotSpot(TM) 64-Bit Server VM (build 25.65-b01, mixed mode)

## 安装mysql 
​	查看自带的mysql，然后卸载。
​	

	解开文件
	
	获得多个rpm文件，注意client客户端，和server服务端
	安装 rpm 文件
	rpm -ivh MySQL-server-5.6.25-1.el6.x86_64.rpm
	rpm -ivh MySQL-client-5.6.25-1.el6.x86_64.rpm
	
	A RANDOM PASSWORD HAS BEEN SET FOR THE MySQL root USER !
	You will find that password in '/root/.mysql_secret'.
	一个随机的密码，对root用户已经生成，在这个目录下
	cat /root/.mysql_secret
	# The random password set for the root user at Wed Oct 30 23:12:28 2019 (local time): 6_KQmiYpTfUA9CmE	868tvv_XCn1NawzK
	
	启动mysql
	service mysql start 
	
	登录
	 mysql -uroot -p868tvv_XCn1NawzK
	
	设置密码
	处于
	set password = password('123');
	show databases;
	exit
	
	关于mysql远程访问的权限
	在登录mysql的情况下，给root用户所有的权限，密码123，账号是root
	grant all privileges on *.* to 'root' @'%' identified by '123'
	
	flush privileges;	刷新
	
	关闭防火墙
	防火墙打开3306端口


​	

	## 
	
	ubuntu
	cd /etc/mysql/mysql.conf.d/
	vi mysqld.cnf 
	z注释bind
	mysql -u root -p
	123456
	grant all privileges on *.* to 'root'@'%' identified by '123456';
	123456是你的密码


​	
​	


## 安装tomcat

​	上传tomcat
​	解压
​	启动startup.sh
​	要关防火墙，
​	防火墙设置：根据配置文件 /etc/sysconfig/iptables	来控制本机的，出，入的网络访问行为
​	service iptables status	查看防火墙的状态
​	service iptables stop	关闭防火墙
​	service iptables start	启动防火墙
​	chkconfig iptables off	禁止防火墙自启

	访问 http://192.168.80.129:8080/，对应ip的8080默认端口

## 安装radis

​	先安装中个编辑器
​	yum install gcc-c++
​	

	$ wget http://download.redis.io/releases/redis-2.8.9.tar.gz
	$ tar -zxvf redis-2.8.9.tar.gz
	$ cd redis-2.8.9
	$ make
	安装完成后，处于安装目录下，执行下一句命令
	make[1]: Leaving directory `/usr/local/redis/redis-2.8.9/src'
	执行安装的方法，在创建的ide/redis目录下，安装
	[root@fff redis-2.8.9]# make PREFIX=/usr/local/ide/redis install


/*	自动执行的代码
	cd src && make install
	make[1]: Entering directory `/usr/local/redis/redis-2.8.9/src'
	Hint: To run 'make test' is a good idea ;)
    INSTALL install
    INSTALL install
    INSTALL install
    INSTALL install
    INSTALL install
	make[1]: Leaving directory `/usr/local/redis/redis-2.8.9/src'
*/	自动执行的代码
	
	从下载完成的目录，复制配置文件到达，bin目录
	cp redis.conf /usr/local/ide/redis/bin/
	
	查看是否在后台运行
	ps aux | grep redis
	关闭
	redis-cli -p 8080 shutdown 
	
	Redis 2.8.9 (00000000/0) 64 bit                             
 	Running in stand alone mode
	Port: 6379
	PID: 4879

	./redis-server redis.conf 
	pkill redis  //停止redis
	./redis-cli 




Nginx：静态代理，反向代理，负载均衡

## Nginx安装



先是gcc的安装环境
安装pcre，是一个Perl库，Nginx的HTTP模块使用pcre来解析正则表达式
pcre-devel 是使用pcre开发的二次开发库，所以也需要安装
yum install -y pcre pcre-devel

zlib
zlib库提供了很多种压缩和解压缩的方式，Nginx使用zlib对HTTP包的内容进行gzip
yum install -y zlib zlib-devel

openssl
openssl时一个强大的安全套接字层密码库，囊括了主要的密码算法，常用的秘钥和证书
封装管理功能及SSL协议，并提供丰富的应用程序供测试或其他目的使用，
Nginx不仅支持HTTP协议，还支持HTTPS（仅在ssl协议上传输HTTP），
所以要在linux上安装OpenSSL
yum install -y openssl spenssl-devel

进去Nginx的解压目录，复制粘贴以下指令，并且自动执行
./configure \
--prefix=/usr/local/nginx \
--pid-path=/var/run/nginx/nginx.pid \
--lock-path=/var/lock/nginx.lock \
--error-log-path=/var/log/nginx/error.log \
--http-log-path=/var/log/nginx/access.log \
--with-http_gzip_static_module \
--http-client-body-temp-path=/var/temp/nginx/client \
--http-proxy-temp-path=/var/temp/nginx/proxy \
--http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
--http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
--http-scgi-temp-path=/var/temp/nginx/scgi

然后会生成一个Makefile文件，
有这个文件后，在当前目录，执行make命令

然后 make install，执行安装命令

然后创建临时文件 mkdir /val/temp/nginx/client -p

然后直接访问浏览器、80端口

然后设置conf里面的Nginx.xml文件。
location / {
            root   index;
            index  index.html index.htm;
        }
并且复制一个index文件夹到nginx目录，，也就是和sbin同等级目录。


## Nginx 的使用
nginx -s stop	强行停止
nginx -s quit	优雅的停止
nginx -s reload	重新启动Nginx

## Nginx 热部署
1，先备份旧版本的启动文件  
mv /usr/local/nginx/sbin/nginx  /usr/local/nginx/sbin/nginx.old 

2，重新下载编译最新版本的Nginx，并且放在原来Nginx的目录下 

3， ps -ef | grep nginx 查看Nginx状态   
root      1752     1  0 20:39 ?        00:00:00 nginx: master process ./sbin/nginx   
nobody    1783  1752  0 20:41 ?        00:00:00 nginx: worker process   
root      1787     1  0 20:41 ?        00:00:00 wget http://nginx.org/download/nginx-1.17.2.tar.gz   
root      4357  1708  0 21:00 pts/2    00:00:00 grep --color=auto nginx

4，获得 nginx PID 为 1752，给正在运行的 nginx 的 master 进程发送信号，告诉它我们要进行热部署了。   
发送 USR2 信号给旧版本主进程号,使 nginx 的旧版本停止接收请求，用 nginx 新版本接替   
```java
	kill -USR2 1752
```
5，ps -ef | grep nginx    
root      1752     1  0 20:39 ?        00:00:00 nginx: master process ./sbin/nginx   
nobody    1783  1752  0 20:41 ?        00:00:00 nginx: worker process   
root      1787     1  0 20:41 ?        00:00:00 wget http://nginx.org/download/nginx-1.17.2.tar.gz   
root      4391  1752  0 21:02 ?        00:00:00 nginx: master process ./sbin/nginx   
nobody    4392  4391  0 21:02 ?        00:00:00 nginx: worker process   
root      4394  1708  0 21:07 pts/2    00:00:00 grep --color=auto nginx

6，这个时候我们需要给老的 nginx 发送信号，告诉老的 nginx 请优雅的关闭所有的 worker 进程。   
发送 WINCH 信号到旧的主进程，它会通知旧的 worker 进程优雅的关闭，然后退出
```java
	kill -WINCH 1752
```
7，ps -ef | grep nginx    
root      1752     1  0 20:39 ?        00:00:00 nginx: master process ./sbin/nginx   
root      1787     1  0 20:41 ?        00:00:00 wget http://nginx.org/download/nginx-1.17.2.tar.gz   
root      4391  1752  0 21:02 ?        00:00:00 nginx: master process ./sbin/nginx   
nobody    4392  4391  0 21:02 ?        00:00:00 nginx: worker process   
root      4402  1708  0 21:08 pts/2    00:00:00 grep --color=auto nginx   
也可以发现老的 nginx maser 进程还存在，它的意义是：如果存在问题，需要退回到老版本中，我们可以给它发送 reload 命令，让他重新把 worker 进程拉起来、把新版本关掉。保留在这里方便我们做版本回退。

如果要退出保留的 master 进程，可以通过 kill -QUIT 命令来完成:   
发送 QUIT 信号到旧的主进程，它会退出保留的 master 进程
kill -QUIT 1752

8，执行完后，1752 进程退出，通过 netstat lntup 可以看到 80 端口已经被 4391 进程监听了（新版本 nginx 的进程）。

到此为止，我们就完成了 nginx 的热部署。

日志切割   
https://segmentfault.com/a/1190000020885852



# redis集群 以及 Redis高级开发

1，保存redis.conf文件

2，redis.conf文件解读

​		units are case insensitive so 1GB 1Gb 1gB are all the same.

​		include，可以将配置文件拆分

​		GENERAL，

​				daemonize no，设置是否后台运行

​				pidfile /var/run/redis.pid，当你运行起来后，这里会有一个文件，存放pid

​				port 6379

​				timeout 0

​				tcp-keepalive 60 保持联系

​				log-level  notice 日志级别 debug开发测试阶段使用，werbose，notice，warning上生产以后，级别越高，报错越少

​				logfile 日志的名字

​				syslog-enabled no 是否把日志放到系统日志里面

​				syslog-ident Redis	指定系统日志里面的标识

​				syslog-facility user或者local0-local7 				

​				databases 16 默认支持16个数据库

​		SNAPSHOTTING	快照

​		reqlication 复制

​		security 安全

​		limits 限制

​				maxclients

​				maxmemory <bytes> 内存、缓存过期策略，最大内存的策略，有五种选择策略

​						lru = less res use 最近最少使用的

​						volatile-lru 使用LRU算法移除key，只对设置了过期时间的键

​						allkeys-lru 使用LRU算法移库key

​						volatile-random 在过期集合中移除随机的key，只对设置了过期时间的键
​						allkeys-random 移除随机的key
​						volatile-ttl 移除那些TTL值最小的key，即那些快要过期的key
​						noeviction 永不过期的策略

​				maxmemory-policy 默认永不过期

​				maxmemory-samples 设置样本的数量，LRU算法和最小TTL算法都不是精确算法，而是估算值算法，所以你可以设置样本的大小

​				Redis默认会检查这么多个key，并选择其中LRU的那个

## Redis配置说明

1，Redis默认不是以守护进程的方式运行的，可以通过该配置项修改，使用yes启动守护进程，daemonize no

2，当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定，pidfile /var/run/redis.pid

3，指定Redis监听端口，默认为6379，

4，绑定的主机地址 bind 127.0.0.1

5，当客户端限制多长时间后关闭连接，如果指定为0，表示关闭该功能，timeout 300

6，指定日志记录级别，Redis总共四个级别debug，verbose，notice，warning，

7，日志记录的方式，默认为标准输出，如果配置为Redis为守护进程，这里又配置为标准输出，则日志会发送给/dev/null

logfile stdout

8，设置数据库的数量，默认数据库为0，可以使用select<dbid>命令在连接上指定数据库id

databases 16

9，指定在多长时间内，有多少次更新操作，就将数据同步到本地，可以多个条件配合

save <seconds>  <changes>	

10，指定存储至本地数据库时，是否压缩数据，默认yes，Redis采用LZF压缩，如果为了节省CPU时间，可以关闭该选项，但会导致数据库文件变得巨大

rdbcompressioon yes

11，指定本地数据库文件名，默认值为dump.rdb

dbfilename dump.rdb

12，指定本地数据库存放目录

dir ./

13，设置当本机为slav服务时，设置master服务的ip地址及端口，在Redis启动时，它会自动从mater进行数据同步

slaveof <masterip> <masterport>

14，当master服务设置了密码保护时，slave服务连接master的密码

masterauth <master-password>

15，设置Redis连接密码，如果配置了连接密码，客户端在连接Redis时需要通过auth <password> 命令，提供密码，默认是关闭的

requirepass foobared

16，设置同一时间最大客户端连接数，默认无限，Redis可以同时打开的客户端连接数为，Redis进程可以打开的最大文件描述符数，如果设置maxclient 0，表示不作限制。当客户端连接数到达限制时，Redis会关闭新的连接，并向客户端返回max number of clients reached 错误信息

maxclients 128

17，指定Redis最大内存限制，Redis在启动时会把数据加载到内存，达到最大内存后，Redis会先尝试清除已到期或即将到期的key，当此方法加载后，仍然到达最大内存设置，将无法再进行写入操作，但仍然可以进行写入操作，但仍然可以进行读取操作。

Redis新的vm机制，会把key存放到内存，value存放在swap区

maxmemory <bytes>

18，指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能会在断电时导致一段时间内的数据丢失，因为Redis本身同步数据文件是按照上面的save条件来同步的，所以有的数据会在一段时间内会存在于内存中，默认为no

19，指定更新日志文件名称，默认为appendonly.aof

appendfilename appendonly.aof

20，指定更新日志条件，共有3个可选值

no 表示等操作系统进行数据缓存同步到磁盘，快速

always 表示每次更新操作后，手动调用fsync()将数据写到磁盘，慢，但是安全

everysec，表示每秒同步一次，折中，默认值

sppendfsync everysec

21，指定是否启用虚拟内存机制，默认为no，

VM机制将数据分页存放，由Redis将访问量较少的页，即冷数据swap到磁盘上去，访问多的页面由磁盘自动换出到内存。（后续会讲解，Redis的VM机制）

vm-enabled no

22，虚拟内存文件路径，默认值为/tmp/ redis.swap,不可多个 Redis实例共享 

vm-swap-file /tmp/redis swap  

23，将所有大于vm-max- memory的数 据存入虚拟内存，无论 vm-max-memory 设置多小，所有索引数据都是内存存储 的( Redis的索引数据就是keys),也就是 说当 vm-max-memory设置为0的时候其实 是所有vaue都存在于磁盘。默认值为0 

vm-max-memory 0 

24，Redis swap文件分成了很多的 page,一个对象可以保存在多个page上 面,但一个page上不能被多个对象共享, vm-page-size是要根据存储的数据大小 来设定 作者建议如果存储很多小对象，page大 小最好设置为32域者64 bytes；如果存 储很大大对象,则可以使用更大的page，如果不确定,就使用默认值

vm-page-size 32

25，设置swap文件中的page数量,由于 页表(一种表示页面空闲或使用的 bmap)是在放在内存中的,,在磁盘上每8 个 pages将消耗1byte的内存 

 vm-pages 134217728 

26，设置访问swap文件的线程数最好不要超过机器的核数如果设置为0,那么所有对swap文件的操作都是串行的,可能会造成比较长时间的延迟。默认值为4

vm-max-threads 4

27，设置在向客户端应答时,是否把较小的包合并为一个包发送,默认为开启

glueoutputbuf yes

28，指定在超过一定的数量或者最大的元素超过某一临界值时,采用一种特殊的哈希算法

hash-max-zipmap-entries 64

hash-max-zipmap-value 512

29，指定是否激活重置哈希,默认为开启(后面在介绍 Redis的哈希算法时具体介绍)

activerehashing yes

30，指定包含其它的配置文件,可以在同一主机上多个Reds实例之间使用同一份配置文件,而同时各个实例又拥有自己的特定配置文件

include/path/tolocal conf

## Redis 的过期策略

```
定期删除
redis每隔100ms就会|随机|抽取一些设置了过期时间的key，检查其是否过期，如果过期了就删除
为了预防缓存雪崩，缓存雪崩是大面积缓存消失，请求直接访问服务器

```



```
惰性删除
当你获取key的时候，如果这个key删除了过期时间，获取的时候已经过期，那么就将这个key删除，不会返回。


```



```
内存淘汰机制
当定期删除漏掉了很多过期key，同时也没有去查找这些过期的key，没走惰性删除，那么久开始走内存淘汰机制

noeviction：当内存不足以容纳新写入的数据时，新写入的操作会报错
allkeys-lru：当内存不足以容纳新写入的数据时，在键空间中，删除最近最少使用的key（最常用的）
allkeys-random：当内存不足以容纳新写入的数据时，在键空间中，随机移除某个key，
volatile-lru：当内存不足以容纳新写入的数据时，在设置了过期时间的键空间中，移除最小使用的key
volatile-random：当内存不足以容纳新写入的数据时，在设置了过期时间的键空间中，随机移除某个key
volatile-ttl：当内存不足以容纳新写入的数据时，在设置了过期时间的键空间中，有更早过期时间的key


```



## Redis 的持久化——RDB

RDB：

```
在指定的时间间隔内将内存中的数据集快照写入磁盘
也就是行话讲的 Snapsho快照，它恢复时是将快照文件直接读到内存里

Redis会单独创建(fork)，一个子进程来进行持久化，会先将数据写入到一个临时文件中，待持久化过程都结束了，再用这个临时文件替换上次持久化好的文件

整个过程中,主进程是不进行任何IO操作的,这就确保了极高的性能

如果需要进行大规模数据的恢复,且对于数据恢复的完整性不是非常敏感，那RDB方式要比AOF方式更加的高效。

缺点：是最后一次持久化后的数据可能丢失
```

```
fork

Foκk的作用是复制一个与当前进程一样的进程。新进程的所有数据(变量、环境变量、程序计数器等)，数值都和原进程一致，但是是一个全新的进程，并作为原进程的子进程
```

```
rdb保存到本地的是 dump.rdb文件
```



snapshotting快照

```
Redis 启动
./redis-server /redis/redis.conf
./redis-cli -p 6379

触发rdb快照的，的三种方式
1，根据配置文件的要求，修改到了次数，就会保存
2，执行save命令，立刻保存
	bgsave:redis会在后台异步的进行快照操作，
	快照同时还可以响应客户端的请求，可以通过lastsave命令获取最后一次成功执行快照的时间
3，执行flushall，立刻保存，但是是空的
4，
```

```
stop-writes-on-bgsave-error 默认yes
默认，出错就刹车

如果配置成no，表示不在乎数据不一致，或者有其他手段发现和控制

```

```
rdbcompression yes
默认开启 LZF 压缩算法，节省CPU的损耗。。对于存储到磁盘的快照，可以设置是否进行压缩，
如果是，Redis会采用LZF算法
如果不想使用，设置成no
```

```
rdbcheckcum
在存储快照后，可以让Redis会用CRC64算法来进行数据的校验，但是这样做会增加大约10%的性能消耗
如果希望获取到最大的性能提升，可以关闭此功能

```

```
dbfilename dump.rdb
dir 
```

```
如何停止快照功能
redis-cli config set save ""
```



```
优势
适合大规模的数据恢复
对数据的完整性和一致性要求不高

劣势
1，在一定时间间隔做一次备份，所以有机会丢失最后一次快照的修改
2，fork的时候，会保存在本地，会占用数据空间
```



## Redis 的持久化——AOF

```
插入的数据，每插入一次都会记录保存下来。

以日志的形式来记录每个写操作，将Redis执行过的所有写指令记录下来(读操作不记录)，
只许追加文件但不可以改写文件，redis启动之初会读取该文件重新构建数据，换言之，
redis重启的话就根据日志文件的内容将写指令从前到后执行一次以完成数据的恢复工作
```

```
AOF的保存：appendonly.aof
```

```
修改配置文件
复制一份redis.conf 为 redis_aof.conf
修改redis_aof.conf

设置参数 appendonly yes(默认是no)
设置参数 appendfilename "appendonly.aof"

redis-server /redis/redis_aof.conf
redis-cli -p 6379

备份被写坏的文件
Redis-check-aof --flx
```

AOF——Rewrite

```
AOF采用文件追加方式,文件会越来越大为避免出现此种情况,新增了重写机制,
当AOF文件的大小超过所设定的阈值时, Redis就会启动AOF文件的内容压缩,
只保留可以恢复数据的最小指令集,可以使用命令 bgrewriteaof
```

```
什么时候触发重写，触发原理

AOF过大时,会fork出一条新进程来将文件重写(也是先写临时文件最后再rename)
遍历新进程的内存中数据,每条记录有一条的set语句。重写aof文件的操作,并没有读取旧的aof文件,
而是将整个内存中的数据库内容用命令的方式重写了一个新的aof文件,这点和快照有点类似
```

```
触发机制

Redis会记录上次重写时的A0F大小,默认配置是当AOF文件大小是上次 rewrite后大小的一倍且文件大于64M时触发
配置文件中所写
appendfsync	everysec
auto-aof-rewrite-percentage 100	(100%)
auto-aof-rewrite-min-size 64mb

```

```
AOF简介
AOF文件是一个只进行追加的日志文件
Redis可以在AOF文件体积变得过大时,自动地在后台对AOF进行重写
AOF文件有序地保存了对数据库执行的所有写入操作,这些写入操作以Reds协议的格式保存,因此AOF文件的内容非常容易被人读懂,对文件进行分析也很轻松

对于相同的数据集来说,AOF文件的体积通常要大于RDB文件的体积
根据所使用的 fsync策略,AOF的速度可能会慢于RDB
```

```
官网建议：
如果你非常在意你的数据，但是希望你的数据能够快速的备份和恢复，但是对数据完整性较低的话，可以仅仅选择RDB

如果你比较在意你的数据，请选择AOF

如果你只做缓存，如果你希望你的数据仅仅在服务器运行的时候存在，你也可以不使用任何持久化方式

如果你同时开启了两个持久化方式，在这种情况下,当 redis重启的时候会优先载入AOF文件来恢复原始的数据,
因为在通常情况下AoF文件保存的数据集要比RDB文件保存的数据集要完整.

RDB的数据不实时,同时使用两者时服务器重启也只会找AOF文件。
那要不要只使用AOF呢?作者建议不要,因为RDB更适合用于备份数据库(AOF在不断变化不好备份),
快速重启,而且不会有AOF可能潜在的bug,留着作为一个万一的手段。

```

```
性能建议

因为RDB文件只用作后备用途,建议只在 Slave上持久化RDB文件,而且只要15分钟备份一次就够了,只保留save9001这条规则

如果 Enalbe aof,好处是在最恶劣情况下也只会丢失不超过两秒数据,启动脚本较简单只|oad自己的AOF文件就可以了。代价是带来了持续的IO,二是 AOF rewrite的最后将 rewrite过程中产生的新数据写到新文件造成的阻塞几乎是不可避免的。只要硬盘许可,应该尽量减少 AOF rewrite的频率,AOF重写的基础大小默认值64M太小了,可以设到5G以上。默认超过原大小100%大小时重写可以改到适当的数值

如果不 Enable aof,仅靠 Master- Slave Replication实现高可用性也可以。能省掉一大笔IO也减少了 rewrite时带来的系统波动。代价是如果 Master/ Slave同时倒掉,会丢失十几分钟的数据,启动脚本也要比较两个 Master/Save中的RDB文件,载入较新的那个。新浪徽博就选用了这种架构
```

## Redis事务

```
Redis事务是什么
可以一次执行多个命令,本质是一组命令的集合。
一个事务中的所有命令都序列化,按顺序地串行化执行执行而不会被其它命令插入,不许加塞
```

```
常用指令
discard		取消事务
exec		执行所有事务块的命令
multi		标记一个事务块的开始
unwatch		取消 watch 命令，对所有key的监视
watch key(key.....)	建议一个或者多个key，如果在事务执行之前，这个key被其他命令改动，那么事务就会被打断
```

```
正常执行
multi
set k1 k1
set k2 k2
get k2
set k3 k3
exec
```

```
放弃事务
multi
set k1 k1
set k2 k2
get k2
set k3 k3
discard
```

```
全体连坐
multi
set k1 k1
set k2 k2
getset k2
set k3 k3
exec
如果命令是直接报错，事务不会被执行
如果不能够加入队列，直接全部
```

```
冤有头债有主
multi
set k1 k1
incr k1 
set k2 k2
set k3 k3
exec
如果报错发生在事务处理器，则只有该语句不会被执行
如果可以加入队列，则只有错误的语句不会被执行
```

```
watch监控
1，unwatch可以取消监控
2，执行exce可以取消监控

如果执行watch后，有加塞篡改，则事务不会被执行


```

```
redis的事务的特性
单独的隔离操作:事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中,不会被其他客户端发送来的命令请求所打断

没有隔离级别的概念:队列中的命令没有提交之前都不会实际的被执行,因为事务提交前任何指令都不会被实际执行也就不存在”事务内的查询要看到事务里的更新,在事务外查询不能看到“这个让人万分头痛的问题

不保证原子性:redis同一个事务中如果有一条命令找行失败,其后命令仍然会被执行,没有回滚
```

## Redis发布 和 订阅	 **Pub/Sub** 

```
作用：进程间的消息通信模式，发送者发送消息，订阅者接收消息
```

```
命令
pusbcribe pattern [pattern.....]		订阅一个或者多个
pubsub subcommand [argument [argument]]	查看订阅发布系统过得状态
publish channel message					将信息发送到指定的频道
punsubscribe [pattern] [pattern]		退订所有给定模式的频道
subscribe channel [channel]				订阅给定的一个或者多个频道的信息
unsubscribe [channel [channel]]			指退订给定的频道
```

```
案例：
先订阅，才能够接收到信息
1，可以一次性订阅多个	：subscribe c1 c2 c3
2，消息发布		   ：publish c2 hello-redis
3，订阅多个，通配符	：psubscribe new*
4，收取信息		   ：publish new1 redis

1和2，是订阅单个多个，只要有任何消息发布，都会立刻受到消息
3和4，是订阅单个多个，但是使用了通配符，只要是这个开头的，都会那啥


缺点：在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如RocketMQ等
```

## redis Geo——redis3.2以后

```
支持存储地理位置信息用来实现诸如附近位置，geo的数据类型为zset

geoadd cityGeo 116.405285 39.904989 "北京"
geoadd cityGeo 121.472644 31.231706 "上海"

geopos cityGeo 北京
1) "116.40528291463851929"
2) "39.9049884229125027"
   
geodist cityGeo 北京 上海
"1067597.9668"
geodist cityGeo 北京 上海 km
"1067.5980"

georadius cityGeo 116.405285 39.904989 100 km WITHDIST WITHCOORD ASC COUNT 5
根据给定的经纬度，返回半径不超过指定距离的元素
可以指定WITHDIST返回距离，WITHCOORD返回经纬度，WITHHASH返回geohash值
可以指定ASC或DESC，根据距离来排序
可以指定COUNT限定返回的记录数

georadiusbymember cityGeo 北京 100 km WITHDIST WITHCOORD ASC COUNT 5
根据指定的地点查询半径在指定范围内的位置
可以指定WITHDIST返回距离，WITHCOORD返回经纬度，WITHHASH返回geohash值
可以指定ASC或DESC，根据距离来排序
可以指定COUNT限定返回的记录数

geohash cityGeo 北京
"wx4g0b7xrt0"
```

## redis Redisearch 全文检索

```
https://www.jianshu.com/p/458319b4e47e
```



## redis 主从复制

```
作用：
主机数据更新后，根据配置和策略，自动同步到备机的master/slaver机制，master以写为主，slaver以读为主
```

```
功能：读写分离，容灾恢复
```

```
如何使用：
1，配从库，不配主库：只在从机配置，不管主机
2，从库配置，slaveof主库，主库端口：在从机上配置主机的ip和端口
	每次和master断开后，都需要重新连接，重新执行从机的配置命令，除非你配置进redis.conf文件
	
3，修改配置文件细节处理
	如何操作：
	1，关闭服务器的防火墙
    1，拷贝多个redis.conf文件
    2，开启daemonize yes
    3，pid文件名字
    4，指定端口
    5，log文件名字
    6，dump.rdb名字
4，多个服务器，多个IP多个端口
	bind：设置在bind指定的IP地址的计算机才可以访问这个Redis服务器。0.0.0.0允许所有的IP访问
	

4，常用三招，一主二仆，薪火相传，反客为主
	
一主二仆
	init：启动服务
	./redis-cli
	./redis-cli -h 192.168.80.220 -p 6380
	./redis-cli -h 192.168.80.221 -p 6381
	
	127.0.0.1:6379> info replication
    # Replication
    role:master
    connected_slaves:0
    master_repl_offset:0
    repl_backlog_active:0
    repl_backlog_size:1048576
    repl_backlog_first_byte_offset:0
    repl_backlog_histlen:0
    三台都是master对象，
    
	一个master，两个slave：
	连接前必须打开对应的端口，主的和父的都要打开
	/sbin/iptables -I INPUT -p tcp --dport 6379

	SLAVEOF 127.0.0.1 6379
	SLAVEOF no one
	日志查看：
	主从问题演示：

薪火相传
	上一个Slave可以是下一个slave的Master, Slave同样可以接收其他slaves的连接和同步请求，那么该slave作为了链条中下一个的master,可以有效减轻master的写压力中途变更转向，会清除之前的数据，重新建立拷贝最新的Slaveof新主库IP新主库端口
	master-->slave-->slave

反客为主
	slaveof no one 
	
	
	sentinel monitor sentinel1 192.168.80.130 6379 1


```

## redis 复制的原理

```
Slave启动成功连接到master后会发送一个sync命令

Master接到命令启动后台的存盘进程，同时收集所有接收到的用于修改数据集命令，
在后台进程执行完毕之后，master将传送整个数据文件到slave,以完成一次完全同步

全量复制:而slave服务在接收到数据库文件数据后，将其存盘并加载到内存中。

增量复制:Master继续将新的所有收集到的修改命令依次传给slave，完成同步

但是只要是重新连接master，一次完全同步(全量复制)将被自动执行

```

## redis的哨兵模式 sentinel

```
反客为主的自动版，能够后台监控主机是查故障，如果故障了根据投票数，自动将从库转换为主库

1，调整结构，6379带着80、81
2，自定义的/redis目录下新建sentinel.conf文件， 名字绝不能错

4，配置哨兵,填写内容
	sentinel monitor（自己起名字) 127.0.0.1 6379 1
	上面最后一个数字1，表示主机挂掉后salve投票看让谁接替成为主机，得票数多少后成为主机
	
启动哨兵。

正常主从演示
原有的master挂了
投票新选置
重新主从继续开工,info replication查查看圓

问题:如果之前的master重启回来， 会不会双master冲突?国

sentinel monitor sentinel1  192.168.80.130 6379 1

sentinel down-after-milliseconds sentinel1 30000

sentinel parallel-syncs sentinel1 1

sentinel failover-timeout sentinel1 180000




一组 sentinel 能同时监控多个Master
```



```

```



## 吊打面试官系列  https://segmentfault.com/a/1190000020937483 

## redis，memcache，MongoDB的区别

```
redis，memcache，MongoDB的区别
1，性能上
redis和memcache差不多，MongoDB性能低于其余两个

2，操作的便利性
MongoDB类似关系型数据库，redis和memcache类似，操作简便

3，容灾可靠性
redis支持rdb和AOF，
memcache不支持
MongoDB1.8后支持

4，事务支持
redis支持的事务是伪事务
memcache支持乐观锁事务
MongoDB不支持事务
```

## redis 缓存雪崩

```
缓存雪崩
当缓存全部失效，所有的请求都去直接访问数据库，数据库因为请求太多，直接宕机，这就是缓存雪崩
同一时间，设置过期时间的缓存几乎全部失效，在一瞬间redis和没有一样，过大数量的请求直接打在服务器上，

如何解决缓存雪崩呢？
非集群：
对过期时间设置随机值，1-10000，可以保证不会再同一时间大面积失效

集群：
集群部署，可以将热点数据均匀分布在不同的redis服务器中，也可以避免全部失效的问题
也可以设置一些热点数据永远都不过期

```

## redis 缓存击穿 和 缓存穿透

```
缓存击穿
单个热点数据，被高并发不停的访问，持续的大并发穿透缓存，直接请求服务器，在缓存上凿开了一个洞。


缓存穿透
用户请求数据库中不存在的数据，例如-1，或者过大的数字
用户可能是攻击者，导致数据库压力过大，压垮数据库
解决办法：
对参数ID进行校验，小于1的数据不允许进入

```

## redis 缓存雪崩 缓存击穿 缓存穿透 如何解决 

```
事前：主从同步，读写分离，哨兵，

事情发生时：Hystrix 限流+降级，每秒只有多少人可以通过

事后：RDB，AOF
```



```
1，当同一时间有大量的key同时消失的时候，需要注意什么
当同一时间有大量key消失，那么就会有大量的请求到达数据库，就会造成缓存的雪崩

2，redis分布式锁
setnx争抢锁，expire给锁加过期时间，

3，假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如何将它们全部找出来？
redis是单线程的，所以keys指令的操作会卡顿一段时间，可以使用过scan，scan可以无阻塞的提取出文件
 keys ab*
 scan 0 match ab* count 5
 
 4，使用redis的list用作消息队列，rpush生产消息，lpop消费消息，当lpop没有消息的时候，进行sleep一会后再试，
 
 5，
 
```



## 两个redis集群，如何进行数据的复制

```
使用 rdb，和 AOF
```

## 缓存-数据库读写模式

```
读的时候先读缓存，缓存中没有的话，读取数据库，返回的时候添加缓存，同时给前端返回数据

写的时候，先改数据库，然后删除缓存
```

# docker

```
简介
Docker是-一个开源的应用容器引擎;
Docker支持将软件编译成一个镜像;然后在镜像中各种软件做好配置,将镜像发布出去,其他使用者可以直接使
用这个镜像;
运行中的这个镜像称为容器,容器启动是非常快速的。
```

```
docker主机(Host) :安装了Docker程序的机器( Docker直接安装在操作系统之上) ;
docker客户端(Clent) :连接docker主机进行操作;
docker仓库(Registry) :用来保存各种打包好的软件镜像;
docker镜像(lmages) :软件打包好的镜像;放在docker仓库中;
docker容器(Container) :镜像启动后的实例称为-一个容器;容器是独立运行的一一个或- -组应用

使用Docker的步骤:
1 ).安装Docker
2)。去Docker仓库找到这个软件对应的镜像;
3).使用Docker运行这个镜像,这个损像就会生成一个Docker容器 ;
4)、对容器的启动停止就是对软件的启动

```

```
安装docker
1，检查内核版本。必须是3.10及以上
	uname -r
2，安装docker
	yum install docker
3，输入y确认安装
4，启动docker
	[root@localhost ~]# systenctl start docker
	[root@localhost ~]# docker -V
	Docker version 1.12.6, bulld 3e8e77d/1.12.6
5，开机启动docker
	[root@localhost ~]# systenct1 enable docker
	Created synlink from /etc/systemd/system/multi-user . target 			.wants/docker.service to
	/usr/1ib/systend/system/docker . service.
6，停止docker
	systemctl stop docker
7，重启docker
	systemctl restart docker
8，刷新镜像路径
	systemctl daemon-reload
9，从仓库查找镜像
	docker search mysql
10，从仓库拉取镜像
	docker pull mysql:5.5	拉取指定版本
	docker pull mysql		拉取最新版本
11，获取本地所有的镜像
	docker images
12，删除指定的本地镜像
	docker rmi imageid
```

```
1，首先安装高内核版本的centos7.5以上
https://opsx.alibaba.com/mirror?lang=zh-CN
https://www.cnblogs.com/asheng2016/p/install-centos75.html

2，正式开始docker的入门
首先安装docker：yum install docker
启动docker：systenctl start docker
设置开机启动：systenct1 enable docker
修改该路径的文件为vi /etc/docker/daemon.json 
{
"registry-mirrors": ["https://d7meol8c.mirror.aliyuncs.com"]
}

"registry-mirrors":
        [
             "https://d7meol8c.mirror.aliyuncs.com"
        ]

刷新该docker文件：systemctl daemon-reload
重启docker：systemctl restart docker
拉取镜像：docker search mysql
查看镜像：docker images


```

```
容器操作

软件镜像，运行镜像，产生一个容器（正在运行的软件）
service firewalld status

1、搜索镜像
	docker search tomcat
2.控取镜像
	docker pull tomcat
3.根据镜像启动容器
	docker run --nane mytomcat -d tomcat:latest
	--nane 自定义容器名称
4、查看运行中的容器
	docker ps
5、停止运行中的容器
	docker stop 容器的id
6、查看所有的容器
	docker PS -a
7、启动容器
	docker start 容器id
8、删除一个容器
	docker rm 容器id
9.启动一个做了端口映射的tomcat
	docker run -d --name tomcat1  -p 8889:8080 50d274ef4fb3
	docker run -d -p 8889:8080 tomcat --name tomcat2
	docker run -d -p 8888:8080 tomcat --name tomcat1
	-d:后台运行
	-p:将主机的端口映射到容器的一一个端口主机端口:容器内部的端口
10.为了演示简单关闭了linux的防火墙
    service firewalld status ;查看防火墙状态
    service firewalld stop: 关闭防火墙
11.查看容器的日志
	docker logs container-nane/container-id
更多命令参看
https://docs.docker.com/ engine/reference/commandline/docker/

```

```
使用mysql
docker run --name mysql1 -d d404d78aa797	无法使用
docker logs 91e22796ea6e
error: database is uninitialized and password option is not specified 
  You need to specify one of MYSQL_ROOT_PASSWORD, MYSQL_ALLOW_EMPTY_PASSWORD and MYSQL_RANDOM_ROOT_PASSWORD
三个参数必须指定一个

docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
docker run --name mysql01 -e MYSQL_ROOT_PASSWORD=123456 -d d404d78aa797
开启端口映射
docker run -p 3307:3306 --name mysql01 -e MYSQL_ROOT_PASSWORD=123456 -d d404d78aa797

docker run --name mysq103 -V /conf/mysq1:/etc/mysq1/conf.d -e YSQL_ ROOT PASSHORD-my-secret-pw
-d mysql:tag
把主机的/my/custom文件夹挂载到mysqldocker春器的/etc/mysql/conf . d文件夹里面
改aysq1的配置文件就只需要把nysq1配置文件放在
docker run --name some-mysql -e MYSQL ROOT PASSWORD-ay-secret-pl -d mysql:tag 上-
character-set-
server-utf8nb4 --collation-server-utf8mb4. _unicode. ci
指定aysq1的一些参数



使用tomcat
docker run -d --name tomcat1  -p 8889:8080 50d274ef4fb3


```

```
Ubuntu下的docker

curl http://www.baidu.com
获得页面的所有数据，html页面

脚本自动安装
curl -fsSL get.docker.com -o get-docker.sh 
sh get-docker.sh --mirror Aliyun

docker version 

进入tomcat里面
docker run -it \ 
tomcat \ 
bash 

先启动容器，然后再进入启动的容器里面
docker
	run 运行容器
		-it 以交互的形式运行容器
		--rm 退出容器之前将其删除（不删除的挂会在后台，删除退出的时候就会退出后台）（也就是删除容器，注意，不是删除镜像）
		

```

```
docker fiel 定制镜像


```

## docker 配置 mysql 主从复制

```
主节点需要启动一个logdump线程，用来将binlog文件传给从节点的io线程
从节点需要启动两个线程，IO线程和sql线程 ，IO线程去请求主库的binlog文件，将得到的binlog写入relaylog文件，
	sql线程去执行relaylog文件
3307.主
3308.从


通过docker exec -it 627a2368c865 /bin/bash命令进入到Master容器内部，也可以通过docker exec -it mysql-master /bin/bash命令进入。627a2368c865是容器的id,而mysql-master是容器的名称。
mysql -uroot -p123456	进入mysql

1，主服务器配置


2，从服务器配置

```



## springboot 与 jdbc 数据访问

```
JDBC

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = SpringdataJdbcApplication.class)
public class SpringdataJdbcApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        String sql = "select * from userinfo";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("userInfoId"));
            System.out.println(resultSet.getString("userName"));
            System.out.println(resultSet.getString("passWord"));
        }
        connection.close();
    }
}

spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/springboot1
    username: root
    password: 123
    
```

```
springboot默认支持的数据连接池有
tomcat的连接池，hikariDatasource，dbcp

也可以自定义数据连接池
```

```
DataSourcelnitializer : ApplicationListener ;

作用:
1 ). runSchemaScripts);运行建表语句;
2). runDataScripts(;运行插入数据的sq|语句;
默认只需要将文件命名为:
	schema-*.sql. data- .5q1|
每一次运行的时候都会创建，第二次运行的时候，是清除数据库

```



# Linux 使用遇见的BUG（VM15.5）

## 首次使用，无法上网

```
首次使用CentOS 先使用本地DOS ping Linux的IP，然后使用CentOS ping本地的IP

如果ping不通，请检查本地的虚拟机网络的IP和CentOS是否在同一个路径下
```

## 克隆服务器后，不能够上网的问题

```
修改网络适配器，点击高级，点击重新生成，00:50:56:2E:CE:68

修改网络适配器，点击高级，点击重新生成，00:50:56:34:6B:EB
```

