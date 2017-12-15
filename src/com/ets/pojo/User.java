package com.ets.pojo;

import java.util.Date;

public class User {
    private Long userId;

    private String username;

    private String password;

    private String realname;

    private String sex;

    private Integer idcard;

    private String phone;

    private Date birthday;

    private String email;

    private Date createdtime;

    private Date updatedtime;

    private Byte role;

    private String question;

    private String answer;

    public User(Long userId, String username, String password, String realname, String sex, Integer idcard, String phone, Date birthday, String email, Date createdtime, Date updatedtime, Byte role, String question, String answer) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.idcard = idcard;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.createdtime = createdtime;
        this.updatedtime = updatedtime;
        this.role = role;
        this.question = question;
        this.answer = answer;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}