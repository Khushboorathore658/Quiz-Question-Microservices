package com.Quiz.QuizService.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz.QuizService.entities.Quiz;
import com.Quiz.QuizService.repositories.QuizRepository;
import com.Quiz.QuizService.services.QuestionClient;
import com.Quiz.QuizService.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	private QuizRepository quizRepository;
	private QuestionClient questionClient;
	

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizes= quizRepository.findAll();
		
		List<Quiz> newQuizList= quizes.stream().map(quiz->{quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
			}).collect(Collectors.toList());
		return newQuizList;
		
		
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz =quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}
	

}
