package com.day19_treeset_sql.clonestring;

public class Address implements Cloneable {
    private String address;

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address  {" +
                "address='" + address + '\'' +
                '}';
    }
}
