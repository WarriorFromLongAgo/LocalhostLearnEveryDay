package com.feijm.execltest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;

public class ExeclTest {
    public static void main(String[] args) throws Exception {
        //创建一份
        XSSFWorkbook excel = new XSSFWorkbook();
        //创建第一个sheet
        XSSFSheet sheet = excel.createSheet("我的POI之旅");
        //创建第一行
        XSSFRow row = sheet.createRow( 0);
        //创建第一个单元格
        XSSFCell cell = row.createCell(0);
        //设置单元格的值
        cell.setCellValue("Ay");
        //生成单元格样式
        XSSFCellStyle xssfCellStyle = excel.createCellStyle();
        //设置背景颜色
        xssfCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        //solid 填充  foreground  前景色
        xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        row.setRowStyle(xssfCellStyle);

        //创建第一行
        XSSFRow row2 = sheet.createRow( 1);
        //创建第一个单元格
        //设置单元格的值
        //生成单元格样式
        //设置背景颜色
        XSSFCellStyle xssfCellStyle2 = excel.createCellStyle();
        xssfCellStyle2.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        //solid 填充  foreground  前景色
        xssfCellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        row2.setRowStyle(xssfCellStyle2);
        XSSFCell cell2 = row2.createCell(0);
        cell2.setCellValue("by");


        //通过流写到硬盘
        FileOutputStream out = new FileOutputStream("D:/old_color.xls");
        excel.write(out);
        out.close();
    }
}
