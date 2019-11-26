package com.feijm.execldeal;

import javax.swing.*;
import java.awt.*;

public class ExeclDeal4 extends JFrame {
    static JPanel jPanelSelectOne;
    static JPanel jPanelSelectTwo;
    static JPanel jPanelSelectThree;

    static JPanel jPanelWriteOne;
    static JPanel jPanelWriteTwo;
    static JPanel jPanelWriteThree;
    static JPanel jPanelWriteFour;
    static JPanel jPanelWriteFive;
    static JPanel jPanelWriteSix;

    static JPanel jPanelTwoWriteOne;
    static JPanel jPanelTwoWriteTwo;
    static JPanel jPanelTwoWriteThree;
    static JPanel jPanelTwoWriteFour;
    static JPanel jPanelTwoWriteFive;


    public static void main(String[] args) {
        ExeclDeal4 execlDeal4 = new ExeclDeal4();
    }


    private ExeclDeal4() {
        jPanelSelectOne = new JPanel();
        jPanelSelectTwo = new JPanel();
        jPanelSelectThree = new JPanel();

        jPanelWriteOne = new JPanel();
        jPanelWriteTwo = new JPanel();
        jPanelWriteThree = new JPanel();
        jPanelWriteFour = new JPanel();
        jPanelWriteFive = new JPanel();
        jPanelWriteSix = new JPanel();

        jPanelTwoWriteOne = new JPanel();
        jPanelTwoWriteTwo = new JPanel();
        jPanelTwoWriteThree = new JPanel();
        jPanelTwoWriteFour = new JPanel();
        jPanelTwoWriteFive = new JPanel();

        JPanel jPanelTempOne = new JPanel();
        JPanel jPanelTempTwo = new JPanel();
        JPanel jPanelTempThree = new JPanel();
        JPanel jPanelTempFour = new JPanel();
        JPanel jPanelTempFive = new JPanel();
        JPanel jPanelTempSix = new JPanel();
        JPanel jPanelTempSeven = new JPanel();
        JPanel jPanelTempEight = new JPanel();
        JPanel jPanelTempNine = new JPanel();

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);


        add(jPanelSelectTwo);
        add(jPanelSelectThree);

        add(jPanelWriteOne);
        add(jPanelWriteTwo);
        add(jPanelWriteThree);
        add(jPanelWriteFour);
        add(jPanelWriteFive);
        add(jPanelWriteSix);

        add(jPanelTwoWriteOne);
        add(jPanelTwoWriteTwo);
        add(jPanelTwoWriteThree);
        add(jPanelTwoWriteFour);
        add(jPanelTwoWriteFive);


        add(jPanelTempTwo);
        add(jPanelTempThree);
        add(jPanelTempFour);
        add(jPanelTempFive);
        add(jPanelTempSix);
        add(jPanelTempSeven);
        add(jPanelTempEight);
        add(jPanelTempNine);

        //定义一个GridBagConstraints，
        //是用来控制添加进的组件的显示位置
        //该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
        //NONE：不调整组件大小。
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
        //BOTH：使组件完全填满其显示区域。
        GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
        //该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        // 起始点为第1列
        gridBagConstraints_1.gridx = 0;
        // 起始点为第1行
        gridBagConstraints_1.gridy = 0;
        //  占据右移4格
        gridBagConstraints_1.gridwidth = 4;
//        gridBagConstraints.gridheight = 0;
        //// 第一列的分布方式为40%
        gridBagConstraints_1.weightx = 40;
        jPanelSelectOne.setBackground(Color.GREEN);
        gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
//        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
//        gridBagLayout.setConstraints(jPanelSelectOne, gridBagConstraints_1);
        add(jPanelSelectOne, gridBagConstraints_1);

        GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
        gridBagConstraints_2.gridx = 4;
        gridBagConstraints_2.gridy = 0;
        gridBagConstraints_2.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
        gridBagConstraints_2.weightx = 10;
        jPanelTempOne.setBackground(Color.CYAN);
        gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
//        gridBagLayout.setConstraints(jPanelTempOne, gridBagConstraints_2);
        add(jPanelTempOne, gridBagConstraints_2);

        GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
        gridBagConstraints_3.gridx = 5;
        gridBagConstraints_3.gridy = 0;
        gridBagConstraints_3.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
        gridBagConstraints_3.weightx = 10;
        jPanelWriteOne.setBackground(Color.LIGHT_GRAY);
        gridBagConstraints_3.fill = GridBagConstraints.BOTH;
//        gridBagLayout.setConstraints(jPanelWriteOne, gridBagConstraints_3);
        add(jPanelWriteOne, gridBagConstraints_3);

        GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
        gridBagConstraints_4.gridx = 6;
        gridBagConstraints_4.gridy = 0;
        gridBagConstraints_4.gridwidth = 4;
        gridBagConstraints_4.gridheight = 0;
        gridBagConstraints_4.weightx = 40;
        jPanelWriteTwo.setBackground(Color.LIGHT_GRAY);
        gridBagConstraints_4.fill = GridBagConstraints.BOTH;
//        gridBagLayout.setConstraints(jPanelWriteTwo, gridBagConstraints_4);
        add(jPanelWriteTwo, gridBagConstraints_4);

/********************************************************************************************/
//  第一行排列结束
/********************************************************************************************/
        GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
        // 起始点为第1列
        gridBagConstraints_5.gridx = 0;
        // 起始点为第1行
        gridBagConstraints_5.gridy = 1;
        //  占据右移4格
        gridBagConstraints_5.gridwidth = 4;
//        gridBagConstraints.gridheight = 0;
        JTextField jTextFieldSelect = new JTextField();
        jTextFieldSelect.setSize(100,20);
        jPanelSelectTwo.add(jTextFieldSelect);
        jPanelSelectTwo.setBackground(Color.GREEN);
        gridBagConstraints_5.fill = GridBagConstraints.BOTH;
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
//        gridBagLayout.setConstraints(jPanelSelectTwo, gridBagConstraints_5);
        add(jPanelSelectTwo, gridBagConstraints_5);

        GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
        gridBagConstraints_6.gridx = 4;
        gridBagConstraints_6.gridy = 1;
        gridBagConstraints_6.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
        gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
        jPanelTempTwo.setBackground(Color.CYAN);
//        gridBagLayout.setConstraints(jPanelTempTwo, gridBagConstraints_6);
        add(jPanelTempTwo, gridBagConstraints_6);

        GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
        gridBagConstraints_7.gridx = 5;
        gridBagConstraints_7.gridy = 1;
        gridBagConstraints_7.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 10;
        gridBagConstraints_7.fill = GridBagConstraints.BOTH;
        jPanelWriteThree.setBackground(Color.LIGHT_GRAY);
//        gridBagLayout.setConstraints(jPanelWriteThree, gridBagConstraints_7);
        add(jPanelWriteThree, gridBagConstraints_7);

        GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
        gridBagConstraints_8.gridx = 6;
        gridBagConstraints_8.gridy = 1;
        gridBagConstraints_8.gridwidth = 4;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 40;
        gridBagConstraints_8.fill = GridBagConstraints.BOTH;
        jPanelWriteFour.setBackground(Color.LIGHT_GRAY);
        gridBagLayout.setConstraints(jPanelWriteFour, gridBagConstraints_8);
        add(jPanelWriteFour, gridBagConstraints_8);

/*******************************************************************************************/
//  第二行排列结束
/*******************************************************************************************/
        // 起始点为第1列
        GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
        gridBagConstraints_9.gridx = 0;
        // 起始点为第1行
        gridBagConstraints_9.gridy = 2;
        //  占据右移4格
        gridBagConstraints_9.gridwidth = 4;
//        gridBagConstraints.gridheight = 0;
        jPanelSelectThree.setBackground(Color.GREEN);
        gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
//        gridBagLayout.setConstraints(jPanelSelectThree, gridBagConstraints_9);
        add(jPanelSelectThree, gridBagConstraints_9);

        GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
        gridBagConstraints_10.gridx = 4;
        gridBagConstraints_10.gridy = 2;
        gridBagConstraints_10.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
        gridBagConstraints_10.fill = GridBagConstraints.HORIZONTAL;
        jPanelTempThree.setBackground(Color.CYAN);
        gridBagLayout.setConstraints(jPanelTempThree, gridBagConstraints_10);
        add(jPanelTempThree, gridBagConstraints_10);

        GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
        gridBagConstraints_11.gridx = 5;
        gridBagConstraints_11.gridy = 2;
        gridBagConstraints_11.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 10;
        gridBagConstraints_11.fill = GridBagConstraints.BOTH;
        jPanelWriteFive.setBackground(Color.LIGHT_GRAY);
        gridBagLayout.setConstraints(jPanelWriteFive, gridBagConstraints_11);
        add(jPanelWriteFive, gridBagConstraints_11);

        GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
        gridBagConstraints_12.gridx = 6;
        gridBagConstraints_12.gridy = 2;
        gridBagConstraints_12.gridwidth = 4;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 40;
        gridBagConstraints_12.fill = GridBagConstraints.BOTH;
        jPanelWriteSix.setBackground(Color.LIGHT_GRAY);
//        gridBagLayout.setConstraints(jPanelWriteSix, gridBagConstraints_12);
        add(jPanelWriteSix, gridBagConstraints_12);
/*******************************************************************************************/
//  第三行排列结束
/*******************************************************************************************/
        // 起始点为第1列
        GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
        gridBagConstraints_13.gridx = 0;
        // 起始点为第1行
        gridBagConstraints_13.gridy = 3;
        //  占据右移4格
        gridBagConstraints_13.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
        jPanelTwoWriteOne.setBackground(Color.GREEN);
        gridBagConstraints_13.fill = GridBagConstraints.HORIZONTAL;
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
//        gridBagLayout.setConstraints(jPanelTwoWriteOne, gridBagConstraints_13);
        add(jPanelTwoWriteOne, gridBagConstraints_13);

