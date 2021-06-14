<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:if test="${(empty action) || (action !='storico')}">
	<a href="${pageContext.request.contextPath}/helpCenter/allThreads">storico thread</a>
</c:if>

<c:if test="${empty action }">
	<c:if test="${ listHelpCenter.size()>0 }">
	
		<table>
			<tr>
				<th>domanda  </th>
				<th>data creazione  </th>
				<th>ultimo aggiornamento  </th>
				<th>utente  </th>
				<th></th>
			</tr>
		
			<c:forEach items="${listHelpCenter}" var="domanda">
				<tr>
						<td>${domanda.question}</td>
						<td>${domanda.createdAt}</td>
						<c:if test="${empty domanda.updatedAt}">
							<td>${domanda.createdAt}</td>
						</c:if>
						<c:if test="${not empty domanda.updatedAt}">
							<td>${domanda.updatedAt}</td>
						</c:if>
						<td>${domanda.userDidQuestion.surname } ${domanda.userDidQuestion.name}</td>
					
						<td>
							<form:form method="post" modelAttribute="goToThread" 
									action="${pageContext.request.contextPath}/helpCenterThread/thread"> 
				
								<form:hidden path = "id" value = "${ domanda.id }" /> 
								
								<input type="submit" value="vai al thread">
							</form:form> 
						</td>
				</tr>
				
			</c:forEach>
			
		</table>
	</c:if>
	
	<c:if test="${listHelpCenter.size()==0 }">
		<p>nessuna domanda in attesa di risposta</p>
		
		<!-- FAI METODO TIMED PER RIACRIMENTO DELLA LISTA -->
	</c:if>

</c:if>

<c:if test="${ not empty action }" >

	<c:choose>
	
		<c:when test="${ action == 'thread' }" >
			<jsp:include page="threadHelpDesk.jsp" />
		</c:when>
	
	</c:choose>


</c:if>
