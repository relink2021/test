package com.kurong.test.dao;

import com.kurong.test.bean.Item;
import com.kurong.test.bean.ShopCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
        public List<Item> getAllItem(@Param("item_name") String item_name, @Param("sub_kind") String sub_kind, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize, @Param("filter") int filter, @Param("owner") String owner, @Param("edit") int edit);
        public int releaseItem(Item item);
        public int getItemCounts(@Param("item_name") String item_name, @Param("sub_kind") String sub_kind, @Param("owner") String owner, @Param("edit") int edit);
        public Item getItemMessage(@Param("item_name") String item_name);
        public int deleteItem(String item_name);
        public int editItem(Item item);
        // 以下是购物车中用到的
        public List<ShopCar> getAllShopCar(@Param("buyername") String buyername);
        public int getShopCarCounts(@Param("buyername") String buyername);
        public int deleteShopCar(ShopCar shopCar);
        public int addCart(ShopCar shopCar);
        public ShopCar checkItem(ShopCar shopCar);
        public int editShopCar(ShopCar shopcar);
}
