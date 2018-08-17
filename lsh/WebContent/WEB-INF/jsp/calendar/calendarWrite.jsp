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
		$("#addBtn").click(function(){
			location.href="/calendar/calendar.do";
		});
	});
</script>
</head>
<body>
<br/>
<form action="/calendar/calendarWrite.do" method="post">
	<div align="center" style="padding:20px;">
	<h3>게시글 쓰기</h3>
		<table border="1" style="width:1000px;">
			<tr align="center">
				<td width="300px;">제목</td>
				<td><input type="text" id="title" name="title" style="width:700px;"/></td>
			</tr>
			<tr align="center">
				<td width="300px;">장소</td>
				<td><input type="text" id="place" name="place" style="width:700px;"/></td>
			</tr>
			<tr align="center">
				<td width="300px;">범주</td>
				<td><input type="text" id="category" name="category" style="width:700px;"/></td>
			</tr>
			<tr align="center">
				<td width="300px;">일정</td>
				<td><input type="text" id="startYear" name="startYear" style="width:50px;" maxlength="4"/>
				<input type="text" id="startMonth" name="startMonth" style="width:30px;" maxlength="2"/>
				<input type="text" id="startDay" name="startDay" style="width:30px;" maxlength="2"/>
				~
				<input type="text" id="endYear" name="endYear" style="width:50px;" maxlength="4"/>
				<input type="text" id="endMonth" name="endMonth" style="width:30px;" maxlength="2"/>
				<input type="text" id="endDay" name="endDay" style="width:30px;" maxlength="2"/></td>
			</tr>
			<tr align="center"> 
				<td width="300px;">내용</td>
				<td><textarea id="content" name="content" style="width:700px; height:100px;"></textarea></td>
			</tr>
		</table>
	</form>
		<div align="right" style="padding-top:20px; padding-right: 300px;">
			<input type="button" id="addBtn" value="목록" >
			<input type="submit" value="저장" />
		</div>
</div>
</body>
</html>
