package com.kurong.test.dao;

import com.kurong.test.bean.Item;
import com.kurong.test.bean.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    public List<Order> getAllOrder(@Param("sellername") String sellername, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getOrderCounts(@Param("sellername") String sellername);
    public Order getOrderMessage(@Param("item_name") String item_name,@Param("sellername") String sellername,@Param("buyername") String buyername, @Param("date") String date);
    // 获取登录用户买到的商品
    public List<Order> getUserBoughtOrder(@Param("buyername") String buyername, @Param("sellername")String sellername,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserBoughtOrderCounts(@Param("buyername") String buyername, @Param("sellername") String sellername);
    // 获取登录用户卖出的商品
    public List<Order> getUserSoldOrder(@Param("sellername")String sellername,@Param("buyername") String buyername,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserSoldOrderCounts(@Param("sellername")String sellername,@Param("buyername") String buyername);

    //以下是购物车界面点击“结算”按钮后需要用到的
    public int addOrder(Order order);
    public int deleteShopCar(Order order);
    public int deleteItem(Order order);
    public int checkAmount(Order order);//检查item表中商品数量与order数量的大小
    public int updateItemAmount(Order order);
}
