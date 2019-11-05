<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Twenty Second</title>
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/choice/step.css">
<body>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<section style="margin-top: 60px;">
<div class = "div">
<form action = "/knowStep" method = "post">
<div id = "step1">
<div class = "stepWrap">
	<label style = "cursor:pointer; color:black;" onclick = "backPage(1)">step1</label>
	<span style = "color:black;">></span>
	<label>step2</label>
	<span>></span>
	<label>step3</label>
	<span>></span>
	<label>step4</label>
</div>
<div class = "div">
	<h4 style="font-weight:500; padding-bottom:10px; border-bottom:2px solid black;">Top notes<span style="font-weight:300;"> 를 선택하세요.</span></h4>
		<div>
			<label class = "label" for = "q1_1">
				<span><img src="/choiceimg/note/Bergamot.jpg" class = "img"></span>
				<span><p>베르가못<br>Bergamot</p></span>
				<span><input type = "checkbox" id = "q1_1" name = "q1" value = "베르가못" /></span>
			</label>
			<label class = "label" for = "q1_2">
				<span><img src="/choiceimg/note/Mint.png" class = "img"></span>
				<span><p>민트<br>Mint</p></span>
				<span><input type = "checkbox" id = "q1_2" name = "q1" value = "민트" /></span>
			</label>
			<label class = "label" for = "q1_3">
				<span><img src="/choiceimg/note/Pear.jpg" class = "img"></span>
				<span><p>배<br>Pear</p></span>
				<span><input type = "checkbox" id = "q1_3" name = "q1" value = "배" /></span>
			</label>
			<label class = "label" for = "q1_4">
				<span><img src="/choiceimg/note/Grapefruit.jpg" class = "img"></span>
				<span><p>자몽<br>Grapefruit</p></span>
				<span><input type = "checkbox" id = "q1_4" name = "q1" value = "그레이프" /></span>
			</label>
			<label class = "label" for = "q1_5">
				<span><img src="/choiceimg/note/Neroli.jpg" class = "img"></span>
				<span><p>네롤리<br>Neroli</p></span>
				<span><input type = "checkbox" id = "q1_5" name = "q1" value = "네롤리" /></span>
			</label>
			<label class = "label" for = "q1_6">
				<span><img src="/choiceimg/note/Lavanda.jpg" class = "img"></span>
				<span><p>라벤더<br>Lavender</p></span>
				<span><input type = "checkbox" id = "q1_6" name = "q1" value = "라벤더" /></span>
			</label>
			<label class = "label" for = "q1_7">
				<span><img src="/choiceimg/note/Pink-Pepper.jpg" class = "img"></span>
				<span><p>핑크페퍼<br>Pink pepper</p></span>
				<span><input type = "checkbox" id = "q1_7" name = "q1" value = "핑크페퍼" /></span>
			</label>
			<label class = "label" for = "q1_8">
				<span><img src="/choiceimg/note/Lime.jpg" class = "img"></span>
				<span><p>라임<br>Lime</p></span>
				<span><input type = "checkbox" id = "q1_8" name = "q1" value = "라임" /></span>
			</label>
			<label class = "label" for = "q1_9">
				<span><img src="/choiceimg/note/Orange.jpg" class = "img"></span>
				<span><p>오렌지<br>Orange</p></span>
				<span><input type = "checkbox" id = "q1_9" name = "q1" value = "오렌지" /></span>
			</label>
			<label class = "label" for = "q1_10">
				<span><img src="/choiceimg/note/Lemon.jpg" class = "img"></span>
				<span><p>레몬<br>Lemon</p></span>
				<span><input type = "checkbox" id = "q1_10" name = "q1" value = "레몬" /></span>
			</label>
			<label class = "label" for = "q1_10">
				<span><img src="/choiceimg/note/Currant.jpg" class = "img"></span>
				<span><p>건포도<br>Currant</p></span>
				<span><input type = "checkbox" id = "q1_10" name = "q1" value = "커런트" /></span>
			</label>
			<label class = "label" for = "q1_10">
				<span><img src="/choiceimg/note/Rose.jpg" class = "img"></span>
				<span><p>장미<br>Rose</p></span>
				<span><input type = "checkbox" id = "q1_10" name = "q1" value = "로즈" /></span>
			</label>
			<label class = "label" for = "q1_10">
				<span><img src="/choiceimg/note/Mandarin.jpg" class = "img"></span>
				<span><p>만다린<br>Mandarin</p></span>
				<span><input type = "checkbox" id = "q1_10" name = "q1" value = "만다린" /></span>
			</label>
			<label class = "label" for = "q1_10">
				<span><img src="/choiceimg/note/Rasberry.jpg" class = "img"></span>
				<span><p>산딸기<br>Raspberry</p></span>
				<span><input type = "checkbox" id = "q1_10" name = "q1" value = "라즈베리" /></span>
			</label>
		</div>
	</div>
	<div class = "wrap">
		<input type = "button" class = "buttons" value = "BACK" onclick="location.href = '/goChoice'"><input type = "button" value = "NEXT" class = "buttons black" onclick="goPage(2, this)" />
	</div>
