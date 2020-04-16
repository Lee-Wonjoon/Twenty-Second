<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section style ="margin-top:60px;">
		<div class ="imgContainer" style="height:100px; text-align: center; font-size: 35px; line-height: 80px;">
			Admin Page
		</div>
		<div class ="wrapper">
			<div class="mb64 col-md-3"><%@include file ="/WEB-INF/views/hide/for/admin/adminpage_left_nav.jsp" %></div>
			<div class="thisPageCon">
				<form action="/searchAdmin" method=post>
					<input name="value">
					<input type="hidden" name="location" value="reviewAdmin">
					<input type="hidden" name="table" value="perfume_review">
					<select name="area">
						<option value="perfume_review_No">리뷰번호</option>
						<option value="perfume_No">향수번호</option>
						<option value="member_nickname">리뷰작성자</option>
					</select>
					<button>검색</button>
				</form>
				<table border=1 style="width:100%;">
					<tr>
						<th style="width: 10%;">no</th>
						<th style="width: 10%;">향수번호</th>
						<th style="width: 10%;">작성자</th>
						<th style="width: 40%;">내용</th>
						<th style="width: 20%;">게시일</th>
						<th style="width: 10%;">관리</th>
					</tr>
					<c:forEach items="${pd.list}" var="list" varStatus="i">
						<tr>
							<td>${list.perfumeReviewNo}</td>
							<td>${list.perfumeNo}</td>
							<td>${list.memberNickname }</td>
							<td>${list.perfumeReviewContent }</td>
							<td>${list.perfumeReviewDate }</td>
							<td>
							<button type="button" onclick="$.delReview(${list.perfumeReviewNo});">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="pageNavi" >
					${pd.pageNavi}
				</div>
				
			</div>
		</div>
	<script>
		$(document).ready(function(){
			$.delReview = function(val){
				if(confirm('정말로 삭제하시겠습니까?')){
					location.href='/deleteReviewAdmin?perfumeReviewNo='+val;
				}
			}
		})
	</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>