package com.Question.QuestionService.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Question.QuestionService.entities.Question;
import com.Question.QuestionService.repositories.QuestionRepository;
import com.Question.QuestionService.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	private QuestionRepository questionRepository;
	
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		
		this.questionRepository = questionRepository;
	}

	@Override
	public Question create(Question question) {
		
		return questionRepository.save(question) ;
	}

	@Override
	public List<Question> get() {
		
		return questionRepository.findAll();
	}

	@Override
	public Question getOne(Long id) {
		
		return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found !!"));
				
	}

	@Override
	public List<Question> getQuestionsofQuiz(Long quizId) {
		
		return questionRepository.findByQuizId(quizId);
	}

	
}
