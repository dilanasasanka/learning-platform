package com.example.learningplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningplatform.dto.TutorialRequestRequest;
import com.example.learningplatform.entity.TutorialRequest;
import com.example.learningplatform.repository.TutorialRequestRepository;
import com.example.learningplatform.repository.UserRepository;

@Service
public class TutorialRequestService {

	@Autowired
    private TutorialRequestRepository tutorialRequestRepository;
	
	@Autowired
    private UserRepository userRepository;

    public List<TutorialRequest> getTutorialRequestsForTutor(Long tutorId) {
        return tutorialRequestRepository.findByTutorId(tutorId);
    }

    public void respondToTutorialRequest(Long requestId, String response) {
        TutorialRequest tutorialRequest = tutorialRequestRepository.getTutorialRequestById(requestId);
        // Update tutorial request status based on response
        tutorialRequest.setStatus(response);
        tutorialRequestRepository.save(tutorialRequest);
    }

    public List<TutorialRequest> getAllTutorialRequests() {
        return tutorialRequestRepository.findAll();
    }

    public TutorialRequest getTutorialRequestById(Long id) {
        return tutorialRequestRepository.getTutorialRequestById(id);
    }

    public void deleteTutorialRequest(Long id) {
        tutorialRequestRepository.deleteById(id);
    }
    
    public List<TutorialRequest> getTutorialRequestsByStudent(Long id){
    	return tutorialRequestRepository.findByStudentId(id);
    }
    
    public List<TutorialRequest> getTutorialRequestsByTutor(Long id){
    	return tutorialRequestRepository.findByTutorId(id);
    }
    
    public List<TutorialRequest> getTutorialRequestsByStatus(String status){
    	return tutorialRequestRepository.findByStatus(status);
    }
    
	public TutorialRequest createTutorialRequest(TutorialRequestRequest request) {

		TutorialRequest newTutorialRequest = new TutorialRequest();
		newTutorialRequest.setDayOfWeek(request.getDayOfWeek());
		newTutorialRequest.setStartTime(request.getStartTime());
		newTutorialRequest.setEndTime(request.getEndTime());
		newTutorialRequest.setSubject(request.getSubject());
		newTutorialRequest.setStudent(userRepository.getUserById(request.getStudentId()));
		newTutorialRequest.setTutor(userRepository.getUserById(request.getTutorId()));
		
		tutorialRequestRepository.save(newTutorialRequest);
		
		return newTutorialRequest;
	}

    // Implement other CRUD operations if needed
}

