<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section class="pt-xs-40">
		<div class="container">
			<div class="row">
				<!-- 왼쪽 메뉴 부분 시작 -->
				<div class="col-sm-4 col-md-3 mb64">
					<%@include file="/WEB-INF/views/mypage/common/mypage_left_nav.jsp" %>
				</div>	
				<!-- 왼쪽 메뉴 끝 -->
				<!-- 오른쪽 메뉴 시작 -->
				<div class="col-sm-8 col-md-8 col-md-offset-1">
					<h5 class="mb4">비밀번호 재 확인</h5>
					<hr class="hr-bold">
					<form class="myInfoCheckForm" action="/myInfoPage" method="post">
						<div class="row">
							<div class="col-sm-6">
								<!--  required="required"-->
								<input type="email" name="memberId" id="email" placeholder="이메일(ID)">
							</div>
							<div class="col-sm-6">
								<input type="password" name="memberPw" id="password" placeholder="비밀번호">
							</div>
							<div class="col-sm-12 mb16">
								<span style="color:red;" class="statusMes"></span><br>
							</div>
							<div class="col-sm-12 mb16">
								<a href="/views/member/search.jsp" style="float:right; margin-bottom:10px; color:#999999; font-size:12px; font-weigtht:300;">비밀번호를 잊어버리셨나요?</a>
							</div>
							<div class="col-sm-12">
								<input class="myInfoCheckBtn" type="submit" name="commit" value="확인" class="hollow">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	<script>
		$(function(){
			$(".myInfoCheckForm").submit(function(e){
				if($("#email").val()!="${sessionScope.member.memberId}" || $("#password").val()!="${sessionScope.member.memberPw}"){
					$(".statusMes").html("아이디 또는 비밀번호가 일치하지 않습니다.");
					return false;				
				}
			});
		});
		
	</script>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>