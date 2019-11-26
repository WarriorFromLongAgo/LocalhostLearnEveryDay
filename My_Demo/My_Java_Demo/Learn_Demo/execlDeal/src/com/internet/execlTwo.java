//package com.internet;
//
//import java.awt.RenderingHints;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//
////org.apache.poi
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
////org.jfree
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.ValueAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.title.TextTitle;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//import java.awt.Font;
//
//public class EmployeeStatics {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        JOptionPane.showMessageDialog(null,"\n您好，我是智能机器人小紫\n\n"
//                        + "很高兴为您提供员工数据统计分析服务\n\n"
//                        + "请选择一个Excel文件 ^_^\n\n",
//                "选择Excel文件",JOptionPane.INFORMATION_MESSAGE);
//
//        ArrayList Employees = null;
//
//        //从Excel文件读取数据
//        try {
//            Employees = ReadFileUsingFileChooser();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        //人数统计
//        int n = Employees.size();
//
//        //最大最小工资、工龄、工资初始化
//        int maxA = 0;
//        int minA = Integer.MAX_VALUE;
//        int maxWA = 0;
//        int minWA = Integer.MAX_VALUE;
//        int maxS = 0;
//        int minS = Integer.MAX_VALUE;
//
//        //男女性别人数
//        int M = 0;
//        int FM = 0;
//
//        double sumS, sumA, sumWA, avgS, avgA, avgWA, MFM;
//
//        sumS = sumA = sumWA = 0;
//
//        //遍历实现相关统计
//        for (Employee e : Employees) {
//
//            if(e.age > maxA)
//                maxA = (int) e.age;
//            if(e.age < minA)
//                minA = (int) e.age;
//            if(e.workAge > maxWA)
//                maxWA = (int) e.workAge;
//            if(e.workAge < minWA)
//                minWA = (int) e.workAge;
//            if(e.sal > maxS)
//                maxS = (int) e.sal;
//            if(e.sal < minS)
//                minS = (int) e.sal;
//
//            sumS += e.sal;
//            sumA += e.age;
//            sumWA += e.workAge;
//
//            if (e.sex.equals("男"))
//                M++;
//            if (e.sex.equals("女"))
//                FM++;
//        }
//
//        //计算平均值
//        avgS = sumS / n;
//        avgA = sumA / n;
//        avgWA = sumWA / n;
//
//        //计算男女比例
//        MFM = (double) M / FM;
//
//        JOptionPane.showMessageDialog(null,"员工人数为" + n + "，男女比例为" + MFM + "（男/女）\n"
//                + "平均年龄为" + avgA + "，平均工龄为" + avgWA + "，平均工资为" + avgS + "\n"
//                + "最高年龄为" + maxA + "，最低年龄为" + minA + "，最高工龄为" + maxWA + "，最低工龄为" + minWA + "\n"
//                + "最高工资为" + maxS + "K，最低工资为" + minS + "K\n");
//
//        int option=JOptionPane.YES_OPTION;
//        option=JOptionPane.showConfirmDialog(null, "是否显示员工数据统计图？");
//
//        if (option==JOptionPane.YES_OPTION) {
//            CategoryDataset dataset = getDataSet(Employees);
//
//            //构造chart
//            JFreeChart chart = ChartFactory.createBarChart3D(
//                    "员工数据统计图", // 图表标题
//                    "员工属性", // 目录轴的显示标签--横轴
//                    "数值", // 数值轴的显示标签--纵轴
//                    dataset, // 数据集
//                    PlotOrientation.VERTICAL, // 图表方向：水平、
//                    true, // 是否显示图例(对于简单的柱状图必须
//                    false, // 是否生成工具
//                    false // 是否生成URL链接
//            );
//
//            //处理chart中文显示问题
//            processChart(chart);
//
//            //chart 以swing形式输出
//            ChartFrame pieFrame = new ChartFrame("员工数据统计图", chart);
//            pieFrame.pack();
//            pieFrame.setVisible(true);
//        }
//    }
//
//    public static ArrayList ReadFileUsingFileChooser() throws Exception {
//        // TODO Auto-generated method stub
//
//        JFileChooser fileChooser = new JFileChooser();
//        ArrayList temp = new ArrayList();
//
//        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            java.io.File file = fileChooser.getSelectedFile();
//
//            FileInputStream fileIn = new FileInputStream(file);
//            //根据指定的文件输入流导入Excel从而产生Workbook对象
//            HSSFWorkbook wb0 = new HSSFWorkbook(fileIn);
//            //获取Excel文档中的第一个表单
//            HSSFSheet sht0 = wb0.getSheetAt(0);
//            //对Sheet中的每一行进行迭代
//
//            int r;
//            int rowNum = sht0.getPhysicalNumberOfRows();
//
//            for (r = 1; r <= rowNum; r++) {
//
//                Row row = sht0.getRow(r);
//                if (row == null) {
//                    break;
//                }
//
//                //创建实体类
//                Employee info=new Employee();
//
//                //取出当前行第1个单元格数据，并封装在info实体stuName属性上
//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                info.setID(row.getCell(0).getStringCellValue());
//                info.setName(row.getCell(1).getStringCellValue());
//                info.setSex(row.getCell(2).getStringCellValue());
//                info.setAge(row.getCell(3).getNumericCellValue());
//                info.setWorkAge(row.getCell(4).getNumericCellValue());
//                info.setSal(row.getCell(5).getNumericCellValue());
//                temp.add(info);
//
//            }
//            fileIn.close();
//        }
//
//        else {
//            System.out.println("No file selected");
//        }
//        return temp;
//    }
//
//    //获取一个演示用的组合数据集对象
//    private static CategoryDataset getDataSet(ArrayList Employees) {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (Employee e : Employees){
//            dataset.addValue(e.workAge, "工龄", e.name);
//            dataset.addValue(e.sal, "工资", e.name);
//            dataset.addValue(e.age, "年龄", e.name);
//        }
//        return dataset;
//    }
//
//
//    //解决图表汉字显示问题
//    private static void processChart(JFreeChart chart) {
//        CategoryPlot plot = chart.getCategoryPlot();
//        CategoryAxis domainAxis = plot.getDomainAxis();
//        ValueAxis rAxis = plot.getRangeAxis();
//        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
//                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
//        TextTitle textTitle = chart.getTitle();
//        textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
//        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
//        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
//        rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
//        rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
//        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
//        // renderer.setItemLabelGenerator(new LabelGenerator(0.0));
//        // renderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 12));
//        // renderer.setItemLabelsVisible(true);
//    }
//}
//
//class Employee {
//    String ID;
//    String name;
//    String sex;
//    double age;
//    double workAge;
//    double sal;
//
//    public void setID(String ID) {
//        this.ID = ID;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public void setAge(double age) {
//        this.age = age;
//    }
//
//    public void setWorkAge(double workAge) {
//        this.workAge = workAge;
//    }
//
//    public void setSal(double sal) {
//        this.sal = sal;
//    }
//}