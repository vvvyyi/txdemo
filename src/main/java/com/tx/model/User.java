package com.tx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/29.
 */
@Entity
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
}
