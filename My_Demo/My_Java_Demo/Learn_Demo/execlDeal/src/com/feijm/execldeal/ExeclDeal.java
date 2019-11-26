package com.feijm.execldeal;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.jdesktop.swingx.JXDatePicker;

import javax.sql.PooledConnection;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class ExeclDeal extends JFrame {
    private static Object[][] objArr = null;
    private static List<ExeclModel> execlModelList = new ArrayList<>();

    public static void main(String[] args) {
        ExeclDeal execlDeal = new ExeclDeal();
//        execlDeal.Mainface();

    }

    public void Mainface() {
        //  文件处理界面
        JFrame jFrame = new JFrame("文件处理界面");
        //JFrame.DISPOSE_ON_CLOSE 关闭窗口，过一段时间，程序停止
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //  设置最外层界面的大小
        jFrame.setBounds(10, 10, 1300, 700);
        //  设置一个JPanel对象    创建内容面板
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        //  绝对布局
        jPanel.setLayout(null);

        //  选择本地execl文件的处理
        JButton selectExeclButton = new JButton("点击获取，本地execl文件路径");
        selectExeclButton.setBounds(10, 10, 300, 30);
        jPanel.add(selectExeclButton);
        selectExeclButton.setBackground(Color.GREEN);

        JTextField textFieldFilePath = new JTextField("显示路径");
        textFieldFilePath.setBounds(10, 50, 300, 30);
        textFieldFilePath.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(textFieldFilePath);

        JButton decideButton = new JButton("确定读取");
        decideButton.setBounds(320, 10, 100, 70);
        jPanel.add(decideButton);
        decideButton.setBackground(Color.GREEN);

        JTextField textFieldWarningOne = new JTextField("注意：必须先点击 确定读取");
        textFieldWarningOne.setBounds(10, 170, 300, 30);
        textFieldWarningOne.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(textFieldWarningOne);

        JButton popupButton = new JButton("点击查看读取的文件");
        popupButton.setBounds(10, 200, 300, 30);
        popupButton.setBackground(Color.GREEN);
        jPanel.add(popupButton);

        JLabel jLabelOne = new JLabel("次月还款", JLabel.CENTER);
        jLabelOne.setBounds(500, 10, 100, 30);
        //必须设置底部为透明的
        jLabelOne.setOpaque(true);
        jLabelOne.setBackground(Color.GREEN);
        jPanel.add(jLabelOne);
        JTextField oneTextField = new JTextField("0");
        oneTextField.setBounds(620, 10, 150, 30);
        oneTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(oneTextField);

        JLabel examplejlabletwo = new JLabel("<html>四个地方都是输入数字的，同时保证四个相加，和为100</html>");
        examplejlabletwo.setBounds(780, 10, 100, 110);
        examplejlabletwo.setOpaque(true);
        examplejlabletwo.setBackground(Color.GREEN);
        jPanel.add(examplejlabletwo);

        JLabel jLabelTwo = new JLabel("次次月还款", JLabel.CENTER);
        jLabelTwo.setBounds(500, 50, 100, 30);
        //必须设置底部为透明的
        jLabelTwo.setOpaque(true);
        jLabelTwo.setBackground(Color.GREEN);
        jPanel.add(jLabelTwo);
        JTextField twoTextField = new JTextField("0");
        twoTextField.setBounds(620, 50, 150, 30);
        twoTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(twoTextField);

        JLabel jLabelThree = new JLabel("次次次月还款", JLabel.CENTER);
        jLabelThree.setBounds(500, 90, 100, 30);
        //必须设置底部为透明的
        jLabelThree.setOpaque(true);
        jLabelThree.setBackground(Color.GREEN);
        jPanel.add(jLabelThree);
        JTextField threeTextField = new JTextField("0");
        threeTextField.setBounds(620, 90, 150, 30);
        threeTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(threeTextField);

        JLabel jLabelFour = new JLabel("保证金", JLabel.CENTER);
        jLabelFour.setBounds(500, 130, 100, 30);
        //必须设置底部为透明的
        jLabelFour.setOpaque(true);
        jLabelFour.setBackground(Color.GREEN);
        jPanel.add(jLabelFour);
        JTextField fourTextField = new JTextField("0");
        fourTextField.setBounds(620, 130, 50, 30);
        fourTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(fourTextField);
        JLabel jLabelSix = new JLabel("<html>左边是百分比 右边是月份</html>", JLabel.CENTER);
        jLabelSix.setBounds(680, 130, 90, 50);
        //必须设置底部为透明的
        jLabelSix.setOpaque(true);
        jLabelSix.setBackground(Color.GREEN);
        jPanel.add(jLabelSix);
        JTextField fiveTextField = new JTextField("0");
        fiveTextField.setBounds(800, 130, 50, 30);
        fiveTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(fiveTextField);
        JLabel jLabelFive = new JLabel("个月后还", JLabel.CENTER);
        jLabelFive.setBounds(850, 130, 70, 30);
        //必须设置底部为透明的
        jLabelFive.setOpaque(true);
        jLabelFive.setBackground(Color.GREEN);
        jPanel.add(jLabelFive);
        /*
         *
         * 下方为WriteToExecl区域
         *
         *
         * */
        JLabel examplejlable = new JLabel("下方为日期选择", JLabel.CENTER);
        examplejlable.setBounds(925, 170, 100, 30);
        examplejlable.setOpaque(true);
        examplejlable.setBackground(Color.GREEN);
        jPanel.add(examplejlable);

        JLabel writejlabelone = new JLabel("第一个日期", JLabel.CENTER);
        writejlabelone.setBounds(500, 200, 100, 30);
        //必须设置底部为透明的
        writejlabelone.setOpaque(true);
        writejlabelone.setBackground(Color.GREEN);
        jPanel.add(writejlabelone);
        JTextField writejtextone = new JTextField();
        writejtextone.setBounds(620, 200, 300, 30);
        writejtextone.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(writejtextone);
        //  日期控件
        Date date = new Date();
        JXDatePicker jxDatePickerOne = new JXDatePicker();
        jxDatePickerOne.setDate(date);
        jxDatePickerOne.setBounds(925, 200, 100, 30);
        jPanel.add(jxDatePickerOne);
        jxDatePickerOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date tempdate = jxDatePickerOne.getDate();
//                System.out.println(tempdate);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOne = simpleDateFormat.format(tempdate);
                writejtextone.setText(dateOne);
            }
        });

        JLabel writejlabeltwo = new JLabel("第二个日期", JLabel.CENTER);
        writejlabeltwo.setBounds(500, 240, 100, 30);
        //必须设置底部为透明的
        writejlabeltwo.setOpaque(true);
        writejlabeltwo.setBackground(Color.GREEN);
        jPanel.add(writejlabeltwo);
        JTextField writejtexttwo = new JTextField();
        writejtexttwo.setBounds(620, 240, 300, 30);
        writejtexttwo.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(writejtexttwo);
