<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/css/header/style.css">
	<link rel="stylesheet" href="/css/header/responsive.css">
	<script type="text/javascript" src="/js/bootstrap.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insert perfume</title>
	<style>
			.field{
			  --uiFieldPlaceholderColor: var(--fieldPlaceholderColor, #767676);
			}			
			.field__input{ 
			  background-color: transparent;
			  border-radius: 0;
			  border: none;			
			  -webkit-appearance: none;
			  -moz-appearance: none;			
			  font-family: inherit;
			  font-size: 1em;
			}	
			.field__input:focus::-webkit-input-placeholder{
			  color: var(--uiFieldPlaceholderColor);
			}			
			.field__input:focus::-moz-placeholder{
			  color: var(--uiFieldPlaceholderColor);
			  opacity: 1;
			}
			.a-field{
			  display: inline-block;
			}			
			.a-field__input{ 
			  display: block;
			  box-sizing: border-box;
			  width: 100%;
			}			
			.a-field__input:focus{
			  outline: none;
			}			
			.a-field{
			  --uiFieldHeight: var(--fieldHeight, 40px);  
			  --uiFieldBorderWidth: var(--fieldBorderWidth, 2px);
			  --uiFieldBorderColor: var(--fieldBorderColor);			
			  --uiFieldFontSize: var(--fieldFontSize, 1em);
			  --uiFieldHintFontSize: var(--fieldHintFontSize, 1em);			
			  --uiFieldPaddingRight: var(--fieldPaddingRight, 15px);
			  --uiFieldPaddingBottom: var(--fieldPaddingBottom, 15px);
			  --uiFieldPaddingLeft: var(--fieldPaddingLeft, 15px);   			
			  position: relative;
			  box-sizing: border-box;
			  font-size: var(--uiFieldFontSize);
			  padding-top: 1em;  
			}			
			.a-field__input{
			  height: var(--uiFieldHeight);
			  padding: 0 var(--uiFieldPaddingRight) 0 var(--uiFieldPaddingLeft);
			  border-bottom: var(--uiFieldBorderWidth) solid var(--uiFieldBorderColor);  
			}			
			.a-field__input::-webkit-input-placeholder{
			  opacity: 0;
			  transition: opacity .2s ease-out;
			}			
			.a-field__input::-moz-placeholder{
			  opacity: 0;
			  transition: opacity .2s ease-out;
			}			
			.a-field__input:not(:placeholder-shown) ~ .a-field__label-wrap .a-field__label{
			  opacity: 0;
			  bottom: var(--uiFieldPaddingBottom);
			}			
			.a-field__input:focus::-webkit-input-placeholder{
			  opacity: 1;
			  transition-delay: .2s;
			}			
			.a-field__input:focus::-moz-placeholder{
			  opacity: 1;
			  transition-delay: .2s;
			}			
			.a-field__label-wrap{
			  box-sizing: border-box;
			  width: 100%;
			  height: var(--uiFieldHeight);				
			  pointer-events: none;
			  cursor: text;			
			  position: absolute;
			  bottom: 0;
			  left: 0;
			}			
			.a-field__label{
			  position: absolute;
			  left: var(--uiFieldPaddingLeft);
			  bottom: calc(50% - .5em);			
			  line-height: 1;
			  font-size: var(--uiFieldHintFontSize);			
			  pointer-events: none;
			  transition: bottom .2s cubic-bezier(0.9,-0.15, 0.1, 1.15), opacity .2s ease-out;
			  will-change: bottom, opacity;
			}			
			.a-field__input:focus ~ .a-field__label-wrap .a-field__label{
			  opacity: 1;
			  bottom: var(--uiFieldHeight);
			}						
			.a-field_a1 .a-field__input{
			  transition: border-color .2s ease-out;
			  will-change: border-color;
			}			
			.a-field_a1 .a-field__input:focus{
			  border-color: var(--fieldBorderColorActive);
			}						
			.a-field_a2 .a-field__label-wrap::after{
			  content: "";
			  box-sizing: border-box;
			  width: 0;
			  height: var(--uiFieldBorderWidth);
			  background-color: var(--fieldBorderColorActive);			
			  position: absolute;
			  bottom: 0;
			  left: 0;  			
			  will-change: width;
			  transition: width .285s ease-out;
			}			
			.a-field_a2 .a-field__input:focus ~ .a-field__label-wrap::after{
			  width: 100%;
			}
			.a-field_a3{
			  padding-top: 1.5em;
			}			
			.a-field_a3 .a-field__label-wrap::after{
			  content: "";
			  box-sizing: border-box;
			  width: 100%;
			  height: 0;			
			  opacity: 0;
			  border: var(--uiFieldBorderWidth) solid var(--fieldBorderColorActive);			
			  position: absolute;
			  bottom: 0;
			  left: 0;			
			  will-change: opacity, height;
			  transition: height .2s ease-out, opacity .2s ease-out;
			}			
			.a-field_a3 .a-field__input:focus ~ .a-field__label-wrap::after{
			  height: 100%;
			  opacity: 1;
			}			
			.a-field_a3 .a-field__input:focus ~ .a-field__label-wrap .a-field__label{
			  bottom: calc(var(--uiFieldHeight) + .5em);
			}			
			.field{
			  --fieldBorderColor: #D8D8D8;
			  --fieldBorderColorActive: #000;
			}			
			body{
			  margin: 0;			  
			  min-height: 100vh;
			  display: flex;
			  flex-direction: column;
			}			
			.page{
			  box-sizing: border-box;
			  width: 100%;
			  max-width: 1000px;
			  margin: auto;
			  padding: 15px;			  
			  display: grid;
			  grid-gap: 30px;
			  align-items: flex-end;
			  order: 1;
			}			
			@media (min-width: 481px){			  
			  .page{
			      grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
			  }
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
			}
			.btn1:hover {
			    background-color: black;
			    color: white;
			    transition: .60s;
			}
			.btn-tertiary {
			  color: #555;
			  padding: 0;
			  line-height: 40px;
			  width: 300px;
			  margin: auto;
			  display: block;
			  border: 2px solid #555;
			  &:hover, 
			    &:focus {
			      color: lighten(#555, 20%);
			      border-color: lighten(#555, 20%);
			    }
			}
			
			/* input file style */
			
			.input-file {
				width: 0.1px;
				height: 0.1px;
				opacity: 0;
				overflow: hidden;
				position: absolute;
				z-index: -1;
				cursor: pointer;
			  + .js-labelFile {
			    overflow: hidden;
			    text-overflow: ellipsis;
			    white-space: nowrap;
			    padding: 0 10px;
			    cursor: pointer;
			    .icon:before {
			      //font-awesome
			      content: "\f093";
			    }
			    &.has-file {
			      .icon:before {
			        //font-awesome
			        content: "\f00c";
			        color: #5AAC7B;
			      }
			    }
			  }
			}

	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section style="padding-top:60px; padding-bottom:30px;">
		<div class="table-wrapper" style="text-align:center; width:50%; margin:0 auto;">
			<form action="/insertPerfume" method="post" enctype="multipart/form-data">
				<div id="img-viewer" style="margin-bottom:20px;">
					<img id="img-view" width="200" height="200">
				</div>
				<div>
				  <input type="file" name="perfumePhotoname" id="file" class="input-file" onchange="loadImg(this)">
				  <label for="file" class="btn btn-tertiary js-labelFile" >
					   <i class="icon fa fa-check"></i>
					   <span class="js-fileName">UPLOAD</span>
					</label>				  
				</div>
				<div class="page">
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeBrand" placeholder="　"  required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">brand</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeName" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">name</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeVolume" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">volume (only number)</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeDensity" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">density</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeTop" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">top note</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeMiddle" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">middle note</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeBase" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">base note</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeGender" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">gender</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumePrice" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">price (only number)</span>
				    </span>
				  </label>
				  <label class="field a-field a-field_a2">
				    <input class="field__input a-field__input" name="perfumeDetail" placeholder="　" required>
				    <span class="a-field__label-wrap">
				      <span class="a-field__label">detail img link</span>
				    </span>
				  </label>
				</div>
				<br>
				
				
				<br>
				<button type="submit" class="btn1">등록하기</button>
			</form>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
	function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function(e) {
	            $('#imagePreview').css('background-image', 'url('+e.target.result +')');
	            $('#imagePreview').hide();
	            $('#imagePreview').fadeIn(650);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	$("#imageUpload").change(function() {
	    readURL(this);
	});
	function loadImg(f) {
		// f = input 태그
		console.log(f.files); // input 태그에 선택된 파일을 배열로 가져옴 (1개여도 무조건)
		if (f.files.length != 0 && f.files[0] != 0) { // 배열의 길이가 0이 아니고 (파일이 올라간 여부) , 용량이 0이 아닌지
			var reader = new FileReader();
			reader.readAsDataURL(f.files[0]); // 매개변수로 지정한 파일의 경로
			reader.onload = function(e) { // 파일 경로를 다 읽어오고 나면
				$("#img-view").attr('src', e.target.result);
			}
		} else { // 파일이 있다가 없어지는 경우
			$("#img-view").attr('src', '');
		}
	}
	$('.input-file').each(function() {
	    var $input = $(this),
	        $label = $input.next('.js-labelFile'),
	        labelVal = $label.html();
	    
	   $input.on('change', function(element) {
	      var fileName = '';
	      if (element.target.value) fileName = element.target.value.split('\\').pop();
	      fileName ? $label.addClass('has-file').find('.js-fileName').html(fileName) : $label.removeClass('has-file').html(labelVal);
	   });
	  });
	</script>
</body>
</html>