package com.demo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.entity.Subject;
import com.demo.springboot.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {


	@Autowired
	SubjectRepository subRepo;

	public Subject addSubject(Subject subject) {
		return subRepo.save(subject);
	}
	public Subject searchSubject(long subjectID) {
		return subRepo.getOne(subjectID);
	}
	public List<Subject> listAllSubjects() {
		return subRepo.findAll();
	}
	public void updateSubject(Subject subject, long subjectID) {
		boolean isPresent = subRepo.existsById(subjectID);
		if(isPresent){
			deleteSubjectById(subjectID);
			subRepo.save(subject);
		}
	}
	public void deleteSubjectById(long subjectID) {
		subRepo.deleteById(subjectID);
	}
	public void deleteAllSubjects() {
		subRepo.deleteAll();
	}
}
