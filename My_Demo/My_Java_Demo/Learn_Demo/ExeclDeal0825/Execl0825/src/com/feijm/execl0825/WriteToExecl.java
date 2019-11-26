//package com.feijm.execl0825;
//
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.VerticalAlignment;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.*;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class WriteToExecl {
//    public static void main(String[] args) {
//        Map<String, Double> strDoubleMap = new LinkedHashMap<>();
//        strDoubleMap.put("2017-09", 110.0);
//        strDoubleMap.put("2017-10", 220.0);
//        strDoubleMap.put("2018-01", 333.0);
//        strDoubleMap.put("2018-03", 444.0);
//        strDoubleMap.put("2018-04", 555.0);
//
//        String startTime = "2017-11-28";
//        String deadLine = "2018-03-27";
//
//        //1、新建工作簿
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
//        //2、创建工作表
//        XSSFSheet oneSheet = xssfWorkbook.createSheet("工作表1");
//
//        //创建单元格，并设置值表头 设置表头居中
//        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
//        //水平居中
//        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
//        //垂直居中
//        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//
//        //创建行，指定起始行号，从0开始
//        XSSFRow titleRow = oneSheet.createRow(0);
//        //创建第一行的列数
//        XSSFCell titleCell = null;
//        titleRow.setHeightInPoints(40);
//        String[] titleArr = {"开票日期", "总共货款", "分月还款日期", "分月还款金额", "在设置日期里的应还款金额"};
//        for (int i = 0; i < titleArr.length; i++) {
//            titleCell = titleRow.createCell(i);
//            XSSFRichTextString hssfRichTextString = new XSSFRichTextString(titleArr[i]);
//            titleCell.setCellValue(hssfRichTextString);
//
//            titleCell.setCellStyle(xssfCellStyle);
//            titleRow.setRowStyle(xssfCellStyle);
//        }
//
//        for (int i = 0; i < titleArr.length; i++) {
//            int columnWidth = titleRow.getCell(i).getStringCellValue().length();
//            oneSheet.setColumnWidth(i, 512 * (columnWidth + 1));
//        }
//
//        //  beginSign是每次输出时，开始的位置，表示的是行数
//        int beginSign = 1;
//        int i = 0;
//
//        for (Map.Entry<String, Double> strDoubleEntry : strDoubleMap.entrySet()) {
//            Long time1 = null;
//            Long time2 = null;
//            Long time3 = null;
//            Long time4 = null;
//
////            获得传入的map中的key和value
//            String keyMap = strDoubleEntry.getKey();
//            double valueMap = strDoubleEntry.getValue();
//
//            double payment1 = valueMap * 0.95;
//            double payment2 = valueMap * 0;
//            double payment3 = valueMap * 0;
//            double earnestMoney = valueMap * 0.05;
//
////            解析key值，获得年和月份
//            String[] split = keyMap.split("-");
//            int year = Integer.parseInt(split[0]);
//            int moth = Integer.parseInt(split[1]);
////            第一个月和保证金配合使用
//            int firstMoth = moth;
//            //  保证每一次都是创建4行
//            //  underSign 是结束的位置，也就是行数
////            tempBeginSign用来保证第五列能够准备的打印
//            int tempBeginSign = beginSign;
//            int underSign = (i + 1) * 4;
//            XSSFRow othreRow = null;
//
//            for (int j = beginSign; j <= underSign; j++) {
////                创建行，
//                othreRow = oneSheet.createRow(j);
////                创建列，创建的同时，设置水平居中，垂直居中
//                for (int k = 0; k < 5; k++) {
//                    XSSFCell otherCell = othreRow.createCell(k);
//                    otherCell.setCellStyle(xssfCellStyle);
//                    othreRow.setRowStyle(xssfCellStyle);
//                }
//
////                对第一列和第二列进行赋值
//                othreRow.getCell(0).setCellValue(keyMap);
//                othreRow.getCell(1).setCellValue(valueMap);
////                对第三列，次月进行赋值
//                if (j % 4 == 1) {
//                    moth = moth + 1;
//                    if (moth > 12) {
//                        year = year + 1;
//                        moth = moth - 12;
//                    }
//                    String yearMoth = year + "-" + moth + "-" + 28;
//                    time1 = getDate(yearMoth);
//                    othreRow.getCell(2).setCellValue(yearMoth);
//
//                    othreRow.getCell(3).setCellValue(payment1);
////                    othreRow.getCell(4).setCellValue(valueMap);
//                }
////                对第三列，次次月进行赋值
//                if (j % 4 == 2) {
//                    moth = moth + 1;
//                    if (moth > 12) {
//                        year = year + 1;
//                        moth = moth - 12;
//                    }
//                    String yearMoth = year + "-" + moth + "-" + 28;
//                    time2 = getDate(yearMoth);
//                    othreRow.getCell(2).setCellValue(yearMoth);
//
//                    othreRow.getCell(3).setCellValue(payment2);
////                    othreRow.getCell(4).setCellValue(valueMap);
//                }
////                对次次次月进行赋值
//                if (j % 4 == 3) {
//                    moth = moth + 1;
//                    if (moth > 12) {
//                        year = year + 1;
//                        moth = moth - 12;
//                    }
//                    String yearMoth = year + "-" + moth + "-" + 28;
//                    time3 = getDate(yearMoth);
//                    othreRow.getCell(2).setCellValue(yearMoth);
//
//                    othreRow.getCell(3).setCellValue(payment3);
////                    othreRow.getCell(4).setCellValue(valueMap);
//                }
////                对保证金这个月进行赋值，需要获得面板上的保证金几个月后还。
//                if (j % 4 == 0) {
//                    moth = moth + 1;
//                    if (moth > 12) {
//                        year = year + 1;
//                        moth = moth - 12;
//                    }
//                    String yearMoth = year + "-" + moth + "-" + 28;
//                    time4 = getDate(yearMoth);
//                    othreRow.getCell(2).setCellValue(yearMoth);
//
//                    othreRow.getCell(3).setCellValue(earnestMoney);
////                    othreRow.getCell(4).setCellValue(valueMap);
//                }
////                保证开始的位置，永远在已经创建的下方一行
//                beginSign = j + 1;
//            }
////            指定合并开始行、合并结束行 合并开始列、合并结束列
//            CellRangeAddress rangeAddress1 = new CellRangeAddress(tempBeginSign, underSign, 0, 0);
//            CellRangeAddress rangeAddress2 = new CellRangeAddress(tempBeginSign, underSign, 1, 1);
//            CellRangeAddress rangeAddress3 = new CellRangeAddress(tempBeginSign, underSign, 4, 4);
////                添加要合并地址到表格
//            oneSheet.addMergedRegion(rangeAddress1);
//            oneSheet.addMergedRegion(rangeAddress2);
//            oneSheet.addMergedRegion(rangeAddress3);
////            i 是用来确认当前是从map里面取出来的第几个数的。
//            i++;
//
//            long startTimeLong = getDate(startTime);
//            long deadLineLong = getDate(deadLine);
//            double finallyPayment = 0;
//            if (time1 >= startTimeLong && time1 <= deadLineLong) {
//                finallyPayment = finallyPayment + payment1;
//            }
//            if (time2 >= startTimeLong && time2 <= deadLineLong) {
//                finallyPayment = finallyPayment + payment2;
//            }
//            if (time3 >= startTimeLong && time3 <= deadLineLong) {
//                finallyPayment = finallyPayment + payment3;
//            }
//            if (time4 >= startTimeLong && time4 <= deadLineLong) {
//                finallyPayment = finallyPayment + earnestMoney;
//            }
//            //设置第五列的数据
//            oneSheet.getRow(tempBeginSign).getCell(4).setCellValue(finallyPayment);
//        }
//
//
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream("d:\\hello-3.xlsx");
//            xssfWorkbook.write(fileOutputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileOutputStream != null) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private static Long getDate(String StringTime) {
//        try {
//            System.out.println("输入的时间" + StringTime);
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date parse = dateFormat.parse(StringTime);
//
//            System.out.println(parse);
//            long time = parse.getTime();
//            System.out.println(time);
//            System.out.println("===========================================================");
//            return time;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
