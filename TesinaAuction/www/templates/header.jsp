<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-3.6.0.min.js"></script> 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="ckeditor/ckeditor.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${param.title}</title>



</head>
<body>

<c:if test =" ${ staff == null}">
	
	<form action="staff/login" method="post">
	
		<label for="email">Email : </label>
		<input type="text" name="email" id="email" />
	
		<label for="password">Password : </label>
		<input type="password" name="password" id="password" />
		
		<input type="submit" />
		
	</form>

</c:if>
	
<c:if test = "${user !=null}">
     	<li><a href="staff/logOut.jsp">logout</a></li>
    	<li><a href="updateUtente.jsp">modifica account</a></li>
</c:if>

<!-- 

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Home</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
            
            <a href="#">Esempio di link</a>
            
            </li>
            
            
            
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<div class="container" style="margin-top:10px">

 -->

<br/><br/><br/>
