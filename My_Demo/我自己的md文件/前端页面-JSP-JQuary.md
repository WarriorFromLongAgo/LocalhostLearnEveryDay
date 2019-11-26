		<%@ page contentType="text/html;charset=UTF-8" language="java" %>

#jsp	
1，指令
	作用：用于配置jsp页面，导入资源文件
	格式：<%@ 指令名称 属性名称1=属性值1 属性名称2=属性值2 %>
	分类：
		1，page：配置jsp页面的
			contentType：等同于response.setContentType()
				1，设置响应页面的格式及字符集
				2，设置jsp的页面编码，如果使用低级工具，则需要设置pageEnding属性设置
				pageEncoding 
			import：导包
			errorPage：当页面发生异常后，会自动跳转到的错误页面
			iserrorPage：标识当前页面是否是错误页面
		2，include：页面包含的，导入页面资源文件
			<%@include file="top.jsp"%>
		3，taglib：导入一些资源
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			1，前缀：prefix="c"，一般都是 c 
			2，
	注释：
	
	内置对象：
		1，pageContext	当前页面共享数据，可以获取其他的八个对象
		2，request		一次请求访问的多个资源	
		3，session		一次会话的多个请求
		4，application	多个用户间共享数据

		5，response		响应对象
		6，page			当前页面的对象，当前的servlet，this
		7，out			输出对象
		8，config		读取本地的配置文件
		9，exception		异常对象
	

#MVC开发模式
	m
	v
	c


#el表达式
	1，jsp默认支持el表达式，如果要忽略el式有两种办法
		1，配置jsp中的page指令中的，isELIgnord="true"，忽略当前页面中所有的el表达式
		2，\${表达式} 忽略当前的el表达式
	2，使用
		1，空运算符：empty，${empty list}判断是否为空
			${not empty list}，不为空，且长度大于0 
		2，获取动态的虚拟目录
			${pageContext.request}
			${pageContext.request.contextPath}
			 
#JSTL
	1，概念：JSP标准标签库
	2，作用：用于简化JSP页面上的JAVA代码
	3，使用步骤
		1，导入jar包
		2，引入标签库，taglib
		3，使用标签
	4，常用的JSTL，if，choose，foreach


#分页的实现
客户端--输出至--服务器
	每页显示多少条：由页面传入到服务器，同时如果小于0，则赋值1，过大则赋值最大值
	当前所在页：由页面传输到服务器

服务器--输出至--客户端	
	数据总条数：服务器读取数据库
	总页码：总条数 除以 每页显示多少条
	List的数据集合：

#模糊搜索的实现
	
	后台获取条件参数
	Map<String, String[]> conditionStrStrArrMap = request.getParameterMap();
	然后将条件传入到分页的地方，然后就是分页搜索查询
	Paging<Student> paging = new ProjectServiceImpl().findByPageListService(currentPage, pageShowAnCount, conditionStrStrArrMap);
	
	前端传递参数
	<a href="${pageContext.request.contextPath}/pageAllController?currentPage=${paging.currentPage - 1}&pageShowAnCount=5&name=${condition.name[0]}&birthplace=${condition.birthplace[0]}&mailbox=${condition.mailbox[0]}" aria-label="Previous">

#JQuary基础
概念：一个JavaScript框架，简化JS的开发
	JavaScript框架：本质上就是一些JS文件，封装了JS的原生代码
入门： 
	JQuary的三个版本：
	1.X:兼容IE678，使用最为广泛，官方只做BUG维护，最终版本1.12.4，
	2.X:不兼容IE678，很少有人用，官方只做BUG维护
	3.X:不兼容IE678，只支持最新的浏览器，除非特殊要求，一般不会使用3.x的版本，很多老的插件不支持此版本，官方维护3.2.1
	
	jquary非min版本：开发版本，可以良好的观看、。
	jquary有min版本：生产版本，缩小大小，程序加载更快

	var div2 = $("#div2");
    alert(div2.html());

							js				jq
	单击事件				onclick				click
	获取焦点操作			onfocus				focus
	失去焦点操作			onblur				blur
	下拉区域改变事件		onchange			change
	鼠标移入事件			onmousover			
	鼠标移出事件			onmousout			on
	键盘事件				onkeydown			keydown
	表单提交事件			onsubmit			submit
	

JQuary对象和JS对象的区别于转换
	/*
    * 1，JQuary对象在操作时，更加方便
    * 2，JQuary对象和JS对象方法时不通用的
    * 3，两者相互转换
    * jq------>js：jq对象[索引] 或者 jq对象.get(索引)
    * js------>jq：$(js对象)
    * */
    $div[0].innerHTML = "ddd";
    $div.get(1).innerHTML = "eee";

    for (var i = 0; i < divArr.length; i++) {
        // js对象转换为jq
        // divArr[i].innerHTML = "aaa";
        $(divArr[i]).html("ccc");
    }
	
