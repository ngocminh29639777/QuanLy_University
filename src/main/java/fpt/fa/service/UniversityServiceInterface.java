package fpt.fa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fpt.fa.entity.University;

public interface UniversityServiceInterface {
    List<University> getAllUniversity();
    University getUniversityById(String universityID);
    University createUniversity(University university);
    University updateUniversity(University university);
    void deleteUniversity(String universityID);
    Page<University> findByUniversityIDAndUniversityName(String universityID, String universityName, Pageable pageable);
    Page<University> findByUniversityID(String universityID, Pageable pageable);
    Page<University> findByUniversityNameContaining(String universityName, Pageable pageable);
    Page<University> getAllUniversity(Pageable pageable);
    boolean isUniversityIDExists(String universityID);
}
