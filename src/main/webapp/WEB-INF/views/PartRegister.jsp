<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">

			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome to Part Register Page</h3>
			</div>

			<div class="card-body">

				<form:form action="save" method="POST" modelAttribute="part">


					<div class="row">
						<div class="col-4">
							<label for="partCode">PART CODE</label>
						</div>
						<div class="col-4">
							<form:input path="partCode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partWid">PART WIDTH</label>
						</div>
						<div class="col-4">
							<form:input path="partWid" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partLen">PART LENGTH</label>
						</div>
						<div class="col-4">
							<form:input path="partLen" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partHgt">PART HEIGHT</label>
						</div>
						<div class="col-4">
							<form:input path="partHgt" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="baseCost">BASE COST</label>
						</div>
						<div class="col-4">
							<form:input path="baseCost" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">BASE CURRENCY</label>
						</div>
						<div class="col-4">
							<form:select path="baseCurrency" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="YES">INR</form:option>
								<form:option value="NO">USD</form:option>
								<form:option value="NO">AUS</form:option>
								<form:option value="NO">ERU</form:option>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="uomOb">UOM</label>
						</div>
						<div class="col-4">
							<form:select path="uomOb.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${uomMap }" />
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="omSaleOb">SALE</label>
						</div>
						<div class="col-4">
							<form:select path="omSaleOb.orderId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${omSaleMap}" />
							</form:select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="omPurchaseOb">PURCHASE</label>
						</div>
						<div class="col-4">
							<form:select path="omPurchaseOb.orderId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${omPurchaseMap}" />
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="note">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" />
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>

