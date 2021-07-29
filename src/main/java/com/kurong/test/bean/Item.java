package com.kurong.test.bean;

// 商品信息
public class Item {
    private String username;     // 发布者
    private String item_name;    // 商品名
    private String fineness;     // 成色
    private String main_kind;    // 主类
    private String sub_kind;     // 副类
    private double price;        // 单价
    private int amount;          // 数量
    private String item_detail;  // 详情
    private String contact;      // 卖家联系方式
    private String item_img;     // 商品图片url

    public Item() {
    }

    public Item(String username, String item_name, String fineness, String main_kind, String sub_kind, double price, int amount, String item_detail, String contact, String item_img) {
        this.username = username;
        this.item_name = item_name;
        this.fineness = fineness;
        this.main_kind = main_kind;
        this.sub_kind = sub_kind;
        this.price = price;
        this.amount = amount;
        this.item_detail = item_detail;
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

    public String getItem_detail() {
        return item_detail;
    }

    public void setItem_detail(String item_detail) {
        this.item_detail = item_detail;
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
                ", item_detail='" + item_detail + '\'' +
                ", contact='" + contact + '\'' +
                ", item_img='" + item_img + '\'' +
                '}';
    }
}
