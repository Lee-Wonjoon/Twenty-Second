<%@page import="fp.basket.model.vo.BasketList"%>
<%@page import="fp.basket.model.vo.Basket"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
</head>
<body>	
<style>
	.check_all{
		width:50%;
		background: skyblue;
	}
	div{
		box-sizing: border-box;
	}
	.div-80{
		width:80%;
		margin: 0 auto;
	}
	.div-50{
		width: 50%;
	}
	
	.container_body{
		margin-bottom: 48px;
	}
	.check_div{
		border: 1px solid  #585858;
		display: inline-block;
		width: 20px;
		height: 20px;
		line-height: 2.5;
		margin-right: 5px;
		position: relative;
	}
	.check_div img{
		width:15px;
		height:17px;
		position: absolute;
		left: 1.7px;
		top: 0px;
	}
	.checked_basket{
		background: #585858;
	}
	.position_right{
		float: right;
		clear: left;
	}
	.bb_bold{
		border-bottom: 1px solid black;
		padding-bottom: 20px;
		margin-bottom: 20px;
	}
	.color_000{
		color: #000;
		font-size: 16px;
		font-weight: bold;
	}
	.basket_img{
		width: 150px;
		height: 150px;
	}
	.hidden_data{
		display: none;
	}
</style>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section class="pt-xs-40">
		<div class="container container_body">
		<c:if test="${empty directCheck }">
		<input type="hidden" id="directChk" value="0">
		</c:if>
		<c:if test="${not empty directCheck }">
		<input type="hidden" id="directChk" value="1">
		</c:if>
			<div class="row">
				<div class="div-80">
					<div class="row  bb_bold">
						<div class="div-50">
							<button type="button" class="btn btn-dark btn-sm" onclick="checkAll(this);">전체선택</button>
						</div>
						<div class="div-50">
							<button type="button" class="btn btn-outline-dark btn-sm position_right" onclick="delBasket();">선택삭제</button>
						</div>
					</div>
					<c:if test="${not empty basketList }">
						<c:forEach items="${basketList }" var="bl" varStatus="i">
						<table class="table-borderless to_perfume">
							<tbody>
								<tr>
									<td rowspan="4" style="width: 50px;">
										<div class="check_div" onclick="checkOne(this);"><img src="/img/checkgoodwhite.png">
											<span class="hidden_data">${bl.b.basketNo}</span>
										</div>
									</td><td rowspan="4"><a href="/viewPerfume?perfumeNo=${bl.b.basketPerfumeNo}"><img class="basket_img" alt="Twenty Second" src="/upload/photo/${bl.perfumePhotopath}"></a></td><td>제품명 : ${bl.perfumeName}</td>
								</tr>
								<tr>
									<td> 용량 : ${bl.perfumeVolume} ml</td>
									
								</tr>
								<tr>
									<td> 수량 : ${bl.b.basketAmount} 개
									<input type="hidden" value="${bl.b.basketAmount}"></td>
								</tr>
								<tr>
									<td> 가격 : ${bl.b.basketPrice} 원
									<input type="hidden" value="${bl.b.basketPrice}"></td>
								</tr>
							</tbody>
						</table>
						<c:if test="${i.last }">
						<br>
						</c:if>
						<c:if test="${not i.last }">
						<hr>
						</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${empty basketList }">
					<p class="text-center mt32">장바구니에 담긴 상품이 없습니다.</p>
					</c:if>
					<table class="table mt64">
						<tbody>
							<tr>
								<th>주문상품 수</th>
								<td class="text-right" id="total_count"></td>
							</tr>
							<tr>
								<th>총 상품금액</th>
								<td class="text-right" id="total_price"></td>
							</tr>
							<tr>
								<th>배송비</th>
								<td class="text-right" id="ship_price"></td>
								
							</tr>
							<tr>
								<th class="color-000">총 결제 금액</th>
								<td class="text-right color-000" id="ship_total_price"></td>
							</tr>
							<tr>
								<th><span>[ 총 결제 금액 = 상품금액 + 배송비 ]</span></th>
								<td class="text-right"></td>
							</tr>
						</tbody>
					</table>
					<div id="sticky-button" class="row-gapless mb-xs-0 mb96">
							<button type="button" style="width: 100%;" class="btn btn-dark" onclick="paymentStart();">주문하기</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script>
