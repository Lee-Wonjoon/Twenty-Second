<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<style>
	.pCiBal{
		height:50px;
		text-overflow: clip;
	}
	
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class ="imgContainer" style="height:100px; text-align: center; font-size: 35px; line-height: 80px;">
			Admin Page
		</div>
		<div class ="wrapper">
			<div class="mb64 col-md-3"><%@include file ="/WEB-INF/views/hide/for/admin/adminpage_left_nav.jsp" %></div>
			<div class="thisPageCon">
				<form action="/searchAdmin" method=post>
					<input name="value">
					<input type="hidden" name="location" value="noticeAdmin">
					<input type="hidden" name="table" value="notice">
					<select name="area">
						<option value="notice_No">공지번호</option>
						<option value="notice_title">공지제목</option>
					</select>
					<button>검색</button>
					<a id="insertATagAdmin" onclick="location.href='/insertNoticeAdmin'">공지작성</a>
				</form>
				<table border=1 style="width:100%;">
					<tr>
						<th style="width:50px;">no</th>
						<th style="width:250px;">공지제목</th>
						<th>공지내용</th>
						<th style="width:100px;">공지일자</th>
						<th style="width:100px;">관리</th>
					</tr>
					<c:forEach items="${pd.list}" var="list" varStatus="i">
						<tr>
							<td class="findEasyMembNoAdmin">${list.noticeNo}</td>
							<td>${list.noticeTitle}</td>
							<td style="width:300px; overflow:auto;"><p class="pCiBal" style="line-height: 50px;">상세보기를 위해 클릭하세요.</p></td>
							<td>${list.noticeDate}</td>
							<td>
							<button type="button" class="modifyNotice">수정</button>
							<button type="button" class="deleteNotice">삭제</button>
							</td>
						</tr>
						<tr class= "noticeConTR" style="display:none">
								<td colspan=5>
									<c:choose>
										<c:when test='${!empty list.noticeContent }'>
											<pre style="padding:30px; white-space: pre-wrap;"><c:if test="${!empty list.filepath }"><img src="/upload/notice/${list.filepath }" style="max-width: 400px;"></c:if><br>${list.noticeContent }</pre>
										</c:when>
										<c:otherwise>
											<pre style="padding:30px;">공지 내용 없음 </pre>
										</c:otherwise>
									</c:choose>
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
		$(".deleteNotice").click(function(){
			if(confirm('정말로 공지를 삭제하시겠습니까?')){
				var membNo = $(this).parent().parent().children(".findEasyMembNoAdmin").html();
				location.href='/deleteNoticeAdmin?noticeNo='+membNo;
			}
		});
		$(".modifyNotice").click(function(){
			var membNo = $(this).parent().parent().children(".findEasyMembNoAdmin").html();
			location.href='/modifyNoticeAdmin?noticeNo='+membNo;
		});
		$("tr").click(function(){
			//$(".noticeConTR").css("display","none");
			$(this).next(".noticeConTR").toggle();
		});
	})
	</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>