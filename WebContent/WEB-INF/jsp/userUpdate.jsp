<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="updateUser">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="id" id="id" value="${user.id}" />
                <div>
                    <label for="username">用户名称：</label>
                    <input type="text" name="username" id="username" placeholder="${user.username}" value="${user.username}" required/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>

                    <select name="sex">
                        <option value="1"selected>男</option>
                        <option value="0">女</option>
                    </select>
                </div>
                <div>
                    <label for="birthOfDate">出生日期：</label>
                    <input type="date" name="birthOfDate" id="birthOfDate" placeholder="${user.birthOfDate}" value="${user.birthOfDate}" required/>
                    <span >*</span>
                </div>
                <div>
                    <label for="mobilePhoneNumber">用户电话：</label>
                    <input type="text" name="mobilePhoneNumber" id="mobilePhoneNumber" placeholder="${user.mobilePhoneNumber}" value="${user.mobilePhoneNumber}" required/>
                    <span >*</span>
                </div>
                <div>
                    <label for="email">用户邮箱：</label>
                    <input type="text" name="email" id="email" placeholder="${user.email}" value="${user.email}" required/>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                    <input type="text" name="address" id="address" placeholder="${user.address}" value="${user.address}" required/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userType" value="0" ${user.userType eq 0?'checked':''}/>管理员
                    <input type="radio" name="userType" value="1" ${user.userType eq 1?'checked':''}/>经理
                    <input type="radio" name="userType" value="2" ${user.userType eq 2?'checked':''}/>普通用户

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
    <%@ include file="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>