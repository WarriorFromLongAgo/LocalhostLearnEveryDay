package com.byit.swing;

import javax.swing.*;
import java.awt.*;

public class SwingTable {
    public static void main(String[] args) {
        tablel();
    }

    private static void tablel() {

        Object[][] unit = {
                {"张三", "86", "94", "180"},
                {"李四", "92", "96", "188"},
                {"王五", "66", "80", "146"},
                {"赵六", "98", "94", "192"},
                {"刘七", "81", "83", "164"},
        };
        Object[] name = {"姓名", "语文", "数学", "总成绩"};
        //  row data    行数据
        //  column Names 列名称
        JTable table = new JTable(unit, name);
        //  每行的高度
        table.setRowHeight(30);
        //  被选择的行的底部的颜色
        table.setSelectionBackground(Color.RED);
        //  被选择的行的字体的颜色
        table.setSelectionForeground(Color.BLUE);
        JFrame frame = new JFrame("表格数据处理");
//        JPanel
        //  将表格包装进入JScrollPane, 他提供轻量级组件的可滚动视图。
        frame.add(new JScrollPane(table));
        frame.setSize(350, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
