package com.beifeng.hadoop.spring.boot.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="cas_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String username;
    
    @Column
    private String password;
    
    @Column
    private String email;
    
    @Column
    private String mobile;
    
    @Column
    private String applications;
    
    public User() {
        super();
    }

    public User(String username, String password, String email, String mobile,
            String applications) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.applications = applications;
    }
    
    

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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getApplications() {
        return applications;
    }

    public void setApplications(String applications) {
        this.applications = applications;
    }
    
    
    
    
}
