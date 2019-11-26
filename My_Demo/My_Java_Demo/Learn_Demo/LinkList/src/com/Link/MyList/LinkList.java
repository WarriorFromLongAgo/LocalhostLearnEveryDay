package com.Link.MyList;

public class LinkList {
    //链表的长度
    private int size;
    //链表的头结点
    private ListNode listHead;
    //链表的尾结点
    private ListNode listLast;

    /**
     * 参数的初始化
     */
    public LinkList() {
        this.size = 0;
        this.listHead = null;
        this.listLast = null;
    }

    /**
     * 判断链表是否为空
     * 为空则返回true
     * 否则返回false
     */
    public boolean isEmpty() {
        boolean b = (this.size == 0) ? true : false;
        return b;
//        if (this.size == 0) {
//            return true;
//        }
//        return false;
    }

    /**
     * 返回数组的长度
     */
    public int getCount() {
        return this.size;
    }

    /**
     * 返回头部的数据
     */
    public int getListHead() throws Exception {
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception("数组长度为 0 ，无法返回");
        }
        return this.listHead.Data;
    }

    /**
     * 返回尾部的数据
     */
    public int getListLast() throws Exception {
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception("数组长度为 0 ，无法返回");
        }
        return this.listLast.Data;
    }

    /**
     * 返回index处的数据
     */
    public int getIndexList(int index) throws Exception {
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception("数组长度为 0 ，无法返回");
        }
        if (index > this.size || index < 0) {
            throw new Exception(" index异常 ");
        }
        ListNode tempList = this.listHead;

        for (int i = 0; i < index; i++) {
            tempList = tempList.nextNode;
        }
        return tempList.Data;
    }

    /**
     * 返回链表的最大值
     */
    public int getmax() throws Exception {
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception("数组长度为 0 ，无法返回");
        }
        ListNode maxData = new ListNode();
        maxData.Data = this.listHead.Data;
        ListNode tempHead = this.listHead;
        for (int i = 0; i < this.size; i++) {
            if (tempHead.Data > maxData.Data) {
                maxData.Data = tempHead.Data;
                tempHead = tempHead.nextNode;
            } else {
                tempHead = tempHead.nextNode;
            }
        }
        return maxData.Data;
    }

    /**
     * 返回链表的最小值
     */
    public int getmin() throws Exception {
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception("数组长度为 0 ，无法返回");
        }
        ListNode minData = new ListNode();
        minData.Data = this.listHead.Data;
        ListNode tempHead = this.listHead;
        for (int i = 0; i < this.size; i++) {
            if (tempHead.Data > minData.Data) {
                tempHead = tempHead.nextNode;
            } else {
                minData.Data = tempHead.Data;
                tempHead = tempHead.nextNode;
            }
        }
        return minData.Data;
    }

    /**
     * 清空整个链表
     */
    public void clearList() {
        this.listLast = null;
        this.listHead = null;
    }

    /**
     * 在头部添加
     */
    public void addfirst(int inputInt) throws Exception {
        this.insert(0, inputInt);
    }

    /**
     * 在尾部添加
     */
    public void addlast(int inputInt) throws Exception {
        this.insert(this.size, inputInt);
    }

    /**
     * 在index插入
     */
    public void insert(int index, int inputInt) throws Exception {
        if (index > this.size || index < 0) {
            throw new Exception(" index异常 ");
        }

        ListNode newNode = new ListNode(inputInt);
        ListNode tempHead = this.listHead;
        ListNode tempLast = this.listLast;

        if (this.size == 0 && this.listHead == null && this.listLast == null) {
            this.listHead = newNode;
            this.listLast = newNode;
            this.size++;
            return;
        }
        if (index == 0) {
            newNode.nextNode = this.listHead;
            newNode.previousNode = null;
            this.listHead.previousNode = newNode;
            //this.listHead.previousNode.nextNode = this.listHead;
            this.listHead = newNode;
        } else if (index == this.size) {
            newNode.previousNode = this.listLast;
            newNode.nextNode = null;
            this.listLast.nextNode = newNode;
            //newNode.previousNode.nextNode = newNode;
            this.listLast = newNode;
        } else {
            ListNode A = this.listHead;
            ListNode B = this.listHead.nextNode;
            for (int tempIndex = 0; tempIndex < (index - 1); tempIndex++) {
                A = A.nextNode;
                B = B.nextNode;
            }
            A.nextNode = newNode;
            B.previousNode = newNode;
            newNode.previousNode = A;
            newNode.nextNode = B;
        }
        this.size++;
    }

    /**
     * 在头部删除
     */
    public void deletefirst() throws Exception {
        this.delete(0);
    }

    /**
     * 在尾部删除
     */
    public void deletelast() throws Exception {
        this.delete(this.size);
    }

    /**
     * 在index删除
     */
    public void delete(int index) throws Exception {
        if (index > this.size || index < 0) {
            throw new Exception(" index异常 ");
        }
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception("数组长度为 0 ，无法返回");
        }
        if (index == 0) {
            listHead = listHead.nextNode;
        } else if (index == (this.size - 1)) {
            this.listLast = listLast.previousNode;
            this.listLast.nextNode = null;
        } else {
            ListNode A = this.listHead;
            ListNode B = this.listHead.nextNode;
            for (int tempIndex = 0; tempIndex < index - 1; tempIndex++) {
                A = A.nextNode;
                B = B.nextNode;
            }
            B = B.nextNode;
            A.nextNode = B;
            B.previousNode = A;
        }
        this.size--;
    }

    /**
     * print
     */
    public void print() throws Exception {
        if (this.listHead == null && this.listLast == null && this.size == 0) {
            throw new Exception(" 空空如也，无法打印 ");
        } else {
            ListNode tempHead = this.listHead;

            for (int i = 0; i < this.size; i++) {
                int tempInt = tempHead.Data;
                System.out.print(tempInt + ",");
                tempHead = tempHead.nextNode;
            }
            System.out.println();
        }
    }
}
