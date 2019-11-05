<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Twenty Second</title>
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.photo:last-child:after{
		clear: both;
	}
	.loader{
		position:absolute;
		left:50%;
		top:50%;
		z-index:1;
		width: 150px;
		height:150px;
		margin:-75px 0 0 -75px;
	}
	.search{
	display:inline-block;
	color:black;
	background-color:white;
	font-size: 14px;
	border: 1px solid black;
	padding: 3px 15px;
	text-align: center;
	line-height: 35px;
	margin: 0px 10px;
	font-weight: bold;
	}
	.search:hover {
	background-color: black;
	color:white;
	}
	
}
</style>
<body>
<!-- <img src = "/choiceimg/loading.gif" style = "position:absolute;  left:50%; top:50%; z-index:2;width: 150px;height:150px;margin:-75px 0 0 -75px;"> -->
	<script>
		function restart(path, index){
			//배열이면..
			
			if(path.length >= 2){
				console.log(path[0].name);
				$("input[name='"+path[0].name+"'][value='"+index+"']").attr("checked",false);
			}else{//배열 아니면
				console.log(path.name);
				$("input[name='"+path.name+"'][value='"+index+"']").attr("checked",false);
			}
			console.log(index);
			$("form").submit();
		}
	</script>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<section>
<div class = "loader"></div>
<!-- 여기에는 ArrayList<Perfume>형태, list 이름으로 퍼퓸리스트를 받았음 -->
	<div class = "div" style = "width : 1332px; margin : 0 auto;">
	<h2 style="color:black; padding: 30px 0px 10px 10px">추천된 향수</h2><hr>
		<c:choose>
		<c:when test="${empty list }">
			<form action="/knowStep" method="post">
			<p style = "display:inline-block; color:black; padding-left: 10px; font-size: 16px;">검색조건</p>
			<c:if test="${not empty q1 }">
				<c:forEach var="top" items="${q1 }" varStatus="status">
				<input type="checkbox" style="display: none" name = "q1" value="${top }" checked="checked">
				<input type="button" class="search" onclick="restart(q1,'${top }')" value = "top:${top }">
				</c:forEach>
			</c:if>
			<c:if test="${not empty q2 }">
				<c:forEach var="middle" items="${q2 }" varStatus="status">
				<input type="checkbox" style="display: none" name = "q2" value="${middle }" checked="checked">
				<input type="button" class="search" onclick="restart(q2,'${middle }')" value = "middle:${middle }">
				</c:forEach>
				</c:if>
			<c:if test="${not empty q3 }">
				<c:forEach var="base" items="${q3 }" varStatus="status">
				<input type="checkbox" style="display: none" name = "q3" value="${base }" checked="checked">
				<input type="button" class="search" onclick="restart(q3,'${base }')" value = "base:${base }">
				</c:forEach>
			</c:if>
			<c:if test="${not empty brand }">
				<input type="checkbox" style="display: none" name = "brand" value="${brand }" checked="checked">
				<input type="button" class="search" onclick="restart(brand,'${brand }')" value = "brand:${brand }">
			</c:if>
			<input type="checkbox" style="display: none" name = "q5" value="${q5 }" checked="checked">
			<input type="checkbox" style="display: none" name = "q6" value="${q6 }" checked="checked">
			</form>
		<p style="text-align: center; color:black; font-size: 24px; margin-top: 150px;">추천된 향수가 없습니다.</p>
		<div style = "width:100%; text-align: center;">
		<img src = "/choiceimg/nosearch.png" style = "width:150px; height:150px; margin-bottom: 100px;">
		</div>
		</c:when>
		<c:otherwise>
		<c:forEach var="p" items="${list }">
		<a href="/viewPerfume?perfumeNo=${p.perfumeNo }"><div class='photo' style='text-align:center; border:1px solid #F2F2F2; width:303px; margin:0 auto; margin-left:15px; margin-right:15px; margin-bottom:30px; padding-top:10px; padding-bottom:10px; float:left'>
           <img class="imghover" src='/upload/photo/${p.perfumePhotopath }' width='200px' height='200px'>
           <p class ='caption' style="color:#585858; margin-bottom:0px; padding-top:10px; font-weight:500;">${p.perfumeName }</p>
           <p class ='caption' style="color:#585858; margin-bottom:0px; font-weight:500;">${p.perfumeVolume } ml</p>
           <p class ='caption' style="color:#585858; font-size: 0.8em;">${p.perfumePrice }원</p>
           </div></a>
           </c:forEach>
		</c:otherwise>
		</c:choose>
    </div>
    <div style = "clear:both;"></div>
    </section>
	<%@ include file = "/WEB-INF/views/common/footer.jsp" %>

</body>
</html>