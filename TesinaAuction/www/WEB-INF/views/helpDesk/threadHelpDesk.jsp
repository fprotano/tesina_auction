<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p>aperto thread</p>

<a href="${pageContext.request.contextPath}/helpCenter/HelpCenterToAnswer" >lista thread</a>

<c:forEach items="${ threads }" var="thread">
	${thread.createdAt }<br>
	${thread.question }<br>
	<c:if test="${not empty thread.answer }">
		<p>${ thread.answer }</p><br>
	</c:if>
	<c:if test="${thread.answer==null }">
		<form:form method="post" modelAttribute="threadToAnswer" 
									action="${pageContext.request.contextPath}/helpCenterThread/answer"> 
				
								<form:hidden path = "id" value = "${ thread.id }" />
								<lablel>Risposta : </lable><br/>
								<form:input path="answer" required="required" />
								
								<input type="submit" value="invia risposta">
			
		</form:form>
	</c:if>
</c:forEach>