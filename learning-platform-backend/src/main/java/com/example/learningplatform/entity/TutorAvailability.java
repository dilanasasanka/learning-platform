package com.example.learningplatform.entity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutor_availabilities")
public class TutorAvailability implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;
    
    private DayOfWeek dayOfWeek;
    
    private LocalTime startTime;
    
    private LocalTime endTime;

    private String subject;
    
	public TutorAvailability() {
		super();
	}

	public TutorAvailability(Long id, User tutor, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime,
			String subject) {
		super();
		this.id = id;
		this.tutor = tutor;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getTutor() {
		return tutor;
	}

	public void setTutor(User tutor) {
		this.tutor = tutor;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}

