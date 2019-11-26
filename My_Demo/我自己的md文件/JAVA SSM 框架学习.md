# Mybatis
## 框架的定义

```
框架是对重复代码的封装，也是对复杂问题的封装。重复代码是类似于 连接关闭，获取sqlsession等

优势：可以提高开发的效率，由于已经封装了很多东西，开发者不需要再去继续开发这一部分，可以将自己的时间放在开发其他的东西上
劣势：因为每次运行都是运行很多代码的，所以会降低运行的效率
```

## orm思想

```
采用object relational mapping，对jdbc进行封装，
ORM：object relational mapping 对象关系映射

简单的说：就是把数据库表和实体类的属性联系起来，让我们可以操作实体类。
```

##  关系型数据库

```
关系型数据：一对多，一对一，多对多，三种类型的关系型数据，不仅仅可以保存数据，还可以保存数据之间的关系

关系模型：数据存储的数据结构（二叉树，B+数），操作指令集合SQL语句，完整性约束（表内数据 和 表于表之间的约束）
```

## mybatis的入门

```
执行原理：通过配置文件，将要执行的东西全部配置起来。在CUD操作的时候，通过namespace和id找到，statement，并执行，然后封装结果集。
```

	解析主配置文件 和 映射配置文件，构建一个SqlSessionFactory，获得数据库连接数据，接口映射文件的地址，实体类别名等等
	创建工厂使用了构建者模式，主要是把对象的创建细节隐藏
	SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
	SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
	使用工厂生产SqlSession对象，生产sqlSession使用了工厂模式，降低类之间的依赖（这里如何理解）
	SqlSession对象里面包含数据库的链接 connection，以及sql语句
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	sqlSession第一种操作方式：
	使用namespace 和 id的组合，找到映射配置文件中的statement，执行操作
	List<User> list = sqlSession.selectList("com.bianyiit.dao.IUserDao.findAll");
		
	sqlSession第二种操作方式：
	使用SqlSession创建Dao接口的代理对象，创建dao接口的时候，使用了代理模式，不修改源码的基础上，对已有的方法进行增强
	IPeopleDao peopleDao = sqlSession.getMapper(IPeopleDao.class);
	使用代理对象执行方法，
	List<People> peopleList = peopleDao.findAllDao();
	
	释放资源
	sqlSession.close();
	inputStream.close(); 
	
	结果集封装
	1，当数据库的字段，实体类的属性名称一致，mybatis自动的封装
	2，resultMap可以设置返回类型，



	3，mybatis的主配置文件
		1，实体类的别名
			<typeAliases>
				可以以类名来代替全限定类名的书写，不区分大小写
	        	<package name="com.fff.domain"></package>
			</typeAliases>
			
			<typeAliases>
				对每一个类都使用别名代替，不区分大小写
	        	<typeAlias type="com.fff.domain.User" alias="user"></typeAlias>
			</typeAliases>
		2，<properties resource="jdbc.properties"></properties>
			加载外置配置文件
		
		3，<transactionManager type="JDBC"></transactionManager>
		连接池概念：一种用来存储数据库连接的容器
			创建：项目启动的时候，直接读取配置文件，创建响应数量的空闲数据库连接
			使用：直接去连接池里面获取
			归还：.close不会销毁，而是直接归还
			
			作用：
			特点：1，拥有队列的特点，先进先出。按照顺序获取。2
	
		<mappers>
	    	<!--        指定文件位置		-->
			dao接口的映射配置文件
	    	<mapper resource="IUserDao.xml"/>
		</mappers>
		
		--property
		-settings（全局配置参数）
			--setting
		-typeHandlers（类型处理器）
		-objectFactory（对象工厂）
		-plugins（插件）
		-environments（环境集合属性对象）
			--environment（环境子属性对象）
				---transactionManager（事务管理）
				---dataSource（数据源）
		-mappers （映射器）
			--package

6，mybatis的CRUD

7，mybatis的事务
	mybatis的事务会自动的开始，但是不会自动的提交，需要自己 sqlsession.commite();

