package com.tardisyuan.dormmanagement.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

public class Leavenote {
    private Integer lid;

    private Integer sid;

    private Integer scid;

    private ZonedDateTime lcratetime;

    private String cratetime;

    private ZonedDateTime lstarttime;

    private String starttime;

    private ZonedDateTime lendtime;

    private String endtime;

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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCratetime() {
        return cratetime;
    }

    public void setCratetime(String cratetime) {
        this.cratetime = cratetime;
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

    public ZonedDateTime getLcratetime() {
        return lcratetime;
    }

    public void setLcratetime(ZonedDateTime lcratetime) {
        this.lcratetime = lcratetime;
    }

    public ZonedDateTime getLstarttime() {
        return lstarttime;
    }

    public void setLstarttime(ZonedDateTime lstarttime) {
        this.lstarttime = lstarttime;
    }

    public ZonedDateTime getLendtime() {
        return lendtime;
    }

    public void setLendtime(ZonedDateTime lendtime) {
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