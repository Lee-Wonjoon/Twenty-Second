<%@page import="fp.basket.model.vo.BasketList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    ArrayList<BasketList> list = (ArrayList<BasketList>)request.getAttribute("basketList");
    int totalCount = (Integer)request.getAttribute("totalCount");
    int totalPrice = (Integer)request.getAttribute("totalPrice");
    int shipPrice = (Integer)request.getAttribute("shipPrice");
    int shipTotalPrice = (Integer)request.getAttribute("shipTotalPrice");
    String basketNoList = (String)request.getAttribute("basketNoList");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

<style>
	div{
		box-sizing: border-box;
	}
	.div-80{
		width:80%;
		margin: 0 auto;
	}
	.div-50{
		width:33%;
		height: 50px;
		line-height: 2.5;
	}
	.content{
		display: none;
		padding: 16px 0;
		height:100%;
		font-size: 13px;
	}
	.title{
		cursor: pointer;
		color:black;
		font-size: 16px;
		font-weight: bold;
		padding-bottom: 20px;
		padding-top: 10px;
	}
	.content_open{
		display: block;
	}
	.toggler{
		border-bottom: 1px solid black;
	}
	.list-tbl th, .list-tbl td{
		color:gray;
	}
	#ship_msg{
		width: 100%;
		background: #f5f5f5;
		margin-bottom: 24px;
		border: none;
		padding: 16px 20px;
	}
	.span-right{
		float: right;
		padding-right: 10px;
		position: relative;
		width:30px;
	}
	.arrow_img{
		width:100%;
		height: 25px;
		position: absolute;
		top: 0px;
		right: 10px;
	}
	.mb0{
		margin-bottom: 0px;
	}
	.basket_img{
		width: 150px;
		height: 150px;
	}
	.hidden_data{
		display: none;
	}
	.container_body{
		margin-bottom: 48px;
	}
</style>

