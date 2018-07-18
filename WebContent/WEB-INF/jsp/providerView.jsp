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
</head>
<body>
<%@ include file="/WEB-INF/jsp/part/header.jsp" %>
	<%@ include file="/WEB-INF/jsp/part/time.jsp" %>
	 <section class="publicMian ">
	<%@ include file="/WEB-INF/jsp/part/left.jsp" %>
	 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>供应商编码：</strong><span>${provider.providerCode}</span></p>
            <p><strong>供应商名称：</strong><span>${provider.providerName}</span></p>
            <p><strong>联系人：</strong><span>${provider.contact}</span></p>
            <p><strong>联系电话：</strong><span>${provider.contactNumber}</span></p>
            <p><strong>传真：</strong><span>${provider.fax}</span></p>
            <p><strong>邮箱：</strong><span>${provider.email}</span></p>
            <p><strong>创建时间：</strong><span>${provider.createDate}</span></p>
            <p><strong>描述：</strong><span>${provider.description}</span></p>

            <a href="providerList">返回</a>
        </div>
    </div>
</section>
    <%@ include file="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>