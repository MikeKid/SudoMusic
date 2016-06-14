<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="main.title"/></title>
</head>
<body>
	<h3><spring:message code="about.title.long"/></h3>
	<spring:message code ="${aboutUsText}" />
</body>
</html>
<%@ include file="footer.jsp" %>