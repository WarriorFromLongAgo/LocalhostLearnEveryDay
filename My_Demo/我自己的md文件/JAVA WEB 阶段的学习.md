#  tomcat

​	1，服务器的启动和关闭，bin目录下面的startup，和shutdown
​	2，服务器发布项目的方式
​		1，将项目复制到webapps的目录里面（导成war包），访问项目的路径就是文件夹的名字，localhost：8080/user
​		2，在conf/server.xml里面，的HOST标签下面设置
​			<Context docBase="D:\IDE\hello" path="/hehe" />
​		3，在conf/Catalina/localhost/ 下创建一个xml文件，文件名称格式hehe.xml，里面的内容是<Context docBase="D:\IDE\hello" />
​		支持	热部署
​		

		IDEA与Tomcat集成后，使用的是第三种，下图为 Using CATALINA_BASE: 
		C:\Users\biantai\.IntelliJIdea2019.1\system\tomcat\Tomcat_8_5_31_day13_JSP_Project\conf
		内容为：<Context path="/day13_JSP_Project_war_exploded" docBase="D:\MyJAVADemo\day13_JSP_Project\out\artifacts\day13_JSP_Project_war_exploded" />
	
	3，服务器
		安装了服务器软件的电脑，安装了Tomcat的叫做web容器服务器

# servlet

​	1，创建一个类，实现servlet的接口，并实现五个方法
​	2，然后在web.xml中配置servlet（servlet-name和servlet-class(全限定类名)）和servlet-mapping（servlet-name和url-pattern(访问路径)），
​	3，GernericServlet：不能够处理http协议，请求与响应。
​	4，HttpServlet：能够处理http协议

	5，配置servlet
		1，注解配置
		2，web.xml配置
	6，其他
		1，web应用都是运行在web容器上的，
		2，启动服务器，会直接加载web.xml，得到配置文件


​	
servlet的生命周期

	1，创建	init：
		默认情况下:servlet第一次在访问的时候，会调用init
		设置load-on-startup：大于等于0，在启动服务器的时候，就直接调用init，设置小于0：则是默认
		（不可以设置非整数）、
		数字代表的是，优先级，不要设置为1，1是最高优先级，建议设置为2，因为servlet本身有很多自带的servlet优先级为1
	2，销毁	destroy：服务器正常关闭的时候，
	3，处理请求 service：
		1，servlet是多线程的，（多个线程请求同一个资源）
		2，每一次用户请求的时候，Tomcat会创建新的线程去执行servlet的service方法
		3，解决多线程安全问题：
			1，不允许定义成员变量，定义成员变量也要定义成 无法修改的。
			所有的变量全部定义局部变量、

#request
	1，浏览器发送一个表单数据，表单数据在传输的时候都是基于http协议
	2，表单到达服务器后，也就是一个请求后。

	1，Tomcat服务器会根据请求URL中的资源路径，创建对应的servletdemo1中的对象
	2，当客户端的请求到达Tomcat服务器，一定先会创建request和response对象，request对象中封装请求 消息数据。
	3，Tomcat将request和response两个对象，传递给service方法。
	4，我们可以通过request对象获取请求信息数据，通过修改response对象设置响应消息数据。
	5，服务器在给浏览器响应之前，会先从response对象中获取 已经设置好的响应消息数据
	6，request的书写步骤
		1，接收请求参数
		2，封装请求参数
		3，处理请求
		4，相应数据

一，request的继承结构

	ServletRequest
	接口继承
	HttpServletRequest
	接口继承	
	org.apache.catalina.connector.RequestFacade类（Tomcat）

二，request功能

	1，获取请求的消息
	
		1，获取请求行数据，
			get /day14/demo1?name=zhangsan HTTP/1.1
			方法
				1，获取请求的方式，get post
					String getMethod()
	
				2，(重要)获取虚拟目录		/day14
					String getContextPath()
	
				3，获取servlet路径，	/demo1
	 				String getServletPath()
	
				4，获取get方式请求参数 name=zhangsan
					String getQueryString
	
				5，(重要)获取请求的URI		/day14/demo1
					String getRequestURI()	/day14/demo1
					StringBuffer getRequestURL()	http://localhost/day14/demo1
				URL:统一资源定位符	http://localhost/day14/demo1	中华人民共和国
				URI：统一资源标识符	/day14/demo1	共和国 
	
				6，获取协议及版本	http/1.1
					String getProtocol()
	
				7，获取客户机的IP地址
					String getRemoteAddr()
		2，获取请求头数据
			方法			
			(重要)String getHeader(String name):通过请求头的名称，获取请求头的值
			Enumeration<String> getHeaderNames()：获取所有的请求头的名称
		
		3，获取请求体数据
			请求体：只有post的请求方式，才有请求体，在请求体中封装了post的请求参数。
			步骤：
				1，获取流对象
					bufferedReader getReader()	获取字符输入流，只能操作字符数据
					ServletInputStream getInputStream()	获取字节输入流，可以操作任何
					 
				2，再从流对象中获取数据
					
	2，其他功能
		1，获取请求参数通用方式
			String getParameter(String name) 根据参数名称获取参数值username=fei&password=123
			String[] getParameterValues(String name) 根据参数名称获取参数值的数组hobby=1&hobby=2
			多用于复选框
			Enumeration<String> getParameterNames() 获取所有请求的参数名称
			Map<String, String[]> getParameterMap() 获取所有参数的map集合
			
			中文乱码的问题，
			get方式，Tomcat8 已经解决
			post方式，设置流的编码
				request.setCharacterEncoding("utf-8")
				1,在获取参数前，设置request的编码格式，
	
		2，请求转发，一种在服务器内部的资源跳转的方式
			步骤：
				RequestDispatcher getRequestDispatcher(String path) 
				通过request对象，获取请求转发器对象，
				forward(ServletRequest request, ServletResponse response)
				使用RequestDispatcher对象来进行转发
			特点：
				浏览器的地址栏不发生变化，
				只能在当前服务器内部资源中，进行转发
				在浏览器中只会有一次请求，只有一个request的对象，但是会访问两个资源
				可以使用request对象共享数据


