<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 앞으로 들어갈 클래스명들은 디자인을 위한 것일 뿐인게 많다. --> 

<!-- doctype부터 어쩌구 이런거는 다 불러올 페이지에 있을 예정이므로 그냥 싹 다 지워도 됨.
불러오는 시점에선 이미 그것들 안에 둘러쌓여있을 것이므로. -->
   <style>
      .footer_area h6{
         color: #E6E6E6;
      }
      .footer_area hr{
         border-top: 1px solid gray;
      }
      .footer_area .footer1{
         width: 100%;
         padding-top: 10px;
      }
      .footer_area span{
         color: #BDBDBD;
         font-size: 13px;
         font-weight: 100;
      }
      .footer_area .footer2{
         font-weight: bold;
         color: #E6E6E6;
      }
      *{
	   	font-family: 'Noto Sans KR', sans-serif;
	   }
   </style>
   <footer class = "footer_area" style="height:300px; background-color:black;">
      <div style="width:60%; margin:0 auto; padding-top:30px;">
              <div style="width:50%; float:left; padding-left: 30px; padding-rignt: 30px; height: 215px;">
                 <h6>SNS</h6><hr>
                 <div class="footer1">                    
                    <img src = "/footerimg/facebook.png">
                    <a href="https://www.facebook.com/" target="_blank"><span>FACEBOOK</span></a>
                 </div>
                 <div class="footer1">           
                    <img src = "/footerimg/instagram.png">
                    <a href="https://www.instagram.com/" target="_blank"><span>INSTAGRAM</span></a>
                 </div>
                 <div class="footer1">
                    <img src = "/footerimg/twitter.png">
                    <a href="https://twitter.com/?lang=ko" target="_blank"><span>TWITTER</span></a>
                 </div>              
              </div>
              <div style="width:50%; float:right; padding-left: 30px; padding-rignt: 30px; height: 215px;">
                 <h6>COMPANY</h6><hr>
                 <div class="footer1">
                    <span class="footer2">상호명 </span>
                    <span>두번째 스무살</span>
                 </div>
                 <div class="footer1">
                    <span class="footer2">주소 </span>
                    <span>서울 영등포구 선유동2로 57 이레빌딩</span>
                 </div>
                 <div class="footer1">
                    <span class="footer2">대표이사 </span>
                    <span>배병축</span>
                 </div>
                 <div class="footer1">
                    <span class="footer2">사업자등록번호 </span>
                    <span>1990-0221-30</span>
                 </div>
              </div>
              <div style="widtt:100%; float:left; padding-left: 30px;">
                 <span>COPYRIGHT © 2019 TWENTY SECOND KOREA ALL RIGHT RESERVED</span>
              </div>
          </div>
   </footer>