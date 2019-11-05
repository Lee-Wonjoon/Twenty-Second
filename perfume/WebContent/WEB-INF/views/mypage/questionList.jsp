<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<style>
   .container .hoverTr:hover{
      background-color: #EEEEEE;
      cursor:pointer;
   }
   .file-divInmypage{
		background: #585858;
		width: 100%;
		color: #fff;
		text-align: center;
		font-size: 16px;
		height: 40px;
		line-height: 40px;
	}
	.test-Inmypage{
		width: 100%;
	}
</style>
</head>
<body>
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
               <h5 class="mb4">1:1 상담 내역</h5>
               <hr class="hr-bold">
               <span>상세 내용을 확인하기 위해 클릭하세요</span>
               <br><br>
               <c:choose>
                  <c:when test="${!empty list}">
                     <table style="border: none; width:100%;" class="cart-list">
                        <tr>
                           <td style="color:black; width:10%;">문의번호</td>
                           <td style="color:black; width:60%;">문의제목</td>
                           <td style="color:black; width:20%;">문의날자</td>
                           <td style="color:black; width:10%;">문의상태</td>
                        </tr>
                        <c:forEach items="${list }" var="list" varStatus="i">
                           <tr class="hoverTr" style="border-top: 1px solid black; height:50px;">
                              <td style="padding-left:20px;">${size - i.index}</td>
                              <td>${list.questionTitle }</td>
                              <td>${list.questionDate }</td>
                              <td>${list.questionStatus }</td>
                           </tr>
                           <tr style="display:none; border-top: 1px solid black; border-bottom: 1px solid black;">
                              <td colspan=4>
                                 <div style="padding:20px;">
                                    문의 내역<hr style="border-top:1px solid #888888;"><pre style="padding:5px; font-size: 15px;"><c:if test="${!empty list.filepath }"><img src="/upload/question/${list.filepath }" style="max-width: 400px;"></c:if><br>${list.questionContent }</pre>
                                    <c:forEach items="${ans }" var="ans" varStatus="j">
                                       <c:if test="${ans.questionRel eq list.questionNo}">
                                          <div style="padding:20px; margin-top:50px; margin-left:5%; border-top:1px solid black;border-bottom: 1px solid black;">
                                             답변 내역<hr style="border-top:1px solid #888888;"><pre style="font-size: 13px; padding:5px;"><c:if test="${!empty ans.filepath }"><img src="/upload/answer/${ans.filepath }" style="max-width: 400px;"></c:if><br>${ans.questionTitle }<br><br>${ans.questionContent }</pre>
                                          </div>
                                       </c:if>
                                    </c:forEach>
                                 </div>
                                 <button class="btn btn-outline-dark closeQuestionAnswerBtn" style="float:right; margin-right:50px; border:1px solid black; margin-bottom: 20px; wid">닫기</button>
                              </td>
                           </tr>
                           
                        </c:forEach>
                     </table>
                  </c:when>
                  <c:otherwise><div>1:1 상담 내역이 없습니다.</div></c:otherwise>
               </c:choose>
               <h5 class="mb4 mt64">1:1 상담 하기</h5>
               <hr class="hr-bold">
               <form class="new_question" id="new_question" enctype="multipart/form-data" action="/writeQuestion" method="post">
                  <input class="form-control" name="questionTitle" placeholder="문의 제목" style="width:100%; padding:10px; font-size: 15px;"><br>
                  <textarea class="form-control" placeholder="문의 내용" rows="4" name="questionContent" id="questionContent" style="width:100%;resize: none;"></textarea><br>
                  <div>
						<p id="file-nameInmypage">파일명 : </p>
						<input class="inputfile inputfile-6" type="file" name="filename" id="inquiry_attachments" style="display: none;">
						<label class="test-Inmypage" for="inquiry_attachments">
							<div class="file-divInmypage">파일올리기</div>
						</label>
					</div>
                  <br>
                  <div>
                     <button class="btn btn-outline-dark" style="width: 100%">문의하기</button>
                  </div>
                  <br><br><br>
               </form>
            </div>
         </div>
      </div>
   <script>
   $(document).ready(function(){
		$("#inquiry_attachments").change(function(){
			
			$("#file-nameInmypage").html("파일명 : " + $("#inquiry_attachments").val().substr(12));
		});
	});
      $(function(){
         $(".hoverTr").click(function(){
            $(".hoverTr").toggle();
            $(this).toggle();
            $(this).next().toggle();
         });
         $(".closeQuestionAnswerBtn").click(function(){
            $(".hoverTr").toggle();
            $(this).parent().parent().prev().toggle();
            $(this).parent().parent().toggle();
         });
         $(".new_question").submit(function(e){
            if($.trim($(this).children("input").val()).length == 0){
               alert("문의글의 제목을 작성해주세요.");
               return false;
            }else if($.trim($(this).children("textarea").val()).length == 0){
               alert("문의글의 내용을 작성해주세요.");
               return false;
            }
         });
      });
   </script>
   </section>
   <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>