<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<title>로그인</title>
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
	height:52px;
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
}
#kakao-login-btn1>span{
	font-size: 18px;
	position: absolute;
	top:15px;
	left:182px;
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
		<div class="table-wrapper" style="margin:0 auto; width:500px; height:600px; text-align: center; margin-top: 200px;">
			<a name="login" class="log" id="kakao-login-btn1"></a><br>
			<div style="width:100%; margin: 0 auto;">
				<div class="leftline"></div>OR<div class="rightline"></div>
			</div>			
			<form action="/login" method="post">
				<input class="input1" type="text" placeholder="E-MAIL (ID)" name="memberId"><br>
				<input class="input1" type="password" placeholder="PASSWORD" name="memberPw"><br><br>
				<a href="/views/member/search.jsp" style="float:right; margin-bottom:10px; color:#999999; font-size:12px; font-weigtht:300;">비밀번호를 잊어버리셨나요?</a>
				<button type="submit" class="btn1" style="clear:both;">LOG IN</button><br>
			</form>
			<hr>
			<div style="width:100%; height:30px; margin:0 auto; margin-top:14px; text-align:center;">
				<span style="float:left; font-size:14px; font-weight:300;">TWENTY SECOND 계정이 없으신가요?</span>
				<button type="button" onclick="location.href='/views/member/join.jsp'" class="btn1" style="float:right; width:100px; font-size:13px; height:30px; padding:0px; font-weight:300;">SIGN UP</button>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script>
	function facebook() {
		window.open("");
	}
	function google() {
		window.open("");
	}
</script>
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
	    $("#kakao-login-btn1").append($('<span>카카오 계정으로 로그인</span>'));
	  //]]>
	    </script>
</body>
</html>