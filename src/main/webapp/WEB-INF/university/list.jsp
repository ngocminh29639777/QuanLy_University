<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%--
  Created by Eclipse IDE.
  User: Phan Minh
  Date: 16/04/2024
  Time: 7:15 CH
  File: create.jsp
  To change this template use File | Settings | File Templates.
--%>
<head>
<meta charset="UTF-8">
<title>List University</title>
<jsp:include page="/WEB-INF/layout/header.jsp" />
<style>
table th {
	text-align: center;
}

table {
	user-select: none;
}

.fade-in {
	opacity: 0;
	transition: opacity 0.3s ease-in-out;
}

td {
	vertical-align: middle;
	text-align: center;
}

.fade-in.active {
	opacity: 1;
}

.image {
	width: 100%;
	color: blue;
	font-size: 40px;
}

.dtHorizontalExampleWrapper {
	max-width: 600px;
	margin: 0 auto;
}

#dtHorizontalExample th, td {
	white-space: nowrap;
}

.trash {
	color: red;
	cursor: pointer;
}

tr:hover td {
	background-color: rgb(186, 248, 248);
	transition: all 0.3s;
}
/* .table {
    background-color: rgb(227, 243, 5);
    
  } */
.overlay {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background-color: #c5c5c5;
	opacity: 0.8;
	transition: all 0.3s;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.success-container {
	width: 300px;
	height: 150px;
	background-color: #0000FF;
	color: white;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
	padding: 20px;
	opacity: 0;
	transition: opacity 0.5s ease-in-out;
}

.success-icon {
	font-size: 48px;
	margin-bottom: 10px;
}

.success-message {
	font-size: 18px;
	font-weight: bold;
}

/* Hiển thị phần tử */
.active {
	opacity: 1;
}

/* Căn lề trái và cho phép xuống dòng cho cột Address */
table td {
	text-align: left;
}

td.universityName, td.address {
	white-space: pre-wrap;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/layout/page-loader.jsp" />
	<jsp:include page="/WEB-INF/layout/navbar.jsp" />
	<jsp:include page="/WEB-INF/layout/sidebar.jsp" />

	<section class="content">
		<div class="container-fluid">
			<!-- Striped Rows -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>LIST UNIVERSITY</h2>

						</div>

						<!-- Phần tìm kiếm -->

						<div class="row " style="margin-top: 30px">
							<div class="col-12 text-center">


								<form action="${contextPath}/university/list" method="GET"
									class="form-inline my-2 my-lg-0 ">
									<div class="form-group">
										<label for="universityID" class="mr-sm-2">University
											ID:</label> <input class="form-control mr-sm-2" type="text"
											id="universityID" placeholder="University ID"
											name="universityID">
									</div>
									<div class="form-group">
										<label for="universityName" class="mr-sm-2"
											style="margin-left: 30px">University Name:</label> <input
											class="form-control mr-sm-2" type="text" id="universityName"
											placeholder="University Name" name="universityName">
									</div>
									<button class="btn btn-outline-success btn-primary my-2 my-sm-0" style="margin-left: 30px"
										type="submit">Search</button>
								</form>

							</div>
						</div> 
						
						

						<!-- Phần tìm kiếm  -->


						<div class="body table-responsive">

							<table id="dtHorizontalExample"
								class="table table-bordered table-striped"
								id="dataTable-listUniversitys">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">University ID</th>
										<th scope="col">University Name</th>
										<th scope="col">Founded Year</th>
										<th scope="col">Address</th>
										<th scope="col">Phone</th>
										<th scope="col">Modify</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${not empty listUniversitys}">
											<c:forEach items="${listUniversitys}" var="university">
												<tr>
													<td>${university.universityID}</td>
													<td class="universityName">${university.universityName}</td>
													<%-- <td>${university.foundedYear.dayOfMonth}/${university.foundedYear.monthValue}/${university.foundedYear.year}</td> --%>
													<td>${String.format('%02d', university.foundedYear.dayOfMonth)}/${String.format('%02d', university.foundedYear.monthValue)}/${university.foundedYear.year}</td>
													<td class="address">${university.address}</td>
													<td>${university.phone}</td>
													<td class="text-center"><a href="javascript:void(0);"
														onclick="confirmDelete('${university.universityID}')">
															<button class="btn btn-danger text-center" type="button"
																style="width: 40px">
																<i class="fa fa-trash fa-1.5x" aria-hidden="true"></i>
															</button>
													</a> <a
														href="${contextPath}/university/update?id=${university.universityID}">
															<button class="btn btn-primary text-center" type="button"
																style="width: 40px">
																<i class="fa fa-pencil fa-1.5x" aria-hidden="true"></i>
															</button>
													</a></td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<td colspan="4" style="text-align: center">No record</td>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>


						<!-- trang page  -->

						<div class="row px-0">
							<div class="col-12 text-center">
								<c:if test="${totalPages > 0}">
									<nav aria-label="Page navigation">
										<ul class="pagination mx-3">
											<c:if test="${currentPage > 0}">
												<li class="page-item"><a class="page-link"
													href="?page=${currentPage - 1}" aria-label="Previous">
														<span aria-hidden="true">&laquo;</span> <span
														class="sr-only">Previous</span>
												</a></li>
											</c:if>
											<c:forEach begin="0" end="${totalPages - 1}" var="i">
												<c:choose>
													<c:when test="${currentPage == i}">
														<li class="page-item active"><span class="page-link">${i + 1}<span
																class="sr-only">(current)</span></span></li>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
															href="?page=${i}">${i + 1}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:if test="${currentPage < totalPages - 1}">
												<li class="page-item"><a class="page-link"
													href="?page=${currentPage + 1}" aria-label="Next"> <span
														aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
												</a></li>
											</c:if>
										</ul>
									</nav>
								</c:if>

							</div>

						</div>


						<!--trang page  -->
						<c:if test="${param.isNewSuccess eq 'true'}">
							<!-- Kiểm tra isNewSuccess từ URL -->
							<div class="success-container" id="successContainer">
								<div class="success-icon">&#10004;</div>
								<div class="success-message">${successMessage}</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<!-- #END# Striped Rows -->


		</div>
	</section>

	<script>
		function confirmDelete(universityID) {
			var result = confirm("Are you sure you want to delete university?");
			if (result) {
				window.location.href = "${contextPath}/university/delete?id="
						+ universityID;
			}
		}

		// JavaScript để kích hoạt hiển thị thông báo thành công
		document.addEventListener("DOMContentLoaded", function() {
			showSuccessMessage();
		});

		function showSuccessMessage() {
			var successContainer = document.getElementById("successContainer");
			if (successContainer) { // Kiểm tra xem có phần tử successContainer hay không
				successContainer.classList.add("active"); // Thêm lớp active để hiển thị phần tử

				// Tự động ẩn sau 3 giây
				setTimeout(function() {
					successContainer.classList.remove("active"); // Loại bỏ lớp active
				}, 1000); // Thời gian tính bằng mili giây (3000ms = 3 giây)
			}
		}
		
		// JavaScript để xóa tham số isNewSuccess=true từ URL
		if (window.location.search.indexOf('isNewSuccess=true') > -1) {
		    var newUrl = window.location.href.replace(/(\?|&)isNewSuccess=true/, '');
		    window.history.replaceState({}, document.title, newUrl);
		}
		
	
		document.addEventListener("DOMContentLoaded", function() {
		    var searchForm = document.querySelector(".form-inline");
		    if (searchForm) {
		        searchForm.addEventListener("submit", function(event) {
		            var universityIDInput = document.getElementById("universityID");
		            var universityNameInput = document.getElementById("universityName");

		            // Loại bỏ dấu cách đầu và cuối của giá trị nhập vào trước khi gửi yêu cầu
		            universityIDInput.value = universityIDInput.value.trim();
		            universityNameInput.value = universityNameInput.value.trim();
		        });
		    }
		});
		
	</script>

	<jsp:include page="/WEB-INF/layout/script.jsp" />
	<%-- <jsp:include page="/WEB-INF/layout/footer.jsp" />  --%>
</body>
</html>