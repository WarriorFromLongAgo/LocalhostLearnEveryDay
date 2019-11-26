using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkList_namespace
{
    class Link<T>
    {
        //链表 节点 的数据
        public T Data { get; set; }
        //链表的下一个节点
        public Link<T> NextNode { get; set; }
        //链表上一个节点
        public Link<T> PriousNode { get; set; }
        /// <summary>
        /// 无参数构造函数
        /// </summary>
        public Link()
        {
            this.Data = default;
        }
        /// <summary>
        /// 有参数构造函数
        /// </summary>
        /// <param name="data"></param>
        public Link(T data)
        {
            this.Data = data;
        }
    }
    /// <summary>
    /// 链表的实现
    /// </summary>
    /// <typeparam name="T"></typeparam>
    class MyLink<T>
    {
        public int size;
        private Link<T> LastNode;
        private Link<T> HeadNode;
        /// <summary>
        /// 无参数构造函数
        /// </summary>
        public MyLink()
        {
            this.HeadNode = null;
            this.LastNode = null;
            this.size = 0;
        }
        /// <summary>
        /// 在 index的后面插入节点
        /// </summary>
        /// <param name="index"></param>
        /// <param name="item"></param>
        public void Insert(int index,T item)
        {
            if (index < 0 || index > this.size)
            {
                Console.WriteLine("插入的index不符合");
            }

            Link<T> NewNode = new Link<T>(item);
            Link<T> tempHead = this.HeadNode;
            Link<T> tempLast = this.LastNode;

            if (this.HeadNode == null)
            {
                this.HeadNode = null;
                this.LastNode = null;
            }
            else if (index == 0)
            {
                NewNode.NextNode = tempHead;
                NewNode.PriousNode = null;
                tempHead.PriousNode = NewNode;
                tempHead.PriousNode.NextNode = NewNode;
                this.HeadNode = NewNode;
            }
            else if (index == this.size)
            {
                tempLast.NextNode = NewNode;
                NewNode.PriousNode = tempLast;
                NewNode.PriousNode.NextNode = NewNode;
                NewNode.NextNode = null;
                this.LastNode = NewNode;
            }
            else
            {

            }

        }
    }
    class LinkList
    {
        static void Main(string[] args)
        {
        }
    }
}
