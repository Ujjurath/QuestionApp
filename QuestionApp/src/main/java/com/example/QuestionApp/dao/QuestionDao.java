package com.example.QuestionApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.QuestionApp.model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer>  {

	List<Questions> findQuestionByCategory(String category);
	@Query(value = "SELECT * FROM Questions q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Questions> findRandomQuestionsByCategory(String category, int numQ);
		
}
