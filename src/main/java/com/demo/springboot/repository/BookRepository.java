package com.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}