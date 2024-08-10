package fpt.fa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * 
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Đại diện cho ID composite của mối quan hệ giữa University và Department.
 *
 */
@Embeddable
public class UniDepartID implements Serializable {

	private static final long serialVersionUID = 1L;
	private String universityID;
	private String departmentID;

	/**
	 * Khởi tạo một đối tượng UniDepartID không có tham số.
	 */
	public UniDepartID() {
		super();
	}

	/**
	 * Khởi tạo một đối tượng UniDepartID với các tham số đã chỉ định.
	 * 
	 * @param universityID ID của đại học
	 * @param departmentID ID của khoa
	 */
	public UniDepartID(String universityID, String departmentID) {
		super();
		this.universityID = universityID;
		this.departmentID = departmentID;
	}

	public String getUniversityID() {
		return universityID;
	}

	public void setUniversityID(String universityID) {
		this.universityID = universityID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Ghi đè phương thức hashCode để tính toán mã băm cho đối tượng UniDepartID.
	 * 
	 * @return mã băm được tính toán từ các trường universityID và departmentID
	 */
	@Override
	public int hashCode() {
		return Objects.hash(departmentID, universityID);
	}

	/**
	 * Ghi đè phương thức equals để so sánh hai đối tượng UniDepartID.
	 * 
	 * @param obj đối tượng cần so sánh với UniDepartID hiện tại
	 * @return true nếu hai đối tượng UniDepartID giống nhau, ngược lại trả về false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniDepartID other = (UniDepartID) obj;
		return Objects.equals(departmentID, other.departmentID) && Objects.equals(universityID, other.universityID);
	}

	/**
	 * Chuyển đối tượng UniDepartID thành một chuỗi.
	 * 
	 * @return chuỗi biểu diễn cho UniDepartID
	 */
	@Override
	public String toString() {
		return "UniDepartID [universityID=" + universityID + ", departmentID=" + departmentID + "]";
	}

}