选择器：筛选具有相似特征的元素(标签)
1，基本语法学习
	选择器的优先级：id选择器 > class选择器 > 标签选择器

	1，事件的绑定：
	2，入口函数	：
	当你不添加入口函数，同时将script写在head里面，而不是写在body的最下面，就会造成冲突。
	必须先加载按钮才可以进行此方法或者说事件。
	$(function () {
        var $button1 = $("#button1");
        $button1.click(function () {
            alert("点击");
        })
    });
	window.onload = fun1;
	function fun1 () {
        var $button1 = $("#button1");
        $button1.click(function () {
            alert("点击");
        })
    };
	
	window.onload 和 $(function(){})
	window.onload只能定义一次，如果定义多次，后面的会将前面的覆盖掉。
	
	
	3，样式的控制	：

2，分类
	
	1，基本选择器
		1，标签选择器（元素选择器）：$("html标签名") 获得所有匹配标签名称的元素
		2，id选择器				：$("#id的属性值") 获得与指定id属性值匹配的元素
		3，类选择器				：$(".class的属性值") 获得与指定的class属性值匹配的元素
		4，并集选择器				：$("选择器1,选择器2.....") 获得多个选择器选中的所有元素
	2，层级选择器
		1，后代选择器				：$（"A B"）选择A元素内部的所有B元素
		2，子选择器				：$（"A > B"）选择A元素内部的所有B 子元素
		div( span(span) span )
		$（"div span"）选择三个span
		$（"div > span"）选择 两个个span，两个儿子，孙子不算
	3，属性选择器
		1，属性名称选择器			：$（"A[属性名]"）包含指定属性的选择器
		2，属性选择器				：$（"A[属性名 = '值']"）包含指定属性等于指定值的选择器
		3，复合属性选择器			：$（"A[属性名 = '值'][]..."）包含多个属性条件的选择器
	4，过滤选择器（此处冒号也算是元素选择器）
		1，首元素选择器			：first	获得选择的元素中的第一个元素
		2，尾元素选择器			：last	获得选择的元素中的第一个元素
		3，非元素选择器			：not(selecter) 不包括指定内容的选择器
		4，偶数选择器				：even 偶数，从0开始计数，获得第偶数个元素
		5，奇数选择器				：odd 奇数，从0开始计数，获得第奇数个元素
		6，等于索引选择器			：eq(index)	指定索引元素
		7，大于索引选择器			：gt(index) 大于指定索引元素
		8，小于索引选择器			：lt(index) 小于指定索引元素
		9，标题选择器				：header 获得标题元素，固定写法
	5，表单过滤选择器
		1，可用元素选择器			：enabled	获得可用元素
		2，不可用元素选择器		：disabled	获得不可用元素
		3，选中选择器				：checked	获得单选/复选框中的元素
		4，选中选择器				：selected	获得下拉框中的元素

           

DOM操作
1，内容相关的操作
	1，html()：获取、设置元素的标签体内容
		<div id="divOne"><p><a href="#">标题标签</a></p></div>
		获取：<p><a href="#">标题标签</a></p>
		设置：<div id="divOne">aaa</div>
	2，text()：获取、设置元素的标签体纯文本内容
		<div id="divOne"><p><a href="#">标题标签</a></p></div>
		获取：标题内容
		设置：<div id="divOne">aaa</div>
	3，val()：获取、设置元素的value值 
		<input type="text" id="inputOne" name="userName" value="zhangsan">
		获取：zhangsan
		设置：只设置 value 值
	4，$()
		设置一个标签属性
		$(<input type="text" id="inputOne" name="userName" value="zhangsan">)	//创建一个标签
2，属性相关的操作
	1，通用属性操作：
	attr()		：获取、设置元素的属性
	removeAttr()：删除属性
	prop()		：获取、设置元素的属性
	removeProp()：删除属性
	
	attr 和 prop 的区别：	
		如果你操作的是元素的固有属性：则建议使用prop,
		如果你操作的是自定义的元素：则建议使用attr

	2，对class属性操作：
	addClass	：添加class属性值
	removeClass	：删除class属性值
	toggleClass	：切换class属性值
		toggleClass：判断如果元素对象上存在class="one"，则将属性值one删除掉
					如果元素对象上不存在class="one"，则添加

3，CRUD相关的操作
	1，append()：父元素将子元素追加到末尾
		对象1.append(对象2)：将对象2添加到对象1的元素内部，并且在末尾
	2，prepend()：父元素将子元素追加到开头
		对象1.prepend(对象2)：将对象2添加到对象1的元素内部，并且在开头

	3，appendTo()：
		对象1.append(对象2)：将对象1添加到对象2的元素内部，并且在末尾
	4，prepend()：
		对象1.prepend(对象2)：将对象1添加到对象2的元素内部，并且在开头
	
	5，after()：添加元素到元素的后面
		对象1.after(对象2)：将对象2添加到对象1的后面，对象1和对象2是兄弟的关系
	6，before():添加元素到元素的前面
		对象1.after(对象2)：将对象2添加到对象1的前面，对象1和对象2是兄弟的关系
	
	7，insertAfter()：添加元素到元素的后面
		对象1.after(对象2)：将对象2添加到对象1的后面，对象1和对象2是兄弟的关系
	8，insertBefore():添加元素到元素的前面
		对象1.after(对象2)：将对象2添加到对象1的前面，对象1和对象2是兄弟的关系
	
	9，remove()：删除移除元素
		对象.remove()：将对象删除
	10，empty()：清空所有的后代元素
		对象.empty()：将对象的后代元素全部清空
	11，clone()：
	12，

