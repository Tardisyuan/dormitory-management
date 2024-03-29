<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <base href="${basePath}">
        <title>宿舍管理系统</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="stylesheet" href="static/x-admin/css/font.css">
        <link rel="stylesheet" href="static/x-admin/css/xadmin.css">
        <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
        <script src="static/x-admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="static/x-admin/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container" style="background:linear-gradient(to left,rgba(18, 49, 255, 1), rgba(160, 8, 183, 1)) !important">
            <div class="logo">
                <a href="home">宿舍管理系统</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">${loginInfo.nickname}</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('个人信息','')">个人信息</a></dd>
                        <dd>
                            <a onclick="logout();">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="home">前台首页</a></li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="管理员管理">&#xe726;</i>
                            <cite>管理员信息管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('权限列表','power/page',true)">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>权限列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('管理员列表','user/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>管理员列表</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="学生管理">&#xe6b8;</i>
                            <cite>学生信息管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('学生列表','student/page',true)">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>学生列表</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="辅导员管理">&#xe6b8;</i>
                            <cite>辅导员信息管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('辅导员管理','sc/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>辅导员列表</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="请假单管理">&#xe723;</i>
                            <cite>请假单管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('请假单列表','leavenote/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>请假单列表</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="学院信息管理">&#xe723;</i>
                            <cite>学院信息管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('学院管理','college/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>学院列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('专业管理','major/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>专业列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('班级管理','classes/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>班级列表</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="宿舍管理">&#xe6d7;</i>
                            <cite>宿舍管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('宿舍管理','dorm/page')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>宿舍管理</cite></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div style="
        text-align:center;
        position: absolute;
        bottom: 0px;
        left: 0;
        z-index: 2;
        background-image: -webkit-linear-gradient(left, rgba(255, 255, 255, 1), rgba(0, 0, 0, 0));
        background-image: -o-linear-gradient(left, rgba(255, 255, 255, 1), rgba(0, 0, 0, 0));
        background-image: linear-gradient(left, rgba(255, 255, 255, 1), rgba(0, 0, 0, 0));
        background-repeat: repeat-x;
        padding: 2rem 0;
        width: 220px;
        max-width: 220px;
        overflow: hidden;
        "><a href="http://beian.miit.gov.cn/">沪ICP备2021028558号</a></div>
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
    </body>
    <script>
        function logout(){
            layer.confirm("确定退出系统吗？",{icon:3,title:"信息提示"},function (index){
                window.top.location.replace("logout");
                layer.close(index);
            })
        }
    </script>

</html>