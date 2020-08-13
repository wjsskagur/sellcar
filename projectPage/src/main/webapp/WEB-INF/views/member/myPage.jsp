<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>마이페이지</h2>
	<h3>[${user_id}] 님 의 마이페이지입니다.</h3>
	
<div class="align-center">
<hr size="1" width="80%">
아이디  ${user_id} 이름 ${user_name} <input type="button" value="비밀번호 변경" onclick="location.href='${pageContext.request.contextPath}/member/changePassword.do'">
<hr size="1" width="80%">
이메일 ${user_email} 연락처  ${user_cell}
<hr size="1" width="80%">
주소 ${user_addr}  ${user_addr2}
<hr size="1" width="80%">
<input type="button" value="정보수정" onclick="location.href='${pageContext.request.contextPath}/member/update.do'">
<input type="button" value="회원탈퇴" onclick="location.href='${pageContext.request.contextPath}/member/delete.do'">
</div>
<c:import url="/sell/sellview.do"/>