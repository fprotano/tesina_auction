<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="post" modelAttribute="insertStaff" 
					action="${pageContext.request.contextPath}/staff/admin-insert">

	<label>Email: </label>
	<br/>
	 <form:input path="email" required="required" />
	<br/>
	
	<!-- 
	<label>Password: </label>
	<br/>
	 <form:input path="password" />
	<br/>
	 -->
	 
	<label>Nome: </label>
	<br/>
	<form:input path="name" required="required" />
	<br/>
	
	<label>Cognome: </label>
	<br/>
	<form:input path="surname" required="required" />
	<br/>
	
	<c:if test="${ not empty roles }" >
		<label for="role">Ruolo: </label>
		<select name="roleId" id="role" required="required" >
			<option value="" disabled></option>
			<!--  
			<c:forEach var = "i" begin = "0" end = "${ roles.size() }">
				<option value="${ i }">${ roles[i] }</option>
			</c:forEach>
			-->
			<c:forEach items = "${ roles }" var = "role">
				<option value="${ role.id }">${ role.title }</option>
			</c:forEach>
		</select>
		<br/>
	</c:if>
	
	<input type="submit" value="registra">
</form:form>