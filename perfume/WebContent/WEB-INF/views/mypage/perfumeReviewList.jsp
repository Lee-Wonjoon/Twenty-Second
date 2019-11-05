<%@page import="fp.perfumereview.model.vo.PerfumeReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
	.perfume_review_list tbody{
		color: #585858;
		height : 40px;
		border-bottom: 1px solid #585858;
	}
	.perfume_review_list td{
		border-left: 1px solid #e8e8e8;
		border-right:1px solid #e8e8e8;
	}
	.perfume_review_list thead{
		background:#585858;
		height: 20px;
		font-size: 12px;
		color: #fff;
		text-align: center;
	}
	.perfume_review_date{
		font-size: 12px;
		width: 12%;
		line-height: 70px;
	}
	.perfume_review_product_name{
		font-style: oblique;
		font-size: 12px;
		line-height: 70px;
		width: 42%;
	}
	.perfume_review_title{
		width: 10%;
		font-size: 11px;
		line-height: 70px;
		text-align: center;
	}
	.perfume_review_content{
		font-size: 10px;
		padding: 0px 0px 0px 0px;
		width: 25%;
	}
	.perfume_review_button{
		font-size: 12px;
		line-height: 70px;
		width: 11%;
		text-align: center;
	}
	.perfume_review_img{
		width: 100px;
		height: 100px;
	}
	.payment_info_list td{
		line-height: 100px;
	}
	.perfume_review_list tbody{
		color: #585858;
		height : 40px;
		border-bottom: 1px solid #585858;
	}
	.perfume_review_list td{
		border-left: 1px solid #e8e8e8;
		border-right:1px solid #e8e8e8;
	}
	.perfume_review_list thead{
		background:#585858;
		height: 20px;
		font-size: 12px;
		color: #fff;
		text-align: center;
	}
	.hr-bold {
	    border-top: 1px solid #333;
	    opacity: 1 !important;
	}

</style>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section class="pt-xs-40">
		<div class="container">
			<div class="row">
				<!-- 왼쪽 메뉴 부분 시작 -->
				<div class="col-sm-4 col-md-3 mb64">
					<%@include file="/WEB-INF/views/mypage/common/mypage_left_nav.jsp" %>
				</div>	
				<!-- 왼쪽 메뉴 끝 -->
				<!-- 오른쪽 메뉴 시작 -->
				<div class="col-sm-8 col-md-8 col-md-offset-1">
					<h5 class="mb4">내가 작성한 리뷰 내역</h5>
					<c:if test="${perfumeReviewList.size() ==0 }">
					<hr class="hr-bold">
					<ul class="cart-list mb64">
						<li class="mt36"> 작성된 리뷰가 없습니다.</li>
					</ul>
					</c:if>
					<c:if test="${perfumeReviewList.size() !=0 }">
					<hr class="hr-bold">
					<table class="table perfume_review_list">
						<thead>
							<tr>
								<td>작성일</td><td>리뷰향수</td><td>제목</td><td>내용</td><td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${perfumeReviewList }" var="pr" varStatus="i">
							<tr>
								<td  rowspan="2" class="perfume_review_date">${pr.perfumeReviewDate }</td>
								<td>
									<a class="product" href="#" onclick="goProduct(this,'${pr.perfumeNo}');">
										<img class="perfume_review_img" alt="Twenty Second" src="/upload/photo/${pr.perfumePhotoPath }">
									</a>
								</td>
								<td  rowspan="2"class="perfume_review_title">${pr.perfumeReviewTitle }</td>
								<td  rowspan="2"class="perfume_review_content">${pr.perfumeReviewContent }</td>
								<td  rowspan="2"class="perfume_review_button">
									<input type="hidden" value="${pr.perfumeReviewNo }">
								</td>
							</tr>
							<tr class="perfume_review_product_name">
								<td>${pr.perfumeName }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>