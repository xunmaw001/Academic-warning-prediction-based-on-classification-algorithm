
基于Spring+SpringMVC+Mybatis架构，响应式设计，支持手机、平板、PC，都有良好的视觉效果！</font>**



### 技术栈
#### 后端

名称 | 描述 | 官网
---|--- |---
Spring Framework | 容器	| http://projects.spring.io/spring-framework/
SpringMVC | MVC框架	| http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc
MyBatis | ORM框架 |  	http://www.mybatis.org/mybatis-3/zh/index.html
MyBatis Generator | 代码生成 | http://www.mybatis.org/generator/index.html
Apache Shiro | 安全框架 | http://shiro.apache.org/
PageHelper | MyBatis分页 | http://git.oschina.net/free/Mybatis_PageHelper
Maven | 项目构建管理 | http://maven.apache.org/
MySQL | 数据库 | https://www.mysql.com/
Tomcat 8.0 | 服务器 | http://tomcat.apache.org/


#### 前端

名称 | 描述 | 官网
---|--- |---
jQuery | 函数库 | http://jquery.com/
Bootstrap | 前端框架 | 	http://getbootstrap.com/
Bootstrap-table | 数据表格 | http://bootstrap-table.wenzhixin.net.cn/
echarts | 图表 | http://echarts.baidu.com/
web uploader | 图片上传 | http://fex.baidu.com/webuploader/
layui | 弹出层 | http://www.layui.com/
sweetalert | 弹出层 |http://mishengqiang.com/sweetalert/
highlight | 代码高亮 |https://highlightjs.org/
summernote | 富文本编辑 |https://summernote.org/
pace | 进度条 |https://github.hubspot.com/pace/
datapicker | 时间选择器 | https://jqueryui.com/datepicker/
Font-awesome | 字体图标 | http://fontawesome.io/
fancybox | 图片展示 |http://fancybox.net/
fakeLoader | 页面预加载 |https://www.awesomes.cn/repo/joaopereirawd/fakeloader-js
content | 菜单栏 
contabs | 选项卡


<br><br><br><br><br><br><br>
<br><br><br><br><br><br>


#### 其余界面访问 www.luotf.com 预览 &emsp;&emsp;后台:luotf/admin  
### 项目部署说明
> 1. 下载并导入本项目。
> 2. 在数据库中导入webapp文件下的 **blog.sql** ，赠送几千条数据。 (如果sql文件导入出错,请粘贴导入) 导入成功后将会多一个 **blog** 数据库。
> 3. 修改项目中的 **mysql.properties** 中的数据库信息。
> 4. 进入Tomcat 安装目录，找到**conf/server.xml** 在**Host**元素中添加子元素。 （重要）
> ```
> <Context path="/upload" docBase="C:\upload"/> 
