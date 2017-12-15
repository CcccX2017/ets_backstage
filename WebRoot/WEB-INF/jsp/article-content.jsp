<%@ page import="com.ets.common.DateConverter"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="js/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title></title>
</head>
<body>
<div class="text-c" style="text-align: left;padding: 10px 20px 20px 20px">
	<h4><b>${announcement.title}</b></h4>
</div>
<div class="text-c" style="text-align: left;">
	<span style="padding-left: 20px">发布人：${announcement.admin.adUsername}</span>
	<span style="padding-left: 10px">创建时间：<fmt:formatDate value="${announcement.createtime}" 
	pattern="yyyy-MM-dd  HH:mm"/></span>
	<span style="padding-left: 10px">更新时间：<fmt:formatDate value="${announcement.updatetime}" 
	pattern="yyyy-MM-dd  HH:mm"/></span>
</div>
<div class="text-c" style="text-align: left;padding: 30px 20px 20px 20px">
	<span>${announcement.content}</span>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="js/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="js/laypage/1.2/laypage.js"></script>

<script type="text/javascript">
</script>
</body>
</html>