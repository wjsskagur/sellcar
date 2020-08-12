<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 200px;
    height: 200px;
  }
  td img {
  width: 100%;
}
	td{
	text-align:center;
	}
</style>
<div class="page-main-style">
	<h2>차량후기</h2>
	<c:if test="${count == 0}">
		<div class="result-display">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<table>
			<tr
				style="background: url('../images/center.gif') repeat-x; text-align: center;">
			</tr>
			<c:forEach var="carre" items="${list}">
				<tr>
				<td><img src="imageView.do?num=${carre.num}"></td>
					<tr><td>글번호: ${carre.num}</td></tr>
					<tr><td width="200">제목: <a href="${pageContext.request.contextPath}/carre/detail.do?num=${carre.num}">${carre.title}</a></td></tr>
					<tr><td>작성자: ${carre.mem_id}</td></tr>
					<tr><td>작성일: ${carre.reg_date}</td></tr>
					<tr><td>조회수: ${carre.hit}</td></tr>
			</c:forEach>
		</table>
		<div class="align-center">${pagingHtml}</div>
		<div class="align-right">
			<c:if test="${!empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='carrewrite.do'">
			</c:if>
		</div>
	</c:if>
	<form id="search_form" action="carrelist.do" method="get">
		<ul class="search">
			<li><select name="keyfield">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="id">id</option>
			</select></li>
			<li><input type="search" size="16" name="keyword" id="keyword">
			</li>
			<li><input type="submit" value="찾기">			<input type="button" value="글쓰기" onclick="location.href='carrewrite.do'"></li>
		</ul>
	</form>
</div>