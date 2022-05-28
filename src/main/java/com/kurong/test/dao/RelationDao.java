package com.kurong.test.dao;

import com.kurong.test.bean.Relation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationDao {

    List<Relation> getAllRelation(@Param("username") String username);
}
