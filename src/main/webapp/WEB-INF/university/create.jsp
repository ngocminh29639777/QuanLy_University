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
<title>Create University</title>
<link rel="stylesheet" href="/resources/css/index.css">
<jsp:include page="/WEB-INF/layout/header.jsp" />

<style>
.error-msg {
	color: red;
}
 /* ngăn chặn người dùng thay đổi kích thước texarea */
.no-resize {
    resize: none;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/layout/page-loader.jsp" />
	<jsp:include page="/WEB-INF/layout/navbar.jsp" />
	<jsp:include page="/WEB-INF/layout/sidebar.jsp" />

	<section class="content">
		<div class="container-fluid">
			<!-- Vertical Layout -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>CREATE UNIVERSITY</h2>
						</div>
						<div class="body">
							<form:form id="form-create-university"
								action="${contextPath}/university/create" method="post"
								modelAttribute="university">
								<div class="row">
									<div class="col-sm-2">
										<form:label path="universityID">University ID: <span
												style="color: red;">(*)</span>
										</form:label>
										<div class="form-group">
											<div class="form-line">
												<form:input path="universityID" class="form-control"
													placeholder="" tabindex="1" maxlength="10"
													pattern="[A-Za-z0-9]+" />
												<span class="error-msg" id="universityID-error"><form:errors
														path="universityID" /></span>
												<!-- Kiểm tra và hiển thị errorMessage nếu có -->
												<c:if test="${not empty errorMessage}">
													<div class="text-danger" role="alert">
														${errorMessage}</div>
												</c:if>
											</div>
										</div>
									</div>

									<div class="col-sm-6">
										<form:label path="universityName">University Name: <span
												style="color: red;">(*)</span>
										</form:label>
										<div class="form-group">
											<div class="form-line">
												<form:input path="universityName" class="form-control"
													placeholder="" tabindex="2" maxlength="100"
													pattern="^[^\d]+$" />
												<span class="error-msg" id="universityName-error"><form:errors
														path="universityName" /></span>
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<form:label path="foundedYear">Founded Year: <span
												style="color: red;">(*)</span>
										</form:label>
										<div class="form-group">
											<div class="form-line">
												<form:input type="date" class="form-control" path="foundedYear" tabindex="3" id="foundedYear"/> 
													<span class="error-msg-2"
													id="foundedYear-error"><form:errors
														path="foundedYear"></form:errors></span>
											</div>
										</div>
									</div>
								</div>


								<!--  -->

								<div class="row">
									<div class="col-sm-2">
										<form:label path="phone">Phone: <span
												style="color: red;">(*)</span>
										</form:label>
										<div class="form-group">
											<div class="form-line">
												<form:input path="phone" class="form-control"
													placeholder="" tabindex="4" maxlength="15"
													pattern="[0-9]{1,}" />
												<span class="error-msg" id="phone-error"><form:errors
														path="phone" /></span>
											</div>
										</div>
									</div>

									<div class="col-sm-6">
										<form:label path="address">Address: <span
												style="color: red;">(*)</span>
										</form:label>
										<div class="form-group">
											<div class="form-line">
												<form:input path="address" class="form-control"
													placeholder="" tabindex="5" maxlength="150" />
												<span class="error-msg" id="address-error"><form:errors
														path="address" /></span>
											</div>
										</div>
									</div>
									<!--  -->
									<div class="col-sm-4">
										<form:label path="departmentList">
        Department List: <span style="color: red;">(*)</span>
										</form:label>
										<div class="form-group">
											<div class="form-line">
												<form:select path="departmentList" multiple="multiple"
													class="form-control" id="sel2" tabindex="6">
													<form:option value="Information Technology">Information Technology</form:option>
													<form:option value="Mechanical">Mechanical</form:option>
													<form:option value="Architecture">Architecture</form:option>
													<form:option value="Electrical">Electrical</form:option>
													<form:option value="Computer Engineering">Computer Engineering</form:option>
													<form:option value="Environmental Engineering">Environmental Engineering</form:option>
												</form:select>
												<span class="error-msg" id="departmentList-error"> <form:errors
														path="departmentList" />
												</span>
											</div>
										</div>
									</div>

								</div>

								<!--  -->

							<form:label path="vision">Vision: <span style="color: red;"></span></form:label>
<div class="form-group">
    <div class="form-line">
        <form:textarea path="vision" class="form-control no-resize"
            placeholder="" tabindex="7" rows="5" cols="50"
            maxlength="500" />
        <span class="error-msg" id="vision-error"><form:errors path="vision" /></span>
    </div>
</div>

<form:label path="mission">Mission: <span style="color: red;"></span></form:label>
<div class="form-group">
    <div class="form-line">
        <form:textarea path="mission" class="form-control no-resize"
            placeholder="" tabindex="8" rows="5" cols="50"
            maxlength="500" />
        <span class="error-msg" id="mission-error"><form:errors path="mission" /></span>
    </div>
</div>

<form:label path="introduction">Introduction: <span style="color: red;"></span></form:label>
<div class="form-group">
    <div class="form-line">
        <form:textarea path="introduction" class="form-control no-resize"
            placeholder="" tabindex="9" rows="5" cols="50"
            maxlength="500" />
        <span class="error-msg" id="introduction-error"><form:errors path="introduction" /></span>
    </div>
</div>

								<!--  -->

								<div class="row">
									<div class="col-sm-2"></div>
									<div class="col-sm-4"></div>
									<div class="col-sm-6 text-right">
										<!-- Thêm lớp text-right -->
										<button type="submit" class="btn btn-success" tabindex="4"
											onclick="showSuccessMessage()" style="width: 90px;">
											<i class="fa fa-check"></i> Save
										</button>

										<button type="button" class="btn btn-primary" tabindex="4"
											onclick="resetForm()" style="width: 90px;">
											<i class="fa fa-check"></i> Reset
										</button>

										<a href="${contextPath}/university/list"
											class="btn btn-warning" tabindex="5" style="width: 90px;">
											<i class="fa fa-remove"></i> Cancel
										</a>
									</div>
								</div>

								<!--  -->

							</form:form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<script>
	document.addEventListener("DOMContentLoaded", function() {
	    const universityIDField = document.querySelector("input[name='universityID']");
	    const universityNameField = document.querySelector("input[name='universityName']");
	    const foundedYearField = document.getElementById("foundedYear");
	    const phoneField = document.querySelector("input[name='phone']");
	    const addressField = document.querySelector("input[name='address']");
	    const departmentListField = document.getElementById("sel2");

	    // Hàm kiểm tra lỗi khi blur
	    const checkError = (field, errorElementId) => {
	        const value = field.value.trim(); // Lấy giá trị của trường nhập và loại bỏ khoảng trắng đầu và cuối
	        const errorElement = document.getElementById(errorElementId); // Lấy phần tử hiển thị thông báo lỗi tương ứng

	        // Kiểm tra nếu giá trị của trường nhập là rỗng
	        if (!value) {
	            errorElement.textContent = "Vui lòng nhập thông tin vào ô này."; // Cập nhật nội dung thông báo lỗi
	            errorElement.style.display = "block"; // Hiển thị thông báo lỗi
	            return true; // Trả về true nếu có lỗi
	        } else {
	            errorElement.textContent = ""; // Nếu không có lỗi, đặt nội dung thông báo lỗi về rỗng
	            errorElement.style.display = "none"; // Ẩn thông báo lỗi
	            return false; // Trả về false nếu không có lỗi
	        }
	    };

	    // Hàm kiểm tra lỗi trước khi submit form
	    const validateForm = () => {
	        let isValid = true; // Biến đánh dấu xem form có hợp lệ hay không

	        // Kiểm tra từng trường và cập nhật biến isValid
	        if (checkError(universityIDField, "universityID-error")) {
	            isValid = false;
	        }
	        if (checkError(universityNameField, "universityName-error")) {
	            isValid = false;
	        }
	        if (checkError(foundedYearField, "foundedYear-error")) {
	            isValid = false;
	        }
	        if (checkError(phoneField, "phone-error")) {
	            isValid = false;
	        }
	        if (checkError(addressField, "address-error")) {
	            isValid = false;
	        }
	        if (checkError(departmentListField, "departmentList-error")) {
	            isValid = false;
	        }
	        // Additional validation for date
	        const currentDate = new Date();
	        const enteredDate = new Date(foundedYearField.value);

	        if (enteredDate >= currentDate) {
	            const errorElement = document.getElementById("foundedYear-error");
	            errorElement.textContent = "Nhập ngày phải nhỏ hơn ngày hiện tại.";
	            errorElement.style.display = "block";
	            isValid = false;
	        }

	        return isValid; // Trả về kết quả cuối cùng của việc kiểm tra
	    };

	    // Thêm sự kiện cho nút Save
	    const saveButton = document.querySelector(".btn-success");
	    saveButton.addEventListener("click", () => {
	        if (!validateForm()) {
	            // Nếu form không hợp lệ, ngăn chặn việc submit form bằng cách sử dụng preventDefault()
	            event.preventDefault();
	        }
	    });
	});
		
	  // Hàm để xóa tất cả thông báo lỗi
    function clearErrors() {
        const errorMessages = document.querySelectorAll('.error-msg');
        errorMessages.forEach(function(errorMessage) {
            errorMessage.textContent = ''; // Xóa nội dung của thông báo lỗi
        });
    }

	// Hàm reset form
	function resetForm() {
	    clearErrors(); // Xóa thông báo lỗi trước khi reset form
	 // Đặt lại giá trị của các trường input
	    document.querySelector("input[name='universityID']").value = "";
	    document.querySelector("input[name='universityName']").value = "";
	    document.getElementById("foundedYear").value = "";
	    document.querySelector("input[name='phone']").value = "";
	    document.querySelector("input[name='address']").value = "";
	    
	    // Xóa thông báo lỗi cho các trường
	    document.getElementById("universityID-error").textContent = "";
	    document.getElementById("universityName-error").textContent = "";
	    document.getElementById("foundedYear-error").textContent = "";
	    document.getElementById("phone-error").textContent = "";
	    document.getElementById("address-error").textContent = "";
	    document.getElementById("departmentList-error").textContent = "";
	    document.getElementById("vision-error").textContent = "";
	    document.getElementById("mission-error").textContent = "";
	    document.getElementById("introduction-error").textContent = "";
	    
	    // Đưa con trỏ vào trường "University ID"
	    document.querySelector("input[name='universityID']").focus();
	    
	   /*  // Đặt lại giá trị của trường foundedYear
	    document.getElementById("foundedYear").value = "";

	    // Xóa thông báo lỗi cho trường foundedYear
	    document.getElementById("foundedYear-error").textContent = ""; */
	}
	
	 // Gọi hàm showSuccessMessage() khi trang được tải hoàn toàn
    document.addEventListener("DOMContentLoaded", function() {
        showSuccessMessage();
    });
	 
	 /* 
	 tạo tăng dần box/list box
	 */
    document.addEventListener("DOMContentLoaded", function() {
        // Lấy danh sách tất cả các option trong select
        var options = document.querySelectorAll('#sel2 option');
        // Chuyển danh sách từ NodeList sang mảng để sử dụng các phương thức mảng
        var optionsArray = Array.from(options);
        // Sắp xếp mảng các option theo thứ tự tăng dần của chữ cái đầu
        optionsArray.sort(function(a, b) {
            return a.text.localeCompare(b.text);
        });
        // Xóa tất cả các option trong select
        options.forEach(function(option) {
            option.remove();
        });
        // Thêm lại các option đã được sắp xếp vào select
        optionsArray.forEach(function(option) {
            document.querySelector('#sel2').appendChild(option);
        });
    });
	 
	 //con trỏ đến trường đầu tiên khi màn hình được mở
    document.addEventListener("DOMContentLoaded", function() {
        // Lấy trường nhập đầu tiên trong biểu mẫu
        const firstInputField = document.querySelector("input[name='universityID']");

        // Thiết lập con trỏ vào trường đầu tiên
        firstInputField.focus();
    });
	 
	</script>





	<jsp:include page="/WEB-INF/layout/script.jsp" />
	<%-- <jsp:include page="/WEB-INF/layout/footer.jsp" /> --%>
</body>
</html>