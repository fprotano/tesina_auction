<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <a href="${pageContext.request.contextPath}/helpCenter/HelpCenterOpenPosts" >lista thread ancora aperti</a> --%>
<%-- <a href="${pageContext.request.contextPath}/helpCenter/HelpCenterToAnswer" >lista thread in attesa di risposta</a> --%>

<c:if test="${ threads.size()>0 }">
	<c:forEach items="${ threads }" var="thread">
	<!-- 	<table> -->
	<!-- 		<thead> -->
	<!-- 			<tr> -->
	<!-- 				<th>Data creazione</th> -->
	<!-- 				<th>domanda</th> -->
	<!-- 				<th>risposta</th> -->
					
	<!-- 			</tr> -->
				
	<!-- 			<tr> -->
	<%-- 				<td>${thread.createdAt }</td> --%>
	<%-- 				<td>${thread.question }</td> --%>
	<%-- 				<td>${thread.answer }</td> --%>
	<!-- 			</tr> -->
	<!-- 		</thead> -->
		
	<!-- 	</table> -->
		<p>data creazione domanda : ${thread.createdAt }</p>
		<p>domanda : ${thread.question }</p>
		<c:if test="${not empty thread.answer }">
			<p>risposta : ${ thread.answer }</p><br>
		</c:if>
		<c:if test="${thread.answer==null }">
			<form:form method="post" modelAttribute="threadToAnswer" 
										action="${pageContext.request.contextPath}/helpCenterThread/answer"> 
					
									<form:hidden path = "id" value = "${ thread.id }" />
									<label>Risposta : </label><br/>
									<form:input path="answer" required="required" />
									
									<input type="submit" value="invia risposta">
				
			</form:form>
		</c:if>
		
	</c:forEach>
	
	<c:if test="${ not empty currentThread && currentThread.closedAt == null }">
		<form:form method="post" modelAttribute="threadToAnswer" 
									action="${pageContext.request.contextPath}/helpCenter/close"> 
				
								<form:hidden path = "helpCenterId" value = "${ currentThread.id }" />
								<input type="submit" value="chiudi thread">
		</form:form>
	</c:if>
	
	<c:if test="${ not empty currentThread && not empty currentThread.closedAt }">
		<p>post chiuso il ${ currentThread.closedAt }</p>
	</c:if>
</c:if>

<c:if test="${ threads.size()==0 }">
	<p>nessun thread</p>
</c:if>