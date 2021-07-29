package com.kurong.test.bean;

// 购物车类
public class ShopCar {
    private String sellername;  // 卖家
    private String buyername;   // 买家
    private String item_name;   // 商品名
    private String fineness;    // 成色
    private String main_kind;   // 主类
    private String sub_kind;    // 副类
    private double price;       // 单价
    private int amount;         // 数量
    private double total;       // 总价
    private String item_img;    // 商品图片
    private String item_detail; // 商品详情
    private boolean isbought;   // 是否付款(实际并未用到)

    public ShopCar() {
    }

    public ShopCar(String sellername, String buyername, String item_name, String fineness, String main_kind, String sub_kind, double price, int amount, double total, String item_img, String item_detail, boolean isbought) {
        this.sellername = sellername;
        this.buyername = buyername;
        this.item_name = item_name;
        this.fineness = fineness;
        this.main_kind = main_kind;
        this.sub_kind = sub_kind;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.item_img = item_img;
        this.item_detail = item_detail;
        this.isbought = isbought;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public String getItem_detail() {
        return item_detail;
    }

    public void setItem_detail(String item_detail) {
        this.item_detail = item_detail;
    }

    public boolean getIsbought() {
        return isbought;
    }

    public void setIsbought(boolean isbought) {
        this.isbought = isbought;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "sellername='" + sellername + '\'' +
                ", buyername='" + buyername + '\'' +
                ", item_name='" + item_name + '\'' +
                ", fineness='" + fineness + '\'' +
                ", main_kind='" + main_kind + '\'' +
                ", sub_kind='" + sub_kind + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", total=" + total +
                ", item_img='" + item_img + '\'' +
                ", item_detail='" + item_detail + '\'' +
                ", isbought=" + isbought +
                '}';
    }

}
