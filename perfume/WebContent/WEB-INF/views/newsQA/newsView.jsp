<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div>
			<ul class="notice_list">
				<c:forEach items="${pd.list}" var="list" varStatus="i">
					<li class="onclickClass">
						<span style="width:8%; height:40px; line-height: 40px;">${list.noticeNo}</span>
						<span style="width:54%; height:40px; line-height: 40px;">${list.noticeTitle}</span>
						<span style="width:20%; height:40px; line-height: 40px;">${list.noticeDate}</span>
						<span style="width:14%; height:40px; line-height: 40px;">${list.noticeWriter}</span>
					</li>
				</c:forEach>
			</ul>
			<
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>