小案例


#JQuary高级
1，动画
	默认显示和隐藏方式
	1，show([speed,[easing],[fn]])
		speed：				三种预定速度之一的字符串("slow","normal", or "fast")，或表示动画时长的毫秒数值(如：1000)
		fn：					在动画完成时执行的函数，每个元素执行一次。（function对象）
		easing:(Optional) 	用来指定切换效果，默认是"swing（先慢，中间快，最后又慢）"，可用参数"linear(匀速)"
	2，hide([speed,[easing],[fn]])
	3，toggle([speed],[easing],[fn])
	滑动显示和隐藏方式
	1，slideDown([speed],[easing],[fn])
	2，slideUp([speed,[easing],[fn]])
	3，slideToggle([speed],[easing],[fn])
	淡入淡出的显示和隐藏方式
	1，fadeIn([speed],[easing],[fn])
	2，fadeOut([speed],[easing],[fn])
	3，fadeToggle([speed,[easing],[fn]])

2，遍历
JS的for循环遍历方式	for(初始值：循环结束条件：步长)
JQuary的遍历方式		对象.each(callback)
					$.each(object, [callback])
					for..of(js 3.0)
	
3，事件绑定
	1，jquary的绑定方式
		jquary.事件方法（回调函数）；
	2，on绑定事件、off解除绑定
		jq对象.on("事件名称", 回调函数) 
		// 使用on给按钮绑定 单击事件 click
            $("#button1").on("click", function () {
                alert("我被点击了！！")
            });

            //使用off 来解除button按钮的单击事件，，将组件上的所有事件解绑
            $("#button2").click(function () {
                $("#button1").off("click");
            });

	3，事件的切换
		jq对象.toggle(fn1, fn2.....)
			单击jq对象的时候，会执行fn1，再次点击会执行fn2，，，，可以点击多个事件对象。并且持续循环

	4， 给name绑定鼠标移动到元素至善搞得事件。绑定鼠标移出的时间，
            $("#name").mouseover(function () {
                $("#name").prop("value","鼠标来了")
            });
            $("#name").mouseout(function () {
                $("#name").prop("value","鼠标走了")
            });
	5，焦点事件 focus
		如果没有传递回调函数，就会获得焦点
		$("#name").focus();
	6，表单提交事件
		submit([[data],fn])：可以传入一个function进行表单的验证
	
		
	
4，案例
5，插件：增强jQuery的方式
	1，实现方式
	$.fn.extend(object) 
		增强jQuery获取对象的功能，	如$("#id")
	$.extend(object) 
		增强自身的功能			如	$ 或者 jQuery
	
#JavaScript
windows对象，alert()弹框函数，confirm(弹出框)，prompt("请输入用户名:")输入框函数，open(URL)打开指定的页面，close（）关闭网页

localtion对象（地址栏）
setInterval()循环调用	setTimeout()只调用一次

获取节点的类型	1普通	3空文本	8注释
previousElementSibling	获取兄弟节点（三个并列的div）
previousSibling			获取上面的兄弟集合，包括空节点等等
nextElementSibling		获取兄弟节点（三个并列的div）

childNodes				获取body节点的子节点的集合，会获得空节点 和 注释的信息
children				获取body节点的子节点的集合
parentNode				根据子节点获取父级节点		var parentObj = firstObj.parentNode;

删除节点
//根据父级节点删除子节点
var divObj = document.getElementsByClassName("box1")[0];
//获取子节点
var aObj = document.getElementsByTagName("a")[0];
divObj.removeChild(aObj);

//节点的获取  还可以根据节点之间的层级关系去获取
      //获取父节点的HTML类型的子节点
      父节点对象.children;
      //根据子节点获取父节点
      子节点对象.parentNode
      //根据指定的指定子节点获取上一个子节点
      节点对象.previousElementSibling
      //根据指定的指定子节点获取上面子节点的集合
      节点对象.previousSibling
      //根据指定的指定子节点获取下一个子节点
      节点对象.nextElementSibling
      //根据指定的指定子节点获取下一个子节点的集合
      节点对象.nextSibling
      //根据名称创建节点对象
      document.createElement("a");
      //设置节点属性
      节点对象.setAttribute("属性","属性值")
      //追加节点（追加到父级节点的末尾处）
       父节点.appenChild(子节点对象);
      //追加到父级节点中的指定位置
       父节点.insertBefore(新节点,旧节点);