package fpt.fa.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Đại diện cho mối quan hệ giữa đại học và khoa.
 */
@Entity
public class UniDepart {

	@EmbeddedId
	private UniDepartID id;

	@JoinColumn(name = "universityID")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("universityID")
	private University university;

	@JoinColumn(name = "departmentID")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("departmentID")
	private Department department;

	/**
	 * Khởi tạo một đối tượng UniDepart không có tham số.
	 */
	public UniDepart() {
		super();
	}

	/**
	 * Khởi tạo một đối tượng UniDepart với các tham số đã chỉ định.
	 * 
	 * @param id         ID của UniDepart
	 * @param university đại học
	 * @param department khoa
	 */
	public UniDepart(UniDepartID id, University university, Department department) {
		super();
		this.id = id;
		this.university = university;
		this.department = department;
	}

	public UniDepartID getId() {
		return id;
	}

	public void setId(UniDepartID id) {
		this.id = id;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, id, university);
	}

	/**
	 * Phan Ngoc Minh Ghi đè phương thức equals để so sánh hai đối tượng UniDepart.
	 * 
	 * @param obj đối tượng cần so sánh với UniDepart hiện tại
	 * @return true nếu hai đối tượng UniDepart giống nhau, ngược lại trả về false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniDepart other = (UniDepart) obj;
		return Objects.equals(department, other.department) && Objects.equals(id, other.id)
				&& Objects.equals(university, other.university);
	}

}