8，自定义Mybatis分析
	mybatis在使用代理dao的方式，实现增删改查的时候，
		一：
		1，创建代理对象。
		2，在代理对象中，调用，selectAllDao
		
		二：
		property	里面的driver，url，username，password，可以获得connaction
		mapper		映射配置信息，com/feijm/dao/IPeopleDao.xml
		mapper		可以执行的sql语句，sql语句，就可以获取 preparedStatement。namespace是全限定类名
	
		三个东西结合在一起，读取配置文件。用到的技术就是解析xml的技术。
		此处使用dom4j解析xml，
	
		三：
		1，根据配置文件的信息，创建connection对象，注册驱动，获取连接
		2，获取预处理对象，preparedStatement 此时需要SQL语句，com.preparedStatement(sql)
		3，执行查询	ResultSet resultset = preparedStatement.executeQuery()
		4，遍历的结果用于封装，
			List<T> list = new Arrary<T>();	
			while(resultSet.next()){}
			将resultSet的数据封装在一个List对象中（在写SQL语句的时候，定义了对象的全限定类名。resultType="对象的全限定类名，用于反射对象的class，并且newInstance()"）
			所以对象名字 必须和 数据库的列名相同
		5，返回list集合
		
		四，第三部想要执行，必须给方法提供两个信息
		第一个，连接信息
		第二个，映射信息，包含 执行的sql语句 和 封装结果的实体类全限定类名
			可以把包含的这两个属性，封装一个对象-------->mapper
		String(key)					Mapper(value)
		com.feijm.dao.IpeopleDao	String sql
		.findAllDao					String domainClassPath
		
		五，创建代理对象
		IPeopleDao peopleDao = sqlSession.getMapper(IPeopleDao.class);
		
		根据Dao接口的字节码，创建Dao的代理对象
		public <T> getMapper(Class<T> daoInterfaceClass){
			类加载器：他使用的和被代理对象是相同的类加载器
			代理对象实现的接口：和被代理的对象实现相同的接口
			如何代理，他就是增强的方法，我们需要自己提供。
				此处是一个，InvocationHandler的接口，我们需要写一个，该接口的实现类，在实现类中调用asList()方法，（指第三步）
			
			Proxy.newProxyInstance(类加载器，代理对象要实现的接口字节码数组，如何代理)
			
		}


	day09 xml配置
	day04 重写各种方法
	day10 注解配置


​		

# Spring （一站式，整个服务器都可以使用）

## spring对Bean的控制反转 和 依赖注入
```
创建Bean的三种方式

使用默认构造函数创建bean对象，如果此时类中没有默认构造函数，则创建失败

使用普通工厂的方法，创建对象（使用某个类中的方法创建对象，并存入spring容器。）
先模拟创建一个工厂类，写一个创建对象的方法，然后首先获得这个工厂类
<bean id="instanceFactory" class="com.fff.factory.InstanceFactory"></bean>
然后调用工厂类的方法，创建对象
<bean id="IUserService" factory-bean="instanceFactory" factory-method="getUserService"></bean>
		
3，使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
<bean id="IUserService" class="com.fff.factory.StaticFactory" factory-method="getUserService"></bean>
```

​	

## Bean的作用范围
```
bean标签的scope属性：sigleton，prototype，request，session，global-session 
sigleton：单例的
prototype：多例的
request：web应用的请求范围
session：web应用的会话范围
global-session：集群环境会话范围，当不是集群时，就是session
```

## bean对象的生命周期	
```
单例对象：
出生：当容器创建，XML文件解析完成，对象出生
死亡：容器销毁，死亡				ClassPathXmlApplicationContext。close()；
总结：生命周期和和容器一致
		
多例对象：
出生：当要使用对象时候，spring框架为我们创建
死亡：当对象长时间不用的时候，java的垃圾回收器回收
总结：
```

## Spring注解开发		@AliasFor别名

```
指定某一个类下的文件，里面有注解，在加载主配置文件的时候，就可以立即创建对象
<context:component-scan base-package="com.fff.dao"></context:component-scan>
<context:component-scan base-package="com.fff.service"></context:component-scan>
```

