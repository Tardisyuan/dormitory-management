package com.tardisyuan.dormmanagement.util;

public class R {
    private Integer code;
    private String msg;
    private Object data;
    private Long count;

    public R(){

    }

    public R(Integer code){
        this.code=code;
    }

    public R(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public R(Integer code,String msg,Object data,Long count){
        this.code=code;
        this.msg=msg;
        this.data=data;
        this.count=count;
    }

    public R(Integer code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static R ok(){
        return new R(1,"success");
    }

    public static R ok(Object data){
        return new R(1,"success",data);
    }

    public static R error(){
        return new R(0,"error");
    }

    public static R page(Long count,Object data){
        return new R(0,"暂无数据",data,count);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
