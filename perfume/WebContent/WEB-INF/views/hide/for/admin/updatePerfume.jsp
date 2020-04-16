<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
	<style>
		.inputbox {
	   		height: 50px;
	   		color: black;
	   		font-weight: 700;
	   		margin: 0 auto;
	   		padding-top:10px;
    	}
    	input{
    		background-color: transparent;
    		border: none;
    		border-bottom: 1px solid black;
    	}
    	.btn1 {
		    width:170px;
		    background-color: white;
		    color:black;
		    padding: 13px 0;
		    text-align: center;
		    display: inline-block;
		    font-size: 17px;
		    cursor: pointer;
		    margin-top: 20px;
		}
		.btn1:hover {
		    background-color: black;
		    color: white;
		    transition: .60s;
		}
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section style ="margin-top:60px;">
		<div class ="imgContainer" style="height:100px; text-align: center; font-size: 35px; line-height: 80px;">
			Admin Page
		</div>
		<div class ="wrapper">
			<div class="mb64 col-md-3"><%@include file ="/WEB-INF/views/hide/for/admin/adminpage_left_nav.jsp" %></div>
			<div class="thisPageCon" style="text-align:center; height: 530px;">
				<form action="/updatePerfumeFinish" method="post" enctype="multipart/form-data">
					<div>
						<img id='imgShow' width="200" height="200" src='/upload/photo/${perfume.perfumePhotopath }'>
					</div>
					<input type="hidden" name="perfumeNo" value=${perfume.perfumeNo }>
					<div class="inputbox">NAME　<input type="text" name="perfumeName" value=${perfume.perfumeName }></div>
					<div class="inputbox">PRICE　<input type="text" name="perfumePrice" value=${perfume.perfumePrice }></div>
					<div class="inputbox"><input style="border:none;" type="file" name="perfumePhotoname" onchange="imgChange(this);"></div>
					<div class="inputbox">DETAIL　<input style="width: 400px;" type="text" name="perfumeDetail" value=${perfume.perfumeDetail }></div>
					
					<!-- 이미지가 있을 경우 대비 -->
					<input type="hidden" name="oldFilename" value=${perfume.perfumePhotoname }>
					<input type="hidden" name="oldFilepath" value=${perfume.perfumePhotopath }>
					<input type="hidden" name="status" class= "status" value="stay">
					<div>
						<button type="submit" class="btn1" style="height: 52px;  border: 1px solid black;">수정</button>
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