## @Autowired @Resource @Qualifier的区别

	@Resource(name = "userDao")  JDK提供可以的完成依赖注入，根据名字查找指定id的对象注入给这个属性
	他是和jdk版本相关的，jdk1.8之前可以使用，以后就不可以使用了。
	
	@Autowired
	1，根据注入类型到容器中查找对象，如果根据类型只找到一个对象，那么直接给这个对象赋值（默认根据类型进行注入）
	2，在spring容器里面如果找到多个同类型的对象，根据变量名去匹配，如果有和变量名称一致的，直接将这个对象赋值给属性
	3，如果找到了多个类型的对象，并且没有名称匹配的，直接报错
	
	@Qualifier 
	@Autowired注解在存在多个类型多个对象的时候，不够安全
	按照类中注入的基础上再按照名称注入，在给类成员变量注入时不能够单独的使用，但是在给方法注入的时候可以单独使用
	当有多个传入的参数时，根据传入指定的名称去匹配。@Qualifier("dataSource") DataSource dataSource
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	2，@component @controller @service @repository的区别，创建对象的注解
	相同：这些注解都是只能够对 自己写的类进行注解
	@component(value = "userDao")
	 
	3，@Scope singleton	prototype request session global-session
	指定对象的创建范围，
	
	4，@PostConstruct	@PreDetroy
	在构造函数创建之后执行

## spring整合junit
```
1，导入Junit的jar包
2，将junit的注解 替换成 spring提供的，@Runwith
3，告知spring的运行器，spring的容器是根据xml创建的还是配置类创建的，并说明位置

contextConfiguration
location：指定xml文件的位置，加上classpath关键字，表示在类路径下
classes：指定注解类所在的位置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class TestUserServiceSpring {
	    @Autowired
	    private IUserService userService;
	
	    @Test
	    public void findUserAllDaoTest() {
	
	        List<UserInfo> userInfoList = userService.findUserAllService();
	        for (UserInfo userInfo : userInfoList) {
	
	            System.out.println(userInfo);
	        }
	    }
	}

	@ContextConfiguration(location = "classpath:applicationContext.xml")
	
注意：当我们使用spring 5.x的版本的时候，Junit必须使用4.12及以上的版本·
```



## 转账的事务控制

```
1，事务的控制应该都是在业务层控制
2，需要使用ThreadLocal对象，把connection和当前线程绑定，从而使一个线程中只有一个能够控制事务的对象。
```



## Spring AOP编程（继承接口，使用JDK代理接口，如果是代理目标类，就会使用cjlb，可以在配置的时候配置）

```
AOP（面向切面编程 Aspect Oriented Programming），是函数式编程的一种衍生范型，
利用AOP可以对业务逻辑的各个部分进行隔离，从而使逻辑各个部分之间的耦合度降低。

作用：在程序运行期间，不修改源码对已有的方法进行增强。
优势：减少重复代码，提高开发效率，维护方便

AOP实现的方式：动态代理的技术（类似动态代理的方式：继承，动态代理，装饰者模式）
	proxy.newInstance()方法里面的invoke，

    <!--com.fff.service..*(..)  service包下面的所有的方法-->
```






	Spring相关的术语：
		1，Joinpoint：连接点，那些被拦截到的点，在spring中这些点是指方法，因为spring只支持方法类型的连接点
			会调用增强的方法，都是连接点，
			
		2，Pointcut：切入点，我们要对哪些Joinpoint进行拦截的定义
			会被增强的方法，都是切入点，哪些类哪些方法，就是切入点。   
			 <aop:pointcut id="pointcut1" expression="execution(* com.fff.service..*(..))"></aop:pointcut>
			
		3，Advice：通知、增强，拦截到Joinpoint之后所要做的事情就是通知
			整个invoke方法在执行，就是环绕通知	around
			在invoke执行前，就是前置通知		before
			在invoke执行后，就是后置通知		after-running
			出现异常执行的，就是异常通知		after-throwing
			在finally里面的，就是最终通知		after
		
		4，Introduction 引介：是一种特殊的通知
			在不修改代码的前提下，可以在运行期间，动态的为类添加一些方法或者Field
		
		5，Target 目标对象：代理的目标对象，被代理对象
		
		6，Weaving 织入：把增强应用到目标对象来创建新的代理对象的过程，		加入事务的支持的过程
		
		7，Proxy 代理：一个类被AOP织入增强后，就产生了一个结果代理类
		
		8，Aspect 切面：是切入点和通知引介的结合


## AOP 声明式事务

