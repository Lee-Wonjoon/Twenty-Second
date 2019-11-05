<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section style ="margin-top:60px;">
		<div class ="imgContainer" style="height:100px; text-align: center; font-size: 35px; line-height: 80px;">
			Admin Page
		</div>
		<div class ="wrapper">
			<div class="mb64 col-md-3"><%@include file ="/WEB-INF/views/hide/for/admin/adminpage_left_nav.jsp" %></div>
			<div class="thisPageCon">
				왼쪽 버튼 누르셈
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>