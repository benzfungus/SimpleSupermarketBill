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
            <span>账单管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>账单编号：</strong><span>${bill.billCode}</span></p>
            <p><strong>商品名称：</strong><span>${bill.goodsName}</span></p>
            <p><strong>商品单价：</strong><span>${bill.price}</span></p>
            <p><strong>商品数量：</strong><span>${bill.quantity}</span></p>
            <p><strong>总金额：</strong><span>${bill.amount}</span></p>
            <p><strong>供应商：</strong><span>${provider.providerName}</span></p>
            
            <p><strong>是否付款：</strong><span><c:if test="${bill.paid eq 0}">未付款</c:if>
            <c:if test="${bill.paid eq 1}">已付款</c:if></span></p>
 			<p><strong>创建时间：</strong><span>${bill.createDate}</span></p>
            <a href="billList">返回</a>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/jsp/part/footer.jsp" %>
</body>
</html>