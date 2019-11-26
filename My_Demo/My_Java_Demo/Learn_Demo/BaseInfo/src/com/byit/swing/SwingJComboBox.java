package com.byit.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingJComboBox {
    public static void main(String[] args) {
        testJComboBox();
    }

    private static void testJComboBox() {
        String[] str = {"中国", "美国", "日本", "英国", "法国", "意大利", "澳大利亚"};
        JFrame frame = new JFrame("下拉框的处理");

        JLabel message = new JLabel();

        JComboBox combo = new JComboBox(str);
        combo.setBorder(BorderFactory.createTitledBorder("你最喜欢去哪个国家旅游?"));
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("你选择了:" + str[combo.getSelectedIndex()]);
            }
        });

        frame.setLayout(new GridLayout(1, 0));
        frame.add(message);
        frame.add(combo);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
