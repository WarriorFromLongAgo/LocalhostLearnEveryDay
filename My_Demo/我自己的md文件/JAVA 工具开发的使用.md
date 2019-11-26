​	

表单校验：https://www.cnblogs.com/GaiaBing/p/9341857.html
https://www.runoob.com/jquery/jquery-plugin-validate.html
表单高级校验：



# git 提交代码 分布式代码版本管理

> 注意：请开启浏览隐藏文件
>
> 否则，将会无法看见 .git 的隐藏文件

## git 提交代码到GitHub（第一次 和 后续代码变更）

```
准备工作，git的安装，SSH添加
```

```
1，git安装（省略）
```

```
2，SSH添加
在github界面，点击右上角setting会出现以下界面，选择SSH添加
title随意填写，下方填写本地的  .pub文件的SSH秘钥

本地SSH的文件目录如下
```

![](JAVA%E5%BC%80%E5%8F%91%E5%B7%A5%E5%85%B7%E7%9A%84%E4%BD%BF%E7%94%A8/%E7%82%B9%E5%87%BBNEW%20%E6%B7%BB%E5%8A%A0SSH.png)

![](JAVA%E5%BC%80%E5%8F%91%E5%B7%A5%E5%85%B7%E7%9A%84%E4%BD%BF%E7%94%A8/%E6%B7%BB%E5%8A%A0SSH.png)

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B0SSH.png)

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B0SSH%201.png)

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B0SSH%202.png)



```
添加完成后

开始正式进行GIT项目创建，项目提交

GitHub处于的界面如下图所示，本地文件夹目录如下
```

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E7%AC%AC%E4%B8%80%E6%AC%A1%E6%8F%90%E4%BA%A4.png)

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B02%20.png)

```
第一次提交代码开始


在此目录下，右键打开git bash
本地Git开始操作
git init
```

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B0%201.png)

```
git add .
选择dasd目录添加，.也可以修改

$ git commit -m "tijiao"
将添加的代码提交到本地的仓库，同时添加本地提交的描述文件

$ git remote add origin https://github.com/WarriorFromLongAgo/11.git

$ git push -u origin master


```

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B04.png)

```
第二次提交代码开始

$ git commit -m "2019年11月8日11:04:08"
将添加的代码提交到本地的仓库，同时添加本地提交的描述文件

$ git remote add origin https://github.com/WarriorFromLongAgo/11.git
https://gitee.com/warriorfromlongago/LocalhostLearnEveryDay2.git

fatal: remote origin already exists.
提交报错
$ git remote rm origin
执行上述命令
$ git remote add origin https://github.com/WarriorFromLongAgo/11.git

再次提交

$ git push -u origin     
提交到主分支

```

![](%E9%A1%B9%E7%9B%AE%E5%AE%9E%E4%B9%A0/%E6%9C%AC%E5%9C%B0%203.png)

## git clone项目到本地

```
git clone https://gitee.com/null_468_6114/mvnfhm.git
```

```
1，首先获得HTTPS的下载地址
```

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191114102629.png)

```
2，处于当前目录下，右键打开git bash命令行项目
```

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191114102835.png)

```
执行git clone命令将项目clone到本地
```

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191114102349.png)

## git 从仓库pull文件下来

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/clone%201.png)

```
1，处于git存在的目录下，右键打开git bash
```

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/clone2.png)

```
2，git pull origin master
把变更拉下来
```

# 码云创建仓库实例

## 1，创建仓库









# Zookeeper 协调管理

```
作用：基于观察者设计模式设计的分布式服务管理框架，负责存储管理项目中，大家都关心的数据，然后接受观察者的注册，一旦这些数据发生变化，zookeeper就负责通知已经在zookeeper上注册的观察者做出相应的反应。
```

```
特点：
1，zookeeper是一个leader，多个follower组成的集群，。
2，zookeeper中只要有 > 1/2 的节点存活，zookeeper集群就可以正常服务，不包括 = 
3，全局数据一致，每个server保存一份相同的数据副本，client无论连接到哪个server，数据都是一致的。
4，来自同一个 client的请求，都是按照顺序进行的。
5，数据更新的特点，一次数据更新，要么成功要么失败。事务的特点。
6，在一定时间范围内，client能读到最新的数据，同步时间非常短，数据量非常小

```

``` 
zookeeper的数据结构
zookeeper数据模型的结构，整体看上去是一棵树，每个人节点称为一个zookeeperNoode
每个节点的存储数据大小为 1M
```

![image-20191109142717262](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/image-20191109142717262.png)

