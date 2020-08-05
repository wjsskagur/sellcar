<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/><br/>
<table style="font-family: 돋움; font-size: 10pt;" >
<tr id="bbsList">
	<td id="bbsList_title" colspan="3">
	차량 후기 게시판
	</td>
</tr>
<!-- 차량 후기 수정 -->
<tr>
	<td align="left" colspan="2" width="400">
	Total ${totalArticle } articles, ${totalPage } pages / Now Page is ${currentPage }
	</td>
	<td align="right" colspan="1" width="200">
	<input type="button" value="게시물등록" onclick="location.href='write.do'"/>
	</td>
</tr>
<tr><td style="border-bottom:2px solid #DBDBDB;" colspan="3"></td></tr>
<tr>
		<td><a href="#">삭제</a></td>
</tr>

<tr><td style="border-bottom:2px solid #DBDBDB;" colspan="3"></td></tr>	
<tr>

</tr>
</table>