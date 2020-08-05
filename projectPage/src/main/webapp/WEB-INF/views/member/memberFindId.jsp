<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#findId_form').submit(function(){
			if($('#mem_name').val() == '' || $('#mem_cell').val() == '') {
				alert("이름 / 연락처를 적어주시기 바랍니다.");
				return false;
			}
		});
	});
</script>
<form:form action="findId.do" commandName="memberVO" id="findId_form">
<div class="page-main-style">
	<ul>
		<li>
			<label for="mem_name">이름</label>
			<form:input path="mem_name" name="mem_name" />
		</li>
		<li>
			<label for="mem_cell">연락처</label>
			<form:input path="mem_cell" name="mem_cell" />
		</li>
	</ul>
	<div class="align-center">
		<input type="submit" value="아이디 찾기">
		<input type="button" value="뒤로가기" onclick="location.href='${pageContext.request.contextPath}/member/login.do'">
	</div>
</div>
</form:form>