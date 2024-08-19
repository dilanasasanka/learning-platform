package com.example.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learningplatform.entity.TutorAvailability;
import com.example.learningplatform.entity.User;

@Repository
public interface TutorAvailabilityRepository extends JpaRepository<TutorAvailability, Long> {
    List<TutorAvailability> findByTutorId(Long id);
    TutorAvailability getTutorAvailabilityById(Long id);
    List<TutorAvailability> getTutorAvailabilityByDayOfWeek(Integer index);
    
}

