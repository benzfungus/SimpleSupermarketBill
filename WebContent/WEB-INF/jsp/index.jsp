<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head lang="en">
	    <title>超市账单管理系统</title>
	    <link rel="stylesheet" href="css/public.css"/>
	    <link rel="stylesheet" href="css/style.css"/>
	    <script src="js/time.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/part/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/part/time.jsp" %>
		<section class="publicMian">
			<%@ include file="/WEB-INF/jsp/part/left.jsp" %>
			<div class="right">
		        <img class="wColck" src="img/clock.jpg" alt=""/>
		        <div class="wFont">
		            <h2>${sessionScope.user.username}</h2>
		            <p>欢迎来到超市账单管理系统!</p>
					<span id="hours"></span>
	        	</div>
	    	</div>
		</section>
<%@ include file="/WEB-INF/jsp/part/footer.jsp" %>
</body>
</html>