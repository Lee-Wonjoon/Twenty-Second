<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perstagram</title>
<link rel="stylesheet" type="text/css" href="/css/slick.css">
<link rel="stylesheet" type="text/css" href="/css/slick-theme.css">
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="/js/slick.min.js"></script>
<link href="/js/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-ui.js"></script>
<style>

   .slick-next:before {
       content:url("/img/오른쪽.png"); 
   }
   .slick-prev:before {
       content:url("/img/왼쪽.png"); 
   }
   *{
      box-sizing: border-box;
      color:black;
   }
   #search{
      width:56%;
      height:70px;
      text-align:center;
      margin-left:22%;
      margin-right:22%;
   }
   #search a{
      float:right;
   }
   #tab{
      width:56%;
      height:30px;
      cursor: pointer;
      color:black;
      font-weight:bold;
      margin-left:22%;
      margin-right:22%;
   }
   #tab>ul{
      float:right;
      text-align:center;
      height:10px;
   }
   #tab>ul>li{
      height:30px;
      padding:2px;
      float:left;
   }
   #content{
      width:100%;
        height:1200px;
      /* border:1px solid black; */
   }
   #content1{
      width:56%;
      height:95%;
        /* border:1px solid blue; */
      margin-right:22%;
      margin-left:22%;
   }
   
   #content2{
      width:56%;
        /* height:95%; */
      /* border:1px solid blue; */
      margin-right:22%;
      margin-left:22%;
   }   
   .reviewCon{
      width:33.3%;
      height:400px;
      border:5px solid white;
      float:left;
      cursor:pointer;
   }
   .reviewCon>div:first-child{
      width:100%;
      height:80%;
      /* border:1px solid green; */
   }
   .reviewCon>div:nth-child(2){
      width:100%;
      height:10%;
      border:1px solid lightgray;
   }
   .reviewCon>div:last-child{
      width:100%;
      height:10%;
      border:1px solid lightgray;
   }
   .heart{
      width:25px;
      height:25px;
      float:right;
      margin-top:5px;
      margin-right:5px;      
      cursor:pointer;
   }   
   .heart1{
      width:25px;
      height:25px;
      float:right;
      margin-top:5px;
      margin-right:5px;      
      cursor:pointer;
   }
   .heart2{
      width:25px;
      height:25px;
      float:right;
      margin-top:5px;
      margin-right:5px;      
      cursor:pointer;
   }

   .recommend{
      width:25px;
      height:25px;
      font-size:17px;
      text-align:center;
      float:right;
      margin-top:5px;
      margin-right:2px;
   }
   #content2{
      display:none;
   }
   #upload2{
      display:none;
   }
   input,textarea:focus{
        outline:none;
   }
   #Write_modal{
      width:100%;
      text-align:center;
      margin:0 auto;
   }
   #contentForm{
      width:100%;
      height:600px;
      margin-top:5%;
      margin-bottom:5%;
      text-align:center;   
   }
   .write_tab{
      width:100%;
      height:100%;
      margin:0 auto;
   }
   #hash_input{
      float:left; 
      margin-right:10px;
   }
   #regist{
      float:left;
      padding-top:3px;
   }
   #hash{
      margin-right:10px;
      color:blue;
      font-weight:bold;
   }
   #upload{
      display:none;
   }
/*    #imgView{
      display:none;
   } */
   .commentList{
      width:100%;
      clear:both;
      border:1px solid #ccc;
      border-radius: 5px;
      overflow:hidden;
   }
   .commentList>li{
      float:left;
      color:black;
      font-weight: bold;
   }
   .comment-wrapper table{
      width:100%;
      text-align:center;
   }
   #detail_btn{
      border-right:1px solid white;
      border-left:1px solid white;
      border-bottom:1px solid white;
   }
