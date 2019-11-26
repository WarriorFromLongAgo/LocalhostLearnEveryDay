package com.Link.MyList;

public class ListNode {
    public int Data;
    public ListNode previousNode;
    public ListNode nextNode;

    //No parameter Constructor
    //无参数构造函数
    public ListNode() {

    }

    //Parameter constructor
    //有参数构造函数
    public ListNode(int data) {
        this.Data = data;
    }

    public ListNode(int data, ListNode previousNode, ListNode nextNode) {
        this.Data = data;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public ListNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(ListNode previousNode) {
        this.previousNode = previousNode;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
