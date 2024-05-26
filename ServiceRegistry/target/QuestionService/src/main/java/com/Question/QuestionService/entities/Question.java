package com.Question.QuestionService.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long questionId;
private String question;

private Long quizId;

}
