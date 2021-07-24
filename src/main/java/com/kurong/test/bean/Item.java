package com.kurong.test.bean;

// 商品信息
public class Item {
    private String username;
    private String item_name;
    private String fineness;
    private String main_kind;
    private String sub_kind;
    private double price;
    private int amount;
    private String comment;
    private String contact;
    private String item_img;

    public Item() {
    }

    public Item(String username, String item_name, String fineness, String main_kind, String sub_kind, double price, int amount, String comment, String contact, String item_img) {
        this.username = username;
        this.item_name = item_name;
        this.fineness = fineness;
        this.main_kind = main_kind;
        this.sub_kind = sub_kind;
        this.price = price;
        this.amount = amount;
        this.comment = comment;
        this.contact = contact;
        this.item_img = item_img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getFineness() {
        return fineness;
    }

    public void setFineness(String fineness) {
        this.fineness = fineness;
    }

    public String getMain_kind() {
        return main_kind;
    }

    public void setMain_kind(String main_kind) {
        this.main_kind = main_kind;
    }

    public String getSub_kind() {
        return sub_kind;
    }

    public void setSub_kind(String sub_kind) {
        this.sub_kind = sub_kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    @Override
    public String toString() {
        return "Item{" +
                "username='" + username + '\'' +
                ", item_name='" + item_name + '\'' +
                ", fineness='" + fineness + '\'' +
                ", main_kind='" + main_kind + '\'' +
                ", sub_kind='" + sub_kind + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", contact='" + contact + '\'' +
                ", item_img='" + item_img + '\'' +
                '}';
    }
}
