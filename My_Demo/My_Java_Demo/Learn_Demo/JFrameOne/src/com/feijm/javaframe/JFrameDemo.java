//package com.feijm.javaframe;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class JFrameDemo extends JFrame {
//
//    public JFrameDemo() {
//        //创建窗体对象
//        //继承后，不需要new对象
//        //JFrame frameDemo = new JFrame("窗体标题");
//
//        //设置窗体可见，，删掉所有的对象
//        setVisible(true);
//        //设置标题
//        setTitle("这是一个窗口");
//        //JFrame.EXIT_ON_CLOSE 关闭窗口，同时停止程序
//        //JFrame.DO_NOTHING_ON_CLOSE 不可以关闭
//        //JFrame.HIDE_ON_CLOSE 隐藏窗口，但是不停止程序
//        //JFrame.DISPOSE_ON_CLOSE 关闭窗口，过一段时间，程序停止
//        //frameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //frameDemo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        //frameDemo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        //设置窗体的大小，单位是像素
////        frameDemo.setSize(300, 300);
////        //设置坐标，单位像素
////        frameDemo.setLocation(200, 200);
//        //可以一次性设置窗体大小，以及窗体的坐标
//        setBounds(200, 200, 300, 300);
//        //获取窗体容器
//        Container container = getContentPane();
//        container.setBackground(Color.white);
//        //生成一个文本框组件
//        //JLabel jLabelOne = new JLabel("这是一个窗体");
//        JLabel jLabelTwo = new JLabel("这是放在JPanel上的标签");
//
//        //创建一个JPanel对象
//        JPanel jPanelOne = new JPanel();
//
//        //添加组件
//        container.add(jLabelTwo);
//        container.add(jPanelOne);
//        //删除组件
//        //container.remove(jLabelOne);
//        //验证容器中的组件
//        container.validate();
//        //重新载入容器
//        setContentPane(container);
//        //设置窗口是否可见，true and false
//        setVisible(true);
//        //设置窗体是否可以可以改变大小
//        setResizable(true);
//        //好像会和窗口设置的大小长宽冲突
//        //pack();
//
//        System.out.println("x= " + getX() + ",y= " + getY());
//    }
//
//    public static void main(String[] args) {
//
//        new JFrameDemo();
//    }
//}
