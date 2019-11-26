package com.feijm.datechoose;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);

        Date date = new Date();

        final JXDatePicker datepick = new JXDatePicker();

        // 设置 date日期
        datepick.setDate(date);

        datepick.setBounds(137, 83, 177, 24);

        f.add(datepick);

        JButton b = new JButton("获取时间");
        b.setBounds(137, 183, 100, 30);
        f.add(b);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取 日期
                Date d = datepick.getDate();
                System.out.println(d);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(d);
                System.out.println(format);
                JOptionPane.showMessageDialog(f, "获取控件中的日期 :" + d);

            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
