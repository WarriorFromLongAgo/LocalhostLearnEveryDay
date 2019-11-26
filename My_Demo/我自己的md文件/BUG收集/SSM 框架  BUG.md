#Cause: org.apache.ibatis.builder.BuilderException: 
#Error parsing SQL Mapper Configuration. Cause: java.io.IOException: Could not find resource com.feijm.dao.IPeopleDao.xml

报错行
SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

说出来你可能不信，这其实就是我之前说得IDEA的锅：
IDEA的Maven是不会编译src的java目录的xml文件，所以在Mybatis的配置文件中找不到xml文件！

	以前这里写的是全限定类名，现在修改成/
 	<mappers>
        <mapper resource="com/feijm/dao/IPeopleDao.xml"/>
    </mappers>

#Spring JdbcTemplate未写空参构造函数错误
对象未写空参构造函数。

导致 query(说起来， new BeanRowsMapper()<Peopler>);的时候
一直在此行死循环，不能往下走

解决办法：写一个空参构造。

#Method not found: isUsername
最开始的时候，发现userName 和 数据库里面的username不相符，所以直接修改了实体类里面的userName。
全部都修改了，但是跑了一遍后，仍然还是有BUG。
继续调试。。无法解决这个BUG，，，于是，我就对这个实体类进行了重构，OK了。草。

#java.io.FileNotFoundException: Could not open ServletContext resource [/jdbc.properties]

```
在spring配置中加载文件的配置修改为
  <context:property-placeholder` `location="classpath:jdbc.properties" />
```

#No qualifying bean of type 'com.fff.dao.IAccountDao' available: expected at least 1 bean which qualifies as autowire candidate. 

​	1，没有开启包扫描

2， https://www.cnblogs.com/hd976521/p/7026329.html 



## JSP页面乱码 

没有导入 isELIgnored="false"

## Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.2:compile (default-compile) on project projectController1: Compilation failure

前端页面传送到后面的数据不正确

## The request sent by the client was syntactically incorrect.

controller只能够接受string 或者  interge类型

不能够接受，date