​	DataSourceTransactionManager jdbc,mybatis
​	
​	1，底层实现
​		PlarformTransactionManager:实现统一的接口，应对不同的事务方案
​		TransactionDefinition:定义事务的基本信息，
​			事务的传播行为
​			事务的隔离级别
​			事务的超时时间
​			事务的只读状态
​		Transactionstatus:获取事务运行郭晨中的状态

		<!-- 以方法为单位,指定方法应用什么事务属性
			isolation:隔离级别
			propagation:传播行为
			read-only:是否只读
			
			 REQUIRED：支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。 
			 SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行。 
			 MANDATORY：支持当前事务，如果当前没有事务，就抛出异常。 
			 REQUIRES_NEW：新建事务，如果当前存在事务，把当前事务挂起。 
			 NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。 
			 NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。 
			 NESTED：支持当前事务，如果当前事务存在，则执行一个嵌套事务，如果当前没有事务，就新建一个事务。 
	
		 -->
		<tx:method name="addUser" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false" />
		<tx:method name="deleteUser" propagation="REQUIRED" read-only="false" />
		<tx:method name="updateUser" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false" />
		<tx:method name="queryUser" propagation="SUPPORTS" read-only="true" />
		
		<tx:method name="modify*" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false" />
		<tx:method name="remove*" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false" />
		<tx:method name="get*" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="true" />
		<tx:method name="find*" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="true" />

# Spring Mvc框架：基于组件方式执行流程

```
1，spring mvc 和 Struts2的优劣分析
共同点：
都是表现成框架，都是基于MVC框架，底层都是ServletAPI，处理请求的机制是一个核心控制器
区别：
SpringMvc 的入口是 Servlet，而 Struts2 的入口是 Filter
SpringMvc 是基于方法设计的，请求转发的时候，被转发的controller都是单例的，因为类是被spring所管理的，一个类中含有多个方法
而 Struts2 是基于类设计的，Struts2 每次执行都会创建一个动作类，是多例的，
所以 SpringMvc 的效率会比 Struts2 快
SpringMvc 的使用更加简洁，而且支持 JSR303（ JSR 是 Java Specification Requests 的缩写，意思是 Java 规范提案，
他规定了很多常用的校验注解，我们可以将这些注解加在我们 JavaBean 的属性上面，我们就可以在需要校验的时候进行校验了）
处理 ajax 的请求更加方便
Struts2 的 OGNL 表达式，使页面的开发效率相比 SpringMVC 更高些，但执行效率并没有比 JSTL 提升，尤其是 Struts2 的表单标签，远没有 Html 执行效率高
```



	4，资源放在 WEB-INF 的原因
		WEB-INF中的资源浏览器不能够直接访问，受保护的目录。
	
	2，入门程序
		1，选择Maven-archetype-webapp点击创建
		2，archetypeCatalog		internal



​			

​	
```xml
<!--配置自定义类型转换器-->
	    <bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
	        <property name="converters">
	            <set>
	                <bean class="com.fff.util.StringToDateConverter"/>
	            </set>
	        </property>
	    </bean>
```


​		    <!--开启SpringMvc框架的注解支持-->
​		    <mvc:annotation-driven conversion-service="conversionService"/>
​			自动加载 RequestMappingHandlerMapping 处理映射器，和 RequestMappingHandlerAdapter（处理适配器）
​			属性是加载，自定义类型转换器


	3，执行流程
		1，项目启动，启动服务器，加载配置文件
			第一，DispatcherServlet 前端控制器 对象创建，前端控制器本质上是一个BaseServlet
		
			第二，springmvc.xml 文件加载
	
			第三，包扫描的存在，所有的 Controller 类对象创建
			
			第四，SpringMvc的三大件，会被创建，HandlerMapping 处理器映射器，HandlAdapter 处理器适配器，InternalResourceViewResolver 视图解析器对象 创建
	
		2，发送请求，后台处理请求		####################################################################
			超链接点击：<a href="/hello">12112</a>发送请求至 DispatcherServlet


