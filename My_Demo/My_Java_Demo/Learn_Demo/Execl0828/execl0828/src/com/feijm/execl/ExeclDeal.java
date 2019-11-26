package com.feijm.execl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class ExeclDeal {
    private static Object[][] objArr = null;
    private static List<ExeclModel> execlModelList = new ArrayList<>();

    private JFrame jFrame;

    private JPanel jPanel;

    //    选择文件
    private JButton selectExeclButton;
    //    显示路径
    private JTextField textFieldFilePath;
    //    确定读取
    private JButton decideButton;
    //    表格显示
    private JTextField textFieldWarningOne;
    //    弹出表格
    private JButton popupButton;

    //    次月
    private JLabel jLabelOne;
    private JTextField oneTextField;

    //    注意信息
    private JLabel examplejlabletwo;

    //    次次月
    private JLabel jLabelTwo;
    private JTextField twoTextField;
    //    次次次月
    private JLabel jLabelThree;
    private JTextField threeTextField;
    //    保证金
    private JLabel jLabelFour;
    private JTextField fourTextField;
    //    保证金提示
    private JLabel jLabelSix;
    //    保证金几个月机油
    private JTextField fiveTextField;
    private JLabel jLabelFive;

    //    注意信息
    private JLabel examplejlable;

    //    第一个日期
    private JLabel writejlabelone;
    private JTextField writejtextone;
    private JXDatePicker jxDatePickerOne;
    //    第二个日期
    private JLabel writejlabeltwo;
    private JTextField writejtexttwo;
    private JXDatePicker jxDatePickerTwo;
    //    输出到文件按钮
    private JButton writeExecl;

    public JTextField addTips1;
    public JTextField addTips2;

    private static String filepath;

    public ExeclDeal() {
        jFrame = new JFrame("文件处理界面");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //  设置最外层界面的大小
        jFrame.setBounds(10, 10, 1300, 700);
        //  设置一个JPanel对象    创建内容面板
        jPanel = new JPanel();
        jFrame.add(jPanel);
        //  绝对布局
        jPanel.setLayout(null);

        selectExeclButton = new JButton("点击获取，本地execl文件路径");
        selectExeclButton.setBounds(10, 10, 300, 30);
        jPanel.add(selectExeclButton);
        selectExeclButton.setBackground(Color.GREEN);

        textFieldFilePath = new JTextField("显示路径");
        textFieldFilePath.setBounds(10, 50, 300, 30);
        textFieldFilePath.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(textFieldFilePath);

        decideButton = new JButton("确定读取");
        decideButton.setBounds(320, 10, 100, 70);
        jPanel.add(decideButton);
        decideButton.setBackground(Color.GREEN);

        textFieldWarningOne = new JTextField("注意：必须先点击 确定读取");
        textFieldWarningOne.setBounds(10, 170, 300, 30);
        textFieldWarningOne.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(textFieldWarningOne);

        popupButton = new JButton("点击查看读取的文件");
        popupButton.setBounds(10, 200, 300, 30);
        popupButton.setBackground(Color.GREEN);
        jPanel.add(popupButton);

        jLabelOne = new JLabel("次月还款", JLabel.CENTER);
        jLabelOne.setBounds(500, 10, 100, 30);
        //必须设置底部为透明的
        jLabelOne.setOpaque(true);
        jLabelOne.setBackground(Color.GREEN);
        jPanel.add(jLabelOne);
        oneTextField = new JTextField("0");
        oneTextField.setBounds(620, 10, 150, 30);
        oneTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(oneTextField);

        examplejlabletwo = new JLabel("<html>四个地方都是输入数字的，同时保证四个相加，和为100</html>");
        examplejlabletwo.setBounds(780, 10, 100, 110);
        examplejlabletwo.setOpaque(true);
        examplejlabletwo.setBackground(Color.GREEN);
        jPanel.add(examplejlabletwo);

        jLabelTwo = new JLabel("次次月还款", JLabel.CENTER);
        jLabelTwo.setBounds(500, 50, 100, 30);
        //必须设置底部为透明的
        jLabelTwo.setOpaque(true);
        jLabelTwo.setBackground(Color.GREEN);
        jPanel.add(jLabelTwo);
        twoTextField = new JTextField("0");
        twoTextField.setBounds(620, 50, 150, 30);
        twoTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(twoTextField);

        jLabelThree = new JLabel("次次次月还款", JLabel.CENTER);
        jLabelThree.setBounds(500, 90, 100, 30);
        //必须设置底部为透明的
        jLabelThree.setOpaque(true);
        jLabelThree.setBackground(Color.GREEN);
        jPanel.add(jLabelThree);
        threeTextField = new JTextField("0");
        threeTextField.setBounds(620, 90, 150, 30);
        threeTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(threeTextField);

        jLabelFour = new JLabel("保证金", JLabel.CENTER);
        jLabelFour.setBounds(500, 130, 100, 30);
        //必须设置底部为透明的
        jLabelFour.setOpaque(true);
        jLabelFour.setBackground(Color.GREEN);
        jPanel.add(jLabelFour);
        fourTextField = new JTextField("0");
        fourTextField.setBounds(620, 130, 50, 30);
        fourTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(fourTextField);
        jLabelSix = new JLabel("<html>左边是百分比 右边是月份</html>", JLabel.CENTER);
        jLabelSix.setBounds(680, 130, 90, 50);
        //必须设置底部为透明的
        jLabelSix.setOpaque(true);
        jLabelSix.setBackground(Color.GREEN);
        jPanel.add(jLabelSix);
        fiveTextField = new JTextField("0");
        fiveTextField.setBounds(800, 130, 50, 30);
        fiveTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(fiveTextField);
        jLabelFive = new JLabel("个月后还", JLabel.CENTER);
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
        examplejlable = new JLabel("下方为日期选择", JLabel.CENTER);
        examplejlable.setBounds(925, 170, 100, 30);
        examplejlable.setOpaque(true);
        examplejlable.setBackground(Color.GREEN);
        jPanel.add(examplejlable);

        writejlabelone = new JLabel("第一个日期", JLabel.CENTER);
        writejlabelone.setBounds(500, 200, 100, 30);
        //必须设置底部为透明的
        writejlabelone.setOpaque(true);
        writejlabelone.setBackground(Color.GREEN);
        jPanel.add(writejlabelone);
        writejtextone = new JTextField();
        writejtextone.setBounds(620, 200, 300, 30);
        writejtextone.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(writejtextone);

        //  日期控件
        Date date = new Date();
        jxDatePickerOne = new JXDatePicker();
        jxDatePickerOne.setDate(date);
        jxDatePickerOne.setBounds(925, 200, 100, 30);
        jPanel.add(jxDatePickerOne);


        writejlabeltwo = new JLabel("第二个日期", JLabel.CENTER);
        writejlabeltwo.setBounds(500, 240, 100, 30);
        //必须设置底部为透明的
        writejlabeltwo.setOpaque(true);
        writejlabeltwo.setBackground(Color.GREEN);
        jPanel.add(writejlabeltwo);
        writejtexttwo = new JTextField();
        writejtexttwo.setBounds(620, 240, 300, 30);
        writejtexttwo.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(writejtexttwo);

        //  日期控件
        jxDatePickerTwo = new JXDatePicker();
        jxDatePickerTwo.setDate(date);
        jxDatePickerTwo.setBounds(925, 240, 100, 30);
        jPanel.add(jxDatePickerTwo);

        writeExecl = new JButton("输出为Execl文件");
        writeExecl.setBounds(500, 280, 420, 30);
        writeExecl.setBackground(Color.GREEN);
        jPanel.add(writeExecl);

        addTips1 = new JTextField("此软件源码在CSDN： https://blog.csdn.net/whitecake/article/details/100144923");
        addTips1.setBounds(10, 350, 700, 30);
        jPanel.add(addTips1);

        //设置窗口是否可见，true and false
        jFrame.setVisible(true);

        //设置窗体是否可以可以改变大小
        jFrame.setResizable(true);
    }

    public static void main(String[] args) {
        ExeclDeal execlDeal = new ExeclDeal();

        execlDeal.jxDatePickerOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date tempdate = execlDeal.jxDatePickerOne.getDate();
//                System.out.println(tempdate);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOne = simpleDateFormat.format(tempdate);
                execlDeal.writejtextone.setText(dateOne);
            }
        });

        execlDeal.jxDatePickerTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date tempdate = execlDeal.jxDatePickerTwo.getDate();
