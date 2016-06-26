<%@ include file="/WEB-INF/jsp/header.jsp" %> <!-- TODO Path should come from config -->
<html>
<head>
<title>Index</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
	<br>
	<div style="text-align:center">
		<h3>
			<spring:message code="index.title.long"/>
		</h3>
	</div>
	
	<div style="text-align:center">
		<spring:message code="index.message.greeting"/>
		<br/>
		<br/>
		<a href="login"><spring:message code="login.title.short"/></a> - <a href="register"><spring:message code="register.title.short"/></a>
		<br/>
	</div>	
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>