<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="baidu-site-verification" content="Eg9tVrHSEK" />
<title>首页_基于分类算法的学业警示预测</title>
<link rel="shortcut icon"
  href="${pageContext.request.contextPath}/images/favicon.ico">
<meta name="keywords" content="基于分类算法的学业警示预测" />
<meta name="description" content="基于分类算法的学业警示预测" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/css/animate.css"
  rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/loaders.css"
  rel="stylesheet">
<link
  href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css"
  rel="stylesheet">

<style type="text/css">
.loader-inner>div {
  background-color: #907f819e
}
</style>
</head>
<body
  style="background:url(${pageContext.request.contextPath}/images/bj.png) repeat top left scroll;z-index:-2">
  <%@ include file="top.jsp"%>
  <article style="opacity:0">
    <!-- <div class="pics ">
			<ul>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div> -->

    <div class="lbox ">
      <div class="banbox">
        <div class="banner">
          <div id="banner" class="fader">
            <li class="slide" style=" "><a
              href="https://www.4562.com/" target="_blank"><img
                src="${pageContext.request.contextPath}/images/5e9a97fc44fc12475b6b0e87e2ff5806.jpg"></a></li>

            <li class="slide" style=" "><a
              href="javascript:void(0)"
              target="_blank"><img
                src="${pageContext.request.contextPath}/images/2.jpg"></a></li>

            <li class="slide" style=""><a
              href="https://www.4562.com/" target="_blank"><img
                src="${pageContext.request.contextPath}/images/8db2f0313616ebe46ca5770769850b42.png"></a></li>
            <div class="fader_controls">
              <div class="pic_page prev" data-target="prev"></div>
              <div class="pic_page next" data-target="next"></div>
              <ul class="pager_list">

              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="headline">
        <ul>
          <li><a href="find/20400.html"
            title="【2019届校园招聘】如何准备互联网校招？"><img
              src="${pageContext.request.contextPath}/images/3ee0644472fa8556562ab3d8716b5316.jpg"
              alt="【2019届校园招聘】【2019届校园招聘】如何准备互联网校招？"><span>【2019届校园招聘】<br> 该如何准备互联网校招？</span></a></li>
          <li><a href="find/19873.html"
            title="【匆匆校园招聘季】总结校招经历的这几个月…"><img
              src="${pageContext.request.contextPath}/images/3f0b6da48a6fd4e626a021ff7bd0d74f.jpg"
              alt="【匆匆校园招聘季】总结校招经历的这几个月…"><span>【匆匆校园招聘季】<br>总结校招经历的这几个月</span></a></li>
        </ul>
      </div>

      <div class="clearblank"></div>

      <div class="tab_box whitebg">

        <div class="tab_buttons">
          <ul>
            <li class=""></li>
            <li class=""></li>
          </ul>
        </div>
        <div class="newstab">
          
        </div>


      </div>

      <div class="zhuanti whitebg">
        <h2 class="htitle">特别推荐</h2>
        <ul class="animated ">

        </ul>
      </div>
      <div class="ad whitebg">
        <a href="#" target="_blank"> <img
          src="${pageContext.request.contextPath}/images/longad2.png">
        </a>
      </div>

      <div class="newblogs bloglist whitebg animated fadeIn"
        style="display:none;animation-delay:0.3s">
        <h2 class="htitle">最新文章</h2>
        <ul class="animated ">

        </ul>
        <p class="page" style='display:none'>
        <p>
        <p class="pageMin">
        <p>
      </div>

    </div>


    <div class="rbox">
      <div class="card">
        <h2>名片</h2>
        <p>网名：</p>
        <ul class="linkmore">
          <li><a href="http://www.luotf.com" target="_blank"
            class="iconfont icon-zhuye" title="网站地址"></a></li>
          <li><a
            href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=-MTIxcrLz8jMyLyNjdKfk5E"
            target="_blank" class="iconfont icon-youxiang" title="我的邮箱"></a></li>
          <li><a
            href="http://wpa.qq.com/msgrd?v=3&uin=849673404&site=qq&menu=yes"
            target="_blank" class="iconfont icon---" title="QQ联系我"></a></li>
          <li id="weixin"><a href="#" target="_blank"
            class="iconfont icon-weixin" title="关注我的微信"></a><i><img
              src="${pageContext.request.contextPath}/images/my_vx.png"></i></li>
        </ul>
      </div>

    <div class="whitebg notice">
      <h2 class="htitle">热门文章</h2>
      <ul>
      
     </ul>
    </div>

      <div class="dj paihang animated fadeIn"
        style="animation-delay:0.3s">
        <h2 class="htitle">点击排行</h2>
        <ul class="">

        </ul>
      </div>

     
    </div>
    <a href="#" class="top cd-top animated ">Top</a>
  </article>
  <!-- 全局js -->
  <script src="${pageContext.request.contextPath}/js/page/index.js"></script>
  <script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
  <script
    src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
</body>

</html>