</style>
</head>
<body>
   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <section style="margin-top:80px;">
      <div id="search">
      <form action="/reviewSearch" style="margin-top:20px;">
         <img src="/img/hash.png" width="19px;" style="position:absolute; z-index:1; margin-top:8px; margin-left:3px;"/>
         <input type="text" name="search_txt" style="position:relative;width:300px; text-indent:19px;border-radius:10px;margin-right:5px;" id="searchTxt">
         <button type="submit" class="btn btn-outline-dark" id="searchBtn">검색</button>
         <c:if test="${not empty sessionScope.member.memberId}">
         <button type="button" id="writeBtn" class="btn btn-outline-dark" data-toggle="modal" data-target="#myModal_write" style="float:right;">글쓰기</button>
         </c:if>
      </form>
      </div>   <!-- 검색부분 -->
      <div id="tab">
         <ul>
            <li id="tab1">최신순 |</li>
            <li id="tab2">추천순</li>
         </ul>      
      </div>
         <div id="content"> <!-- content 부분 -->
            <div id="content1" class= "your-class">
               <c:forEach items="${review}" var="r" varStatus="i">
                  <input type="hidden" value=i>
                  <c:if test="${i.count%9 == 1}">
                     <div>
                  </c:if>   
                     <div class="reviewCon">
                        <div style="position: relative;">
                        <img style="width:100%; height:100%; cursor:pointer;" class="imgClick" id="imgList${r.reviewNo}" src="/upload/review/${r.filepath}" onclick="detail_Load(${r.reviewNo})" data-toggle="modal" data-target="#myModal_detail">
                        </div>
                        <div>
                        <input type="hidden" id="reviewNum" value="${r.reviewNo}">
                           <c:set var="checkHeart" value="0"></c:set>
                           <c:forEach items="${recommend}" var="rec" varStatus="j">
                              <c:if test="${r.reviewNo eq rec.reviewNo && rec.memberNo eq sessionScope.member.memberNo }">
                                 <img id="heartOff${r.reviewNo }" src="/img/빈하트.png" class="heart1" style="display:none;">
                                 <img id="heartON${r.reviewNo }" src="/img/빨간하트.png" class="heart2" value="${r.reviewNo}">
                                 <c:set var="checkHeart" value="1"></c:set>
                              </c:if>   
                           </c:forEach>
                           <c:if test="${checkHeart ne 1 }">
                              <img id="heartOff${r.reviewNo }" src="/img/빈하트.png" class="heart1">
                              <img id="heartON${r.reviewNo }" src="/img/빨간하트.png" class="heart2" value="${r.reviewNo}" style="display:none;">
                           </c:if>
                        <span class="recommend" id="recom_name${r.reviewNo}">${r.readcount}</span>
                        </div>
                        <div style="line-height:40px;"><span style="color:blue;margin-left:10px;">${r.hashtag}</span></div>
                     </div>
                  <c:if test="${i.count%9==0 || i.last == true}">
                     </div>
                  </c:if>      
               </c:forEach>   
            </div>
         </div>
         
  <!-- The Modal(글쓰기) -->
  <div class="modal fade" id="myModal_write">
    <div class="modal-dialog modal-dialog-centered modal-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header" style="border:none;">
          <h4 class="modal-title"></h4>
          <button type="button" onclick="WriteClose();" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body modal-open" style="overflow:hidden;">
          <div id="Write_modal">
            <form action="/reviewWrite" method="post" enctype="multipart/form-data" onSubmit="return ReviewRegist()" id="contentForm" name="contentForm">
               <table border="1" style=text-align:center; class="write_tab">   
                  <tr>
                     <td rowspan=7 style="width:60%;height:100%;">
                  <input type = "hidden" id="imgChangeFlag" value ="N">
                        <input type="file" name="filename" onchange="loadImg(this)" id="upload">
                        <label for="upload" style="cursor:pointer;"><img src="/img/플러스.jpg" id="imgView" onClick="imgChangeYN()"></label>
                        <!-- <img id="imgView"> -->   <!-- 이미지 미리보기 -->
                     </td>
                     <td style="height:7%;text-align:left;font-weight:bold;"><img src="/img/man.png" style="width:29px;height:29px;margin-left:2px;margin-right:5px;">${sessionScope.member.memberNickname}
                        <input type="hidden" name="reviewWriter" value="${sessionScope.member.memberNickname}">
                     </td>
                  </tr>
                  <tr style="font-weight:bold;">
                     <td style="height:7%;text-align:left;"><img src="/img/content.png" style="width:25px;height:25px;margin-left:5px;margin-right:5px;">리뷰작성</td>
                  </tr>
                  <tr>
                     <td style="height:55%;"><textarea name="reviewContent" id="reviewContent" rows="13" cols="40" style="border:none;resize:none;"></textarea></td>
                  </tr>
                  <tr style="font-weight:bold;">
                     <td style="height:7%;text-align:left;"><img src="/img/speech-bubble.png" style="width:25px;height:25px;margin-left:5px;margin-right:5px;">해쉬태그작성</td>
                  </tr>
                  <tr>
                     <td style="height:10%;text-align:left;">
                        <input type="text" id="hash_input" >                        
                        <a href="javascript:hash_regist()" id="regist">등록</a>
                     </td>
                  </tr>
                  <tr>   
                     <td style="height:7%;text-align:left;">      
                        <span id="hash"></span>
                        <input type="hidden" id="hashVal" name="hashtag"></input>
                        <input type="hidden" id="hashCnt" name="hashtagCnt" value="1"></input>
                     </td>
                  </tr>
                  <tr>
                     <td><button type="submit" class="btn btn-outline-dark">등록하기</button></td>
                  </tr>
               </table>
            </form>
            </div>
           </div>
        
