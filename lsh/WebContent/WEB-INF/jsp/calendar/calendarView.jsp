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
		$("#calBtn").click(function(){
			location.href="/calendar/calendar.do";
		});
	});
</script>
</head>
<body>
<br/>
<div align="center" style="padding:20px;">
	<h3>일정 보기</h3>
		<table border="1" style="width:800px;">
			<c:forEach var="item" items="${calList }">
				<tr>
					<td align="center" width="200px;">제목</td>
					<td>${item.title } / ${item.seq }</td>
				</tr>
				<tr>
					<td align="center">장소</td>
					<td>${item.place }</td>
				</tr>
				<tr>
					<td align="center">일시</td>
					<td>${item.startDate } ~ ${item.endDate }</td>
				</tr>
				<tr>
					<td align="center">설명</td>
					<td>${item.content }</td>
				</tr>
			</c:forEach>
		</table>
		<div align="right" style="padding-top:20px; padding-right: 300px;">
			<input type="button" id="calBtn" name="" value="달력으로" />
		</div>
</div>
</body>
</html>
