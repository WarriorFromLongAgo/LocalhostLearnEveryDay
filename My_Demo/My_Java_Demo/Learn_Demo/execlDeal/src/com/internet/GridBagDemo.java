package com.internet;

import javax.swing.*;
import java.awt.*;

public class GridBagDemo extends JFrame {
    public static void main(String args[]) {
        GridBagDemo demo = new GridBagDemo();
    }

    public GridBagDemo() {
        init();
        this.setSize(600, 600);
        this.setVisible(true);
    }

    public void init() {
        jButtonOpen = new JButton("打开");
        jButtonSave = new JButton("保存");
        jButtonSaveAs = new JButton("另存为");
        jPanel = new JPanel();
        String[] str = {"java笔记", "C#笔记", "HTML5笔记"};
        jComboBox = new JComboBox(str);
        jTextField = new JTextField();
        jButtonClear = new JButton("清空");
        jList = new JList(str);
        jPanel2 = new JPanel();
        //为了看出效果，设置了颜色
        jPanel2.setBackground(Color.PINK);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        //把组件添加进jframe
        this.add(jButtonOpen);
        this.add(jButtonSave);
        this.add(jButtonSaveAs);
        this.add(jPanel);
        this.add(jComboBox);
        this.add(jTextField);
        this.add(jButtonClear);
        this.add(jList);
        this.add(jPanel2);

        //定义一个GridBagConstraints，
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        //是用来控制添加进的组件的显示位置
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        //该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
        //NONE：不调整组件大小。
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
        //BOTH：使组件完全填满其显示区域。

        //该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        gridBagConstraints.gridwidth = 1;
        //该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        gridBagConstraints.weightx = 0;
        //该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        gridBagConstraints.weighty = 0;
        //设置组件
        layout.setConstraints(jButtonOpen, gridBagConstraints);


        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        layout.setConstraints(jButtonSave, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        layout.setConstraints(jButtonSaveAs, gridBagConstraints);

        //该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        gridBagConstraints.gridwidth = 0;
        //不能为1，j4是占了4个格，并且可以横向拉伸，
        gridBagConstraints.weightx = 0;
        //但是如果为1，后面行的列的格也会跟着拉伸,导致j7所在的列也可以拉伸
        //所以应该是跟着j6进行拉伸
        gridBagConstraints.weighty = 0;
        layout.setConstraints(jPanel, gridBagConstraints);

        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        layout.setConstraints(jComboBox, gridBagConstraints);

        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        layout.setConstraints(jTextField, gridBagConstraints);

        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        layout.setConstraints(jButtonClear, gridBagConstraints);

        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 1;
        layout.setConstraints(jList, gridBagConstraints);

        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 1;
        layout.setConstraints(jPanel2, gridBagConstraints);

        JTable jTable = new JTable(4,4);
        jPanel2.add(jTable);
    }

    JButton jButtonOpen;
    JButton jButtonSave;
    JButton jButtonSaveAs;
    JPanel jPanel;
    JComboBox jComboBox;
    JTextField jTextField;
    JButton jButtonClear;
    JList jList;
    JPanel jPanel2;
}
