<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ listHelpCenter.size()>1 }">
	
	<table>
		<tr>
			<th>domanda</th>
			<th>data creazione</th>
			<th>ultimo aggiornamento</th>
			<th>utente</th>
		</tr>
	
		<c:forEach items="${listHelpCenter}" var="domanda">
			<tr>
				<a href="helpCenter/thread/${domanda.id}">
					<td>${domanda.question}</td>
					<td>${domanda.createdAt}</td>
					<c:if test="${empty domanda.updatedAt}">
						<td>${domanda.createdAt}</td>
					</c:if>
					<c:if test="${not empty domanda.updatedAt}">
						<td>${domanda.updatedAt}</td>
					</c:if>
					<td>${domanda.User.surname } ${domanda.User.name}</td>
				</a>
			</tr>
		</c:forEach>
		
	</table>
</c:if>
