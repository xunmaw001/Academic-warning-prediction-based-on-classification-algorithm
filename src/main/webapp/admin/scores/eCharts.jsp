<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>数据图表</title>
<meta name="keywords" content="">
<meta name="description"
	content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="${pageContext.request.contextPath}/css/gruvbox-light.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css"rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/fakeLoader.css" rel="stylesheet">
<style type="text/css">
	.input-group-addon{
		color: #c23531;
	}
</style>
</head>
<body class="white-bg" style="opacity:0">
<div id="fakeloader"></div>
   <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5> <i class="fa line-chart"></i> 学生人数</h5>
                        <div class="ibox-tools ">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="javascript:void(0)">选项1</a>
                                </li>
                                <li><a href="javascript:void(0)">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="echarts" id="echarts-line-visit" ></div>
	                    <div class="col-sm-8 input-daterange input-group" style="margin: 20px auto 0px;" id="datepicker">
							 <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
							<input type="text" class="input-sm form-control" id="startTime" />
							<span class="input-group-addon">到 </span> <input type="text"
										class="input-sm form-control" id="endTime" />
						</div>
                    </div>
                    
                </div>
            </div>
            
            </div>
            <!-- row结束 -->
           <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5> <i class="fa fa-bar-chart"></i>班级排名</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="javascript:void(0)">选项1</a>
                                </li>
                                <li><a href="javascript:void(0)">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="echarts" id="echarts-line-blogClickSort"></div>
                    	<div style="margin:27px 0 0 15px">
                    		<h5>注:  点击可以查看对应成绩内容</h5>
                    	</div>
                    	
                    </div>
                </div>
            </div>
            
       
            <a style="display:none" class=" btn-sm btn-info" id="btn" href="#" data-toggle="modal" data-target="#myModal">查看</a>
        </div>
    </div>
  
	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/highlight.pack.js"></script>
		<script>hljs.initHighlightingOnLoad();</script> 
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/js/plugins/peity/jquery.peity.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
	<!-- 自定义js -->
	<script src="${pageContext.request.contextPath}/js/content.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
	
	<script
		src="${pageContext.request.contextPath}/js/plugins/echarts/echarts.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/fakeLoader.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/admin/scores/charts.js"></script>
    
</body>

</html>
