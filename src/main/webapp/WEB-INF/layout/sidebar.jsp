<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<!-- Sidebar  -->
<section>
	<!-- Left Sidebar -->
	<aside id="leftsidebar" class="sidebar">
		<!-- Menu -->
		<div class="menu" id="sidebarAdmin">
			<ul class="list">
				<li class="header"><a href="#"><span>MENU</span></a></li>
				<li class="header"><a href="${contextPath}/"><span>Home</span></a>
				</li>
				<li class="header">
					<div class="row">
						<div class="col-sm-10">
							<a href="#"><span>Student University</span></a>
						</div>
						<div class="col-sm-2">
							<a href="#"><i class="fa fa-plus" aria-hidden="true"></i></a>

						</div>
					</div>

				</li>
				<li class="header">
					<div class="row">
						<div class="col-sm-10">
							<a href="#" id="universityManager"><span>University
									Manager</span></a>
						</div>
						<div class="col-sm-2">
							<a href="#"><i class="fa fa-plus" aria-hidden="true"></i></a>

						</div>
					</div>

					<ul id="submenuUniversityManager" style="display: none;">

						<li>
							<div class="row">
								<!-- Create University -->
								<div class="col-sm-12">
									<a href="${contextPath}/university/create"><span
										style="margin-right: 5px"><i class="fa fa-plus-circle"
											aria-hidden="true"></i></span> Create University</a>
								</div>
							</div>
						</li>

						<li>
							<div class="row">
								<!-- Create University -->
								<div class="col-sm-12">
									<a href="${contextPath}/university/list"><span
										style="margin-right: 5px"><i class="fa fa-plus-circle"
											aria-hidden="true"></i></span> List University</a>
								</div>
							</div>
						</li>


					</ul>
				</li>
				<li class="header">
					<div class="row">
						<div class="col-sm-10">
							<a href="#"><span>Department University</span></a>
						</div>
						<div class="col-sm-2">
							<a href="#"><i class="fa fa-plus" aria-hidden="true"></i></a>

						</div>
					</div>
				</li>
			</ul>
		</div>
		<!-- #Menu -->
	</aside>
	<!-- #END# Left Sidebar -->
</section>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		// Bắt sự kiện click vào "University Manager"
		document.getElementById("universityManager").addEventListener(
				"click",
				function(event) {
					event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ <a>

					// Chọn submenu của "University Manager"
					var submenu = document
							.getElementById("submenuUniversityManager");

					// Toggle hiển thị của submenu
					if (submenu.style.display === "none") {
						submenu.style.display = "block";
					} else {
						submenu.style.display = "none";
					}
				});
	});
</script>