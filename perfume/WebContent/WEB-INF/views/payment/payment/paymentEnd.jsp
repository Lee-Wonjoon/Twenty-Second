<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String check = (String)(request.getAttribute("check"));
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	.span-right{
		float: right;
		padding-right: 10px;
		position: relative;
		width:30px;
	}
	.mb0{
		margin-bottom: 0px;
	}
	.div_payment_img{
		width:50px;
		height: 50px;
		background: #585858;
		position: relative;
		border-bottom-left-radius: 50px;
		border-bottom-right-radius: 50px;
		border-top-left-radius: 50px;
		border-top-right-radius: 50px;
		
	}
	.payment_img{
		position: absolute;
		width:45px;
		height: 45px;
		top:2px;
		left: 2px;
		
	}
	.w100{
		width: 100%;
		text-align: center;
	}
	.container_body{
		margin-bottom: 48px;
	}
	.btn1{
		border: 1px solid black;
		border-bottom-left-radius: 0px;
		border-bottom-right-radius: 0px;
		border-top-left-radius: 0px;
		border-top-right-radius: 0px;
	}
		
	
</style>

<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container container_body">
			<div class="row">
				<div class="div-80">
				<%if(check.equals("1")){ %>
					<table class="table-borderless mt64 w100">
						<tbody>
							<tr>
								<td colspan="2">
									<div class="div_payment_img"><img class="payment_img" src="/img/paymentSuccess.png"></div>
								</td>
							</tr>
							<tr>
								<th colspan="2">결제가 성공하였습니다.</th>
							</tr>
							<tr>
								<th colspan="2">Twenty Second를 이용해 주셔서 감사합니다.</th>
							</tr>
							<tr>
								<th class="color-000">상품명</th>
								<td class="text-right color-000"></td>
							</tr>
							<tr>
								<th class="color-000">결제금액</th>
								<td class="text-right color-000"></td>
							</tr>
							<tr>
								<th class="color-000">결제상태</th>
								<td class="text-right color-000"></td>
							</tr>
							<tr>
								<td><button type="button"  style="width: 50%;" class="btn btn-outline-dark btn1">마이페이지</button><button type="button" style="width: 50%;" class="btn btn-outline-dark btn1">메인으로</button></td>
							</tr>
						</tbody>
					</table>
					<%}else{ %>
					<div class="div_border1">
						<div class="div_border2">결제 내역</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</section>
	<style>
		.div_border1{
			border: 1px solid black;
			height: 200px;
			width: 100%;
		}
		.div_border2{
			border: 1px solid black;
			height: 100px;
			width: 100%;
			font-size: 40px;
			text-align: center;
			color: #585858;
		}
	</style>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>