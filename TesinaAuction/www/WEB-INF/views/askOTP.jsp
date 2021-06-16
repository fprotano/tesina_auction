<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div style="text-transform: uppercase;" class="container">
	<div class="item-wrap">
		<div class="item-html">
			<input id="tab-1" type="radio" name="tab" class="item-insert" checked>
				<label for="tab-1" class="tab">Inserisci codice OTP</label>
			<div class="insert-item-form">
				<form:form class="insert-in-html" method="post"
					modelAttribute="accountAskOTP"
					action="${pageContext.request.contextPath}/staff/login-OTP">
					
					<form:hidden path = "email" value = "${ accountAskOTP.email }" /> 
					<form:hidden path = "password" value = "${ accountAskOTP.password }" /> 

					<div class="group">
						<form:input class="input" path="otpCode"
							value="${ accountAskOTP.otpCode }" required="required"
							placeholder="codice OTP" />
					</div>
					<br />
					<div class="group">
						<button class="button" type="submit" value="invia">invia</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>