<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<style>
	.additionalBtn{
		border: 1px solid rgb(169, 169, 169); height: 30px; display: inline-block; padding-left: 5px; padding-right: 5px; color: black; float: right;
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
			<div class="thisPageCon">
				<form action="/searchAdmin" method=post>
					<input name="value">
					<input type="hidden" name="location" value="listAdmin">
					<input type="hidden" name="table" value="perfume left join stock on (perfume_no = stock_perfume_no)">
					<select name="area">
						<option value="perfume_No">향수번호</option>
						<option value="perfume_name">향수이름</option>
						<option value="perfume_brand">향수브랜드</option>
					</select>
					<button>검색</button>
					<a id="insertATagAdmin" onclick="location.href='/views/perfume/insertPerfume.jsp'">상품추가</a>
					<button type="button" class="additionalBtn changeToStockOption">재고관리</button>
				</form>
				<!-- 링크 임시값임 -->
				<table border=1 style="width:100%;">
					<tr>
						<th>no</th>
						<th style="width:100px;">이미지</th>
						<th>향수 이름</th>
						<th>브랜드</th>
						<th>용량</th>
						<th>가격</th>
						<th>재고</th>
						<th>관리</th>
					</tr>
					<c:forEach items="${pd.list}" var="list" varStatus="i">
						<tr>
							<td>${list.perfumeNo}</td>
							<td>
								<c:if test="${!empty list.perfumePhotopath }">
								<img src='/upload/photo/${list.perfumePhotopath}'>
								</c:if>
							</td>
							<td>${list.perfumeName }</td>
							<td>${list.perfumeBrand }</td>
							<td>${list.perfumeVolume }</td>
							<td>${list.perfumePrice }</td>
							<td style="width:61px;">
								<p class="convertOption stockAmount" style="display:inline;">${list.stock }</p>
								<button style="display:none;" class="convertOption stockIn">입고</button><br><button style="display:none; margin-top:10px;" class="convertOption stockOut">출고</button>
								<input type="hidden" class="hiddenInp" value="${list.perfumeNo }">
							</td>
							<td>
								<button type="button" onclick="location.href='/updatePerfume?perfumeNo=${list.perfumeNo}'">수정</button>
								<button type="button" onclick="$.delPerfume(${list.perfumeNo});">삭제</button>
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
			$.delPerfume = function(val){
				if(confirm('정말로 삭제하시겠습니까?')){
					location.href='/deletePerfume?perfumeNo='+val;
				}
			}
			$(".changeToStockOption").click(function(){
				$(".convertOption").toggle();
			});
			$(".stockIn").click(function(){
				var amount = prompt( '입고량 : ', '');
				var thisT = $(this); 
				var perfumeNo = $(this).parent().children("input").val();
				$.ajax({
        			url : "/updateStock",
        			data : {type : "in", amount : amount, perfumeNo : perfumeNo},
        			type : "get",
        			dataType : "json",
        			success : function(data){
        				thisT.parent().children("p").html(data);
        			}
        		});
				$(".convertOption").toggle();
			});
			$(".stockOut").click(function(){
				var amount = prompt( '출고량 : ', '');
				var thisT = $(this); 
				var perfumeNo = $(this).parent().children("input").val();
				$.ajax({
        			url : "/updateStock",
        			data : {type : "out", amount : amount, perfumeNo : perfumeNo},
        			type : "get",
        			dataType : "json",
        			success : function(data){
        				thisT.parent().children("p").html(data);
        			}
        		});
				$(".convertOption").toggle();
			});
		})
	</script>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>