​			
​		3，共享数据
​			域对象：一个有作用范围的对象，可以在范围内共享数据，
​			request域，代表一次请求的范围，一般用于请求转发的多个资源中共享数据
​			方法：
​				void setAttribute(String name, Object obj) 存储数据
​				object getAttitude(String name) 通过键，获取值
​				void removeAttribute(String name) 通过键删除 键值对
​				
​		4，获取 servletContext（）
​			范围：整个web项目（一个web项目只有一个）
​			创建：服务器启动的时候，会为每一个web应用，创建一个servletContext
​			（上下文：当前服务的环境对象）
​			获取：servletContext getServletContext()
​			销毁：服务器关闭的时候，销毁
​	
​			作用：获取应用的相关信息
​				(获取web目录下的文件，获取WEB-INF下的文件，获取src目录下的文件)
​				1，servletContext.getRealPath("a.txt")
​				2，servletContext.getRealPath("/WEB-INF/a.txt")
​				
​				3，servletContext.getRealPath("/WEB-INF/classes/a.txt")
​				4，类加载器：
​		
​		5，servletConfig：每一个servlet对应一个config


​			
# HTTP协议	
	作用：规范数据两端的数据格式
	
	1，基于tcp/ip协议，
	2，基于请求响应模型
	3，是无状态的，各个请求之间，相互独立。对事务的处理没有记忆性。
	4，


1，请求消息：客户端发送给服务端的数据

	数据格式：
		1，请求行
		2，请求头
		3，请求空行（不需要）
		4，请求体

2，响应消息：服务器发送给客户端的数据

	数据格式：
		1，响应行
			1，组成的协议/版本	响应的状态码	状态码的描述
			2，响应的状态码，都是三位数字
				分类：
					1，1XX 服务器接收客户端数据，但没有接收完成，等待一段时间后，发送1xx状态码
					2，2xx 成功
					3，3xx 重定向，
					4，4xx 客户端错误
						404：请求的路径没有对应的资源
						405：请求的方式没有对应的方法
					5，5xx 服务端错误
						500：服务器内部出现异常
		2，响应头
			格式：头名称：值
			常见的响应头：
			Content-Type: text/html; charset=utf-8 数据格式和编码
			content-disposition 服务器告诉客户端以什么格式打开我的响应体数据
				1，默认值：in-line：在当前页面打开
				2，attachment；filename=xxx：以附件形式打开响应体，文件下载
				
		3，响应空行（不需要）
		4，响应体:传输的数据
	
	response headers 响应的头信息
	
	HTTP/1.1 200 OK
	
	Date: Sat, 07 Sep 2019 09:45:44 GMT
	Content-Type: text/html; charset=utf-8
	Transfer-Encoding: chunked
	Connection: keep-alive
	Server: nginx
	Cache-Control: public, max-age=900, must-revalidate
	Content-Security-Policy: default-src 'self'; script-src 'self' 'unsafe-inline' 'unsafe-eval' http://a.alimama.cn g.click.taobao.com platform.sina.com.cn suggestion.baidu.com www.baidu.com hm.baidu.com nssug.baidu.com tui.cnzz.net www.google-analytics.com *.googlesyndication.com static.huohu123.com https://www.duba.com/main3_json.html http://www.duba.com/main3_json.html; img-src * data:; child-src 'self' *.firefoxchina.cn  *.17huohu.com; frame-src 'self' *.firefoxchina.cn  *.17huohu.com www.taobao.com entry.baidu.com; frame-ancestors 'self' *.firefoxchina.cn tongji.baidu.com about:; style-src 'self' 'unsafe-inline'; font-src 'self' data: ; report-uri /_/csp-reports
	Content-Encoding: gzip
	Age: 490
	X-Via: 1.1 PSbjsdBGPru29:1 (Cdn Cache Server V2.0), 1.1 fzh37:10 (Cdn Cache Server V2.0), 1.1 PS-000-01qzq70:2 (Cdn Cache Server V2.0)


	<html>
	</html>

## response对象
	功能：设置响应消息
	1，设置响应行
		1，HTTP/1.1 200 OK
		设置状态码，setstatus（int xx）
		200	正常
		302 重定向
		404 访问的资源找不到
		405 访问的方式错误，getpost
		500 服务器程序错误
	
	2，设置响应头
		setContenttype（） 设置响应的数据格式，以及浏览器打开数据的编码方式
		setLocaltion() 设置重定向的资源跳转路径
		setHeader(String name, String value)
	3，设置响应体
		获取流，然后使用输出流输出到浏览器
		字符输出流，字节输出流
		printWriter getWriter()
		ServletOutputStream getOutputStream()
	
	4，完成重定向：重定向和转发都是资源跳转的方式
	代码实现：
		第一种方式 1，设置状态码为302；response.setStatus(302)
		2，设置响应头为localhost：response.setHeader("localhost"，"网址")
		
		第二种方式 response.sendRedirect("网址")
		
	5，重定向和转发的区别
		重定向：redirect
				1，地址栏可以发生变化。
				2，重定向可以访问其他站点
				3，重定向是两次请求，不可以使用request对象域来共享数据
	
		转发：forward
				浏览器的地址栏不发生变化，
				只能在当前服务器内部资源中，进行转发
				在浏览器中只会有一次请求，只有一个request的对象，但是会访问两个资源
				可以使用request对象共享数据
		
	6，路径的写法
		1，路径的分类
			相对路径：通过相对路径不可以确定位移资源
				如：./index.html
				不以/开头的，以.开头
				规则：找到当前资源和目标资源之间的相对路径关系
			绝对路径：通过绝对路径可以确定唯一的资源
				如：http://localhost/day/response
				以斜杠开头的路径，就是绝对路径


​	

#会话
	打开浏览器，进行一系列的请求，直到关闭，统称为一次会话。
	
	作用：实现在一次会话和多次请求之间共享数据，

#cookie的实现（会话cookie， 持久级别的cookie）
	新建一个cookie
	new cookie(string name, string value)
	发送cookie
	void response.add发送对象
	获取对象
	cookie[]  request.getcookie
	
	实现原理：
		基于响应头的setcookie实现，
		基于请求头的Cookie实现
	
	1，一次可以发送多个cookie
	2，cookie默认情况下，浏览器关闭后，cookie即被销毁
	3，持久保存可以设置setMaxAge(int seconds)
		1，正数，持久保存多少秒
		2，负数默认值
		3，零：删除信息
	4，cookie可以存储中文
	5，cookie共享问题
		一个Tomcat服务器中，部署多个web项目，那么这些web项目之间的cookie不可以共享
		默认情况下，cookie不可以共享。
		
		setPath(String path)设置cookie的获取范围，默认情况下，设置当前的虚拟目录
		cookie1.setPath("/day16") 设置day16目录下的项目，可以使用这个cookie
		如果要共享，想cookie设置成"/"		
		cookie1.setPath("/") 当前项目的根路径
		
		2，不同的服务器之间的cookie共享
			setDomain(String path)
			如果设置一级域名相同。则多个服务器之间都可以共享使用
			setDomain(".baidu.com") 那么tieba.baidu.com news.baidu.com中的cookie都可以一起使用
		
	6，cookie的特点和作用
		1，cookie存储数据在，客户端浏览器
		2，浏览器对于单个cookie的大小是有限制的，以及对同一个域名下的总cookie数量也有限制
		（20个）
		
		作用：1，cookie一般用于存储少量不敏感的数据
			2，在不登录的情况下，完成服务器对于客户端的身份识别
	
	案例：记住上一次的访问时间
		1，需求：
			1，访问一个Servlet，如果是第一次访问，则提示您好，欢饮您首次访问
			2，如果不是第一次访问，则提示欢迎回来，显示上一次登录的时间，显示时间的字符串


