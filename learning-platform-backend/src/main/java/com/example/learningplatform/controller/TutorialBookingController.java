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

import com.example.learningplatform.dto.TutorialBookingRequest;
import com.example.learningplatform.entity.TutorialBooking;
import com.example.learningplatform.service.TutorialBookingService;

@RestController
@RequestMapping("/api/tutorial-bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorialBookingController {

    @Autowired
    private TutorialBookingService tutorialBookingService;

    @PostMapping
    public ResponseEntity<TutorialBooking> createTutorialBooking(@RequestBody TutorialBookingRequest request) {
        TutorialBooking createdBooking = tutorialBookingService.bookTutorial(request);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/by-student/{studentId}")
    public ResponseEntity<List<TutorialBooking>> getTutorialBookingsByStudent(@PathVariable Long studentId) {
        List<TutorialBooking> tutorialBookings = tutorialBookingService.getTutorialBookingByStudent(studentId);
        return ResponseEntity.ok(tutorialBookings);
    }

    @GetMapping("/by-tutor/{tutorId}")
    public ResponseEntity<List<TutorialBooking>> getTutorialBookingsByTutor(@PathVariable Long tutorId) {
        List<TutorialBooking> tutorialBookings = tutorialBookingService.getTutorialBookingByTutor(tutorId);
        return ResponseEntity.ok(tutorialBookings);
    }

    @GetMapping
    public ResponseEntity<List<TutorialBooking>> getAllTutorialBookings() {
        List<TutorialBooking> tutorialBookings = tutorialBookingService.getAllTutorialBookings();
        return ResponseEntity.ok(tutorialBookings);
    }
    
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteTutorialBooking(@PathVariable Long requestId) {
    	tutorialBookingService.deleteTutorialBooking(requestId);
        return ResponseEntity.ok().build();
    }
}