<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container container_body">
			<div class="row">
				<div class="div-80">
					<ul class="accordion accordion-2 checkout mb0">
						<li class="toggler">
							<div class="title">
								총 <%=totalCount %> 개의 상품 / <%=totalPrice %> 원<span class="span-right"><img src="/img/down.png" class="arrow_img"></span>
							</div>
							<div class="content">
								<%for(BasketList bl : list){%>
								<table class="table-borderless to_perfume">
									<tbody>
										<tr>
											<td rowspan="4"><img class="basket_img" alt="Twenty Second" src="/upload/photo/<%=bl.getPerfume_photopath()%>"></td>
											<td>제품명 : <%=bl.getPerfume_name() %></td>
										</tr>
										<tr>
											<td> 용량 : <%=bl.getPerfume_volume() %> ml</td>
										</tr>
										<tr>
											<td> 수량 : <%=bl.getB().getBasketAmount() %> 개
										</tr>
										<tr>
											<td> 가격 : <%=bl.getB().getBasketPrice() %> 원
										</tr>
									</tbody>
								</table>
								<hr>
								<%} %>
							</div>
						</li>
						<li data-behavior="shipping-info-section" class="toggler">
							<div class="title acc-title">
								배송정보<span class="span-right"><img src="/img/down.png" class="arrow_img"></span><br>
								<p id="new_addr" class="small mt8 text-muted">배송 정보가 없습니다.</p>
							</div>
							<div class="content">
								<div class="tabbed-content button-tabs adress-info">
									<ul class="tab_ship">
										<li id="ship_addr_list">배송지 목록</li>
										<li id="new_addr">새 주소</li>
									</ul>
									<hr class="hr-bold">
									<div class="contents">
										<div class="content" style="padding-top:5px;">
										<h5>배송지 목록 (기존 배송지를 클릭하시면 현재 배송정보로 이동됩니다. 배송정보 삭제를 원하시면 삭제버튼을 누르세요.)</h5>
										<br>
										<table class="table-hover" id="shipAddr_list">
											<tbody></tbody>
										</table>
										</div>
										<div class="content addr_insert">
										<h5>새로운 주소 입력</h5>
											<span>
											<input id='postCode' style='width:200px;display:inline-block;margin-top:24px;margin-bottom:24px;' type='text' class='form-control' placeholder="우편번호">
											</span>
											<button id='addrSearchBtn' onclick="addrSearch();" class='btn btn-outline-dark' style="width: 200px;margin-bottom:5px;">주소검색</button>
											<span>
											<input id='userAddr' style='width:100%;margin-bottom:24px;' type='text' class='form-control' placeholder="주소">
											</span>
											<span>
											<input id='detailAddr' style='width:60%;float:left;' type='text' class='form-control' placeholder="상세주소" >
											</span>
											<span>
											<input id='extraAddr' style='width:35%;float:left;margin-left: 5px; margin-bottom:24px;' type='text' class='form-control' placeholder="참고항목">
											</span>
											<input id='userPhone' style='width:100%;margin-bottom:24px;' type='text' class='form-control' placeholder="전화번호">
											<input id='userName' style='width:100%;margin-bottom:24px;' type='text' class='form-control' placeholder="받는사람 이름">
											<button type="button" class="btn btn-dark" onclick="return insertAddr();" style="width: 100%;">등 록</button>
										</div>
									</div>
								</div>
							</div>
						</li>
					</ul>
						<ul class="accordian accordion-2 checkout">
							<li class="toggler">
								<div class="title acc-title">
									배송요청사항<span class="span-right"><img src="/img/down.png" class="arrow_img"></span>
								</div>
								<div class="content"">
									<textarea placeholder="배송 메시지 입력" id="ship_msg"></textarea>
								</div>
							</li>
							<li class="toggler">
								<div class="title acc-title">
									주문금액 확인<span class="span-right"><img src="/img/up.png" class="arrow_img"></span>
								</div>
								<div class="content content_open">
									<table class="table list-tbl">
										<tbody>
											<tr>
												<th>주문상품 수</th>
												<td class="text-right" id="totalCount"><%=totalCount %> 개</td>
												<input type="hidden" value="<%=totalCount%>">
											</tr>
											<tr>
												<th>상품 비용</th>
												<td class="text-right"><span id="subtotal"><%=totalPrice %> 원</span>
												</td>
											</tr>
											<tr>
												<th>배송비</th>
												<td class="text-right">
													<span id="shippingCost"><%=shipPrice %> 원</span>
												</td>
											</tr>
											<tr>
												<th>총 결제 금액</th>
												<td class="text-right">
													<span id="total"><%=shipTotalPrice %> 원</span>
													<input type="hidden" value="<%=shipTotalPrice%>">
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</li>
							<li class="toggler">
								<div class="title acc-title">
									결제수단 확인<span class="span-right"><img src="/img/up.png" class="arrow_img"></span>
								</div>
								<div class="content select-checkout content_open">
									<div style="width:100%;display: flex; flex-wrap: wrap;">
										<div class="div-50 pay_method">
											<input type="radio" class="payment_method" name="payment_method" id="method_card" value="card">
											<label class="non_check" for="method_card">신용카드</label>
										</div>
										<div class="div-50 pay_method">
											<input type="radio" class="payment_method" name="payment_method" id="method_trans"value="trans">
											<label class="non_check" for="method_trans">계좌이체</label>
										</div>
										<div class="div-50 pay_method">
											<input type="radio" class="payment_method" name="payment_method" id="method_phone"value="phone">
											<label class="non_check" for="method_phone">휴대폰결제</label>
										</div>
									</div>
								</div>
							</li>
						</ul>
						<br>
						<div>
						<div class="check_div" onclick="checkOne(this);"><img src="/img/checkgoodwhite.png"></div>
											<span>주문 상품 및 결제, 주문정보를 확인하였으며, 이에 동의합니다.(필수)</span>
						</div>
						<br>
						<div id="sticky-button" class="row-gapless mb-xs-0 mt48 mb48">
							<input type="hidden" value="<%=list.get(0).getPerfume_name() %>">
							<input type="hidden" value="<%=list.get(0).getPerfume_volume() %>">
							<input type="hidden" value="${member.memberId }">
							<input type="hidden" value="<%=basketNoList%>">
							<button type="button" class="btn btn-dark" style="width: 100%;" onclick="paymentGo();">결제하기</button>
						</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
