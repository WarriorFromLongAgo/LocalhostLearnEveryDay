package com.byit.swing;

import javax.swing.*;

public class SwingTest {
    public static void main(String[] args) {
        login();
    }

    private static void login() {
        //  登录的主界面
        JFrame jFrame = new JFrame("学生登录管理界面");
        //JFrame.EXIT_ON_CLOSE 关闭窗口，同时停止程序
        //JFrame.DO_NOTHING_ON_CLOSE 不可以关闭
        //JFrame.HIDE_ON_CLOSE 隐藏窗口，但是不停止程序
        //JFrame.DISPOSE_ON_CLOSE 关闭窗口，过一段时间，程序停止
        //frameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frameDemo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //frameDemo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //  设置长宽高
        jFrame.setBounds(200, 200, 350, 200);
        //  设置一个JPanel对象
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        //  绝对布局
        jPanel.setLayout(null);
        //  账号密码
        JLabel jfAccount = new JLabel("账号");
        JLabel jfPassword = new JLabel("密码");
        //  添加进jp对象
        jPanel.add(jfAccount);
        jPanel.add(jfPassword);
        //  设置账号 和 密码框框的大小和位置
        jfAccount.setBounds(50, 20, 80, 25);
        jfPassword.setBounds(50, 50, 80, 25);
        //  账号的输入框
        JTextField textFieldUserName = new JTextField();
        textFieldUserName.setBounds(110, 20, 165, 25);
        jPanel.add(textFieldUserName);
        //  密码的输入栏
        JPasswordField textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(110, 50, 165, 25);
        jPanel.add(textFieldPassword);
//        JTextField textFieldPassword = new JTextField();
//        textFieldPassword.setBounds(110, 50, 165, 25);
//        jPanel.add(textFieldPassword);

        //  登录 和 注册 按钮的实现
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(120, 100, 80, 25);
        jPanel.add(loginButton);
        //  登录 和 注册 按钮的实现
        JButton registrationButton = new JButton("注册");
        registrationButton.setBounds(220, 100, 80, 25);
        jPanel.add(registrationButton);

        //设置窗口是否可见，true and false
        jFrame.setVisible(true);

        //设置窗体是否可以可以改变大小
        jFrame.setResizable(true);
    }
}
