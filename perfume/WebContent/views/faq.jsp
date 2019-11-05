<%@page import="fp.notice.models.vo.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

.cs, .notice {
	color: gray;
}

.FAQ {
	color: black;
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
.content{
	display: none;
	padding: 10px;
	font-size: 13px;
}
.notice_list>li{
	color: black;
	line-height: 44px;
}
.onclickClass{
	cursor:pointer;
}
</style>
<title>FAQ</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<section style="margin-top:80px;">
	<div class="imgDivCs" style="margin-top:-40px;"><img src="/headerimg/tempppp.png" style="width:122%; height:90%;"></div>
	<div class="wrapper"
		style="margin: 0 auto; width: 50%; /* border:1px solid gray;  */ min-width: 600px;">
		<div class="tap" style="height: 60px;">
			<div class="FAQ">FAQ</div>
			<!-- <span></span> -->
			<div class="cs" onclick="location.href='/personalCs?memberId=${sessionScope.member.memberId}'"
				style="cursor: pointer;">1:1문의</div>
			<!-- <span></span> -->
			<div class="notice" onclick="location.href='/news'"
				style="cursor: pointer;">NOTICE</div>
		</div>
		<div class="notice_con">
			<div class="csContent">
				<ul class="notice_list">
						<li class="">
							<div class="onclickClass">Twenty Second는 어떤 사이트인가요?
							</div>
						</li>
							<div class="content">
								<p>
									Twenty Second는 고객의 향기 선호 분석을 통해, 취향에 맞는 향수를 추천해주는
									서비스입니다. <br>전세계 향수를 통해 보다 취향에 가까운 향수를 추천해 드리며, 추천된 향수는 마이페이지에 저장됩니다.
								</p>
								<button style="border:1px solid #ccc; border-radius:5px; background-color: white; color: #888888; margin-left:42%; margin-top:0;" class="returnFunc">닫기</button>
							</div>
						
						<li>
							<div class="onclickClass">주문 후 배송 현황을 어떻게 확인할 수 있나요?</div>
						</li>
							<div class="content">
								<p>
									특별한 공지가 없는 한 주문 후 2일 이내에, 각종 백화점에 유통되는 메이져 제품은 주문 후 익일에 TwentySecond에서
									출고됩니다. <br>모든 제품은 CJ 대한통운을 통해 배송되며 출고 후 마이페이지에서 송장번호를 확인하실
									수 있습니다. <br>송장번호는 TwentySecond 가입 시 등록해주신 전화번호와 이메일 주소로도 함께 전달드립니다.
								</p>
								<button style="border:1px solid #ccc; border-radius:5px; background-color: white; color: #888888; margin-left:42%; margin-top:0;" class="returnFunc">닫기</button>
							</div>
						<li>
							<div class="onclickClass">주문 취소는 어떻게 하나요?</div>
						</li>
							<div class="content">
								<p>
									01 '상품 준비중' 단계에서는 자유롭게 주문 취소하실 수 있습니다. <br>마이페이지&gt;최근 주문
									내역에서 '주문 취소' 버튼을 클릭해주시면 취소 요청이 접수 됩니다. <br>이는 취소 요청 단계이며
									영업일 기준 9:30am~6:30pm 사이에 취소 요청 내역 확인 후 <br>최종적으로 결제 취소를 처리
									해드립니다. 결제 취소가 완료되면 문자를 통해 안내 받으실 수 있습니다.
								</p>
								<button style="border:1px solid #ccc; border-radius:5px; background-color: white; color: #888888; margin-left:42%; margin-top:0;" class="returnFunc">닫기</button>
								<p>
									02 '출고 작업중' 단계에서는 주문 취소가 제한적으로 이루어집니다. <br>마이페이지&gt;최근 주문
									내역에서 출고 작업중 단계로 조회 되면, 고객님이 직접 주문 취소를 하실 수는 없습니다. <br>주문
									취소를 원하실 경우, 1:1 CS, 파펨 고객센터로 다음의 내용과 함께 문의주시면 확인 후 처리해드릴 예정입니다.
									<br>1. 주문자 성함 2. 결제수단 (카드 결제/휴대폰 결제/가상계좌)
								</p>
								
								<p>※ 가상계좌로 주문완료 후 아직 입금 전 단계에서 취소를 원하실 경우에는 별도로 취소 요청을 해주지
									않으셔도 됩니다.</p>
									<button style="border:1px solid #ccc; border-radius:5px; background-color: white; color: #888888; margin-left:42%; margin-top:0;" class="returnFunc">닫기</button>
							</div>
						<li>
							<div class="onclickClass">직접 가서 시향할 수 있는 오프라인 매장은
								없나요?</div>
						</li>
							<div class="content">
								<p>
									TwentySecond는 자사 제품을 만들어 팔지 않으며, 향수를 유통하는 온라인 사이트입니다.<br>
									시향을 원하시는 제품이 있다면 해당 상품을 취급하는 매점에 들려 시향을 하시는 걸 권합니다.
								</p>
								<button style="border:1px solid #ccc; border-radius:5px; background-color: white; color: #888888; margin-left:42%; margin-top:0;" class="returnFunc">닫기</button>
							</div>
						<!-- <li>
							<div class="onclickClass">향수 보관을 어떻게 하시나요?</div>
						</li>
							<div class="content">
								<p>
									저희 TwentySecond는 
								</p>
							</div> -->
						<li>
							<div class="onclickClass">문의사항이 있을 경우 어느 채널을 통해 문의해야
								하나요?</div>
						</li>
							<div class="content">
								<p>제품 교환/반품 요청, 품절 상품의 재입고 여부 및 각종 문의를 하실 수 있는 TwentySecond의 채널은 다음과
									같습니다.</p>

								<p>*제품 파손, 누락 등 제품에 문제가 있는 경우 수령일로부터 7일 이내 문의 주셔야 교환/환불이
									가능합니다.</p>

								<p>
									- TwentySecond web site 1:1 문의 게시판 <br>- 카카오톡 옐로 ID: @TwentySecond <br>-
									TwentySecond 고객센터 메일: help@TwentySecond.com
								</p>
								<button style="border:1px solid #ccc; border-radius:5px; background-color: white; color: #888888; margin-left:42%; margin-top:0;" class="returnFunc">닫기</button>
							</div>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$(".onclickClass").click(function() {
			$(this).parent().next().fadeToggle();
		});
		$(".returnFunc").click(function() {
			$(this).parent().fadeToggle();
		});
	</script>
</body>
</html>
