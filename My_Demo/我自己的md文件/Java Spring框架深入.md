# SpringSecurity 

```
SSM复合工程
父打包方式为pom，子打包方式为jar，web为war包


```

## 权限控制——方法级别的权限控制

```
<error-page>
	<error-code>403</error-code>
    <location>/403.jsp</location>
</error-page>
报错就会跳转到这里。在web.xml里面配置

```



```
JS250注解
第一步:需要在spring-security.xn1中开启
    <security:g1obal -nethod-security jsr250- annotati ons-"enabled">
第二步:在指定的controller方法上使用
    @RequestMapping("/findA11.do")
    @RolesAllowed("ADMIN")
    public ModeLAndView findAllController throws Exception {}
第三步:必须在pon.xnl文件中导入
    <dependency>
        <groupId>jarax.annotation</groupId
        <artifactId>jsr250-api</artifactId>
        <version>1.0</version>
    </dependency>


@RolesAllowed("ADMIN")		允许某些权限可以访问方法（可以省略前缀）
@PermitAll					表示允许所有的角色进行访问，也就是说不进行权限控制
@DenyAll是和PermitAll相反的	 表示无论什么角色都不能访问

```

```
Secured注解的使用，由spring官方提供

1.开启使用
<security:global-method-security secured-annotations="enabled"/>
2.在指定的方法上使用
@RequestMapping("/findA1l.do")
@Secured("ROLE_ADMIN")
public ModelAndView findAll(@RequestParam(name="page", required=true)


注意：JS250注解可以省略ROLE_，但是secured注解不可以省略
```

```
基于表达式操作权限

第一步开启
<security:global-method-security pre-post-annotations-"enabled" />

第二步使用，可以使用SPEL表达式
@Requestlappine("/save. do")
@PreAuthorize("authentication.principal.username=='tom" )
public String save (UserInfo userInfo) throws Exception (
    userService.save(userInfo);
    return "redirect:findAll.do";
}
@Recuestlappine("/findAll.do")
@Prehuthorize("hasRole( ROLB_ADMIN )")
public ModelAndView findA110 thrors Exception [
ModelAndVier w = ner Mode LAndVier():
List(UserInfo> userList = userService.findAll
mv.addobject("userList', userlist);
mw.setVienlase("user-list");


@PreAuthorize在方法调用之前,基于表达式的计算结果来限制对方法的访问
@PostAuthorize 允许方法调用，但是如果表达式计算结果为false,将抛出一一个安全性异常
@PostFilter允许方法调用，但必须按照表达式来过滤方法的结果
@PreFilter允许方法调用,但必须在进入方法之前过滤输入值


```

## 页面端的权限控制

```
第一步导入jar包
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-taglibs</artifactId>
    <version>version</version>
</dependency>
第二步在页面导入
<x@taglib uri-"http://www.springframework.org/security/tags" prefix="security"%>
第三步在页面上使用
authentication：可以获取当前正在操作的用户信息
authorize：用于控制页 面上某些标签是否可以显示

实际使用
如果是admin用户，才可以显示。如果不是则不显示。
<security :authorize access="hasRole(' ADMIN )">
    <a
        href="$ (pageContext. request. contextPath) /user/findA1l. do"> <i
        class="fa fa-circle-o"></i> 用户管理
    </a>
</secur ity:authorize>
修改spring-security.xml文件
<security:http auto-config="true" use-expressions="true">
<security:intercept-ur1 pattern="/**" access="hasAnyRole('ROLE_USER','ROLE_ADMIN')"/>
开启el表达式，use-expressions="true" 

```



spring AOP的实际使用

```

```



# Spring boot

## springboot的配置文件——application.properties

```
application.yml
application.yaml
application.properties

springboot默认会去加载resources目录下的配置文件，加载顺序是yml-->yaml-->properties，所以下层会覆盖上层的数据

yml：是一种直观的能够被电脑识别的数据序列化格式，并且容易被人类阅读，容易与脚本语言交互。
可以被支持YAML库的不同编程语言导入，比如：C/C++，Ruby，Python，Java，C#，PHP等。
YML是以数据为核心的，比传统的XML文件更加简洁。
```

