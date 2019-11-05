<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<form action="/insertNoticeSubmit" method="post" enctype="multipart/form-data">
					<div style="color:black;">
						공지제목 : <input type="text" name="noticeTitle">
					</div>
					<hr>
					<div>
						<input type="file" name="filename">
					</div>
					<hr>
					<div style="color:black;">
						내용<br>
						<textarea name="noticeContent" style="max-width:500px; max-height: 150px; min-width: 500px; min-height: 150px;"></textarea>
					</div>
					<div>
						<button type="submit">전송</button><button type="reset">초기화</button>
					</div>
				</form>
			</div>
		</div>
	<script>
	</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>