//  日期控件
//        Date date = new Date();
        JXDatePicker jxDatePickerTwo = new JXDatePicker();
        jxDatePickerTwo.setDate(date);
        jxDatePickerTwo.setBounds(925, 240, 100, 30);
        jPanel.add(jxDatePickerTwo);
        jxDatePickerTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date tempdate = jxDatePickerTwo.getDate();
//                System.out.println(tempdate);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOne = simpleDateFormat.format(tempdate);
                writejtexttwo.setText(dateOne);
            }
        });

        JButton writeExecl = new JButton("输出为Execl文件");
        writeExecl.setBounds(500, 280, 420, 30);
        writeExecl.setBackground(Color.GREEN);
        jPanel.add(writeExecl);


        selectExeclButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();             //设置选择器
                chooser.setMultiSelectionEnabled(true);             //设为多选
                int returnVal = chooser.showOpenDialog(selectExeclButton);        //是否打开文件选择框
                System.out.println("returnVal=" + returnVal);
                if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
                    System.out.println(filepath);
                    textFieldFilePath.setText(filepath);
                }
            }
        });
        decideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filepath = textFieldFilePath.getText();

                if ("".equals(filepath) || filepath == null) {
                    JOptionPane.showMessageDialog(getContentPane(), "请先选择文件~",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!(filepath.endsWith("xlsx") || filepath.endsWith("xls"))) {
                    JOptionPane.showMessageDialog(getContentPane(), "请选择Excel文件~",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                /* 打开文件 */
                try {
                    readExecl(filepath);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                //  Java Swing表格显示
                Object[][] tempObjArr = new Object[objArr.length][12];

                System.out.println("==============================");
                System.out.println("==============================");
                System.out.println("==============================");
                System.out.println("==============================");
                String billingTime = null;
                double payment = 0;
                for (int i = 0; i < objArr.length; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (j == 2 && i != 0) {
                            billingTime = objArr[i][j].toString();
                        }
                        if (j == 11 && i != 0) {
                            payment = Double.parseDouble((String) objArr[i][j]);
                            execlModelList.add(new ExeclModel(billingTime, payment));

                        }
                        tempObjArr[i][j] = objArr[i][j];

//                        System.out.print(objArr[i][j] + ",");
                    }
//                    System.out.println();
                }
                for (ExeclModel execlModel : execlModelList) {
                    System.out.println(execlModel);
                }


                for (int i = 1; i < tempObjArr.length; i++) {
                    for (int j = 0; j < tempObjArr[i].length; j++) {
//                        tempObjArr[i][j] = tempObjArr[i][j];
                        System.out.print(tempObjArr[i][j] + ",");
                    }
                    System.out.println();
                }

                //  横标题
                Object[] objectArrTitle = new Object[tempObjArr[0].length];

                for (int i = 0; i < tempObjArr[0].length; i++) {
                    objectArrTitle[i] = tempObjArr[0][i];
                }

                System.out.println("==============================");
                System.out.println("==============================");
                System.out.println("==============================");
                System.out.println("==============================");


                //  临时开辟一个窗口用来显示读取到的文件数据
                popupButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //  新建一个popupJframe
                        JFrame popupJframe = new JFrame("显示表格页面");

                        //新建一个表格，把第一行列名， 和表格数据传入
                        JTable jTablePopup = new JTable(tempObjArr, objectArrTitle);
                        //  设置大小。
                        jTablePopup.setPreferredScrollableViewportSize(new Dimension(1000, 700));
                        //  垂直滚都条 和 水平滚动条
                        JScrollPane jScrollPane = new JScrollPane(jTablePopup, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                        //  字体居中显示，并且添加进入popupJframe
                        popupJframe.getContentPane().add(jScrollPane, BorderLayout.CENTER);
                        //  设置表格的自动调整模式
                        jTablePopup.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                        popupJframe.pack();
                        popupJframe.setBounds(20, 20, 1000, 700);
                        popupJframe.setLayout(null);
                        popupJframe.setVisible(true);
                    }
                });
            }
        });

        writeExecl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strNext = oneTextField.getText();
                String strNextNext = twoTextField.getText();
                String strNextNextNext = threeTextField.getText();
                String strEarnestMoney = fourTextField.getText();
                String strAfterMouth = fiveTextField.getText();

                boolean flag = fingNotInt(strNext, strNextNext, strNextNextNext, strEarnestMoney, strAfterMouth);
                if (!flag) {
                    JOptionPane.showMessageDialog(getContentPane(), "请检查次月，次次月，次次次月，保证金的输入框，存在非法数字",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int next = Integer.parseInt(strNext);
                int nextNext = Integer.parseInt(strNextNext);
                int nextNextNext = Integer.parseInt(strNextNextNext);
                int earnestMoney = Integer.parseInt(strEarnestMoney);
                int afterMouth = Integer.parseInt(strAfterMouth);

                if ((next + nextNext + nextNextNext + earnestMoney) != 100) {
                    JOptionPane.showMessageDialog(getContentPane(), "次月，次次月，次次次月，保证金，相加百分比不为 100",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String writeTextOne = writejtextone.getText();
                String writeTextTwo = writejtexttwo.getText();

                System.out.println(writeTextOne);
                System.out.println(writeTextTwo);

//===========================================================================================
                //  金额的合并，，相同月份的，金额，进行合并
                Map<String, Double> strDoubleMap = new LinkedHashMap<>();
                for (ExeclModel execlModel : execlModelList) {
                    //  key键
                    String billingTime = execlModel.getBillingTime();
                    //  旧的价格，通过查找旧的map，得到旧的贷款价格
                    Double oldDouble = strDoubleMap.get(billingTime);
                    //  key键对应的vlaue价格
                    double keyValueDouble = execlModel.getPayment();

                    if (strDoubleMap.containsKey(billingTime)) {
                        strDoubleMap.replace(billingTime, oldDouble, oldDouble + keyValueDouble);
                    } else {
                        strDoubleMap.put(billingTime, keyValueDouble);
                    }
                }


                for (Map.Entry<String, Double> stringDoubleEntry : strDoubleMap.entrySet()) {
                    System.out.print("key = " + stringDoubleEntry.getKey());
                    System.out.println("，value = " + stringDoubleEntry.getValue());
                }
//===========================================================================================


            }
        });

        //  关闭的时候关机java虚拟机
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

//        decideButton.get
        //设置窗口是否可见，true and false
        jFrame.setVisible(true);

        //设置窗体是否可以可以改变大小
        jFrame.setResizable(true);
    }

    private void readExecl(String filepath) throws IOException {
        Workbook workbook = null;
        InputStream inputStream = new FileInputStream(filepath);

//        HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
//        XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx

        if (filepath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (filepath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            System.out.println("格式不对");
        }
        //  取出第0个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //第一行是列名，+ 1的话就是不读 所以不读
        int firstRowIndex = sheet.getFirstRowNum();
        int lastRowIndex = sheet.getLastRowNum() - 3;

        int lastCellIndextemp = sheet.getRow(0).getLastCellNum();
        objArr = new Object[lastRowIndex][lastCellIndextemp];


        System.out.println("firstRowIndex: " + firstRowIndex);
        System.out.println("lastRowIndex: " + lastRowIndex);
        //遍历行
        for (int rIndex = firstRowIndex; rIndex < lastRowIndex; rIndex++) {
            System.out.println("rIndex = " + rIndex);
//            System.out.println("rIndex: " + rIndex);
            Row row = sheet.getRow(rIndex);

            int firstCellIndex = row.getFirstCellNum();
            int lastCellIndex = row.getLastCellNum();

            if (row != null) {
                //遍历列
                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {

                    Cell cell = row.getCell(cIndex);
                    if (cell != null) {
                        if (cIndex + 1 >= lastCellIndex) {
                            System.out.print(cell.toString());
                        } else {
                            System.out.print(cell.toString() + ",");
                        }
                        objArr[rIndex][cIndex] = cell.toString();
                    }
                }
                System.out.println();
                System.out.println("firstRowIndex = " + firstCellIndex);
                System.out.println("lastRowIndex = " + lastCellIndex);
                System.out.println("firstRowIndex = " + firstRowIndex);
                System.out.println("lastRowIndex = " + lastRowIndex);
            }
        }
        System.out.println("==============================");

        for (int i = 0; i < objArr.length; i++) {
            for (int j = 0; j < objArr[i].length; j++) {
                System.out.print(objArr[i][j] + ",");
            }
            System.out.println();
        }
    }

    public boolean fingNotInt(String strNext, String strNextNext, String strNextNextNext, String strEarnestMoney, String strAfterMouth) {
        String temStr = strNext + strNextNext + strNextNextNext + strEarnestMoney + strAfterMouth;

        boolean flag = true;
        for (int i = 0; i < temStr.length(); i++) {
            if (temStr.charAt(i) < '0' || temStr.charAt(i) > '9') {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void writeToExecl(Map<String, Double> strDoubleMap) {
        String startTime = "2017-11-28";
        String deadLine = "2018-03-27";

        //1、新建工作簿
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //2、创建工作表
        XSSFSheet oneSheet = xssfWorkbook.createSheet("工作表1");

        //创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        //水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //创建行，指定起始行号，从0开始
        XSSFRow titleRow = oneSheet.createRow(0);
        //创建第一行的列数
        XSSFCell titleCell = null;
        titleRow.setHeightInPoints(40);
        String[] titleArr = {"开票日期", "总共货款", "分月还款日期", "分月还款金额", "在设置日期里的应还款金额"};
        for (int i = 0; i < titleArr.length; i++) {
            titleCell = titleRow.createCell(i);
            XSSFRichTextString hssfRichTextString = new XSSFRichTextString(titleArr[i]);
            titleCell.setCellValue(hssfRichTextString);

            titleCell.setCellStyle(xssfCellStyle);
            titleRow.setRowStyle(xssfCellStyle);
        }

        for (int i = 0; i < titleArr.length; i++) {
            int columnWidth = titleRow.getCell(i).getStringCellValue().length();
            oneSheet.setColumnWidth(i, 512 * (columnWidth + 1));
        }

        //  beginSign是每次输出时，开始的位置，表示的是行数
        int beginSign = 1;
        int i = 0;

        for (Map.Entry<String, Double> strDoubleEntry : strDoubleMap.entrySet()) {
            Long time1 = null;
            Long time2 = null;
            Long time3 = null;
            Long time4 = null;

//            获得传入的map中的key和value
            String keyMap = strDoubleEntry.getKey();
            double valueMap = strDoubleEntry.getValue();

            double payment1 = valueMap * 0.95;
            double payment2 = valueMap * 0;
            double payment3 = valueMap * 0;
            double earnestMoney = valueMap * 0.05;

//            解析key值，获得年和月份
            String[] split = keyMap.split("-");
            int year = Integer.parseInt(split[0]);
            int moth = Integer.parseInt(split[1]);
//            第一个月和保证金配合使用
            int firstMoth = moth;
            //  保证每一次都是创建4行
            //  underSign 是结束的位置，也就是行数
//            tempBeginSign用来保证第五列能够准备的打印
            int tempBeginSign = beginSign;
            int underSign = (i + 1) * 4;
            XSSFRow othreRow = null;

            for (int j = beginSign; j <= underSign; j++) {
//                创建行，
                othreRow = oneSheet.createRow(j);
//                创建列，创建的同时，设置水平居中，垂直居中
                for (int k = 0; k < 5; k++) {
                    XSSFCell otherCell = othreRow.createCell(k);
                    otherCell.setCellStyle(xssfCellStyle);
                    othreRow.setRowStyle(xssfCellStyle);
                }

//                对第一列和第二列进行赋值
                othreRow.getCell(0).setCellValue(keyMap);
                othreRow.getCell(1).setCellValue(valueMap);
//                对第三列，次月进行赋值
                if (j % 4 == 1) {
                    moth = moth + 1;
                    if (moth > 12) {
                        year = year + 1;
                        moth = moth - 12;
                    }
                    String yearMoth = year + "-" + moth + "-" + 28;
                    time1 = getDate(yearMoth);
                    othreRow.getCell(2).setCellValue(yearMoth);

                    othreRow.getCell(3).setCellValue(payment1);
//                    othreRow.getCell(4).setCellValue(valueMap);
                }
//                对第三列，次次月进行赋值
                if (j % 4 == 2) {
                    moth = moth + 1;
                    if (moth > 12) {
                        year = year + 1;
                        moth = moth - 12;
                    }
                    String yearMoth = year + "-" + moth + "-" + 28;
                    time2 = getDate(yearMoth);
                    othreRow.getCell(2).setCellValue(yearMoth);

                    othreRow.getCell(3).setCellValue(payment2);
//                    othreRow.getCell(4).setCellValue(valueMap);
                }
//                对次次次月进行赋值
                if (j % 4 == 3) {
                    moth = moth + 1;
                    if (moth > 12) {
                        year = year + 1;
                        moth = moth - 12;
                    }
                    String yearMoth = year + "-" + moth + "-" + 28;
                    time3 = getDate(yearMoth);
                    othreRow.getCell(2).setCellValue(yearMoth);

                    othreRow.getCell(3).setCellValue(payment3);
//                    othreRow.getCell(4).setCellValue(valueMap);
                }
//                对保证金这个月进行赋值，需要获得面板上的保证金几个月后还。
                if (j % 4 == 0) {
                    moth = moth + 1;
                    if (moth > 12) {
                        year = year + 1;
                        moth = moth - 12;
                    }
                    String yearMoth = year + "-" + moth + "-" + 28;
                    time4 = getDate(yearMoth);
                    othreRow.getCell(2).setCellValue(yearMoth);

                    othreRow.getCell(3).setCellValue(earnestMoney);
//                    othreRow.getCell(4).setCellValue(valueMap);
                }
//                保证开始的位置，永远在已经创建的下方一行
                beginSign = j + 1;
            }
//            指定合并开始行、合并结束行 合并开始列、合并结束列
            CellRangeAddress rangeAddress1 = new CellRangeAddress(tempBeginSign, underSign, 0, 0);
            CellRangeAddress rangeAddress2 = new CellRangeAddress(tempBeginSign, underSign, 1, 1);
            CellRangeAddress rangeAddress3 = new CellRangeAddress(tempBeginSign, underSign, 4, 4);
//                添加要合并地址到表格
            oneSheet.addMergedRegion(rangeAddress1);
            oneSheet.addMergedRegion(rangeAddress2);
            oneSheet.addMergedRegion(rangeAddress3);
//            i 是用来确认当前是从map里面取出来的第几个数的。
            i++;

            long startTimeLong = getDate(startTime);
            long deadLineLong = getDate(deadLine);
            double finallyPayment = 0;
            if (time1 >= startTimeLong && time1 <= deadLineLong) {
                finallyPayment = finallyPayment + payment1;
            }
            if (time2 >= startTimeLong && time2 <= deadLineLong) {
                finallyPayment = finallyPayment + payment2;
            }
            if (time3 >= startTimeLong && time3 <= deadLineLong) {
                finallyPayment = finallyPayment + payment3;
            }
            if (time4 >= startTimeLong && time4 <= deadLineLong) {
                finallyPayment = finallyPayment + earnestMoney;
            }
            //设置第五列的数据
            oneSheet.getRow(tempBeginSign).getCell(4).setCellValue(finallyPayment);
        }


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("d:\\hello-3.xlsx");
            xssfWorkbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Long getDate(String StringTime) {
        try {
            System.out.println("输入的时间" + StringTime);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = dateFormat.parse(StringTime);

            System.out.println(parse);
            long time = parse.getTime();
            System.out.println(time);
            System.out.println("===========================================================");
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
