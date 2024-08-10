//package fpt.fa.service;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import fpt.fa.entity.University;
//import fpt.fa.repository.UniversityRepository;
//
///**
// * @author Phan Ngoc Minh
// * Date 14/04/2024
// * Lớp dịch vụ cung cấp các phương thức liên quan đến đối tượng University
// */
//@Service
//@Transactional
//public class UniversityService {
//
//	@Autowired
//	private UniversityRepository universityRepository;
//
//	/**
//	 * Trả về danh sách tất cả các đại học.
//	 * 
//	 * @return danh sách các đại học
//	 */
//	public List<University> getAllUniversity() {
//		return universityRepository.findAll();
//	}
//	
//	
//	
//	
//	/**
//	 * Trả về thông tin đại học dựa trên ID.
//	 * 
//	 * @param universityID ID của đại học cần lấy thông tin
//	 * @return thông tin đại học có ID tương ứng, hoặc null nếu không tìm thấy
//	 */
//	public University getUniversityById(String universityID) {
//		return universityRepository.findById(universityID).orElse(null);
//	}
//
//	/**
//	 * Tạo mới một đại học.
//	 * 
//	 * @param university đối tượng đại học cần tạo mới
//	 * @return đối tượng đại học đã được tạo mới
//	 */
//	public University createUniversity(University university) {
//		return universityRepository.save(university);
//	}
//
//	/**
//	 * Cập nhật thông tin đại học.
//	 * 
//	 * @param university đối tượng đại học cần cập nhật thông tin
//	 * @return đối tượng đại học đã được cập nhật thông tin
//	 */
//	public University updateUniversity(University university) {
//		return universityRepository.save(university);
//	}
//
//	/**
//	 * Xóa một đại học dựa trên ID.
//	 * 
//	 * @param universityID ID của đại học cần xóa
//	 */
//	public void deleteUniversity(String universityID) {
//		universityRepository.deleteById(universityID);
//	}
//
//	// Các phương thức tìm kiếm thêm
//
//		/**
//		 * Tìm kiếm đại học theo ID và tên.
//		 * 
//		 * @param universityID   ID của đại học
//		 * @param universityName tên của đại học
//		 * @param pageable       thông tin trang để phân trang
//		 * @return trang chứa danh sách các đại học phù hợp với ID và tên được chỉ định
//		 */
//	// Thêm phương thức findByUniversityIDAndUniversityName
//	public Page<University> findByUniversityIDAndUniversityName(String universityID, String universityName,
//			Pageable pageable) {
//		return universityRepository.findByUniversityIDAndUniversityName(universityID, universityName, pageable);
//	}
//	
//	/**
//	 * Tìm kiếm đại học theo ID.
//	 * 
//	 * @param universityID ID của đại học
//	 * @param pageable     thông tin trang để phân trang
//	 * @return trang chứa danh sách các đại học có ID được chỉ định
//	 */
//
//	public Page<University> findByUniversityID(String universityID, Pageable pageable) {
//		return universityRepository.findByUniversityID(universityID, pageable);
//	}
//	
//	/**
//	 * Tìm kiếm đại học theo tên chứa một từ khóa cụ thể.
//	 * 
//	 * @param universityName từ khóa cần tìm trong tên đại học
//	 * @param pageable       thông tin trang để phân trang
//	 * @return trang chứa danh sách các đại học có tên chứa từ khóa được chỉ định
//	 */
//
//	public Page<University> findByUniversityNameContaining(String universityName, Pageable pageable) {
//		return universityRepository.findByUniversityNameContaining(universityName, pageable);
//	}
//
//	/**
//	 * Trả về trang chứa danh sách tất cả các đại học với phân trang.
//	 * 
//	 * @param pageable thông tin trang để phân trang
//	 * @return trang chứa danh sách tất cả các đại học
//	 */
//	public Page<University> getAllUniversity(Pageable pageable) {
//		return universityRepository.findAll(pageable);
//	}
//	
//	public boolean isUniversityIDExists(String universityID) {
//	    return universityRepository.existsById(universityID);
//	}
//}
package fpt.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fpt.fa.entity.University;
import fpt.fa.repository.UniversityRepository;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Lớp dịch vụ cung cấp các phương thức liên quan đến đối tượng University
 */
@Service
@Transactional
public class UniversityService implements UniversityServiceInterface {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversityById(String universityID) {
        return universityRepository.findById(universityID).orElse(null);
    }

    @Override
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University updateUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public void deleteUniversity(String universityID) {
        universityRepository.deleteById(universityID);
    }

    @Override
    public Page<University> findByUniversityIDAndUniversityName(String universityID, String universityName, Pageable pageable) {
        return universityRepository.findByUniversityIDAndUniversityName(universityID, universityName, pageable);
    }

    @Override
    public Page<University> findByUniversityID(String universityID, Pageable pageable) {
        return universityRepository.findByUniversityID(universityID, pageable);
    }

    @Override
    public Page<University> findByUniversityNameContaining(String universityName, Pageable pageable) {
        return universityRepository.findByUniversityNameContaining(universityName, pageable);
    }

    @Override
    public Page<University> getAllUniversity(Pageable pageable) {
        return universityRepository.findAll(pageable);
    }

    @Override
    public boolean isUniversityIDExists(String universityID) {
        return universityRepository.existsById(universityID);
    }
}