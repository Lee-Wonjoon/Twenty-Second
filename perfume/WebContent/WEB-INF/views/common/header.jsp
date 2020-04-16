<%@page import="fp.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
       Member m = (Member)session.getAttribute("member");
    %>
<!-- 앞으로 들어갈 클래스명들은 디자인을 위한 것일 뿐인게 많다. -->
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header/style.css">
<link rel="stylesheet" href="/css/header/responsive.css">
<link rel="stylesheet" type="text/css"
   href="https://fonts.googleapis.com/earlyaccess/notosanskr.css">
<script type="text/javascript" src="/js/bootstrap.js"></script>

<style>
.imgDivCs {
	matgin:0 auto;
	margin-left: 10%;
	margin-right: 10%;
	/* background-image: url("/headerimg/tempppp.png"); */
	background-size: cover;
	-webkit-filter: grayscale(85%);
	transition: opacity 0.3s;
	margin-bottom: 20px;
}
section {
   margin-top: 0;
}

.logo_h {
   padding-top: 10px;
}

#logofixer {
   padding-top: 10px;
}

#navbarSupportedContent {
   background-color: white;
}

* {
   font-family: 'Noto Sans KR', sans-serif;
}

#navbarSupportedContent .nav-item>a {
   font-style: normal;
   font-weight: bold;
   line-height: 46px;
   width:100%;
   height:100%;
   color: #1C1C1C;
   vertical-align: middle;
}
section{
	margin-top:100px !important;
}
</style>
<!-- doctype부터 어쩌구 이런거는 다 불러올 페이지에 있을 예정이므로 그냥 싹 다 지워도 됨.
불러오는 시점에선 이미 그것들 안에 둘러쌓여있을 것이므로. -->
<header class="header_area"
   style="height: 61px; position: fixed; background-color: white; top: 0px; border-bottom: 1px solid #ccc;">
   <nav class="navbar navbar-expand-lg navbar-light" style="height: 60px;">
      <div class="container" style="height: 60px;">
         <!-- '/'하나 하면 자기자신과 동일 -->
         <img src="/headerimg/twenty.png" width="220"
            onclick="location.href='/myIndex.jsp'" style="cursor: pointer;">
         <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="icon-bar" style="background: black;"></span> <span
               class="icon-bar" style="background: black;"></span> <span
               class="icon-bar" style="background: black;"></span>
         </button>
         <div class="collapse navbar-collapse offset"
            id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav ml-auto">
               <li class="nav-item"><a href="/perfumeList">SHOP</a></li>
               <li class="nav-item"><a href="/news">NEWS</a></li>
               <li class="nav-item"><a href="/views/faq.jsp">CS</a></li>
               <li class="nav-item"><img alt="" src="/headerimg/persta.png"
                  onclick="location.href='/reviewList'"
                  style="width: 149px; line-height: 10px; cursor: pointer;"></li>
            </ul>
         </div>
         <div class="right-button">
            <ul style="width: 180px;">
               <c:choose>
                  <c:when test="${empty member}">
                     <li class="nav-item" style="width: 30px; margin-left: 0;"></li>
                     <li class="nav-item" style="margin-left: 20px;">
                        <button class="btn btn-dark"
                           onclick="location.href='/views/member/login.jsp'">Login</button>
                     </li>
                     <li class="nav-item" style="margin-left: 10px; cursor: pointer;">
                        <img alt="" src="/headerimg/shoppingcart.png"
                        onclick="location.href='/basketList'" width="30px;">
                     </li>
                  </c:when>
                  <c:otherwise>
                     <li class="nav-item" style="margin-left: 0;">
                        <button class="btn btn-dark" onclick="location.href='/logout'">Logout</button>
                     </li>
                     <li class="nav-item" style="width: 30px; margin-left: 10px;">
                        <c:choose>
                           <c:when test="${member.memberId ne 'admin@'}">
                              <img alt="" src="/headerimg/mypage.png"
                                 onclick="location.href='/mypageMain'"
                                 width="30px;" style="cursor: pointer;">
                           </c:when>
                           <c:otherwise>
                              <img alt="" src="/headerimg/mypage.png"
                                 onclick="location.href='/memberAdmin'" width="30px;"
                                 style="cursor: pointer;">
                           </c:otherwise>
                        </c:choose>
                     </li>
                     <li class="nav-item" style="margin-left: 20px;"><img alt=""
                        src="/headerimg/shoppingcart.png"
                        onclick="location.href='/basketList'" width="30px;"
                        style="cursor: pointer;"></li>
                  </c:otherwise>
               </c:choose>
            </ul>
         </div>
      </div>
   </nav>
<script>
$(function(){
	if(${not empty hrefKakaoLogout}){
		
	}
	if(${not empty msg}){
		alert("${msg}");
	}
});
</script>
</header>