<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<jsp:include page="templates/header.jsp">
	<jsp:param value="home" name="title"/>
	</jsp:include>

<c:if test = "${staff != null}">

		<c:choose>
         
         <c:when test = "${staff.roleId ==1}">
           <!--  ADMIN -->
           <jsp:include page="WEB-INF/views/admin/homeAdmin.jsp">
           </jsp:include>
         </c:when>
         
         <c:when test = "${staff.roleId ==2}">
            <!--  HELP DESK -->
           <jsp:include page="WEB-INF/views/helpDesk/homeHelpDesk.jsp">
           </jsp:include>
         </c:when>
         
      </c:choose>
      
      </c:if>
      
<c:if test="${staff == null}">
	<p>per proseguire devi effettuare il login</p>
</c:if>
      

<jsp:include page="templates/footer.jsp"></jsp:include>