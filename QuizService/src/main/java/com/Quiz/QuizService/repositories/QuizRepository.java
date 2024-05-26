package com.Quiz.QuizService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quiz.QuizService.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>{

}
