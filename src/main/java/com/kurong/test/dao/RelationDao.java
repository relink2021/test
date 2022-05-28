package com.kurong.test.dao;

import com.kurong.test.bean.AccessInfo;
import com.kurong.test.bean.Relation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationDao {

    List<Relation> getAllRelation(String username);
    List<AccessInfo> getAllAccess(String username);
    int agreeAccess(String self, String other);
    int refuseAccess(String self, String other);
    int addRelation(Relation relation);
    int addAccess(AccessInfo accessInfo);
}
