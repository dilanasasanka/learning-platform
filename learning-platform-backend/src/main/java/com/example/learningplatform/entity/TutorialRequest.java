package com.example.learningplatform.entity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutorial_requests")
public class TutorialRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    private String subject;
    
    private DayOfWeek dayOfWeek;
    
    private LocalTime startTime;
    
    private LocalTime endTime;
    
    private String status;

	public TutorialRequest() {
		super();
	}

	public TutorialRequest(Long id, User tutor, User student, String subject, DayOfWeek dayOfWeek, LocalTime startTime,
			LocalTime endTime, String status) {
		super();
		this.id = id;
		this.tutor = tutor;
		this.student = student;
		this.subject = subject;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

}

