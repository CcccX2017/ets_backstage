<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="js/zTree/v3/css/metroStyle/metroStyle.css" type="text/css">
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>产品分类</title>
</head>
<body>
<input type="hidden" id="mainIframeName" name="mainIframeName" value="${parentName}">
<table class="table">
	<tr>
		<td width="200" class="va-t"><ul id="treeDemo" class="ztree"></ul></td>
		<td class="va-t" style="padding-top: 400px">
			<input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;确定&nbsp;&nbsp;" id="btn_ok">
		</td>
	</tr>
</table>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript" src="js/zTree/v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="js/zTree/v3/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="js/zTree/v3/js/jquery.ztree.exedit.js"></script>
<script type="text/javascript">
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	check: {
		enable: true,
		chkStyle: "radio",
		radioType: "all"
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "categoryId",
			pIdKey: "parentId",
			rootPId: ""
		}
	},
	callback: {
		onCheck:onCheck
	}
};

var zNodes;
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

$(function(){
	$.ajax({
		type: "GET",
		async: false,
		cache: false,
		dataType: "json",
		url: "category/getCategory.action",
		success: function(_data){
			if(_data.status == 0){
				zNodes = _data.data;
			}
		}
	});
});

$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
});

var name;
var categoryId;
var parentId;
function onCheck(e, treeId, treeNode) {
	name = treeNode.name;
	categoryId = treeNode.categoryId;
	parentId = treeNode.parentId;
}

$('#btn_ok').click(function(){
	if(name == null || categoryId == null){
		alert("请选择类别");
	}else if(parentId == 0 && name != "其他类别"){
		alert("当前节点为父节点,且该节点下有子节点,请选择子节点");
	}
	else{
		parent.$('#categoryName').html(name);
		parent.$('#categoryId').val(categoryId);
		parent.layer.closeAll();
	}
});

</script>
</body>
</html>