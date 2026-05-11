package com.sisiback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int id;
    private String userName;
    private String userPass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
