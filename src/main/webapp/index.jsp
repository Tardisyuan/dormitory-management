<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>宿舍系统后台登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="static/x-admin/css/font.css">
    <link rel="stylesheet" href="static/x-admin/css/login.css">
	  <link rel="stylesheet" href="static/x-admin/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="static/x-admin/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">宿舍系统登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
			<select name="login_type">
                <option value="3">3.管理员登录</option>
				<option value="1">1.学生登录</option>
				<option value="2">2.辅导员登录</option>
			</select>
			<hr class="hr15">
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function  () {
            layui.use('form', function(){
				var form = layui.form;
				//监听提交
				form.on('submit(login)', function(data){
					var url = 'adminlogin';
					if (data.field.login_type == 1){
					    url = 'studentlogin'
                    }
                    if (data.field.login_type == 2){
                        url = 'sclogin'
                    }
					$.ajax({
						url:url,
						data:data.field,
						method:"post",
						dataType:"json",
						success(res){
							if(res.code==1){
								location.replace('home');
							}else{
								layer.msg(res.msg,{icon:5});
							}
						},
						error(e){
							console.log(e);
							layer.alert('与服务器连接失败，请稍后再试...',{icon:5});
							}
					});
				
				
                
                return false;
              });
            });
        })
    </script>
    <!-- 底部结束 -->
</body>
</html>
