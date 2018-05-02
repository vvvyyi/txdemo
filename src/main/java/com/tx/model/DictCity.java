package com.tx.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 城市
 */
@Entity
public class DictCity {
    //ID (邮编)
    @Id
    private int id;

    private int parentId;
    //层级
    private int depth;
    //级别中文
    private String depthStr;
    //拼音首字母
    private char firstLetter;
    //简拼
    private String jianpin;
    //全拼
    private String pinyin;
    //中文
    private String name;

    public DictCity(){}

    public DictCity(int id, int parentId, int depth, String depthStr, char firstLetter, String jianpin, String pinyin, String name) {
        this.id = id;
        this.parentId = parentId;
        this.depth = depth;
        this.depthStr = depthStr;
        this.firstLetter = firstLetter;
        this.jianpin = jianpin;
        this.pinyin = pinyin;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getDepthStr() {
        return depthStr;
    }

    public void setDepthStr(String depthStr) {
        this.depthStr = depthStr;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getJianpin() {
        return jianpin;
    }

    public void setJianpin(String jianpin) {
        this.jianpin = jianpin;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
