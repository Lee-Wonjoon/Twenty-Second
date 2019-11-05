<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
*{
	box-sizing: border-box;
}
.container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
.row {
    margin-right: -15px;
    margin-left: -15px;
}
.col-xs-6 {
    width: 50%;
}
.color-000 {
    color: #000 !important;
}
p.lead {
    font-size: 16px;
    line-height: 28px;
}
h1, h2, h3, h4, h5, h6 {
    color: #000;
}
h5 {
    font-size: 14px;
    line-height: 24px;
}
p {
    margin: 0 0 10px;
}
a {
    color: #999;
    transition: all 0.3s ease;
    -webkit-transition: all 0.3s ease;
    -moz-transition: all 0.3s ease;
    cursor: poitner;
}
body {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-size: 13px;
    line-height: 19px;
    font-family: 'notokr-demilight', "Open Sans Condensed", Verdana, sans-serif;
    color: #999;
    overflow-x: hidden;
    -ms-overflow-style: scrollbar;
}
body{
	font-size: 13px;
}
.add-to-cart input[type="text"], .add-to-cart input[type="number"], .cart-list input[type="text"], .cart-list input[type="number"] {
    background: #fff;
    border: 1px solid #f5f5f5;
    width: 40px;
    height: 30px;
    color: #222;
    text-align: center;
    padding: 0 5px;
    margin: 0;
    font-size: 11px;
}
input[type="text"], input[type="number"], input[type="email"], input[type="password"] {
    background: #f5f5f5;
    border: none;
    width: 100%;
    height: 50px;
    padding-left: 20px;
    margin-bottom: 24px;
    border-radius: 0;
    font-size: 16px;
}
input[type="text"], input[type="number"], button, textarea, select, input[type="password"] {
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
input[type=checkbox]:checked, input[type=radio]:checked {
    background-color: #000;
}
input[type=checkbox], input[type=radio] {
    padding: 5px;
    border-radius: 15px;
    line-height: 24px;
    -webkit-appearance: button;
    border: double 1px #ccc;
    background-color: #fff;
    color: #FFF;
    white-space: nowrap;
    overflow: hidden;
    width: 15px;
    height: 15px;
}
input[type=submit].cart-item-btn {
    height: 25px;
    line-height: 17px;
    font-size: 11px;
    width: auto;
    background: #fff;
    border-color: #666;
    color: #000;
}
.btn-option {
    padding: 3px 10px;
    border: 1px solid #666;
    font-size: 11px;
    line-height: 17px;
    height: 25px;
    min-width: 60px;
    margin-bottom: 0;
    opacity: .8;
}
.btn-100 {
    width: 100%;
}
.mb0 {
    margin-bottom: 0 !important;
}
.mt4 {
    margin-top: 4px;
}
.mb4 {
    margin-bottom: 4px;
}
.mt16 {
    margin-top: 16px;
}
.mt36 {
    margin-top: 36px;
}
.ml36{
	margin-left: 36px;
}
.mb36 {
    margin-bottom: 36px;
}
.mt64 {
    margin-top: 64px;
}
.mb64{
	margin-bottom:64px;	
}


input[type="submit"], button[type="submit"], .submit-btn {
    height: 50px;
    line-height: 48px;
    border: 1px solid #000;
    background: #000;
    color: #fff;
    width: 100%;
    border-radius: 0 !important;
    font-size: 18px;
}
input[type="submit"], button[type="submit"], .submit-btn {
    height: 50px;
    line-height: 48px;
    border: 1px solid #000;
    background: #000;
    color: #fff;
    width: 100%;
    border-radius: 0 !important;
    font-size: 18px;
}
.hollow, button[type="submit"].hollow, .submit-btn.hollow {
    background: none;
    border: 1px solid #000;
    color: #000;
    transition: all 0.3s ease;
    -webkit-transition: all 0.3s ease;
    -moz-transition: all 0.3s ease;
}
.hr-bold {
    border-top: 1px solid #333;
    opacity: 1 !important;
}
</style>
	<div class="hidden-xs">
		<ul class="mypage-nav">
			<li>
				<a href="/myInfoCheck">
					<h5>회원 정보</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/paymentList">
					<h5>구매 내역</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/recommendList">
					<h5>추천 향수 내역</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/basketList">
					<h5>장바구니</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/questionList">
					<h5>1:1 문의</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/outPage">
					<h5>회원탈퇴</h5>
					<hr class="hr-bold">
				</a>
			</li>
		</ul>
	</div>
</body>
</html>