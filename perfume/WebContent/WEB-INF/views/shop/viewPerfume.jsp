<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="/css/bootstrap.css">
   <link rel="stylesheet" href="/css/header/style.css">
   <link rel="stylesheet" href="/css/header/responsive.css">
   <script type="text/javascript" src="/js/bootstrap.js"></script>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view perfume</title>
<style>
   div.all {
        width: 100%;
        height: 500px;
    }
    div.left {
        width: 50%;
        height: 500px;  
        float: left;
        box-sizing: border-box;
    }
    div.right {
        width: 50%;
        height: 500px;
        float: right;
        box-sizing: border-box;
        padding-top: 70px;
        text-align: left;
    }
    .btn1 {
       width:170px;
       background-color: white;
       border: 1px solid black;;
       color:black;
       padding: 13px 0;
       text-align: center;
       display: inline-block;
       font-size: 17px;
       cursor: pointer;
       float:left;
   }
   .btn1:hover {
       background-color: black;
       color: white;
       transition: .60s;
   }
   div.taball {
        width: 100%;
        height: 100px;
    }
    #tableft {
        width: 50%;
        height: 40px;  
        float: left;
        box-sizing: border-box;
        background-color: black; 
        color: white;
        border: none;
        border-bottom: 1px solid black;
    }
    #tabright {
        width: 50%;
        height: 40px;
        float: right;
        box-sizing: border-box;
        background-color:white; 
        border: none;
        border-bottom: 1px solid black;
    }
    .hidden{
       display: none;
    }
    #amount{
       border: none;
       background-color:#F5F5F5;
       width: 340px;
         height: 50px;
         text-align: center;
         padding-left:10px;
         color: #777777;
    }
    .divreview {
       margin:0 auto;
    }
    .input1{
       border: none;
       background-color:#F5F5F5;
       width: 100%;
       height: 30px;
       padding-left:10px;
       color: #777777;
       font-weight: 300;
    }
    .textarea1{
       border: none;
       background-color:#F5F5F5;
       font-weight: 300;
       width: 100%;
       height: 53px;
       padding-left:10px;
       color: #777777;
    }
    .commentList{
         width: 100%;
         clear: both;
         border-top: 1px solid black;
         padding: 10px;
         overflow: hidden;
      }
      .commentList>li{
         float: left;
         color: black;
         padding-left: 10px;
         padding-right: 10px;
      }
      .a3{
         color:#BDBDBD;
      }