#JSP
	1，java servlet page：java的服务器页面
		一个特殊的页面，即可以写html，又可以写java
	
	2，原理，本质是一个servlet
	3，JSP的脚本
		<% 	代码 %> （方法，局部）正常运行的代码，可以写，在service中写的所有代码
		<%! 代码 %> 定义全局变量
		<%= 代码 %> 代码会直接输出到页面上
	4，JSP的内置对象
		request：
		response：
		out：字符输出流对象，可以将数据输出到页面上，
			response.getWriter 和 out的区别：前者优先输出，后者在前者输出完后输出
			Tomcat服务器真正给客户端做响应的时候，会先找response缓冲区数据，然后再找out缓冲区的数据

#session 
	1，服务器端的会话技术，他是基于 cookie实现的，所以是利用请求调用

	2，获取HttpSession对象
		HttpSession sessoin = request.getSession();	
	3，使用HttpSession对象
		object  getAttribute(String name)
		void	setAttribute(String name, object value)		
		void	removeAttribute(String name)				删除对应name的对象头
		void	setMaxInactiveInterval(int interval) 		设置失效时间
		String  getId() 
		long	getCreationTime() 返回创建此回话的时间
	
	4，细节
		1，当客户端关闭，服务器不关闭，再次获取的session是否为同一个
			答：不是同一个，
			答：如果需要是同一个session，则可以创建一个cookie，键为JSESSIONID，设置最大的存货时间，让cookie持久化保存		
	
		2，当客户端关闭，服务器关闭，再次获取的session是否为同一个，
			答：不是同一个，但是要确保数据不丢失
				session的钝化：在服务器正常关闭的时候，将session对象序列化到硬盘上。
				session的火花：	在服务启动时，将session进行加载
			
	5，session的生命周期
		1，创建：
			用户在一次会话中，并且调用getsession方法的时候，创建。
		2，销毁
			服务器非正常关闭
			30分钟到了，就会销毁（web.xml）


		2，session对象删除	
			invalidate()
		3，session默认的失效时间	
			setMaxInactiveInterval(int interval) 
	
	6，session的特点
		1，session用于存储一次会话的多次请求的数据，存在于服务器中
		2，session可以存储任意类型，任意大小的数据
		
	7，session和cookie的区别
		1，session存储数据在服务器端，cookie在客户端
		2，session没有数据大小限制，cookie有限制
		3，session数据安全，cookie相对于不安全

#域对象
	request：
	pagecontext：一个页面之间贡献该数据
	servletContext：一个服务器中的唯一一个
	cookie：
			
#MVC
将业务代码与数据展示分离，servlet和JSP

#三层架构：将服务器代码分层开发，使各个模块的耦合度降低，
	页面--控制器controller--视图层view
	
	业务逻辑层，数据访问层，数据库
	
	web层：处理页面请求
	service层：业务逻辑层
	dao层：date access object，业务处理逻辑，数据访问层


#ajax
1，概念：ASychronous Javascript And Xml	异步的JavaScript 和 xml

	ASychronous	异步
	Sychronous	同步
	
	异步和同步：客户端和服务器相互通信的基础上
	
	异步：客户端不需要等待服务端的响应，客户端可以进行其他的操作
	
	同步：客户端必须等待服务端的响应，在等待期间客户端不能做其他操作
	
	ajax是一种用于创建动态网页的技术
	ajax是一种无须加载整个页面，能够更新部分网页的技术。

2，实现方式
	1，原生JS的实现
			// 1，获取核心对象
            var xmlhttp;
            // 如果是低版本浏览器
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            // 2，建立连接
            xmlhttp.open("GET", "ajaxServlet?userName=feijm", true);
            // method：请求的类型；GET 或 POST
            // url：文件在服务器上的位置
            // async：true（异步）或 false（同步）
    
            // send(string)    string：仅用于 POST 请求
            // 将请求发送到服务器。
            xmlhttp.send();
    
    2，jQuery实现方式
    	$.ajax()
    		语法：ajax(url, [settings]);		ajax({键值对});
    			$.ajax({
                url: "ajaxServlet1111",  //请求路径
                type: "POST",
                // date: "userName=tom&age=22",
                date: {"userName": "tom", "age": 22},
                success: function (date) {
                    alert(date);
                },
                error: function () {
                    alert("出错啦。。。");
                }
            });


​			
​		$.get()
​			$.get(url, [data], [callback], [type])
​			url：请求路径
​			data：请求参数
​			callback：回调函数
​			type：响应结果的类型（可以再前端设定，也可以在后台设定type）
​			
​		$.post()

#json	JavaScript object notation	JavaScript对象表示法
json：多用于存储和交换文本信息的语法
	经常用于数据的传输
	json 比 xml 更小更快更易解析
	
	1，基本规则
		数据在名称/值对中	：json数据是由键值对构成的
			键用引号引起来"" ''，也可以不用引号引起来
			值的取值类型
			1，数字，整数或者浮点数
			2，字符串，在双引号中
			3，逻辑值 true或者false
			4，数组，在花括号中		{"person":[{}, {}, {}]}
			5，对象，在花括号中		{"address":{"city:'黄石', provice:'湖北'"}}	在对象里面在写一个对象
			6，null
		
		Json的数据格式：
			数据由逗号分隔	：多个键值对用逗号分隔
			花括号保存对象	：使用{}定义数据的格式
			方括号保存数组	：
	
	2，获取数据 
		1，json对象.键名	获取对象
		2，json["键名"]	获取对象
		3，数组对象[索引]
	
	3，json数据和java对象的相互转换
		json解析器：jsonlib	Gson	fastjson	jackson（spring mvc自带）
		1，json转为java对象
			
		2，java对象转换为json
			1，使用步骤
				1，导入jar包
				2，
				string = objectMapper.writeValueAsString(project);
	        	objectMapper.writeValue(new File("D:\\学习资料下载\\我自己的 md文件\\a.txt"), project);	
				
				String string = JSON.toJSONString(people);
				Object o = JSON.toJSON(people);
	    		System.out.println(string);
				
			2，注解
			@JsonIgnore	在private的属性上添加，添加后该属性不会被转换成json
			@JsonFormat(pattern = "yyyy-MM-dd")
	
			//    @JsonFormat(pattern = "yyyy-MM-dd")
			//    @JsonIgnore
			//    @JSONField(format = "")
			//    @JSONField(serialize = false)


