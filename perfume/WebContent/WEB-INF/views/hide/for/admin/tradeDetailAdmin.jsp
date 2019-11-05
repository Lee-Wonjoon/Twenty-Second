<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
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
	<div style="display:none;">
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	</div>
	<section class="pt-xs-40">
		<div>
			<h2 style= "padding-left : 30px;">Detail</h2><hr>
		</div>
		<div class="container container_body">
			<div class="row">
				<div class="div-80">
				<!-- payment_info -->
					<%-- <%for(BasketList bl : list){%> --%>
					<c:forEach items="${list }" var="list">
						<table class="table-borderless to_perfume">
							<tbody>
								<tr>
									<td rowspan="4" style="width: 50px;">
										<div class="check_div checked_basket" style="display:none;" onclick="checkOne(this);">
											<span class="hidden_data"></span>
										</div>
									</td><td rowspan="4"><img class="basket_img" alt="Twenty Second" src="/upload/photo/${list.paymentInfoPerfumePhotopath }"></td><td>제품명 : ${list.paymentInfoPerfumeName }</td>
								</tr>
								<tr>
									<td> 용량 :${list.paymentInfoPerfumeVolume } ml</td>
									
								</tr>
								<tr>
									<td> 수량 : ${list.paymentInfoBasketAmount } 개
									<input type="hidden" value="${list.paymentInfoBasketAmount }"></td>
								</tr>
								<tr>
									<td> 가격 : ${list.paymentInfoBasketPrice } 원
									<input type="hidden" value="${list.paymentInfoBasketPrice }"></td>
								</tr>
							</tbody>
						</table>
						<hr>
					</c:forEach>
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
				</div>
			</div>
		</div>
	</section>
<script>
	$(function(){
		var total_count = 0;
		var total_price = 0;
		var ship_price = $("#ship_price");
		var ship_total_price = $("#ship_total_price");
		var total_count_fin = $("#total_count");
		var total_price_fin = $("#total_price");
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
	});
	
</script>
</body>
</html>