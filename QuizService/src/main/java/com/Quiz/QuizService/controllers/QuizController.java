package com.Quiz.QuizService.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.QuizService.entities.Quiz;
import com.Quiz.QuizService.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private QuizService quizservice;

	public QuizController(QuizService quizservice) {
		this.quizservice = quizservice;
	}
	//create
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizservice.add(quiz);	
	}
	//Get all
	@GetMapping
	public List<Quiz> getAll(){
		return quizservice.get();
		
	}
	//get by id
	@GetMapping("/{id}")
	public Quiz getOne(@PathVariable Long id) {
		return quizservice.get(id);
		
	}
	
	
}
