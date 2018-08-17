<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){


	});

</script>
</head>
<body>
<br/>

<div align="center" style="padding:20px;">
	<h3>게시판 목록</h3>
		<div align="right" style="font-size: 12px; padding-right: 300px; padding-bottom: 10px;">총 <span style="color: red">${totalCount }</span>건</div>
		<table border="1" style="width:;" class="table">
		<thead>
			<tr align="center">
				<td width="50px;" scope="cols">번호</td>
				<td width="300px;">제목</td>
				<td width="100px;">작성자명</td>
				<td width="250px;">작성날짜</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="item">
				<tr>
					<td align="center">${item.seq }</td>
					<td><a href="/board/boardView.do?seq=${item.seq }">${item.title }</a></td>
					<td align="center">${item.createName}</td>
					<td><fmt:formatDate value="${ item.createDate }" pattern="yyyy-MM-dd HH:mm" /></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<input type="button" onclick="location.href='/board/boardWriteForm.do'" value="글쓰기" />
</div>

</body>
</html>
