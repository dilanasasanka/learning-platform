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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningplatform.dto.TutorAvailabilityRequest;
import com.example.learningplatform.entity.TutorAvailability;
import com.example.learningplatform.entity.TutorialBooking;
import com.example.learningplatform.entity.TutorialRequest;
import com.example.learningplatform.service.TutorAvailabilityService;

@RestController
@RequestMapping("/api/tutor-availabilities")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorAvailabilityController {

    @Autowired
    private TutorAvailabilityService tutorAvailabilityService;

    @GetMapping
    public ResponseEntity<List<TutorAvailability>> getAllTutorAvailabilities() {
        List<TutorAvailability> tutorAvailabilities = tutorAvailabilityService.getAllTutorAvailabilities();
        return ResponseEntity.ok(tutorAvailabilities);
    }

    @PostMapping
    public ResponseEntity<TutorAvailability> createTutorAvailability(@RequestBody TutorAvailabilityRequest request) {
        TutorAvailability createdAvailability = tutorAvailabilityService.createTutorAvailability(request);
        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }
    
    @GetMapping("/by-tutor/{tutorId}")
    public ResponseEntity<List<TutorAvailability>> getTutorAvailabilityByTutor(@PathVariable Long tutorId) {
        List<TutorAvailability> tutorAvailabilities = tutorAvailabilityService.getTutorAvailabilityByTutor(tutorId);
        return ResponseEntity.ok(tutorAvailabilities);
    }
    
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteTutorAvailability(@PathVariable Long requestId) {
    	tutorAvailabilityService.deleteTutorAvailability(requestId);
        return ResponseEntity.ok().build();
    }
}
