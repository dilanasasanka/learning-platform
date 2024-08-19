package com.example.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learningplatform.dto.TutorialRequestRequest;
import com.example.learningplatform.entity.TutorialBooking;
import com.example.learningplatform.entity.TutorialRequest;

@Repository
public interface TutorialRequestRepository extends JpaRepository<TutorialRequest, Long>{

	List<TutorialRequest> findByTutorId(Long tutorId);
	
	List<TutorialRequest> findByStudentId(Long studentId);
	
	List<TutorialRequest> findByStatus(String status);

	TutorialRequest getTutorialRequestById(Long requestId);

	List<TutorialRequest> findAll();

	void deleteById(Long id);
}