<!--            Modal footer
           <div class="modal-footer">
             <button type="button" onclick="WriteClose()" class="btn btn-secondary" data-dismiss="modal">Close</button>
           </div>
         -->
      </div>
    </div>
  </div>

  <!-- The Modal(상세보기) -->
  <div class="modal fade" id="myModal_detail">
    <div class="modal-dialog modal-dialog-centered modal-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header" style="border:none;">
          <h4 class="modal-title"></h4>
          <button type="button" class="close" onClick="WriteClose()" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body modal-open" style="overflow:hidden;">
              <div id="Detail_modal">
      <table border="1px solid lightgrey" style=text-align:center; class="detail_tab">
         <tr>
            <td colspan="2" style="height:30%; padding-bottom:5px;">
               <img src="/img/빈하트.png" class="heart1">
               <img src="/img/빨간하트.png" class="heart2">
            </td>
         </tr>
         
         <tr>
            <td rowspan=3 style="width:60%;">                     
               <img id="imgView2">   <!-- 이미지 미리보기 -->
            </td>
            <td style="height:15%;text-align:left;font-weight:bold;"><img src="/img/man.png" style="width:29px;height:29px;margin-left:2px;margin-right:5px;">
               <span id="Nick_detail"></span>               
            </td>
         </tr>
         <tr>
            <td style="height:40%;">
            <textarea name="detailContent" id="detailContent" rows="14" cols="40" style="border:none;resize:none;" readonly="readonly">
            </textarea>
            </td>
         </tr>
         <tr>   
            <td style="height:20%;text-align:left;">
            <span id="hash_detail" style="color:blue;"></span>
            </td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:left;">
            <!-- 댓글 -->
               <div class="comment-write" style="width:100%;margin:0 auto;float:left;">
                  <form action="/reviewCommentInsert" method="post">
                  <input type="hidden" name="reviewCommentWriter" id="CommentWriter" value="${sessionScope.member.memberNickname }">
                  <input type="hidden" name="reviewRef" id="rNo2">
                  <input type="hidden" name="reviewWrtier" id="rw">
                  <table class="table" style="float:left;">
                     <tr>
                        <td>
                           <textarea rows="1" id="comment_Write" class="form-control" name="reviewCommentContent" style="resize:none;border-radius:10px;"></textarea>
                        </td>
                        <td width="80px">
                           <button type="button" class="btn btn-dark" id="comment_In">등록</button>
                        </td>
                     </tr>
                  </table>
                  <div class="comment-wrapper" style=" margin:0 auto;" id="comment_print">
                  </div>
               </form>
            </div>
         </td>   
      </tr>
      <tr id="detail_btn" style="display:none;">
         <td colspan="2" style="height:30%;border:none;"">
            <button id="deleteBtn" class="btn btn-outline-dark" style="float:right;margin-top:15px;">삭제하기</button>
            <button id="updateBtn" class="btn btn-outline-dark" style="float:right;margin-right:5px;margin-top:15px;" data-dismiss="modal" data-toggle="modal" data-target="#myModal_modify">수정하기</button>
         </td>
      </tr>
      </table>
      </div>
        </div>
        
<!--         Modal footer
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div> -->    
      </div>
    </div>
  </div>
  
  <!-- The Modal(수정하기) -->
  <div class="modal fade" id="myModal_modify">
    <div class="modal-dialog modal-dialog-centered modal-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header" style="border:none;">
          <h4 class="modal-title"></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body modal-open" style="overflow:hidden;">
              <div id="modify">
      <form action="/reviewUpdate" method="post" enctype="multipart/form-data" id="contentForm2">
         <table border="1" style=text-align:center; class="write_tab">   
            <tr>
               <td rowspan=7 style="width:60%;height:100%;">
                     <input type="file" name="filename2" onchange="up_loadImg(this)" id="upload2">
                     <label for="upload2" style="cursor:pointer;float:left;"><img src="/img/업로드버튼.png" id="imgView3"></label>
                     <!-- <img id="imgView3"> -->   <!-- 이미지 미리보기 -->                  
                     <input type="hidden" id="oldFileName" name="oldFileName">
                     <input type="hidden" id="oldFilePath" name="oldFilePath">
               </td>
               <td style="height:38px;text-align:left;font-weight:bold;">
                  <img src="/img/man.png" style="width:29px;height:29px;margin-left:2px;margin-right:5px;">
                  <span id="Nick_detail2"></span>
               </td>
            </tr>
            <tr style="font-weight:bold;">
               <td style="height:38px;text-align:left;"><img src="/img/content.png" style="width:25px;height:25px;margin-left:5px;margin-right:5px;">리뷰작성</td>
            </tr>
            <tr>
               <td style="height:55%;"><textarea name="reviewContent2" rows="13" cols="40" id="updateText" style="border:none;resize:none;"></textarea></td>
            </tr>
            <tr style="font-weight:bold;">
               <td style="height:38px;text-align:left;"><img src="/img/speech-bubble.png" style="width:25px;height:25px;margin-left:5px;margin-right:5px;">해쉬태그작성</td>
            </tr>
            <tr>
               <td style="height:32px;text-align:left; padding-top:2px;">
                  <input type="text" id="hash_input2" >
                  <a href="javascript:hash_regist2()" id="regist2">등록</a>
               </td>
            </tr>
            <tr style="height:30px;">   
               <td style="text-align:left;">   
                  <span id="hash2" style="color:blue;"></span>
                  <input type="hidden" id="hashVal2" name="hashtag2">
                  <input type="hidden" id="hashCnt2" name="hashtagCnt2">
                  <input type="hidden" id="rNo" name="reviewNo2">
               </td>
            </tr>
            <tr>
               <td><button type="submit" id="updateBtn2" class="btn btn-outline-dark">수정하기</button></td>
            </tr>
         </table>
      </form>
   </div>
        </div>
        
