package com.tardisyuan.dormmanagement.bean;

public class College {
    private Integer collegeid;

    private String collegename;

    private Integer collstatus;

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename == null ? null : collegename.trim();
    }

    public Integer getCollstatus() {
        return collstatus;
    }

    public void setCollstatus(Integer collstatus) {
        this.collstatus = collstatus;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeid=" + collegeid +
                ", collegename='" + collegename + '\'' +
                ", collstatus=" + collstatus +
                '}';
    }
}