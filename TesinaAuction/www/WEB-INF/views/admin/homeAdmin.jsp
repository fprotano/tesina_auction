<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="caption">
	<i>In questa area riservata &egrave; possibile gestire ogni account
		amministrativo</i>
</div>



	<a href="${pageContext.request.contextPath}/staff/admin-insert"><button
			class="option-btn" style="text-align: center;">Inserisci
			staff</button> </a> <a
		href="${pageContext.request.contextPath}/staff/list-helpDesk"><button
			class="option-btn" style="text-align: center;">Lista staff</button> </a>



<c:if test="${ not empty action }">

	<c:choose>

		<c:when test="${ action == 'insert' }">
			<jsp:include page="insertStaff.jsp" />
		</c:when>

		<c:when test="${ action == 'listStaff' }">
			<jsp:include page="listStaff.jsp" />
		</c:when>

	</c:choose>


</c:if>

<style>
.caption {
	text-align: center;
	font-size: 18px;
	margin: 0;
	padding: 0;
}
</style>