```
yml文件的语法

1，配置普通文件格式
key: value（类似json）
# value前有一个空格

2，配置对象
object:
	key1: value1
	key2: value2
或者 object: {key1: value1, key2: value2}

3，配置数组，list/set集合的数据
key:
	- beijing
	- shanghai
	- hubei
或者 key: [beijing, shanghai, hubei]

key: 
	- name: zhangsan
	  age: 20
	  score: 100
	- name: lisi
	  age: 21
	  score: 90

```

## spring-boot-starter 场景启动器

springboot将各种场景，做成一个个starter，只需要在项目里面引入，就可以帮助我们导入依赖

## 配置文件的加载

```
1，@value
@value("${name}")
private string name;
@value("${person.addr}")
private string addr;


```

```
2，@configurationProperties(prefix = "person")
首先定义 属性
然后提供getset方法
然后在类上提供注解描述是哪个对象的映射，configurationProperties(prefix = "person")

默认是从全局配置文件中获取值
```

```
3，propertysource 使用在所有要使用该配置文件的类上

propertysource（value = classpath：person.properties）
执行加载某个配置文件

```

```
4，importResource，使用在主配置类上

导入spring的配置文件，让配置文件里面的内容重新生效

springboot里面没有spring的配置文件，diy的配置文件也不可以识别。

```

## springboot profile

```
1，多profile文件
	在主配置文件编写的时候，文件名：application-{profile}.properties/yml
	application-dev.properties		开发环境
	application-prod.properties		生产环境
	application.properties			临时环境（默认会加载这个）

2，多yml文件
	server:
	  port:8081
	spring:
	  profiles:
	    active:prod
	spring:
	  profiles:dev
	---
	server:
	  port:8082
	spring:
	  profiles:prod
	---
	server:
	  port:8083
	spring:
	  profiles:one
	
	yml文件的文件块模式，然后可以激活环境
	
	
3，指定激活某一个类型的配置
	配置文件：spring.profiles.active=dev
	运行中命令行模式：--spring.profiles.active=dev
	
	

```

## application.properties 的加载优先级

```
resources/prop目录下：
resources目录下：
src目录下
项目文件路径下

 优先级由高到低，高优先级的配置会覆盖低优先级的配置 	四个文件全部加载。
 
 但是是：互补配置
 
 
 spring.config.locatrion来改变加载哪个配置文件（可以以命令行模式启动）
 
 可以在项目打包后，通过修改配置文件，修改程序
```

```
外部配置加载顺序
SpringBoot也可以从以下位置加载配置；
优先级从高到低，高优先级的配置覆盖低优先级的配置，，，所有的配置会形成互补配置

1，命令行参数 java :jar spring-boot-02 config-02-0.0.1-SNAPSHOT.jar -server.port=8087
2.来自java:comp/env的JNDI属性
3.Java系统属性( System.getProperties())
4.操作系统环境变量
5.RandomValuePropertySource配置的random.*属性值
优先加载带properties的
6.Jar包外部application-{profile}.properties或application.yml(带spring.profile)配置文件
7.jar包内部application-{profile}.properties或application.yml(带spring.profile)配置文件

8.jar包外部application.properties或application.yml(不带spring profile)配置文件
9.jar包内部application.properties或application.yml(不带springprofile)配置文件
10.@Configuration注解类上的@PropertySource
11.通过SpringApplication.setDefaultProperties指定的默认属性


```

## springboot 日志框架

```
日志门面（日志的抽象层，都是接口）
JCL：jakarta commons logging
SLF4j（simple logging facade for java）
```

```
日志实现
log4j，jul（java.util.logging），log4j2，logback
```

