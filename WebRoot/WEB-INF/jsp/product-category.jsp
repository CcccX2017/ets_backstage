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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品分类 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table">
	<tr>
		<td width="200" class="va-t"><ul id="treeDemo" class="ztree"></ul></td>
		<td class="va-t"><iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=390px SRC="product-category-add.action"></iframe></td>
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
	edit: {
		enable: true,
		editNameSelectAll: true,
		showRemoveBtn: true,
		showRenameBtn: true
	},
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
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
		/* beforeClick: function(treeId, treeNode) {
			alert(treeNode.categoryId);
		}, */
		beforeRemove:beforeRemove,
		beforeEditName: beforeEditName,
		beforeRename:beforeRename,
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


function beforeEditName(treeId, treeNode){
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		setTimeout(function() {
			if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {
				setTimeout(function() {
					zTree.editName(treeNode);
				}, 0);
			}
	}, 0);
	return false;
}

function beforeRemove(treeId, treeNode){
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.selectNode(treeNode);
	var flag =  confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	if(flag){
		$.ajax({
			type: "POST",
			async: false,
			url: "category/delectCategoryById.action",
			data: {
				categoryId : treeNode.categoryId,
			},
			success : function(_data){
				if(_data.status == 0){
					isDeled = true;
					layer.msg(_data.msg,{icon: 6,time:1000});
				}else {
					isDeled = false;
					layer.msg(_data.msg,{icon: 5,time:1000});
				}
			}
		});
	}else {
		return false;
	}
}

function beforeRename(treeId, treeNode, newName, isCancel) {
	if (newName.length == 0) {
		setTimeout(function() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.cancelEditName();
			alert("节点名称不能为空.");
		}, 0);
		return false;
	}else{
		var isDeled = false;
		$.ajax({
			type: "POST",
			async: false,
			url: "category/setCategoryName.action",
			data: {
				categoryId : treeNode.categoryId,
				categoryName : newName
			},
			success : function(_data){
				if(_data.status == 0){
					isDeled = true;
					layer.msg(_data.msg,{icon: 6,time:1000});
				}else {
					isDeled = false;
					layer.msg(_data.msg,{icon: 5,time:1000});
				}
			}
		});
		return isDeled;
	}
}

$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	//demoIframe.on("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
});
</script>
</body>
</html>