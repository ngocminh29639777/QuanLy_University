package fpt.fa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Đại diện cho thông tin của một khoa trong trường đại học.
 * 
 */

@Entity
public class Department {

	@Id
	private String departmentID;

	@Column(name = "departmentName", columnDefinition = "nvarchar(255)")
	private String departmentName;

	@Column(name = "description", columnDefinition = "nvarchar(255)")
	private String description;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Student> students;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<UniDepart> unideparts;

	/**
	 * Phương thức khởi tạo không tham số của đối tượng Department.
	 */
	public Department() {
		super();
	}

	/**
	 * Phương thức khởi tạo có tham số của đối tượng Department.
	 * 
	 * @param departmentID   mã khoa
	 * @param departmentName tên khoa
	 * @param description    mô tả
	 */
	public Department(String departmentID, String departmentName, String description) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.description = description;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	 * Ghi đè phương thức toString để hiển thị thông tin về đối tượng Department.
	 * 
	 * @return chuỗi thông tin về đối tượng Department
	 */
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", description="
				+ description + "]";
	}

}
