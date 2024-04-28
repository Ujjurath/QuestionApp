package com.example.QuestionApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuestionApp.dao.QuestionDao;
import com.example.QuestionApp.model.Questions;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Questions>> getAllQuestions(){
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK) ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.BAD_REQUEST) ;
		
	}

	public ResponseEntity<List<Questions>> getQuestionByCategory(String category) {
		try {
		return new ResponseEntity<>(questionDao.findQuestionByCategory(category), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findQuestionByCategory(category), HttpStatus.OK);
	}

	
	public ResponseEntity<String> addQuestion(Questions question) {
		// TODO Auto-generated method stub
		 questionDao.save(question);
		 return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
}
