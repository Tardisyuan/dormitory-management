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
        <script src="static/x-admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="static/x-admin/js/xadmin.js"></script>
        <script type="text/javascript" src="static/x-admin/js/jquery.min.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
                <a>首页</a>
                <a>学生信息管理</a>
                <a>
                    <cite>学生列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
                <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
            </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <%--按照条件进行搜索--%>
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="sid" placeholder="请输入学号" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="collid" id="collid">
                                        <option value="">[请选择所在学院]</option>
                                        <c:forEach var="collList" items="${collList}">
                                            <option value="${collList.collegeid}">${collList.collegename}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="cgrade" placeholder="请输入年级" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="sname" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="ssex" id="ssex">
                                        <option value="">[请选择性别]</option>
                                        <option value="1">男</option>
                                        <option value="2">女</option>

                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="mid" id="mid">
                                        <option value="">[请选择所在专业]</option>
                                        <c:forEach var="mList" items="${mList}">
                                            <option value="${mList.mid}">${mList.mname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="cid" id="cid">
                                        <option value="">[请选择所在班级]</option>
                                        <c:forEach var="cList" items="${cList}">
                                            <option value="${cList.cid}">${cList.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="dbno" id="dbno">
                                        <option value="">[请选择宿舍楼]</option>
                                        <option value="L16A">L16A</option>
                                        <option value="L16B">L16B</option>
                                        <option value="C1">C1</option>
                                        <option value="C2">C2</option>
                                        <option value="C3">C3</option>
                                        <option value="C4">C4</option>
                                        <option value="C5">C5</option>
                                        <option value="C6">C6</option>
                                        <option value="C7">C7</option>
                                        <option value="C8">C8</option>
                                        <option value="C9">C9</option>
                                        <option value="C10">C10</option>
                                        <option value="C11">C11</option>
                                        <option value="C12">C12</option>
                                        <option value="C13">C13</option>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="dno" placeholder="请输入宿舍号" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="scid" id="scid">
                                        <option value="">[请选择辅导员]</option>
                                        <c:forEach var="scList" items="${scList}">
                                            <option value="${scList.scid}">${scList.scname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="isafl">
                                        <option value="">[请选择请假状态]</option>
                                        <option value="0">未请假</option>
                                        <option value="1">请假中</option>
                                        <option value="2">已请假</option>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="search">
                                        <i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table" id="tableList" lay-filter="tableList">
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/html" id="toolbar">
        <div class = "layui-btn-container" > 
            <button class = "layui-btn layui-btn-sm" lay-event = "add" >添加</button>
        </div>
    </script>

    <script type="text/html" id="optTpl">
        <div class = "layui-btn-container" >
            <button class = "layui-btn layui-btn-sm" lay-event = "update" >修改</button>
            <button class = "layui-btn layui-btn-sm" lay-event = "replay" >重置密码</button>
            <button class = "layui-btn layui-btn-sm layui-btn-danger" lay-event = "delete" >删除</button>
        </div>
    </script>


    <script type="text/javascript">
        layui.use(['table','form'], function() {
            let table = layui.table;
            let form = layui.form;
            //头工具栏事件
            table.on('toolbar(tableList)',function(obj) {
                if(obj.event=="add"){
                    xadmin.open("学院信息","student/toUpdate",500,700,false);
                }
            });
            /*监听表格内工具栏*/
            table.on('tool(tableList)',function (obj){
                if(obj.event=="update"){
                    xadmin.open("学院信息","student/toUpdate?sid="+obj.data.sid,500,700,false);
                }
                if(obj.event=="replay"){
                    layer.confirm("确定重置该用户密码吗？",{icon:3,title:"确定提示"},function (index){
                        $.ajax({
                            url:"student/doUpdate",
                            data:{
                                id:obj.data.id,
                                password:"888888"
                            },
                            method: "post",
                            dataType: "json",
                            success(res) {
                                if(res.code>0){
                                    layer.alert("重置密码成功，新密码为888888",{icon:6},function (index){
                                        table.reload('tableList');//重新渲染表格
                                        layer.close(index);
                                    })
                                }else{
                                    layer.alert("重置密码失败",{icon:5},function (index){
                                        layer.close(index);
                                    })
                                }
                            },
                            error(e) {
                                layer.msg("与服务器连接失败，请稍后再试...",{icon:5});
                                console.log(e);
                            }
                        });
                    })
                }
                if(obj.event=="delete"){
                    layer.confirm("确定删除该数据吗？",{icon:3,title:"确定提示"},function (index){
                        $.ajax({
                            url:"student/delete",
                            data:{sid:obj.data.sid},
                            method:"post",
                            dataType:"json",
                            success(res){
                                if(res.code==1){
                                    layer.alert("删除成功！",{icon:6},function (index){
                                        table.reload('tableList');//重新渲染表格
                                        layer.close(index);
                                    });
                                }else{
                                    layer.alert(res.msg,{icon:5});
                                }
                            },
                            error(e){
                                layer.msg("与服务器连接失败，请稍后再试...",{icon:5});
                                console.log(e);
                            }
                        });
                        layer.close(index);//关闭确定窗口
                    })
                }
            });
            //渲染表格
            table.render({
                elem:"#tableList",/*指定被渲染的表格*/
                url:"student/list",/*远程加载JSON数据*/
                cols:[[/*设置列*/
                    {field: 'sid',title:'学生学号',align:'center',fixed: 'left'},
                    {field: 'sname',title:'学生姓名',align:'center',width:80},
                    {field: 'collegename',title: '所处学院',align:'center',width:150},
                    {field: 'ssex',title: '性别',align:'center',width:75,templet: function (d) {
                        if (d.ssex===1){
                            return "男";
                        }
                            return "女";
                        }},
                    {field: 'cname',title: '班级名',width:240,align:'center'},
                    {field: 'sidcard',title: '身份证号',align:'center',width:150,hide:true},
                    {field: 'stel',title: '学生电话',align:'center',width:110},
                    {field: 'sptel',title: '学生家长电话',align:'center',width:110},
                    {field: 'sptel2',title: '学生家长电话',align:'center',width:110},
                    {field: 'dno',title: '宿舍',align:'center',width:80,templet: function (d) {
                            return d.dbno +"&nbsp;" + d.dno;
                        }},
                    {field: 'dhno',title: 'A/B间',align:'center',width:70},
                    {field: 'sbed',title: '床位',align:'center',width:70},
                    {field: 'power',title: '权限名',align:'center',width:80},
                    {field: 'isafl',title: '是否请假',width:80,align:'center',templet: function (d) {
                            if (d.isafl===1){
                                return "请假中";
                            }if (d.isafl===1){
                                return "已请假";
                            }
                            return "未请假";
                        }},
                    {title: '操作',toolbar:'#optTpl',fixed:'right',width:220}
                ]],
                page:true,/*开启分页*/
                toolbar:"#toolbar"/*指定工具栏*/
            });
            //监听搜索按钮提交
            form.on('submit(search)',function (obj){
                table.reload('tableList',{
                    page:{
                        curr:1
                    },
                    where:obj.field
                });
                return false;
            });
        });
    </script>
</html>