<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

	});
</script>
</head>
<body>
<br/>
<div align="center" style="padding:20px;">
	<h3>게시글 보기</h3>
		<table border="1" style="width:1000px;">
				<tr>
					<td align="center" width="300px;">제목</td>
					<td>${viewList.title }</td>
				</tr>
				<tr>
					<td align="center" width="300px;">내용</td>
					<td><str:replace replace="NL" with="<br />" newlineToken="NL"><c:out value="${ viewList.content }" /></str:replace></td>
				</tr>
				<tr>
					<td align="center" width="300px;">작성자</td>
					<td>${viewList.createName }</td>
				</tr>
				<tr>
					<td align="center" width="300px;">작성일</td>
					<td><fmt:formatDate value="${ viewList.createDate }" pattern="yyyy-MM-dd" /></td>
				</tr>
		</table>
		<div align="right" style="padding-top:20px; padding-right: 300px;">
			<button onclick="location.href='/board/boardList.do'">목록</button>
			<button onclick="location.href='/board/boardModify.do?seq=${viewList.seq}'">수정</button>
			<button onclick="location.href='/board/boardDelete.do?seq=${viewList.seq}'">삭제</button>
		</div>
</div>
</body>
</html>
