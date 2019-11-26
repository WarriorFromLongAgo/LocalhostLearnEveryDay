# 1，代理抛出异常错误
java.rmi.server.ExportException: Port already in use: 1099; nested exception is: java.net.BindException: Address already in use: JVM_Bind

问题分析
这里说的是1099端口被其它进程占用了.

解决办法
找出占用1099端口的进程,进入windows命令，查看什么进程占用了1099端口
使用命令:netstat -aon|findstr 1099 找出占用1099端口的进程
netstat -aon!findstr 1099	找到占用1099端口的进程
taskkill -f  -pid 3756(3765为进程id) 

# 2，IDEA和servletContext问题点
问题说明：在IDEA外面对一张图片进行操作，设置图片名称等等。
如果包含中文，则会出现读取错误，显示为无法下载，已下载就是转移到新地址的错误

#  3，a href="javascript:deleteStudent(${student.id});"
写一个方法传参的时候

	function deleteStudent(id) {
	        if (confirm("您确定要删除吗")) {
	            location.href = "${pageContext.request.contextPath}/deleteController?id=" + id;
	        }
	    }

# 4，JS代码理论上建议放在入口函数里面
如果把JS代码放在dom树的头部或者说开始的地方，就会出现错误。
错误现象就是没有任何现象。
放在入口函数里面，就是有用的。

# 5，修改数据，回显的时候
必须返回的是一个对象，不能是List或者是其他的什么。
否则无法在EL表达式里面拿出数据

# 6，转发和重定向BUG
转发的时候request域里面携带了太多不必要的参数，这些参数在登录的时候包含太多参数
登录 和 下一个界面的关系应该是重定向，直接清除request里面的东西。

# 7，建立web项目的时候
背景介绍：使用的是德鲁伊连接池
报错问题：德鲁伊连接池的配置文件无法获得
问题分析：根据报错，猜测是德鲁伊的路径错了，哪个文件是否有空的现象
BUG测试：修改各个路径，不允许出现空，用下划线代替空
问题后续：修改后可以正常使用

# 8，baseServlet使用
背景介绍：baseServlet使用
报错问题：反射的时候，底层sql语句，也是JDBCtemplet用错了
问题分析：根据报错，猜测是底层出错了，然后一步步打印，发现在jdbctemplet上下，没有打印
BUG测试：一步步打印测试
问题后续：修改

# 9，The origin server did not find a current representation for the target resource

```
背景介绍：配置maven的整合，使用tomcat7:run启动
			<plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <port>8080</port>
                    <path>/ssm</path>
                </configuration>
            </plugin>
前端页面描述如下		
<form action="/user/findAll" method="post">
    <input type="submit" value="提交">
</form>

maven多项目控制 环境下，路径不一致导致的问题。

报错问题：index的路径为，8080/ssm，点击一下后，跳转路径变为8080/user/findAll，然后报错
问题分析：路径找不到，所以导致的错误
BUG测试：修改<port>8080</port> 为<port>/</port>，或者修改form表单的请求路径
问题后续：修改
```

