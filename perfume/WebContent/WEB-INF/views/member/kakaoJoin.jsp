<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = (String)request.getAttribute("id");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카카오 회원가입</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
</script>
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

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section style="padding-top:60px;">
		<div class="table-wrapper" style="margin:0 auto; width:750px; height:900px;">
			<form id="kakaojoinform" action="/kakaoJoin" method="post" id="control">
				<input type="hidden" name="memberId" value="<%=id %>">
				
				<div class="div2">
					<span class="span1">닉네임</span>　<span id="chkNickName"></span>
					<input class="input1" type="text" name="memberNickName" id="nickName"><br>
				</div>
				<input type="hidden" name="memberPw" value="<%=id %>">
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

				<button type="submit" class="admin btn1" style="width:100%">SIGN UP</button>
				
				
			</form>
			
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script>
	var arr = [false,false,false];
	var mailChkNum = "";
	$(document).ready(function(){//기능작동 준비
		$("label").click(function(){//label태그를 클릭하면 기능을 수행
			$("label").css('background-color','white').css('color','indigo');
			$(this).css('background-color','#5E5E5E').css('color','white');
		});
		
		$("#nickName").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[0] = false;
			var regExp = /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣][a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣0-9]{1,9}$/;//정규표현식
			var nickName = $("#nickName").val();//input창에 입력값을 변수에 저장
			if(regExp.test(nickName)){
				$.ajax({
					url:"/checkNickName",//CheckNickNameServlet
					data:{memberNickName:nickName},
					type: "post",
					success:function(data){
						if(data == '1'){
							arr[0] = true;
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
		
		$("#birth").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[1] = false;
			var birth = $("#birth").val();//input창에 입력값을 변수에 저장
			var regExp = /^[0-9]{8}$/;//정규표현식
			if(regExp.test(birth)){
				arr[1] = true;
				$("#chkBirth").html('사용 가능한 생년월일 입니다.');//id가 chkBirth인 span태그에 html효과를 넣어줌
				$("#chkBirth").css('color','green');//id가 chkBirth인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("#chkBirth").html('생년월일을 입력해주세요.');//id가 chkBirth인 span태그에 html효과를 넣어줌
				$("#chkBirth").css('color','red');//id가 chkBirth인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		$("#phone").change(function() {//input안에 입력값이 변환되면 기능 수행
			arr[2] = false;
			var phone = $("#phone").val();//input창에 입력값을 변수에 저장
			var regExp = /^\d{3}-\d{3,4}-\d{4}$/;//정규표현식
			if(regExp.test(phone)){
				arr[2] = true;
				$("#chkPhone").html('사용 가능한 번호입니다.');//id가 chkPhone인 span태그에 html효과를 넣어줌
				$("#chkPhone").css('color','green');//id가 chkPhone인 span태그에 쓰여진 문자의 색깔을 초록색으로 지정
			}else{
				$("#chkPhone").html('번호를 다시 입력해주세요.');//id가 chkPhone인 span태그에 html효과를 넣어줌
				$("#chkPhone").css('color','red');//id가 chkPhone인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});
		
		function clear(){
			message.innerHTML="";
			var input = document.getElementsByTagName("input");
			for(var i=0; i<input.length; i++){
				input[i].style.background="white";
			}
		}
		
		
		var chkUnload = true;
		/* function check() {
			var length = arr.length;
			var chk =0;
			for(var i=0; i<arr.length; i++){
				if(arr[i]==false){
					return false;
				}else{
					chk++;
				}	
			}
			if(chk==length){
				chkUnload=false;				
			}
			return false;
		}
		
		 */
	    $(window).on("beforeunload", function(){
	        if(chkUnload){
	        	var confirmResult = confirm("회원 가입을 취소하시겠습니까?");
		    	if(confirmResult ){
		    		var newWin = window.open("https://accounts.kakao.com/logout?continue=https://accounts.kakao.com/weblogin/account", "카카오 로그아웃","width=1,height=1,toolbar=no,menubar=no,scrollbars=no,resizable=no");
		    		newWin.close();
		        }else{
		        	
		        }
	        }
	    });
	    $("#kakaojoinform").submit(function(){
	    	/* function check() { */
				var length = arr.length;
				var chk =0;
				for(var i=0; i<arr.length; i++){
					if(arr[i]==false){
						alert("가입 폼을 완성해주세요!");
						return false;
					}else{
						chk++;
					}	
				}
				if(chk==length){
					chkUnload=false;				
				}
			/* } */
	    })
		$(".clickbtn").click(function() {
			$(".clickbtn").css("color", "black");
			$(this).css("background", "black").css("color", "white");
		});
	});
</script>
</body>
</html>