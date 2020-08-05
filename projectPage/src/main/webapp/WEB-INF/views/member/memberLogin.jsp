<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:if test="${count == 0}">
	${count = 1};
	<script type="text/javascript">
		alert("아이디/비밀번호를 확인하세요.");
	</script>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#login_form').submit(function() {
			if($('#id').val() == '' || $('#passwd').val() == '') {
				alert("아이디/비밀번호를 입력하세요.");
				return false;
			}
		});
	});
</script>
<form:form action="login.do" commandName="memberVO" id="login_form">
<div class="page-main-style">
	<ul class="align-center">
		<li>
			<form:input path="mem_id" id="id" placeholder="아이디를 입력하세요." />
		</li>
		<li>
			<form:password path="mem_pw" id="passwd" placeholder="비밀번호를 입력하세요." />
		</li>
	</ul>
	<div class="align-center">
		<a href="findId.do">아이디 찾기</a> | <a href="findPasswd.do">비밀번호 찾기</a> | <a href="registerAgree.do">회원가입</a>
	</div>
	<div class="align-center">
		<input type="submit" value="로그인">
	</div>
</div>
</form:form>