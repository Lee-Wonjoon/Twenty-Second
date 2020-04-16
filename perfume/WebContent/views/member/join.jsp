<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<title>회원가입</title>
<style>
	.btn1 {
	    width:500px;
	    background-color: white;
	    border: 1px solid black;;
	    color:black;
	    padding: 13px 0;
	    text-align: center;
	    display: inline-block;
	    font-size: 17px;
	    cursor: pointer;
	    margin-bottom: 20px;
	}
	.btn1:hover {
	    background-color: black;
	    color: white;
	    transition: .60s;
	}
	.leftline{
		width: 45%;
		height: 20px;
		border-bottom: 1px solid black;
		float: left;
	}
	.rightline{
		width: 45%;
		height: 20px;
		border-bottom: 1px solid black;
		float: right;
	}
	*{
		color:black;
	}
	.input1{
    	border: none;
    	background-color:#F5F5F5;
    	width: 500px;
   		height: 50px;
   		padding-left:10px;
   		margin-top: 20px;
   		color: #777777;
    }
   .log{
	display:block;
	width:500px;
	height:48px;
	background-color: #FDDC3F;
}
#kakao-login-btn{
	display:none;
}
#kakaoLogo{
	width:52px;
	position: absolute;
	left: 132px;
}
#kakao-login-btn1{
	position: relative;
	height: 52px;
}
#kakao-login-btn1>span{
	font-size: 18px;
	position: absolute;
	top:15px;
	left:178px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<script>
		$(function(){
			var newWin = window.open("https://accounts.kakao.com/logout?continue=https://accounts.kakao.com/weblogin/account", "카카오 로그아웃","width=1,height=1,toolbar=no,menubar=no,scrollbars=no,resizable=no");
			newWin.close();							
		});
	</script>
	<section>
		<div class="table-wrapper" style="margin:0 auto; width:500px; height:500px; text-align: center; margin-top: 200px;">
			<a id="kakao-login-btn1" name="login" class="log"></a>
			<div style="width:100%; margin: 0 auto; margin-bottom:20px;">
				<div class="leftline"></div>OR<div class="rightline"></div>
			</div>
			<button type="button" class="btn1" style="margin-bottom:0px;" onclick="location.href='/views/member/emailJoin.jsp'">이메일로 회원가입</button><br><br>			
			<div style="width:100%; height:30px; margin:0 auto; text-align:center;">
				<span style="float:left; font-size:13px; color:#999999; font-weight:300;">회원 가입 또는 계속하기를 클릭하면 파펨의</span><br>
				<span style="float:left; font-size:13px; color:black; font-weight:500;">이용약관 및 개인정보보호정책</span>
				<span style="float:left; font-size:13px; color:#999999; font-weight:300;">에 동의하는 것입니다.</span>				
			</div>
			<br><hr>
			<div style="width:100%; height:30px; margin:0 auto; margin-top:14px; text-align:center;">
				<span style="float:left; font-size:14px; font-weight:300;">이미 TWENTY SECOND 계정이 있으신가요?</span>
				<button type="button" onclick="location.href='/views/member/login.jsp'" class="btn1" style="float:right; width:100px; font-size:13px; height:30px; padding:0px; font-weight:300;">LOG IN</button>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script type='text/javascript'>
	  //<![CDATA[
	    // 사용할 앱의 JavaScript 키를 설정해 주세요.
	    Kakao.init('52b873587dbf1ed4d7e2c4dfaaf39adc');
	    // 카카오 로그인 버튼을 생성합니다.
	    Kakao.Auth.createLoginButton({
	      container: '#kakao-login-btn1',
	      success: function(authObj) {
	        // 로그인 성공시, API를 호출합니다.
	        Kakao.API.request({
	          url: '/v2/user/me',
	          success: function(res) {
	           var id = JSON.stringify(res.id);
	           var form = $("<form action='/kakao' method='post'></form>");
	           form.append($("<input type='text' name='id' value='"+id+"'>"));
	           $('body').append(form);
	           form.submit();
	          },
	          fail: function(error) {
	            alert(JSON.stringify(error));
	          }
	        });
	      },
	      fail: function(err) {
	        alert(JSON.stringify(err));
	      }
	    });
	    $("#kakao-login-btn1").append($('<img id="kakaoLogo" src="/upload/loginKakao/kakao.png">'));
	    $("#kakao-login-btn1").append($('<span>카카오 계정으로 회원가입</span>'));
	  //]]>
	    </script>
</body>
</html>