​			
​			DispatcherServlet--->进行视图的解析--->解析往success.jsp--->返回页面结果
​	
​	4，DispatcherServlet	 前端控制器
​		用户请求到达前端控制器，是整个流程控制的中心，由他调用其他组件，处理用户的请求，他的存在降低了耦合性
​		
​	5，HandlerMapping 处理器映射器
​		根据用户请求找到 Handler，也就是对应的处理器，为springMvc提供不同的映射器，实现不同的映射方式，如配置文件方式，实现接口方式，注解方式。
​		
​		在项目启动的时候，Controller对象创建时，把Controller中的所有的请求方法保存到这里，以类似map的结构存储。可以使请求更加快速的找到对应的方法，
​		比反射更快。


​	
​	6，Handler：适配器
​		是开发中要编写的具体业务控制器，由 DispatcherServlet 把用户请求转发到这里，由 Handler 对具体的用户请求进行处理
​		
​		是真正处理请求的方法，
​	
​	7，HandlAdapter：处理器适配器，会将 Controller 的类转成适配器
​		通过  HandlAdapter 对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行
​	
​	8，View Resolver 视图解析器
​		负责将处理结果，生成 View 视图，首先根据逻辑视图名称解析成物理视图名称，即具体的页面地址，再生成View视图对象，最后对 View 进行渲染将处理结果
​		通过页面展示给用户。
​		
​	9，View 视图
​		进行渲染，


​	
​	10，RequestMapping注解：用于建立请求 URL 和 处理请求方法之间的对应关系
​		@Target({ElementType.METHOD, ElementType.TYPE})
​		@Retention(RetentionPolicy.RUNTIME)
​		@Documented
​		@Mapping
​		public @interface RequestMapping {
​		}
​		
​		/user/hello
​		放在类上的话可以声明一级目录
​		
​		value：用于指定请求的 url，与 path 的作用一致
​		method：用于指定请求的方式			method = {RequestMethod.POST}
​		parms：用于指定限定请求参数的条件，要求请求参数的 key value 必须和配置的一模一样
​				parms = {"accountName=heihei"}，表示请求参数必须有 accountName，并且参数必须为heihei
​				parms = {money!100}，表示请求参数的money 不能是 100
​		headers：用于指定限制请求消息头 的条件		headers={"Accept"}必须包含这个请求头
​		
​		参与大于等于2个时，关系是与的关系
​	
​	11，请求参数的绑定（Spring MVC会自动的将String类型，转化为Integer类型）
​		1，绑定的机制
​			username=hehe&password=123
​			sayHello(String username, String password)
​			1，表单提交的数据都是key-value形式的，
​			2，SpringMVC参数绑定的过程，是把表单的数据 作为控制器方法参数进行绑定的
​			3，表单的value参数 和 方法参数名称一致
​		
​		<input type="text" name="username">（account）
​		<input type="text" name="password">（account）
​		<input type="text" name="age">（account）
​		<input type="text" name="user.uname">（user）
​		<input type="text" name="user.password">（user）
​		以account对象接受
​	
​		当处于1对多的时候，	private List<User> userList
​		第一次使用当 userList[0].uname接受
​		第二个使用当 userList[1].uname接受

