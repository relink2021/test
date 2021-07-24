package com.kurong.test.dao;

import com.kurong.test.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password, @Param("role") String role);
    public int addUser(User user);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public User checkUsername(@Param("username") String username);
    public int updateMessage(User user);
    public int deleteUser(String username);
    public int updateUser(User user);
    public int resetPassWord(User user);
}
