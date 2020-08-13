<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//비밀번호 변경 체크
		$('#mem_pw').keyup(function(){
			if($('#confirm_passwd').val()!='' && $('#confirm_passwd').val()!=$(this).val()){
				$('#message_id').text('비밀번호 불일치').css('color','red');
			}else if($('#confirm_passwd').val()!='' && $('#confirm_passwd').val()==$(this).val()){
				$('#message_id').text('비밀번호 일치').css('color','black');
			}
		});
		
		$('#confirm_passwd').keyup(function(){
			if($('#mem_pw').val()!='' && $('#mem_pw').val()!=$(this).val()){
				$('#message_id').text('비밀번호 불일치').css('color','red');
			}else if($('#mem_pw').val()!='' && $('#mem_pw').val()==$(this).val()){
				$('#message_id').text('비밀번호 일치').css('color','black');
			}
		});
		
		$('#change_form').submit(function(){
			if($('#old_pw').val()==''){
				alert('현재 비밀번호를 입력하세요!');
				$('#old_pw').focus();
				return false;
			}
			if($('#mem_pw').val()==''){
				alert('변경할 비밀번호를 입력하세요!');
				$('#mem_pw').focus();
				return false;
			}
			if($('#mem_pw').val()!=$('#confirm_passwd').val()){
				$('#message_id').text('비밀번호 불일치').css('color','red');
				return false;
			}
		});	
	});
	
</script>
<div class="page-main-style">
	<h2>비밀번호 변경</h2>
	<form:form action="changePassword.do" commandName="memberVO" id="change_form">
		<form:hidden path="mem_num"/>
		<ul>
			<li>
				<label for="old_pw">현재 비밀번호</label>
				<form:password path="old_pw"/>
				<form:errors path="old_pw" cssClass="error-color"/>
			</li>
			<li>
				<label for="mem_pw">변경할 비밀번호</label>
				<form:password path="mem_pw"/>
				<form:errors path="mem_pw" cssClass="error-color"/>
			</li>
			<li>
				<label for="confirm_passwd">변경할 비밀번호 확인</label>
				<input type="password" id="confirm_passwd">
				<span id="message_id" class="error-color"></span>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
	</form:form>
</div>