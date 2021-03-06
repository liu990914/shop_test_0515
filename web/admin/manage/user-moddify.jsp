<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<link rel="stylesheet" href="../../css/bootstrap.min.css"
	type="text/css" />
<script src="../../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="../../css/style.css" type="text/css" />
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="../images/logo.gif" />
		</div>
		<div class="help">
			<a href="../index.html">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="index.html">首页</a></li>
				<li class="current"><a href="user.html">用户</a></li>
				<li><a href="product.html">商品</a></li>
				<li><a href="order.html">订单</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap">管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<em><a href="user-add.html">新增</a></em><a href="user.html">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="product-add.html">新增</a></em><a href="FindUServlet">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="order.html">订单管理</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>修改用户</h2>
			<div class="manage">
				<form action="UpdateUServlet" method="post">
					<input type="hidden" name="uid" value="${user.uid }"/>
					<table class="form">
						<tr>
							<td class="field">用户名：</td>
							<td><input type="text" class="text" name="uname" value="${user.uname }" /></td>
						</tr>
						<tr>
							<td class="field">姓名：</td>
							<td><input type="text" class="text" name="name" value="${user.name }" /></td>
						</tr>
						<tr>
							<td class="field">密码：</td>
							<td><input type="text" class="text" name="pwd" value="${user.pwd }" /></td>
						</tr>
						<tr>
							<td class="field">性别：</td>
							<td><input type="radio" name="sex" value="男"
								checked="checked" />男 <input type="radio" name="sex" value="女" />女</td>
						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td>
								<div class="col-sm-6">
									<input type="date" class="form-control" name="birth" value="${user.birth }">
								</div>
							</td>
						</tr>
						<tr>
							<td class="field">email：</td>
							<td><input type="text" class="text" name="email" value="${user.email }" /></td>
						</tr>
						
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="添加" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 中软国际 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
