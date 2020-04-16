<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
</head>
<body>
<style>
	.div-25{
		width:25%;
		float: left;
		margin-top:20px;
		margin-bottom:10px;
		text-align: center;
	}
	.div-25 p{
		font-size: 10px;
		color:#585858;
		text-align: left;
	}
	.div-img{
		width:80%;
		height: 130px;
		position: relative;
		margin-bottom:10px;
	}
	.recommendImg{
		position: absolute;
		left:20px;
	}
	.clear-left{
		clear: left;
	}
	.dateNo{
		color:#585858;
		margin-left:10px;
		font-size: 12px;
		font-style: italic;
	}
</style>
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
					<h5 class="mb4">추천 향수 목록 (날짜를 선택하세요.)</h5>
					<hr class="hr-bold">
					<div class="mt40">
						<c:if test="${empty recommendDataList }">
							<p style="margin-top:40px; text-align: center;">추천된 향수가 없습니다.<br>
							Second Twenty의 향수 추천을 만나보세요.<br>
							<button style="margin-top: 20px;margin-bottom: 40px;"class="btn btn-dark" onclick="location.href='/goChoice'">향수 추천 받기</button></p>
						</c:if>
						<c:if test="${not empty recommendDataList }">
						<c:forEach items="${dateList }" var="dl" varStatus="j" >
								<p class="dateNo" onclick="showRecommend(this);">
								${dl } 추천 리스트
								</p>
								<div class style="display: none;">
								<c:forEach items="${recommendDataList }" var="rd" varStatus="i" >
									<c:if test="${dl==rd.recommendDate }">
										<div class="div-25">
											<div class="div-img">
												<a href="/viewPerfume?perfumeNo=${rd.recommendPerfumeNo }"><img class="recommendImg" src='/upload/photo/${rd.recommendPerfumePhotopath }' width='120px' height='120px'></a>
											</div>
											<p style="width:100%;text-align: center;">${rd.recommendPerfumeName }<br>${rd.recommendPerfumeVolume }ml</p>
										</div>
									</c:if>
								</c:forEach>
								<div class="clear-left"></div>
								</div>
							<hr>
						</c:forEach>
							<br>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script>
	function showRecommend(atr){
		$(atr).next().slideToggle(700);
	}
</script>
</body>
</html>