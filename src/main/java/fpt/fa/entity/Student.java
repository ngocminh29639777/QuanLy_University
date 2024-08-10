package fpt.fa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Đại diện cho thông tin của sinh viên.
 */
@Entity
public class Student {

	@Id
	private String studentID;

	@Column(name = "fullName", columnDefinition = "nvarchar(255)")
	private String fullName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate academicYear;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDay;

	@JoinColumn(name = "department")
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;

	@Column(name = "email", columnDefinition = "nvarchar(255)")
	private String email;

	private int gender;

	@Column(name = "perAddress", columnDefinition = "nvarchar(255)")
	private String perAddress;

	@Column(name = "phone", columnDefinition = "nvarchar(255)")
	private String phone;

	@Column(name = "temAddress", columnDefinition = "nvarchar(255)")
	private String temAddress;

	@JoinColumn(name = "university")
	@ManyToOne(fetch = FetchType.LAZY)
	private University university;

	/**
	 * Phương thức khởi tạo không tham số của đối tượng Student.
	 */
	public Student() {
		super();
	}

	/**
	 * Phương thức khởi tạo có tham số của đối tượng Student.
	 * 
	 * @param studentID    mã sinh viên
	 * @param fullName     họ và tên sinh viên
	 * @param academicYear năm học của sinh viên
	 * @param birthDay     ngày sinh của sinh viên
	 * @param department   khoa của sinh viên
	 * @param email        email của sinh viên
	 * @param gender       giới tính của sinh viên (1: Nam, 0: Nữ)
	 * @param perAddress   địa chỉ thường trú của sinh viên
	 * @param phone        số điện thoại của sinh viên
	 * @param temAddress   địa chỉ tạm trú của sinh viên
	 * @param university   trường đại học của sinh viên
	 */
	public Student(String studentID, String fullName, LocalDate academicYear, LocalDate birthDay, Department department,
			String email, int gender, String perAddress, String phone, String temAddress, University university) {
		super();
		this.studentID = studentID;
		this.fullName = fullName;
		this.academicYear = academicYear;
		this.birthDay = birthDay;
		this.department = department;
		this.email = email;
		this.gender = gender;
		this.perAddress = perAddress;
		this.phone = phone;
		this.temAddress = temAddress;
		this.university = university;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(LocalDate academicYear) {
		this.academicYear = academicYear;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPerAddress() {
		return perAddress;
	}

	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTemAddress() {
		return temAddress;
	}

	public void setTemAddress(String temAddress) {
		this.temAddress = temAddress;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	/**
	 * Ghi đè phương thức toString để hiển thị thông tin về đối tượng Student.
	 * 
	 * @return chuỗi thông tin về đối tượng Student
	 */
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", fullName=" + fullName + ", academicYear=" + academicYear
				+ ", birthDay=" + birthDay + ", department=" + department + ", email=" + email + ", gender=" + gender
				+ ", perAddress=" + perAddress + ", phone=" + phone + ", temAddress=" + temAddress + ", university="
				+ university + "]";
	}

}
