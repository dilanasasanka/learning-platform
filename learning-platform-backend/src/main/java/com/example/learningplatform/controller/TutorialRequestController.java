package com.example.learningplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningplatform.dto.TutorialRequestRequest;
import com.example.learningplatform.entity.TutorialRequest;
import com.example.learningplatform.service.TutorialRequestService;

@RestController
@RequestMapping("/api/tutorial-requests")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorialRequestController {

    @Autowired
    private TutorialRequestService tutorialRequestService;

    @PostMapping
    public ResponseEntity<TutorialRequest> createTutorialRequest(@RequestBody TutorialRequestRequest request) {
        TutorialRequest createdRequest = tutorialRequestService.createTutorialRequest(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{requestId}/status")
    public ResponseEntity<Void> setTutorialRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        tutorialRequestService.respondToTutorialRequest(requestId, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-student/{studentId}")
    public ResponseEntity<List<TutorialRequest>> getTutorialRequestsByStudent(@PathVariable Long studentId) {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getTutorialRequestsByStudent(studentId);
        return ResponseEntity.ok(tutorialRequests);
    }

    @GetMapping("/by-tutor/{tutorId}")
    public ResponseEntity<List<TutorialRequest>> getTutorialRequestsByTutor(@PathVariable Long tutorId) {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getTutorialRequestsByTutor(tutorId);
        return ResponseEntity.ok(tutorialRequests);
    }

    @GetMapping
    public ResponseEntity<List<TutorialRequest>> getAllTutorialRequests() {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getAllTutorialRequests();
        return ResponseEntity.ok(tutorialRequests);
    }

    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<TutorialRequest>> getTutorialRequestsByStatus(@PathVariable String status) {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getTutorialRequestsByStatus(status);
        return ResponseEntity.ok(tutorialRequests);
    }
    
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteTutorialRequest(@PathVariable Long requestId) {
        tutorialRequestService.deleteTutorialRequest(requestId);
        return ResponseEntity.ok().build();
    }

}