        GridBagConstraints gridBagConstraints_14 = new GridBagConstraints();
        gridBagConstraints_14.gridx = 1;
        gridBagConstraints_14.gridy = 3;
        gridBagConstraints_14.gridwidth = 3;
//        gridBagConstraints.gridheight = 0;
        jPanelTwoWriteTwo.setBackground(Color.CYAN);
        gridBagConstraints_14.fill = GridBagConstraints.HORIZONTAL;
//        gridBagLayout.setConstraints(jPanelTwoWriteTwo, gridBagConstraints_14);
        add(jPanelTwoWriteTwo,gridBagConstraints_14);

        GridBagConstraints gridBagConstraints_15 = new GridBagConstraints();
        gridBagConstraints_15.gridx = 4;
        gridBagConstraints_15.gridy = 3;
        gridBagConstraints_15.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 10;
        gridBagConstraints_15.fill = GridBagConstraints.HORIZONTAL;
        jPanelTempFour.setBackground(Color.LIGHT_GRAY);
//        gridBagLayout.setConstraints(jPanelTempFour, gridBagConstraints_15);
        add(jPanelTempFour,gridBagConstraints_15);


        GridBagConstraints gridBagConstraints_16 = new GridBagConstraints();
        gridBagConstraints_16.gridx = 5;
        gridBagConstraints_16.gridy = 3;
        gridBagConstraints_16.gridwidth = 1;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 40;
        gridBagConstraints_16.fill = GridBagConstraints.HORIZONTAL;
        jPanelTwoWriteThree.setBackground(Color.LIGHT_GRAY);
//        gridBagLayout.setConstraints(jPanelTwoWriteThree, gridBagConstraints_16);
        add(jPanelTwoWriteThree, gridBagConstraints_16);

        GridBagConstraints gridBagConstraints_17 = new GridBagConstraints();
        gridBagConstraints_17.gridx = 6;
        gridBagConstraints_17.gridy = 3;
        gridBagConstraints_17.gridwidth = 4;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 40;
        gridBagConstraints_17.fill = GridBagConstraints.BOTH;
        jPanelTwoWriteFour.setBackground(Color.LIGHT_GRAY);
//        gridBagLayout.setConstraints(jPanelTwoWriteFour, gridBagConstraints_17);
        add(jPanelTwoWriteFour,gridBagConstraints_17);

/*******************************************************************************************/
//  第四行排列结束
/*******************************************************************************************/
        GridBagConstraints gridBagConstraints_18 = new GridBagConstraints();
        gridBagConstraints_18.gridx = 0;
        gridBagConstraints_18.gridy = 4;
        gridBagConstraints_18.gridwidth = 10;
//        gridBagConstraints.gridheight = 0;
//        gridBagConstraints.weightx = 10;
        jPanelTwoWriteFive.setBackground(Color.LIGHT_GRAY);
        gridBagConstraints_18.fill = GridBagConstraints.BOTH;
//        gridBagLayout.setConstraints(jPanelTwoWriteFive, gridBagConstraints_18);
        add(jPanelTwoWriteFive,gridBagConstraints_18);
/*******************************************************************************************/
//  第五行排列结束
/*******************************************************************************************/

/*******************************************************************************************/
//  panelSet    面板的设置
        JButton selectButton = new JButton("点击读取本地execl");
        JTextField jTextField = new JTextField();
        JButton decideButton = new JButton("点击确认，开始读取");

        JLabel jLabelOne = new JLabel("次月还款");
        JTextField jTextFieldOne = new JTextField();
        JLabel jLabelTwo = new JLabel("次次月还款");
        JTextField jTextFieldTwo = new JTextField();
        JLabel jLabelThree = new JLabel("次次次月还款");
        JTextField jTextFieldThree = new JTextField();

        JLabel writeJLableOne = new JLabel("上月时间");
        JTextField writeJTextOne = new JTextField();
        JLabel writeJLableTwo = new JLabel("本月时间");
        JTextField writeJTextTwo = new JTextField();
        JButton writeButton = new JButton("点击确认，输出execl");

        jPanelSelectOne.add(selectButton);
        jPanelSelectTwo.add(jTextField);
        jPanelSelectThree.add(decideButton);

        jPanelWriteOne.add(jLabelOne);
        jPanelWriteTwo.add(jTextFieldOne);
        jPanelWriteThree.add(jLabelTwo);
        jPanelWriteFour.add(jTextFieldTwo);
        jPanelWriteFive.add(jLabelThree);
        jPanelWriteSix.add(jTextFieldThree);

        jPanelTwoWriteOne.add(writeJLableOne);
        jPanelTwoWriteTwo.add(writeJTextOne);
        jPanelTwoWriteThree.add(writeJLableTwo);
        jPanelTwoWriteFour.add(writeJTextTwo);
        jPanelTwoWriteFive.add(writeButton);


        setBounds(0, 0, 1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //  设置最外层界面的大小
//        设置窗口是否可见，true and false
        setVisible(true);
//        设置窗体是否可以可以改变大小
        setResizable(true);
    }
}
