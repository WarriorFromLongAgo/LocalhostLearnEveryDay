package com.feijm.pojo;

public class Product {
//    productId INT PRIMARY KEY AUTO_INCREMENT,
//    productName VARCHAR(20) NOT NULL,
//    productPrice DOUBLE NOT NULL,
//    productFlag INT NOT NULL,
//    productCid VARCHAR(20) NOT NULL

    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer productFlag;
    private String productCid;

    public Product() {
    }

    public Product(Integer productId, String productName, Double productPrice, Integer productFlag) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productFlag = productFlag;
    }

    public Product(String productName, Double productPrice, Integer productFlag) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productFlag = productFlag;
    }

    @Override
    public String toString() {
        return "Product {" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productFlag=" + productFlag +
                ", productCid='" + productCid + '\'' +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(Integer productFlag) {
        this.productFlag = productFlag;
    }

    public String getProductCid() {
        return productCid;
    }

    public void setProductCid(String productCid) {
        this.productCid = productCid;
    }
}
