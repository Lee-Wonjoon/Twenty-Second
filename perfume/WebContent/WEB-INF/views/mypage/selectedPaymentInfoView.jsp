<%@page import="fp.payment.models.vo.PaymentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매 상세 내역</title>
</head>
<body>
<style>
	.basket_img{
		width: 100px;
		height: 100px;
	}
	.payment_info_list td{
		line-height: 100px;
	}
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
	.product_name{
		margin-left: 20px;
		color: #585858;
	}
	.hr-bold {
	    border-top: 1px solid #333;
	    opacity: 1 !important;
	}
</style>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container container_body">
			<div class="row">
				<div class="div-80">
					<div class="content">
					<h4 class="product_name">상품명 : ${paymentProductName}</h4>
					<hr class="hr-bold">
						<table class="table payment_list">
							<thead>
								<tr>
									<td>제품사진</td><td>제품명</td><td>용량</td><td>수량</td><td>가격</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${paymentInfoList }" var="pi" varStatus="i">
								<tr class="payment_info_list">
									<td><a href="/viewPerfume?perfumeNo=${pi.paymentInfoPerfumeNo}"><img class="basket_img" alt="Twenty Second" src="/upload/photo/${pi.paymentInfoPerfumePhotopath}"></a></td>
									<td>${pi.paymentInfoPerfumeName}</td>
									<td>${pi.paymentInfoPerfumeVolume} ml</td>
									<td>${pi.paymentInfoBasketAmount} 개
									<td>${pi.paymentInfoBasketPrice} 원
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>