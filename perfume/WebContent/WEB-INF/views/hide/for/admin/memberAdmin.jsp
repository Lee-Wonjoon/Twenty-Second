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
					<input type="hidden" name="location" value="memberAdmin">
					<input type="hidden" name="table" value="member">
					<div class="searchAdminSelect">
						<select name="area">
							<option value="member_No">회원번호</option>
							<option value="member_Nickname">닉네임</option>
						</select>
					</div>
					<div class="searchAdminValue"><button>검색</button></div>
				</form>
				<table border=1 style="width:100%;">
					<tr>
						<th>no</th>
						<th>아이디</th>
						<th>닉네임</th>
						<th>생일</th>
						<th>연락처</th>
						<th>가입일</th>
						<th>상태</th>
						<th style="width:85px;">탈퇴 사유</th>
						<th>관리</th>
					</tr>
					<c:forEach items="${pd.list}" var="list" varStatus="i">
						<tr>
							<td class="findEasyMembNoAdmin">${list.memberNo}</td>
							<td>${list.memberId}</td>
							<td>${list.memberNickname}</td>
							<td>${list.memberBirth}</td>
							<td>${list.memberPhone}</td>
							<td>${list.memberEnrollDate}</td>
							<c:choose>
								<c:when test='${list.memberValid == "true"}'>
									<td style="color:red; text-decoration: line-through;">비활성</td>
									<td><button class="membDelConBtn">사유확인</button></td>
								</c:when>
								<c:when test='${list.memberValid == "false"}'>
									<td>활성</td>
									<td></td>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test='${list.memberValid.equals("true")}'>
								<td><button type="button" class="deactivateMemb">활성화</button></td>
								</c:when>
								<c:when test='${list.memberValid.equals("false")}'>
								<td><button type="button" class="activateMemb">비활성</button></td>
								</c:when>
							</c:choose>
						</tr>
						<c:if test='${list.memberValid.equals("true")}'>
							<tr style="display:none">
								<td colspan=9>
									<c:choose>
										<c:when test='${!empty list.memberDeleteContent }'>
											<pre style="padding:30px;">${list.memberDeleteContent }</pre>
										</c:when>
										<c:otherwise>
											<pre style="padding:30px;">탈퇴 사유 없음</pre>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<div id="pageNavi" >
					${pd.pageNavi }
				</div>
			</div>
		</div>
		<script>
		$(document).ready(function(){
			$(".activateMemb").click(function(){
				if(confirm('정말로 다음 계정을 비활성화 하시겠습니까?')){
					var membNo = $(this).parent().parent().children(".findEasyMembNoAdmin").html();
					location.href='/validMemberAdmin?memberNo='+membNo+'&valid=true';
				}
			});
			$(".deactivateMemb").click(function(){
				if(confirm('정말로 다음 계정을 활성화 하시겠습니까?')){
					var membNo = $(this).parent().parent().children(".findEasyMembNoAdmin").html();
					location.href='/validMemberAdmin?memberNo='+membNo+'&valid=false';
				}
			});
			$(".membDelConBtn").click(function(){
				$(this).parent().parent().next().toggle();
			});
		})
		</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>