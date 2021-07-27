package com.kurong.test.bean;

public class ChekInfo {
    private String cart_owner;
    private String item_name;

    public ChekInfo() {
    }

    public ChekInfo(String cart_owner, String item_name) {

        this.cart_owner = cart_owner;
        this.item_name = item_name;
    }

    public String getCart_owner() {
        return cart_owner;
    }

    public void setCart_owner(String cart_owner) {
        this.cart_owner = cart_owner;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    @Override
    public String toString() {
        return "ChekInfo{" +
                "cart_owner='" + cart_owner + '\'' +
                ", item_name='" + item_name + '\'' +
                '}';
    }
}