​	
​	4，案例
​		校验用户名是否存在：
​			1，需要校验传输的内容：
​			在前端异步传输的时候的get，可以设置返回的type格式
​			在服务器设置响应的数据格式，MIME，response.setContentType("application/json;charset=utf-8")

#redis
1，一款高性能的NOSQL的非关系型数据库，
	存储：key	value
		name：zhangsan
		age：23
	1，数据之间没有联系
	2，数据存储在内存中。

2，mysql关系型数据库，oracle
emp
id name age
					1，可以进行多对一的绑定，有关联，有关系。
					2，数据存储在硬盘的文件上
dept
id name address

3，非关系型数据库（用来当做缓存）
	我要经常去查询一些不太经常变化的数据，缓存的思想。
	从缓冲中获取数据：
	有数据
		1，直接返回
	没有数据
		1，从数据库中查询
		2，将数据中放入缓存
		3，返回数据
	
	总结：关系型数据库与NOSQL数据库并非对立关系而是互补关系，即通常情况下使用关系型数据库，在适合使用NOSQL的时候使用NOSQL，
		让NOSQL数据库对关系数据库的不足进行，弥补。
		一般会将数据存储在关系型数据库中，在nosql数据库中备份存储关系。

4，主流的非关系型数据库
	1，键值对形式，Redis
		内容缓存，处理大量数据的高访问负责
	2，列存储数据库：HBase
		分布式的文件系统
	3，文档型数据库：MonogoDB
		WEB应用
	4，图形数据库：Graph
		社交网络
5，什么是Redis
	目前Redis支持的键值数据类型如下：
		字符串类型
		哈希类型
		列表类型
		集合类型
		有序集合类型
	Redis应用场景
		
		为了解决
		单例的数据库，最大数据是10G
	
		缓存（数据查询，短连接，新闻内容，商品内容，等等）
		聊天室的在线好友列表
		任务列表（秒杀，抢购，12306，等等）
		应用排行榜
		网站访问统计
		数据过期处理（可以精确到毫秒）：
		分布式集群架构中的session分离：单点登录

6，Redis使用
	1，Redis中文网下载
	2，直接解压就可以使用
	redis.windows.conf：配置文件
	redis-cli.exe：Redis的客户端
	redis-server.exe：Redis的服务器端
	3，命令操作
		1，Redis的数据结构
		字符串类型	：string			get set del
		哈希类型		：hashmap			hset key field value	hget key field		hdel key field		hgetall key
		列表类型		：linkedlist		可以添加一个元素到列表的头部或者是尾部
			lpush key value：将元素添加到列表的左边
			rpush key value：将元素添加到列表的右边
			lrange key start end：范围的获取				（0 -1）是获取全部
			lpop key：从列表的最左边删除一个元素，并返回
			rpop key：从列表的最右边删除一个元素，并返回
		集合类型		：set（不允许重复元素）
			sadd key value 	：
			smembers key 	：获取set集合中的所有的元素
			sren key value	：删除set集合中的某个元素
		有序集合类型	：sortset	（不允许重复元素，且元素有序）
			zadd key score value (score value的分数)(添加也是覆盖)
			zrange key start end	
			zren key value 	
	4，通用命令
		keys *：去查询所有的键（）会返回mylist，myset，mysort这种键
		get username：获取字符串的参数
		type username：获得参数的类型	type myList
		del key：删除指定的key value
		setex：可以指定过期时间的key和value，秒为单位：setex（key，秒，value）
		
		 
7，内存的持久化
	Redis持久化机制：
	RDB：默认方式
		在一定的时间间隔，检测key的变化情况，然后去持久化数据
		#   In the example below the behaviour will be to save:
		
		#   after 900 sec (15 min) if at least 1 key changed
		15分钟900秒，如果有一个key被改变的话，持久化一次
		#   after 300 sec (5 min) if at least 10 keys changed
		5分钟300秒，如果有10个key被改变的话，持久化一次
		#   after 60 sec if at least 10000 keys changed
		1分钟60秒，如果有10W个key被改变的话
		save 900 1
		save 300 10
		save 60  10000
		1，redis.windows.conf：用命令行从配置文件启动，持久化后就会生成一个rdb后缀的文件
		在Redis目录命令行启动：目录 + redis-server.exe redis.windows.conf
	
	AOF：日志记录的方式，记录每一条的数据操作，每一次命令操作后，都持久化数据
		appendonly no	默认是关闭的。yes代表开启
		
		# appendfsync always	每一次操作，都进行持久化
		appendfsync everysec	每隔一秒，进行一次持久化
		# appendfsync no		不进行持久化

8，java客户端 jedis
	java操作jedis的数据库的工具
	1，下载jar包
	2，操作
		1，获取连接	：Jedis jedis = new Jedis("127.0.0.1", 6379);
		2，操作		：jedis.set("userName","feijm");
		2，关闭连接	：jedis.close();
		
9，jedis连接池，jedisPool 与 配置对象
	 0，创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        设置最大的连接数
        jedisPoolConfig.setMaxTotal(50);
//        空闲连接
        jedisPoolConfig.setMaxIdle(10);
//        1，创建JedisPool连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
//        2，调用方法 getResource()获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("hehe", "hahahahhahahahaha");
    
        jedis.close();

10，案例
	1，提供一个index.html页面，页面中有一个省份，下拉页表
	2，当页面加载完成后，自动发送ajax请求，加载所有的省份。
	3，
		
	注意：使用Redis缓存一些不经常发生变化的数据
		数据库的数据一旦发生改变，则需要更新缓存
		数据库的表执行，增删改的相关操作，需要将Redis缓存数据清空，再次存入

#Maven
概念：是一个项目管理工具，包含了一个项目对象模型，pom。包含两个东西：1，项目生命周期：Projet LifeCycle；2，依赖管理系统：Dependency Management System。用来运行定义在生命周期阶段phase，中插件plugin 目标goal 的逻辑。

