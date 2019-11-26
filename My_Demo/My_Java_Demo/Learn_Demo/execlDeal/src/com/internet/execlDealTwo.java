//package com.internet;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//@SuppressWarnings("all")
//public class execlDealTwo {
//    public JButton selectExeclButton;
//    public JButton decideButton;
//    public JTextField textFieldFilePath;
//    public JTextField textField2;
//    public JTextField textField3;
//    public JTextField textField4;
//    public JButton button3;
//    public JTextField textField5;
//    public JTextField textField6;
//    public JTable table1;
//    public JPanel execlDeal2;
//
//    private static Object[][] objArr = null;
//
//    public execlDealTwo(JFrame frame) {
//        selectExeclButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser chooser = new JFileChooser();             //设置选择器
//                chooser.setMultiSelectionEnabled(true);             //设为多选
//                int returnVal = chooser.showOpenDialog(selectExeclButton);        //是否打开文件选择框
//                System.out.println("returnVal=" + returnVal);
//
//                if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
//
//                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
//                    System.out.println(filepath);
//
//                    textFieldFilePath.setText(filepath);
//                }
//            }
//        });
//        decideButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String filepath = textFieldFilePath.getText();
//
//                if ("".equals(filepath) || filepath == null) {
//                    JOptionPane.showMessageDialog(frame.getContentPane(), "请先选择文件~",
//                            "警告", JOptionPane.WARNING_MESSAGE);
//                    return;
//                }
//                //  filepath.endwith
//                String suffix = filepath.substring(filepath.lastIndexOf(".") + 1);
//                System.out.println(suffix);
//                if (!(suffix.equals("xlsx") || (suffix.equals("xls")))) {
//                    JOptionPane.showMessageDialog(frame.getContentPane(), "请选择Excel文件~",
//                            "警告", JOptionPane.WARNING_MESSAGE);
//                    return;
//                }
//
//                /* 打开文件 */
//                try {
//                    readExecl(filepath);
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//
//                //  Java Swing表格显示
//                Object[][] tempObjArr = new Object[objArr.length][12];
//
//                System.out.println("==============================");
//                System.out.println("==============================");
//                System.out.println("==============================");
//                System.out.println("==============================");
//                for (int i = 0; i < objArr.length; i++) {
//                    for (int j = 0; j < 12; j++) {
//                        tempObjArr[i][j] = objArr[i][j];
////                        System.out.print(objArr[i][j] + ",");
//                    }
////                    System.out.println();
//                }
//
//                for (int i = 1; i < tempObjArr.length; i++) {
//                    for (int j = 0; j < tempObjArr[i].length; j++) {
////                        tempObjArr[i][j] = tempObjArr[i][j];
//                        System.out.print(tempObjArr[i][j] + ",");
//                    }
//                    System.out.println();
//                }
//
//                //  横标题
//                Object[] objectArrTitle = new Object[tempObjArr[0].length];
//                for (int i = 0; i < tempObjArr[0].length; i++) {
//                    objectArrTitle[i] = tempObjArr[0][i];
//                }
//                System.out.println("==============================");
//                System.out.println("==============================");
//                System.out.println("==============================");
//                System.out.println("==============================");
//
//                JPanel jPanelTable = new JPanel();
////                jPanelTable.setLayout(null);
//                frame.add(jPanelTable);
//                // 以Names和playerInfo为参数，创建一个表格
//                JTable jTable = new JTable(tempObjArr, objectArrTitle);
//                // 设置此表视图的首选大小
//                jTable.setSize(10, 100);
//                jTable.setLocation(10, 200);
////                jTable.setPreferredScrollableViewportSize();
//                // 创建包含表格的滚动窗格
//                JScrollPane jScrollPane = new JScrollPane(jTable);
//                jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
////                定义 jPanelTable 的布局为 BoxLayout，BoxLayout 为垂直排列
//                jPanelTable.setLayout(new BoxLayout(jPanelTable, BoxLayout.Y_AXIS));
////                先加入一个不可见的 Strut，从而使 topPanel 对顶部留出一定的空间
//                jPanelTable.add(Box.createVerticalStrut(10));
////                加入包含表格的滚动窗格
//                jPanelTable.add(jScrollPane);
//                jPanelTable.add(Box.createVerticalStrut(10));
//
//                frame.addWindowListener(new WindowAdapter() {
//                    @Override
//                    public void windowClosing(WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//            }
//        });
//
//    }
//
//    public static void main(String[] args) {
//
//        JFrame frame = new JFrame("execlDealTwo");
//
//        execlDealTwo execlDealTwo = new execlDealTwo(frame);
//        frame.setContentPane(execlDealTwo.execlDeal2);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void readExecl(String filepath) throws IOException {
//        Workbook workbook = null;
//        InputStream inputStream = new FileInputStream(filepath);
//
////        HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
////        XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
//
//        if (filepath.endsWith("xlsx")) {
//            workbook = new XSSFWorkbook(inputStream);
//        } else if (filepath.endsWith("xls")) {
//            workbook = new HSSFWorkbook(inputStream);
//        } else {
//            System.out.println("格式不对");
//        }
//        //  取出第0个工作表
//        Sheet sheet = workbook.getSheetAt(0);
//        //第一行是列名，+ 1的话就是不读 所以不读
//        int firstRowIndex = sheet.getFirstRowNum();
//        int lastRowIndex = sheet.getLastRowNum();
//
//        int lastCellIndextemp = sheet.getRow(0).getLastCellNum();
//        objArr = new Object[lastRowIndex + 1][lastCellIndextemp];
//
//
//        System.out.println("firstRowIndex: " + firstRowIndex);
//        System.out.println("lastRowIndex: " + lastRowIndex);
//        //遍历行
//        for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
////            System.out.println("rIndex: " + rIndex);
//            Row row = sheet.getRow(rIndex);
//
//            int firstCellIndex = row.getFirstCellNum();
//            int lastCellIndex = row.getLastCellNum();
//
//            if (row != null) {
//                //遍历列
//                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
//                    Cell cell = row.getCell(cIndex);
//                    if (cell != null) {
//                        if (cIndex + 1 >= lastCellIndex) {
//                            System.out.print(cell.toString());
//                        } else {
//                            System.out.print(cell.toString() + ",");
//                        }
//                        objArr[rIndex][cIndex] = cell.toString();
//                    }
//                }
//                System.out.println();
//            }
//        }
//        System.out.println("==============================");
//        System.out.println("==============================");
//        System.out.println("==============================");
//        System.out.println("==============================");
//        for (int i = 0; i < objArr.length; i++) {
//            for (int j = 0; j < objArr[i].length; j++) {
//                System.out.print(objArr[i][j] + ",");
//            }
//            System.out.println();
//        }
//    }
//
//    {
//// GUI initializer generated by IntelliJ IDEA GUI Designer
//// >>> IMPORTANT!! <<<
//// DO NOT EDIT OR ADD ANY CODE HERE!
//        $$$setupUI$$$();
//    }
//
//    /**
//     * Method generated by IntelliJ IDEA GUI Designer
//     * >>> IMPORTANT!! <<<
//     * DO NOT edit this method OR call it in your code!
//     *
//     * @noinspection ALL
//     */
//    private void $$$setupUI$$$() {
//        execlDeal2 = new JPanel();
//        execlDeal2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
//        execlDeal2.setAlignmentX(1.0f);
//        execlDeal2.setAlignmentY(1.0f);
//        execlDeal2.setAutoscrolls(false);
//        execlDeal2.setBorder(BorderFactory.createTitledBorder("Execl文件处理"));
//
//        final JPanel jPanelJframe = new JPanel();
//        jPanelJframe.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
//        execlDeal2.add(jPanelJframe, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//
//
//        final JPanel jPanelRead = new JPanel();
//        jPanelRead.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
//        jPanelRead.setBackground(new Color(-12631745));
//        jPanelJframe.add(jPanelRead, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//        selectExeclButton = new JButton();
//        selectExeclButton.setText("点击选择本地execl");
//        jPanelRead.add(selectExeclButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        decideButton = new JButton();
//        decideButton.setText("点击读取execl");
//        jPanelRead.add(decideButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        textFieldFilePath = new JTextField();
//        jPanelRead.add(textFieldFilePath, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
//
//
//
//        final JPanel jPanelSelect = new JPanel();
//        jPanelSelect.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
//        jPanelJframe.add(jPanelSelect, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//        final JLabel label1 = new JLabel();
//        label1.setText("Label");
//        jPanelSelect.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        final JLabel label2 = new JLabel();
//        label2.setText("Label");
//        jPanelSelect.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        final JLabel label3 = new JLabel();
//        label3.setText("Label");
//        jPanelSelect.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        textField2 = new JTextField();
//        jPanelSelect.add(textField2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
//        textField3 = new JTextField();
//        jPanelSelect.add(textField3, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
//        textField4 = new JTextField();
//        jPanelSelect.add(textField4, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
//
//
//
//        final JPanel panel4 = new JPanel();
//        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1));
//        panel4.setBackground(new Color(-11300421));
//        execlDeal2.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//        button3 = new JButton();
//        button3.setText("Button");
//        panel4.add(button3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        final JLabel label4 = new JLabel();
//        label4.setText("Label");
//        panel4.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        final JLabel label5 = new JLabel();
//        label5.setText("Label");
//        panel4.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        textField5 = new JTextField();
//        panel4.add(textField5, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
//        textField6 = new JTextField();
//        panel4.add(textField6, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
//
//        final JPanel panel5 = new JPanel();
//        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
//        execlDeal2.add(panel5, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//        final JScrollPane scrollPane1 = new JScrollPane();
//        panel5.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
//        table1 = new JTable();
//        scrollPane1.setViewportView(table1);
//    }
//
//    /**
//     * @noinspection ALL
//     */
//    public JComponent $$$getRootComponent$$$() {
//        return execlDeal2;
//    }
//}
//
//
