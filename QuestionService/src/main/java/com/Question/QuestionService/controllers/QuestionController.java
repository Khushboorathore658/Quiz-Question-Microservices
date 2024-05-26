package com.Question.QuestionService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question.QuestionService.entities.Question;
import com.Question.QuestionService.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		
		this.questionService = questionService;
	}
	//create
	@PostMapping
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
		
	}
	//getAll
	@GetMapping
	public List<Question> getAll(){
		return questionService.get();
	}
	
	//getOne
	@GetMapping("/{questionId}")
	public Question getOne(@PathVariable Long questionId) {
		return questionService.getOne(questionId);
	}
// get all question of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsofQuiz(@PathVariable Long quizId){
	    return questionService.getQuestionsofQuiz(quizId);
	}
	
	
	
}