<!--         Modal footer
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div> -->
      </div>
    </div>
  </div>             
</section>
   <%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
   <script>
   var newJquery = $.noConflict(true);

/*    $("#myModal_detail").ready(function(){
      location.href="/reviewCommentList?reviewNo="+reviewNo;   
   });
   */
   function write(){
      document.getElementById("imgView").src = "/img/플러스.jpg";      
   }
   
   $("#myModal_detail").on('shown', function(){
      $("#comment_print").empty();
      $("#myModal_detail").css("overflow","hidden");
   });
   
   
   $("#comment_In").click(function(){
      if(${empty sessionScope.member.memberId}){
         alert("로그인 후 이용 가능합니다.");
         $("#comment_Write").attr("value","")="";
         return false;
      }
      if($("#comment_Write").attr("value") == ""){
         alert("댓글을 입력해주세요");
         return false;
      }
      var commentWrite = $("#comment_Write").attr("value");
      var reviewNo = $("#rNo2").attr("value");
      var commentWriter = $("#CommentWriter").attr("value"); 
      var date = new Date();
      var sDate = date.getFullYear()+"-"+("0"+(date.getMonth()+1)).slice(-2) + "-" +("0"+date.getDate()).slice(-2);
      $.ajax({
         url : "/reviewCommentInsert",
         type : "get",
         data : {commentWrite:commentWrite,reviewNo:reviewNo,commentWriter:commentWriter},
         success : function(data){
            var list = $("#comment_print");
            list.append($("<table id='remv_tab"+data+"' style='margin-bottom:3px'><tr>"
                  +"<td style='margin-left:2px; width:15%;'<span id='cmWriter"+data+"'>"+commentWriter+"</span></td>"
                  +"<td style='margin-left:2px; width:60%;'><textarea rows='1' name='reviewCommentContent' id='ta"+data+"' style='resize:none;border-radius:10px;width:100%;'  readonly>"+commentWrite+"</textarea></td>"
                  +"<td style='margin-left:2px; width:15%;'>"+sDate+"</td>"
                   +"<td style='margin-left:2px; width:5%;' id='upbtn"+data+"'><a href='javascript:updateComment("+data+");'>수정</a></td>"
                   +"<td style='margin-left:2px; display:none;' id='upbtnC"+data+"'><a href='javascript:updateComment("+data+");'>수정완료</a></td>"
                   +"<td style='margin-left:2px;width:5%;' id='delbtn"+data+"'><a href='javascript:deleteComment("+data+");'>삭제</a></td>"
                  +"</tr></table>"));
/*             list.append($("<td style='padding:2px'><span>"+commentWriter+"</span></td>"));
            list.append($("<td style='padding:2px'><textarea rows='1' class='form-control' name='reviewCommentContent' readonly>"+commentWrite+"</textarea></td>"));
             list.append($("<td><a href='#'>수정</a></td>"));
            list.append($("<td><a href='#'>삭제</a></td>")); 
            list.append($("</tr></table>")); */
            
            $("#comment_Write").attr("value","");
         },
         error:function(){
            console.log("댓글등록실패");
         }
      });
   }); 
/*    function login_Check()
   {
      alert("aa");
      return false;
   } */
   
/*    $(function(){
      $("#updateBtn").click(function(){
         $("#Detail_modal").css("display","none");
         $("#modify").css("display","block");
      });   
   }); */
   $("#searchBtn").click(function(){
      if($("#searchTxt").val() == ""){
         alert("검색할 해쉬태그를 입력해주세요.");
      }
   });
   
   newJquery("#content1").ready(function(){
      $('.your-class').slick({
          arrows: true
      });
   });
   
   function WriteClose(){
      $("#contentForm")[0].reset();
      document.getElementById("hash").innerText = "";
      document.getElementById("imgView").src = "";
      document.getElementById("hashCnt").value = "1";
      document.getElementById("hashVal").value = "";
      $("#comment_print").empty();
   }
   
   function ReviewRegist(){
      if(document.getElementById("imgChangeFlag").value == "N"){
         alert("사진을 등록해주세요");
         document.contentForm.reviewContent.focus();
         return false;
      }
      else if(document.getElementById("reviewContent").value==""){
         alert("리뷰 내용을 작성해주세요");
         document.contentForm.reviewContent.focus();
         return false;
      }
      else if(document.getElementById("hash").innerText==""){
         alert("해쉬태그를 1개 이상 등록해주세요");
         document.contentForm.reviewContent.focus();
         return false;
      }
   }
      
