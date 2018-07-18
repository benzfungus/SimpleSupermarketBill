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
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${user.id}</span></p>
            <p><strong>用户名称：</strong><span>${user.username}</span></p>
            <p><strong>用户性别：</strong><span><c:if test="${user.sex == 1}">男</c:if>
                    							<c:if test="${user.sex == 0}">女</c:if></span></p>
            <p><strong>用户年龄：</strong><span>${user.age}</span></p>
            <p><strong>出生日期：</strong><span>${user.birthOfDate}</span></p>
            <p><strong>用户电话：</strong><span>${user.mobilePhoneNumber}</span></p>
            <p><strong>用户地址：</strong><span>${user.address}</span></p>
            <p><strong>用户邮箱：</strong><span>${user.email}</span></p>
            <p><strong>用户类别：</strong><span><c:if test="${user.userType == 0}">管理员</c:if>
                    	<c:if test="${user.userType == 1}">经理</c:if>
                    	<c:if test="${user.userType == 2}">普通用户</c:if></span></p>

            <a href="userList">返回</a>
        </div>
    </div>
</section>
   <%@ include file="/WEB-INF/jsp/part/footer.jsp" %>
</body>
</html>