</div>
<div id = "step2">
	<div class = "stepWrap">
		<label style = "cursor:pointer; color:black;" onclick = "backPage(1)">step1</label>
		<span style = "color:black;">></span>
		<label style = "cursor:pointer; color:black;" onclick = "backPage(2)">step2</label>
		<span style = "color:black;">></span>
		<label>step3</label>
		<span>></span>
		<label>step4</label>
	</div>
	<div class = "div">
		<h4 style="font-weight:500; padding-bottom:10px; border-bottom:2px solid black;">Middle notes<span style="font-weight:300;"> 를 선택하세요.</span></h4>
		<div>
		<label class = "label" for = "q2_1">
			<span><img src="/choiceimg/note/Orange.jpg" class = "img"></span>
			<span><p>오렌지<br>Orange</p></span>
			<span><input type = "checkbox" id = "q2_1" name = "q2" value = "오렌지" /></span>
		</label>
		<label class = "label" for = "q2_2">
			<span><img src="/choiceimg/note/Peony.jpg" class = "img"></span>
			<span><p>모란<br>Peony</p></span>
			<span><input type = "checkbox" id = "q2_2" name = "q2" value = "모란" /></span>
		</label>
		<label class = "label" for = "q2_3">
			<span><img src="/choiceimg/note/Jasmine.jpg" class = "img"></span>
			<span><p>자스민<br>Jasmine</p></span>
			<span><input type = "checkbox" id = "q2_3" name = "q2" value = "자스민" /></span>
		</label>
		<label class = "label" for = "q2_4">
			<span><img src="/choiceimg/note/Geranium.jpg" class = "img"></span>
			<span><p>제라늄<br>Geranium</p></span>
			<span><input type = "checkbox" id = "q2_4" name = "q2" value = "제라늄" /></span>
		</label>
		<label class = "label" for = "q2_5">
			<span><img src="/choiceimg/note/Clove.jpg" class = "img"></span>
			<span><p>정향<br>Clove</p></span>
			<span><input type = "checkbox" id = "q2_5" name = "q2" value = "정향" /></span>
		</label>
		<label class = "label" for = "q2_6">
			<span><img src="/choiceimg/note/Peach.jpg" class = "img"></span>
			<span><p>복숭아<br>Peach</p></span>
			<span><input type = "checkbox" id = "q2_6" name = "q2" value = "복숭아" /></span>
		</label>
		<label class = "label" for = "q2_7">
			<span><img src="/choiceimg/note/Rose.jpg" class = "img"></span>
			<span><p>장미<br>Rose</p></span>
			<span><input type = "checkbox" id = "q2_7" name = "q2" value = "로즈" /></span>
		</label>
		<label class = "label" for = "q2_8">
			<span><img src="/choiceimg/note/Freesia.jpg" class = "img"></span>
			<span><p>프리지아<br>Freesia</p></span>
			<span><input type = "checkbox" id = "q2_8" name = "q2" value = "프리지아" /></span>
		</label>
		<label class = "label" for = "q2_9">
			<span><img src="/choiceimg/note/Lemongrass.jpg" class = "img"></span>
			<span><p>레몬그라스<br>Lemongrass</p></span>
			<span><input type = "checkbox" id = "q2_9" name = "q2" value = "레" /></span>
		</label>
		<label class = "label" for = "q2_10">
			<span><img src="/choiceimg/note/amber.webp" class = "img"></span>
			<span><p>앰버<br>Amber</p></span>
			<span><input type = "checkbox" id = "q2_10" name = "q2" value = "앰버" /></span>
		</label>
		<label class = "label" for = "q2_11">
			<span><img src="/choiceimg/note/Lily.jpg" class = "img"></span>
			<span><p>백합<br>lily</p></span>
			<span><input type = "checkbox" id = "q2_11" name = "q2" value = "백합" /></span>
		</label>
		<label class = "label" for = "q2_12">
			<span><img src="/choiceimg/note/Mayvalley.jpg" class = "img"></span>
			<span><p>은방울꽃<br>May lily</p></span>
			<span><input type = "checkbox" id = "q2_12" name = "q2" value = "은방울꽃" /></span>
		</label>
		<label class = "label" for = "q2_13">
			<span><img src="/choiceimg/note/Lavanda.jpg" class = "img"></span>
			<span><p>라벤더<br>Lavender</p></span>
			<span><input type = "checkbox" id = "q2_13" name = "q2" value = "라벤더" /></span>
		</label>
		<label class = "label" for = "q2_14">
			<span><img src="/choiceimg/note/Iris.jpg" class = "img"></span>
			<span><p>붓꽃<br>Iris</p></span>
			<span><input type = "checkbox" id = "q2_14" name = "q2" value = "아이리스" /></span>
		</label>
		<label class = "label" for = "q2_14">
			<span><img src="/choiceimg/note/Violet.jpg" class = "img"></span>
			<span><p>제비꽃<br>Violet</p></span>
			<span><input type = "checkbox" id = "q2_14" name = "q2" value = "바이올렛" /></span>
		</label>
		</div>
	</div>
	<div class = "wrap">
		<input type = "button" class = "buttons" value = "BACK" onclick = "backPage(1)" /><input type = "button" value = "NEXT" class = "buttons black" onclick = "goPage(3, this)" />
	</div>