/*    $("#imgList").click(function(){
      var rNo = $("#rNo2").attr("value");
      $.ajax({
         url : "/reviewRecommendList",
         data : {reviewNo : rNo},
         type : "get",
         dataType : "json",
         success : function(data){
            for(var i in data){
               var p=data[i];
               if(p.memberNo == ${sessionScope.member.memberNo} && p.reviewNo == rNo){
                  $(".heart1").css("display","none");
                  $(".heart2").css("display","block");
               }else{
                  $(".heart1").css("display","block");
                  $(".heart2").css("display","none");
               }
            }
         }
      });
   }); */
   
   newJquery(function(){
      newJquery("#updateBtn").click(function(){
         newJquery("#myModal_detail").modal("hide");
         newJquery(".modal-backdrop").css("display","none");   
         newJquery("#myModal_modify").focus();
      });
      
      newJquery("#writeBtn").click(function(){
         $("#imgView").attr("src","/img/플러스.jpg");
      });
   });   
/*    $(function(){ //함수실행
      $("#writeBtn").click(function(){ //dia_bt라는 아이디를 클릭했을 때
         $("#Write_modal").dialog({ // dia_rs를 dialog오버레이창의로 띄워주고 'dialog창'이라는 제목과 넓이 800을 설정
            title : "글쓰기",
            width : 800,
            modal : true, //dialog창이 올라왔을 때 dialog이전 레이어(즉 dialog창뒤에 있는것)을 보호할것인가 하지않을것인가 정함
         });
      });
   });  */
   
