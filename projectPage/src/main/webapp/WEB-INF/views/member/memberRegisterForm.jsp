<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		var checkId = 0;
		
		$('#confirmId').click(function(){
			if($('#mem_id').val()==''){
				$('#message_id').css('color', 'red').text('아이디를 입력하세요.');
				return;
			}
			
			$('#message_id').text(''); // 메세지 초기화
			$('#loading').show();
			
			$.ajax({
				url:'confirmId.do',
				type:'post',
				data:{id:$('#mem_id').val()},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					$('#loading').hide();
					
					if(data.result == 'idNotFound') {
						$('#message_id').css('color','blue').text("사용 가능한 아이디입니다.");
						checkId = 1;
					} else if(data.result == 'idDuplicated') {
						$('#message_id').css('color','red').text("사용할 수 없는 아이디입니다.");
						checkId = 0;
					} else {
						checkId = 0;
						alert("Id 중복체크 오류");
					}
				},
				error:function(){
					checkId = 0;
					$('#loading').hide();
					alert("네트워크 오류 발생");
				}
			});
		});
		
		$('#mem_pw').keydown(function(){ // 비밀번호를 입력할 때 '비밀번호 불일치' 글자가 자동으로 나오도록
			var checkPasswd = 0;
			$('#message_passwdCheck').css('color', 'red').text("비밀번호 불일치");
		});
		
		$('#mem_pwCheck').keyup(function(){ // 비밀번호 확인란에 입력시 비밀번호가 맞는지 확인
			if($('#mem_pw').val() != $('#mem_pwCheck').val()){
				$('#message_passwdCheck').css('color', 'red').text("비밀번호 불일치");
				checkPasswd = 0;
			} else if($('#passwd').val() == $('#passwdCheck').val()) {
				$('#message_passwdCheck').css('color', 'blue').text("비밀번호 일치");
				checkPasswd = 1;
			}
		});
		
		// 아이디 중복안내 메세지 초기화 및 아이디 중복값 초기화
		$('#register_form #mem_id').keydown(function(){
			checkId = 0;
			$('#message_id').text("");
		});
		
		// submit 이벤트 발생시 아이디 중복체크 여부 확인
		$('#register_form').submit(function(){
			if(checkId == 0) {
				$('#message_id').css('color', 'red').text("아이디 중복체크 필수!")
				if($('#message_id').val() == ''){
					$("#mem_id").focus();
				}
				
				return false;
			}
			
			if(checkPasswd == 0){
				alert("비밀번호가 일치하지 않습니다.");
				$('#passwdCheck').text('');
				$('#passwdCheck').focus();
				return false;
			}
			
			if($('#mem_zip').val() == '') {
				$('#zipcode').css('color', 'red').text("우편번호는 필수항목")
				
				return false;
			}
		});
	})
</script>
<form:form action="register.do" commandName="memberVO" id="register_form">
<div class="page-main-style">
	<div class="align-center"><h2>회원가입</h2></div>
	<ul>
		<li>
			<label for="mem_name">이름</label>
			<form:input path="mem_name" />
			<form:errors path="mem_name" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_id">아이디</label>
			<form:input path="mem_id" />
			<input type="button" id="confirmId" value="중복확인">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" width="16" height="16" 
				style="display:none;" id="loading">
			<span id="message_id"></span>
			<form:errors path="mem_id" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_pw">비밀번호</label>
			<form:password path="mem_pw" />
			<form:errors path="mem_pw" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_pwCheck">비밀번호 확인</label>
			<input type="password" id="mem_pwCheck" name="mem_pwCheck" maxlength="16">
			<span id="message_passwdCheck"></span>
		</li>
		<li>
			<label for="mem_email">이메일</label>
			<form:input path="mem_email" />
			<form:errors path="mem_email" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_cell">연락처</label>
			<form:input path="mem_cell" />
			<form:errors path="mem_cell" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_zip">우편번호</label>
			<input type="text" name="mem_zip" id="mem_zip" size="5" maxlength="5">
			<input type="button" id="zipcode_select" value="우편번호 찾기" onclick="sample4_execDaumPostcode()">
			<span id="zipcode"></span>
		</li>
		<li>
			<label for="mem_addr">주소</label>
			<form:input path="mem_addr" />
			<form:errors path="mem_addr" cssClass="error-color" />
		</li>
		<li>
			<label for="mem-addr2">상세주소</label>
			<form:input path="mem_addr2" />
			<form:errors path="mem_addr2" cssClass="error-color" />
		</li>
	</ul>
	<div class="align-center">
		<input type="submit" value="가입완료">
		<input type="button" value="취소" onclick="${pageContext.request.contextPath}/main/main.do">
	</div>
</div>
</form:form>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('mem_zip').value = data.zonecode;
                document.getElementById('mem_addr').value = roadAddr;
               
            }
        }).open();
    }
</script>