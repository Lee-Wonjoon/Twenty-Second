<%@page import="fp.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member m = (Member)session.getAttribute("member");
    %>
    <!-- 앞으로 들어갈 클래스명들은 디자인을 위한 것일 뿐인게 많다. --> 
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel = "stylesheet" href="/css/bootstrap.css">
<link rel = "stylesheet" href="/css/header/style.css">
<link rel = "stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src ="/js/bootstrap.js"></script>

<!-- doctype부터 어쩌구 이런거는 다 불러올 페이지에 있을 예정이므로 그냥 싹 다 지워도 됨.
불러오는 시점에선 이미 그것들 안에 둘러쌓여있을 것이므로. -->
	<header class = "header_area" style="height:60px;">
		<nav class = "navbar navbar-expand-lg navbar-light" style="height:60px;">
			<div class = "container" style="height:60px;">
				<!-- '/'하나 하면 자기자신과 동일 -->
				<a class = "navbar-brand logo_h" href="/" style="height:60px;">
					<img src = "/headerimg/logo.png" width="135" height="60">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class= "collapse navbar-collapse offset" id="navbarSupportedContent">
					<ul class ="nav navbar-nav menu_nav ml-auto">
						<li class="nav-item"><img alt="" src="/headerimg/shop.png" onclick="location.href='/shop'" style="width:100%; vertical-align: middle; cursor: pointer;"></li>
						<li class="nav-item"><img alt="" src="/headerimg/NEWS.png" onclick="location.href='/news'" style="width:100%; vertical-align: middle; cursor: pointer;"></li>
						<li class="nav-item"><img alt="" src="/headerimg/cs.png" onclick="location.href='/cs'" style="width:100%; vertical-align: middle; cursor: pointer;"></li>
						<li class="nav-item"><img alt="" src="/headerimg/persta.png" onclick="location.href='/persta'" style="width:100%; line-height: 10px; cursor: pointer;"></li>
					</ul>
				</div>
				<div class="right-button">
					<ul style="width:175px;">
						<%if(m==null){ %>
							
							<li class="nav-item" style="width:30px; margin-left:0;">
								
							</li>
							<li class="nav-item" style="margin-left:20px;">
								<button class ="btn btn-dark" onclick="location.href='/views/member/login.jsp'">Login</button>
							</li>
							<li class="nav-item" style="margin-left:10px; cursor: pointer;">
								<img alt="" src="/headerimg/shoppingcart.png" onclick="location.href='/shoppingcart'" width="30px;">
							</li>
							
							<!-- 
							
							로그인 화면을 보고싶은데 맴버가 없다면 해당 주석을 풀고 위를 주석 하세요
							
							<li class="nav-item" style="margin-left:0;">
								<button class ="btn btn-dark">Logout</button>
							</li>
							<li class="nav-item" style="width:30px; margin-left:10px;">
								<img alt="" src="/headerimg/mypage.png" onclick="location.href='/mypage'" width="30px;" style="cursor: pointer;">
							</li>
							<li class="nav-item" style="margin-left:20px;">
								<img alt="" src="/headerimg/shoppingcart.png" onclick="location.href='/shoppingcart'" width="30px;" style="cursor: pointer;">
							</li>
							 -->
						<%}else{ %>
							<li class="nav-item" style="margin-left:0;">
								<button class ="btn btn-dark" onclick="location.href='/mypage?memberId=<%=m.getMemberId()%>'"><%=m.getMemberName() %></button>
							</li>
							<li class="nav-item" style="width:30px; margin-left:10px;">
								<img alt="" src="/headerimg/mypage.png" onclick="location.href='/mypage'" width="30px;" style="cursor: pointer;">
							</li>
							<li class="nav-item" style="margin-left:20px;">
								<img alt="" src="/headerimg/shoppingcart.png" onclick="location.href='/shoppingcart'" width="30px;" style="cursor: pointer;">
							</li>
						<%} %>
					</ul>
				</div>
 			</div>
		</nav>
	</header>