<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData =request.getAttribute("pp") != null ? (String)request.getAttribute("pp") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台管理 - 易买网</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/scripts/function-manage.js"></script>
	<link rel="stylesheet" href="editor/default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/manage/editor/prettify.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/manage/editor/default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/manage/editor/prettify.css" />
	<script charset="UTF-8" src="${pageContext.request.contextPath}/admin/manage/editor/kindeditor.js"></script>
	<script charset="UTF-8" src="${pageContext.request.contextPath}/admin/manage/editor/zh_CN.js"></script>
	<script charset="UTF-8" src="${pageContext.request.contextPath}/admin/manage/editor/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="pdesc"]', {
				cssPath : 'editor/prettify.css',
				uploadJson : 'upload_json.jsp',
				fileManagerJson : 'file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<%!
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
%>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li class="current"><a href="product.html">商品</a></li>
			<li><a href="order.html">订单</a></li>
			]		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.html">新增</a></em><a href="user.html">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="product-add.html">新增</a></em><a href="FindServlet">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.html">订单管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>添加商品</h2>
		<div class="manage">
			<form action="${pageContext.request.contextPath}/AddProductBgServlet.do" method="post"  enctype="multipart/form-data">
				<table class="form">
					<tr>

						<td colspan="2">商品名称：<input type="text" class="text" name="pname" value="铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机" /></td>
					</tr>
					<tr>
						<td colspan="2">
							所属分类：<select name="cid">
							<option value="1">手机数码</option>
							<option value="2">电脑办公</option>
							<option value="3">家具家居</option>
							<option value="4">鞋靴箱包</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">商品图片：<input type="file" class="text" name="pimage" /></td>
					</tr>
					<tr>
						<td colspan="2">市场价格：<input type="text" class="text tiny" name="market_price" /> 元</td>
					</tr>
					<tr>
						<td colspan="2">商品价格：<input type="text" class="text tiny" name="shop_price" /> 元</td>
					</tr>
					<tr>
						<td colspan="2" >详细描述：</td>
					</tr>
					<tr>
						<td ><textarea name="pdesc" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 中软国际 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
    