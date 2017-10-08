package com.maikeffi.deposit.interview.automate.model;

public class UserForm {
    public String name;
    public String email;
    public String password;
    public String cnfPassword;

    public UserForm(String name, String email, String password, String cnfPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cnfPassword = cnfPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnfPassword() {
        return cnfPassword;
    }

    public void setCnfPassword(String cnfPassword) {
        this.cnfPassword = cnfPassword;
    }
}
