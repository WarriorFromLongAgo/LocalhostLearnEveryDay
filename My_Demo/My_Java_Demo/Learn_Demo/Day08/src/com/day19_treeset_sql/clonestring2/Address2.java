package com.day19_treeset_sql.clonestring2;

public class Address2 implements Cloneable {
    private String address2;

    public Address2() {
    }

    public Address2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address  {" +
                "address='" + address2 + '\'' +
                '}';
    }
}