<style>
	.tab_ship li{
		width:20%;
		height:40px;
		float: left;
		clear: right;
		font-size: 16px;
		border: 1px solid black;
		margin-right:10px;
		line-height: 2.5;
		text-align: center;
	}
	.tab_ship{
		overflow:hidden;
	}
	.addr_insert span{
		padding-right: 5px;
	}
	.addr_insert{
		padding-bottom: 5px;
		padding-top: 5px; 
	}
	#shipAddr_list{
		width:100%;
		margin: 0 auto;
		cursor: pointer;
	}
	.payment_method{
		display: none;
	}
	.pay_method{
		float: left;
	}
	.non_check{
		border : 1px solid black;
		background: white;
		width: 90%;
		height: 80%;
		text-align: center;
		font-size: 16px;
	}
	.non_check:hover{
		background: black;
		color:white;
		width: 90%;
		height: 80%;
		text-align: center;
		font-size: 16px;
		transition : .60s;
	}
	.check{
		border : 1px solid black;
		background: black;
		width: 90%;
		height: 80%;
		text-align: center;
		font-size: 16px;
		color: white;
		transition : .60s;
	}
	.check_div{
		border: 1px solid  #585858;
		display: inline-block;
		width: 14px;
		height: 14px;
		margin-right: 5px;
		position: relative;
	}
	.check_div img{
		width:10px;
		height:12px;
		position: absolute;
		left: 1px;
		top: 0px;
	}
	.checked{
		background: #585858;
	}
