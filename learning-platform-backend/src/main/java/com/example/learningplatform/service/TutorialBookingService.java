package com.example.learningplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.learningplatform.dto.TutorialBookingRequest;
import com.example.learningplatform.entity.TutorialBooking;
import com.example.learningplatform.entity.User;
import com.example.learningplatform.repository.TutorialBookingRepository;
import com.example.learningplatform.repository.UserRepository;

@Service
public class TutorialBookingService {

	@Autowired
    private TutorialBookingRepository tutorialBookingRepository;
    
	@Autowired
    private UserRepository userRepository;

    public TutorialBooking bookTutorial(TutorialBookingRequest request) {
        // Validate request and handle booking
        TutorialBooking tutorialBooking = new TutorialBooking();
        tutorialBooking.setStudent(userRepository.getUserById(request.getStudentId()));
        tutorialBooking.setTutor(userRepository.getUserById(request.getTutorId()));
        tutorialBooking.setSubject(request.getSubject());
        tutorialBooking.setDayOfWeek(request.getDayOfWeek());
        tutorialBooking.setStartTime(request.getStartTime());
        tutorialBooking.setEndTime(request.getEndTime());
        return tutorialBookingRepository.save(tutorialBooking);
    }

    public List<TutorialBooking> getAllTutorialBookings() {
        return tutorialBookingRepository.findAll();
    }

    public List<TutorialBooking> getTutorialBookingByStudent(Long id) {
        return tutorialBookingRepository.findByStudentId(id);
    }
    
    public List<TutorialBooking> getTutorialBookingByTutor(Long id) {
        return tutorialBookingRepository.findByTutorId(id);
    }
    
    public TutorialBooking getTutorialBookingById(Long id) {
        return tutorialBookingRepository.getTutorialBookingById(id);
    }

    public void deleteTutorialBooking(Long id) {
        tutorialBookingRepository.deleteById(id);
    }

    // Implement other CRUD operations if needed
}

