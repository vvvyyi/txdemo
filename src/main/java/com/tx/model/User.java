package com.tx.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/29.
 */
@Entity
@Table(name = "user", indexes = {@Index(name="mobile_idx",columnList = "mobile",unique = false)})
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String mobile;
    private String realName;
    private String idEntity;
    private String birthDay;
    private String wxId;
    private Timestamp addTime;
    private Timestamp updateTime;
    private Long cityId;
    @Column(nullable = false, length = 50, unique = true)
    private String openid;

    public User() {
    }

    public User(String openid) {
        this.openid = openid;
    }

    public User(String userName, String mobile, String realName, String idEntity, Long cityId, String openid) {
        this.userName = userName;
        this.mobile = mobile;
        this.realName = realName;
        this.idEntity = idEntity;
        this.cityId = cityId;
        this.openid = openid;
        this.addTime = new Timestamp(System.currentTimeMillis());
        this.updateTime = this.addTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(String idEntity) {
        this.idEntity = idEntity;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
