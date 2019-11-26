1，
https://tieba.baidu.com/p/5979984208?share=9105&fr=share&see_lz=0&sfc=qqfriend&client_type=2&client_version=10.3.8.10&st=1568823439&unique=1E93CF57EDC934D94B8BA0A9F116B105&red_tag=1169767176

首先调试方法还是穷人首选的VEH，
.常量 全局钩子1,“26FEE50”,,
13年的时候，我们管检测叫作VM，为什么这么叫我也不是很懂。
通常在一个功能地址的附近都有一个这样的地址
02XXXXXX call 1
用大神的话讲这里被VM了多少多少个字节，找到还原就是过掉了这个VM

搜索双浮点1000得到几个绿色的基址 其中一个就是加速的地址 添加到地址栏对它进行访问

会出来两个扫描，其中一个就是在检测这个加速地址是否是1000正常值

没错，检测最根本的工作就是检测数值是否被更改 字节是否被更改这属于简单的检测，知道了它的检测原理处理它就简单了

首先我们申请一个地址写入1000的双浮点数据，然后替换了检测在对比的地址就可以PASS掉检测了。

dnf的检测我也是从荒野行动那找来的灵感，3月份找肥猫大神买下段驱动时他教的xor eax，eax 我感觉我被他带了弯路

不过我发的石头检测处理视频他认可了我 我也挺高兴的。



上游戏先处理一下VEH调试，然后开ce转到26FEE50钩子地址

dnf.exe+22FEE50 - 55 - push ebp
dnf.exe+22FEE51 - 8B EC - mov ebp,esp
dnf.exe+22FEE53 - 6A FF - push -01 { 255 }
dnf.exe+22FEE55 - 68 70C11804 - push dnf.exe+3D8C170 { [0824548B] }
dnf.exe+22FEE5A - E8 5675A610 - call TenRPCS.dll+2863B5

把这里改成ret即可实现全屏钩子效果，我们先别急着改 先F5下一个段

然后对着空气A一下，果断断了下来 ，下面很明显有一个call TenRPCS.dll的地址



就是以前说的VM 我们F7跟进去，

TenRPCS.dll+84943 - FF D2 - call edx

跟到了这里 这里的edx就是即将进入的检测入口 我们进去
GameRpcs.dll+18DAF0 - 55 - push ebp

然后运行 我们再ret了钩子地址
dnf.exe+22FEE50 - C3 - ret

也是下段 对着空气A一下，因为是ret所以它不会进入下面那个call TenRPCS.dll+2863B5了



dnf.exe+2419698 - E8 56CB9410 - call TenRPCS.dll+2861F3

ret之后它来到了这里 我们进去看下

GameRpcs.dll+18D5C0 - 55 - push ebp

很明显和刚刚进入的入口不一样，这里可以有很多种办法过检测，可以去分析GameRpcs.dll+18D5C0这个检测

分析检测是个比较头疼的事情，我这里是选择HOOK TenRPCS

就是这个地方TenRPCS.dll+84943 - FF D2 - call edx



GameRpcs.dll+18D5C0 - 55 - push ebp 这个是我们实现了全屏钩子效果的检测地址 可以理解为 要打人，但是打错人了的意思

GameRpcs.dll+18DAF0 - 55 - push ebp 而这里就是我们正确的或者说正常要去的地方

那么hook就是 先申请个地址

0A060000 - 00 00 - add [eax],al

TenRPCS.dll+84943 - FF D2 - call edx
TenRPCS.dll+84945 - 83 C4 2C - add esp,2C { 44 }
TenRPCS.dll+84948 - 89 75 FC - mov [ebp-04],esi



我们先判断edx是否为GameRpcs.dll+18D5C0这个错误的地址

0A060000 - 81 FA C0D55414 - cmp edx,GameRpcs.dll+18D5C0 { [81EC8B55] }

然后留两个字节做je短跳

先在0A060008开始写好不等于的代码

0A060008 - FF D2 - call edx//hook处字节
0A06000A - 83 C4 2C - add esp,2C { 44 }//hook处字节
0A06000D - E9 3649F008 - jmp TenRPCS.dll+84948 //跳转回去

0A060006 - 74 08 - je 0A060012
再让留的两个字节跳到下面来处理判断=真的代码， 我这里没说标志位不要觉得low，小白比较好理解




如果真 我们就mov 正确的给edx，然后再跳到上面继续执行

0A060012 - BA F0DA5414 - mov edx,GameRpcs.dll+18DAF0 { [83EC8B55] }
0A060017 - EB EF - jmp 0A060008

最后

TenRPCS.dll+84943 - E9 B8B60FF7 - jmp 0A060000

可以看图 没有崩溃

讲解完毕


#
https://tieba.baidu.com/p/5640719393?pid=119086844932&cid=&red_tag=2542502350#119086844932

技能无CD。VM段里还原
GameRpcs.dll+192260 - 83 C4 20 - add esp,20
GameRpcs.dll+192263 - 90 - nop
GameRpcs.dll+192264 - 90 - nop
GameRpcs.dll+192265 - E9 4B9CE0EF - jmp dnf.exe+1AFBEB5
GameRpcs.dll+19226A - 90 - nop
GameRpcs.dll+19226B - 90 - nop
GameRpcs.dll+19226C - 90 - nop
GameRpcs.dll+19226D - 90 - nop


技能无CD
01EFBEB0 - 83 C4 20 - add esp,20
01EFBEB3 - 90 - nop
01EFBEB4 - 90 - nop