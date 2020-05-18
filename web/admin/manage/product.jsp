<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台管理 - 易买网</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/scripts/function-manage.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>
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
		</ul>
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
				<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.html">订单管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pb.lists }" var="pro">
					<tr>
						<td class="first w4 c">${pro.pid }</td>
						<td class="thumb"><img width="150px" height="200px" src="${pageContext.request.contextPath}/${pro.pimage }" /><a href="../product-view.html" target="_blank">${pro.pname }</a></td>
						<td class="w1 c"><a href="${pageContext.request.contextPath}/findbypid.do?pid=${pro.pid }">修改</a> <a href="${pageContext.request.contextPath}/deleteproductbg.do?pid=${pro.pid }">删除</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<div class="clear"></div>
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
			<c:choose>
				<c:when test="${pb.nowpage eq 1 }">
					<li class="disabled"><a  aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pb.url}&nowpage=${pb.nowpage-1}" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="1" end="${pb.totalpage}" var="i">
				<c:choose>
					<c:when test="${i eq pb.nowpage }">
						<li class="active"><a href="${pb.url}&nowpage=${i}">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pb.url}&nowpage=${i}">${i }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pb.nowpage eq pb.totalpage }">
					<li class="disabled"><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:when>
				<c:otherwise>

					<li><a href="${pb.url}&nowpage=${pb.nowpage+1}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2010 中软国际 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
    