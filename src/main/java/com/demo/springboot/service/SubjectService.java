package com.demo.springboot.service;

import java.util.List;

import com.demo.springboot.entity.Subject;

public interface SubjectService {

	public Subject addSubject(Subject subject);
	public Subject searchSubject(long subjectID);
	public List<Subject> listAllSubjects();
	public void updateSubject(Subject book, long subjectID);
	public void deleteSubjectById(long subjectID);
	public void deleteAllSubjects();
	
}