​	12，配置过滤器，解决中文乱码
​		过滤器执行在dispatcherservlet之前
​	
​		<filter>
​	        <filter-name>characterEncodingFilter</filter-name>
​	        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
​	        <init-param>
​	            <param-name>encoding</param-name>
​	            <param-value>UTF-8</param-value>
​	        </init-param>
​		</filter>
​	    <filter-mapping>
​	        <filter-name>characterEncodingFilter</filter-name>
​	        <url-pattern>/*</url-pattern>
​	    </filter-mapping>
​	13，map集合，list集合的对象的封装
​		<form action="/param/saveUser" method="post">
​			<input type="text" name="list[0].uname">
​			<input type="text" name="list[0].password">
​			<input type="text" name="map['one'].uname">
​			<input type="text" name="map['one'].password">
​		</form>
​	14，自定义类型转换器
​		String-------------------Date
​		
​		public class StringToDateConverter implements Converter<String, Date> {
​		    /**
​		     * @return
​		     * @Author
​		     * @Description
​		     * @Date 2019/10/24 19:19
​		     * @Param
​		     **/
​		    @Override
​		    public Date convert(String inputStr) {
​		        if (inputStr == null || inputStr.length() == 0|| "".equals(inputStr)){
​		            throw new RuntimeException("数据为空，请传入数据");
​		        }
​		        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
​		        try {
​		            return dateFormat.parse(inputStr);
​		
​		        } catch (ParseException e) {
​		            throw new RuntimeException("数据类型异常转换出错");
​		        }
​		    }
​		}
​		
​		<!--配置自定义类型转换器-->
​	    <bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
​	        <property name="converters">
​	            <set>
​	                <bean class="com.fff.util.StringToDateConverter"/>
​	            </set>
​	        </property>
​	    </bean>
​		
​		<!--开启SpringMvc框架的注解支持-->
​		<mvc:annotation-driven conversion-service="conversionService"/>
​	
​	15，原生Servlet的使用
​		@RequestMapping(path = "/testServlet")
​	    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
​	        String parameter = request.getParameter("11");
​	        System.out.println(parameter);
​	        return parameter;
​	    }
​	

	16，RequestParam：把请求中指定名称的参数 给控制器中的形参赋值
		假如页面数据的name名称和实体类中的属性名称对应不上，就可以利用这个方法进行封装
		value：请求参数中的名称
		required：请求参数中是否必须提供此参数，默认就是true
		
		@RequestMapping(path = "/testServlet")
	    public String testRequestParam(@RequestParam(value = "name", required = true) String username) {
	
	        System.out.println(username);
	        return username;
	    }
		
	17，RequestBody：
			获取请求体的全部参数内容，直接获得的是key=value&key=value...结构的内容，，，get方式不适用	
			required：请求参数中是否必须提供此参数，默认就是true。
					当取值为true的时候，get请求方式为true，如果取值为false，get请求得到的是null
			@RequestMapping(path = "/testServlet")
		    public String testRequestBody(@RequestBody String body) {
		
		        System.out.println(body);
		        return body;
		    }


​			
​			
​	18，PathVaribale：用于绑定Url中的占位符，例如请求中的，/delete/{id}，这个{id}就是占位符
​					url 支持占位符是spring3.0以后引入的，是springMvc支持rest风格URL的一个重要的标志
​		属性：
​			value：用于指定url中的占位符
​			rrequired：是否必须提供占位符
​		
​		<a href="/testPathVariable/100">testPathVariable</a>
​		@RequestMapping(path = "/testPathVariable/{sid}")
​	    public String testPathVariable(@PathVariable(value = "sid") String id) {
​	
​	        System.out.println(id);
​	        return id;
​	    }
​		
​	19，HiddentHttpMethodFilter
​		作用：html页面只支持post和get请求，delete和put方式不支持，Spring3.0添加了一个过滤器，可以修改浏览器请求方式
​		使用：
​		1，在web.xml中配置该过滤器
​		2，请求方式必须post
​		3，按照要求提供_method请求参数，该参数的取值就是我们需要的请求方式
​	
​	20，RequestHeader
​		作用：用于获取请求消息头
​		属性：value，提供消息头名称，，，，required：是否必须含有此消息头
​	
​	21，cookievalue
​		作用：用于把指定cookie名称的值，传入控制器方法参数
​		属性：value，指定cookie的名称，，，，required：是否必须含有此cookie
​	
​	22，ModelAttribute
​		作用：springMvc4.3引入的，可以修饰方法和参数
​			方法上：当前方法会在控制器方法前执行。可以修饰没有返回值的方法，也可以修饰有返回值的方法
​			参数上：获取指定的数据给参数赋值
​		属性：value：用于获取数据的key，key可以是POJO的属性名称，也可以是Map结构的key
​	
​	23，SessionAttribute
​		作用：用于多次执行控制器方法间的参数共享
​		属性：value：用于指定存入的属性名称，，，type：用于指定存入的数据类型
​	
​		modelMap  get方法，获取session中的数据
​		sessionStatus	setComplete（）销毁session中，所有的数据，等本次请求完成后，才会销毁