```
在系统中使用sl4j

配置文件使用 sl4j 的配置文件

springboot集合日志框架
1，将系统中的其他日志框架排除
2，使用中间包替换原有的日志框架
3，导入sl4j日志实现

springboot底层使用的是，sl4j和logback
底层也有中间包，例如jul-to-slf4j，log4j-pver-slf4j，jcl-over-slf4j
调用slf4j.api
```

```
引入其他框架，移除掉默认的日志依赖

		<dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>commons-logging</groupId>
                    <artifactId>commons-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```

```
1，springboot默认日志的使用
日志的级别:
（1，在测试类中写下面的一段代码）
由低到高 trace < debug < info < warn < error
可以调整输出的日志级别:日志就只会在这个级别以以后的高级别生效
logger.trace("这是trace日志...");
logger.debug( "这是debug日志...");
SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别: root级别
默认只输出下面的三个
logger.info("这是info日志...");
logger.warn(“这是warn日志...");
logger.error("这是error日志...");

在application.properties里面可以设定日志的级别
logging.level.com.atguigu=trace

logging.file 和 logginf.path
1，都不指定，只在控制台输出
2，只指定 file ，输出日志到 my.log 文件
3，只指定 path ，输出到指定目录的 spring.log 文件

（2，在配置文件中写下面的一段）
#logging. poth=
#不指定路径在当前项目下生成springboot. log日志
#可以指定完整的路径:
#logging.file=G:/springboot.log.
#在当前磁盘的根路径下创建spring文件夹和里面的log文件夹:使用spring.log 作为默认文件
1ogging.path=/spring/1og
的在控制台输出的日志的格式
1ogging. pattern. console=%d{yyy-MM-dd HH:mn:ss.SSs} [%thread] %-51eve1 %1ogger{50} . %msg%n
#指定文件中 日志输出的格式
1ogging. pattern.file=%d{yyyy-MM-dd} === [%thread] === %-51evel_%logger{50} - %msg%n



```

## 自己DIY日志

```
1，只需要在 resources 下导入 logback.xml 文件
就会被 日志框架 直接识别

2，logback-spring.xml
可以设置被springboot框架识别，可以指定日志的等级，可以设置高级功能
测试模式还是生产模式



```

# springboot web开发

```
1，请求静态资源的文件
	/webjars/**的请求，可以直接请求到，所导入的类似jQuery资源（在maven导入）。
2，静态资源的存放文件夹
	classpath:/META-INF/resources/，在resources目录下再建一个
	classpath:/redources/，在resources目录下再建一个
	classpath:/static/
	classpath:/public/
	/:当前项目的根路径
	
webjars网站，引入页面的静态资源

3，首页的处理
	静态资源目录下的所有index.html页面，

4，配置的图标
	静态资源目录下的所有favicon.ico文件
	
可以在application.properties文件中设置
spring.resources.static-location=classpath:/public/
```

```
2，模板引擎
JSP其实也是模板引擎的一种，velocity，freemarwork，thymeleaf
将模板和动态的数据，组合成一个新的HTML页面

springboot 使用 thymeleaf
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
在properties下，修改thymeleaf主程序和layout程序的版本
<thymeleaf.version>3.0.9.RELEASE</thymeleaf.version>
<thymeleaf-layout-dialect.version>2.2.2</thymeleaf-layout-dialect.version>
        
thymeleaf的使用
默认是classpath:/templates/下
controller返回的时候，会拼接成classpath:/templates/success.html

使用：
1，<html lang="en" xmlns:th="http://www.thymeleaf.org">
2，<div th:text="${hello}"></div>
3，<div id="divId" th:id="${hello}" th:class="${hello}" th:text="${hello}"></div>
使用th+任意html属性，来替换原生属性的值

spring.thymeleaf.cache=false	可以关闭缓存
```

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/QQ%E6%88%AA%E5%9B%BE20191116180200.png)

```
<P style="color: red" th:text="${msg}" th:if="${not strings.isEmpty(msg)}"></p>
如果string不为空，那么才显示


```