Maven依赖管理：maven项目对jar包的管理，依赖管理

bin：MVN文件命令用来构建项目
boot：Maven自身运行所需要的类加载器
conf：settings.xml对Maven进行各种各样配置的时候
lib：Maven自适应运行所需要的jar包

Maven仓库种类和批次之间的关系
	1，maven工程：只会放置jar包的坐标，当启动Maven工程的时候，Maven会在仓库中去找jar包
	（在conf/settings.xml里面
	<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
	
	 Default: ${user.home}/.m2/repository
	系统盘用户目录下：创建一个.m2文件夹，再在下面创建一个repository文件夹，作为本地仓库的位置，
	）
	
	2，系统盘本地仓库：去本地仓库找JAR包。
		如果是可以联网的，本地仓库会自动去中央仓库下载jar包，没有联网，就报错。
		放置了几乎所有开源的jar包
	
	3，为了不联网也可以开发， 远程仓库，私服
		保证远程仓库和你的电脑在一个局域网，局域网从远程仓库下载，
		假如远程仓库也没有的话，远程仓库就从中央仓库下载， 
		远程仓库也可以通过本地上传jar包
	
	<localRepository>/path/to/local/repo</localRepository>
	通过修改，可以重新制定本地仓库的路径，

1，Maven标准结构目录
	核心代码部分：
	配置文件部分：
	测试代码部分：
	测试配置文件：

	传统项目：src目录下，
	Maven项目：src/main/java 核心代码
			  src/main/resources 配置文件部分
			  src/test/java目录 
			  src/test/resources 测试配置文件部分
			 
			  WEB项目：src/main/webapp 页面资源，JS，CSS，图片

2，Maven中的常用命令
	1，mvn clean：删除了target目录，把编译完成的信息清除，清除别人的代码的编译环境
	2，mvn complie：编译src/main 下的文件
	3，mvn test：编译src/test下的文件，也会编译src/main下面的代码
	4，package:打包，编译src/test下的文件，也会编译src/main下面的代码，并且导成war包
		因为pom.xml中默认指定导成war包
	5，mvn install：编译src/test下的文件，也会编译src/main下面的代码，并且导成war包
		安装到了本地的仓库

3，Maven生命周期
	清除其他信息
	五个命令。编译，测试，打包，安装，发布
	发布：mvn deploy，必须要进行配置，才可以

	站点生命周期：
	
	默认声明周期，清理声明周期：
		清除项目编译信息：
		编译
		测试
		打包
		安装
		发布

4，maven概念模型
	1，依赖管理
	pom.xml项目对象模型
	pom.xml，最上面是项目自身的信息，dependency下 项目运行所依赖的jar包，bulid下 jdk的插件以及Tomcat插件，运行环境。
	
	dependency依赖管理模型（b2b，local，centeral三类仓库）
	<dependency>
		公司名称
		<groupId>javax.servlet.jsp</groupId>
		项目名
		<artifactId>jsp-api</artifactId>
		版本号
		<version>2.0</version>
	<dependency>
	
	2，默认生命周期：五个命令，编译，测试，打包，安装，发布，每一个命令都是Maven底层的一个插件，
	默认生命周期就是，一键构建

5，maven的配置
	在系统变量里面，设置新的 MAVEN_HOME
	D:\IDE\apache-maven-3.3.91
	在系统变量 path 里面添加后续
	;%MAVEN_HOME%\bin
	打开cmd，输入 mvn -v
	会显示以下
	Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T00:41:47+08:00)
	Maven home: D:\IDE\apache-maven-3.3.91\bin\..
	Java version: 1.8.0_211, vendor: Oracle Corporation
	Java home: D:\IDE\JDK8_Updata_211\jre
	Default locale: zh_CN, platform encoding: GBK
	OS name: "windows 7", version: "6.1", arch: "amd64", family: "dos"
	即为成功
	

#黑马旅游网





