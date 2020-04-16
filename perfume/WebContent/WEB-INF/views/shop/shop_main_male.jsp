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
	.imghover:hover{
		transform:scale(1.1);
		transition: transform .60s;
	}
	.a1{
		color:#BDBDBD;
		font-weight:500;
	}
	.a2{
		color:#BDBDBD;
		font-weight:300;
	}
	.a1:hover, .a2:hover{	
		color:#585858;
	}
	.input1{
		border: none;
    	background-color:#F5F5F5;
    	width: 150px;
   		height: 30px;
   		margin-bottom: 20px;
   		padding-left:10px;
   		color: #777777;
    }
    .selectbox{
    	border: none;
    	background-color:#F5F5F5;
    	width: 80px;
   		height: 30px;
   		text-align: center;
   		padding-left:10px;
   		color: #777777;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>	
	<section>
		<div class="table-wrapper" style="margin:0 auto; width:70%; text-align: center;">
			<div style="padding-bottom:40px; height:80px;">
				<a class="a1" href="/perfumeList">ALL</a>
				<a style="margin-left:30px; color:black;" class="a1" href="/perfumeListMale">MALE</a>
				<a style="margin-left:30px;" class="a1" href="/perfumeListFemale">FEMALE</a>
				<a style="margin-left:30px;" class="a1" href="/perfumeListUni">UNISEX</a>
			</div>
			
			<div style="width:100%; height:60px; margin:0 auto;">
				<p style="color:#585858; font-weight:700; font-size:1.8em;">BEST SELLER</p>
			</div>
			
			<div style="width:100%; height:360px;">
				<c:forEach items="${p }" var="p" varStatus="i">
					<div class='photo' style='border:1px solid #F2F2F2; width:303px; margin:0 auto; margin-left:15px; margin-right:15px; margin-bottom:30px; padding-top:10px; padding-bottom:10px; float:left'>
						<a href="/viewPerfume?perfumeNo=${p.perfumeNo }"><img class="imghover" src='/upload/photo/${p.perfumePhotopath }' width='200px' height='200px'></a>
						<p class ='caption' style="color:#585858;; margin-bottom:0px; padding-top:10px; font-weight:500;">${p.perfumeName }</p>
						<p style="color:#585858;; font-size: 0.5em; margin-bottom:0px;">${p.perfumeVolume }ml</p>
						<p style="color:#585858;; font-size: 0.8em;">${p.perfumePrice }원</p>
					</div>
				</c:forEach>
			</div>	
			
			<div style="width:100%; height:30px; text-align:right; padding-right:15px;">	
				<form action="/searchPerfumeMale" method=post>
					<c:if test="${!empty inputvalue}">					
						<c:if test="${selected eq 'perfume_name'}">
							<select name="selected" class="selectbox">
								<option value="perfume_name" selected>NAME</option>
								<option value="perfume_brand">BRAND</option>
							</select>
						</c:if>
						<c:if test="${selected eq 'perfume_brand'}">
							<select name="selected" class="selectbox">
								<option value="perfume_name">NAME</option>
								<option value="perfume_brand" selected>BRAND</option>
							</select>
						</c:if>
						<input name="inputvalue" class="input1" value="${inputvalue }">
					</c:if>
					<c:if test="${empty inputvalue}">
						
						<select name="selected" class="selectbox">
							<option value="perfume_name">NAME</option>
							<option value="perfume_brand">BRAND</option>
						</select>
						<input name="inputvalue" class="input1">
					</c:if>			
					<button style="background-color:transparent; border:none;"><img src="/img/searchicon.png"></button>
				</form>
			</div>	
			
			<div style="width:100%; height:30px; padding-top:50px; padding-bottom:50px; text-align:right; padding-right:20px;">			
				 <a class="a2" href="/perfumeList">최신순</a>
				 <span>｜</span>
				 <a class="a2" href="/perfumeList2">인기순</a>
			</div>		
			
			<div style="width:100%;">
				<c:forEach items="${pd.list }" var="p" varStatus="i">
					<div class='photo' style='border:1px solid #F2F2F2; width:303px; margin:0 auto; margin-left:15px; margin-right:15px; margin-bottom:30px; padding-top:10px; padding-bottom:10px; float:left'>
						<a href="/viewPerfume?perfumeNo=${p.perfumeNo }"><img class="imghover" src='/upload/photo/${p.perfumePhotopath }' width='200px' height='200px'></a>
						<p class ='caption' style="color:#585858;; margin-bottom:0px; padding-top:10px; font-weight:500;">${p.perfumeName }</p>
						<p style="color:#585858;; font-size: 0.5em; margin-bottom:0px;">${p.perfumeVolume }ml</p>
						<p style="color:#585858;; font-size: 0.8em;">${p.perfumePrice }원</p>
					</div>
				</c:forEach>
			</div>						
		</div>
	</section>
	<div id="pageNavi" style="clear:left; margin-bottom:20px;">
		${pd.pageNavi }
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
	</script>
</body>
</html>