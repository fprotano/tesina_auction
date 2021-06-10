<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/templates/header.jsp">
	<jsp:param value="${ title }" name="title"/>
</jsp:include>
<br>
<c:if test="${not empty sessionScope.staff.name }">
<p>${ sessionScope.staff.name } </p>
</c:if>
${ message } <br>

<c:choose>

         <c:when test = "${sessionScope.staff.roleId == 1}">
            <jsp:include page="admin/homeAdmin.jsp" />
         </c:when>
         
         <c:when test = "${sessionScope.staff.roleId == 2}">
            <jsp:include page="helpDesk/homeHelpDesk.jsp" />
         </c:when>
         
         <c:otherwise>
         	<c:out value="per proseguire, effettua il login" /><br><br>
            <jsp:include page="login.jsp" />
         </c:otherwise>
      </c:choose>

<jsp:include page="/templates/footer.jsp"></jsp:include>