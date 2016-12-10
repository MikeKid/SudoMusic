<%@ include file="header.jsp" %>
<html>
<head>
<title><spring:message code="main.title"/></title>
</head>

<body>
	<br>
	<h3>
		<spring:message code="login.title.long"/>
	</h3>
	<spring:message code="${message}" htmlEscape="false"/>
	
	<form method="POST" action="/SudoMusic/login">
	    <table>
		    <tr>
		        <td><label path="email"><spring:message code="form.field.email"/></label></td>
		        <td><input type="email" name="email" value="example@domain.xxx"/></td>
		        <!-- data-ng-pattern="/^[a-z0-9._-]+\.[a-z]{2,4}$/i" -->
		    </tr>
		    <tr>
		        <td><label path="password"><spring:message code="form.field.password"/></label></td>
		        <td><input type="password" name="password" /></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="<spring:message code="form.button.login.label"/>"/>
		        </td>
		    </tr>
		</table>  
	</form>
</body>
</html>
<%@ include file="footer.jsp" %>