https://www.baidu.com/s?ie=UTF-8&wd=%E5%B4%A9%E5%9D%8F%E5%AE%B6%E6%97%8F
https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=I%E7%A4%BE&oq=ai%25E5%25B0%2591%25E5%25A5%25B3&rsv_pq=b89a7c6100155045&rsv_t=7b5bIMCD9WGzeAuXjAD6GismyHUQXcLBKm%2FefCH6uBhJ%2BG3ogODeThjD2bY&rqlang=cn&rsv_enter=1&rsv_dl=tb&rsv_sug3=5&rsv_sug1=3&rsv_sug7=100&rsv_sug2=0&inputT=1494&rsv_sug4=1495
https://www.baidu.com/s?ie=UTF-8&wd=ai%E5%B0%91%E5%A5%B3
https://www.kanzhun.com/

	24，controller返回字符串，或者返回void


	30，文件上传————Spring案例
		1，在springmvc.xml，先配置一个文件解析器


	32，异常处理器
		
	33，拦截器
		1，拦截器链：将拦截器按照一定的顺序，连接成一条链。在访问被拦截的方法或者字段的时候，拦截器链中的拦截器就会按照之前定义的顺序被调用。
		
		拦截器和过滤器的区别：
		过滤器：是servlet规范的一部分，任何Javaweb都可以使用。。在url-pattern中配置了 /* 之后，可以对所有的资源进行拦截。
		过滤器：由spring Mvc框架提供，只能在springmvc框架中使用，只会拦截访问的控制器方法，如果访问的是jsp，html，css，image或者js 是不会进行拦截的。
		
		拦截器必须实现 HanlerInterceptor接口
	
		2，编写拦截器的类
		3，
	
	34：ruslt for

```
转发 重定向
return  "forward:/product/findAll";
return  "redirect:findAll";
return  "redirect:/product/findAll";
```



# Swagger 的学习

```

```





# SSM面试问题收集

# SSM面试问题收集

# SSM面试问题收集

# SSM面试问题收集

# SSM面试问题收集

# 1，简单介绍Spring 的IOC

```
IOC：将项目中的所有创建对象都交给Spring IOC容器管理，IOC容器在web运行时，加载配置文件或者注解，通过反射创建对象，往IOC容器里面存放。需要的时候再去IOC容器里面获取，减少层与层之间的耦合。
经常在一个类里面需要调用其他对象，经常new对象调用的话，两个类之间一定会存在耦合，

控制反转：将框架中的所有的创建对象，都交给spring管理，在Spring中有三种注解创建对象的方式，一种是通过工厂类的方式创建，一种是通过构造方法创建，一种是通过对象的set方法创建。注解的话也可以，则是直接通过@Controller @Repository @component @service

依赖注入：在创建对象的时候，将对象需要依赖的属性，也就是参数注入进去。例如创建实体类的时候没需要数据库表的字段，创建jdbctemplate的时候需要DataSource，创建service的时候，需要dao对象等等。配置文件的的话，可以使用property。注解直接使用autowired，或者qulifire，或者Resource，value获取配置文件。

```

## 1-1、SpringIOC容器 applicationConetext 是如何创建的

```
Map结构的IOC容器

手动加载spring容器的三个加载方式，
ClassPathXmlApplicationContext:只能从类路径加载文件
FileSystemXmlApplicationContext:可以加载任意路径下的文件，必须有访问权限
AnnotationConfigApplicationContext:用于读取注解创建容器


```

## 1-2、Autowired和qulifire使用的区别

```
@Autowired @Resource @Qualifier的区别
	@Resource(name = "userDao")  JDK提供可以的完成依赖注入，根据名字查找指定id的对象注入给这个属性
		他是和jdk版本相关的，jdk1.8之前可以使用，以后就不可以使用了。
	@Autowired
		1，根据注入类型到容器中查找对象，如果根据类型只找到一个对象，那么直接给这个对象赋值（默认根据类型进行注入）
		2，在spring容器里面如果找到多个同类型的对象，根据变量名去匹配，如果有和变量名称一致的，直接将这个对象赋值给属性
		3，如果找到了多个类型的对象，并且没有名称匹配的，直接报错
	@Qualifier 
		@Autowired注解在存在多个类型多个对象的时候，不够安全
		按照类中注入的基础上再按照名称注入，在给类成员变量注入时不能够单独的使用，但是在给方法注入的时候可以单独使用
		
		当有多个传入的参数时，根据传入指定的名称去匹配。@Qualifier("dataSource") DataSource dataSource
		@Bean("jdbcTemplate")
	    public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }
```

## 1-3、Autowired和Resource使用的区别

```

```

## 1-4、纯注解的使用

```

```

## 1-5、Bean对象创建方式，及描述生命周期，

```

```

## 1-6、SpringIOC的使用，需要配置哪些操作。或者有哪些其他的增强操作。

```
1，必须配置包扫描，否则容器在创建的时候
```

## Spring的Autowired实现原理

```

```



# 2，简单介绍Spring的AOP

```
Spring的AOP是面向切面编程，主要实现原理是动态代理，可以对重复代码进行
抽取，单独编写功能代码。可以实现对业务逻辑的各个部分进行隔离，在运行的时候动态的植入切面代码，使业务逻辑之间的耦合度降低。

```

```
AOP声明式事务：前置通知，后置通知，异常通知，最终通知，环绕通知
切入点（指定方法的拦截路径）：execution(* com.fff.service..*(..))

```

## 2-1、事务的注解配置和配置文件配置

```
配置文件：
注解：

```

## 2-2、设置事务的基本信息  

```

```

## 2-3、ThredLocal本地线程

```

```

## 2-4、引介

```

```



# 3、简单介绍MVC

```

```

## 3-1、springmvc的工作原理

```

```

## 3-2、springmvc接受请求参数的常见方式有哪几种

```

```



## 3-3、简单说明文件的上传和下载

```

```

# 4、简单介绍Mybatis

```

```

## 4-1、简单介绍mybatis的缓存分类，及实现方法

```
一级缓存：一级缓存放在sqlsession里面，会将参数和值以键值对的形式存放在内存里面，当你请求第二次的时候，会先去内存里面查找是否有这个键，
	1，当进行增删改的时候会清除缓存里面的信息
	2，sqlSession.clearCache()，会在执行清除缓存方法的时候
	3，会在事务提交的时候清除缓存
	4，当sqlsession关闭的时候
二级缓存：mapper级别的缓存，存放在sqlsession工厂中，在每一次事务提交的时候才会提交到二次缓存里面，查找也一样，
```

## 4-2、简单介绍mybatis框架的优势

```
1，基于sql编程，同时sql语句可以写在XML文件中，相当灵活，不会对现有的程序设计产生任何影响，XML配置SQL也可以解除代码间的耦合，
2，和JDBC相比，减少了很多代码，比如获得链接，封装结果集等
3，封装了JDBC底层，可以很好的兼容各种数据库。
4，半自动的映射，不用自己手动的去封装结果集
```

## 4-3、在MyBatis开发中，通常一个Xml映射文件，都会写一个Dao接口与之对应，请问这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗？

```

```

## 4-4、mybatis的事务操作

```

```

## 4-5、mybatis #{} ${}的区别

```
1，#{} 是预编译处理，在处理的时候会编译成问号，调用 PreparedStatement 的 set 方法进行赋值

2，${} 是字符串的替换，直接替换成变量的值
```

## 4-6、简单介绍mybatis的分页

```
物理分页：LIMIT 物理分页
逻辑分页：获得全部数据后，再截取
```

# 5，简单说明SSM的整合

```

```

## 5-1、为什么要进行SSM整合

```
主要是为了让springIOC容器可以管理整个框架的所有创建对象
```

## 5-2、为什么不使用springmvc的IOC容器保存框架的创建对象

```
1，Springmvc是一个web容器，如果由他管理他管理，会有耦合，而且管理混乱。
2，Mvc的容器和spring的容器本身在逻辑上就存在父子关系。子类可以访问父类的东西，所以没必要由mvc去管理所以的对象。

```

## 5-3、为什么SpringMVC里面的IOC容器可以访问，Spring容器里面的service对象？

```
SSM框架在加载的时候，由servletcontext监听器创建webapplicationcontext容器，保存在servletcontext里面。然后创建springmvc的时候，先获取spring创建的webapplication，然后初始化自己的webapplication容器，但是在初始化的时候，会将spring的父容器依赖注入进去，进行构建。

Mvc的容器在逻辑上，存在父子关系。子类可以访问父类的东西。
```

## 6，简单说明SSM框架常用的注解

```

```

## 7，简单说明项目开发流程

**能把web项目介绍清楚，主要先从整体介绍，然后分模块，最主要把业务流程说清楚。**

```

```







