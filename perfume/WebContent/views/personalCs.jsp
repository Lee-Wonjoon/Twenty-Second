<%@page import="fp.notice.models.vo.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%
    	PageData pd = (PageData)request.getAttribute("pd");
    %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
	box-sizing: border-box;
}

.tap>div {
	float: left;
	width: 15%;
	/* border: 1px solid gray; */
	height: 60px;
	text-align: center;
	line-height: 60px;
	display: inline-block;
	font-size: 20px;
}

/* .wrapper>.1_1_con, .wrapper>.notice_con{
		display:none;
	} */
/* .wrapper *{
		border: 1px solid gray;
	} */
.wrapper>.FAQ_con {
	float: none;
}

.cs {
	color: black;
}

.notice, .FAQ {
	color: gray;
}

.wrapper>.tap {
	border-bottom: 1px solid black;
}

.tap>span {
	width: 1px;
	height: 40px;
	background-color: gray;
	line-height: 40px;
	float: left;
	margin-top: 10px;
}

.notice_list {
	margin-left: 0px;
	margin-bottom: 50px;
	padding: 2%;
}

.notice_list>li {
	height: 44px;
	border-bottom: 1px solid #ccc;
	display: block;
}

.notice_list>li>span {
	display: inline-block;
}
/* .notice_con span:nth-of-type(0){
		width:8%;
	}
	.notice_con span:nth-of-type(1){
		width:54%;
	}
	.notice_con span:nth-of-type(2){
		width:20%;
	}
	.notice_con span:nth-of-type(3){
		width:14%;
	} */
.notice_view>p, .notice_view>pre {
	margin-bottom: 20px;
	line-height: 24px;
	font-size: 14px;
	font-family: "Roboto", sans-serif;
	font-weight: normal;
	color: #888888;
}

#pageNavi {
	text-align: center;
	width: 80%;
	margin: 0 auto;
	margin-bottom: 50px;
}

#pageNavi>* {
	margin: 10px;
	padding: 0.375rem 0.75rem;
}

.selectPage {
	font-size: 18px;
	color: #888888;
}

.btn {
	font-color: #888888;
	font-family: "Roboto", sans-serif;
	font-size: 15px;
}

.notice_intro {
	width: 50%;
	float: left;
}

.postQuestion {
	width: 50%;
	float: left;
}

.postQuestion>button {
	border: 1px solid #ccc;
	border-radius: 10px;
	background-color: white;
	color: #888888;
	height: 50px;
	width: 150px;
	margin: 20px;
}

.postQuestion {
	height: 98px;
	width: 50%;
	text-align: center;
}

.postDiv {
	float: none;
	margin-bottom: 100px;
}

.postBtn {
	height: 40px;
	background-color: white;
	border: 1px solid #ccc;
	color: #888888;
	text-align: center;
	line-height: 20px;
	cursor: pointer;
	padding:10px;
	border-radius: 10px;
}
</style>
<title>1:1 Question</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<section style="margin-top:80px;">
	<div class="imgDivCs" style="margin-top:-40px;"><img src="/headerimg/tempppp.png" style="width:122%; height:90%;"></div>
	<div class="wrapper"
		style="margin: 0 auto; width: 50%; /* border:1px solid gray;  */ min-width: 600px;">
		<div class="tap" style="height: 60px;">
			<div class="FAQ" onclick="location.href='/views/faq.jsp'"
				style="cursor: pointer;">FAQ</div>
			<div class="cs">1:1문의</div>
			<div class="notice" onclick="location.href='/news'" style="cursor: pointer;">NOTICE</div>
		</div>
		<div class="notice_con">
			<div style="height:98px;">
				<div class="notice_intro">
					<p style="margin-top: 10px;">
						TwentySecond는 고객의 소리를 듣습니다.<br>- 궁금한 사항을 남겨주시면, 신속하게 답변을 드리도록
						하겠습니다.
					</p>
				</div>
				<div class="postQuestion">
					<button type="button">문의 작성하기</button>
				</div>
			</div>
			<div class="csContent">
				<ul class="notice_list">
<%-- 				<c:when test="${empty list[0]}">
 --%>					<c:forEach items="${list}" var="ques" varStatus="i">
						<li class="onclickClass" style="color: #333333;"><span
							style="width: 8%; height: 40px; line-height: 40px; cursor: pointer;">${size - i.index}</span>
							<span
							style="width: 54%; height: 40px; line-height: 40px; cursor: pointer;">${ques.questionTitle}</span>
							<span
							style="width: 20%; height: 40px; line-height: 40px; text-align: center;">${ques.questionDate}</span>
							<span
							style="width: 14%; height: 40px; line-height: 40px; text-align: right;">${ques.questionWriter}</span>
						</li>
						<div class="notice_view" style="display: none;">
							<pre><c:if test="${!empty ques.filepath }"><img src="/upload/question/${ques.filepath }"></c:if><br>${ques.questionContent}</pre>
							<br>
							<div style="margin: 0 auto">
								<button
									style="border: 1px solid #ccc; border-radius: 10px; background-color: white; color: #888888; margin-left: 42%;"
									class="returnFunc">돌아가기</button>
							</div>
						</div>
					</c:forEach>
					</ul>
				<div id="pageNavi">${pd.pageNavi }</div>
			</div>
			<div class="postDiv" style="display:none;">
				<form action="/writeQuestion" method="post" enctype="multipart/form-data">
					<br>
					<input type="hidden" name= "questionWriter" value="${sessionScope.member.memberNickname }">
					<input placeholder="문의 제목" type="text" name="questionTitle" style="width: 100%; padding:10px;"><br>
					<br>
					<label for="fileInput" class="postBtn" style="height:40px; line-height: 20px;" >첨부파일</label> <div></div>
					<input id="fileInput" type="file" style="display: none;" name="filename">  
					<textarea placeholder="문의 내용" rows="4" name="questionContent" style="width: 100%; padding:10px; min-height: 150px; max-height: 150px;"></textarea>
					<br>
					<button type="submit" class="postBtn" style="float: right; margin-right: 10px;">등록하기</button>
					<button type="button" class="postBtn returnBtn" style="float: right; margin-right: 10px;">돌아가기</button>
				</form>
			</div>
		</div>
	</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$(".onclickClass").click(function() {
			$(".notice_list").children("li").toggle();
			$(this).toggle();
			$(this).next().fadeToggle();
			$("#pageNavi").toggle();
		});
		$(".returnFunc").click(function() {
			$(".notice_list").children("li").toggle();
			$(this).parent().parent().toggle();
			$("#pageNavi").toggle();
		});
		$(".postQuestion").click(function() {
			if(${empty sessionScope.member}){
				window.location.href = "/views/member/login.jsp";
			}else{
				$(".csContent").toggle();
				$(".postDiv").toggle();				
			}
		});
		$(".returnBtn").click(function() {
			$(".csContent").toggle();
			$(".postDiv").toggle();
		});
		$("#fileInput").change(function(){
			$(this).prev().html($(this).val());
		});
	</script>
</body>
</html>
