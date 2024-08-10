<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- Navbar  -->
<nav class="navbar-top navbar-default navbar-fixed-top nav-custom">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${contextPath}"> <img
				src="${contextPath}/resources/img/fpt-logo.png" alt="FPT Logo">
			</a>
		</div>

		<div class="navbar-collapse collapse">
			<form class="navbar-form navbar-right" role="search">
				<div class="input-group">
					<i class="fa fa-search" style="color: white" aria-hidden="true"></i>
				</div>
			</form>
		</div>
	</div>
</nav>