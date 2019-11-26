package com.fff.domain;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private String orderNum;
    /*订单生成时间*/
    private Date orderTime;
    private String orderTimeStr;
    /*旅游人数*/
    private int peopleCount;
    /*订单描述*/
    private String orderDesc;
    /*支付方式(0 支付宝 1 微信 2其它)*/
    private String payTypeStr;
    private Integer payType;
    /*订单状态(0 未支付 1 已支付)*/
    private int orderStatus;
    private String orderStatusStr;

    private Product product;
    private Member member;
    private List<Traveller> travellerList;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        System.out.println(" product setDepartureTime ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderTimeStr = simpleDateFormat.format(orderTime);
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
//        if(orderTime!=null){
//             orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm");
//        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus==0){
            orderStatusStr="未支付";
        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellerList() {
        return travellerList;
    }

    public void setTravellerList(List<Traveller> travellerList) {
        this.travellerList = travellerList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        if(payType==0){
            payTypeStr = "微信";
        }else if(payType==1){
            payTypeStr = "支付宝";
        }else{
            payTypeStr="其他";
        }
        this.payType = payType;
    }

    public String getPayTypeStr() {

        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellerList=" + travellerList +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
