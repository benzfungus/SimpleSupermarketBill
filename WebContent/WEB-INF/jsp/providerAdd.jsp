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
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="insertProvider" method="POST">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerCode">供应商编码：</label>
                    <input type="text" name="providerCode" id="providerCode" required/>
                    <span>*请输入供应商编码</span>
                    <span style="color:red">${errorAlertMessageMap.providerCode}</span>
                </div>
                <div>
                    <label for="providerName">供应商名称：</label>
                    <input type="text" name="providerName" id="providerName" required/>
                    <span >*请输入供应商名称</span>
                    <span style="color:red">${errorAlertMessageMap.providerName}</span>
                </div>
                <div>
                    <label for="contact">联系人：</label>
                    <input type="text" name="contact" id="contact" required/>
                    <span>*请输入联系人</span>
                    <span style="color:red">${errorAlertMessageMap.contact}</span>
                </div>
                <div>
                    <label for="contactNumber">联系电话：</label>
                    <input type="text" name="contactNumber" id="contactNumber" required/>
                    <span>*请输入联系电话</span>
                    <span style="color:red">${errorAlertMessageMap.contactNumber}</span>
                </div>
                <div>
                    <label for="address">联系地址：</label>
                    <input type="text" name="address" id="address"/>
                    <span></span>
                </div>
                <div>
                    <label for="fax">传真：</label>
                    <input type="text" name="fax" id="fax"/>
                    <span></span>
                </div>
                <div>
                    <label for="email">邮箱：</label>
                    <input type="email" name="email" id="email" required/>
                    <span>*</span>
                    <span style="color:red">${errorAlertMessageMap.email}</span>
                </div>
                <div>
                    <label for="description">描述：</label>
                    <input type="text" name="description" id="description"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.html">返回</a>-->
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