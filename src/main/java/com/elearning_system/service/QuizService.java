package com.elearning_system.service;

import com.elearning_system.entity.Quiz;
import com.elearning_system.entity.Progress;
import com.elearning_system.repository.QuizRepository;
import com.elearning_system.repository.ProgressRepository;
import com.elearning_system.dto.QuizAnswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepo;

    @Autowired
    private ProgressRepository progressRepo;

    // Add question
    public Quiz addQuestion(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    // Get all questions
    public List<Quiz> getAllQuestions() {
        return quizRepo.findAll();
    }

    // Calculate score
    public int calculateScore(List<QuizAnswer> answers) {

        int score = 0;

        for (QuizAnswer ans : answers) {
            Quiz quiz = quizRepo.findById(ans.getQuestionId()).orElse(null);

            if (quiz != null && quiz.getCorrectAnswer().equals(ans.getSelectedAnswer())) {
                score++;
            }
        }

        return score;
    }

    // NEW: Save progress
    public int calculateAndSaveScore(String email, List<QuizAnswer> answers) {

        int score = calculateScore(answers);

        Progress progress = new Progress();
        progress.setEmail(email);
        progress.setScore(score);

        progressRepo.save(progress);

        return score;
    }
}