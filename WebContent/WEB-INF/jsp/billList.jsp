<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>超市账单管理系统</title>
	    <link rel="stylesheet" href="css/public.css"/>
	    <link rel="stylesheet" href="css/style.css"/>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/part/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/part/time.jsp" %>
		<section class="publicMian ">
		<%@ include file="/WEB-INF/jsp/part/left.jsp" %>
			<div class="right">
	        	<div class="location">
	                <strong>你现在所在的位置是:</strong>
	                <span>账单管理页面</span>
	            </div>
		        <div class="search">
		            <form action="searchBill" method="POST">
		                <span>商品名称：</span>
		                <input type="text" placeholder="请输入商品的名称"/>
		                <span>供应商：</span>
		                <select name="tigong" >
		                    <option value="">--请选择--</option>
		                    <c:forEach items="${providers}" var="provider" varStatus="status">
		                    <option value="${status.index}">${provider.providerName}</option>
		                    </c:forEach>
		                </select>
		                <span>是否付款：</span>
		                <select name="paid">
		                    <option value="">--请选择--</option>
		                    <option value="1">已付款</option>
		                    <option value="0">未付款</option>
		                </select>
		                <input type="submit" value="查询"/>
		                <a href="billAdd">添加订单</a>
		        	</form>
		        </div>
		    <!--账单表格 样式和供应商公用-->
		            <table class="providerTable" cellpadding="0" cellspacing="0">
		                <tr class="firstTr">
		                    <th width="10%">账单编号</th>
		                    <th width="10%">商品名称</th>
		                    <th width="10%">商品单价</th>
		                    <th width="10%">商品数量</th>
		                    <th width="10%">账单金额</th>
		                    <th width="10%">供应商</th>
		                    <th width="10%">是否付款</th>
		                    <th width="10%">创建时间</th>
		                    <th width="20%">操作</th>
		                </tr>
		                <c:forEach items="${bills}" var="bill" varStatus="status">
		                <c:forEach items="${providers}" var="provider" varStatus="pstatus">
		                <c:if test="${bill.providerId eq provider.id}">
		                <tr>
		                    <td>${bill.billCode}</td>
		                    <td>${bill.goodsName}</td>
		                    <td>${bill.price}</td>
		                    <td>${bill.quantity}</td>
		                    <td>${bill.amount}</td>
		                    <td>${provider.providerName}</td>
		                    <td>
		                    <c:if test="${bill.paid == 0}">未付款</c:if>
		                    <c:if test="${bill.paid == 1}">已付款</c:if></td>
		                    <td>${bill.createDate}</td>
		                    <td>
		                        <a href="billView?id=${bill.id}"><img src="img/read.png" alt="查看" title="查看"/></a>
		                        <a href="billUpdate?id=${bill.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
		                        <a href="#" name="${bill.id}" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a>
		                    </td>
		                </tr>
		                </c:if>
		                </c:forEach>
		                </c:forEach>
		            </table>
		        </div>
	    </section>
	    <!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>
	<div class="remove" id="removeBi">
	    <div class="removerChid">
	        <h2>提示</h2>
	        <div class="removeMain">
	            <p>你确定要删除该订单吗？</p>
	            <a href="#" id="deleteBillYes">确定</a>
	            <a href="#" id="no">取消</a>
	        </div>
	    </div>
	</div>
	
	<footer class="footer">
	</footer>
	
	
	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>
	    
	</body>
</html>