<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="findIdCheck.do" method="get">
	<div class="page-main-style">
		<c:if test="${!empty mem_id}">
		<ul>
			<li>
				이름 : ${mem_name}
			</li>
			<li>
				아이디 : ${mem_id}
			</li>
		</ul>
		</c:if>
		<c:if test="${empty mem_id}">
			<div class="align-cetner">
				<%= request.getParameter("mem_name") %>${message}
			</div>
		</c:if>
		<div class="align-center">
			<input type="button" value="로그인" onclick="location.href='${pageContext.request.contextPath}/member/login.do'">
			<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
	</div>
</form>