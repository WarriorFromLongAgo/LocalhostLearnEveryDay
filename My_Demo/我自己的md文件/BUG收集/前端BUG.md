##1，Servlet 和 JS的bug
···123
  

···123

    var changeVerificationCode = document.getElementById("changeVerificationCode");
            // changeVerificationCode.onclick = function () {
            //     var date = new Date().getTime();
            //     changeVerificationCode.src = "/numPhoto_war_exploded/verificationCodeServlet?" + date;
            // };
            changeVerificationCode.onclick=function () {
                var verificationCode = document.getElementById("VerificationCode");
                var date = new Date().getTime();
                verificationCode.src = "/numPhoto_war_exploded/verificationCodeServlet?" + date;
            };
<img src="/numPhoto_war_exploded/verificationCodeServlet" id="VerificationCode">
<button id="changeVerificationCode">看不清，换一个</button>
<!--<input type="button" id="changeVerificationCode" value="看不清，换一个">-->
<a id="changeVerificationCodeImg" href="">看不清，换一个</a>

#2，没有导包的BUG
Uncaught ReferenceError: $ is not defined
没有导包，所以导致BUG

#3，复制粘贴页面，导致JS的包没有检测到
报错1：Failed to load resource: the server responded with a status of 404 ()
报错2：在引入jQuery时 报net::ERR_ABORTED 404

手写一遍JS的导入就解决了。

#4，页面跳转，获取地址栏的中文的时候
背景介绍：页面跳转的时候获取地址栏，出现undifined
报错问题：页面跳转获取不到 中文信息
问题分析：页面跳转的时候，获取不到数据
BUG测试：将传递数据的中文用 引号括起来
问题后续：括起来后，可以正常的传输中文

中文乱码，window.decode

html5 <html lang="en">	修改成 ch	

