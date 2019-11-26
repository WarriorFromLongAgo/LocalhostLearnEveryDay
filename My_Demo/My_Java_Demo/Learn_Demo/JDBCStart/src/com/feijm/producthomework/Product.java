package com.feijm.producthomework;

public class Product {
    private Integer pid;
    private String pname;
    private Integer price;
    //1代表已上架，0代表未上架
    private Integer flag;
    private String cid;

    public Product() {
    }

    public Product(String pname, Integer price, Integer flag, String cid) {
        this.pname = pname;
        this.price = price;
        if (flag != 0 && flag != 1) {
            throw new RuntimeException("设置的上架状态有误");
        }
        this.flag = flag;
        this.cid = cid;
    }

    public Product(Integer pid, String pname, Integer price, Integer flag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        if (flag != 0 && flag != 1) {
            throw new RuntimeException("设置的上架状态有误");
        }
        this.flag = flag;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product {" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", flag=" + flag +
                ", cid='" + cid + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        if (flag != 0 && flag != 1) {
            throw new RuntimeException("设置的上架状态有误");
        }
        this.flag = flag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }


}
