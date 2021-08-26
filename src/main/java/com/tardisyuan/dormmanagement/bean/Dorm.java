package com.tardisyuan.dormmanagement.bean;

public class Dorm {
    private Long did;//宿舍编号

    private String dbno;//宿舍楼

    private Integer dfloor;//所在楼层

    private Integer dno;//宿舍房间号

    private String dhno;//A/B间

    private Integer dtype;//宿舍容纳人数

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDbno() {
        return dbno;
    }

    public void setDbno(String dbno) {
        this.dbno = dbno == null ? null : dbno.trim();
    }

    public Integer getDfloor() {
        return dfloor;
    }

    public void setDfloor(Integer dfloor) {
        this.dfloor = dfloor;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getDhno() {
        return dhno;
    }

    public void setDhno(String dhno) {
        this.dhno = dhno == null ? null : dhno.trim();
    }

    public Integer getDtype() {
        return dtype;
    }

    public void setDtype(Integer dtype) {
        this.dtype = dtype;
    }
}