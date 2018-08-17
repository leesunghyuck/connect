<%@page import="lsh.service.CalendarVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
/*
		$("div").click(function(){
			var divId = $(this).attr("id");

			var $form = $('<form></form>');
			$form.attr('action', '/calendar/calendarView.do');
			$form.attr('method', 'post');
			$form.appendTo('body');

			var divId = $("<input type='hidden' value= "+divId+" name='divId'>");

			$form.append(divId);
			$form.submit();
		});
*/
		$("#addBtn").click(function(){
			location.href="/calendar/calendarWriteForm.do";
		});

	});

</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 달력</title>

<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
} /* 브라우저별 기본 여백 차이가 있기에 작성한다. */
body {
	font-size: 9pt;
}

td {
	font-size: 10pt;
	width: 100px;
}
tr {
	height: 20px;
}

a {
	cusor: pointer;
	color: #000000;
	text-decoration: none;
	font-size: 9pt;
	line-height: 150%;
}

a:HOVER, a:ACTIVE {
	font-size: 9pt;
	color: #F28011;
	text-decoration: underline;
}
</style>
</head>
<body>
	<div align="center">
		<table width="300" border="0" cellpadding="1" cellspacing="2">
			<tr height="30">
				<td align="center">
					<a href="calendar.do?year=&month="> ◀ </a> <b>년 월</b>
					<a href="calendar.do?year=&month="> ▶ </a>
				</td>
				<td align="right"><input type="button" id="addBtn" value="일정 추가" style="margin-top: 10px;"/></td>
			</tr>
		</table>
		<c:forEach var="item" items="${map }">
				${item.key } = ${item.value }
		</c:forEach>
		<br />
		<br />
		<c:forEach var="item" items="${calList }">
			<h4>[ ${item.startMonth }.${item.startDay } ~ ${item.endMonth }.${item.endDay } ]</h4>
		</c:forEach>
		<table width="700" border="0" cellpadding="2" cellspacing="1" bgcolor="#ffffff" >
			<tr height="40">
				<td align="center" bgcolor="#e6e4e6" width="100"><font color="red">일</font></td>
				<td align="center" bgcolor="#e6e4e6" width="100">월</td>
				<td align="center" bgcolor="#e6e4e6" width="100">화</td>
				<td align="center" bgcolor="#e6e4e6" width="100">수</td>
				<td align="center" bgcolor="#e6e4e6" width="100">목</td>
				<td align="center" bgcolor="#e6e4e6" width="100">금</td>
				<td align="center" bgcolor="#e6e4e6" width="100"><font color="blue">토</font></td>
			</tr>
		</table>

		<!-- 1주차 -->
		<table border="1" width="700" border="0" cellpadding="2" cellspacing="1">
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 0}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td width="100"><c:if test="${ item.value[status.index] ne 0}">${item.value[status.index]}</c:if></td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 0}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td>
								<c:forEach begin="0" end="6" varStatus="status_2">
									<c:if test="${item.value[status.index] ge calList[status_2.index].startDay && item.value[status.index] le calList[status_2.index].endDay}">
										<div style="background: ${calList[status_2.index].category };">${calList[status_2.index].title }</div>
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="0" end="6" varStatus="status">
					<td>
						&nbsp;
					</td>
				</c:forEach>
			</tr>
		</table>

		<!-- 2주차 -->
		<table border="1" width="700" border="0" cellpadding="2" cellspacing="1">
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 1}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td width="100">${item.value[status.index]}</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 1}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td>
								<c:forEach begin="0" end="6" varStatus="status_2">
									<c:if test="${item.value[status.index] ge calList[status_2.index].startDay && item.value[status.index] le calList[status_2.index].endDay}">
										<div style="background: ${calList[status_2.index].category };">${calList[status_2.index].title }</div>
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="0" end="6" varStatus="status">
					<td>
						&nbsp;
					</td>
				</c:forEach>
			</tr>
		</table>

		<!-- 3주차 -->
		<table border="1" width="700" border="0" cellpadding="2" cellspacing="1">
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 2}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td width="100">${item.value[status.index]}</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 2}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td>
								<c:forEach begin="0" end="6" varStatus="status_2">
									<c:if test="${item.value[status.index] ge calList[status_2.index].startDay && item.value[status.index] le calList[status_2.index].endDay}">
										<div style="background: ${calList[status_2.index].category };">${calList[status_2.index].title }</div>
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="0" end="6" varStatus="status">
					<td>
						&nbsp;
					</td>
				</c:forEach>
			</tr>
		</table>

		<!-- 4주차 -->
		<table border="1" width="700" border="0" cellpadding="2" cellspacing="1">
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 3}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td width="100">${item.value[status.index]}</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 3}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td>
								<c:forEach begin="0" end="6" varStatus="status_2">
									<c:if test="${item.value[status.index] ge calList[status_2.index].startDay && item.value[status.index] le calList[status_2.index].endDay}">
										<div style="background: ${calList[status_2.index].category };">${calList[status_2.index].title }</div>
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="0" end="6" varStatus="status">
					<td>
						&nbsp;
					</td>
				</c:forEach>
			</tr>
		</table>

		<!-- 5주차 -->
		<table border="1" width="700" border="0" cellpadding="2" cellspacing="1">
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 4}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td width="100">${item.value[status.index]}</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="item" items="${map }" varStatus="status">
					<c:if test="${item.key eq 4}">
						<c:forEach begin="0" end="6" varStatus="status">
							<td>
								<c:forEach begin="0" end="6" varStatus="status_2">
									<c:if test="${item.value[status.index] ge calList[status_2.index].startDay && item.value[status.index] le calList[status_2.index].endDay}">
										<div style="background: ${calList[status_2.index].category };">${calList[status_2.index].title }</div>
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="0" end="6" varStatus="status">
					<td>
						&nbsp;
					</td>
				</c:forEach>
			</tr>
		</table>

		<!-- 6주차 -->
		<c:forEach var="item" items="${map }" varStatus="status">
			<c:if test="${item.key eq 5}">
				<table border="1" width="700" border="0" cellpadding="2" cellspacing="1">
					<tr>
						<c:forEach var="item" items="${map }" varStatus="status">
							<c:if test="${item.key eq 5}">
								<c:forEach begin="0" end="6" varStatus="status">
									<td width="100">${item.value[status.index]}</td>
								</c:forEach>
							</c:if>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="item" items="${map }" varStatus="status">
							<c:if test="${item.key eq 0}">
								<c:forEach begin="0" end="6" varStatus="status">
									<td>
										<c:forEach begin="0" end="6" varStatus="status_2">
											<c:if test="${item.value[status.index] ge calList[status_2.index].startDay && item.value[status.index] le calList[status_2.index].endDay}">
												<div style="background: ${calList[status_2.index].category };">${calList[status_2.index].title }</div>
											</c:if>
										</c:forEach>
									</td>
								</c:forEach>
							</c:if>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach begin="0" end="6" varStatus="status">
							<td>
								&nbsp;
							</td>
						</c:forEach>
					</tr>
				</table>
			</c:if>
		</c:forEach>
	</div>
</body>

</html>
