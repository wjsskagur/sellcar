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
<form id="memberlevel" action="memberLevel.do" method="post">
<div>
	<h3>${member.mem_id} 님의 회원등급을 변경합니다.</h3><br>
	<select	id="mem_auth" name="mem_auth">
		<option value="2" selected>일반</option>
		<option value="3">관리자</option>
	</select>
	<input type="hidden" value="${member.mem_num}" name="mem_num"/> 
	<br>
		<div>
	<input type="submit" value="변경">
	<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/management/member.do'">
	</div>
</div>
</form>
