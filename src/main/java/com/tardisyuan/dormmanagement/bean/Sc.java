package com.tardisyuan.dormmanagement.bean;

public class Sc {
    private Integer scid;

    private String scname;

    private Integer collegeid;

    private String sctel;

    private Integer scstatus;

    private String scpassword;

    private Integer pid;

    private String collegename;

    private String power;

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname == null ? null : scname.trim();
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public String getSctel() {
        return sctel;
    }

    public void setSctel(String sctel) {
        this.sctel = sctel == null ? null : sctel.trim();
    }

    public Integer getScstatus() {
        return scstatus;
    }

    public void setScstatus(Integer scstatus) {
        this.scstatus = scstatus;
    }

    public String getScpassword() {
        return scpassword;
    }

    public void setScpassword(String scpassword) {
        this.scpassword = scpassword == null ? null : scpassword.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}