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
<%--            <input type="hidden" name="id" value="${college.collegeid}">--%>
            <div class="layui-form-item">
                <label for="cid" class="layui-form-label">
                    <span class="x-red">*</span>班级编号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="cid" name="cid" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入班级编号" value="${classes.cid}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="cgrade" class="layui-form-label">
                    <span class="x-red">*</span>年级
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="cgrade" name="cgrade" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入年级" value="${classes.cgrade}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="mid" class="layui-form-label">
                    <span class="x-red">*</span>专业名
                </label>
                <div class="layui-input-inline">
                    <select name="mid" id="mid" required lay-verify="required">
                        <option value="">[请选择所在专业]</option>
                        <c:forEach var="mList" items="${mList}">
                            <option value="${mList.mid}">${mList.mname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="cname" class="layui-form-label">
                    <span class="x-red">*</span>班级名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="cname" name="cname" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入班级名" value="${classes.cname}" class="layui-input">
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
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>状态</label>
                <div class="layui-input-block">
                    <input type="radio" name="cstatus" value="1" lay-skin="primary" title="可用" checked>
                    <input type="radio" name="cstatus" value="0" lay-skin="primary" title="禁用">
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
    let cstatus="${classes.cstatus}";
    let cname="${classes.cname}";
    let cid="${classes.cid}";
    let scid="${classes.scid}";
    let mid="${classes.mid}";
    layui.use(['form'],function() {
        let form = layui.form;
        if(cstatus){
            $("#collegename").val(cname);
            $("#collegeid").val(cid);
            $("#mid").val(mid);
            $("#scid").val(scid);
            let rs=$('input[name="cstatus"]');//获取所有的状态单选框
            for(let i=0;i<rs.length;i++){
                let value=rs[i].value;//获取每个单选框的value值
                rs[i].checked=value==cstatus;//单选框的值和当前权限状态值一致则直接选中
            }
            //调用layui渲染表单
            form.render();
        }
        //监听提交
        form.on('submit(add)',function(data) {
            console.log(data.field)
            $.ajax({
                url:'classes/doUpdate',
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