#过滤器
继承Filter接口

	1，需要有三个方法，init，doFilter,destroy
	2，web.xml配置
	
		1，注解配置
		@WebFilter("/*")		访问所有的资源时，都会访问这个过滤器
		@WebFilter("/demo.jsp")	访问demo.jsp的时候，会访问这个过滤器
		2，web.xml配置
		<filter>
			<filter-name>demo1</filter-name>
			<filter-class>com.feijm.filter.FilterDemo</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>demo1</filter-name>
			<!-- 拦截路径 -->
			<url-mapping>/*</url-mapping>
		</filter-mapping>
	
	3，过滤器的执行流程
	4，过滤器生命周期
		"/*"
		1，服务器一开机立刻创建Filter对象，访问init方法，只执行一次（加载资源）
		2，访问dofilter，
		3，访问index.jsp
		4，返回至dofilter方法，
		以后的每一次刷新都会访问dofilter，和对应的页面，
		5，当服务器正常关闭的时候，调用destroy方法。非正常关闭也会销毁对象（释放资源）
		
	5，过滤器配置详解	
		1，拦截路径配置
			1，具体资源拦截："/index.jsp"，只有访问index.jsp资源时，过滤器才会放行。
			2，目录拦截："/user/"，访问/user/下的所有资源时，过滤器都会放行
			对servlet的注解设置为"/user/servlrt1"
			对filter的注解设置为"/user/*"
	
			3，后缀名拦截："*.jsp"，访问所有后缀名为jsp资源时，过滤器都会拦截
			4，所有资源拦截："*"，
		2，拦截方式配置
			1，注解配置
				设置dispatcherTypes属性，
					1，REQUEST：默认值，浏览器直接请求资源
					2，FOWARD：转发请求资源时
					3，INCLUDE：包含访问资源
					4，ERROR：错误跳转的时候
					5，ASYNC：异步访问资源
			@WebFilter(urlPatterns = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
			直接访问index.jsp资源时，触动拦截器，而转发的时候不会触发拦截器
			
			@WebFilter(urlPatterns = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
			直接访问index.jsp 和 转发访问index.jsp 时，触动拦截器，而转发的时候不会触发拦截器

3，拦截的时候，会访问index.jsp两次
			2，配置文件配置
		<filter>
            <filter-name>demo1</filter-name>
            <filter-class>com.feijm.filter.FilterDispatcherTypes</filter-class>
        </filter>

        <filter-mapping>
            <filter-name>demo1</filter-name>
            <!-- 拦截路径 -->
            <url-pattern>/*</url-pattern>
            <dispatcher>REQUEST</dispatcher>
            <dispatcher>FORWARD</dispatcher>
        </filter-mapping>
    
    6，过滤器链
    	1，过滤器的先后问题
    		1，注解配置的过滤器：按照类名的字符串比较规则比较，值小的先执行
    			如AFilter 和 BFilter：每一个字符分别比较，A比B小，AFilter先执行
    		2，web.xml配置的过滤器
    			谁 <filter-mapping> 定义在上面，谁就先执行
    7，例子
    	登录验证的界面
    	1，判断是否是登录相关的资源，是就放行，不是就进行过滤
    	2，判断当前用户是否登录，判断session中是否有User
    	3，没有就跳转到登录页面 
    	
    	验证码，登录的界面，以及登录的servlet不能够拦截，其他的都可以拦截
    	以及/css/，/js/等目录不可以拦截
    
    8，敏感词汇过滤
    	1，需求		
    		1，敏感词汇详见，敏感词汇.txt
    		2，如果是敏感词汇，则替换为****
    			
    	2，分析
    		1，对request进行增强，增强获取参数的相关方法
    		2，放行
    	
    	3，增强对象的模式
    		1，设计模式：一些通用的解决固定模式问题的解决方案
    		装饰模式：对比代理模式，比代理模式笨重
    		代理模式：
    			1，概念
    			真实对象：被代理的对象（联想公司）
    			代理对象：代理商
    			代理模式：代理对象代理真实对象，达到增强真实对象功能的目的
    			2，动态代理
    			静态代理：有一个类文件描述代理模式
    			动态代理：在内存中形成代理类
    				1，代理对象和真实对象实现相同的接口
    				2，代理对象，Proxy.newProxyInstance();
    				3，使用代理对象来调用方法
    				4，增强方法
    		SaleComputer saleComputer = (SaleComputer) Proxy.newProxyInstance(Lenove.class.getClassLoader(), Lenove.class.getInterfaces(), new InvocationHandler() {
                /*
                 * 代理逻辑的方法，代理对象saleComputer调用的所有方法，都会触发该方法的执行
                 * 参数1，proxy代理对象
                 * 参数2，代理对象的方法，被封装的对象
                 * 参数3：代理对象调用方法时，传递的实际参数
                 * */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("该方法执行了。。。。。。。。。。。。");
                    System.out.println(method.getName());
                    System.out.println(args[0]);
                    return null;
                }
            });
    		
    		SaleComputer saleComputer = (SaleComputer) Proxy.newProxyInstance(Lenove.class.getClassLoader(), Lenove.class.getInterfaces(), new InvocationHandler() {
                /*
                 * 代理逻辑的方法，代理对象saleComputer调用的所有方法，都会触发该方法的执行
                 * 参数1，proxy代理对象
                 * 参数2，代理对象的方法，被封装的对象
                 * 参数3：代理对象调用方法时，传递的实际参数
                 * */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object object = method.invoke(lenove, args[0]);
                    return object;
                }
            });
    		
    		增强的方式：
    			1，增强参数列表
    			2，增强返回值的类型
    			3，增强方法体执行逻辑


#Listener：监听器
概念：web的三大组件
1，时间的监听机制
	事件：一件事情
	事件源：事件发生的地方
	监听器：一段代码，
	注册监听：将事件，事件源，监听器绑定在一起。当事件源发生某个事件后，执行监听器的代码

2，ServletContextListener：监听ServletContext对象的创建和销毁
	contextDestroyed(ServletContextEvent sce)：销毁之前会调用该方法
	contextInitialized(ServletContextEvent sce)：创建之后会调用该方法
	1，定义一个类，实现 ServletContextListener 接口
	2，复写方法
	3，配置一下
		1，web.xml的配置
			配置监听器
			<listener>
        		<listener-class>com.feijm.listener.ContextListener</listener-class>
    		</listener>						
			指定初始化参数
			<context-param>
		        <param-name>contextConfigLocation</param-name>
		        <param-value>/WEB-INF/classes/applicationContext.xml</param-value>
    		</context-param>

		2，注解的配置
			@WebListener()

# Maven

```
maven项目是由项目结构的，必须按照结构创建项目

本地仓库，等等
setting的设置
高版本对maven的不支持

	1，注册中文乱码问题
	过滤器设置request为utf-8，控制台打印的时候出现乱码。
	其实是Maven的中文乱码，maven的项目，控制台是由maven控制的。
	
	maven默认的编码是，gb2312
	2，ajax返回的数据无法使用
	因为不设置的话，返回的就只是string，而不是json对象，无法对立面的属性进行调用或者判断
```



```
maven的项目生命周期
清理
初始化
编译
测试
报告
打包 
部署
站点生成

maven管理项目生命周期过程都是基于插件来完成的。
```

```
项目对象管理模型project object model
1，依赖的坐标
2，打包的方式
3，本工程的坐标


```

```
依赖管理系统


```



## Maven高级

```
聚合：将多个工程文件聚合到一起
继承：子类继承父类的依赖管理

创建父工程
1，只需要pom文件，不需要src目录
2，在pom文件里面需要设置：
packaging打包方式 pom，表示这个是父工程


创建子模块
1，直接在父工程下，创建子模块。
2，在父工程里面，就会有一个modules的标签，
	modules其实就是聚合的体现，聚合子模块
	<modules>
        <module>maven_dao</module>
        <module>maven_service</module>
        <module>maven_controller</module>
        <module>maven_domain</module>
    </modules>
3，子工程会有一个parent标签，指定继承关系
	<parent>
        <artifactId>TestMaven</artifactId>
        <groupId>com.fff</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

4，子模块之间，进行对应的依赖注入
	<dependencies>
        <dependency>
            <groupId>com.fff</groupId>
            <artifactId>maven_dao</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.fff</groupId>
            <artifactId>maven_domain</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

package只是简单的打包
install 打包到本地仓库

如果是单独的模块，可以单独的打包
如果是父工程-子工程。则直接从父类打包
```



```

1，当ABCD四个依赖，相互依赖的时候，当你想去除其中某一个依赖，或者指定不包含某一个依赖
	<exclusions>
        <exclusion>
          <groupId>top.dayarch.demo</groupId>
          <artifactId>Project-B</artifactId>
        </exclusion>
      </exclusions>


2，
3，

```

```
依赖管理模型
scope的四个属性：test，runtime，complire，provied

A-->B-->C1
A-->B-->C2
1，优先按照路径长度进行依赖的选择，优先依赖路径短的依赖
2，如果路径长度一样，谁先声明，优先依赖谁

版本锁定
 <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.17</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
1，在父类POM文件，声明这个，那么在子类，可以不写版本号，


变量的声明
	<properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <spring-version>5.0.2.RELEASE</spring-version>
    </properties>
```



