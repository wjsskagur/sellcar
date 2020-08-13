<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
$(function(){
	
	document.getElementById('upload').onchange=function(event){
			
		var file = document.getElementById('upload');
		//파일 넓이 & 높이 체크
		var $width = 287;
		var $height = 300;
		var $target = $(this);
		//용량 체크
		if (file.files && file.files[0].size > (5 * 1024 * 1024)) {
	        alert("파일 사이즈가 5mb 를 넘습니다.");
	        $target.val('');
	    }
		//파일 읽기 기능 제공
		var reader = new FileReader();

		reader.readAsDataURL($(this)[0].files[0]);
		
		//파일의 내용을 전부 읽어들이면 이벤트가 발생
		reader.onload = function(e){
			$('body').append('<img src="" id="temp_img" style="display:none;" />');  //보이지 않는 임시 img 태그를 생성.
	           $img = $('#temp_img').attr('src', e.target.result);                          //파일을 선택했을 경우 정보를 $img 객체에 저장
	           if($img.width() == 0 || $img.height() == 0){  
	        	   alert('파일를 다시 선택하세요.');
	        	   $target.val('');
	        	   return;
	           }
	           if($img.width() > $width || $img.height() > $height){                  //가로 세로 사이즈 비교 후 반환
	              alert('지정된 크기와 맞지 않습니다.('+$width + 'x'+ $height +')');
	              $target.val('');
	              $('#temp_img').remove(); //위에서 생성한 임시 img 태그 삭제
	           } 
		};
		//파일의 내용을 읽어들일 떄 에러가 발생
		reader.onerror = function(){
				alert('파일 읽기에 실패했습니다.');
			}
		};
});

</script>
<div class="page-main-style">
	<h2>글쓰기</h2>
	<form:form action="carrewrite.do" enctype="multipart/form-data" commandName="carreVO">
		<ul>
			<li>
				<label for="title">제목</label>
				<form:input path="title"/>
				<form:errors path="title" cssClass="error-color"/>
			</li>	
			<li>
				<label for="content">내용</label>
				<form:textarea path="content"/>
				<form:errors path="content" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">파일업로드</label>
				<input type="file" name="upload" id="upload">
				<form:errors path="content" cssClass="error-color"/>
				<br>(5mb,287px*300px 이하)로 업로드해야합니다.<br>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="목록" onclick="location.href='carreview.do'">	
		</div>
	</form:form>
</div>