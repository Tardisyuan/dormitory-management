<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--isELIgnored属性的默认值就是false，只有idea中需要显示调用这段话--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--引入jstl标签库--%>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <base href="${basePath}">
    <title>欢迎页面-X-admin2.2</title>
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
            <div class="layui-form-item">
                <label for="did" class="layui-form-label">
                    <span class="x-red">*</span>宿舍编号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="did" name="did" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入宿舍编号" value="${dorm.did}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="dbno" class="layui-form-label">
                    <span class="x-red">*</span>宿舍楼
                </label>
                <div class="layui-input-inline">
                    <select name="dbno" id="dbno" required lay-verify="required">
                        <option value="">[请选择宿舍楼]</option>
                        <option value="L16A">L16A</option>
                        <option value="L16B">L16B</option>
<%--                        <option value="C1">C1</option>--%>
<%--                        <option value="C2">C2</option>--%>
<%--                        <option value="C3">C3</option>--%>
                        <option value="C4">C4</option>
<%--                        <option value="C5">C5</option>--%>
<%--                        <option value="C6">C6</option>--%>
<%--                        <option value="C7">C7</option>--%>
<%--                        <option value="C8">C8</option>--%>
<%--                        <option value="C9">C9</option>--%>
<%--                        <option value="C10">C10</option>--%>
<%--                        <option value="C11">C11</option>--%>
<%--                        <option value="C12">C12</option>--%>
<%--                        <option value="C13">C13</option>--%>

                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="dfloor" class="layui-form-label">
                    <span class="x-red">*</span>所在楼层
                </label>
                <div class="layui-input-inline">
                    <select name="dfloor" id="dfloor" required lay-verify="required">
                        <option value="">[请选择楼层]</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="dno" class="layui-form-label">
                    <span class="x-red">*</span>宿舍房间号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="dno" name="dno" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入宿舍房间号" value="${dorm.dno}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="dhno" class="layui-form-label">
                    <span class="x-red">*</span>A / B间(选填)
                </label>
                <div class="layui-input-inline">
                    <select name="dhno" id="dhno" required lay-verify="required">
                        <option value="">[请选择A / B间]</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="dtype" class="layui-form-label">
                    <span class="x-red">*</span>宿舍容纳人数
                </label>
                <div class="layui-input-inline">
                    <select name="dtype" id="dtype" required lay-verify="required">
                        <option value="">[请选择宿舍容纳人数]</option>
                        <option value="4">4</option>
                        <option value="6">6</option>
                    </select>
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
    //使用js获取el表达式的值
    let dfloor="${dorm.dfloor}";
    let dbno="${dorm.dbno}";
    let dhno="${dorm.dhno}";
    let dtype="${dorm.dtype}";
    layui.use(['form'],function() {
        let form = layui.form;
        if(did){
            $("#dfloor").val(dfloor);
            $("#dbno").val(dbno);
            $("#dhno").val(dhno);
            $("#dtype").val(dtype);
            //调用layui渲染表单
            form.render();
        }
        //监听提交
        form.on('submit(add)',function(data) {
            $.ajax({
                url:'dorm/doUpdate',
                method:"post",
                data:data.field,
                dataType:"json",
                success(res){
                    if(res.code==1){
                        layer.alert("更新成功！",{icon:6},function (){
                            //关闭当前frame
                            xadmin.close();
                            // 可以对父窗口进行刷新
                            xadmin.father_reload();
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
