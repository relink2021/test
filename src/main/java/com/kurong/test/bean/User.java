package com.kurong.test.bean;

/*
 * 用户实体
 */
public class User {

    private String username; // 用户名
    private String password; // 密码
    private String real_name; // 真实姓名
    private String sex;     // 性别
    private String address;  // 地址
    private String phone;    // 手机
    private String email;    // 邮箱
    private String role;     // 角色
    private double balance;     // 余额
    private boolean state = true;   // 状态

    public User() {
    }

    public User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public User(String username, String password, String real_name, String sex, String address, String phone, String email, String role, double balance, boolean state) {
        this.username = username;
        this.password = password;
        this.real_name = real_name;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.balance = balance;
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", real_name='" + real_name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                ", state=" + state +
                '}';
    }
}