```properties
Simple expressions:
    Variable Expressions: ${...}
    	1，获取属性
    	2，调用方法
    	3，使用内置的基本对象
    	#ctx : the context object.
        #vars: the context variables.
        #locale : the context locale.
        #request : (only in Web Contexts) the HttpServletRequest object.
        #response : (only in Web Contexts) the HttpServletResponse object.
        #session : (only in Web Contexts) the HttpSession object.
        #servletContext : (only in Web Contexts) the ServletContext object.
    Selection Variable Expressions: *{...}
    Message Expressions: #{...} 获取国际化内容
    Link URL Expressions: @{...}
    Fragment Expressions: ~{...}
Literals
Text literals: 'one text' , 'Another one!' ,…
Number literals: 0 , 34 , 3.0 , 12.3 ,…
Boolean literals: true , false
Null literal: null
Literal tokens: one , sometext , main ,…
Text operations:
String concatenation: +
Literal substitutions: |The name is ${name}|
Arithmetic operations:
Binary operators: + , - , * , / , %
Minus sign (unary operator): -
Boolean operations:
Binary operators: and , or
Boolean negation (unary operator): ! , not
Comparisons and equality:
Comparators: > , < , >= , <= ( gt , lt , ge , le )
Equality operators: == , != ( eq , ne )
Conditional operators:
If-then: (if) ? (then)
If-then-else: (if) ? (then) : (else)
Default: (value) ?: (defaultvalue)
Special tokens:
Page 17 of 106
No-Operation: _
```

## springboot 自动配置 springmvc

```
以下是SpringBoot对SpringMVC的默认开启配置:
1，Inclusion of ContentNegotlatingVlewResolver and BeanNameViewResolver beans.
自动配置了ViewResolver (视图解析器:根据方法的返回值得到视图对象( View) ,视图对象决定如何
渲染(转发?重定向? ) )
2，ContentNegotiatingViewResolver :组合所有的视图解析器的;
如何定制：我们可以自己给容器中添加一一个视图解析器;自动的将其组合进来;
3，Support for serving static resources, including support for WebJars (see below).
静态资源文件夹路径webjars
4，Static index.htal support. 静态首页访问
5，Custom Favicon support (see below), favicon.ico 
6，自动注册了of Converter，GenericConverter, Formatter beans.
Converter：转换器
Formatter：格式器
GenericConverter：

```

## springboot 默认配置的修改

```
1). SpringBoot在自动配置很多组件的时候,先看容器中有没有用户自己配置的( @Bean.
@Component )如果有就用用户配置的,如果没有,才自动配置;如果有些组件可以有多个( ViewResolver )将
用户配置的和自己默认的组合起来;
2).在SpringBoot中会有非常 多的xxConfigurer帮助我们进行扩展配置
3)、在SpringBoot中会有很多的xxxCustomizer帮助我们进行定制配置

```



## 扩展配置 springmvc

```
编写一个配置类(@Configuration) ，是WebMveConfigurerAdapter类型;不能标注@EnableWebMvc

@EnableWebMvc
@Configuration
public class MySpringMvc implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        请求是 hello2 会自动的跳转到 success
        registry.addViewController("/hello2").setViewName("/success");
    }
}

@EnableWebMvc的作用是自动配置，如果添加注解则不会自动加载springboot框架默认的配置

```

## springboot 国际化页面

1，编写国际化配置文件:
2，使用ResourceBundleMessageSource管理国际化资源文件
3，在页面使用fmtmessage取出国际化内容
步骤:
1，编写国际化配置文件,抽取页面需要显示的国际化信息

​	在resource下创建/i18n/login.properties，login_zh_CN.properties，login_en_US.properties

​	login.userName=xxxxx

2，SpringBoot自动配置好了管理国际化资源文件的组件

​	ResourceBundleMessageSource

3，去页面获取国际化的值

```html
input需要单独处理，其他直接使用thymeleaf
<input type=" checkbox"，value="remember-me"/> [[#{login. remember}]]
```
4，点击按钮实现国际化的处理

