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
					<input type="hidden" name="location" value="questionAdmin">
					<input type="hidden" name="table" value="question">
					<select name="area">
						<option value="question_No">문의번호</option>
						<option value="question_writer">문의작성자</option>
					</select>
					<button>검색</button>
				</form>
				<table border=1 style="width:100%;">
					<tr>
						<th>no</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>처리현황</th>
						<th>관리</th>
					</tr>
					<c:forEach items="${pd.list}" var="list" varStatus="i">
						<c:if test="${list.questionLevel==0}">
							<tr>
								<td>${list.questionNo}</td>
								<td>${list.questionTitle}</td>
								<td>${list.questionWriter}</td>
								<td>${list.questionDate}</td>
								<td>${list.questionStatus}</td>
								<td>
								<button type="button" onclick="location.href='/readQuestionAdmin?questionNo=${list.questionNo}&questionStatus=${list.questionStatus}'">확인하기</button>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<div id="pageNavi" >
					${pd.pageNavi}
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>