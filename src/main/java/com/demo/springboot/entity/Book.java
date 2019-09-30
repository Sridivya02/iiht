package com.demo.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "book",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "book_id")})

public class Book implements Serializable {

	private static final long serialVersionUID = 2L;


	@Id
	@Column(name = "book_id", unique = true, nullable = false)
	private long id;

	private String title;
	private double price;
	private int volume;
	private Date published;

	public Book() {
		super();
	}
	public Book(long id) {
		this.id = id;
	}
	public Book(long id, String title, double price, int volume, Date published) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.published = published;
	}


	public long getBookId() {
		return id;
	}
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	@Column(name = "price")
	public double getPrice() {
		return price;
	}
	@Column(name = "volume")
	public int getVolume() {
		return volume;
	}
	//@Temporal(TemporalType.DATE)
	@Column(name = "published")
	public Date getPublishd() {
		return published;
	}

	public void setPublishDate(Date published) {
		this.published = published;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setBookId(long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "bookId:" + id + "\ntitle: " + title + "\nprice: " + price + "\nvolume:" + volume + "\npublishDate:"+ published;
	}

	@Override
	public boolean equals(Object o) { 

		// If the object is compared with itself then return true   
		if (o == this) { 
			return true; 
		} 

		/* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
		if (!(o instanceof Book)) { 
			return false; 
		} 

		// typecast o to Complex so that we can compare data members  
		Book c = (Book) o; 

		// Compare the data members and return accordingly  
		return Long.compare(id, c.id) == 0 ;
	} 

}

