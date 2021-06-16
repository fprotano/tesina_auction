<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
.msg{
text-align: center;
font-size: 20px;
color:red;
}
.loggedUser{
text-align: center;
font-size: 27px;
font-family: inherit;
text-transform: uppercase;}

</style>

<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="/templates/header.jsp">
	<jsp:param value="${ title }" name="title"/>
</jsp:include>
<br>

<c:if test="${not empty message }" >
	<p>${message}</p>
</c:if>

<c:if test="${ empty sessionScope.staff }">
	
     <div class="msg">  <c:out value="Per proseguire effettua il login" /></div><br><br>
        <jsp:include page="login.jsp" />

</c:if>

<c:if test="${not empty sessionScope.staff }">
	<a href="${pageContext.request.contextPath}/staff/logout"><button>log out</button></a>
	<br>
	<p class="loggedUser">Benvenuto ${ sessionScope.staff.surname } ${ sessionScope.staff.name }</p><br>
	
<c:choose>

         <c:when test = "${sessionScope.staff.roleId == 1}">
            <jsp:include page="admin/homeAdmin.jsp" />
         </c:when>
         
         <c:when test = "${sessionScope.staff.roleId == 2}">
            <jsp:include page="helpDesk/homeHelpDesk.jsp" />
         </c:when>
         
      </c:choose>

</c:if>
<jsp:include page="/templates/footer.jsp"></jsp:include>









