package com.demo.springboot.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "subject",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "subject_id")})
@NamedQueries({
	@NamedQuery(
	name = "sortBySubTitle",
	query = "from Subject order by subTitle"
	)
})
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;
	private long subjectId;
	private String subTitle;
	private int durationHours;
	private Set<Book> references;

	public Subject() {
		super();
	}
	
	public Subject(long subjectId) {
		this.subjectId = subjectId;
	}
	public Subject(long subjectId, String subTitle, int durationHours, Set<Book> references) {
		this.subjectId = subjectId;
		this.subTitle = subTitle;
		this.durationHours = durationHours;
		this.references = references;

	}
	
	@Id
	@Column(name = "subject_id", unique = true, nullable = false)
	public long getSubjectId() {
		return subjectId;
	}
	@Column(name = "sub_title")
	public String getSubTitle() {
		return subTitle;
	}
	@Column(name = "duration_hrs")
	public int getDurationHours() {
		return durationHours;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="sub_book",  
			joinColumns = {@JoinColumn(name = "subject_id")},
			inverseJoinColumns = {@JoinColumn(name = "book_id")}
			)
	public Set<Book> getReferences() {
		return references;
	}
	
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	@Override
	public String toString() {
		return "subjectId:" + subjectId + "\nsubTitle: " + subTitle + "\ndurationHours: " + durationHours +"\nreferences: "+references;
	}


}

