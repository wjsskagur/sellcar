<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources//css/bootstrap.min.css">
<style>
*{
	float:center;
	text-align:center;
} 
</style>
<form id="level" action="memberclear.do" method="post">
<div class="page-main-style">
	<input type="hidden" value="${member.mem_num}" name="mem_num"/>
	<h3>${member.mem_id} 님의 회원정보를 <br>삭제하시겠습니까?</h3><br>
	
	<input type="submit" value="삭제">
	<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/management/member.do'">
</div>
</form>