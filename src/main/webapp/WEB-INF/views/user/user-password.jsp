<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--isELIgnored属性的默认值就是false，只有idea中需要显示调用这段话--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--引入jstl标签库--%>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <base href="${basePath}">
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="static/x-admin/css/font.css">
        <link rel="stylesheet" href="static/x-admin/css/xadmin.css">
        <script type="text/javascript" src="static/x-admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="static/x-admin/js/xadmin.js"></script>
        <script type="text/javascript" src="static/x-admin/js/jquery.min.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                    <input type="hidden" name="id" value="${loginInfo.id}">
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          用户名
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="username" name="username" autocomplete="off" placeholder="请输入用户名" value="${loginInfo.username}" disabled class="layui-input">
                      </div>
                  </div>
                    <div class="layui-form-item">
                        <label for="oldPwd" class="layui-form-label">
                            <span class="x-red">*</span>原密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="oldPwd" name="oldPwd" required="" lay-verify="required|checkPwd" autocomplete="off" placeholder="请输入原密码" class="layui-input">
                        </div>
                    </div>
                        <div class="layui-form-item">
                        <label for="password" class="layui-form-label">
                            <span class="x-red">*</span>密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="password" name="password" required="" lay-verify="required"
                                   autocomplete="off" placeholder="请输入密码" class="layui-input">
                        </div>
                    </div>
                        <div class="layui-form-item">
                        <label for="repwd" class="layui-form-label">
                            <span class="x-red">*</span>确认密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="repwd" name="repwd" required="" lay-verify="required|respwd" autocomplete="off" placeholder="请再次输入密码" class="layui-input">
                        </div>
                    </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label"></label>
                      <button  class="layui-btn" lay-filter="add" lay-submit="">
                          提交
                      </button>
                  </div>
              </form>
            </div>
        </div>
        <script>

            layui.use(['form'],function() {
                let form = layui.form;
                //自定义表单验证
                form.verify({
                    respwd:function (value){
                        if(value!=$("#password").val()){
                            return "两次密码不一致！";
                        }
                    },
                    checkPwd:function (value){
                        let result=0;
                        $.ajax({
                            url:"user/checkPwd",
                            data:{
                                password:value,
                                id:"${loginInfo.id}"
                            },
                            method:"GET",
                            dataType: "json",
                            async:false,    //是否发送异步请求
                            success(res) {
                                result=res.code;
                            },
                            error(e) {
                                layer.msg("与服务器连接失败，请稍后再试...",{icon:5});
                                console.log(e);
                            }
                        });
                        if(result==0){
                            return "原密码不正确！";
                        }
                    }
                });


                //监听提交
                form.on('submit(add)',function(data) {
                    $.ajax({
                        url:'user/doUpdate',
                        method:"post",
                        data:data.field,
                        dataType:"json",
                        success(res){
                            if(res.code==1){
                                layer.alert("修改密码成功，请重新登录！",{icon:6},function (){
                                    //关闭当前frame
                                    xadmin.close();
                                    window.top.location.replace("logout");
                                });
                            }else{
                                layer.alert("更新失败！",{icon:5});
                            }
                        },
                        error(e){
                            console.log(e);
                            layer.msg("与服务器连接失败，请稍后再试...",{icon:5});
                        }
                    });
                    return false;
                });
            });
        </script>
    </body>
</html>
