<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div style="text-transform: uppercase;" class="container">
	<div class="item-wrap">
		<div class="item-html">
			<input id="tab-1" type="radio" name="tab" class="item-insert" checked>
				<label for="tab-1" class="tab">Login</label>
			<div class="insert-item-form">
				<form:form class="insert-in-html" method="post"
					modelAttribute="staff"
					action="${pageContext.request.contextPath}/staff/login">

					<div class="group">
						<form:input class="input" path="email"
							value="${ datiLogin.email }" required="required"
							placeholder="Email" />
					</div>
					<br />
					<div class="group">
						<form:input class="input" type="password" path="password"
							value="${ datiLogin.password }" required="required"
							placeholder="Password" />
					</div>
					<br />
					<div class="group">
						<button class="button" type="submit" value="Login">accedi</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>