# Nexus私服

```

```




# WEB阶段面试题

## 1，什么是事务？事务的特性？mysql和oracle的事务隔离级别分别是什么

```
事务是数据库操作的最小单元，这个单元要么一起成功执行，要么一起未执行

事务的四大特性：
原子性：事务是数据库操作的最小单位，要么一起成功，要么一起失败
持久性：事务完成后，不会再倒退。数据的改变是永久的。
隔离性：多个事务之间的操作是相互隔离的，互不影响。
一致性：事务的执行是从一个一致性状态转变成另一个一致性的过程

Mysql是第三级事务：可重复读，可能将未提交的数据查询出来
Oracle是第二季事务：读已提交，事务成功提交后才可以被查询到

```

## 2，原生JDBC的开发流程

```
定义driver，url，username password
加载驱动类driver
通过三个参数获取连接，
定义sql
通过connection，获取发送sql的对象，
发送sql，获得结果集
封装结果集
释放资源

```

## 3，连接池的原理

```
连接池是一个存放连接的容器，当服务器启动的时候，连接池根据配置文件，创建空闲状态的连接数量，当需要使用连接的时候，直接去连接池获取，不用重新创建，当归还连接的时候，是直接归还到连接池，不是销毁。

当需要连接时，先判断

如果空闲连接池有连接，那么去空闲连接池获取最开始的连接，并从空闲连接池删除，

如果空闲连接池为空，那么再判断活动连接池的长度是否大于配置中的连接池最大数目，

如果小于，那么创建连接放在池里面，并且返回**

如果大于，那么判断最开始从空闲连接池里面获取的连接，判断他的存在时间，如果大于配置的存在时间，那么终止这个连接，将这个连接返回，
```

## 4，Statement和PreparedStatement有什么区别？哪个性能更好？

```
Statement是直接发送sql语句的，不能够预防sql注入攻击。
preparedstatement是预编译处理的发送，然后将参数按照顺序放进去，可以预防sql注入攻击。
Preparedstatement性能比较好

```

## 5，使用JdbcTemplate的开发流程

```
Jdbctemplate是spring框架的一个小部分
1，先导入依赖包
2，生成jdbc对象，但是需要提供一个DataSource的连接对象。
3，然后就可以使用它的方法了。

```

## 6，Xml解析的方式和原理

```
SAX：逐行加载进内存，只能够读取

DOM：将整个xml文件全部加载进内存，可以读取，也可以修改
```

## 7，悲观锁和乐观锁的原理以及优缺点

```
悲观锁：
当我们要对一条数据进行修改的时候，为了避免被其他人修改，最好的方法就是直接对该数据进行加锁，防止其他人修改，可以使用的是数据库本身自带的锁技术，也只有数据库自带的锁技术才能真正的保证数据访问的排他性
```

```
乐观锁：
假设认为数据一般情况下，不会造成冲突，所以在数据提示进行更新提交的时候，才会正式对数据的冲突与否进行检测，如果发现冲突了，则返回用户错误的信息，让用户决定如何去做，
一般的实现乐观锁的机制是，记录数据的版本，有两种方式，
1，使用版本号（在每条数据的后面添加版本号）
提交的时候先查询版本号，如果版本号已经被修改，则返回报错信息。然后从数据库获得最新的版本号，进行修改

提交版本，必须大于记录的版本，才能够执行

2，使用时间戳

```

```
CAS（check and set）：多个线程尝试使用乐观锁访问同一个变量的时候，只有一个线程能够更新这个变量的值，而其他线程都失败。失败的不会被挂起，而是被告知这次竞争中失败，请下次再竞争。
如果内存位置的值与预期原值匹配，那么处理器自动将该位置值更新为新值，否则不作任何操作。
```



```
优缺点：
1，功能限制，与悲观锁相比，乐观锁适用的场景有很多限制，乐观锁只能保证单个变量的原子性，当涉及到多个变量的时候，只能通过对整个代码块加锁来控制
2，竞争激烈的程度，如果悲观锁和乐观锁都可以使用，需要考虑竞争的激烈程度
当竞争不激烈的时候，出现并发冲突小的时候，乐观锁有优势，
当竞争激烈的时候，悲观锁更有优势。，因为乐观锁在执行更新时频繁失败，需要不断的重试，消耗系统资源


但是在高并发的时候，还是使用乐观锁居多
```

## 8，数据库的CRUD基本操作语句

```
Insert into user(username, password) values (‘111’, ‘2222’);
Delete from user where username=’111’
Update user set username = ‘1’, password = ‘2’ where id = ‘2’
Select * from user

```

## 9，说说servlet的生命周期

```
初始阶段：当用户的第一次请求到达服务器，会创建一个基于web的servlet容器，

运行阶段：然后创建一个servlet，只执行一次。调用service，每访问一次servlet，都会调用一次。

销毁阶段：当服务器关闭的时候，会进行销毁。Servlet由jvm虚拟机销毁
	
Servlet是线程不安全的，多线程运行，所以不应该定义成员变量。

```

## 10，post请求和get请求的区别

```
get：
没有请求体，请求的参数的发送全部体现在地址栏，而且会在历史记录里面保存
请求数据的编码格式只有url编码
Get用于信息的获取，是安全和幂等的。
Get请求提交的数据根据浏览器不同，大小有限制

post：
有请求体，数据全部放在请求体内部，不会体现在历史记录里面
请求数据的编码格式可以自己自定义
Post可能会修改服务器资源
Post请求数据放在请求体里面，没有大小限制

```

## 11，转发和重定向的区别  

```
转发：
转发是一次请求，访问资源，会被拦截器拦截一次
转发可以访问WEB-INF下的受保护的资源
转发不会改变浏览器的URL
请求之间可以共享数据
只能够访问浏览器内部

重定向
重定向是两次请求，才能访问到资源，会被拦截器拦截两次
重定向不可以直接访问受保护的资源，
重定向会改变浏览器的URL
因为是两次请求，所以不可以共享数据
只可以访问浏览器内部不受保护的资源，可以访问服务器外部资源

```

## 12，request和response对象的常用api