```
应用场景：
1，统一命名服务
在分布式环境下，经常对应用和服务统一命名，便于识别，

2，统一配置管理
同步机制：
	1，要求集群中，所有节点的配置信息是一致的，比如kafka集群
	2，配置文件修改后，希望可以快速同步到各个节点上，
配置管理：
	1，将配置文件写入zookeeper的一个znode，
	2，其他客户端监听这个znode

3，统一集群的管理
	1，分布式环境中，实时掌握每个节点的状态，根据节点实时状态，做出相应的调整
	2，将节点信息写入其中的一个子节点，监听这个znode的变化，做出实时的相应的变化

4，服务器动态上下线，

5，软负载均衡
	在zookeeper中记录每台服务器的访问数，让访问数最小的服务器去处理最新的用户请求

```

## zookeeper linux下的使用

```
1，上传压缩文件，并解压
2，复制一份zoo_sample.cfg文件为 zoo.cfg文件，在解压文件的conf目录下
3，修改zoo.cfg的文件保存位置
dataDir=/usr/local/zookeeper-3.4.14/zookeeperData
4，操作zookeeper
	bin/zkServer.sh start	启动服务器
	bin/zkCli.sh			启动客户机
	ls /					查看zookeeper根目录下有什么文件
	quit					退出客户机
	bin/zkServer.sh stop	关闭服务

```

```
配置文件解读
ticktime=2000	2秒
initLimit=10 	10个心跳，超过就是连不上了
syncLimit=5		5个心跳，集群启动后，同步通信时间
clientPort=2181	客户端访问服务器的端口
dataDir=/usr/local/zookeeper-3.4.14/zookeeperData	文件保存位置

```

```
1，半数机制：集群中只要有 > 1/2 的节点存活，集群就可以正常服务，不包括 = 
2，在配置中虽然没有指定master和slave，但是集群在工作时，只有一个leader和一堆fallow，leader是通过内部的选举机制产生的。
3，内部选举机制是先入为主，假设有5台服务器，1,2，3，4,5，以id大小为序号，开始选举leader
	1先进去，给自己一票，但是不满足半数，进入2
	2进去，给自己一票，同时1给他一票，不满足半数进入3
	3进去，给自己一票，同时1和2给他两票，满足半数，胜任leader
	4和5都称为fallow
```



```
节点类型
1，持久化目录节点：客户端与集群连接后，该节点依然存在
2，持久化顺序编号目录节点：客户端与集群断开连接后，节点依旧存在，但是会对该节点进行顺序编号
3，临时目录节点：客户端与集群连接后，该节点被删除
4，临时顺序编号目录节点：客户端与集群连接后，该节点被删除，只是会给该节点进行顺序编号

创建znode时设置顺序标识，znode名称后会附加一个值，顺序号是单调递增的计数器，由父节点维护
顺序标识：用于对所有的事件进行全局排序，客户端可以通过顺序号推断事件的顺序
```

# zookeeper实战

```
1，集群规划
在 fuwu1，fuwu2，fuwu3 部署

2，解压安装
解压，创建zoo.cfg文件，创建zookeeperData目录，

##############################################
#########################     cluster
service.1=fuwu1:2888:3888
service.2=fuwu2:2888:3888
service.3=fuwu3:2888:3888
.1 .2 .3是服务器的ID，在myid里面写的
fuwu1,2,3是服务器的ID
2888是数据交互的端口
3888是选举信息交互的端口
```



# 消息队列

```
消息服务中间件，提升系统的异步通信，扩展解耦能力
消息服务有两个重要概念：消息代理和目的地。
	当消息发送者发送消息以后，将由消息代理接管。消息代理保证消息传递到指定的目的地。
消息队列主要有两种形式的目的地：
	队列：点对点消息通信
	主题：发布、订阅
点对点式：
	消息发送者发送消息，消息代理将其放入队列，消息接受者从队列中获取消息内容，读取后移除队列
	消息只有唯一的发送者和接收者，但并不是说只能有一个接收者
发布订阅式：
	发送者发送消息到主题，多个接收者监听这个主题。那么就在消息到达时，同时接到消息
JMS：java message service：java消息服务
	基于JVM的消息代理规范。activeMQ，是JMS的实现
AMQP：advanced message queuing protocol
	高级消息队列协议，也是消息代理的一个规范，兼容JMS
	rabbitMQ是基于AMQP的实现

```



```
JMS：JAVA API
不是跨语言的，不是跨平台的。
Model消息模型：peer-2-peer，pub-sub
支持的消息类型：textmessage，mapmessage，bytesmessage，streammessage，objectmessage，message
综合评价：JMS定义了JAVA API层面的标准，在java体系中，多个client均可以通过JMS进行交互，不需要应用修改代码，但是其对跨平台的支持较差;

java使用不用更改代码，
```

