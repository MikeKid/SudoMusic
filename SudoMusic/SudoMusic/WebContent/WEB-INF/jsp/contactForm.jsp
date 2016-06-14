<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title><spring:message code="main.title"/></title>
</head>

<body>
	<h3><spring:message code="contactForm.title.long"/></h3>
	<br/><br/>
	
	<c:if test="${not empty infoMessage}">
		<spring:message code="${infoMessage}"/>
	</c:if>
	
	<form method="POST" action="/SudoMusic/contactForm">
		        
       	<label path="fullName">
       		<spring:message code="form.field.fullName"/>
       	</label>
        
        <input name="fullName" />
        <form:errors path="fullName" class="control-label" />
        
    	<div class="form-group has-error">
	        <label path="email"><spring:message code="form.field.email"/></label>
	        <input name="email" />
	        <form:errors path="email" class="control-label">asdf</form:errors>
        </div>
        
   	    <label path="message"><spring:message code="form.field.message"/></label>
        <textarea name="message"></textarea>
        <form:errors path="message" class="control-label" />
        
        <label path="register"><spring:message code="form.field.register"/></label>
        <input name="register" type="checkbox"/>
	    
	    <c:if test="register">
		    <tr>
		        <label path="subscribe"><spring:message code="form.field.subscribe"/></label>
		        <input name="subscribe" type="checkbox"/>
		    </tr>
	    </c:if>
		
		<div>
   	    	<input type="submit" value="<spring:message code="form.button.submit.label"/>"/>
   	    </div>

	</form>
	
	<%@ include file="footer.jsp" %>
</body>
</html>