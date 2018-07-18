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
            <span>供应商管理页面</span>
        </div>
        <div class="search">
        <form action="searchProvider" method="POST">
            <span>供应商名称：</span>
            <input type="text" placeholder="请输入供应商的名称" name="providerName"/>
            <input type="submit" value="查询"/>
            <a href="providerAdd">添加供应商</a>
         </form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="10%">邮箱</th>
                <th width="20%">操作</th>
            </tr>
            <c:forEach items="${providers}" var="provider" varStatus="status">
            <tr>
                <td>${provider.providerCode}</td>
                <td>${provider.providerName}</td>
                <td>${provider.contact}</td>
                <td>${provider.contactNumber}</td>
                <td>${provider.fax}</td>
                <td>${provider.createDate}</td>
                <td>${provider.email}</td>
                <td>
                    <a href="providerView?id=${provider.id}"><img src="img/read.png" alt="查看" title="查看"/></a>
                    <a href="providerUpdate?id=${provider.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="#" name="${provider.id}" class="removeProvider"><img src="img/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
          </c:forEach>
        </table>

    </div>
</section>
	<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="deleteProviderYes">确定</a>
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