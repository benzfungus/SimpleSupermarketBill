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
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="updateBill" method="POST">
            <input type="hidden" name="id" id="id" value="${bill.id}">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billCode">账单编码：</label>
                    <input type="text" name="billCode" id="billCode" placeholder="${bill.billCode}" value="${bill.billCode}" required/ >
                    <span>*请输入订单编码</span>
                   <span style="color:red">${errorAlertMessageMap.billCode}</span>
                </div>
                <div>
                    <label for="goodsName">商品名称：</label>
                    <input type="text" name="goodsName" id="goodsName" placeholder="${bill.goodsName}" value="${bill.goodsName}"  required/>
                    <span >*请输入商品名称</span>
                    <span style="color:red">${errorAlertMessageMap.goodsName}</span>
                </div>
                <div>
                    <label for="price">商品单价：</label>
                    <input type="text" name="price" id="price" placeholder="${bill.price}" value="${bill.price}" required/>
                    <span>*请输入商品单价请输入大于0的数，小数点后保留2位</span>
                     <span style="color:red">${errorAlertMessageMap.price}</span>
                </div>
                <div>
                    <label for="quantity">商品数量：</label>
                    <input type="number" name="quantity" id="quantity" placeholder="${bill.quantity}" value="${bill.quantity}" required/>
                    <span>*请输入大于0的正自然数</span>
                    <span style="color:red">${errorAlertMessageMap.quantity}</span>
                </div>
                <div>
                    <label for="amount">总金额：</label>
                    <input type="text" name="amount" id="amount" placeholder="${bill.amount}" value="${bill.amount}" required/>
                    <span>*请输入大于0的数，小数点后保留2位</span>
                    <span style="color:red">${errorAlertMessageMap.amount}</span>
                </div>
                <div>
                    <label >供应商：</label>
                    <select name="providerId" >
                        <option value="">--请选择相应的提供商--</option>
                        <c:forEach items="${providers}" var="provider" varStatus="status" >
                        <option value="${provider.id}" ${bill.providerId eq provider.id?"selected":""}>${provider.providerName}</option>
                        </c:forEach>
                    </select>
                    <span>*请选择供应商</span>
                    <span style="color:red">${errorAlertMessageMap.provider}</span>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input type="radio" name="paid" value="0" ${bill.paid eq 0?'checked':''} />未付款
                    <input type="radio" name="paid" value="1" ${bill.paid eq 1?'checked':''} />已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.html">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
                </div>
            </form>
        </div>

    </div>
</section>
<%@ include file="/WEB-INF/jsp/part/footer.jsp" %>
</body>
</html>