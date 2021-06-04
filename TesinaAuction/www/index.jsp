<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%
String cp = request.getContextPath();
%>
<jsp:include page="templates/header.jsp">
<jsp:param value="Index" name="title"/>
</jsp:include>
It works!
<jsp:include page="templates/footer.jsp"></jsp:include>
<jsp:forward page="staff/index"></jsp:forward>
<!-- 	
	<jsp:include page="templates/header.jsp" />

<c:if test = "${staff != null}">

		<c:choose>
         
         <c:when test = "${staff.roleId ==1}">
           
           <jsp:include page="WEB-INF/views/admin/homeAdmin.jsp" />
         </c:when>
         
         <c:when test = "${staff.roleId ==2}">
            
           <jsp:include page="WEB-INF/views/helpDesk/homeHelpDesk.jsp" />
         </c:when>
         
      </c:choose>
      
      </c:if>
      
<c:if test="${staff == null}">
	<p>per proseguire devi effettuare il login</p>
</c:if>
      

<jsp:include page="templates/footer.jsp" />
-->