```
request.getparamter获取请求的数据

request.getparamterMap()获取请求的参数

request.getparamterValues()获取请求的数组

request.getdispacher..forword请求转发

request.setcharsetEncoding设置请求的数据格式

request.getHeader获取指定的请求头

request.setattribute()设置参数

request.getattribute()获取参数

request.getsession()获取session

request..getcooke获取cookie

 

response.getwritter获取输出流

response.senddirect响应转发

response.setconenttype设置输出的格式

response.setcontent-disposition告诉客户端以什么格式打开
```

## 13，cookie的生命周期，cookie何时创建何时销毁，cookie的类别

```
初始化：当在一次会话的时候，new一个cookie的时候，，
销毁：默认清情况下，会话结束，cookie就销毁，但是可以设置存活期，时间到了才会销毁

```

## 14，session的生命周期，何时创建，何时销毁，session销毁的有哪几种方式

```
初始化：request.getsession的时候创建
销毁：默认30分钟销毁，也可以设置存活时间。服务器正常关闭会冻化在本地

1，服务器的销毁可以调用invitation的方法，
2，默认30分钟到了，或者设置的时间到了
3，设置默认的失效时间
4，服务器非正常的关闭

```

## 15，session和cookie有什么区别

```
session：session是基于cookie实现的
session是服务器的会话技术，保存在服务器
保存在服务器没有大小要求，
保存的数据一般都是保密数据
cookie：cookie是基于请求和响应的头实现的。
Cookie是客户端的会话技术，保存在客户端
Cookie对大小和域名有大小要求
保存的一般都是非隐私数据

```

## 16， jsp的内置对象有哪些，域对象有哪些，有什么特性

```
九个内置对象：
Request：请求对象
Response：响应对象
Page：当前页面的对象，类似this，
Out：输出到页面
Config：读取本地的配置文件
Exception：异常对象
Session
Application
Pagecontext

四个域对象
pagecontext：当前页面共享数据，可以获取其他的对象
session：一次会话的多个请求
request：一次请求的数据共享
application：多个用户间共享数据

```

## 17，filter和servlet的区别是什么

```
Filter
在web启动时就会初始化
是一个web应用拦截器，在web应用中可以配置多个，
不能够处理请求，只能根据拦截要求，进行拦截处理

Servlet
在用户请求到达服务器的时候才初始化
是web用来接收处理请求并且返回响应的，也可以配置多个
主要作用就是接收请求，处理数据，返回数据

```

## 18，servlet与jsp的区别?

```
Servlet是服务端的程序，JSP是服务器页面程序，

Jsp本质是一个servlet，但是可以在jsp中书写java代码，

```

## 19，javaweb各种乱码的解决方案

```
get请求乱码，更换tomcat8，或者将数据进行编码的转换，将ISO8859-1转为字节码，再转化为UTF-8编码
post请求乱码，设置过滤器

```

## 20，说说你对mvc开发模式的理解，有何优缺点

```
Model：负责对数据的处理，包括业务层和持久层。同时返回目标数据。
View：负责对目标数据的渲染，和处理服务器返回的响应，
Controller： 负责协调model和view，负责处理委托，处理数据。

为什么要使用MVC？
MVC是一种将业务层持久层的数据，和视图层强制隔离的设计方法，这种好处是毋庸置疑的。
在MVC中，多个视图 可以共用一个视图管理器，不管你想要一个什么样的东西，控制器都可以处理。
Model层返回的数据可以被控制器转成各种数据，返回给页面渲染。同时如果要对数据库相关进行更改，只需要修改model层的代码，不需要修改其它层的数据。
运用了MVC设计方法的程序，三层的代码是相互独立的，改变其中一个不会影响其他的两个，使用这种方法的代码耦合度很低。

```

## 21，手写一个单例模式代码

```
饿汉式：


```

```
懒汉式：
```

## 22，内连接和外连接的区别

```

```

## 23，SELECT、FROM 、WHERE 、GROUP BY 、HAVING 、ORDER BY 这几个关键词的  执行先后顺序

```
	FROM先选择查找哪个表，
	Where 过滤查找条件
	Group by：将过滤完的数据进行分组
	Having：将分组完的数据，再进行过滤
	Order by：再按照顺序进行排序

```

## 24，Json的数据格式

```
第一种，key-value的数据形式
第二种，花括号的对象表现 
第三种，中括号数组的表现，以及数组对象 符合的表现

```

## 25，说说前后台怎么进行交互的

```

```

## 26，JavaScript的数据类型有哪些？

```
Number数字
String
Boolean
Null
Undefined
Object
arrary数组

```

## 27，说出Jquery的常用选择器

```
标签选择器
Id选择器
类选择器
并集选择器，获得多个选择器的元素
属性选择器
子选择器
后代选择器
可用和不可用选择器
两种选中选择器

```

## 28，说说你对ajax的理解。说说异步和同步的区别

```
Ajax是一种异步的请求方式，用来客户端和服务器的相互通信。

无需加载整个页面，创建动态网页的技术，

 

异步是分时

同步是
```

## 29，说说redis是什么？以及它的数据类型有哪些？以及应用场景？**

```
Redis是非关系型数据库，数据之间没有关系，只是以key-value的形式将对应的数据结构存放在内存里面，主要是为了解决高并发等问题，默认端口是6379**

Redis的优势：读取速度非常快，因为是放在内存上，最终的数据会持久化到硬盘上

String，List，Set，Zset，Hashmap

1，String用来存放json，list可以用来存放分类信息**

2，速度快的原因可以用来处理高并发数据，直接存放在Redis里面，不用去本地数据库获取**

3，可以支持大量数据的读写。*
```

## 30，说说你对servlet的理解

```
Servlet是javaweb用来处理请求和响应，和前端进行交互的网络模块，

默认有五个方法，
init方法是在容器启动时被容器调用，且只会被调用一次；
getServletConfig方法用于获取ServletConfig；
service方法用于处理一个具体的请求
getServletInfo方法用于获取Servlet相关的信息：版权等。
destroy方法用来销毁一个Servlet，和init一样，只会被调用一次，一般在服务器关闭时用于释放一些资源。

```

## 31，说说js的常用事件

```
点击事件

焦点事件，失去焦点，获得焦点

鼠标移动事件

鼠标按下事件
```

## 32，说说你对maven的理解

```
Maven项目管理工具，包含项目生命周期管理 和 依赖管理

依赖管理就是对jar包的管理，安装的时候会在本地构建一个仓库，在项目中导入包的时候，如果本地没有jar包，则去maven中央仓库上下载，保证项目正常运行。

项目生命周期管理就是项目的编译，测试，打包，安装，清除，发布
```

## 33，Java web过滤器的生命周期 

```

```

## 34，ThreadLocal？应用场景？ 

```

```























