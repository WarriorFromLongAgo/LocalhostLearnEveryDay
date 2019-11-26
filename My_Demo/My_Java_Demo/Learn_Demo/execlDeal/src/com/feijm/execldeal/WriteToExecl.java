package com.feijm.execldeal;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteToExecl {
    public static void main(String[] args) throws IOException {
        Map<String, Double> stringDoubleMap = new HashMap<>();
        stringDoubleMap.put("1111月", 110.0);
        stringDoubleMap.put("2222月", 220.0);
        stringDoubleMap.put("3333月", 333.0);
        stringDoubleMap.put("4444月", 444.0);
        stringDoubleMap.put("5555月", 555.0);

        //1、新建工作簿
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //2、创建工作表
        XSSFSheet oneSheet = xssfWorkbook.createSheet("工作表1");
//        自适应列宽度
        oneSheet.autoSizeColumn(1, true);
        //指定合并开始行、合并结束行 合并开始列、合并结束列
//        CellRangeAddress rangeAddress = new CellRangeAddress(0, 10, 0, 3);
        //添加要合并地址到表格
//        oneSheet.addMergedRegion(rangeAddress);


        //创建行，指定起始行号，从0开始
        XSSFRow titleRow = oneSheet.createRow(0);
        //创建单元格，指定起始列号，从0开始
        XSSFCell titleCell = titleRow.createCell(0);
//        目的是想把行高设置成20px
        titleRow.setHeightInPoints(40);
        titleRow.createCell(0).setCellValue("开票日期");
        titleRow.createCell(1).setCellValue("总共货款");
        titleRow.createCell(2).setCellValue("分月还款日期");
        titleRow.createCell(3).setCellValue("分月还款金额");
        titleRow.createCell(4).setCellValue("日期区间需还款金额");

        if (!stringDoubleMap.isEmpty()) {
            for (Map.Entry<String, Double> stringDoubleEntry : stringDoubleMap.entrySet()) {

            }
        }


        CellStyle cellStyle = xssfWorkbook.createCellStyle();
//        for (int i = 0; i <= 3; i++) {
//            titleRow.getCell(i).setCellStyle(cellStyle);//设置自动换行
//        }


        //设置单元格内容
//        titleCell.setCellValue("我是合并后的单元格");
        //创建样式对象

        //自动换行*重要*
        cellStyle.setWrapText(true);
        //设置样式对齐方式：水平\垂直居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设定填充单色
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设定背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        //为指定单元格设定样式
        titleCell.setCellStyle(cellStyle);
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\hello-3.xlsx");
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }


    private static void day01() throws IOException {
        //1、新建工作簿
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //2、创建工作表
        HSSFSheet oneSheet = hssfWorkbook.createSheet("工作表1");
        //3、创建行
        HSSFRow row = oneSheet.createRow(0);
        //4、创建单元格
        HSSFCell cell = row.createCell(0);
        //5、单元格写入内容
        cell.setCellValue("你好JAVA");
        //6、保存工作簿
        File file = new File("C:\\Users\\Public\\Documents\\处理后的.xls");
        hssfWorkbook.write(file);
        System.out.println("创建Excel成功");
    }

}
