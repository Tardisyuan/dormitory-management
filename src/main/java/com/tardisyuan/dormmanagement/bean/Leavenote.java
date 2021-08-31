package com.tardisyuan.dormmanagement.bean;

import java.time.ZonedDateTime;
import java.util.Date;

public class Leavenote {
    private Integer lid;

    private Integer sid;

    private Integer scid;

    private Date lcratetime;

    private Date lstarttime;

    private Date lendtime;

    private Integer ltype;

    private String lnote;

    private String sname;

    private String scname;

    @Override
    public String toString() {
        return "Leavenote{" +
                "lid=" + lid +
                ", sid=" + sid +
                ", scid=" + scid +
                ", lcratetime=" + lcratetime +
                ", lstarttime=" + lstarttime +
                ", lendtime=" + lendtime +
                ", ltype=" + ltype +
                ", lnote='" + lnote + '\'' +
                ", sname='" + sname + '\'' +
                ", scname='" + scname + '\'' +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Date getLcratetime() {
        return lcratetime;
    }

    public void setLcratetime(Date lcratetime) {
        this.lcratetime = lcratetime;
    }

    public Date getLstarttime() {
        return lstarttime;
    }

    public void setLstarttime(Date lstarttime) {
        this.lstarttime = lstarttime;
    }

    public Date getLendtime() {
        return lendtime;
    }

    public void setLendtime(Date lendtime) {
        this.lendtime = lendtime;
    }

    public Integer getLtype() {
        return ltype;
    }

    public void setLtype(Integer ltype) {
        this.ltype = ltype;
    }

    public String getLnote() {
        return lnote;
    }

    public void setLnote(String lnote) {
        this.lnote = lnote == null ? null : lnote.trim();
    }
}