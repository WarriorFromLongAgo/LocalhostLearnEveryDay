using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld_namespace
{
    class HelloWorldgouzao
    {    
        /**
        *三目运算
        */
        public void TrinocularOperation()
        {
            //用来计数
            int count = 0;
            //求和
            int num = 0;
            //第一个数，最后一个数
            int left = 1;
            int right = 2000000000;
            //中位数
            int middle = right / 2;
            //如果是奇数，就把中位数给middle
            if ((right & 1) != 0)
            {
                num = left + ((right - left) / 2);
            }

            Console.WriteLine("while题目 第一次 = " + num);
            while (count < middle)
            {
                Console.WriteLine("nnum = " + num);
                if (int.MaxValue - num - right < left)
                {
                    num = int.MaxValue;
                    break;
                }
                num = num + left + right;
                left++;
                right--;
                count++;
            }
            Console.WriteLine("while题目 最后一次" + num);
        }
    }

    class HelloWorld
    {
        static void Main(string[] args)
        {
            HelloWorldgouzao ff = new HelloWorldgouzao();
            ff.TrinocularOperation();

            Console.ReadKey();
        }

    }
}