```
AMQP：网络线及协议
跨语言，跨平台
model消息模型：direct exchange，fanout exchange，topic change，headers exchange，system exchange
支持的消息类型：byte[]，在实际应用中，将复杂的消息序列化后发送

综合评价：AMQP定义了wire-level层的协议标准;天然具有跨平台、跨语言特性。

跨平台，使用需要更改代码

```



```
spring支持
    spring-jms提供了对JMS的支持
    spring-rabbit提供了对AMQP的支持
    需要ConnectionFactory的实现来连接消息代理
    提供JmsTemplate、RabbitTemplate来发送消息
    @JmsListener (JMS)、@RabbitListener (AMQP)注解在方法上监听消息代理发布的消息
	@EnableJms、@EnableRabbit开启支持
9. Spring Boot自动配置
	JmsAutoConfiguration
	RabbitAutoConfiguration

```



```
分布式基于发布/订阅模式的消息队列，主要用于大数据实时处理行业

1，解耦
	允许独立的扩展或修改两边的处理过程，只要确保他们遵守相同的接口约束
2，

```

## rabbitMQ

简洁：由erlang开发实现的AMQP的开源实现

核心概念：

message：消息是不具名的，由消息头和消息体组成，消息体是不透明的，而消息头则由一系列的可选属性组成。这些属性包括routing-key路由键，priority相对其他消息的优先权，delivery-mode消息可能需要持久化存储。

publisher：消息的生产者，也是一个向交换器发布消息的客户端应用程序

exchange：交换器，用来接收生产者发送的消息并将这些消息路由给服务器中的队列。

​		Exchange有4种类型: direct(默认), fanout, topic,和headers,不同类型的Exchange转发消息的

​		策略有所区别

queue：消息队列，从来保存消息直到发送给消费者。他是消息的容器，也是消息的终点。一个消息可以投入一个或者多个队列。消息一直在队列里面，等待消费者连接到这个队列将其取走。

Binding：绑定，用于消息队列和交换器之间的关联。一个绑定就是基于路由键，将交换器和消息队列连
接起来的路由规则，所以可以将交换器理解成一个由绑定构成的路由表。
Exchange和Queue的绑定可以是多对多的关系。

Connection：网络连接，比如一个TCP连接。

Channel：信道，多路复用连接中的一条独立的双向数据流通道。信道是建立在真实的TCP连接内的虚拟连接，AMQP命令都是通过信道发出去的，不管是发布消息、订阅队列还是接收消息，这些动作都是通过信道完成。因为对于操作系统来说建立和销毁TCP都是非常昂贵的开销，所以引入了信道的概念，以复用一条TCP连接。

Consumer：消息的消费者，表示一个从消息队列中取得消息的客户端应用程序。

Virtual Host，虚拟主机，表示一批交换器、 消息队列和相关对象。虚拟主机是共享相同的身份认证和加密环境的独立服务器域。每个vhost本质上就是一个mini版的RabbitMQ服务器，拥有自己的队列、交换器、绑定和权限机制。vhost 是AMQP概念的基础，必须在连接时指定，RabbitMQ默认的vhost是 / 。

Broker：表示消息队列服务器实体



```
exchange类型：
direct exchange： 直连型路由器：当headers匹配AMQP消息的headers时，直接连接将消息给发过去。
	也可以设置绑定规则，当规则匹配时，直接将消息放到不同队列queue里面去。
	典型的点对点通信模式
fanout exchange：群发型路由器，信息到达后，给绑定的所有队列都群发一份。
topic exchange：通过模式的匹配分配消息的路由键属性。
	符号“#”：匹配0个或者多个单词
	符号"*"：匹配一个单词
	第一个消息为usa.news，会放在第一个和第二个队列
	四个队列为USA.#，#.news，#.weather，europe.#


```

```
docker pull rabbitmq:3-management 
docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq01 5ab234e119da

http://192.168.200.128:15672/
guest==guest
 
//Message需要自己构造一个;定义消息体内容和清息头
//rabbitTemplate.send(exchage, routeKey, message);

//object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq;
//rabbitTemplate. convertAndSend( exchage, routeKey,object);
Map<String,object> map = new HashMap<>();
map.put("msg", "这是第一个消息");
map.put("data", Arrays .aslist("helloworld" ,123,true));
//对象被
rabbitTemplate . convertAndSend( exchange: "exchange.direct" , routingKey: "atguigu.news" ,map);

```



```

```



# -------------------------------------------------

# solr 

```
https://www.bilibili.com/video/av48889139?p=6

1，
```





















































