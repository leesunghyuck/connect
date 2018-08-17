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
	<h3>게시글 쓰기</h3>
		<form action="/board/boardWrite.do" method="post">
			<table border="1" style="width:1000px;">
				<tr align="center">
					<td width="300px;">제목</td>
					<td><input type="text" id="title" name="title" style="width:700px;" value="${viewList.title }"/></td>
				</tr>
				<tr align="center">
					<td width="300px;">내용</td>
					<td><textarea id="content" name="content" rows="" cols="" style="width:700px; height:200px;">${viewList.content }</textarea></td>
				</tr>
			</table>
			<input type="button" value="목록" onclick="location.href='/board/boardList.do'">
			<input type="submit" value="저장" />
		</form>
</div>
</body>
</html>
