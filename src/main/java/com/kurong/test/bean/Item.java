package com.kurong.test.bean;

// 商品信息
public class Item {
    private String id;
    private String logo_img;
    private String logo_name;
    private String detail_img;
    private String detail_top;
    private String detail_info1;
    private String detail_info2;
    private String price;
    private int num;

    public Item() {
    }

    public Item(String logo_img, String logo_name, String detail_img, String detail_top, String detail_info1, String detail_info2, String price, int num) {
        this.logo_img = logo_img;
        this.logo_name = logo_name;
        this.detail_img = detail_img;
        this.detail_top = detail_top;
        this.detail_info1 = detail_info1;
        this.detail_info2 = detail_info2;
        this.price = price;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo_img() {
        return logo_img;
    }

    public void setLogo_img(String logo_img) {
        this.logo_img = logo_img;
    }

    public String getLogo_name() {
        return logo_name;
    }

    public void setLogo_name(String logo_name) {
        this.logo_name = logo_name;
    }

    public String getDetail_img() {
        return detail_img;
    }

    public void setDetail_img(String detail_img) {
        this.detail_img = detail_img;
    }

    public String getDetail_top() {
        return detail_top;
    }

    public void setDetail_top(String detail_top) {
        this.detail_top = detail_top;
    }

    public String getDetail_info1() {
        return detail_info1;
    }

    public void setDetail_info1(String detail_info1) {
        this.detail_info1 = detail_info1;
    }

    public String getDetail_info2() {
        return detail_info2;
    }

    public void setDetail_info2(String detail_info2) {
        this.detail_info2 = detail_info2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", logo_img='" + logo_img + '\'' +
                ", logo_name='" + logo_name + '\'' +
                ", detail_img='" + detail_img + '\'' +
                ", detail_top='" + detail_top + '\'' +
                ", detail_info1='" + detail_info1 + '\'' +
                ", detail_info2='" + detail_info2 + '\'' +
                ", price='" + price + '\'' +
                ", num=" + num +
                '}';
    }
}
