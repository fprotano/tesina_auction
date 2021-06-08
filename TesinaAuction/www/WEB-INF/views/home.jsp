<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/templates/header.jsp">
	<jsp:param value="home" name="title"/>
</jsp:include>

<c:choose>
         
         <c:when test = "${staff.roleId == 1}">
            <jsp:include page="${pageContext.request.contextPath}adminMio/homeAdmin.jsp" />
         </c:when>
         
         <c:when test = "${staff.roleId == 1}">
            <jsp:include page="${pageContext.request.contextPath}helpDesk/homeHelpDesk.jsp" />
         </c:when>
         
         <c:otherwise>
         	<c:out value="per proseguire, effettua il login" /><br><br>
            <jsp:include page="${pageContext.request.contextPath}login.jap" />
         </c:otherwise>
      </c:choose>

<jsp:include page="/templates/footer.jsp"></jsp:include>