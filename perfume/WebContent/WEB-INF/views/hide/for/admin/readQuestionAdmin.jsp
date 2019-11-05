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
			<div class="thisPageCon" style="padding:50px;">
				<div style="color:black; font-size: 15px;">
					글번호 : ${question.questionNo }
				</div>
				<div style="color:black; font-size: 15px;">
					제목 : ${question.questionTitle }
				</div>
				<hr>
				<div>
					<!-- 있다면 사진도 같이 넣어주는 것 해야함 -->
					<pre style="font-size: 15px; font-family: 'Noto Sans KR', sans-serif;"><c:if test="${!empty question.filepath }"><img src="/upload/question/${question.filepath }" style="max-width: 400px;"></c:if><br>${question.questionContent }</pre>
				</div>
				<hr>
				<div>
						<!-- 파일 첨부 기능 추가해야함 -->
						<!-- enctype도 지정해야함. -->
					<c:choose>
						<c:when test="${not empty answer.questionNo }">
						<div style="padding-left:70px;">
							<div style="color:black;">
								답변 : ${answer.questionTitle }
							</div>
							<hr>
							<div>
								<pre style="font-size: 15px; font-family: 'Noto Sans KR', sans-serif;"><c:if test="${!empty answer.filepath }"><img src="/upload/answer/${answer.filepath }" style="max-width: 400px;"></c:if><br>${answer.questionContent }</pre>
							</div>
							<hr>
						</div>
						</c:when>
						<c:when test="${empty answer.questionNo }">
						<button type="button" class="answerQuestionAdmin">답장하기</button>
						<form action="/answerQuestionAdmin" method="post" style="display:none;" class="adminAnswerForm"  enctype="multipart/form-data">
							<input type="hidden" name="questionNo" value=${question.questionNo }>
							<img style="display:none;" src="" id="imgShow">
							<textarea name="questionContent" rows="5" style="width: 80%; max-height: 126px;"></textarea>
							<br>
							<input type="file" name="filename" onchange="imgChange(this);"><br> 
							<button type="submit">전송하기</button><button type="reset" class="reset">취소</button>
						</form>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	<script>
		function imgChange(f){
			$(".status").val("change");
			if(f.files.length != 0 && f.files[0]!=0){
				var reader = new FileReader();
				reader.readAsDataURL(f.files[0]) // 매개변수로 지정한 파일의 경로
				reader.onload = function(e){ // 파일 경로가 다 읽어지고 나면
					$("#imgShow").attr('src',e.target.result); // 읽어온 경로값을 src속성에 넣어줌 
					$("#imgShow").attr('display','block');
				}
			}
		}
		$(".answerQuestionAdmin").click(function(){
			$(this).hide();
			$(".adminAnswerForm").show();
		});
		$(".reset").click(function(){
			$(".answerQuestionAdmin").show();
			$(".adminAnswerForm").hide();
		});
	</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>