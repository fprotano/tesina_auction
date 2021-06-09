<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div>

	<a href="${pageContext.request.contextPath}/staff/admin-insert"><button>Inserisci staff </button> </a>
	<a href="#"><button>Lista staff </button> </a>

</div>

<c:if test="${ not empty action }" >

	<c:choose>
	
		<c:when test="${ action == 'insert' }" >
			<jsp:include page="insertStaff.jsp" />
		</c:when>
	
	</c:choose>


</c:if>