原理：国际化Locale (区域信息对象) ; LocaleResolver (获取区域信息对象) 

​		一般是直接从请求头中获取区域信息

5，自己写一个 LocaleResolver ，带参数向后台传递?的添加信息，由后台解析

```java
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolvelocale(HttpServletRequest request) {
        String 1 = request . getParameter( name: "1" );
        Locale locale = Locale. getDefault();
        if(!StringUtils. isEmpty(1)){
        	String[] split = 1.split( regex: " .");
        	locale = new Locale(split[0], split[1]);
    	}
    	return locale;
	}
}

```

6，自己写个config类，加载自己的 LocaleResolver 



7，拦截器进行拦截检查

```
1，实现HandlerInterceptor接口
从request中获取，处理
2，注册拦截器对象


```

8，公共html的抽取

```html
1，在需要抽取的元素上增加元素，topbar

2，在另一个html引入 topbar
<--模板名:会使用thymeleof的前后缀配置规则进行解析-->
<div th:insert= "~[dashboard: : topbar}"></div>

3，抽取的元素在div片段中
th:insert 将公共片段整个插入到指定元素中

引入方式
<div th:insert-"footer :: copy"></div>
<div th:replace-"footer :: copy"></div>
<div th:include-"footer :: copy"></div>
<div>
    <footer>
        &copy; 2011 The Good Thynes Virtual Grocery
    </footer>
</div>
<footer>
	&copy; 2011 The Good Thynes Virtual Grocery
</footer>
<div>
	&copy; 2011 The Good Thynes Virtual Grocery
</div>

```

```
高亮的选择
th:class="${activeUri=='emps' ? 'nav-link active':'nv-link'}"

<!--引入侧边栏-->
<div th:replace=" commons/bar: :#sidebar(activeUri='emps')"></div>

<!--引入sidebar-->
<div th:replace= "commons/bar: :#Sidebar(activeUri= " main. html')"></div>

<tbody>
    <tr th:each="emp:${emps}">
        <td th:text="${emp. id}"></td>
        <td>[[${emp. lastName}]]</td>
        <td th:text="${emp . email}"></td>
        <td th:text="${emp . gender}==0?'女*:男"></td>
        <td th:text="${ emp . department . departmentName}"></td>
        <td th:text="${emp. birth}"></td>
        <td th:text="${#dates . format (emp.birth, 'yy-MM-dd HH:mm')}">

    </tr>
</tbody>


```

## 错误处理机制

1，默认效果

​	浏览器访问，返回一个错误页面

​	其他模式访问，返回json数据

​	原理：可以参照ErrorMVCAutoConfiguration 错误处理的自动配置

2，定制错误页面

​	给容器中添加了以下组件

​	1，DefaultErrorAttributes 

​	2，BasicErrorController :处理默认/error请求

​	3，ErrorPageCustomizer :

```
@Value("${error.path:/error}")
private string path 。"/error"; 系统出现相误以后来到error请求进行处理 ; ( web. xml注册的错误页面
规则)

```



## 配置嵌入式servlet容器

```java
默认使用的是tomcat 8.5.27

1，定制servlet容器相关的配置，在配置文件中修改server相关的配置
server.xxx
server.tomcat.xxx

2，编写embeddedservletcontainerCustomizer：嵌入式servlet定制器
@Bearl
public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
    return new EmbeddedServletContainerCustomizer() {
    //定制嵌入式的Servlet容器相关的规则
        @Override
        public void customize(ConfigurableE mbeddedServletContainer container) {
        container. . setPort (8083);
    };
}




```

  

## springboot 集成 mybatis

```
1，导入依赖
2，填写配置
3，创建数据库表
4，创建实体类


```



## springdata jpa

