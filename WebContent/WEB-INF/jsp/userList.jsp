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
</head>
<body>
<%@ include file="/WEB-INF/jsp/part/header.jsp" %>
	<%@ include file="/WEB-INF/jsp/part/time.jsp" %>
	 <section class="publicMian ">
	<%@ include file="/WEB-INF/jsp/part/left.jsp" %>
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
            <form action="searchUser" method="POST">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名" name="username"/>
                <input type="submit" value="查询"/>
                <a href="userAdd">添加用户</a>
                </form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">邮箱</th>
                    <th width="10%">用户类型</th>
                    <th width="20%">操作</th>
                </tr>
                <c:forEach items="${users}" var="user" varStatus="status">
                <tr>
                    <td id="id">${status.index+1}</td>
                    <td>${user.username}</td>
                    <td>
                    	<c:if test="${user.sex == 1}">男</c:if>
                    	<c:if test="${user.sex == 0}">女</c:if>
                    </td>
                    <td>${user.age}</td>
                    <td>${user.mobilePhoneNumber}</td>
                    <td>${user.email}</td>
                    <td>
                    	<c:if test="${user.userType == 0}">管理员</c:if>
                    	<c:if test="${user.userType == 1}">经理</c:if>
                    	<c:if test="${user.userType == 2}">普通用户</c:if>
                    <td>
                        <a href="userView?id=${user.id}"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="userUpdate?id=${user.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" name="${user.id}" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                </c:forEach>
            </table>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="deleteUserYes">确定</a>
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