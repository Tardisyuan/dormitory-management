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
                    <a>宿舍管理</a>
                    <a>
                        <cite>宿舍列表</cite></a>
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
                        <%--                            按照条件进行搜索--%>
                        <form class="layui-form layui-col-space5">
                            <div class="layui-inline layui-show-xs-block">
                                <input type="text" name="did" placeholder="请输入宿舍编号" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <select name="dbno">
                                    <option value="">[请选择宿舍楼]</option>
                                    <option value="L16A">L16A</option>
                                    <option value="L16B">L16B</option>
                                    <%--<option value="C1">C1</option>--%>
                                    <%--<option value="C2">C2</option>--%>
                                    <%--<option value="C3">C3</option>--%>
                                    <option value="C4">C4</option>
                                    <%--<option value="C5">C5</option>--%>
                                    <%--<option value="C6">C6</option>--%>
                                    <%--<option value="C7">C7</option>--%>
                                    <%--<option value="C8">C8</option>--%>
                                    <%--<option value="C9">C9</option>--%>
                                    <%--<option value="C10">C10</option>--%>
                                    <%--<option value="C11">C11</option>--%>
                                    <%--<option value="C12">C12</option>--%>
                                    <%--<option value="C13">C13</option>--%>
                                </select>
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <select name="dfloor" id="dfloor">
                                    <option value="">[请选择楼层]</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <input type="text" name="dno" placeholder="请输入宿舍房间号" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <select name="dhno" id="dhno">
                                    <option value="">[请选择A / B间]</option>
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                </select>
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <select name="dtype" id="dtype">
                                    <option value="">[请选择宿舍容纳人数]</option>
                                    <option value="4">4</option>
                                    <option value="6">6</option>
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
<%--    <script type="text/html" id="statusTpl">--%>
<%--        <input type = "checkbox" name = "scstatus" disabled value = "{{d.scstatus}}" lay-skin = "switch" lay-text = "可用|禁用" lay-filter = "scstatus" {{ d.scstatus == 1 ? 'checked': ''}} >--%>
<%--    </script>--%>

<script type="text/html" id="optTpl">
    <div class = "layui-btn-container" >
        <button class = "layui-btn layui-btn-sm" lay-event = "update" >修改</button>
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
                xadmin.open("学院信息","dorm/toUpdate",500,500,false);
            }
        });
        /*监听表格内工具栏*/
        table.on('tool(tableList)',function (obj){
            if(obj.event=="update"){
                xadmin.open("学院信息","dorm/toUpdate?did="+obj.data.did,500,500,false);
            }
            if(obj.event=="delete"){
                layer.confirm("确定删除该数据吗？",{icon:3,title:"确定提示"},function (index){
                    $.ajax({
                        url:"dorm/delete",
                        data:{did:obj.data.did},
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
            url:"dorm/list",/*远程加载JSON数据*/
            cols:[[/*设置列*/
                {field: 'did',title:'宿舍编号'},
                {field: 'dbno',title: '宿舍楼'},
                {field: 'dfloor',title: '所在楼层'},
                {field: 'dno',title: '宿舍房间号'},
                {field: 'dhno',title: 'A/B间'},
                {field: 'dtype',title: '宿舍容纳人数'},
                {title: '操作',toolbar:'#optTpl',fixed:'right'}
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