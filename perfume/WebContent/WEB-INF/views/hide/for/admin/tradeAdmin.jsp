<%@page import="fp.admin.models.vo.PageData"%>
<%@page import="fp.payment.models.vo.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<style>

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<section style="margin-top:60px;">
	<div class="imgContainer" style="height: 100px; text-align: center; font-size: 35px; line-height: 80px;">
		Admin Page
	</div>
	<div class="wrapper">
		<div class="mb64 col-md-3"><%@include
				file="/WEB-INF/views/hide/for/admin/adminpage_left_nav.jsp"%></div>
		<div class="thisPageCon">
			<form action="/searchAdmin" method=post>
				<input name="value"> <input type="hidden" name="location"
					value="tradeAdmin"> <input type="hidden" name="table"
					value="payment"> <select name="area">
					<option value="payment_No">거래번호</option>
					<option value="payment_member_no">회원번호</option>
				</select>
				<button>검색</button>
			</form>
			<div class="col-sm-8 col-md-8 col-md-offset-1" style="max-width:100%;">
				<h5 class="mb4">주문 내역</h5>
				<c:choose>
				<c:when test="${empty pd.list }">
					<hr class="hr-bold"">
					<ul class="cart-list mb64">
						<li class="mt36">주문받은 내역이 없습니다.</li>
					</ul>
				</c:when>
				<c:otherwise>
				<p>상품명을 누르시면 주문받은 상품들을 확인 할 수 있습니다.</p>
				<hr class="hr-bold"  style="margin-bottom:0px;">
				<table class="table payment_list" style="margin-top:0px; font-size: 13px;">
					<thead>
						<tr>
							<td>결제번호</td>
							<td>결제일</td>
							<td style="width:20%">상품명</td>
							<td>결제금액</td>
							<td style="width:35%">받는사람(이름/번호/주소)</td>
							<td>요청사항</td>
							<td>상태</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pd.list }" var="list">
						<tr>
							<td>${list.paymentNo}</td>
							<td class="payment_date">${list.paymentDate}</td>
							<td class="payment_product_name">
								<a class="product" href="#" onclick="showDetail(${list.paymentNo});">${list.paymentProductName}</a>
							</td>
							<td class="payment_price">${list.paymentPrice}원</td>
							<td class="payment_ship_data">${list.paymentShipName}<br>${list.paymentShipPhone}<br>${list.paymentShipAddr}</td>
							<td><br><button type="button" class="checkReqTradeAdmin" class="btn btn-outline-dark btn-sm status_btn">확인</button></td>
							<td class="payment_status">${list.paymentStatus}<br>
							<%--
							디버깅 
							<button type="button" class="btn btn-outline-dark btn-sm status_btn" onclick="changeStatus(this);">테스트</button>
							<input type="hidden" value="결제취소"> 
							<input type="hidden" value="${list.paymentNo}">
							 --%>
								<c:choose> 
									<c:when test='${list.paymentStatus eq "배송완료" || list.paymentStatus eq "배송중"}'>
										
									</c:when>
									<c:when test='${list.paymentStatus eq "환불신청" }'>
										<button type="button" class="btn btn-outline-dark btn-sm status_btn" onclick="changeStatus(this);">환불확인</button>
										<input type="hidden" value="환불"> 
	 								</c:when>							
	 								<c:when test='${list.paymentStatus eq "배송준비중" }'>
	 									<button type="button" class="btn btn-outline-dark btn-sm status_btn" onclick="changeStatus(this);">배송</button>
	 									<input type="hidden" value="배송중"> 
									</c:when>
									<c:when test='${list.paymentStatus eq "결제취소" }'>
										<button type="button" class="btn btn-outline-dark btn-sm status_btn" onclick="changeStatus(this);">취소확인</button>
										<input type="hidden" value="거래취소"> 
									</c:when>
								</c:choose>
								<input type="hidden" value="${list.paymentNo}">
							</td>
						</tr>
						<tr style="display:none">
							<td colspan="7"><div style="border:1px solid gray;">
								<c:choose>
									<c:when test="${!empty list.paymentShipMsg }">
										${list.paymentShipMsg }
									</c:when>
									<c:otherwise>
										요청사항이 없습니다.
									</c:otherwise>
								</c:choose>
							</div></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:otherwise>
				</c:choose>
			</div>
			<div id="pageNavi">${pd.pageNavi}</div>
		</div>
	</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
		//결제상태변경
		function changeStatus(atr) {
			var status = $(atr).next().val();
			var paymentNo = $(atr).next().next().val();
			location.href = "/changePaymentStatusAdmin?paymentNo=" + paymentNo + "&status=" + status;
		}
		//구매상세내역 보기
		function showDetail(pno) {
			var url = "/tradeInfoAdmin?paymentInfoPaymentNo=" + pno;
			window.open(url, "결제내역","width=800,height=700,toolbar=no,menubar=no,scrollbars=no,resizable=yes");
		}
		$(function(){
			$(".checkReqTradeAdmin").click(function(){
				/* amount, perfumeNo */
				$(this).parent().parent().next().toggle();
			});
		})
	</script>
</body>
</html>