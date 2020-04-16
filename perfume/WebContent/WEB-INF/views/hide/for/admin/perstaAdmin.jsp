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
				<form action="/searchAdmin" method=post class="adminSrearchForm">
					<div class="searchAdminValue"><input name="value"></div>
					<input type="hidden" name="location" value="perstaAdmin">
					<input type="hidden" name="table" value="review">
					<div class="searchAdminSelect">
						<select name="area">
							<option value="review_No">리뷰번호</option>
							<option value="review_writer">작성자</option>
						</select>
					</div>
					<div class="searchAdminValue"><button>검색</button></div>
				</form>
				<table border=1 style="width:100%;">
					<tr>
						<th>no</th>
						<th>사진</th>
						<th>작성자</th>
						<th>좋아요</th>
						<th>해시태그</th>
						<th>관리</th>
					</tr>
					<c:forEach items="${pd.list}" var="list" varStatus="i">
						<tr>
							<td class="findEasyMembNoAdmin">${list.reviewNo}</td>
							<td><img src="/upload/review/${list.filepath}" style="width:100px;"></td>
							<td>${list.reviewWriter}</td>
							<td>${list.readcount}</td>
							<td>${list.hashtag}</td>
							<td>
								<form action="/delPerstaAdmin" method="get">
									<input type="hidden" name="reviewNo" value="${list.reviewNo }">
									<button type="submit" >삭제</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="pageNavi" >
					${pd.pageNavi }
				</div>
			</div>
		</div>
		<script>
		$(document).ready(function(){
			$(".membDelConBtn").click(function(){
				$(this).parent().parent().next().toggle();
			});
		})
		</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>