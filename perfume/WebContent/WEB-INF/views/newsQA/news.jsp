<%@page import="fp.notice.models.vo.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%-- <%
    	PageData pd = (PageData)request.getAttribute("pd");
    %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	*{
		box-sizing: border-box;
	}
	.tap>div{
		float: left;
		width: 15%;
		/* border: 1px solid gray; */
		height: 60px;
		text-align: center;
		line-height: 60px;
		display: inline-block;
		font-size: 20px;
	}
	/* .wrapper>.1_1_con, .wrapper>.notice_con{
		display:none;
	} */
	/* .wrapper *{
		border: 1px solid gray;
	} */
	.wrapper>.FAQ_con{
		float: none;
	}
	.cs, .FAQ{
		color: gray;
	}
	.notice{
		color: black;
	}
	.wrapper>.tap{
		border-bottom: 1px solid black;
	}
	.tap>span{
		width:1px;
		height: 40px;
		background-color: gray;
		line-height: 40px;
		float:left;
		margin-top: 10px;
	}
	.notice_list{
		margin-left: 0px;
		margin-bottom: 50px;
		padding:1%;
		
	}
	.notice_list>li{
		height:44px;
		border-bottom: 1px solid #ccc;
		display: block;
	}
	.notice_list>li>span{
		display: inline-block;
		
	}
	/* .notice_con span:nth-of-type(0){
		width:8%;
	}
	.notice_con span:nth-of-type(1){
		width:54%;
	}
	.notice_con span:nth-of-type(2){
		width:20%;
	}
	.notice_con span:nth-of-type(3){
		width:14%;
	} */
	.notice_view>p, .notice_view>pre{
		margin-bottom:20px;
		line-height: 24px;
	    font-size: 14px;
	    font-family: "Roboto", sans-serif;
	    font-weight: normal;
	    color: #888888;
	    white-space: pre-wrap;
	}
	#pageNavi{
		text-align: center;
		width:80%;
		margin:0 auto;
		margin-bottom: 50px;
	}
	#pageNavi>*{
		margin: 10px;
		padding: 0.375rem 0.75rem;
	}
	.selectPage{
		font-size:18px;
		color:#888888;
	}
	.btn{
		font-color: #888888;
		font-family: "Roboto", sans-serif;
		font-size:15px;
	}
</style>
<title>News</title>
</head>
<body>
	<%@ include file= "/WEB-INF/views/common/header.jsp" %>
	<section style="margin-top:62px;">
		<div class="imgDivCs" style="margin-top:-40px;"> <img src="/headerimg/tempppp.png" style="width:122%; height:90%;"></div>
		<div class="wrapper" style="margin:0 auto; width:50%; /* border:1px solid gray;  */min-width: 600px;">
			<div class="tap" style="height:60px;">
				<div class="FAQ" onclick="location.href='/views/faq.jsp'" style="cursor:pointer;" >FAQ</div><!-- <span></span> --><div class="cs" onclick="location.href='/personalCs?memberId=${sessionScope.member.memberId}'" style="cursor:pointer;">1:1문의</div><!-- <span></span> --><div class="notice">NOTICE</div>
			</div>
			<div class="notice_con">
				<p style="margin-top: 10px;">공지사항, 이벤트, 뉴스 등 파펨의 소식을 확인하세요!<br>- 해당 제목을 클릭하면 자세한 내용을 확인 할 수 있습니다.</p>
				<div class = "csContent">
					<ul class="notice_list">
						<c:forEach items="${pd.list}" var="list" varStatus="i">
							<li class="onclickClass" style="color:#333333;">
								<span style="width:8%; height:40px; line-height: 40px; cursor:pointer; ">${list.noticeNo}.</span>
								<span style="width:54%; height:40px; line-height: 40px; cursor:pointer; ">${list.noticeTitle}</span>
								<span style="width:20%; height:40px; line-height: 40px; text-align: center;">${list.noticeDate}</span>
								<span style="width:14%; height:40px; line-height: 40px; text-align: right;">${list.noticeWriter}</span>
							</li>
							<div class= "notice_view" style="display:none;">
								<p>안녕하세요 두번째 스무살입니다.</p>
								<pre>${list.noticeContent}</pre>
								<br>
								<div style="margin:0 auto">
									<button style="border:1px solid #ccc; border-radius:10px; background-color: white; color: #888888; margin-left:42%;" class="returnFunc">돌아가기</button>
								</div>
							</div>
						</c:forEach>
					</ul>
					<div id="pageNavi" >
						${pd.pageNavi}
					</div>
				</div>
			</div> 
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$(".onclickClass").click(function(){
			$(".notice_list").children("li").toggle();
			$(this).toggle();
			$(this).next().fadeToggle();
			$("#pageNavi").toggle();
		});
		$(".returnFunc").click(function(){
			$(".notice_list").children("li").toggle();
			$(this).parent().parent().toggle();
			$("#pageNavi").toggle();
		});
		//location.href='/newsView?noticeNo=${list.noticeNo}
	</script>
</body>
</html>	