<%@page import="fp.perfume.model.vo.Perfume"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>shop_main</title>
<style>
	#pageNavi{
		text-align: center;
		width: 100%;
		margin: 0 auto;
	}
	#pageNavi>*{
		margin: 10px;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>	
	<section>
		<style>
			a{
				color:black;
			}
		</style>
		<div class="table-wrapper" style="margin:0 auto; width:70%; text-align: center;">
			<div style="padding-bottom:40px; height:80px;">
				<a href="/perfumeList">전체향수</a>
				<a style="margin-left:30px;" href="/perfumeListMan">남자향수</a>
				<a style="margin-left:30px;" href="/perfumeListWoman">여자향수</a>
			</div>
			
			<div style="width:100%; height:60px;">
				<img src="/img/rank.png" id="heart1" width="40px">
			</div>
			
			<div style="width:100%; height:360px;">
				<c:forEach items="${p }" var="p" varStatus="i">
					<div class='photo' style='width:24%; margin:0 auto; margin-left:10px; margin-bottom:10px; float:left'>
						<a href="/viewPerfume?perfumeNo=${p.perfumeNo }"><img src='/upload/photo/${p.perfumePhotopath }' width='100%'></a>
						<p class ='caption'>${p.perfumeName }</p>
					</div>
				</c:forEach>
			</div>		
			
			<div style="width:100%; height:30px; padding-top:50px; padding-bottom:50px; text-align:right; padding-right:20px;">			
				 <a href="/perfumeListMan">최신순</a>
				 <a href="/perfumeListMan2">인기순</a>
			</div>			
			
			<div style="width:100%; height:1470px;">
				<c:forEach items="${pd.list }" var="p" varStatus="i">
					<div class='photo' style='width:24%; margin:0 auto; margin-left:10px; margin-bottom:10px; float:left'>
						<a href="/viewPerfume?perfumeNo=${p.perfumeNo }"><img src='/upload/photo/${p.perfumePhotopath }' width='100%'></a>
						<p class ='caption'>${p.perfumeName }</p>
					</div>
				</c:forEach>
			</div>						
		</div>
	</section>
	<div id="pageNavi" style="clear:left;">
		${pd.pageNavi }
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
	</script>
</body>
</html>