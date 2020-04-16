<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twenty Second</title>
</head>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel = "stylesheet" href="/css/bootstrap.css">
<link rel = "stylesheet" href="/css/header/style.css">
<link rel = "stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src ="/js/bootstrap.js"></script>

<link rel = "stylesheet" href="/css/choice/paper.css">
<!--background-repeat: no-repeat;-->
<body>
	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
	<div class = "backgroundPhoto" style = "cursor: pointer; margin-top: 62px;">
		<div class = "titleWrap">
			<div class = "title">
				<p class = "font48">Recommendation Algorithm</p>
				<p class = "font32">by Twenty Second</p>
			</div>
		</div>
	</div>
	<%@ include file = "/WEB-INF/views/common/footer.jsp" %>
	<script>
		$(".backgroundPhoto").on("click", function(){
			location.href = "/goChoice";
		});
	</script>
</body>
</html>