/*    $(function(){ //함수실행
      <c:forEach items="${review}" var="r">
      $("#imgList${r.reviewNo}").click(function(){ //dia_bt라는 아이디를 클릭했을 때
         $("#popupView").dialog({ // dia_rs를 dialog오버레이창의로 띄워주고 'dialog창'이라는 제목과 넓이 800을 설정
            title : "dialog",
            width : 800,
            modal : true, //dialog창이 올라왔을 때 dialog이전 레이어(즉 dialog창뒤에 있는것)을 보호할것인가 하지않을것인가 정함
         });
         $("#Detail_modal").css("display","block");
         $("#modify").css("display","none");
      })
      </c:forEach>;
   }); */
   
   newJquery(function(){
        $("#tab1").click(function(){
           location.href="/reviewList";
        });
        $("#tab2").click(function(){
            location.href="/reviewOrderRecommend";
        });
        $("#Detail_modal").find(".heart1").click(function(){
           var memberNo = "${sessionScope.member.memberNo}";
           if(memberNo == ""){
              alert("로그인 후 이용 가능합니다.");
              return false;
           }
           $(this).css("display","none");
           $(this).next().css("display","block");
           var rNo = $("#rNo2").attr("value");
           $("#heartOff"+rNo).css("display","none");
           $("#heartON"+rNo).css("display","block");
           var recCount = $("#heartON"+rNo).parents(".reviewCon").find(".recommend").html();
           $("#heartON"+rNo).parents(".reviewCon").find(".recommend").html(Number(recCount)+1);
            $.ajax({
               type : 'get',
               data : {reviewNo:rNo, memberNo:memberNo},
               url:'/reviewRecommendPlus?reviewNo='+rNo+'&memberNo=${sessionScope.member.memberNo}',
               success: function(data) { 
                  },
                 error: function(){
                    alert("추천을 실패하였습니다.");                    
                 }
            });            
        });
        $("#Detail_modal").find(".heart2").click(function(){
           var memberNo = "${sessionScope.member.memberNo}";
           if(memberNo == ""){
              alert("로그인 후 이용 가능합니다.");
              return false;
           }
           var heart2 = $(this)
           heart2.prev().css("display","block");
           heart2.css("display","none");
           var rNo = $("#rNo2").attr("value");
           $("#heartOff"+rNo).css("display","block");
           $("#heartON"+rNo).css("display","none");
           var recCount = $("#heartON"+rNo).parents(".reviewCon").find(".recommend").html();
           $("#heartON"+rNo).parents(".reviewCon").find(".recommend").html(Number(recCount)-1);
           //location.href= "/reviewRecommendPlus?reviewNo="+rNo+"&memberNo=${sessionScope.member.memberNo}";
            $.ajax({
               type : 'get',
               dataType : 'html',
               url:'/reviewRecommendMus?reviewNo='+rNo+'&memberNo=${sessionScope.member.memberNo}',
               success: function(data) { 
                  },
                 error: function(){
                    alert("추천을 실패하였습니다.");                    
                 }
            });  
        });
        $("#content").find(".heart1").click(function(){
           var memberNo = "${sessionScope.member.memberNo}";
           if(memberNo == ""){
              alert("로그인 후 이용 가능합니다.");
              return false;
           }
           $(this).css("display","none");
           $(this).next().css("display","block");
           var rNo = $(this).parents(".reviewCon").find("#reviewNum").val();
           
           var recCount = $(this).parents(".reviewCon").find(".recommend").html();
           $(this).parents(".reviewCon").find(".recommend").html(Number(recCount)+1);
           //location.href= "/reviewRecommendPlus?reviewNo="+rNo+"&memberNo=${sessionScope.member.memberNo}";
            $.ajax({
               type : 'get',
               data : {reviewNo:rNo, memberNo:memberNo},
               /* dataType : 'html', */
               url:'/reviewRecommendPlus?reviewNo='+rNo+'&memberNo=${sessionScope.member.memberNo}',
               success: function(data) { 
                  },
                 error: function(){
                    alert("추천을 실패하였습니다.");                    
                 }
            });            
        }); 
          $("#content").find(".heart2").click(function(){
           var memberNo = "${sessionScope.member.memberNo}";
           if(memberNo == ""){
              alert("로그인 후 이용 가능합니다.");
              return false;
           }
           var heart2 = $(this)
           heart2.prev().css("display","block");
           heart2.css("display","none");
           var rNo = $(this).parents(".reviewCon").find("#reviewNum").val();
           
           var recCount = $(this).parents(".reviewCon").find(".recommend").html();
           $(this).parents(".reviewCon").find(".recommend").html(Number(recCount)-1);
           //location.href= "/reviewRecommendPlus?reviewNo="+rNo+"&memberNo=${sessionScope.member.memberNo}";
            $.ajax({
               type : 'get',
               dataType : 'html',
               url:'/reviewRecommendMus?reviewNo='+rNo+'&memberNo=${sessionScope.member.memberNo}',
               success: function(data) { 
                  },
                 error: function(){
                    alert("추천을 실패하였습니다.");                    
                 }
            });  
        });
          
/*         $(".heart2").click(function(){
           var rNo = $(this).attr("value");
            var plus = $("#recom_name"+rNo).html();
            if(plus==null){
               plus = 0;
            }else{
               plus *= 1;
            }
            plus=plus+1;
            $.ajax({
               type : 'get',
               dataType : 'html',
               url:'/reviewRecommend?reviewNo='+rNo+'&plus='+plus,
               success: function(data) { 
                  $("#recom_name").html(data); 
                  }
            });           
        }); */
    });
    
   function loadImg(f){
      if(f.files.length!=0 && f.files[0]!=0){
         var reader = new FileReader();
         reader.readAsDataURL(f.files[0]);
         reader.onload=function(e){
            $("#imgView").attr('src',e.target.result);
         }
      }else{
         $("#imgView").attr('src','');
       }
   }
   
   function up_loadImg(f){
      if(f.files.length!=0 && f.files[0]!=0){
         var reader = new FileReader();
         reader.readAsDataURL(f.files[0]);
         reader.onload=function(e){
            $("#imgView3").attr('src',e.target.result);
         }
      }else{
         $("#imgView3").attr('src','');
       }
   }
   
   function imgChangeYN()
   {
      document.getElementById("imgChangeFlag").value = "Y";
   }

   function hash_regist(){         
      //해쉬 태그 갯수가 5개 이상인지를 묻는 if문
      if(document.getElementById("hashCnt").value > 5){
         alert("해쉬 태그는 5개 이상 입력하실 수 없습니다.");
         document.getElementById("hash_input").value = "";
         return false;
      }
      //같은 해쉬태그 넣지 못하게 하는 if문
      if(document.getElementById("hash_input").value==""){
         alert("입력하신 해쉬태그가 없습니다.");
         return false;
      }
      if(document.getElementById("hashVal").value.indexOf(document.getElementById("hash_input").value) != -1){
         alert("같은 단어는 입력하실 수 없습니다.");
         document.getElementById("hash_input").value = "";
         return false;
      }
      var hash = " #"+document.getElementById("hash_input").value;
      document.getElementById("hash").innerText += hash;
      document.getElementById("hashVal").value += hash;
      
      //해쉬태그 갯수 구하기 start
      var a = document.getElementById("hashCnt").value *= 1;
      a +=1;
      document.getElementById("hashCnt").value = a;
      //해쉬태그 갯수 구하기 end
      
      document.getElementById("hash_input").value = "";
   }
   
   function hash_regist2(){   
      var hash = document.getElementById("hash2").innerHTML;
      //hash += "";
      var count = (hash.match(/#/g) || []).length;
      
      //해쉬 태그 갯수가 5개 이상인지를 묻는 if문
      if(count >= 5){
         alert("해쉬 태그는 5개 이상 입력하실 수 없습니다.");
         document.getElementById("hash_input2").value = "";
         return false;
      }
      
      //같은 해쉬태그 넣지 못하게 하는 if문
      if(document.getElementById("hash2").innerHTML.indexOf(document.getElementById("hash_input2").value) != -1){
         alert("같은 단어는 입력하실 수 없습니다.");
         document.getElementById("hash_input2").value = "";
         return false;
      }         
      var hashPlus = " #"+document.getElementById("hash_input2").value;
      document.getElementById("hash2").innerText += hashPlus;
      document.getElementById("hashVal2").value += hashPlus;
      
      //해쉬태그 갯수 구하기 start
      var a = document.getElementById("hashCnt2").value *= 1;
      a +=1;
      document.getElementById("hashCnt2").value = a;
      //해쉬태그 갯수 구하기 end
      
      document.getElementById("hash_input2").value = "";
   }
   
    $("#upload").change(function(){
       var imgView = $("#imgView")
       imgView.css("display","block");
       
    });  
   
    $("#upload2").change(function(){
       var imgView = $("#imgView3")
       imgView.css("display","block");
    }); 
    
    function readCount(rNo, mNo, flag)
    {
       if(flag=="plus"){
          document.getElementById("heart1").display = "none";
          document.getElementById("heart2").display = "block";
       }
       else{
          document.getElementById("heart2").display = "none";
          document.getElementById("heart1").display = "block";
       }
    }
    function replaceAll(str,searchStr,replaceStr){
       return str.split(searchStr).join(replaceStr);
    }
    function detail_Load(no)
    {
       <c:forEach items="${review}" var="r">
       var num = ${r.reviewNo};
          if(no == num){
             document.getElementById("imgView2").src = "/upload/review/${r.filepath}";
             document.getElementById("imgView3").src = "/upload/review/${r.filepath}";
             var content = "${r.reviewContentBr}";
             document.getElementById("detailContent").value = replaceAll(content,"<br>","\r\n"); 
             document.getElementById("updateText").value = replaceAll(content,"<br>","\r\n");
             document.getElementById("Nick_detail").innerHTML = "${r.reviewWriter}";
             document.getElementById("Nick_detail2").innerHTML = "${r.reviewWriter}";
             document.getElementById("hash_detail").innerHTML = "${r.hashtag}";
             //document.getElementById("hash2").innerHTML = "${r.hashtag}";
             //document.getElementById("hashVal2").value += "${r.hashtag}";
             document.getElementById("rNo").value = "${r.reviewNo}";
             document.getElementById("deleteBtn").value = "${r.reviewNo}";
             document.getElementsByName("reviewWriter2").value = "${r.reviewWriter}";
             document.getElementsByName("detailWriter_detail").value = "${r.reviewWriter}";
             document.getElementById("oldFileName").value = "${r.filename}";
             document.getElementById("oldFilePath").value = "/upload/review/${r.filepath}";
             document.getElementById("rNo2").value = "${r.reviewNo}";
             document.getElementById("rw").value="${r.reviewWriter}";
              $.ajax({
                 url : "/reviewRecommendList",
                 data : {reviewNo : no},
                 type : "get",
                 dataType : "json",
                 success : function(data){
                    var flag = false;
                    for(var i in data){
                       flag= true;
                       var p=data[i];
                       if(p.memberNo == "${sessionScope.member.memberNo}" && p.reviewNo == no){
                          $("#myModal_detail").find(".heart1").css("display","none");
                          $("#myModal_detail").find(".heart2").css("display","block");
                       }else{
                          $("#myModal_detail").find(".heart1").css("display","block");
                          $("#myModal_detail").find(".heart2").css("display","none");
                       }
                    }
                    if(!flag){
                       $("#myModal_detail").find(".heart1").css("display","block");
                      $("#myModal_detail").find(".heart2").css("display","none");
                    }
                 }
              });
              
              var reviewNo = $("#rNo2").attr("value");
              $.ajax({
                 url : "/reviewCommentList",
                 type : "get",
                 data : {reviewNo:reviewNo},
                 success : function(data){
                    var list = $("#comment_print");
                    for(var i in data){
                       var p=data[i];
                       if(p.reviewCommentWriter == "${sessionScope.member.memberNickname}")
                       {
                          list.append($("<table id='remv_tab"+p.reviewCommentNo+"' style='margin-bottom:3px'><tr>"
                          +"<td style='margin-left:2px; width:15%;'><span id='cmWriter"+p.reviewCommentNo+"'>"+p.reviewCommentWriter+"</span></td>"
                          +"<td style='margin-left:2px; width:60%;'><textarea rows='1' id='ta"+p.reviewCommentNo+"' style='resize:none;border-radius:10px;width:100%;' name='reviewCommentContent' readonly>"+p.reviewCommentContent+"</textarea></td>"
                          +"<td style='margin-left:2px; width:15%;'><span id='cmDate'>"+p.reviewCommentDate+"</span></td>"
                          +"<td style='margin-left:2px; width:5%;' id='upbtn"+p.reviewCommentNo+"'><a href='javascript:updateComment("+p.reviewCommentNo+");'>수정</a></td>"
                          +"<td style='margin-left:2px; display:none;' id='upbtnC"+p.reviewCommentNo+"'><a href='javascript:updateComment("+p.reviewCommentNo+");'>수정완료</a></td>"
                          +"<td style='margin-left:2px;width:5%;' id='delbtn"+p.reviewCommentNo+"'><a href='javascript:deleteComment("+p.reviewCommentNo+");'>삭제</a></td>"
                          +"</tr></table>"));
                       }else{
                          list.append($("<table id='remv_tab"+p.reviewCommentNo+"' style='margin-bottom:3px'><tr>"
                             +"<td style='margin-left:2px; width:15%;'><span id='cmWriter'>"+p.reviewCommentWriter+"</span></td>"
                             +"<td style='margin-left:2px; width:60%;'><textarea rows='1' id='ta"+p.reviewCommentNo+"' style='resize:none;border-radius:10px;width:100%;' name='reviewCommentContent' readonly>"+p.reviewCommentContent+"</textarea></td>"
                             +"<td style='margin-left:2px; width:15%;'><span id='cmDate'>"+p.reviewCommentDate+"</span></td>"
                             +"<td style='margin-left:2px; width:5%; visibility:hidden;' id='updateCom'><a href='javascript:updateComment("+p.reviewCommentNo+");'>수정</a></td>"
                          +"<td style='margin-left:2px;width:5%; visibility:hidden;' ><a href='javascript:deleteComment("+p.reviewCommentNo+");'>삭제</a></td>"
                             +"</tr></table>"));
                       }
/*                        list.append($("<td style='padding:2px;'><span id='cmWriter'>"+p.reviewCommentWriter+"</span></td>"));
                       list.append($("<td style='padding:2px;'><textarea rows='1' id='ta"+p.reviewCommentNo+"' class='form-control' name='reviewCommentContent' readonly>"+p.reviewCommentContent+"</textarea></td>"));
                       list.append($("<td><a href='javascript:updateComment("+p.reviewCommentNo+");'>수정</a></td>"));
                       list.append($("<td><a href='javascript:deleteComment("+p.reviewCommentNo+");'>삭제</a></td>"));
                       list.append($("</tr></table>")); */
                    }
                 },
                 error:function(){
                    console.log("댓글등록을 실패하였습니다.");
                 }
              });
          }
          num = 0;
       </c:forEach>;
       var rw_val = $("#rw").val();
       var loginId = '${sessionScope.member.memberNickname}';
      if(${not empty sessionScope.member.memberId} && ( loginId == rw_val)){
         $("#detail_btn").css("display","table-row");
      }else{
         $("#detail_btn").css("display","none");
      }
    }
    
    newJquery("#deleteBtn").click(function(){
       var reviewNo =$(this).attr('value')
          if(confirm("정말로삭제하시겠습니까?")==true){
          location.href="/reviewDelete?reviewNo="+reviewNo;
       }else{
          return;
       }       
    });
    
    function updateComment(no)
    {
       if($("#cmWriter"+no).text() != "${sessionScope.member.memberNickname}"){
          alert("작성자가 아닙니다.");
          return false;
       }
       if($("#ta"+no).attr("readonly")){
          $("#ta"+no).attr("readonly", false);
          $("#ta"+no).css("border-color","blue");
          $("#upbtnC"+no).css("display","block");
          $("#delbtn"+no).css("display","none");
          $("#upbtn"+no).css("display","none");
          return true;
       }
       
       var input = $("#ta"+no).val();
       if(!(confirm("수정하시겠습니까?"))){
          alert("수정되지 않았습니다.");
          return false;
       }else{
          $.ajax({
             url : "/reviewCommentUpdate",
             type : "get",
             data : {no:no,reviewCommentContent:input},
             success : function(data){
                   $("#ta"+no).attr("value",input);
                    $("#ta"+no).attr("readonly", true);
                    $("#ta"+no).css("border-color","");
                    $("#upbtn"+no).css("display","");
                    $("#delbtn"+no).css("display","");
                    $("#upbtnC"+no).css("display","none");
             },
             error:function(){
                console.log("댓글수정을 실패하였습니다.");
             }
          });
       }
    }
    
    function deleteComment(no)
    {
       if($("#cmWriter"+no).text() != "${sessionScope.member.memberNickname}"){
          alert("작성자가 아닙니다.");
          return false;
       }
       
       if(confirm("해당 댓글을 삭제하시겠습니까?")){
          $.ajax({
             url : "/reviewCommentDelete",
             type : "get",
             data : {no:no},
             success : function(data){
                $("#remv_tab"+no).css("display","none");
             },
             error:function(){
                console.log("댓글삭제를 실패하였습니다.");
             }
          });
       }else{
          return false;
       }
          
    }
   </script>   
</body>
</html>