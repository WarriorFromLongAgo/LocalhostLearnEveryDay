package com.byit.JavadeIO;

public class 解释说明 {
}
/*
 * 字符流：Reader + Write
 *        用于读取字符流的 抽象类 ，子类必须实现的方法 只有 read(char[],int,int) 和 close()
 *        字符流 = 字节流+解码
 *
 *         他的子类有
 *              InputStreamReader，（是Reader的子类，是FileReader的父类）
 *              FileReader
 *              BufferedReader
 *
 *          InputStreamReader和FileReader都是Reader的子类，
 *          所以可以把这两个类型的数据作为参数传进去，
 *          这样相当于把这两个类型的数据包成一个BufferedReader类型，提高读取效率。
 *
 *      1，字符流：读取二进制文件，自动解码成我们看得懂的字符
 *
 *      2，Reader：抽象类，所有字符输入流的超类
 *          1，FileReader：文件字符输入流，读取字符串
 *              用法：
 *              1，找到目标文件，
 *                  File file = new File(“C:\\Users\\cdlx2016\\Desktop\\a.txt);
 *              2，建立数据通道
 *                  FileReader reader = new FileReader(file);
 *              3，建立一个缓冲区
 *                  char[] c = new char[1024];
 *              4，读取数据
 *                  int content = 0
 *                  while((content=fileReader.read(c)) != -1){
 *                      sout(new String(c ,0 ,content))
 *                  }
 *              5，关闭资源
 *                  reader.clock();
 *
 *      3，Write：抽象类，所有字符输出的超类
 *              1，FileWrite：文件数据的输出字符流
 *              2，使用注意事项
 *                  1，内部维护一个1024个字符的字符数组，写入数据时，是先将数据写到内部字符数组中，
 *                     如果需要将数据写入硬盘，需要调用flush()或者close()或字符数组满了。
 *                  2，如果需要向文件追加数据，使用new FileWrite(File,boolean)构造方法，boolean为true。
 *              3，如果指定文件不存在，会自己创建一个。
 *              4，用法
 *                  1，找到目标文件
 *                      File file = new File(“C:\\Users\\cdlx2016\\Desktop\\a.txt);
 *                  2，建立数据的通道
                        FileWrite write = new FileWrite(file);
                    3，写入数据
                        write.write(“”);//这里只会写入内部维护的数组
                    4，刷新数据 （刷新、关闭、数组满了 才会写入磁盘(边读边写)）
                        write.flush();
                    5，关闭资源 （默认会调用flush()）
                        write.close();








 *
 *      4，字符串解码：
 *      5，
 *      6，字节流使用场景
 *      7，字符流使用场景
 *
 *
 *
 *
 *  字节流：InputStream输入流（读） + OutputStream输出流（写）
 *  2，InputStreamReader（是Reader的子类，是FileReader的父类）
 *      1，构造方法
 *          new InputStreamReader(InputStream)
            new InputStreamReader(InputStream. String charSetName)
        2，第一种是，传了一个字节流
           第二种是，传进来一个字节流的同时，指定编码的格式，

 *  3，BufferedReader 缓冲流（是Reader类的子类）
 *      1，有按行读取的ReadLine()方法，该方法返回读取的字符
 *      2，缓冲流的机制，把字符流带进了缓冲区，先把数据放入缓冲区，然后再从缓冲区里面去读东西，可以提高效率
 *      构造方法:
 *          new BufferedReader(Reader)
 *
 *      BufferedReader的构造方法需要一个Reader类型的参数
 *      注：带缓冲区的流有时候会读不出来东西，这时候可能的原因是：流没有关。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */

/*
* FileReader
* 构造方法：
*       new FileReader(File file)
        new FileReader(String  path)
  用FileReader读取文本文档
  *
*
*
*
* */