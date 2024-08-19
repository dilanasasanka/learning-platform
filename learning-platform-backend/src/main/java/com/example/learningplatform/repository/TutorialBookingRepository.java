package com.example.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learningplatform.entity.TutorialBooking;
import com.example.learningplatform.entity.User;

@Repository
public interface TutorialBookingRepository extends JpaRepository<TutorialBooking, Long> {
    List<TutorialBooking> findByStudentId(Long id);
    List<TutorialBooking> findByTutorId(Long id);
    TutorialBooking getTutorialBookingById(Long id);
}

