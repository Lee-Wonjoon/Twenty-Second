<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 회원가입</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<style>
	.btn1 {
	    width:365px;
	    height:50px;
	    background-color: white;
	    border: 1px solid black;
	    color:black;
	    padding: 13px 0;
	    text-align: center;
	    display: inline-block;
	    font-size: 17px;
	    cursor: pointer;
	    margin-bottom: 20px;
	    float:left;
	}
	.btn1:hover {
	    background-color: black;
	    color: white;
	    transition: .60s;
	}
	*{
		color:black;
	}
	.input1{
		border: none;
    	background-color:#F5F5F5;
    	width: 365px;
   		height: 50px;
   		margin-bottom: 20px;
   		padding-left:10px;
   		color: #777777;
    }
    .span1{
    	float: left;
    	font-size: 14px;
    	font-weight: 300;
    	margin-bottom: 5px;
    }
    .div1{
    	width: 49%;
    	height: 100px;
    	float: left;
    }
    .div2{
    	width: 49%;
    	height: 100px;
    	float: right;
    }
    .div3{
    	width: 100%;
    	height: 100px;
    	clear: both;
    }
</style>
<script>
	var arr = [false,false,false,false,false,false,false];
	var mailChkNum = "";
	$(document).ready(function(){//기능작동 준비
		$(".mailChk").hide();//인증값을 입력할 input태그, buotton태그, span태그를 숨김
		$("span.mailChk").html('메일 인증');//id가 mailChk인 span태그에 html효과를 넣어줌
		$("label").click(function(){//label태그를 클릭하면 기능을 수행
			$("label").css('background-color','white').css('color','indigo');
			$(this).css('background-color','#5E5E5E').css('color','white');
		});

		$("#id").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[0] = false;
			arr[6] = false;
			$(".mailChk").hide();//인증값을 입력할 input태그, buotton태그, span태그를 숨김
			var id = $("#id").val();//input창에 입력값을 변수에 저장
			var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;//정규표현식
			if(regExp.test(id)){
				$.ajax({
					url: "/checkId",//CheckIdServlet
					data: {memberId:id},
					type: "post",
					success	: function(data) {
						if(data == '1'){
							arr[0] = true;
							$("#chkId").html('사용가능한 아이디 입니다.');//id가 chkId인 span태그에 html효과를 넣어줌
							$("#chkId").css('color','green');//id가 chkId인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
						}else{
							$("#chkId").html('이미 사용중인 아이디 입니다.');//id가 chkId인 span태그에 html효과를 넣어줌
							$("#chkId").css('color','red');//id가 chkId인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
						}
					}
				});
			}else{
				$("#chkId").html('다시 작성');//id가 chkId인 span태그에 html효과를 넣어줌
				$("#chkId").css('color','red');//id가 chkId인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		$(".num").click(function(){//클래스가 num인 button을 클릭하면 기능 수행
			$(".mailChk").show();//인증값을 입력할 input태그, buotton태그, span태그를 보여줌
			$(".num").hide();
			var memberId = $("#id").val();//input창에 입력값을 변수에 저장
			$.ajax({
				url:"/auto",//AutoServlet
				data:{memberId:memberId},
				type:"post",
				success:function(data){
					mailChkNum = data;
				}
			});
		});
		
		$("button.mailChk").click(function(){//id가 mailChk인 button을 클릭하면 기능 수행
			var inputValue = $("input.mailChk").val();//input창에 입력값을 변수에 저장
			if(inputValue == mailChkNum){
				arr[6]=true;
				$("span.mailChk").html('메일 인증 완료');//id가 mailChk인 span태그에 html효과를 넣어줌
				$("span.mailChk").css('color','green');//id가 mailChk인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("span.mailChk").html('메일 인증 실패');//id가 mailChk인 span태그에 html효과를 넣어줌
				$("span.mailChk").css('color','red');//id가 mailChk인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		$("#nickName").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[2] = false;
			var regExp = /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣][a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣0-9]{1,9}$/;//정규표현식
			var nickName = $("#nickName").val();//input창에 입력값을 변수에 저장
			if(regExp.test(nickName)){
				$.ajax({
					url:"/checkNickName",//CheckNickNameServlet
					data:{memberNickName:nickName},
					type: "post",
					success:function(data){
						if(data == '1'){
							arr[1] = true;
							$("#chkNickName").html('사용 가능한 닉네임입니다.');//id가 chkNickName인 span태그에 html효과를 넣어줌
							$("#chkNickName").css('color','green');//id가 chkNickName인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
						}else{
							$("#chkNickName").html('이미 사용중인 닉네임입니다.');//id가 chkNickName인 span태그에 html효과를 넣어줌
							$("#chkNickName").css('color','red');//id가 chkNickName인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
						}
					}
				});
			}else{
				$("#chkNickName").html('영어, 한글 , 숫자로 2~10글자로 작성');//id가 chkNickName인 span태그에 html효과를 넣어줌
				$("#chkNickName").css('color','red');//id가 chkNickName인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		$("#pw").change(function(){//input안에 입력값이 변환되면 기능 수행
			arr[2] = false;
			var value = document.getElementById("pw").value;//input창에 입력값을 변수에 저장
			var regExp = /^[a-zA-Z][a-zA-Z0-9]{10,13}$/;//정규표현식
			if(regExp.test(value)){
				arr[2] = true;
				$("#chkPw").html('사용가능한 비밀번호 입니다.');//id가 chkPw인 span태그에 html효과를 넣어줌
				$("#chkPw").css('color','green');//id가 chkPw인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("#chkPw").html('보안성이 없는 비밀번호입니다.');//id가 chkPw인 span태그에 html효과를 넣어줌
				$("#chkPw").css('color','red');//id가 chkPw인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}	
		});
		
		$("#pw1").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[3] = false;
			var pw = document.getElementById("pw").value;//input창에 입력값을 변수에 저장
			var pw1 = document.getElementById("pw1").value;//input창에 입력값을 변수에 저장
			if(pw == pw1){
				arr[3] = true;
				$("#chkPw1").html('비밀번호가 일치합니다.');//id가 chkPw1인 span태그에 html효과를 넣어줌
				$("#chkPw1").css('color','green');//id가 chkPw1인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("#chkPw1").html('비밀번호가 일치하지 않습니다.');//id가 chkPw1인 span태그에 html효과를 넣어줌
				$("#chkPw1").css('color','red');//id가 chkPw1인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		$("#birth").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[4] = false;
			var birth = $("#birth").val();//input창에 입력값을 변수에 저장
			var regExp = /^[0-9]{8}$/;//정규표현식
			if(regExp.test(birth)){
				arr[4] = true;
				$("#chkBirth").html('사용 가능한 생년월일 입니다.');//id가 chkBirth인 span태그에 html효과를 넣어줌
				$("#chkBirth").css('color','green');//id가 chkBirth인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("#chkBirth").html('생년월일을 입력해주세요.');//id가 chkBirth인 span태그에 html효과를 넣어줌
				$("#chkBirth").css('color','red');//id가 chkBirth인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		$("#phone").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[5] = false;
			var phone = $("#phone").val();//input창에 입력값을 변수에 저장
			var regExp = /^\d{3}-\d{3,4}-\d{4}$/;//정규표현식
			if(regExp.test(phone)){
				arr[5] = true;
				$("#chkPhone").html('사용 가능한 번호입니다.');//id가 chkPhone인 span태그에 html효과를 넣어줌
				$("#chkPhone").css('color','green');//id가 chkPhone인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("#chkPhone").html('번호를 다시 입력해주세요.');//id가 chkPhone인 span태그에 html효과를 넣어줌
				$("#chkPhone").css('color','red');//id가 chkPhone인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
	});
	
	function check() {
		//if(arr[0]==false){
		//	return false;
		//}
		
		//if(arr[1]==false){
		//	return false;
		//}
		
		//if(arr[2]==false){
		//	return false;
		//}
		
		//if(arr[3]==false){
		//	return false;
		//}
		
		//if(arr[4]==false){
		//	return false;
		//}
		
		//if(arr[5]==false){
		//	return false;
		//}
		
		for(var i=0; i<arr.length; i++){
			if(arr[i]==false){
				return false;
			}
			arr[i];
		}
	}
	
	function clear(){
		message.innerHTML="";
		var input = document.getElementsByTagName("input");
		for(var i=0; i<input.length; i++){
			input[i].style.background="white";
		}
	}
	
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="margin:0 auto; width:750px; height:900px;">
			<form action="/emailJoin" method="post" id="control">
				<div class="div3" style="height:60px;">
					<span class="span1" style="font-size:21px;">비밀번호 찾기</span><br>
					<hr style="border-top: 2px solid black;">
				</div>
			
				<div class="div1">
					<span class="span1">이메일 (ID)</span>　<span id="chkId"></span>
					<input class="input1" type="email" name="memberId" id="id"><br>
				</div>
				
				<div class="div2">
					<span class="span1">닉네임</span>　<span id="chkNickName"></span>
					<input class="input1" type="text" name="memberNickName" id="nickName"><br>
				</div>
				
				<div class="div1">
					<span class="span1">이메일 인증 (1회)</span>
					<button type="button" class="num btn1">인증번호 전송</button><br>
					<input type="text" class="mailChk input1" placeholder="인증번호를 입력하세요">									
				</div>
				
				<div class="div2">
					<span class="span1"><span class="mailChk"></span></span>
					<button type="button" class="btn1 mailChk">인증</button>					
				</div>
				
				<div class="div1">
					<span class="span1">비밀번호</span>　<span id="chkPw"></span>
					<input class="input1" type="password" name="memberPw" id="pw"><br>								
				</div>
				
				<div class="div2">
					<span class="span1">비밀번호 확인</span>　<span id="chkPw1"></span>
					<input class="input1" type="password" name="memberPw" id="pw1"><br>									
				</div>
				
				<div class="div1">
					<span class="span1">휴대폰 번호</span>　<span id="chkPhone"></span>
					<input class="input1" type="tel" name="memberPhone" id="phone" placeholder="ex) 010-0000-0000"><br>								
				</div>
				
				<div class="div2">
					<span class="span1">생년월일</span>　<span id="chkBirth"></span>
					<input class="input1" type="text" name="memberBirth" id="birth" placeholder="ex) 20191024"><br>
				</div>
				
				<div class="div1">
					<span class="span1" style="width:100%;">성별 (선택)</span>
					<input type="radio" class="radio1" style="display:none;" name="memberGender" id="male" value="male"><label for="male" class="btn1 clickbtn" style="width:177px; margin-right:10px;">남자</label>
					<input type="radio" class="radio1" style="float:right; display:none;" name="memberGender" id="female" value="female"><label for="female" class="btn1 clickbtn" style="width:177px;">여자</label>
				</div>
				
				<div class="div3" style="height:70px;">
					<span style="font-size:13px; color:#999999; font-weight:300; margin">회원 가입 또는 계속하기를 클릭하면 파펨의</span><br>
					<span style="font-size:13px; color:black; font-weight:500;">이용약관 및 개인정보보호정책</span>
					<span style="font-size:13px; color:#999999; font-weight:300;">에 동의하는 것입니다.</span>					
				</div>

				<button type="submit" class="admin btn1" onclick="return check();" style="width:100%">SIGN UP</button>
				
				<div class="div3">
					<hr>
					<span style="float:left; font-size:14px; font-weight:300;">이미 TWENTY SECOND 계정이 있으신가요?</span>
					<button type="button" onclick="location.href='/views/member/login.jsp'" class="btn1" style="float:right; width:100px; font-size:13px; height:30px; padding:0px; font-weight:300;">LOG IN</button>
				</div>
				
			</form>
			
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$(document).ready(function(){
			$(".clickbtn").click(function() {
				$(".clickbtn").css("color", "black");
				$(this).css("background", "black").css("color", "white");
			});
		});
	</script>	
	
</body>
</html>