$(document).ready(function(){
	if($("#directChk").val()==1){
		$(".check_div").last().click();
	}
});
//결제 페이지로 이동
	function paymentStart(){
		if($("#total_price").html()==""){
			alert("상품을 선택해주세요.");
		}else{
			var basketNoList ="";
			for(var i=0;i<$(".checked_basket").length;i++){
				if(i==$(".checked_basket").length-1){
					basketNoList += $(".checked_basket").eq(i).find('span').html()				
				}else{
					basketNoList += $(".checked_basket").eq(i).find('span').html()+",";
				}
			}
			location.href="/paymentStart?basketNoList="+basketNoList;
		}
	}
//선택한 리스트 장바구니에서 삭제
	function delBasket(){
		var delBasket ="";
		if($(".checked_basket").length==0){
			return;
		}else{
			if(!confirm("선택한 상품을 장바구니에서 삭제하시겠습니까?")){
				return;
			}
			for(var i=0;i<$(".checked_basket").length;i++){
				if(i==$(".checked_basket").length-1){
					delBasket += $(".checked_basket").eq(i).find('span').html()				
				}else{
					delBasket += $(".checked_basket").eq(i).find('span').html()+",";
				}
			}
		}
		location.href="/deleteBasket?delBasket="+delBasket;
	};
	//낱개 선택
	function checkOne(atr){
		var total_count = 0;
		var total_price = 0;
		var ship_price = $("#ship_price");
		var ship_total_price = $("#ship_total_price");
		var total_count_fin = $("#total_count");
		var total_price_fin = $("#total_price");
		if($(atr).attr('class')=="check_div"){
			$(atr).addClass("checked_basket");
		}else{
			$(atr).removeClass("checked_basket");
		}
		if(!$(".checked_basket").length>0){
			total_count_fin.html("");
			ship_price.html("");
			total_price_fin.html("");
			ship_total_price.html("");
			return;
		}
		for(var i=0;i<$(".checked_basket").length;i++){
			total_price += Number($(".checked_basket").eq(i).parent().parent().next().next().next().children().children().val());
			total_count += Number($(".checked_basket").eq(i).parent().parent().next().next().children().children().val());
		}
		if(total_price>=50000){
			ship_price.html("0 원");
			ship_total_price.html(total_price +" 원");
		}else{
			ship_price.html("2500 원");
			ship_total_price.html(total_price+2500 +" 원");
		}
		total_price_fin.html(total_price+" 원");
		total_count_fin.html(total_count+" 개");
	}
	//전체선택
	function checkAll(str){
		var total_count = 0;
		var total_price = 0;
		var ship_price = $("#ship_price");
		var ship_total_price = $("#ship_total_price");
		var total_count_fin = $("#total_count");
		var total_price_fin = $("#total_price");
		if($(str).html()=="전체선택"){
			$(".check_div").addClass("checked_basket");
			$(str).html("선택해제");
			$(str).removeClass("btn-dark");
			$(str).addClass("btn-outline-dark");
		}else{
			$(".check_div").removeClass("checked_basket");
			$(str).html("전체선택");
			$(str).removeClass("btn-outline-dark");
			$(str).addClass("btn-dark");
		}
		if(!$(".checked_basket").length>0){
			total_count_fin.html("");
			ship_price.html("");
			total_price_fin.html("");
			ship_total_price.html("");
			return;
		}
		for(var i=0;i<$(".checked_basket").length;i++){
			total_price += Number($(".checked_basket").eq(i).parent().parent().next().next().next().children().children().val());
			total_count += Number($(".checked_basket").eq(i).parent().parent().next().next().children().children().val());
		}
		if(total_price>=50000){
			ship_price.html("0 원");
			ship_total_price.html(total_price +" 원");
		}else{
			ship_price.html("2500 원");
			ship_total_price.html(total_price+2500 +" 원");
		}
		total_price_fin.html(total_price+" 원");
		total_count_fin.html(total_count+" 개");
	}
</script>
</body>
</html>