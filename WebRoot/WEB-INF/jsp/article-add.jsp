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

<title>新增公告 - 公告管理</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" name="form-article-add" id="form-article-add" action="" method="post">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>公告标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>公告内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<textarea style="width: 100%;height: 500px;visibility: hidden;" name="content"></textarea> 
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="btn_submit" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="js/kindeditor/kindeditor-all-min.js"></script> 
<script type="text/javascript" src="js/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	var itemAddEditor;
	$(function() {
		//创建富文本编辑器
		itemAddEditor = ETS.createEditor("#form-article-add[name=content]");
	});
</script>
<script type="text/javascript">
$(function() {
	//表单验证
	$("#form-article-add").validate({
	onfocusout:function(element){
		$(element).valid();
	},
	rules:{
		title:{
			required:true,
			remote: {
				url:"announcement/checkTitle.action",
				type:"post",
				data:{
					title : function(){
						return $('#title').val();
					}
				},
				dataFilter:function(data,type){
					var d = $.parseJSON(data);
					if(d.status == 0){
						return true;
					}else{
						return false;
					}
				},
			},
		}, 
		content:{
			required:true,
		},
	},
	messages:{
		title:{
			remote:"已存在该公告标题,请修改",
		}
	},
	onkeyup:false,
	focusCleanup:true,
	success:"valid",
	submitHandler:function(form){
		itemAddEditor.sync();
		$.post("announcement/addAnnouncement.action",$('#form-article-add').serialize(),function(data){
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
function removeIframe(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>