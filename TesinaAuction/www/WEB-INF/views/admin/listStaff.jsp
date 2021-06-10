<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<table>

	<thead>
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th></th>
			<th></th>
			<th></th>
		</tr> 
	</thead>
	
	<tbody>
			<c:forEach items="${listStaff}" var="hDesk">
				<tr>
					<td>${hDesk.name}</td>
					<td>${hDesk.surname}</td>
					<td>${hDesk.email}</td>
					<td><a href="#"><button>sospendi</button></a></td>
					<td><a href="#"><button>elimina</button></a></td>
					<td><a href="#"><button>promuovi</button></a></td>
				</tr>
			</c:forEach>
	</tbody>

</table>