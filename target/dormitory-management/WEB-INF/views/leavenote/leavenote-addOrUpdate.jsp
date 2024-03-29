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
<%--    <link rel="stylesheet" href="static/layDate/css/laydate.css">--%>
    <script type="text/javascript" src="static/x-admin/lib/layui/layui.js" charset="utf-8"></script>
<%--    <script type="text/javascript" src="static/layDate/js/laydate.js" charset="utf-8"></script>--%>
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
<%--          请假单编号--%>
            <input type="hidden" name="lid" value="${leavenote.lid}">
            <div class="layui-form-item">
                <label for="sname" class="layui-form-label">
                    <span class="x-red">*</span>学生姓名
                </label>
                <div class="layui-input-inline">
                    <div>
                        <p id="sname" name="sname"></p>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="scid" class="layui-form-label">
                    <span class="x-red">*</span>辅导员
                </label>
                <div class="layui-input-inline">
                    <select name="scid" id="scid" required lay-verify="required">
                        <option value="">[请选择辅导员]</option>
                        <c:forEach var="scList" items="${scList}">
                            <option value="${scList.scid}">${scList.scname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
<%--            创建时间--%>
            <div class="layui-form-item">
                <label for="lcratetime" class="layui-form-label">
                    <span class="x-red">*</span>创建时间
                </label>
                <div class="layui-input-inline">
                    <label for="lcratetime" class="layui-form-label">
                        <p id="lcratetime" name="lcratetime"></p>
                    </label>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="lstarttime" class="layui-form-label">
                    <span class="x-red">*</span>请假开始时间
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="lstarttime" name="lstarttime" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="lendtime" class="layui-form-label">
                    <span class="x-red">*</span>请假结束时间
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="lendtime" name="lendtime" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="collegename" class="layui-form-label">
                    <span class="x-red">*</span>学院名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="collegename" name="collegename" required="" lay-verify="required"
                           class="layui-input">
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
    let lid="${leavenote.lid}";
    let scid="${leavenote.scid}";
    layui.use(['form'],function() {
        let form = layui.form;
        if(lid){
            layui.use('laydate', function(){
                var laydate = layui.laydate;
                //执行一个laydate实例
                laydate.render({
                    elem: '#lstarttime', //指定元素
                    type: 'datetime',
                    value: format("${leavenote.lstarttime}"),
                });
                laydate.render({
                    elem: '#lendtime', //指定元素
                    type: 'datetime',
                    value: format("${leavenote.lendtime}"),
                });
            });
            $("#lcratetime").text(format("${leavenote.lcratetime}"));
            $("#sname").text("${leavenote.sname}");
            $("#scid").val(scid);
            //调用layui渲染表单
            form.render();
        }
        //监听提交
        form.on('submit(add)',function(data) {
            $.ajax({
                url:'leavenote/doUpdate',
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

    function add0(m){return m<10?'0'+m:m }
    function format(shijianchuo)
    {
        var time = new Date(shijianchuo);
        var y = time.getFullYear();
        var m = time.getMonth()+1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
    }
</script>
</body>
</html>