//                System.out.println(tempdate);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOne = simpleDateFormat.format(tempdate);
                execlDeal.writejtexttwo.setText(dateOne);
            }
        });

        execlDeal.selectExeclButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();             //设置选择器
                chooser.setMultiSelectionEnabled(true);             //设为多选
                int returnVal = chooser.showOpenDialog(execlDeal.selectExeclButton);        //是否打开文件选择框
                System.out.println("returnVal=" + returnVal);
                if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
                    System.out.println(filepath);
                    execlDeal.textFieldFilePath.setText(filepath);
                }
            }
        });

        execlDeal.decideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filepath = execlDeal.textFieldFilePath.getText();

                if ("".equals(filepath) || filepath == null) {
                    JOptionPane.showMessageDialog(execlDeal.jFrame.getContentPane(), "请先选择文件~",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!(filepath.endsWith("xlsx") || filepath.endsWith("xls"))) {
                    JOptionPane.showMessageDialog(execlDeal.jFrame.getContentPane(), "请选择Excel文件~",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                /* 打开文件 */
                try {
                    execlDeal.readExecl(filepath);
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
//                for (ExeclModel execlModel : execlModelList) {
//                    System.out.println(execlModel);
//                }


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
                execlDeal.popupButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //  新建一个popupJframe
                        JFrame popupJframe = new JFrame("显示表格页面");

                        //新建一个表格，把第一行列名， 和表格数据传入
                        JTable jTablePopup = new JTable(tempObjArr, objectArrTitle);
                        //  设置大小。
                        jTablePopup.setPreferredScrollableViewportSize(new Dimension(1300, 700));
                        //  垂直滚都条 和 水平滚动条
                        JScrollPane jScrollPane = new JScrollPane(jTablePopup, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                        //  字体居中显示，并且添加进入popupJframe
                        popupJframe.getContentPane().add(jScrollPane, BorderLayout.CENTER);
                        //  设置表格的自动调整模式
                        jTablePopup.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                        popupJframe.pack();
                        popupJframe.setBounds(20, 20, 1500, 700);
                        popupJframe.setLayout(null);
                        popupJframe.setVisible(true);
                    }
                });
            }
        });


        execlDeal.writeExecl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strNext = execlDeal.oneTextField.getText();
                String strNextNext = execlDeal.twoTextField.getText();
                String strNextNextNext = execlDeal.threeTextField.getText();
                String strEarnestMoney = execlDeal.fourTextField.getText();
                String strAfterMouth = execlDeal.fiveTextField.getText();

                boolean flag = execlDeal.fingNotInt(strNext, strNextNext, strNextNextNext, strEarnestMoney, strAfterMouth);
                if (!flag) {
                    JOptionPane.showMessageDialog(execlDeal.jFrame.getContentPane(), "请检查次月，次次月，次次次月，保证金的输入框，存在非法数字",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean emptyFlag = execlDeal.fingIsEmpty(strNext, strNextNext, strNextNextNext, strEarnestMoney, strAfterMouth);
                if (!emptyFlag) {
                    JOptionPane.showMessageDialog(execlDeal.jFrame.getContentPane(), "请检查次月，次次月，次次次月，保证金的输入框，存在空值",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int next = Integer.parseInt(strNext);
                int nextNext = Integer.parseInt(strNextNext);
                int nextNextNext = Integer.parseInt(strNextNextNext);
                int earnestMoney = Integer.parseInt(strEarnestMoney);
                int afterMouth = Integer.parseInt(strAfterMouth);

                if ((next + nextNext + nextNextNext + earnestMoney) != 100) {
                    JOptionPane.showMessageDialog(execlDeal.jFrame.getContentPane(), "次月，次次月，次次次月，保证金，相加百分比不为 100",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String writeTextOne = execlDeal.writejtextone.getText();
                String writeTextTwo = execlDeal.writejtexttwo.getText();

//                System.out.println(writeTextOne);
//                System.out.println(writeTextTwo);

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

                execlDeal.writeToExecl(strDoubleMap);
            }
        });


        //  关闭的时候关机java虚拟机
        execlDeal.jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
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


//        System.out.println("firstRowIndex: " + firstRowIndex);
//        System.out.println("lastRowIndex: " + lastRowIndex);
        //遍历行
        for (int rIndex = firstRowIndex; rIndex < lastRowIndex; rIndex++) {
//            System.out.println("rIndex = " + rIndex);
//            System.out.println("rIndex: " + rIndex);
            Row row = sheet.getRow(rIndex);

            int firstCellIndex = row.getFirstCellNum();
            int lastCellIndex = row.getLastCellNum();

            if (row != null) {
                //遍历列
                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {

                    Cell cell = row.getCell(cIndex);
                    if (cell != null) {
//                        if (cIndex + 1 >= lastCellIndex) {
//                            System.out.print(cell.toString());
//                        } else {
//                            System.out.print(cell.toString() + ",");
//                        }
                        objArr[rIndex][cIndex] = cell.toString();
                    }
                }
//                System.out.println();
//                System.out.println("firstRowIndex = " + firstCellIndex);
//                System.out.println("lastRowIndex = " + lastCellIndex);
//                System.out.println("firstRowIndex = " + firstRowIndex);
//                System.out.println("lastRowIndex = " + lastRowIndex);
            }
        }
        System.out.println("==============================");

//        for (int i = 0; i < objArr.length; i++) {
//            for (int j = 0; j < objArr[i].length; j++) {
//                System.out.print(objArr[i][j] + ",");
//            }
//            System.out.println();
//        }
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

    public boolean fingIsEmpty(String strNext, String strNextNext, String strNextNextNext, String strEarnestMoney, String strAfterMouth) {
        boolean flag = true;
        if ("".trim().equals(strNext) || strNext.length() == 0) {
            return false;
        }
        if ("".trim().equals(strNextNext) || strNextNext.length() == 0) {
            return false;
        }
        if ("".trim().equals(strNextNextNext) || strNextNextNext.length() == 0) {
            return false;
        }
        if ("".trim().equals(strEarnestMoney) || strEarnestMoney.length() == 0) {
            return false;
        }
        if ("".trim().equals(strAfterMouth) || strAfterMouth.length() == 0) {
            return false;
        }
        return flag;
    }

    public void writeToExecl(Map<String, Double> strDoubleMap) {
        String startTime = writejtextone.getText();
        String deadLine = writejtexttwo.getText();

//        下面几个是百分比
        String nextRepayment = oneTextField.getText();
        double nextRepaymentDouble = Double.parseDouble(nextRepayment) * 0.01;

        String nextNextRepayment = twoTextField.getText();
        double nextNextRepaymentDouble = Double.parseDouble(nextNextRepayment) * 0.01;

        String nextNextNextRepayment = threeTextField.getText();
        double nextNextNextRepaymentDouble = Double.parseDouble(nextNextNextRepayment) * 0.01;

        String returnDeposit = fourTextField.getText();
        double returnDepositDouble = Double.parseDouble(returnDeposit) * 0.01;

//        保证金几个月以后还
        String earnestMoneyAfterMoth = fourTextField.getText();
        int earnestMoneyAfterMothNum = Integer.parseInt(earnestMoneyAfterMoth);

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
//        i 确定的是第几次打印，打印的第几个元素，从map里面取出的第几个
        int i = 0;

        for (Map.Entry<String, Double> strDoubleEntry : strDoubleMap.entrySet()) {
            Long time1 = null;
            Long time2 = null;
            Long time3 = null;
            Long time4 = null;

//            获得传入的map中的key和value
            String keyMap = strDoubleEntry.getKey();
            double valueMap = strDoubleEntry.getValue();

//            每个月还多少的金额，以及保证金
            double payment1 = valueMap * nextRepaymentDouble;
            double payment2 = valueMap * nextNextRepaymentDouble;
            double payment3 = valueMap * nextNextNextRepaymentDouble;
            double earnestMoney = valueMap * returnDepositDouble;

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
                    moth = firstMoth + 1 + earnestMoneyAfterMothNum;
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
            String[] split = filepath.split("\\\\");
            String[] split1 = split[split.length - 1].split("\\.");
            String pathp = split1[0];
//            System.out.println(filepath);
//            System.out.println("00000000000000000000000000000000000000000");
            System.out.println(pathp);
            fileOutputStream = new FileOutputStream("D:\\" + pathp + ".xlsx");
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

    private static Long getDate(String stringTime) {
        try {
//            System.out.println("输入的时间" + stringTime);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = dateFormat.parse(stringTime);

//            System.out.println(parse);
            long time = parse.getTime();
//            System.out.println(time);
            System.out.println("======6====l=====s========5======5===l======m======f====5====4====y=b==");
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
