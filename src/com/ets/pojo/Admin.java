package com.ets.pojo;

public class Admin {
    private Integer adId;

    private String adUsername;

    private String adRealname;

    private String adPassword;

    private String adPhone;

    private String adEmail;

    private Integer adRole;

    private Integer adState;

    public Admin(Integer adId, String adUsername, String adRealname, String adPassword, String adPhone, String adEmail, Integer adRole, Integer adState) {
        this.adId = adId;
        this.adUsername = adUsername;
        this.adRealname = adRealname;
        this.adPassword = adPassword;
        this.adPhone = adPhone;
        this.adEmail = adEmail;
        this.adRole = adRole;
        this.adState = adState;
    }

    public Admin() {
        super();
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(String adUsername) {
        this.adUsername = adUsername == null ? null : adUsername.trim();
    }

    public String getAdRealname() {
        return adRealname;
    }

    public void setAdRealname(String adRealname) {
        this.adRealname = adRealname == null ? null : adRealname.trim();
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword == null ? null : adPassword.trim();
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone == null ? null : adPhone.trim();
    }

    public String getAdEmail() {
        return adEmail;
    }

    public void setAdEmail(String adEmail) {
        this.adEmail = adEmail == null ? null : adEmail.trim();
    }

    public Integer getAdRole() {
        return adRole;
    }

    public void setAdRole(Integer adRole) {
        this.adRole = adRole;
    }

    public Integer getAdState() {
        return adState;
    }

    public void setAdState(Integer adState) {
        this.adState = adState;
    }
}