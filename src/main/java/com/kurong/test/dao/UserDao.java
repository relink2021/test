package com.kurong.test.dao;

import com.kurong.test.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password, @Param("role") String role);
    // 返回手机号和邮箱，这里需要填入符合用户名的电话和邮箱信息
    public User getPandE(@Param("username") String username,@Param("phone") String phone, @Param("email") String email);
    public int addUser(User user);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public User checkUsername(@Param("username") String username);
    public int updateMessage(User user);
    public int updateState(User user);
    public int deleteUser(String username);
    public int updateUser(User user);
    public int resetPassWord(User user);
}
