package fpt.fa.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Đại diện cho thông tin trường đại học
 */
@Entity
public class University {

	@Id
	private String universityID;

	@Column(name = "universityName", columnDefinition = "nvarchar(255)")
	private String universityName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate foundedYear;

	@Column(name = "phone", columnDefinition = "nvarchar(15)")
	private String phone;

	@Column(name = "address", columnDefinition = "nvarchar(255)")
	private String address;

	@Column(name = "departmentList", columnDefinition = "nvarchar(255)")
	private String departmentList;

	@Column(name = "vision", columnDefinition = "nvarchar(1000)")
	private String vision;

	@Column(name = "mission", columnDefinition = "nvarchar(1000)")
	private String mission;

	@Column(name = "introduction", columnDefinition = "nvarchar(1000)")
	private String introduction;

	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Student> students;

	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<UniDepart> unideparts;

	/**
	 * Phương thức khởi tạo không tham số của đối tượng University.
	 */
	public University() {
		super();
	}

	/**
	 * Phương thức khởi tạo có tham số của đối tượng University.
	 * 
	 * @param universityID   mã trường đại học
	 * @param universityName tên trường đại học
	 * @param foundedYear    ngày thành lập
	 * @param phone          số điện thoại
	 * @param address        địa chỉ
	 * @param departmentList danh sách các khoa
	 * @param vision         tầm nhìn
	 * @param mission        nhiệm vụ
	 * @param introduction   giới thiệu
	 */

	public University(String universityID, String universityName, LocalDate foundedYear, String phone, String address,
			String departmentList, String vision, String mission, String introduction) {
		super();
		this.universityID = universityID;
		this.universityName = universityName;
		this.foundedYear = foundedYear;
		this.phone = phone;
		this.address = address;
		this.departmentList = departmentList;
		this.vision = vision;
		this.mission = mission;
		this.introduction = introduction;
	}

	public String getUniversityID() {
		return universityID;
	}

	public void setUniversityID(String universityID) {
		this.universityID = universityID;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public LocalDate getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(LocalDate foundedYear) {
		this.foundedYear = foundedYear;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(String departmentList) {
		this.departmentList = departmentList;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<UniDepart> getUnideparts() {
		return unideparts;
	}

	public void setUnideparts(Set<UniDepart> unideparts) {
		this.unideparts = unideparts;
	}

	/**
	 * Ghi đè phương thức toString để hiển thị thông tin về đối tượng University.
	 * 
	 * @return chuỗi thông tin về đối tượng University
	 */
	@Override
	public String toString() {
		return "University [universityID=" + universityID + ", universityName=" + universityName + ", foundedYear="
				+ foundedYear + ", phone=" + phone + ", address=" + address + ", departmentList=" + departmentList
				+ ", vision=" + vision + ", mission=" + mission + ", introduction=" + introduction + "]";
	}

}
