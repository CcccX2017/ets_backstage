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
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加产品分类</title>
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-category-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				分类名称：</label>
			<div class="formControls col-xs-6 col-sm-6">
				<input type="text" class="input-text"  value="" placeholder="" id="categoryName" name="categoryName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				分类级别：</label>
			<div class="formControls col-xs-6 col-sm-6">
				<select class="select" style="height: 32px;" id="level" name="level">
					<option value="1">一级分类</option>
					<option value="2">二级分类</option>
				</select>
			</div>
		</div>
		<div class="row cl" id="child" style="display: none">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				选择父类：</label>
			<div class="formControls col-xs-6 col-sm-6">
				<select class="select" style="height: 32px;" id="parentId" name="parentId">
				</select>
			</div>
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-2">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	//表单验证
	$("#form-category-add").validate({
	onfocusout:function(element){
		$(element).valid();
	},
	rules:{
		categoryName:{
			required:true,
		}, 
		content:{
			required:true,
		},
	},
	messages:{
		title:{
			remote:"已存在该分类名称,请修改",
		}
	},
	onkeyup:false,
	focusCleanup:true,
	success:"valid",
	submitHandler:function(form){
		$.post("category/addCategory.action",$('#form-category-add').serialize(),function(_data){
			if(_data.status == 0){
				layer.msg(_data.msg,{icon: 6,time:800});
				$('#categoryName').val("");
				/* $("#level option:first").prop("selected",'selected');
				$('#child').hide(); */
			}
			else if(_data.status == 10){
				window.location.href="${pageContext.request.contextPath}/login.action";
			}else {
				layer.msg(_data.msg,{icon: 5,time:800});
			}
		});
	}});
	
	$('#level').change(function(){
		if($("#level ").val() == 1){
			$('#child').hide();
		}
		if($("#level ").val() == 2){
			$('#child').show();
			$('#parentId').empty();
			$.ajax({
				type: "GET",
				async: false,
				cache: false,
				dataType: "json",
				url: "category/getChildrenParallelCategory.action",
				success: function(_data){
					if(_data.status == 0){
						$.each(_data.data,function(i,item){
							$("#parentId").append("<option value="+item.categoryId+">"+item.name+"</option>");
						});
					}
				}
			});
		}
	});
});
</script>
</body>
</html>