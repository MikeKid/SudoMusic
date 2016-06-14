<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="header.jsp" %>
<html>
<head>
<title><spring:message code="main.title"/></title>
</head>

<body>
	<h3><spring:message code="register.title.long"/></h3>
	<spring:message code="${message}"/>
	<form method="POST" action="/SudoMusic/register">
	   <table><!--
		    <tr>
		        <td><label path="id">Id</label></td>
		        <td><input name="id" /></td>
		    </tr> -->
		    <tr>
		        <td><label path="name"><spring:message code="form.field.name"/></label></td>
		        <td><input name="name" /></td>
		    </tr>
		    <tr>
	        <td><label path="surname"><spring:message code="form.field.surname"/></label></td>
		        <td><input name="surname" /></td>
		    </tr>
		    <tr>
	        <td><label path="email"><spring:message code="form.field.email"/></label></td>
		        <td><input name="email" /></td>
		    </tr>
		    <tr>
	        <td><label path="password"><spring:message code="form.field.password"/></label></td>
		        <td><input name="password" /></td>
		    </tr>
		    <tr>
	        <td><label path="passwordRepeat"><spring:message code="form.field.passwordRepeat"/></label></td>
		        <td><input name="passwordRepeat" /></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="<spring:message code="form.button.register.label"/>"/>
		        </td>
		    </tr>
		</table>  
	</form>

</body>
</html>
<%@ include file="footer.jsp" %>