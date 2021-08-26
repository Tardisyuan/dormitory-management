package com.tardisyuan.dormmanagement.bean;

public class Student {
    private Integer sid;//学生学号

    private String sname;//学生姓名

    private Integer collegeid;//所处学院代码

    private Integer ssex;//性别

    private Integer cid;//学生班级

    private Long did;//学生宿舍号

    private String sidcard;//身份证号

    private String stel;//学生电话

    private String sptel;//学生家长电话

    private String sptel2;//学生家长电话

    private Integer sbed;//床位

    private String spassword;//密码

    private Integer pid;//权限

    private Integer isafl;//是否请假（0为未请假，1为请假中，2为请假）

    private String cname;//班级名

    private String collegename;//学院名

    private Integer mid;//专业编号

    private String mname;//专业名

    private String dbno;//宿舍楼

    private Integer dno;//宿舍号

    private String dhno;//A/B间

    private String power;//权限名

    private Integer cgrade;//年级

    private Integer scid;//辅导员编号

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", collegeid=" + collegeid +
                ", ssex=" + ssex +
                ", cid=" + cid +
                ", did=" + did +
                ", sidcard='" + sidcard + '\'' +
                ", stel='" + stel + '\'' +
                ", sptel='" + sptel + '\'' +
                ", sptel2='" + sptel2 + '\'' +
                ", sbed=" + sbed +
                ", spassword='" + spassword + '\'' +
                ", pid=" + pid +
                ", isafl=" + isafl +
                ", cname='" + cname + '\'' +
                ", collegename='" + collegename + '\'' +
                ", mid=" + mid +
                ", mname='" + mname + '\'' +
                ", dbno='" + dbno + '\'' +
                ", dno=" + dno +
                ", dhno='" + dhno + '\'' +
                ", power='" + power + '\'' +
                ", cgrade=" + cgrade +
                ", scid=" + scid +
                '}';
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Integer getCgrade() {
        return cgrade;
    }

    public void setCgrade(Integer cgrade) {
        this.cgrade = cgrade;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getDbno() {
        return dbno;
    }

    public void setDbno(String dbno) {
        this.dbno = dbno;
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
        this.dhno = dhno;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public Integer getSsex() {
        return ssex;
    }

    public void setSsex(Integer ssex) {
        this.ssex = ssex;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getSidcard() {
        return sidcard;
    }

    public void setSidcard(String sidcard) {
        this.sidcard = sidcard == null ? null : sidcard.trim();
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel == null ? null : stel.trim();
    }

    public String getSptel() {
        return sptel;
    }

    public void setSptel(String sptel) {
        this.sptel = sptel == null ? null : sptel.trim();
    }

    public String getSptel2() {
        return sptel2;
    }

    public void setSptel2(String sptel2) {
        this.sptel2 = sptel2 == null ? null : sptel2.trim();
    }

    public Integer getSbed() {
        return sbed;
    }

    public void setSbed(Integer sbed) {
        this.sbed = sbed;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword == null ? null : spassword.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsafl() {
        return isafl;
    }

    public void setIsafl(Integer isafl) {
        this.isafl = isafl;
    }
}