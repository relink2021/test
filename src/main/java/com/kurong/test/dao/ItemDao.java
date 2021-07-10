package com.kurong.test.dao;

import com.kurong.test.bean.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
    List<Item> getItems();
}
