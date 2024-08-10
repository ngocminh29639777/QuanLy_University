package fpt.fa.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import fpt.fa.entity.University;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Giao diện repository cho đối tượng University.
 * 
 */
@Repository
public interface UniversityRepository extends JpaRepository<University, String> {

	/**
     * Tìm kiếm các đại học dựa trên ID và tên của đại học, với phân trang.
     */
	Page<University> findByUniversityIDAndUniversityName(String universityID, String universityName, Pageable pageable);

	/**
     * Tìm kiếm các đại học dựa trên ID của đại học, với phân trang.
     */
	Page<University> findByUniversityID(String universityID, Pageable pageable);

	/**
     * Tìm kiếm các đại học dựa trên tên của đại học (chứa từ khóa cụ thể), với phân trang.
     */
	Page<University> findByUniversityNameContaining(String universityName, Pageable pageable);

	/**
     * Tìm kiếm đại học dựa trên ID của đại học.
     */
	University findByUniversityID(String universityID);

}
