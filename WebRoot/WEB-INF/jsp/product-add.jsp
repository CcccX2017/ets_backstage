<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<!--/meta 作为公共模版分离出去-->

<link href="js/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form-product-add" enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 产品类别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a class="btn btn-primary radius" data-title="选择类别"
				data-href="article-add.action" onclick="choose_category('产品类别')"
				href="javascript:;"><i class="Hui-iconfont">&#xe681;</i> 选择类别</a>
				<span><label id="categoryName"></label></span>
				<input type="hidden" id="categoryId" name="categoryId">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 产品标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 产品卖点：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="sellPoint">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 产品价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="price" id="" placeholder="" value="" class="input-text">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 库存数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="num" id="" placeholder="" value="" class="input-text" maxlength="4">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 图片上传：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a class="btn btn-primary radius" data-title="选择图片"
				data-href="" onclick="" id="picFileUpload"
				href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 选择图片</a>
				<input type="hidden" name="image">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 详细内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<textarea style="width: 100%;height: 500px;visibility: hidden;" name="itemDesc"></textarea>
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
<script type="text/javascript" src="js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="js/kindeditor/kindeditor-all-min.js"></script> 
<script type="text/javascript" src="js/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="js/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
var itemAddEditor;
$(function() {
	//创建富文本编辑器
	itemAddEditor = ETS.createEditor("#form-article-add[name=itemDesc]");
	//初始化类目选择和图片上传器
	ETS.init({fun:function(node){
		ETS.changeItemParam(node, "itemAddForm");
	}});
});
	
function showImg() {
	var r = new FileReader();
	f = document.getElementById('file').files[0];
	r.readAsDataURL(f);
	r.onload=function(e) {
	document.getElementById('show').src = this.result;
	document.getElementById('show').width=300;
	document.getElementById('show').height=300;
	};
}

function choose_category(title){
	var index = layer.open({
		type: 2,
		area: ['500px','600px'],
		fix: false, //不固定
		title: title,
		content:"category.action"
	});
}
$(function() {
	//表单验证
	$("#form-product-add").validate({
	onfocusout:function(element){
		$(element).valid();
	},
	rules:{
		title:{
			required:true,
		}, 
		itemDesc:{
			required:true,
		},
		sellPoint:{
			required: true,
		},
		num:{
			required:true,
			number: true
		},
		price:{
			required:true,
			number: true
		}
	},
	onkeyup:false,
	focusCleanup:true,
	success:"valid",
	submitHandler:function(form){
		itemAddEditor.sync();
		$.post("product/productSave.action",$('#form-product-add').serialize(),function(data){
			if(data.status == 0){
				parent.layer.msg(data.msg,{icon: 6,time:2000});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
			else if(data.status == 10){
				window.location.href="${pageContext.request.contextPath}/login.action";
			}else {
				parent.layer.msg(data.msg,{icon: 6,time:1000});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	}});
});
</script>
</body>
</html>