```
//使用JPA注解配置映射关系
//告诉JPA是一个实体类（和数据库表映射的表）
@Entity
//告诉JPA和哪个表相互映射，如果省略默认是 userinfo
@Table(name = "userinfo")
public class UserInfo implements Serializable {
//    设置为主键
    @Id
//    设置为自增主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userInfoId;
//    设置和哪一列映射，长度为50
    @Column(name = "userName", length = 50)
    private String userName;
//    如果那么省略，那么默认为password映射
    @Column(name = "passWord")
    private String passWord;
```

```
继承接口的区别
Repository	统一接口
RevisionRepository	基于乐观锁机制
CrudRepository	基本CRUD操作
PagingAndSortingRepository	基本CRUD和分页


```



## springboot原理分析

```
几个重要的事件回调机制
配置在META-INF/spring.factories
ApplicationContextlnitializer
SpringApplicationRunListener

只需要放在ioc容器中
ApplicationRunner
CommandLineRunner

```



```java
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
		this.resourceLoader = resourceLoader;
		Assert.notNull(primarySources, "PrimarySources must not be null");
		//primarySources 里面放的是 SpringbootJpaApplication.class
		this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
    	//deduceWebApplicationType 判断web环境
		this.webApplicationType = deduceWebApplicationType();
    
		setInitializers((Collection) getSpringFactoriesInstances(
				ApplicationContextInitializer.class));
		setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
		this.mainApplicationClass = deduceMainApplicationClass();
	}
```

## 自定义启动器 starter

```

```





# springboot高级

## spring boot 与缓存

```
JSR-107，spring缓存抽象，整合redis
```

```
JSR-107
1，CachingProvider：定义了创建，配置，获取，管理，控制多个 CacheManager。一个应用可以在运行期间访问多个 CachingProvider。
2，CacheManager：定义了创建，配置，获取，管理，控制多个唯一命名的 Cache。这些 Cache 存在于 CacheManager 的上下文中，一个 CacheManager 仅被 一个 CachingProvider 拥有。
3，Cache：一个类似map的数据结构，并临时存储以key为索引的值，一个cache仅被 一个 CacheManager 拥有。
4，Entry：是一个存储在cache中的key-value对
5，Expiry：每一个存储在cache中的条目，有一个定义的有效期。一旦超过这个时间，条目变为过期状态。一旦过期，条目将不可访问，更新，删除。缓存有效期可以通过 ExpiryPolicy


```

## spring缓存抽象

```
定义了Cache和CacheManager来统一不同的缓存技术，并支持使用JCache（JSR-107）注解简化开发



```

```
重要的概念
cache:缓存接口，定义缓存操作。实现有: RedisCache. EhCacheCache、ConcurrentMapCache等
cachemanager：缓存管理器，管理各种缓存(Cache) 组件
cacheable：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
cacheevict：清空缓存
cacheput：保证方法被调用，又希望结果被缓存。
enableCaching：开启基于注解的缓存
keyGenerator：缓存数据时key生成策略
serialize：缓存数据时value序列化策略


```

```
缓存的初步使用
1，基本环境的搭建，一个查询数据库方法
2，在主配置方法上，配置@EnableCaching，
3，标注缓存注解
	@Cacheable
	@CacheEvict
	@CachePut
4，CacheManager 管理多个 cache 组件，对缓存的真正CRUD操作在cache组件中，每一个缓存都有自己的名字
	cachenames/value：指定缓存组件的名字
	key：缓存数据使用的key，默认使用方法传入参数的值。例如：1-方法的返回值
	key的处理也可以使用SPEL表达式，#id，#root.args[0]，#p0
5，keyGennerator：key的生成器可以自己指定key的生成器的组件id
	key/keyGennerator 二选一使用
6，cacheManager:指定缓存管理器，或者 cacheResolver 指定获取解析器
	cacheManager 或者 cacheResolver，二选一
7，condition：指定符合条件的情况下才缓存
	condition = #id > 0
8，unless:否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存：可以获取到结果进行判断
	unless = "#result == null "
9，sync:是否使用异步模式




```

