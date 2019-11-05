<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
*{
   box-sizing: border-box;
}

.wrapper{
		padding: 15px;
	    margin-right: auto;
	    margin-left: auto;
	    flex-wrap: wrap;
	    display: flex;
	}
	
.container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}

.col-xs-6 {
    width: 50%;
}
.col-md-3 {
	flex: 0 0 15%;
    width: 15%;
    padding-right: 1px;
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

/*  */
.mb0 {
    margin-bottom: 0 !important;
}
/*  */
.mb4 {
    margin-bottom: 4px;
}

/*  */
.hr-bold {
    border-top: 1px solid #333;
    opacity: 1 !important;
}

.mb64{
	margin-bottom:64px;   
}
.fl{
	float:left;
}
.fn{
	float: none;
}
.fr{
	float: right;
}

.thisPageCon{
	margin-bottom:50px;
	width:85%;
	/* border:1px solid black; */
	padding:20px;
	padding-top:0px;
	background-color: white;
	min-height: 427px;
}
.thisPageCon table{
	margin-top:10px;
	text-align: center;
}

.thisPageCon select{
	height:30px;
	top:18px;
}

.thisPageCon table th{
	background-color: #EEEEEE;
	color:black;
 	border-bottom : 1px solid black;
}

.thisPageCon table tr{
	max-height: 47px;
}

.thisPageCon table tr:hover{
	background-color: #F3F3F3;
}

.adminSrearchForm{
	height:40px;
}

.adminSrearchForm>div{
	float:left;
}

.adminSrearchForm select{
	height:30px;
	top:18px;
}

.adminSrearchForm input{
	/* margin-top: 5px; */
}

section{
	width: 75%;
	margin: 0 auto;
}

#pageNavi{
	text-align: center;
	width:80%;
	margin:0 auto;
	margin-top:10px;
}
#pageNavi *{
	margin: 10px;
	padding: 0.375rem 0.75rem;
}
.selectPage{
	font-size:18px;
	color:#888888;
}
.btn{
	font-color: #888888;
	font-size:15px;
}

.thisPageCon button{
	border:1px solid rgb(169, 169, 169);
	background-color: white;
	height: 30px;
}

/* .hidden-xs li:first-child{
	border-top: 1px solid black;
	padding-top: 18px;
} */
.hidden-xs a {
}
.hidden-xs ul{
	background-color: white;
}
#insertATagAdmin{
	margin-left:20px; 
	border:1px solid rgb(169, 169, 169); 
	cursor:pointer; 
	height:30px; 
	display:inline-block; 
	padding-left: 5px;
	padding-right: 5px;
	color:black;
	float:right;
}
.imgContainer{
	background-color: black;
	color:white;
	margin:30px;
}
.imgContainer:hover{
	cursor:pointer;
}

</style>
<body>
	<div class="hidden-xs">
		<ul class="mypage-nav" id="mypage-nav">
			<li>
				<a href="/memberAdmin">
					<h5>회원 관리</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/listAdmin">
					<h5>상품 관리</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/reviewAdmin">
					<h5>리뷰 관리</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/questionAdmin">
					<h5>1:1 관리</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/noticeAdmin">
					<h5>공지 관리</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/tradeAdmin">
					<h5>거래 처리</h5>
					<hr class="hr-bold">
				</a>
			</li>
			<li>
				<a href="/perstaAdmin">
					<h5>Perstagram 관리</h5>
					<hr class="hr-bold">
				</a>
			</li>
		</ul>
	</div>
	<script>
		$(function(){
			$(".imgContainer").click(function(){
				location.href="/memberAdmin";
			});
		})
	</script>
</body>