<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<head>
<title>登录页面 - 易卖二手网后台管理系统</title>
<script src="js/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/layer/2.4/layer.js"></script>
<LINK rel="Bookmark" href="/favicon.ico">
<LINK rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/min.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link rel="stylesheet" type="text/css" href="css/iconfont.css" />
<link rel="stylesheet" type="text/css" href="css/icheck.css" />
<link rel="stylesheet" type="text/css" href="skin/default/skin.css"
	id="skin" />
<style>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #008ead;
	width: 100%;
	height: 400px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.u_logo {
	background: url("images/username.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 13px;
	left: 65px;
}

.p_logo {
	background: url("images/password.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 12px;
	left: 65px;
}

a {
	text-decoration: none;
}

.tou {
	background: url("images/tou.png") no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 140px;
}

.left_hand {
	background: url("images/left_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background: url("images/right_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 100px;
}

.initial_right_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -112px;
}

.left_handing {
	background: url("images/left-handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background: url("images/right_handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}
</style>

<script type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});
</script>

<script type="text/javascript">
	/* function checkFrm() {
		if (frm.username.value == "" && frm.password.value == "") {
			//alert("请输入用户名！");
			parent.layer.msg('请输入用户名和密码',{icon: 5,time:1000});
			return;
		}
		else if (frm.password.value == "") {
			parent.layer.msg('请输入密码',{icon: 5,time:1000});
			return;
		}else if(frm.username.value == ""){
			parent.layer.msg('请输入用户名',{icon: 5,time:1000});
			return;
		}
		$('#btn_submit').click(function(){
			$.post("manage/login.aciton",$('#frm').serialize(),function(data){
				if(data.status == 0){
					window.location.href="/admin";
				}
			});
		})
	} */
</script>
</head>
<body>
	<div class="top_div"></div>
	<div
		style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 300px; text-align: center;">
		<DIV style="width: 165px; height: 96px; position: absolute;">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<p style="font-size:31px; padding:20px;">易卖二手网后台管理系统</p>
		<form class="form form-horizontal" action="" method="post" name="form-login" id="form-login" onsubmit="return false;">
			<p style="padding: 30px -10px 10px; position: relative;">
				<span class="u_logo"></span> <input class="ipt" type="text"
					id="ad_username" name="ad_username" placeholder="用户名" value="">
			</p>
			<P style="position: relative;">
				<SPAN class="p_logo"></SPAN> <INPUT class="ipt" id="ad_password" maxlength="16"
					type="password" name="ad_password" placeholder="密码" value="">
			</P>
			<div
				style="height: 50px; line-height: 20px; margin-top: 15px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<span style="float: right;margin-right: 10px"> <input
							class="btn btn-primary radius" type="submit"
							value="&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;"
							id="btn_submit" name="btn_submit">&nbsp; <input
							class="btn btn-primary radius" type="reset"
							value="&nbsp;&nbsp;重&nbsp;&nbsp;置&nbsp;&nbsp;">
						</span>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div style="text-align:center;"></div>
<script type="text/javascript" src="js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	$("#form-login").validate({
	onfocusout:function(element){
		$(element).valid();
	},
	rules:{
		ad_username:{
			required:true,
		}, 
		ad_password:{
			required:true,
		},
	},
	messages:{
		ad_username:{
			required:"必填",
		}, 
		ad_password:{
			required:"必填",
		},
	},
	onkeyup:false,
	focusCleanup:false,
	success:"valid",
	submitHandler:function(form){
		$.post("manage/login.action",$('#form-login').serialize(),function(data){
			if(data.status == 0){
				//alert(data.msg);
				window.location.href="${pageContext.request.contextPath}/admin.action";
			}
			else if(data.msg == "密码错误"){
				layer.msg(data.msg,{icon: 5,time:1000});
				$("#ad_password")[0].focus()
			}else{
				layer.msg(data.msg,{icon: 5,time:1000});
				$("#ad_username")[0].focus()
			}
		})
	}});
});
</script>
</body>
</html>