</style>
<script>
//주문동의 체크
function checkOne(atr){
		if($(atr).attr('class')=="check_div"){
			$(atr).addClass("checked");
		}else{
			$(atr).removeClass("checked");
		}
}
//배송지 테이블 삭제
function delAddr(atr){
	var shipAddrNo = $(atr).parent().parent().find('th').eq(0).children('input').val();
	var shipAddrName = $(atr).parent().parent().find('th').eq(1).html();
	var shipAddrPhone = $(atr).parent().parent().find('th').eq(2).html();
	var shipAddrAddr = $(atr).parent().parent().find('th').eq(3).html();
	$.ajax({
		url : "/deleteShipAddr",
		type : "get",
		data : {shipAddrNo:shipAddrNo},
		success : function(data){
			var oldmsg = data;
			var p = $("#new_addr");
			var msgList = oldmsg.split("+");
			var msg = "";
			for(var i=0;i<msgList.length;i++){
				msg+= msgList[i]+" ";
			}
			alert(msg);
			var pHtml = $("#new_addr").html();
			if(pHtml==(shipAddrName+"<br>"+shipAddrPhone+"<br>"+shipAddrAddr)){
				$("#new_addr").html("배송 정보가 없습니다.");
			}
			$("#ship_addr_list").click();
		}
	});
};
//베송지 테이블 추가
function insertAddr(){
	var addr = "";
	var name = $("#userName").val();
	var phone = $("#userPhone").val();
	addr += "("+$("#postCode").val() +")";
	addr += $("#userAddr").val();
	addr += $("#extraAddr").val();
	addr += $("#detailAddr").val();
	if(addr.length==2){
		alert("주소를 입력해주세요.");
		return;
	}
	if(phone.length<8){
		alert("전화번호를 정확히 입력해주세요.");
		return;
	}
	if(name.length==0){
		alert("이름을 입력해주세요.");
		return;
	}
	$.ajax({
		url : "/insertShipAddr",
		type : "get",
		data : {addr:addr,name:name,phone:phone},
		success : function(data){
			var oldmsg = data;
			var p = $("#new_addr");
			var msgList = oldmsg.split("+");
			var msg = "";
			for(var i=0;i<msgList.length;i++){
				msg+= msgList[i]+" ";
			}
			alert(msg);
			p.html(name+"<br>"+phone+"<br>"+addr);
		}
	});
}
//배송지목록 선택시 배송정보창 이동
function changeNewAddr(atr){
	var shipAddrName = $(atr).parent().find('th').eq(1).html();
	var shipAddrPhone = $(atr).parent().find('th').eq(2).html();
	var shipAddrAddr = $(atr).parent().find('th').eq(3).html();
	var p = $("#new_addr");
	p.html(shipAddrName+"<br>"+shipAddrPhone+"<br>"+shipAddrAddr);
};
//배송지목록 출력
$("#ship_addr_list").click(function(){
	$(".contents").children('div').hide();
	$("#shipAddr_list").parent().show();
	$.ajax({
		url : "/shipAddrList",
		type : "get",
		success : function(data){
			var tbody = $("#shipAddr_list").children('tbody');
			tbody.html("<tr><th></th><th>회원이름</th><th>연락처</th><th>배송지</th><th>정보삭제</th></tr>");
			if(data.length>0){
				for(var index in data){
					var tr = $("<tr>");
					var th0 = $("<th>");
					var th1 = $("<th onclick='changeNewAddr(this)'>");
					var th2 = $("<th onclick='changeNewAddr(this)'>");
					var th3 = $("<th onclick='changeNewAddr(this)'>");
					var th4 = $("<th>");
					th0.html("<input type='hidden' value='"+data[index].shipAddrNo+"'>");
					th1.html(data[index].shipAddrName);
					th2.html(data[index].shipAddrPhone);
					th3.html(data[index].shipAddrAddr);
					th4.html("<button type='button' class='btn btn-outline-dark btn-sm' onclick='delAddr(this)'>삭제</button>");
					tr.append(th0);
					tr.append(th1);
					tr.append(th2);
					tr.append(th3);
					tr.append(th4);
					tbody.append(tr);
				}
			}else{
				tbody.append("<tr><td></td><td colspan='5' style='padding-top:20px;'>이전 배송 정보가 없습니다. 새 주소를 눌러 배송지를 추가하세요.</td></tr>")
				$("#new_addr").html("배송 정보가 없습니다.");
			}
		}
	});
});
//새 주소 클릭시 새 주소 입력 창 나타남
$("#ship_addr_list").next().click(function(){
	$(".contents").children('div').hide();
	$("#shipAddr_list").parent().next().show();
});
//결제수단 선택시 색상 변화
$(document).ready(function(){
	$(".payment_method").click(function(){
		$(".payment_method").next().removeClass("check");
		$(".payment_method").next().addClass("non_check");
		$(this).next().removeClass("non_check");	
		$(this).next().addClass("check");
	});
	$(".tab_ship").children('li').click(function(){
		$(".tab_ship").children('li').removeClass("check");
		$(this).addClass("check");
	});
});
//위 아래 화살표 변화
$(document).ready(function(){
	$(".title").click(function(){
		if($(this).next().is(":visible")){
			$(this).next().slideUp(500);
			$(this).children(".span-right").children('img').attr('src','/img/down.png');
		}else{
			$(this).next().slideDown(500);
			$(this).children(".span-right").children('img').attr('src','/img/up.png');	
		}
		
		
	});
});
//3.다음 주소 찾기 연동
function addrSearch(){
	new daum.Postcode({
		oncomplete:function(data){
			var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            } 
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("extraAddr").value = extraAddr;
            
            } else {
            	document.getElementById("extraAddr").value = extraAddr;
            }
			$("#postCode").val(data.zonecode);
            $("#userAddr").val(addr);
			$("#detailAddr").focus();
		}
	}).open();
}
//2. 결제모듈 연동
	function paymentGo(){
		if($(".checked").length==0){
			alert("결제 정보에 동의 체크 해주세요.")
			return;
		}
		if($("#new_addr").html()=="배송 정보가 없습니다."){
			alert("배송 정보가 없습니다. 배송정보를 입력해주세요.");
			return;
		}
		if($(".check").length==1){
			alert("결제 수단을 선택해주세요.");
			return;
		}
		var price = $("#total").next().val();
		var pay_method = $(".check").prev().val();
		var addr = $("#new_addr").html();
		var addrlist = addr.split("<br>");
		var buyer_name = addrlist[0];
		var buyer_tel = addrlist[1];
		var buyer_postcode = addrlist[2].substr(1,5);
		var buyer_addr = addrlist[2].substr(7);
		var product_name = $("#sticky-button").children('input').eq(0).val()+" "+$("#sticky-button").children('input').eq(1).val()+"ml"
		if($("#totalCount").next().val()!=1){
			product_name += " 외 "+(Number($("#totalCount").next().val())-1)+"건";
		}
		var buyer_email = $("#sticky-button").children('input').eq(2).val();
		var basketNoList = $("#sticky-button").children('input').eq(3).val();
		var shipMsg = $("#ship_msg").val();
		//상품명_현재시간
		var d = new Date();
		var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();
		var merchant_uid = 'SecondTwenty_'+date+"_"+buyer_tel;
		IMP.init('imp67748939');	//결제 API를 사용하기 위한 코드 입력
		IMP.request_pay({	//결제 요청
			pg : 'inicis',
			pay_method : pay_method,
			merchant_uid : merchant_uid,//상점거래 ID
			name : product_name,				//결제 명
			amount : price,						//결제금액
			buyer_email : buyer_email,			//구매자 email
			buyer_name : buyer_name,			//구매자이름
			buyer_tel : buyer_tel,				//구매자전화번호
			buyer_addr : buyer_addr,			//구매자 주소
			buyer_postcode : buyer_postcode		//구매자 우편번호
		},function(rsp){	//결과 처리
			if(rsp.success){	//결제 성공
				if(confirm("결제가 완료되었습니다. 마이페이지로 이동하시겠습니까?")){
					var form = $("<form action='/paymentEnd' method='post'></form>");
					form.append($("<input type='hidden' name='basketNoList' value='"+basketNoList+"'>"));
					form.append($("<input type='hidden' name='merchantUid' value='"+merchant_uid+"'>"));
					form.append($("<input type='hidden' name='phone' value='"+buyer_tel+"'>"));
					form.append($("<input type='hidden' name='addr' value='"+buyer_addr+"'>"));
					form.append($("<input type='hidden' name='price' value='"+price+"'>"));
					form.append($("<input type='hidden' name='shipMsg' value='"+shipMsg+"'>"));
					form.append($("<input type='hidden' name='productName' value='"+product_name+"'>"));
					form.append($("<input type='hidden' name='shipName' value='"+buyer_name+"'>"));
					form.append($("<input type='hidden' name='loc' value='/mypageMain'>"));
					$("body").append(form);
					form.submit();
				}else{
					var form = $("<form action='/paymentEnd' method='post'></form>");
					form.append($("<input type='hidden' name='basketNoList' value='"+basketNoList+"'>"));
					form.append($("<input type='hidden' name='paymentData' value='"+merchant_uid+"'>"));
					form.append($("<input type='hidden' name='phone' value='"+buyer_tel+"'>"));
					form.append($("<input type='hidden' name='addr' value='"+buyer_addr+"'>"));
					form.append($("<input type='hidden' name='price' value='"+price+"'>"));
					form.append($("<input type='hidden' name='shipMsg' value='"+shipMsg+"'>"));
					form.append($("<input type='hidden' name='productName' value='"+product_name+"'>"));
					form.append($("<input type='hidden' name='shipName' value='"+buyer_name+"'>"));
					form.append($("<input type='hidden' name='loc' value='/'>"));
					$("body").append(form);
					form.submit();
				}
				
			}else{
				alert("결제가 실패되었습니다. 오류 내용 : "+rsp.error_msg);
				return;
			}
			var form = $("<form action='/paymentEnd' method='post'></form>");
			form.append($("<input type='hidden' name='basketNoList' value='"+basketNoList+"'>"));
			form.append($("<input type='hidden' name='paymentData' value='"+merchant_uid+"'>"));
			form.append($("<input type='hidden' name='phone' value='"+buyer_tel+"'>"));
			form.append($("<input type='hidden' name='addr' value='"+buyer_addr+"'>"));
			form.append($("<input type='hidden' name='payMethod' value='"+pay_method+"'>"));
			form.append($("<input type='hidden' name='price' value='"+price+"'>"));
			form.append($("<input type='hidden' name='msg' value='"+msg+"'>"));
			form.append($("<input type='hidden' name='shipMsg' value='"+shipMsg+"'>"));
			form.append($("<input type='hidden' name='productName' value='"+product_name+"'>"));
			form.append($("<input type='hidden' name='shipName' value='"+buyer_name+"'>"));
			$("body").append(form);
			form.submit();
		});
	};

</script>
</body>
</html>