![](%E5%9B%BE%E7%89%87%E6%94%B6%E9%9B%86/cache%20key.png)

## cache的工作原理及使用

```


cachePut：既调用方法，又更新缓存
运行时机：先调用目标方法，然后将目标方法的结果缓存起来。
@CacheEvict: 缓存清除
key：指定要清除的数据
al1Entries=true：删除这个缓存中的 所有的缓存
beforeInvocation = false 设置缓存的清除会否在方法执行前。默认代表是在方法执行之后

@CachePut(value = "emp",key = "#result.id")
@CachePut(value = "emp",key = "#employee.id")
public Employee updateEmp(Employee employee){
    System.out . println("updateEmp :"+employee);
    employeeMapper.updateEmp(employee);
	return employee;
}

@CacheEvict: 缓存清除
key：指定要清除的数据
al1Entries=true：删除这个缓存中的 所有的缓存
beforeInvocation = false 设置缓存的清除会否在方法执行前。默认代表是在方法执行之后
@CacheEvict(value="emp", al1Entries=true)
public void deleteEmp(Integer id){
    System . out .println("deleteEmp:"+id);
    employeeMapper. deleteEmpById(id);
}
删除指定key
@CacheEvict(value="emp", key="#id")
public void deleteEmp(Integer id){
    System . out .println("deleteEmp:"+id);
    employeeMapper. deleteEmpById(id);
}

```

```
@caching

@Caching{
    cacheable = {
    	方法执行前，将ID放在key和返回数据放在缓存中
    	@Cacheable(value="emp", key = "#lastName")
	},
    put = {
    	执行在方法后，将id和返回数据放进去，放到缓存
        @CachePut(value="emp", key = "#result.id"),
        @CachePut(value="emp", key = "#result.email")
    }
}


```

```
@Cacheable(value="emp", key = "#lastName")
@CachePut(value="emp", key = "#result.id")
 
由于每一个类都需要写value，可以使用@cacheconfig（value = "emp"）
```

## springboot redis 

```
Redis常见的五大数据类型
String (字符串)、list (列表)、Set (集合)、Hash (散列)、ZSet (有序集合)
stringRedisTemplate.opsForValue()[String (字符串) ]
stringRedisTemplate.opsForlist()[list (列表) ]
stringRedisTemplate.opsForSet()[Set (集合) ]
stringRedisTemplate.opsForHash()[Hash (散列) ]
stringRedisTemplate.opsForZSet()[ZSet (有序集合) ]


```

```
redis的使用

```

```
redis缓存的使用
原理：cachemanager==cache	缓存组件来实际给缓存中存取数据
1，引入redis的starter，容器中保存的是 rediscachemanager
2，rediscachemanager帮我们创建缓存 rediscache
3，rediscachemanager 默认保存的是序列化后的数据

```









# Spring cloud

