//package com.feijm.javaframe;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class BorderLayoutDemo {
//    public static void main(String[] args) {
//        JFrame jFrameThree = new JFrame("这是第三个GUI程序");
//        jFrameThree.setSize(400,200);
//        //jFrameThree.setBounds(200,200,300,300);
//
//        ////为Frame窗口设置布局为BorderLayout
//
//        jFrameThree.setLayout(new BorderLayout());
//
//        JButton buttonOne = new JButton("上");
//        JButton buttonTwo = new JButton("左");
//        JButton buttonThree = new JButton("中");
//        JButton buttonFour = new JButton("右");
//        JButton buttonFive = new JButton("下");
//        jFrameThree.add(buttonOne,BorderLayout.NORTH);
//        jFrameThree.add(buttonTwo,BorderLayout.WEST);
//        jFrameThree.add(buttonThree,BorderLayout.CENTER);
//        jFrameThree.add(buttonFour,BorderLayout.EAST);
//        jFrameThree.add(buttonFive,BorderLayout.SOUTH);
//        jFrameThree.setBounds(300,200,600,300);
//        Container container = jFrameThree.getContentPane();
//        container.add(buttonOne);
//        container.add(buttonTwo);
//        container.add(buttonThree);
//        container.add(buttonFour);
//        container.add(buttonFive);
//        container.validate();
//        jFrameThree.setContentPane(container);
//
//        jFrameThree.setVisible(true);
//        jFrameThree.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//}
