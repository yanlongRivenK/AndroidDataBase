package com.yanlongrivenk.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yanlongRivenK on 2017/9/3.
 */

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long stuId;
    @Index(unique = true)
    private String stuCode;
    private String stuName;
    private String stuSex;
    private String stuScore;
    @Generated(hash = 1309193239)
    public Student(Long stuId, String stuCode, String stuName, String stuSex,
            String stuScore) {
        this.stuId = stuId;
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuScore = stuScore;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getStuId() {
        return this.stuId;
    }
    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }
    public String getStuCode() {
        return this.stuCode;
    }
    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }
    public String getStuName() {
        return this.stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuSex() {
        return this.stuSex;
    }
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }
    public String getStuScore() {
        return this.stuScore;
    }
    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }
}