```
一，微服务简述
1，什么是微服务?
提倡将原来的单一架构模式和垂直架构模式，在进一步拆分，拆分成更加细小的服务，也是组件。每一组服务都运行在自己的进程中，服务之间有不同的通信协议进行相互配合。
每个服务都是各自具体的业务实现，能够独立的部署到生产环境，可以有一个集中的管理来协调这些服务。可以使用不同的语言来编写服务，也可以使用不同的数据存储。
组件是可以独立替换的和升级的单元。

2，微服务和微服务架构
微服务：服务的大小，是具体解决某一个问题的服务应用，狭义的看是module

3，微服务的优缺点
优点：耦合度降低，代码容易理解，聚焦于一个指定的业务功能
	开发快，效率高，一个服务只干一件事情
	微服务能够被小团队开发使用，无论在开发阶段还是部署阶段都是独立的。
	易和第三方集成，允许容易且灵活的方式集成自动部署，如Jenkins，bamboo
	可以灵活搭配独立的数据库

缺点：分布式系统非常复杂
	多服务之间有很大的运维难度
	系统部署成本依赖
	服务之间的通信成本
	数据一致性问题
	系统集成测试
	性能监控

4，微服务的技术栈
微服务概念								微服务技术的实现

服务开发								Springboot. Spring、 SpringMVC
服务配置与管理								Netflix公司的Archaius.阿里的Diamond等
服务注册与发现								Eureka、Consul. Zookeeper等
服务调用								Rest. RPC、 gRPC
服务熔断器								Hystrix、Envoy等
负载均衡								Ribbon. Nginx等
服务接口调用(客户端调用服务的简化工具)		Feign等
消息队列								Kafka、RabbitMQ、 ActiveMQ等
服务配置中心管理							SpringCloudConfig. Chef等
服务路由(API网关)|						Zuul等
服务监控								Zabbix、Nagios. Metrics. Spectator等
全链路追踪								Zipkin, Brave、 Dapper等
服务部署								Docker. OpenStack、 Kubernetes等
数据流操作开发包						SpringCloud Stream (封装与Redis,Rabbit. Kafka等发送接收消息)
事件消息总线I								Spring Cloud Bus

5，为什么使用springcloud作为微服务架构
和dubbo相比，各种工具实现都很高


2，微服务之间是如何独立通讯的
3，Dubbo和springCloud有哪些区别?
通信机制的不同：dubbo基于HTTP协议的RPC远程过程调用协议，springcloud基于REST通信，

服务注册中心 	Zookeeper		Spring Cloud Netflix Eureka
服务调用方式	RPC				REST API
服务监控	Dubbo-monitor	Spring Boot Admin
断路器		不完善				Spring Cloud Netflix Hystrix
服务网关	无				Spring Cloud Nettfix Zuul
分布式配置	无				Spring Qloud Config
服务跟踪	无				Spring Cloud Sleuth
消息总线	无				Spring Cloud Bus
数据流		无				Spring Cloud Stream
批量任务	无				Spring Cloud Task


4，SpringBoot和SpringCloud, 请你谈谈对他们的理解
5，什么是服务熔断?什么是服务降级
6，微服务的优缺点分别是什么?说下你在项目开发中碰到的坑
7，你所知道的微服务技术栈有哪些?请列举-二)
8，eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别?

二，springcloud入门
API GateWay：服务网关
breaker dashboard：熔断服务监控技术
service registry：服务注册与发现
config dashboard：分布式配置中心
message brokers：消息队列
databases：数据库相关
distributed tracing：全链路监控
microservices：多个微服务架构
负载均衡：

springcloud微服务全家桶：利用springboot开发便利性巧妙的简化了分布式系统基础设施的开发，springcloud为开发人员提供了快速构建分布式系统的工具。包括配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竞选，分布式会话等等，他们都可以使用springboot做到一键启动部署。

```

```
三，
```

# spring cloud 千锋

```
1，SAAS 软件即服务，每天多次变更，直接推送上线。
	推送一次，停止运营40分钟

2，在微服务中，分库分表的数据库之间，这个表可能会包含另一个数据库的一行数据，以json保存的
	已经违反了原来的企业开发的数据库三范式设计，现在必须改变成反三范式。

3，SOA 面向服务架构
	微服务不使用webservice，而是rest api
```

```
CAP
C：一致性，更新操作成功并返回客户端完成后，所有节点在同一时间的数据完全一致
A：可用性，服务一直可用，而且是正常的响应时间
P：分区容错性，分布式系统在遇到某节点或者某个网络分区故障的时候，仍然能够对外提供满足可用性和一致性的服务

保证服务必须数据一致，C必须满足，网络发生故障，宁可停止服务，保证CA。网络发生故障，只读不写。
```

```
Iaas：基础设施即服务
Paas：平台即服务
Saas：软件即服务
Baas：区块链即服务
就是云计算，云服务，云存储，全栈
```

# 千锋 Linux

```
centos：有公司背景，稳定，更新非常缓慢
ubuntu：社区产物，一个月小版本，六个月稳定版
```

