<%@ include file="header.jsp" %>
<html>
<head>
<title><spring:message code="main.title"/></title>
<style type="text/css">
body {
	background-image: url('http://www.pptbackgrounds.net/uploads/elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg');
}
</style>
</head>

<body>

	<br>
	<div style='text-align:center;'>
			<h3><spring:message code="home.title.long"/></h3>
			<spring:message code="${message}"/>
	</div>
	
	<br><br>
</body>
</html>
<%@ include file="footer.jsp" %>