<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
	#logout{
		background-color: #A6A6A6;
  border: none;
  color: #ffffff;
  cursor: pointer;
  display: inline-block;
  font-family: 'BenchNine', Arial, sans-serif;
  font-size: 1.5em !important;
  line-height: 1em !important;
  outline: none !important;
  position: relative !important;
  text-transform: uppercase !important;
  font-weight: 700 !important;
	}
</style>
<header id="login">
				<c:if test="${user_auth == 3}">
				<a	href="${pageContext.request.contextPath}/management/member.do">회원 관리[관리자]</a>
		</c:if>
	<c:if test="${!empty user_id && user_auth > 1}">
	${user_id}님 <input type="button" id="logout" value="로그아웃" 
					onclick="location.href='${pageContext.request.contextPath}/member/logout.do'">	
	</c:if>
	<c:if test="${empty user_id}">
	<a href="${pageContext.request.contextPath}/member/registerAgree.do">회원가입</a>	
	<a href="${pageContext.request.contextPath}/member/login.do">로그인</a>
	</c:if>
</header>