</div>
<div id = "step3">
	<div class = "stepWrap">
		<label style = "cursor:pointer; color:black;" onclick = "backPage(1)">step1</label>
		<span style = "color:black;">></span>
		<label style = "cursor:pointer; color:black;" onclick = "backPage(2)">step2</label>
		<span style = "color:black;">></span>
		<label style = "cursor:pointer; color:black;" onclick = "backPage(3)">step3</label>
		<span style = "color:black;">></span>
		<label>step4</label>
	</div>
	<div class = "div">
		<h4 style="font-weight:500; padding-bottom:10px; border-bottom:2px solid black;">Base notes<span style="font-weight:300;"> 를 선택하세요.</span></h4>
		<div>
		<label class = "label" for = "q3_1">
			<span><img src="/choiceimg/note/amber.webp" class = "img"></span>
			<span><p>앰버<br>Amber</p></span>
			<span><input type = "checkbox" id = "q3_1" name = "q3" value = "앰버" /></span>
		</label>
		<label class = "label" for = "q3_2">
			<span><img src="/choiceimg/note/Vanilla.jpg" class = "img"></span>
			<span><p>바닐라<br>Vanilla</p></span>
			<span><input type = "checkbox" id = "q3_2" name = "q3" value = "바닐라" /></span>
		</label>
		<label class = "label" for = "q3_3">
			<span><img src="/choiceimg/note/wood.jpg" class = "img"></span>
			<span><p>우드<br>Wood</p></span>
			<span><input type = "checkbox" id = "q3_3" name = "q3" value = "우드" /></span>
		</label>
		<label class = "label" for = "q3_4">
			<span><img src="/choiceimg/note/Musk.jpg" class = "img"></span>
			<span><p>머스크<br>Musk</p></span>
			<span><input type = "checkbox" id = "q3_4" name = "q3" value = "머스크" /></span>
		</label>
		<label class = "label" for = "q3_6">
			<span><img src="/choiceimg/note/Patchouli.webp" class = "img"></span>
			<span><p>페츌리<br>Patchouli</p></span>
			<span><input type = "checkbox" id = "q3_6" name = "q3" value = "페츌리" /></span>
		</label>
		<label class = "label" for = "q3_8">
			<span><img src="/choiceimg/note/Tonka-bean.jpg" class = "img"></span>
			<span><p>통카 빈<br>Tonka Bean</p></span>
			<span><input type = "checkbox" id = "q3_8" name = "q3" value = "통카빈" /></span>
		</label>
		<label class = "label" for = "q3_8">
			<span><img src="/choiceimg/note/Oakmoss.jpg" class = "img"></span>
			<span><p>오크모스<br>Oakmoss</p></span>
			<span><input type = "checkbox" id = "q3_8" name = "q3" value = "오크모스" /></span>
		</label>
		</div>
	</div>
	<div class = "wrap">
	<input type = "button" class = "buttons" value = "BACK" onclick = "backPage(2)" /><input type = "button" value = "NEXT" class = "buttons black" onclick = "goPage(4, this)" />
	</div>
