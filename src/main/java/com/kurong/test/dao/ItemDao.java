package com.kurong.test.dao;

import com.kurong.test.bean.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
        public List<Item> getAllItem(@Param("item_name") String item_name, @Param("sub_kind") String sub_kind, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
        public int releaseItem(Item item);
        public int getItemCounts(@Param("item_name") String item_name, @Param("sub_kind") String sub_kind);
        public Item getItemMessage(@Param("item_name") String item_name);
        public int deleteItem(String item_name);
        public int editItem(Item item);
}