</style>   
</head>
<body>
   <%@ include file="/WEB-INF/views/common/header.jsp" %>   
   <section>
      <div style="margin:0 auto; width:50%; text-align: center;">
         <div class="divall">
              <div class="left">
                 <img src='/upload/photo/${perfume.perfumePhotopath }' width="400px">
              </div>
              <div class="right">
                 <form action="/insertBasket?perfumeNo=${perfume.perfumeNo }" method="post">
                       <input type="hidden" name="perfumePrice" value="${perfume.perfumePrice }">
                       <span style="color:black;">${perfume.perfumeBrand }</span><br>
                       <span style="color:black; font-size:25px;">${perfume.perfumeName }</span><br>
                     <span style="color:black; font-size:12px;display:block;margin-top:10px;">${perfume.perfumeVolume }ml</span><br>
                     <span style="color:black;">${perfume.perfumePrice }원</span><br><br>
                     <select id="amount" name="perfumeAmount">
                        <option value="0" hidden>수량 선택</option>
                        <option value="1">1개</option>
                        <option value="2">2개</option>
                        <option value="3">3개</option>
                        <option value="4">4개</option>
                        <option value="5">5개</option>
                     </select>
                     <br><br>
                     <button type="submit" class="btn1">장바구니</button>
                     <button type="button" class="btn1" style="background-color:black; color:white;" onclick="return paymentDirect(${perfume.perfumeNo});">구매하기</button>              
                    </form>
                 
               <form action="/insertPerfumeRecommend" method="post" style="float:left;">
                  <input type="hidden" name="memberNo" value="${sessionScope.member.memberNo }">
                  <input type="hidden" name="perfumeNo" value="${perfume.perfumeNo }">
                  <c:if test="${!empty sessionScope.member }">
                     <div style="float:left; padding-left:10px; position:relative;">
                        <c:if test="${empty pr }">                        
                           <button type="submit" name="heart" value="insert" id="heart1" style="border:none; padding:0px; width:40px; height:40px; background-color:transparent; position:absolute; top:-8px; right:-40px;"><img src ="/img/heart1.png"></button>                                                
                        </c:if>
                        <c:if test="${!empty pr }">
                           <button type="submit" name="heart" value="delete"id="heart2" style="border:none; padding:0px; width:40px; height:40px; background-color:transparent; position:absolute; top:-8px; right:-40px;"><img src ="/img/heart2.png"></button>
                        </c:if>                  
                     </div>                     
                  </c:if>                  
               </form>               
              </div>
          </div>
          <div style="clear:both; margin-bottom:130px;">
             <button id="tableft" class="clickcolor" onclick="leftclick();">제품 상세 정보</button>
             <button id="tabright" onclick="rightclick();">고객 후기</button>
          </div>
          <div id="tab1">
             <img src="${perfume.perfumeDetail} " >
             <img src="/img/detaillast.png" width="100%">
          </div>
          <div id="tab2" class="hidden" style="clear:both; height:1000px;">
             <div class="table-wrapper" style="margin:0 auto; width:100%;">          
               <div style="width:100%; margin:0 auto; text-align:center;">


                  
                   
                  <c:if test="${empty prlist }">
                     <div style="margin:0 auto; text-align:center;">
                        <span style="color:black; font-weight:300;">아직 작성된 리뷰가 없습니다.<br>첫번째 리뷰를 남겨주세요!<br><br></span>
                        <c:if test="${empty sessionScope.member }">
                           <span style="color:gray; font-weight:300;">로그인 후 작성 가능합니다.</span>
                        </c:if>
                     </div>
                  </c:if>
                   
                   
                   <c:if test="${!empty prlist }">
                     <div style="margin:0 auto; text-align:center;">
                        <c:if test="${empty sessionScope.member }">
                         <div style="width:170px; margin:0 auto; padding-top:15px; padding-bottom:40px;">
                           <span style="color:gray; font-weight:300;">로그인 후 작성 가능합니다.</span>
                        </div>                           
                       </c:if>
                     </div>
                  </c:if>

         

   
   
   <c:if test="${not empty sessionScope.member}">    <%-- 댓글 작성 시작 --%>
         <div class="comment-write" style="text-align:center; width:80%; margin:0 auto;">
            <form action="/insertPerfumeReview" method="post">
               <input type="hidden" name="memberNo" value="${sessionScope.member.memberNo }">
               <input type="hidden" name="memberNickname" value="${sessionScope.member.memberNickname }">
               <input type="hidden" name="perfumeNo" value="${perfume.perfumeNo }">
               <table class="table">
                  <tr style="border:none;">
                     <td width="80%" style="padding-left:0px;">
                        <input rows="1" class="textarea1" name="perfumeReviewContent"></input>
                     </td>
                     <td width="20%" style="padding-left:0px; padding-right:0px;">
                        <button type="submit" class="btn1" style="width:100%;">등록</button>
                     </td>
                  </tr>
               </table>
            </form>
         </div>
      </c:if> <%-- 댓글 작성 끝 --%>
      
      <div class="comment-wrapper" style="text-align:center; width:80%; margin: 0 auto; ">
         <c:forEach items="${prlist }" var="pr">
            <ul class="commentList">               
                  <li style="width: 30%; font-weight: 500; text-align: left; font-size:15px;"><span>${pr.memberNickname }</span></li>
                  <li style="width: 70%; text-align: right; font-size:10px;"><span>${pr.perfumeReviewDate }</span></li>
                  
                  <li style="width: 80%; text-align: left; font-size:15px;">
                     <span>${pr.perfumeReviewContent }</span>
                     <input type="text" name="perfumeReviewContent" class="textarea1" value="${pr.perfumeReviewContent }" style="display:none; margin-top:5px;">
                  </li>
                     <c:if test="${not empty sessionScope.member}">
                        <li style="width: 20%; text-align: right;">
                           <c:if test="${sessionScope.member.memberNo == pr.memberNo}">
                              <a href="javascript:void(0)" class="a3" onclick="modifyComment(this, '${pr.perfumeReviewNo }');">수정</a>
                              <a href="javascript:void(0)" class="a3" onclick="deleteComment(this, '${pr.perfumeReviewNo }');">  삭제</a>
                           </c:if>
                        </li>
                     </c:if>                  
               </ul>      
         </c:forEach>
      
                         
               </div><br>
                     
               
             </div>             
          </div>
         
      </div>
   </section>
   <%@ include file="/WEB-INF/views/common/footer.jsp" %>
   <script>
      $(function(){
         $('#non1').addClass('hidden');
         
         if(${!empty righttab }){
            $('#tab1').addClass('hidden');
             $('#tab2').removeClass('hidden');
             $("#tabright").css("background-color","black");
             $("#tabright").css("color","white");
             $("#tableft").css("background-color","white");
             $("#tableft").css("color","black");
         }   
      });
      
      function leftclick() {
         $('#tab2').addClass('hidden');
          $('#tab1').removeClass('hidden');
          $("#tableft").css("background-color","black");
          $("#tableft").css("color","white");
          $("#tabright").css("background-color","white");
          $("#tabright").css("color","black");
      }
      
      function rightclick() {
         $('#tab1').addClass('hidden');
          $('#tab2').removeClass('hidden');
          $("#tabright").css("background-color","black");
          $("#tabright").css("color","white");
          $("#tableft").css("background-color","white");
          $("#tableft").css("color","black");
      }
      
      $("#non2").click(function(){
         $('#non2').addClass('hidden');
         $('#non1').removeClass('hidden');
      });
      
      function paymentDirect(atr){
            var amount = $("#amount").val();
            if(amount == 0){
               alert("수량을 선택해주세요.")
               return;
            }
            location.href="/paymentDirect?perfumeNo="+atr+"&amount="+amount;
        }
      
   </script>
   
   <script>

      function modifyComment(obj, reviewNo) {
         $(obj).prev().hide();
         $(obj).html('수정완료');
         $(obj).attr('onclick', 'modifyComplete(this, "' + reviewNo + '")');
         $(obj).next().html('  취소');
         $(obj).next().attr('onclick', 'modifyCancle(this, "' + reviewNo + '")');
         $(obj).parent().parent().find('input').show();
         $(obj).parent().parent().find('input').prev().hide();
      }
      function modifyCancle(obj, reviewNo) {
         $(obj).prev().prev().show();
         $(obj).prev().html('수정');
         $(obj).prev().attr('onclick', 'modifyComment(this, "' + reviewNo + '")');
         $(obj).html('  삭제');
         $(obj).next().attr('onclick', 'deleteComment(this, "' + reviewNo + '")');
         $(obj).parent().parent().find('input').hide();
         $(obj).parent().parent().find('input').prev().show();
      }
      function modifyComplete(obj, reviewNo) {
         var form = $("<form action='perfumeReviewUpdate' method='post'></form>");
         form.append($("<input type='text' name='perfumeReviewNo' value='" + reviewNo + "'>"));
         form.append($("<input type='hidden' name='perfumeNo' value='" + ${perfume.perfumeNo} + "'>"));
         form.append($(obj).parent().parent().find('input'));
         $('body').append(form);
         form.submit();
      }
      function deleteComment(obj, reviewNo) {
         location.href= "/perfumeReviewDelete?perfumeReviewNo=" + reviewNo +"&perfumeNo=" + ${perfume.perfumeNo};
      }
   </script>
</body>
</html>