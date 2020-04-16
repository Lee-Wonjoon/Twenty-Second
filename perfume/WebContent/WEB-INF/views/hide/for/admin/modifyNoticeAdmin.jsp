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
				<form action="/modifyNoticeAdminSubmit" method="post" enctype="multipart/form-data">
					<div>
						공지번호 : <input name="noticeNo" value='${notice.noticeNo }' readonly="readonly" style="border:none;">
					</div>
					<div>
						공지제목 : <input name="noticeTitle" value='${notice.noticeTitle }'>
					</div>
					<hr>
					<div>
						파일변경 : <input name="filename" type=file onchange="imgChange(this);">
					</div>
					<div>
						미리보기 <br>
						<!-- 있다면 사진도 같이 넣어주는 것 해야함 -->
						<c:if test="${!empty notice.filepath }"><img id="imgShow" style="max-width: 400px;"src="/upload/notice/${notice.filepath }"></c:if><br>
						<textarea name ="noticeContent" style="min-width:600px; max-width:600px; min-height:200px; min-height:200px;">${notice.noticeContent }</textarea>
					</div>
					<hr>
					<div>
						<button type="submit">수정 완료</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script>
	function imgChange(f){
		$(".status").val("change");
		if(f.files.length != 0 && f.files[0]!=0){
			var reader = new FileReader();
			reader.readAsDataURL(f.files[0]) // 매개변수로 지정한 파일의 경로
			reader.onload = function(e){ // 파일 경로가 다 읽어지고 나면
				$("#imgShow").attr('src',e.target.result); // 읽어온 경로값을 src속성에 넣어줌 
			}
		}
	}
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>