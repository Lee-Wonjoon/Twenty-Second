<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
</head>
<body>
<style>
	.check_div{
		border: 1px solid  #585858;
		display: inline-block;
		width: 15px;
		height: 15px;
		line-height: 2.5;
		margin-right: 5px;
		position: relative;
		margin-top: 10px;
		top:3px;
	}
	.check_div img{
		width:13px;
		height:15px;
		position: absolute;
		left: 0px;
		bottom: -1px;		
	}
	.checked_out{
		background: #585858;
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
				<div class="col-sm-8 col-md-8 col-md-offset-1 mb36">
					<h5 class="mb4">회원 탈퇴</h5>
					<hr class="hr-bold">
					<p class="lead color-000">
						Twenty Second를 이용하면서 불편하셨던 점이나 불만사항을 알려주세요.
						<br>
						적극 반영하여 불편함을 해결하기 위해 노력하겠습니다.
						<br>
						<small>회원 탈퇴 시 아래의 안내 사항을 숙지하시기 바랍니다.</small>
					</p>
					<p>
						- 회원 탈퇴 시 고객님의 정보는 상품 반품 등을 위한 전자상거래 등에서의 
						소비자 보호에 관한 법률에 의거한 Twenty Second 고객정보 보호정책
						에 따라 관리됩니다.
						<br>
						- 탈퇴 시 보유 혜택(쿠폰 / 마일리지 등)은 모두 삭제되며, 
						 한번 탈퇴한 아이디는 재 사용에 제한이 있습니다.
						<br>
					</p>
					<p class="color-0000 mt64 mb4">Twenty Second 이용중 불편했던 점을 알려주세요.(선택)</p>
					<form class="new_unregister_form" id="new_unregister_form" action="/deleteMember" method="post">
						<textarea class="form-control" rows="4" name="unregister_form_reason" id="unregister_form_reason" style="width: 100%;resize:none;" ></textarea>
						<input name="unregister_form_agree" type="hidden" value="0">
						<div class="check_div" id="unregister_form_agree" onclick="checkOne(this);"><img src="/img/checkgoodwhite.png">
						</div>
						<label class="ml15" for="unregister_form_agree">
							<span class="span_out">주의 및 안내 사항을 확인했으며, Twenty Second 회원을 탈퇴하겠습니다.</span>
						</label>
						<div class="row-gapless mt16 mb32 clearfix">
							<div class="col-xs-6" style="float: left;border: 1px solid black;">
								<a class="btn btn-lg btn-100 mb0" href="/mypageMain">취소</a>
							</div>
							<div class="col-xs-6" style="float: left; clear:right;">
								<input type="submit" name="commit" value="탈퇴하기" class="mb0">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	<script>
	$(document).ready(function(){
		$('span').click(function(){
			$(".check_div").click();
		});
	});
	function checkOne(atr){
		if($(atr).attr('class')=="check_div"){
			$(atr).addClass("checked_out");
		}else{
			$(atr).removeClass("checked_out");
		}
	}
		$(function(){
			$("#new_unregister_form").submit(function(e){
				if(!$(".checked_out").length==1){
					alert("주의 및 안내사항을 확인 후 동의란에 체크해주세요")
					return false;
				}
			});			
		});
	</script>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>