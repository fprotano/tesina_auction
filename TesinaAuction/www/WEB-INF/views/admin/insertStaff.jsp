<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div style="text-transform: uppercase;" class="container">
	<div class="item-wrap">
		<div class="item-html">
			<input id="tab-1" type="radio" name="tab" class="item-insert" checked><label
				for="tab-1" class="tab">Nuovo membro</label>
			<div class="insert-item-form">
				<form:form class="insert-in-html" method="post"
					modelAttribute="insertStaff"
					action="${pageContext.request.contextPath}/staff/admin-insert">

					<div class="group">
						<form:input class="input" path="email" required="required" placeholder="Email" />
					</div>

					<div class="group">
						<form:input class="input" path="name" required="required" placeholder="Nome" />
					</div>

					<div class="group">
						<form:input class="input" path="surname" required="required"
							placeholder="Cognome" />
					</div>

					<c:if test="${ not empty roles }">
						<div class="group">
							<select name="roleId" id="role" required="required">
								<option value="" disabled>Scegli una opzione</option>
								<!--  
			<c:forEach var = "i" begin = "0" end = "${ roles.size() }">
				<option value="${ i }">${ roles[i] }</option>
			</c:forEach>
			-->
								<c:forEach items="${ roles }" var="role">
									<option value="${ role.id }">${ role.title }</option>
								</c:forEach>
							</select>
						</div>
					</c:if>
					<div class="group">
						<button class="button" type="submit" value="registra">Salva</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>


<style>
.container {
	text-align: center;
}

h1 {
	text-align: center;
	color: red;
	text-transform: uppercase;
	font-family: sans-serif;
	margin-bottom: 10px;
	font-size: 15px;
}

.item-wrap {
	width: 100%;
	margin: auto;
	max-width: 525px;
	min-height: 450px;
	position: relative;
	background:
		url(https://png.pngtree.com/png-vector/20190623/ourlarge/pngtree-hammer-judge-icon-png-image_1511242.jpg);
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
}

.item-html {
	width: 100%;
	height: 100%;
	position: absolute;
	padding: 90px 70px 50px 70px;
	background: rgba(40, 57, 101, .9);
}

.item-html .insert-in-html {
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	position: absolute;
}

.item-html .item-insert, .insert-item-form .group .check {
	display: none;
}

.item-html .tab, .insert-item-form .group .label, .insert-item-form .group .button
	{
	text-transform: uppercase;
}

.item-html .tab {
	font-size: 22px;
	margin-right: 15px;
	padding-bottom: 5px;
	margin: 0 15px 10px 0;
	display: inline-block;
	border-bottom: 2px solid transparent;
}

.item-html .item-insert:checked+.tab, .item-html .sign-up:checked+.tab {
	color: #fff;
	border-color: #1161ee;
}

.insert-item-form {
	min-height: 345px;
	position: relative;
	perspective: 1000px;
	transform-style: preserve-3d;
}

.insert-item-form .group {
	margin-bottom: 15px;
}

.insert-item-form .group .label, .insert-item-form .group .input,
	.insert-item-form .group .button {
	width: 100%;
	color: #fff;
	display: block;
}

.insert-item-form .group .input, .insert-item-form .group .button {
	border: none;
	padding: 15px 20px;
	border-radius: 25px;
	background: rgba(255, 255, 255, .1);
}

.insert-item-form .group input[data-type="password"] {
	text-security: circle;
	-webkit-text-security: circle;
}

.insert-item-form .group .label {
	color: #aaa;
	font-size: 12px;
}

.insert-item-form .group .button {
	background: #1161ee;
}

.insert-item-form .group label .icon {
	width: 15px;
	height: 15px;
	border-radius: 2px;
	position: relative;
	display: inline-block;
	background: rgba(255, 255, 255, .1);
}

.insert-item-form .group label .icon:before, .insert-item-form .group label .icon:after
	{
	content: '';
	width: 10px;
	height: 2px;
	background: #fff;
	position: absolute;
	transition: all .2s ease-in-out 0s;
}

.insert-item-form .group label .icon:before {
	left: 3px;
	width: 5px;
	bottom: 6px;
	transform: scale(0) rotate(0);
}

.insert-item-form .group label .icon:after {
	top: 6px;
	right: 0;
	transform: scale(0) rotate(0);
}

.insert-item-form .group .check:checked+label {
	color: #fff;
}

.insert-item-form .group .check:checked+label .icon {
	background: #1161ee;
}

.insert-item-form .group .check:checked+label .icon:before {
	transform: scale(1) rotate(45deg);
}

.insert-item-form .group .check:checked+label .icon:after {
	transform: scale(1) rotate(-45deg);
}

.item-html .item-insert:checked+.tab+.sign-up+.tab+.insert-item-form .insert-in-html
	{
	transform: rotate(0);
}

.item-html .sign-up:checked+.tab+.insert-item-form .sign-up-htm {
	transform: rotate(0);
}

::placeholder {
	color: #fff;
}

.btn-class {
	text-transform: uppercase;
	border-radius: .7em;
}
select{
font-size: 17px;
width: 250px;
border-radius: 5px;}
</style>
