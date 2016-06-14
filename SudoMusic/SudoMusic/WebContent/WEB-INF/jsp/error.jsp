<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ include file="header.jsp" %>
<html>
<head>
<title><spring:message code="error.title.long"/></title>
</head>
<body>

	<br>
	<div style='text-align:center;'>
			<h3>
				<spring:message code="error.title.long"/>
			</h3>
			<spring:message code="error.message.reported"/>
			<br><br>
			<a href="/SudoMusic/"><spring:message code="error.button.back"/></a>
	</div>
	
	<br><br>
	${exception.getMessage()}

</body>
</html>
<%@ include file="footer.jsp" %>