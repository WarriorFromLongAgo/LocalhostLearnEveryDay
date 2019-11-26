package com.fff.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable {
    private Integer productId;
    private String productNum;
    private String productName;
    private String cityName;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departureTime;
    private String departureTimeStr;

    private Double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        System.out.println(" product setDepartureTime ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        departureTimeStr = simpleDateFormat.format(departureTime);
    }

    public String getDepartureTimeStr() {
        System.out.println(" product getDepartureTimeStr ");

        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        System.out.println(" product setDepartureTimeStr ");

        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        System.out.println(" Product getProductStatus ");
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        System.out.println(" Product setProductStatus ");
        if (productStatus == 0) {
            productStatusStr = "未上架";
        } else {
            productStatusStr = "已上架";
        }
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        System.out.println(" Product getProductStatusStr ");

        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        System.out.println(" Product setProductStatusStr ");

        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        System.out.println(" Product toString ");
        return "Product{" +
                "productId=" + productId +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTimeStr=" + departureTimeStr +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatusStr=" + productStatusStr +
                '}';
    }
}
