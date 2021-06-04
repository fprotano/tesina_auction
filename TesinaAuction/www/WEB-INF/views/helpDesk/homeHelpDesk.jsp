<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- 
<jsp:include page="/templates/header.jsp"></jsp:include>
 -->
<c:if test="${ listHelpCenter.size()>1 }">
	
	<table>
		<tr>
			<th>domanda</th>
			<th>data creazione</th>
			<th>ultimo aggiornamento</th>
			<th>utente</th>
		</tr>
		<c:forEach items="${ listHelpCenter }" var=" domanda ">
			<a href="helpCenter/thread/${ domanda.id }">
				<td>${ domanda.question }</td>
				<td>${ domanda.createdAt }</td>
				<td>${ domanda.updatedAt }</td>
				<td>${ domanda.User.name  domanda.User.surname }</td>
			</a>
		</c:forEach>
	</table>
</c:if>

<jsp:include page="/templates/footer.jsp"></jsp:include>