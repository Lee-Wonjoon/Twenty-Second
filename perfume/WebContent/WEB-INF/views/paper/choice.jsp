<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twenty Second</title>
</head>
<link rel = "stylesheet" href="/css/choice/paper.css">
<body>
	<!--background-repeat: no-repeat;-->
	<hr style = "margin-top: 1px; margin-bottom: 1px;">
	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
	<div class = "backgroundPhoto" style = "margin:-2px; ">
		<div class = "titleWrap">
			<div class = "title">
				<p class = "font42">두번째 향수 추천 서비스</p>
				<p style = "margin-bottom: 20px;">by 두번째 스무살</p>
				<span style = "border:black; text-align: left; line-height: 15px; width:350px; border:1px solid white; display: inline-block; padding: 15px;">
				01.향기 추천 알고리즘으로 향수를 추천받아보세요.<br><br>
				02. 추천받은 향수제품을 구매할 수 있습니다.
				</span><br><br>
				<p>질문) 향수에 대해 잘 아시나요?</p>
				<div class = "choiceButton white" style = "border-right : 1px solid #f3f3f3" onclick = "location.href = '/goKnowStep'">네</div><div style = "border-left: 1px solid #f3f3f3" class = "choiceButton white" onclick = "location.href = '/goUnknowStep'">아니요</div>
			</div>
			
		</div>
	</div>
	<%@ include file = "/WEB-INF/views/common/footer.jsp" %>
</body>
</html>