</div>
<div class = "div2">
<div id = "step4">
<div class = "stepWrap">
	<label style = "cursor:pointer; color:black;" onclick = "backPage(1)">step1</label>
	<span style = "color:black;">></span>
	<label style = "cursor:pointer; color:black;" onclick = "backPage(2)">step2</label>
	<span style = "color:black;">></span>
	<label style = "cursor:pointer; color:black;" onclick = "backPage(3)">step3</label>
	<span style = "color:black;">></span>
	<label style = "cursor:pointer; color:black;" onclick = "backPage(4)">step4</label>
</div>
	<!-- 
	<div class = "div2 overflow">
		<h4>향수 농도를 선택하세요.</h4>
		<div>
		<label class = "verticalabel">
			<span><img src="/choiceimg/spring.jpg" style ="height:94px;width:94px;border-radius: 50%;margin: 0px 5px;"></span>
			<span><p>퍼퓸<br>Perfume</p></span>
			<span style = "display: none;"><input type = "radio" name = "q4" value = "0"></span>
		</label>
		<label class = "verticalabel">
			<span><img src="/choiceimg/spring.jpg" style ="height:94px;width:94px;border-radius: 50%;margin: 0px 5px;"></span>
			<span><p>오드퍼퓸<br>Eau do Parfum</p></span>
			<span style = "display: none;"><input type = "radio" name = "q4" value = "1"></span>
		</label>
		<label class = "verticalabel">
			<span><img src="/choiceimg/spring.jpg" style ="height:94px;width:94px;border-radius: 50%;margin: 0px 5px;"></span>
			<span><p>오드 뚜왈렛<br>Eau de Toilette</p></span>
			<span style = "display: none;"><input type = "radio" name = "q4" value = "2"></span>
		</label>
		<label class = "verticalabel">
			<span><img src="/choiceimg/spring.jpg" style ="height:94px;width:94px;border-radius: 50%;margin: 0px 5px;"></span>
			<span><p>오드 콜로니<br>Eau de Cologne</p></span>
			<span style = "display: none;"><input type = "radio" name = "q4" value = "3"></span>
		</label>
		<label class = "verticalabel">
			<span><img src="/choiceimg/spring.jpg" style ="height:94px;width:94px;border-radius: 50%;margin: 0px 5px;"></span>
			<span><p>오 프레쉬<br>Eau Fraiche</p></span>
			<span style = "display: none;"><input type = "radio" name = "q4" value = "4"></span>
		</label>
		</div>
	</div>
	 -->
	<div class = "div2">
		<h4 style="font-weight:500; padding-bottom:10px; border-bottom:2px solid black; font-size:1.5em;">브랜드를 선택하세요.</h4>
		<div style="position:relative;">
		<input type = "text" autocomplete="off" id = "view" name = "brand" class = "text" style ="color: black;width: 200px; height:30px; border: 1px solid black; border-bottom-color: #aaa; border-left-color: #777; border-right-color: #ccc; box-sizing: border-box; padding:1px 6px; margin-top: 0px; margin-bottom: 0px;" />
		<input type = "button" id = "cancel" class = "cancel" value = "상관없음" />
		<div id = "output" style = "position:absolute; top:30px; left:10px; border:1px solid #aaa; width:200px; background-color: white; overflow: hidden; display:none;"></div>
		</div>
		
	</div>
	<div class = "div2">
		<h4 style="font-weight:500; padding-bottom:10px; border-bottom:2px solid black; font-size:1.5em; margin-top: 40px;">가격을 최대 어디까지 알아보고 계신가요?</h4>
		<div>
		<label class = "span" style = "padding-left: 10px;"><input type = "radio" name = "q5" value = "30000">3만원</label>
		<label class = "span" style = "padding-left: 10px;"><input type = "radio" name = "q5" value = "50000">5만원</label>
		<label class = "span" style = "padding-left: 10px;"><input type = "radio" name = "q5" value = "100000">10만원</label>
		<label class = "span" style = "padding-left: 10px;"><input type = "radio" name = "q5" value = "1073741823">상관없음</label>
		</div>
	</div>
	<div class = "div2">
		<h4 style="font-weight:500; padding-bottom:10px; border-bottom:2px solid black; font-size:1.5em; margin-top: 40px;">대중적인 향수를 추천받고 싶으신가요?</h4>
		<div>
		<h6 style="margin: 0px;margin-bottom: 15px; margin-left: 10px; margin-top: -15px; font-weight:100;">저희 사이트를 기준으로 추천수가 많거나 구매수가 많은 향수를 추천해드립니다.</h6>
		<label class = "span2"  style = "padding-left: 10px;"><input type = "radio" name = "q6" value = "true">네</label>
		<label class = "span2" style = "padding-left: 10px;"><input type = "radio" name = "q6" value = "false">아니오</label>
		</div>
	</div>
	<div class = "wrap">
	<input type = "button" class = "buttons" value = "BACK" onclick = "backPage(3)"><input type = "submit" value = "FINISH" class = "buttons black" style = "font-weight: bold;">
	</div>
