<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="utenti">

	<tr>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Email</th>
		<th></th>
		<th>Opzioni</th>
		<th></th>
	</tr>
	<tbody>
		<c:forEach items="${listStaff}" var="hDesk">
			<tr>
				<td>${hDesk.name}</td>
				<td>${hDesk.surname}</td>
				<td>${hDesk.email}</td>
				<td><a href="#" class="btn"><button>sospendi</button></a></td>
				<td><a href="#" class="btn"><button>elimina</button></a></td>
				<td><a href="#" class="btn"><button>promuovi</button></a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<style>

table {
	position: absolute;
	z-index: 2;
	left: 50%;
	right: 50%;
	top:60%;
	bottom:40%;
	transform: translate(-50%, -50%);
	width: 60%;
	border-collapse: collapse;
	border-spacing: 0;
	box-shadow: 0 2px 15px rgba(64, 64, 64, .7);
	border-radius: 12px 12px 0 0;
	overflow: hidden;
}

td, th {
	padding: 15px 20px;
	text-align: center;
}

th {
	background-color: #6468e3;
	color: #fafafa;
	font-family: 'Open Sans', Sans-serif;
	font-weight: 200;
	text-transform: uppercase;
}

tr {
	width: 100%;
	background-color: #fafafa;
	font-family: 'Montserrat', sans-serif;
}

tr:nth-child(even) {
	background-color: #eeeeee;
}

.a {
	cursor: pointer;
}

a:link {
	color: black;
}

a.btn:hover {
	color: red;
}

a:visited {
	color: black;
}

</style>
