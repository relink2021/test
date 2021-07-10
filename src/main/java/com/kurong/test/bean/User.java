package com.kurong.test.bean;

/*
 * 用户实体
 */
public class User {

    private String username; // 用户名
    private String password; // 密码
    private String phone;    // 手机
    private String role;     // 角色
    private boolean state;   // 状态

    public User() {
    }

    public User(String username, String password, String phone, String role, boolean state) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public boolean getState() {
        return state;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }
}
