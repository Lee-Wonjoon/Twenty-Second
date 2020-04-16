<%@page import="fp.payment.models.vo.Payment"%>
<%@page import="java.util.ArrayList"%>
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
	.payment_list tbody{
		color: #585858;
		height : 40px;
		border-bottom: 1px solid #585858;
	}
	.payment_list td{
		border-left: 1px solid #e8e8e8;
		border-right:1px solid #e8e8e8;
	}
	.payment_list thead{
		background:#585858;
		height: 20px;
		font-size: 12px;
		color: #fff;
		text-align: center;
	}
	.payment_date{
		font-size: 12px;
		width: 12%;
		line-height: 70px;
	}
	.payment_product_name{
		font-style: oblique;
		font-size: 12px;
		line-height: 70px;
		width: 42%;
	}
	.payment_price{
		width: 10%;
		font-size: 11px;
		line-height: 70px;
		text-align: center;
	}
	.payment_ship_data{
		font-size: 10px;
		padding: 0px 0px 0px 0px;
		width: 25%;
	}
	.payment_status{
		font-size: 12px;
		line-height: 70px;
		width: 11%;
		text-align: center;
	}
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
					<h5 class="mb4">주문 내역</h5>
					<hr class="hr-bold">
					<c:if test="${empty paymentList }">
					<ul class="cart-list mb64">
						<li class="mt36"> 구매 내역이 없습니다.</li>
					</ul>
					<div class="text-right mb64">
						<button class="btn btn-outline-dark btn-sm" onclick="location.href='/perfumeList'">첫 구매하러가기</button>
					</div>
					</c:if>
					<c:if test="${not empty paymentList }">
					
					<table class="table payment_list">
						<thead>
							<tr>
								<td>결제일</td><td>상품명</td><td>결제금액</td><td>받는사람(이름/번호/주소)</td><td>현재상태</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${paymentList }" var="p" varStatus="i">
							<tr>
								<td class="payment_date">${p.paymentDate}</td>
								<td class="payment_product_name">${p.paymentProductName}</td>
								<td class="payment_price">${p.paymentPrice}원</td>
								<td class="payment_ship_data">${p.paymentShipName}<br>${p.paymentShipPhone}<br>${p.paymentShipAddr}</td>
								<td class="payment_status">${p.paymentStatus}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				
					<div class="text-right">
						<button class="btn btn-outline-dark" onclick="location.href='/paymentList'">결제내역 더보기</button>
					</div>
					<br><br>
					</c:if>
					<h5 class="mb4">나만의 추천 향수</h5>
					<hr class="hr-bold mb0">
					<div class="mt40">
						<c:if test="${empty recommendDataList }">
							<p style="margin-top:40px; text-align: center;">추천된 향수가 없습니다.<br>
							Second Twenty의 향수 추천을 만나보세요.<br>
							<button style="margin-top: 20px;margin-bottom: 40px;"class="btn btn-dark" onclick="location.href='/goChoice'">향수 추천 받기</button></p>

						</c:if>
						<c:if test="${not empty recommendDataList }">
						<c:forEach items="${recommendDataList }" var="rd" varStatus="i" >
						<c:if test="${i.index<4 }">
						<div class="div-25">
							<div class="div-img">
								<a href="/viewPerfume?perfumeNo=${rd.recommendPerfumeNo }"><img class="recommendImg" src='/upload/photo/${rd.recommendPerfumePhotopath }' width='120px' height='120px'></a>
							</div>
							<p style="width:100%;text-align: center;">${rd.recommendPerfumeName }<br>${rd.recommendPerfumeVolume }ml</p>
						</div>
						</c:if>
						</c:forEach>
							<div class="text-right">
								<button class="btn btn-outline-dark" onclick="location.href='/recommendList'">추천 향수 더보기</button>
							</div>
							<br>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>