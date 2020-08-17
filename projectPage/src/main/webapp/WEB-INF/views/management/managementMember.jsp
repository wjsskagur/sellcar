<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>회원목록</h2>
<table>
	<tr>
		<th>회원번호</th>
		<th>회원등급</th>
		<th>회원ID</th>
		<th>성 명</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>가입일</th>
		<th>설정</th>
	</tr>
	<c:forEach var="member" items="${list}">
	<c:if test="${member.mem_auth < 3}">
	<tr>
		<td>${member.mem_num}</td>
		<td>일반</td>
		<td><a href="memberView.do?mem_id=${member.mem_id}">${member.mem_id}</a></td>
		<td>${member.mem_name}</td>
		<td>${member.mem_cell}</td>
		<td>${member.mem_email}</td>
		<td>${member.mem_date}</td>
		<td class="align-center">
			<input type="button" value="등급변경" onclick="location.href='memberLevel.do?mem_id=${member.mem_id}'">
			<input type="button" value="강제탈퇴" onclick="location.href='memberclear.do?mem_id=${member.mem_id}'">
		</td>
	</tr>
	</c:if>
	</c:forEach>
</table>
<div class="align-center">${pagingHtml}</div>