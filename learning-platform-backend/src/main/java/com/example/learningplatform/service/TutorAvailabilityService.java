package com.example.learningplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningplatform.dto.TutorAvailabilityRequest;
import com.example.learningplatform.entity.TutorAvailability;
import com.example.learningplatform.entity.TutorialBooking;
import com.example.learningplatform.repository.TutorAvailabilityRepository;
import com.example.learningplatform.repository.UserRepository;

@Service
public class TutorAvailabilityService {

	@Autowired
    private TutorAvailabilityRepository tutorAvailabilityRepository;
    
	@Autowired
    private UserRepository userRepository;

    public TutorAvailability createTutorAvailability(TutorAvailabilityRequest request) {
        // Validate request and handle creation
        TutorAvailability tutorAvailability = new TutorAvailability();
        tutorAvailability.setTutor(userRepository.getUserById(request.getTutorId()));
        tutorAvailability.setDayOfWeek(request.getDayOfWeek());
        tutorAvailability.setStartTime(request.getStartTime());
        tutorAvailability.setEndTime(request.getEndTime());
        tutorAvailability.setSubject(request.getSubject());
        return tutorAvailabilityRepository.save(tutorAvailability);
    }

    public List<TutorAvailability> getAllTutorAvailabilities() {
        return tutorAvailabilityRepository.findAll();
    }

    public TutorAvailability getTutorAvailabilityById(Long id) {
        return tutorAvailabilityRepository.getTutorAvailabilityById(id);
    }

    public void deleteTutorAvailability(Long id) {
        tutorAvailabilityRepository.deleteById(id);
    }
    
    public List<TutorAvailability> getTutorAvailabilityByDayOfWeek(Integer index) {
        return tutorAvailabilityRepository.getTutorAvailabilityByDayOfWeek(index);
    }
    
    public List<TutorAvailability> getTutorAvailabilityByTutor(Long id) {
        return tutorAvailabilityRepository.findByTutorId(id);
    }

    // Implement other CRUD operations if needed
}

