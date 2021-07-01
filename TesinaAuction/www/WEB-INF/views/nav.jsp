<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.navbar {
	width: 100%;
	background-color: black;
	overflow: auto;
	
}

.logo {
	color: white;
	float: left;
	margin-left: 30px;
	margin-top: 10px;
	font-size: 35px;
	font-family: 'Zilla Slab', serif;
	
}
</style>
<body>
<div class="navbar">

		<h1 class="logo" style="text-transform: uppercase;">Auction</h1>
<%-- 		<c:if test="${not empty sessionScope.staff }"> --%>
<!-- 			<li class="logout" style="float: right;"> -->
<%-- 				<a href="${pageContext.request.contextPath}/staff/logout"><button>log out</button></a> --%>
<!-- 			</li> -->
<%-- 		</c:if> --%>
	</div>
</body>
</html>