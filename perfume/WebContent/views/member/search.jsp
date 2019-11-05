<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>
<style>
	.btn1 {
	    width:550px;
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
    	width: 550px;
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
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="margin:0 auto; width:550px; height:450px; text-align: center; margin-top:200px;">
			<div class="div3" style="height:60px;">
				<span class="span1" style="font-size:21px;">비밀번호 찾기</span><br>
				<hr style="border-top: 2px solid black;">
			</div>
			
			<div class="div1">
				<span class="span1" id="chkId">　</span>
				<input class="input1" type="email" name="memberId" id="id"><br>
			</div>
			<button class="btn1 num" style="clear:both;">새로운 비밀번호 발급받기</button><br>
			
			<div style="width:100%; height:30px; margin:0 auto; margin-top:14px; text-align:center;">
				<span style="float:left; font-size:14px; font-weight:300;">로그인 화면으로 돌아가기</span>
				<button type="button" onclick="location.href='/views/member/login.jsp'" class="btn1" style="float:right; width:100px; font-size:13px; height:30px; padding:0px; font-weight:300;">SIGN UP</button>
			</div>
			
			
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script>

	$(document).ready(function(){//기능작동 준비
		$("#id").change(function() {//input안에 입력값이 변환되면 기능 수행
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
							$("#chkId").html('존재하지 않는 회원입니다.');//id가 chkId인 span태그에 html효과를 넣어줌
							$("#chkId").css('color','red');//id가 chkId인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
						}
					}
				});
			}else{
				$("#chkId").html('올바른 이메일 형식이 아닙니다.');//id가 chkId인 span태그에 html효과를 넣어줌
				$("#chkId").css('color','red');//id가 chkId인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
			}
		});		
	
		$(".num").click(function(){
			var memberId = $("#id").val();//input창에 입력값을 변수에 저장
			$.ajax({
				url:"/auto2",//AutoServlet
				data:{memberId:memberId},
				type:"post",
				success:function(data){
					$("#chkId").html('메일을 전송했습니다.');//id가 chkId인 span태그에 html효과를 넣어줌
					$("#chkId").css('color','green');//id가 chkId인 span태그에 쓰여진 문자의 색깔을 빨간색으로 지정
				}
			});
		});
		
	});
</script>
</body>
</html>