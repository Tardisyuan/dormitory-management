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
                <label for="sid" class="layui-form-label">
                    <span class="x-red">*</span>学号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="sid" name="sid" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入学号" value="${student.sid}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="sname" class="layui-form-label">
                    <span class="x-red">*</span>学生姓名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="sname" name="sname" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入学生姓名" value="${student.sname}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="collegeid" class="layui-form-label">
                    <span class="x-red">*</span>所在院校
                </label>
                <div class="layui-input-inline">
                    <select name="collegeid" id="collegeid" required lay-verify="required">
                        <option value="">[请选择所在院校]</option>
                        <c:forEach var="collList" items="${collList}">
                            <option value="${collList.collegeid}">${collList.collegename}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="ssex" value="1" lay-skin="primary" title="男" checked>
                    <input type="radio" name="ssex" value="2" lay-skin="primary" title="女">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="cid" class="layui-form-label">
                    <span class="x-red">*</span>所在班级名
                </label>
                <div class="layui-input-inline">
                    <select name="cid" id="cid" required lay-verify="required">
                        <option value="">[请选择所在班级]</option>
                        <c:forEach var="cList" items="${cList}">
                            <option value="${cList.cid}">${cList.cname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="sidcard" class="layui-form-label">
                    <span class="x-red">*</span>身份证
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="sidcard" name="sidcard" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入身份证" value="${student.sidcard}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="stel" class="layui-form-label">
                    <span class="x-red">*</span>电话号码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="stel" name="stel" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入电话号码" value="${student.stel}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="sptel" class="layui-form-label">
                    <span class="x-red">*</span>父亲电话号码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="sptel" name="sptel" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入家长电话号码" value="${student.sptel}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="sptel2" class="layui-form-label">
                    <span class="x-red">*</span>母亲电话号码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="sptel2" name="sptel2" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入家长电话号码" value="${student.sptel2}" class="layui-input">
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
                <label for="dno" class="layui-form-label">
                    <span class="x-red">*</span>宿舍房间号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="dno" name="dno" required="" lay-verify="required"
                           autocomplete="off" placeholder="请输入宿舍房间号" value="${student.dno}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="dhno" class="layui-form-label">
                    <span class="x-red">*</span>A / B间(选填)
                </label>
                <div class="layui-input-inline">
                    <select name="dhno" id="dhno">
                        <option value="">[选填]</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="sbed" class="layui-form-label">
                    <span class="x-red">*</span>床位
                </label>
                <div class="layui-input-inline">
                    <select name="sbed" id="sbed" required lay-verify="required">
                        <option value="">[请选择床位]</option>
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
                <label for="pid" class="layui-form-label">
                    <span class="x-red">*</span>权限
                </label>
                <div class="layui-input-inline">
                    <select name="pid" id="pid" required lay-verify="required">
                        <option value="">[请选择权限]</option>
                        <c:forEach var="power" items="${pList}">
                            <option value="${power.id}">${power.power}</option>
                        </c:forEach>
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
    let pid="${student.pid}";
    let cid="${student.cid}";
    let collegeid="${student.collegeid}";
    let ssex="${student.ssex}";
    let did = "${student.did}";
    let sbed="${student.sbed}";
    let dbno="${student.dbno}";
    let dno="${student.dno}";
    let dhno="${student.dhno}";
    layui.use(['form'],function() {
        let form = layui.form;
        if("${student.sid}"){
            $("#pid").val(pid);
            $("#cid").val(cid);
            $("#collegeid").val(collegeid);
            $("#dno").val(dno);
            $("#dhno").val(dhno);
            $("#sbed").val(sbed);
            $("#dbno").val(dbno);

            let sex=$('input[name="ssex"]');//获取所有的状态单选框
            for(let i=0;i<sex.length;i++){
                let value=sex[i].value;//获取每个单选框的value值
                sex[i].checked=value==ssex;//单选框的值和当前权限状态值一致则直接选中
            }
            //调用layui渲染表单
            form.render();
        }
        //监听提交
        form.on('submit(add)',function(data) {
            console.log(data.field)
            $.ajax({
                url:'student/doUpdate',
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
                        layer.msg(res.msg,{icon:5});
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
