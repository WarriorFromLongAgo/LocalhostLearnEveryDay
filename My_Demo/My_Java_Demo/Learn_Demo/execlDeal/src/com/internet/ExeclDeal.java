package com.internet;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：
 * @more info   ：
 * @more info   ：
 */
public class ExeclDeal extends JFrame{
    private static Object[][] objArr = null;

    public static void main(String[] args) {
        ExeclDeal execlDeal = new ExeclDeal();
        execlDeal.setTitle("文件处理界面");
        Container container = execlDeal.getContentPane();

        JPanel jPanelJframe = new JPanel();
        execlDeal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        execlDeal.setBounds(10, 10, 1300, 700);
        execlDeal.add(jPanelJframe);
        execlDeal.setLayout(null);


/*=============================================================================================*/

        JPanel jPanelRead = new JPanel();
        jPanelRead.setBounds(10,10,100,100);
        jPanelRead.setBackground(Color.GREEN);

//        选择本地execl文件的处理
        JButton selectExeclButton = new JButton("点击读取本地execl文件");
        selectExeclButton.setBounds(0, 0, 300, 30);
        jPanelRead.add(selectExeclButton);
        selectExeclButton.setBackground(Color.GREEN);

//        execl文件的地址
        JTextField textFieldFilePath = new JTextField();
//        设置大小，以及xy轴
        textFieldFilePath.setBounds(10, 50, 300, 30);
//        设置文本的水平对齐方式
        textFieldFilePath.setHorizontalAlignment(JTextField.CENTER);
//        将textFieldFilePath添加至jPanelRead容器
        jPanelRead.add(textFieldFilePath);

//        点击确认读取execl
        JButton decideButton = new JButton();
        decideButton.setText("点击读取execl至表格");
        decideButton.setBounds(320, 10, 100, 70);
        jPanelRead.add(decideButton);
        decideButton.setBackground(Color.GREEN);

//        jPanelJframe.add(jPanelRead,new GridBagLayout());
        jPanelJframe.add(jPanelRead);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replaceAll("-",""));
/*=============================================================================================*/
        JPanel jPanelSelect = new JPanel();

        jPanelSelect.setBounds(110,10,100,100);
        jPanelRead.setBackground(Color.CYAN);

        JLabel label1 = new JLabel("次月回款");
        label1.setBounds(10,10,20,20 );
        JTextField jTextFieldLabel1 = new JTextField();
        jTextFieldLabel1.setBounds(10,10,25,20);

        JLabel label2 = new JLabel("次次月回款");
        label1.setBounds(10,30,20,20 );
        JTextField jTextFieldLabel2 = new JTextField();
        jTextFieldLabel1.setBounds(30,10,25,20);

        JLabel label3 = new JLabel("次次次月回款");
        label1.setBounds(10,50,20,20 );
        JTextField jTextFieldLabel3 = new JTextField();
        jTextFieldLabel1.setBounds(40,10,25,20);


        jPanelJframe.add(jPanelSelect);
/*=============================================================================================*/
        JPanel jPanelWrite = new JPanel();
        jPanelWrite.setBounds(110,10,100,100);
        jPanelRead.setBackground(Color.green);

        jPanelJframe.add(jPanelWrite);
/*=============================================================================================*/
        JPanel jPanelTable = new JPanel();
        jPanelTable.setBounds(200,10,200,200);
        jPanelRead.setBackground(Color.red);

        jPanelJframe.add(jPanelTable);
/*=============================================================================================*/

//        自动改变适应的大小
//        jFrame.pack();

        container.add(jPanelJframe);
//        设置窗口是否可见，true and false
        execlDeal.setVisible(true);
//        设置窗体是否可以可以改变大小
        execlDeal.setResizable(true);
    }
}
