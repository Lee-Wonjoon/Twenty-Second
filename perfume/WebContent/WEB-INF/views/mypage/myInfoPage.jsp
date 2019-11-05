<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>마이페이지</title>
</head>
<body>
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
	.addr_insert span{
		padding-right: 5px;
	}
	.addr_insert{
		padding-bottom: 5px;
		padding-top: 5px; 
	}
	.payment_method{
		display: none;
	}
	.pay_method{
		float: left;
	}
	.div-gender{
		width: 40%;
		float: left;
		border: 1px solid black;
		height: 40px;
		text-align: center;
		font-size: 16px;
		line-height: 40px;
		margin-left: 10px; 
		color:#585858;
		transition : .60s;
	}
	.check-gender{
		color:#fff;
		background: black;
		transition : .60s;
	}
	.btn-black{
		background: black !important;
		border-radius: 0 !important; 
		font-size: 18px !important;
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
					<form class="myInfoChangePwForm" action="/changePw" method="post">
						<h5 class="mb4">비밀번호 변경</h5>
						<hr class="hr-bold">
						<div class="row">
							<div class="input-with-label col-sm-12 text-left">
								<label for="user_current_password">
									<span>기존 비밀번호</span>
								</label>
								<input type="password" name="user_current_password" id="user_current_password">
							</div>
							<div class="input-with-label col-sm-6 text-left">
								<label for="user_password">
									<span>새 비밀번호</span>
								</label>
								<input type="password" name="user_password" id="user_password">
							</div>
							<div class="input-with-label col-sm-6 text-left"><label for="user_password_check">
									<span>새 비밀번호 확인</span>
								</label>
								<input type="password" name="user_password_check" id="user_password_check">
							</div>
						</div>
						<div><span class="statusMes"></span></div><br><br>
						<div class="row">
							<div class="col-sm-12">
								<input class="myInfoCheckBtn" type="submit" name="commit" value="비밀번호 변경" class="hollow">
							</div>
						</div>
					</form>
					<br><br>
						<h5 class="mb4">추가정보</h5>
						<hr class="hr-bold">
						<div class="row">
							<div class="input-with-label col-sm-6 text-left">
								<label for="phone">
									<span>휴대폰 번호</span> <span id="chkPhone"></span>
								</label>
								<input type="text" name="memberPhone" id="phone" placeholder="ex) 010-0000-0000">
							</div>
							<div class="input-with-label col-sm-6 text-left"><label for="birth">
									<span>생년월일</span> <span id="chkBirth"></span>
								</label>
								<input type="text" name="memberBirth" id="birth" placeholder="ex) 20191024">
							</div>
							<div class="input-with-label col-sm-6 text-left">
								<span>성별(선택)</span>
								<div style="margin-top:10px;">
								<div class="div-gender" onclick="checkedGender(this);">남자</div><div class="div-gender" onclick="checkedGender(this);">여자</div>
								</div>
							</div>
						</div>
						<div><span class="statusMes"></span></div><br><br>
						<div class="row">
							<div class="col-sm-12">
								<button type="button" class="btn btn-dark btn-black" onclick="return changeData();" style="width: 100%;height: 50px;">변경하기</button>
							</div>
						</div>
						<br><br>
						<h5 class="mb4 mt32">배송지 정보</h5>
						<hr class="hr-bold">
						<div class="row">
							<div class="content col-sm-12">
								<ul class="tab_ship">
									<li id="ship_addr_list">배송지 목록</li>
									<li id="new_addrs">새 주소</li>
								</ul>
								<div class="contents">
									<div class="content" style="padding-top:5px;">
									<h5>배송지 목록</h5>
									<br>
										<table class="table-hover" id="shipAddr_list" style="width: 100%;margin: 0 auto;cursor: pointer;">
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
										<input id='userName' style='width:100%;margin-bottom:24px;' type='text' class='form-control' placeholder="받는사람">
										<button type="button" class="btn btn-dark" onclick="return insertAddr();" style="width: 100%;">등 록</button>
									</div>
								</div>
							</div>
						</div>
					<br><br>
				</div>
			</div>
		</div>
	<script>
	//추가정보변경
	function changeData(){
		if($("#phone").val().length!=13){
			alert("휴대폰 번호를 예시에 맞게 입력해주세요.")
			return;
		}
		if($("#birth").val().length!=8){
			alert("생년월일을 예시에 맞게 입력해주세요.")
			return;
		}
		var gender = $(".check-gender").html();
		var phone = $("#phone").val();
		var birth = $("#birth").val();
		var form = $("<form action='/changeData' method='post'></form>");
		form.append($("<input type='hidden' name='gender' value='"+gender+"'>"));
		form.append($("<input type='hidden' name='phone' value='"+phone+"'>"));
		form.append($("<input type='hidden' name='phone' value='"+birth+"'>"));
		$("body").append(form);
		form.submit();
	}
	//성별 선택
function checkedGender(atr){
	if($(atr).attr('class')=="div-gender"){
		$(".div-gender").removeClass("check-gender");
		$(atr).addClass("check-gender");
	}else{
		$(atr).removeClass("check-gender");
	}
};	
$(document).ready(function(){
	$("#birth").change(function() {//input안에 입력값이 변환되면 기능 수행
		var birth = $("#birth").val();//input창에 입력값을 변수에 저장
		var regExp = /^[0-9]{8}$/;//정규표현식
		if(regExp.test(birth)){
			$("#chkBirth").html('사용 가능한 생년월일 입니다.');//id가 chkBirth인 span태그에 html효과를 넣어줌
			$("#chkBirth").css('color','green');//id가 chkBirth인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
		}else{
			$("#chkBirth").html('생년월일을 입력해주세요.');//id가 chkBirth인 span태그에 html효과를 넣어줌
			$("#chkBirth").css('color','red');//id가 chkBirth인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
		}
	});
	$("#phone").change(function() {//input안에 입력값이 변환되면 기능 수행
		var phone = $("#phone").val();//input창에 입력값을 변수에 저장
		var regExp = /^\d{3}-\d{3,4}-\d{4}$/;//정규표현식
		if(regExp.test(phone)){
			$("#chkPhone").html('사용 가능한 번호입니다.');//id가 chkPhone인 span태그에 html효과를 넣어줌
			$("#chkPhone").css('color','green');//id가 chkPhone인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
		}else{
			$("#chkPhone").html('번호를 다시 입력해주세요.');//id가 chkPhone인 span태그에 html효과를 넣어줌
			$("#chkPhone").css('color','red');//id가 chkPhone인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
		}
	});
		$(".clickbtn").click(function() {
			$(".clickbtn").css("color", "black");
			$(this).css("background", "black").css("color", "white");
		});
	});
	$(function(){
		$(".myInfoChangePwForm").submit(function(e){
			if($("#user_current_password").val()!="${sessionScope.member.memberPw}"){
				$(".statusMes").html("비밀번호가 일치하지 않습니다.");
				$(".statusMes").css('color','red');
				return false;
			}else{
				if($("#user_password").val()!=$("#user_password_check").val()){
					$(".statusMes").html("두 비밀번호가 일치하지 않습니다.");
					$(".statusMes").css('color','red');
					return false;								
				}
			}
		});
		$("#user_password").keyup(function(){//input안에 입력값이 변환되면 기능 수행
	        var value = $("#user_password").val();//input창에 입력값을 변수에 저장
	        var regExp = /^[a-zA-Z0-9]{10,18}$/;//정규표현식
	        if(regExp.test(value)){
	           $(".statusMes").html('사용가능한 비밀번호 입니다.');//id가 chkPw인 span태그에 html효과를 넣어줌
	           $(".statusMes").css('color','green');//id가 chkPw인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
	        }else{
	           $(".statusMes").html('보안성이 없는 비밀번호입니다.');//id가 chkPw인 span태그에 html효과를 넣어줌
	           $(".statusMes").css('color','red');//id가 chkPw인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
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
				tbody.html("");
				if(data.length>0){
				tbody.html("<tr><th></th><th>받는사람</th><th>연락처</th><th>배송지</th><th>정보삭제</th></tr>");
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
	$(document).ready(function(){
		
		$(".tab_ship").children('li').click(function(){
			$(".tab_ship").children('li').removeClass("check");
			$(this).addClass("check");
		});
		$("#ship_addr_list").click();
	});
	</script>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>