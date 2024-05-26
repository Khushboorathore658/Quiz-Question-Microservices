package com.Question.QuestionService.services;

import java.util.List;

import com.Question.QuestionService.entities.Question;

public interface QuestionService {

	Question create(Question question);
	
	List<Question> get();
	
	Question getOne(Long id);
	
	List<Question> getQuestionsofQuiz(Long quizId);
	
	
	
}
