package com.feijm.web;

import com.feijm.pojo.Product;
import com.feijm.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：
 * @more info   ：
 * @more info   ：
 */
public class ProductApp {
    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println("欢迎进入商品管理系统");
                System.out.println("输入 C 为添加商品");
                System.out.println("输入 U 为修改商品");
                System.out.println("输入 D 为删除商品");
                System.out.println("输入 F 为根据ID查找商品");
                System.out.println("输入 FA 为显示所有的商品");
                System.out.println("输入 DA 为根据ID删除所有的商品");
                System.out.println("输入 Q 为退出系统");
                System.out.println("请输入您的选择：");

                String selectStr = bufferedReader.readLine();
                selectStr = selectStr.trim();

                if ("".equals(selectStr) || selectStr.length() == 0) {
                    System.out.println("输入为空，请重新输入");
                    continue;
                }

                switch (selectStr.toUpperCase()) {
                    case "C":
                        addProduct(bufferedReader);
                        break;
                    case "U":
                        updateById(bufferedReader);
                        break;
                    case "D":
                        deleteProduct(bufferedReader);
                        break;
                    case "F":
                        findById(bufferedReader);
                        break;
                    case "FA":
                        findAll();
                        break;
                    case "DA":
                        deleteAllProduct(bufferedReader);
                        break;
                    case "Q":
                        System.out.println("谢谢您的使用，再见。");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("输入的选择不正确，请重新输入");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("系统初始化失败");
            e.printStackTrace();
        }
    }

    private static void addProduct(BufferedReader bufferedReader) {
        try {
            System.out.println("添加产品功能开启");
            System.out.println("请输入产品名称");
            String productName = bufferedReader.readLine();
            productName = productName.trim();
            System.out.println("请输入产品价格");
            String tempProductPrice = bufferedReader.readLine();
            tempProductPrice = tempProductPrice.trim();
            Double productPrice = Double.parseDouble(tempProductPrice);

            int productFlag = 0;
            while (true) {
                System.out.println("请输入产品上架状态，0为未上架，1为已上架");
                String tempProductFlag = bufferedReader.readLine();
                tempProductFlag = tempProductFlag.trim();

                boolean containIllegalChar = false;
                for (int i = 0; i < tempProductFlag.length(); i++) {
                    if (tempProductFlag.charAt(i) != '1' && tempProductFlag.charAt(i) != '0') {
                        containIllegalChar = true;
                        break;
                    } else {
                        productFlag = Integer.parseInt(tempProductFlag);
                    }
                }

                if (containIllegalChar) {
                    System.out.println("输入的产品上架状态有误，请重新输入");
                } else {
                    break;
                }
            }
            int count = productService.addProductService(new Product(productName, productPrice, productFlag));

            if (count > 0) {
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("-----bufferedReader.readLine() 错误------");
            e.printStackTrace();
        }

    }

    private static void updateById(BufferedReader bufferedReader) {
        try {
            System.out.println("修改单个产品的功能开始");
            System.out.println("请输入需要修改的产品Id");
            String tempProductId = bufferedReader.readLine();
            System.out.println("请输入新的产品名称");
            String tempProductName = bufferedReader.readLine();
            System.out.println("请输入新的产品价格");
            String tempProductPrice = bufferedReader.readLine();
            System.out.println("请输入新的产品上架状态");
            String tempProductFlag = bufferedReader.readLine();

            Product product = new Product(Integer.parseInt(tempProductId), tempProductName,
                    Double.parseDouble(tempProductPrice), Integer.parseInt(tempProductFlag));
            int count = productService.updateByIdService(product);

            if (count > 0) {
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteProduct(BufferedReader bufferedReader) {
        try {
            System.out.println("删除单个产品功能开启");
            System.out.println("请输入需要删除的 productId");
            String tempProductId = bufferedReader.readLine();
            int productId = Integer.parseInt(tempProductId);
            int count = productService.deleteProductService(productId);

            if (count > 0) {
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findById(BufferedReader bufferedReader) {
        try {
            System.out.println("根据Id查找产品的功能开启");
            System.out.println("请输入要查找的 productId");
            String tempProductId = bufferedReader.readLine();
            int productId = Integer.parseInt(tempProductId);
            Product byIdService = productService.findByIdService(productId);

            if (byIdService != null) {
                System.out.println(byIdService);
            } else {
                System.out.println("没有查找到数据");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findAll() {
        System.out.println("返回数据库所有产品的功能开启");

        List<Product> allProduct = productService.findAllService();
        for (Product product : allProduct) {
            System.out.println(product);
        }
        System.out.println("总共的产品的数量（件） = " + allProduct.size());
        System.out.println();
    }

    private static void deleteAllProduct(BufferedReader bufferedReader) {
        try {
            ArrayList<Integer> intArrlist = new ArrayList<>();
            System.out.println("批量删除产品功能开启");

            while (true) {
                System.out.println("请输入所有需要删除的产品的 productId，输入q结束输入");
                String tempProductId = bufferedReader.readLine().toLowerCase().trim();

                if ("q".equals(tempProductId)) {
                    System.out.println("输入结束，共输入productId个数 = " + intArrlist.size());
                    break;
                } else if ("".equals(tempProductId) || tempProductId.length() == 0) {
                    System.out.println("输入的 productId 有误，请重新输入");
                } else {
                    intArrlist.add(Integer.parseInt(tempProductId));
                }
            }

            int[] intArr = productService.deleteAllProductService(intArrlist);
            for (int i = 0; i < intArr.length; i++) {
                if (intArr[i] == 1) {
                    System.out.println("第 " + (i + 1) + " 操作成功");
                } else {
                    System.out.println("第 " + (i + 1) + " 操作失败");
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
