//package com.Link.MyList;
//
///**
// * @Author:
// * @Project:
// * @Time:
// * @version:
// * @修改原因:
// */
//public class MyList<T> {
//    private int size;
//    private ListNode listLast;
//    private ListNode listHead;
//
//    public MyList() {
//        this.size = 0;
//        this.listHead = null;
//        this.listLast = null;
//    }
//
//    /**
//     * 在index插入
//     */
//    public void insert(int index, T inputInt) {
//        ListNode newNode = new ListNode(inputInt);
//        ListNode tempHead = this.listHead;
//        ListNode tempLast = this.listLast;
//
//        if (this.size == 0 && this.listHead == null && this.listLast == null) {
//            this.listHead = newNode;
//            this.listLast = newNode;
//            this.size++;
//            return;
//        }
//        if (index == 0) {
//            newNode.nextNode = this.listHead;
//            newNode.previousNode = null;
//            this.listHead.previousNode = newNode;
//            //this.listHead.previousNode.nextNode = this.listHead;
//            this.listHead = newNode;
//        } else if (index == this.size) {
//            newNode.previousNode = this.listLast;
//            newNode.nextNode = null;
//            this.listLast.nextNode = newNode;
//            //newNode.previousNode.nextNode = newNode;
//            this.listLast = newNode;
//        } else {
//            ListNode A = this.listHead;
//            ListNode B = this.listHead.nextNode;
//            for (int tempIndex = 0; tempIndex < (index - 1); tempIndex++) {
//                A = A.nextNode;
//                B = B.nextNode;
//            }
//            A.nextNode = newNode;
//            B.previousNode = newNode;
//            newNode.previousNode = A;
//            newNode.nextNode = B;
//        }
//        this.size++;
//    }
//
//    public< void print() throws Exception {
//        if (this.listHead == null && this.listLast == null && this.size == 0) {
//            throw new Exception(" 空空如也，无法打印 ");
//        } else {
//            ListNode tempHead = this.listHead;
//
//            for (int i = 0; i < this.size; i++) {
//                T tempInt = tempHead.Data;
//                System.out.print(tempInt + ",");
//                tempHead = tempHead.nextNode;
//            }
//            System.out.println();
//        }
//
//
//    }
//}