</div>
</div>
</form>
</div>

<script type="text/javascript">
	document.addEventListener('keydown', function(event) {
	  if (event.keyCode === 13) {
	    event.preventDefault();
	  };
	}, true);
	//브랜드 자바스크립트
	function brand(me){
		$("#view").val(me.innerHTML);
		$("#output").css("display","none");
	}
	//페이지 onload(step1~3)
	$(function(){
		for(var i = 2; i < 5; i++){
			$("#step"+i).css("display","none");
		}
		var array1 = new Array();
		var array2 = new Array();
		var array3 = new Array();
		$(".label").attr("i", "0");
		$(".label").css("position", "relative");
		//checkboxToggle
		$(".label[for*=q1]").click(function(){
			$(".label[for*=q1]>img").remove();
			$(".label[for*=q1]").children().css("opacity","1");
			$(".label[for*=q1]").find("input").prop('checked', false);
			if($(this).attr("i") == "0" && array1.length < 3){
				array1.push($(this));
				$(this).attr("i", "1");
			}else if($(this).attr("i") == "0"){
				alert("3개 이상의 note를 선택할 수 없습니다.");
			}else{
				$(this).attr("i", "0");
				for(var j = 0; j < array1.length; j++){
					if(array1[j].children().eq(1).html() == $(this).children().eq(1).html()){
						array1.splice(j, 1);
						break;
					}
				}
			}
			for(var i = 0; i < array1.length; i++){
				array1[i].children().css("opacity", "0.4");
				array1[i].find("input").prop('checked', true);
				array1[i].prepend('<img src="/choiceimg/checkIcon.png" style ="width:80px; height:80px; position: absolute; z-index:1; top:25px; left:30px;">');
			}
			return false;
		});
		$(".label[for*=q2]").click(function(){
			$(".label[for*=q2]>img").remove();
			$(".label[for*=q2]").children().css("opacity","1");
			$(".label[for*=q2]").find("input").prop('checked', false);
			if($(this).attr("i") == "0" && array2.length < 3){
				array2.push($(this));
				$(this).attr("i", "1");
			}else if($(this).attr("i") == "0"){
				alert("3개 이상의 note를 선택할 수 없습니다.");
			}else{
				$(this).attr("i", "0");
				for(var j = 0; j < array2.length; j++){
					if(array2[j].children().eq(1).html() == $(this).children().eq(1).html()){
						array2.splice(j, 1);
						break;
					}
				}
			}
			for(var i = 0; i < array2.length; i++){
				array2[i].children().css("opacity", "0.4");
				array2[i].find("input").prop('checked', true);
				array2[i].prepend('<img src="/choiceimg/checkIcon.png" style ="width:80px; height:80px; position: absolute; z-index:1; top:25px; left:30px;">');
			}
			return false;
		});
		//제약조건 만들기
		$(".label[for*=q3]").click(function(){
			$(".label[for*=q3]>img").remove();
			$(".label[for*=q3]").children().css("opacity","1");
			$(".label[for*=q3]").find("input").prop('checked', false);
			if($(this).attr("i") == "0" && array3.length < 3){
				array3.push($(this));
				$(this).attr("i", "1");
			}else if($(this).attr("i") == "0"){
				alert("3개 이상의 note를 선택할 수 없습니다.");
			}else{
				$(this).attr("i", "0");
				for(var j = 0; j < array3.length; j++){
					if(array3[j].children().eq(1).html() == $(this).children().eq(1).html()){
						array3.splice(j, 1);
						break;
					}
				}
			}
			for(var i = 0; i < array3.length; i++){
				array3[i].children().css("opacity", "0.4");
				array3[i].find("input").prop('checked', true);
				array3[i].prepend('<img src="/choiceimg/checkIcon.png" style ="width:80px; height:80px; position: absolute; z-index:1; top:25px; left:30px;">');
			}
			return false;
		});
		//step4
		$(".span").click(function(){
			$(".span").css("backgroundColor", "white").css("color", "black");
			$(this).children("input").checked;
			$(this).children("input").parent().css("backgroundColor", "black").css("color", "white");
		});
		$(".span2").click(function(){
			$(".span2").css("backgroundColor", "white").css("color", "black");
			$(this).children("input").checked;
			$(this).children("input").parent().css("backgroundColor", "black").css("color", "white");
		});
		$("#cancel").click(function(){
			$("#view").val("");
			if($("#view").prop("disabled")){
				$("#view").attr("disabled", false);
				$("#cancel").css("backgroundColor", "white").css("color", "black");
			}else{
				$("#view").prop("disabled", true);
				$("#cancel").css("backgroundColor", "black").css("color", "white");
			}
			$("#output").css("display", "none");
		});
		$(".verticalabel").click(function(){
			$(".verticalabel>span").css("opacity","1");
			$(".verticalabel>img").remove();
			$(this).children().css("opacity","0.4");
			$(this).prepend('<img src="/choiceimg/checkIcon.png" style ="width:80px; height:80px; position: absolute; z-index:1; top:25px; left:10px;">');
		});
		//브랜드 스크립트 시작
		$(window).scroll(function(){
			$("#output").css("display","none");
			$("#output").children().remove();
		});
		var i = 0;
		var rowMax = 8;
		$("#view").keyup(function(event){
			switch(event.keyCode){
				case 13: 
					for(var j = 0; j < rowMax; j++){
						if($("#output>div").eq(j).css("backgroundColor") != 'rgb(255, 255, 255)'){
							$("#view").val($("#output>div").eq(j).html());
							$("#output").css("display","none");
						}
					}
					
					i = -1;
					break;
					//좌측 키나 우측 키 누르면 에러
				case 37:
				case 39:
					$("#output").css("display","none");
					i = -1;
					break;
				case 38: 
					$("#output").children().css("backgroundColor","white");
					$("#output").css("display","");
					if(i > 0){
						$("#output").children().eq(--i).css("backgroundColor","#aaa");
					}else if(i == 0){
						$("#output").children().eq(i).css("backgroundColor","#aaa");
					}
					break;
				case 40: 
					$("#output").children().css("backgroundColor","white");
					i++;
					$("#output").css("display","");
					
					if(i < rowMax){
						$("#output").children().eq(i).css("backgroundColor","#aaa");
					}else{
						i--;
						$("#output").children().eq(i).css("backgroundColor","#aaa");
					}
					break;
				default:
					$("#output").children().css("backgroundColor","white");
					var msg = $("#view").val();
					i = -1;
					$.ajax({
						url : "/viewBrand",
						data : {msg:msg},
						type : "get",
						success : function(data){
							var temp = "";
							var color1 = '"#aaa"';
							var color2 = '"white"';	
							rowMax = Math.min(data.length, 8);
												
							for(var i = 0; i < rowMax; i++){
								temp += "<div style = 'box-sizing: border-box; color:black; cursor:pointer; padding:6px;' onclick = 'brand(this)' onmouseover='this.style.background="+color1+"' onmouseout='this.style.background="+color2+"'>" + data[i] + "</div>";
							}
							$("#output").html(temp);
							$("#output").children().css("backgroundColor","white");
							$("#output").css("display","");
						},
						error : function(){
							console.log("서버전송실패");
						}
					});
			}
			
			
		});
			
	});
	function goPage(go, me){
		if($(me).parent().parent().find("label[i=1]").length != 0){
			for(var i = 1; i < 5; i++){
				$("#step"+i).css("display", "none");
			}
			$("#step"+go).css("display", "");
		}else{
			alert("하나 이상 선택해주세요");
			return false;
		}
	}
	function backPage(go){
		for(var i = 1; i < 5; i++){
			$("#step"+i).css("display", "none");
		}
		$("#step"+go).css("display", "");
	}
	$('form').submit(function(e) {
		if($("input[type='radio']:checked").length < 2){
			alert("비어있는 값이 있습니다.");
			e.preventDefault();
		    e.stopPropagation();
		}
	});
</script>
</section>
<%@ include file = "/WEB-INF/views/common/footer.jsp" %>
</body>
</html>