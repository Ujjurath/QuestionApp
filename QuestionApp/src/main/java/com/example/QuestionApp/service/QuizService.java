package com.example.QuestionApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuestionApp.dao.QuestionDao;
import com.example.QuestionApp.dao.QuizDao;
import com.example.QuestionApp.model.Questions;
import com.example.QuestionApp.model.Quiz;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Questions> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

}
