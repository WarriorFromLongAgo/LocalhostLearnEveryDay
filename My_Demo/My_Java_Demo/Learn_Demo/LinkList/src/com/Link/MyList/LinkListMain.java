package com.Link.MyList;

public class LinkListMain {
    public static void main(String[] args) throws Exception {
        LinkList mylist = new LinkList();
        mylist.addlast(1111);
        mylist.addlast(2222);
        mylist.addlast(0000);
        mylist.addlast(3333);

        mylist.insert(1, 1);
        mylist.insert(4, 4444);
        mylist.print();
//        mylist.deletefirst();
        //mylist.deletelast();
        mylist.delete(mylist.getCount() - 2);
        mylist.print();

        System.out.println("maxdata = " + mylist.getmax());
        System.out.println("mindata = " + mylist.getmin());

        System.out.println();
        mylist.print();
    }
}
