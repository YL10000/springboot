package com.beifeng.hadoop.spring.boot.modal;

public class CasUser {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String mobile;

    private String applications;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getApplications() {
        return applications;
    }

    public void setApplications(String applications) {
        this.applications = applications == null ? null : applications.trim();
    }
}