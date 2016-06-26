<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


	<spring:message code="languageBar.label"/> :
		<a href="?language=en"><spring:message code="languageBar.english"/></a> |
		<a href="?language=es"><spring:message code="languageBar.spanish"/></a>
	<br/>
	
	
	<div class="collapse navbar-collapse">
		<ul class="nav navbar nav">
			<li><a href="/SudoMusic/"><spring:message code="index.title.short"/></a></li>
			<li><a href="about"><spring:message code="about.title.short"/></a></li>
			<li><a href="contactForm"><spring:message code="contactForm.title.short"/></a></li>
			<li>EXPERIMENTAL <a href="welcome"><spring:message code="welcome.title.short"/></a></li>
			<li>EXPERIMENTAL <a href="error"><spring:message code="error.title.short"/></a></li>
		</ul>
	</div>
	
	<div class="collapse navbar-collapse">
		<ul class="nav navbar nav">
			<li><a href="login"><spring:message code="login.title.short"/></a></li>
			<li><a href="register"><spring:message code="register.title.short"/></a></li>
		</ul>
	</div>
	
	
</body>
</html>