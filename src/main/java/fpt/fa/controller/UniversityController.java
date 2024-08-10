//package fpt.fa.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import fpt.fa.entity.University;
//import fpt.fa.service.UniversityService; // Sửa đường dẫn import
//
///**
// * @author Phan Ngoc Minh
// * Date 14/04/2024
// * Lớp điều khiển xử lý các hoạt động liên quan đến đối tượng trường Đại học.
// */
//@Controller
//@RequestMapping("/university")
//public class UniversityController {
//
//	@Autowired
//	private UniversityService universityService; // Sử dụng UniversityService thay vì UniversityRepository
//
//	/**
//	 * Hiển thị danh sách các trường Đại học.
//	 *
//	 * @param model          Đối tượng Model để thêm các thuộc tính
//	 * @param page           Số trang
//	 * @param size           Số lượng mục trên mỗi trang
//	 * @param universityID   ID của trường Đại học (tùy chọn)
//	 * @param universityName Tên của trường Đại học (tùy chọn)
//	 * @return Tên view cho danh sách các trường Đại học
//	 */
//	@GetMapping("/list")
//	public String getList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
//			@RequestParam(name = "size", defaultValue = "5") int size,
//			@RequestParam(name = "universityID", required = false) String universityID,
//			@RequestParam(name = "universityName", required = false) String universityName) {
//		Pageable pageable = PageRequest.of(page, size);
//		Page<University> universitiesPage;
//
//		if (universityID != null && !universityID.isEmpty() && universityName != null && !universityName.isEmpty()) {
//			universitiesPage = universityService.findByUniversityIDAndUniversityName(universityID, universityName,
//					pageable);
//		} else if (universityID != null && !universityID.isEmpty()) {
//			universitiesPage = universityService.findByUniversityID(universityID, pageable);
//		} else if (universityName != null && !universityName.isEmpty()) {
//			universitiesPage = universityService.findByUniversityNameContaining(universityName, pageable);
//		} else {
//			universitiesPage = universityService.getAllUniversity(pageable);
//		}
//
//		model.addAttribute("listUniversitys", universitiesPage.getContent());
//		model.addAttribute("currentPage", universitiesPage.getNumber());
//		model.addAttribute("totalPages", universitiesPage.getTotalPages());
//		model.addAttribute("size", size);
//		return "university/list";
//	}
//
//	/**
//	 * Hiển thị form để tạo mới một trường Đại học.
//	 *
//	 * @param model Đối tượng Model để thêm các thuộc tính
//	 * @return Tên view cho việc tạo mới một trường Đại học
//	 */
//	@GetMapping("/create")
//	public String showCreate(Model model) {
//		model.addAttribute("university", new University());
//		return "university/create";
//	}
//
//	/**
//	 * Xử lý việc tạo mới một trường Đại học.
//	 *
//	 * @param university          Đối tượng University chứa thông tin cần tạo mới
//	 * @param redirectAttributes Đối tượng RedirectAttributes để thêm các thuộc tính flash
//	 * @return URL chuyển hướng đến danh sách các trường Đại học với thông báo thành công hoặc lỗi
//	 */
//	@PostMapping("/create")
//	public String doCreate(@ModelAttribute University university, RedirectAttributes redirectAttributes) {
//		if (universityService.isUniversityIDExists(university.getUniversityID())) {
//			// Nếu universityID đã tồn tại, redirect về trang create với thông báo lỗi
//			redirectAttributes.addFlashAttribute("errorMessage", "ID tồn tại. Nhập lại nhé!");
//			return "redirect:/university/create";
//		} else {
//			// Nếu universityID chưa tồn tại, tiến hành tạo mới đại học
//			universityService.createUniversity(university);
//			redirectAttributes.addFlashAttribute("successMessage", "Thêm mới trường đại học thành công");
//			return "redirect:/university/list?isNewSuccess=true";
//		}
//	}
//
//	/**
//	 * Xóa một trường Đại học.
//	 *
//	 * @param id ID của trường Đại học cần xóa
//	 * @return URL chuyển hướng đến danh sách trường Đại học
//	 */
//	@GetMapping("/delete")
//	public String deleteUniversity(@RequestParam String id) {
//		universityService.deleteUniversity(id);
//		return "redirect:list";
//	}
//
//	/**
//	 * Hiển thị form để cập nhật thông tin của một trường Đại học.
//	 *
//	 * @param universityID ID của trường Đại học cần cập nhật
//	 * @param model        Đối tượng Model để thêm các thuộc tính
//	 * @return Tên view cho việc cập nhật thông tin của một trường Đại học
//	 */
//	@GetMapping("/update")
//	public String showUpdateForm(@RequestParam("id") String universityID, Model model) {
//		University university = universityService.getUniversityById(universityID);
//		model.addAttribute("university", university);
//		return "university/update";
//	}
//
//	/**
//	 * Xử lý việc cập nhật thông tin của một trường Đại học.
//	 *
//	 * @param university Đối tượng University chứa thông tin cần cập nhật
//	 * @return URL chuyển hướng đến danh sách trường Đại học
//	 */
//	@PostMapping("/update")
//	public String doUpdate(@ModelAttribute University university) {
//		universityService.updateUniversity(university);
//		return "redirect:list";
//	}
//	
//	
//
//}
package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fpt.fa.entity.University;
import fpt.fa.service.UniversityServiceInterface;

/**
 * @author Phan Ngoc Minh
 * Date 14/04/2024
 * Lớp điều khiển xử lý các hoạt động liên quan đến đối tượng trường Đại học.
 */
@Controller
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityServiceInterface universityService;

    @GetMapping("/list")
    public String getList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "universityID", required = false) String universityID,
                          @RequestParam(name = "universityName", required = false) String universityName) {
        Pageable pageable = PageRequest.of(page, size);
        Page<University> universitiesPage;

        if (universityID != null && !universityID.isEmpty() && universityName != null && !universityName.isEmpty()) {
            universitiesPage = universityService.findByUniversityIDAndUniversityName(universityID, universityName, pageable);
        } else if (universityID != null && !universityID.isEmpty()) {
            universitiesPage = universityService.findByUniversityID(universityID, pageable);
        } else if (universityName != null && !universityName.isEmpty()) {
            universitiesPage = universityService.findByUniversityNameContaining(universityName, pageable);
        } else {
            universitiesPage = universityService.getAllUniversity(pageable);
        }

        model.addAttribute("listUniversitys", universitiesPage.getContent());
        model.addAttribute("currentPage", universitiesPage.getNumber());
        model.addAttribute("totalPages", universitiesPage.getTotalPages());
        model.addAttribute("size", size);
        return "university/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("university", new University());
        return "university/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute University university, RedirectAttributes redirectAttributes) {
        if (universityService.isUniversityIDExists(university.getUniversityID())) {
            redirectAttributes.addFlashAttribute("errorMessage", "ID tồn tại. Nhập lại nhé!");
            return "redirect:/university/create";
        } else {
            universityService.createUniversity(university);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm mới trường đại học thành công");
            return "redirect:/university/list?isNewSuccess=true";
        }
    }

    @GetMapping("/delete")
    public String deleteUniversity(@RequestParam String id) {
        universityService.deleteUniversity(id);
        return "redirect:list";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") String universityID, Model model) {
        University university = universityService.getUniversityById(universityID);
        model.addAttribute("university", university);
        return "university/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute University university) {
        universityService.updateUniversity(university);
        return "redirect:list";
    }
}