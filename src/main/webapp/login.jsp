<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<title>基于分类算法的学业警示预测-登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"> 
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet">

<script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-7">
				<div class="signin-info">
					<div class="logopanel m-b">
						<h1>[哈尔滨华德学院]</h1>
					</div>
					<div class="m-b"></div>
					<h4>
						欢迎进入 <strong> 基于分类算法的学业警示预测系统</strong>
					</h4>
					<ul class="m-b">
						
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							数据爬取功能:可以爬我们哈尔滨华德学院学生近几年成绩的数据。</li>
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							数据存储模块，能构造训练数据集和构造预测数据集，这两种数据分开存储</li>	
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i>
							能进行分类算法的评估能对预测结果可视化输出</li>
						<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 所有操作都异步</li>
						
					</ul>
					
				</div>
			</div>
			<div class="col-sm-5">
				<form id="login" action="${pageContext.request.contextPath}/checkLogin" method="post">
					<h3 class="no-margins">登录</h3>
					<p class="m-t-md">登录访问基于分类算法的学业警示预测系统</p>
					<input type="text" id="username" name="username" class="form-control uname"
						placeholder="用户名" /> <input type="password" name="password" id="password"
						class="form-control pword m-b" placeholder="密码" /> <a
						style="color:#101010de" href="javascript:void(0);">忘记密码了？</a>
						 <span class="msg" style="color:#6722228a;margin-left:20px;"
						href="javascript:void(0);">${message }</span>
					<button type="button" onclick="login()" class="btn btn-success btn-block">登录</button>
				</form>
			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">
				<strong>&copy; 2019-2020 基于分类算法的学业警示预测</strong>
			</div>
		</div>
	</div>
	<div class="gohome" style="display:none"></div>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/content.js"></script>
	<script type="text/javascript">
$(document).ready(function() {
	$(".gohome").css("display","none");
});


var login=function(){
	var username=$("#username").val().replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
	var password=$("#password").val().replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
	$("#username").val(username);
	$("#password").val(password);
	$("#login").submit();
}
</script>
</body>

</html>
