<%@page import="fp.payment.models.vo.PaymentInfo"%>
<%@page import="fp.payment.models.vo.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Payment> paymentList = (ArrayList)request.getAttribute("paymentList");
    %>
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
	.status_btn{
		width: 100%;
		font-size: 10px !important;
		margin-top: 3px;
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
					<c:if test="${empty paymentList }">
					<hr class="hr-bold">
					<ul class="cart-list mb64">
						<li class="mt36"> 구매 내역이 없습니다.</li>
					</ul>
					<div class="text-right mb64">
						<button class="btn btn-outline-dark btn-sm">첫 구매하러가기</button>
					</div>
					</c:if>
					<c:if test="${not empty paymentList }">
					<p>상품명을 누르시면 구매한 상품들을 확인 할 수 있습니다.</p>
					<hr class="hr-bold">
					<table class="table payment_list">
						<thead>
							<tr>
								<td>결제일</td><td>상품명</td><td>결제금액</td><td>받는사람(이름/번호/주소)</td><td>현재상태</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${paymentList }" var="pl" varStatus="i">
							<tr>
								<td class="payment_date">${pl.paymentDate}</td>
								<td class="payment_product_name"><a class="product" href="#" onclick="goProduct(this,'${pl.paymentNo}');">${pl.paymentProductName}</a></td>
								<td class="payment_price">${pl.paymentPrice}원</td>
								<td class="payment_ship_data">${pl.paymentShipName}<br>${pl.paymentShipPhone}<br>${pl.paymentShipAddr}</td>
								<td class="payment_status">${pl.paymentStatus}
									<c:if test="${pl.paymentStatus=='배송완료'||pl.paymentStatus=='배송중' }">
										<button type="button" class="btn btn-outline-dark btn-sm status_btn" onclick="changeStatus(this);">환불신청</button>
									</c:if>
									<c:if test="${pl.paymentStatus=='배송준비중'}">
										<button type="button" class="btn btn-outline-dark btn-sm status_btn" onclick="changeStatus(this);">결제취소</button>
									</c:if>
									<input type="hidden" value="${pl.paymentNo}">
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		//결제상태변경
		function changeStatus(atr){
			var status = $(atr).html();
			var paymentNo = $(atr).next().val();
			location.href = "/changePaymentStatus?paymentNo="+paymentNo+"&status="+status;
		}
		//구매상세내역 보기
		function goProduct(atr,paymentNo){
			var name = $(atr).html();
			var url = "/selectPaymenyInfo?paymentNo="+paymentNo+"&paymentProductName="+name;
			window.open(url,"구매리스트","width=800,height=700,toolbar=no,menubar=no,scrollbars=no,resizable=yes");
			
		}
	</script>
</body>
</html>