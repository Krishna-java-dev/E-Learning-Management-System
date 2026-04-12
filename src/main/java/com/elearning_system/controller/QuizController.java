package com.elearning_system.controller;

import com.elearning_system.entity.Quiz;
import com.elearning_system.dto.QuizAnswer;
import com.elearning_system.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping
    public Quiz addQuestion(@RequestBody Quiz quiz) {
        return service.addQuestion(quiz);
    }

    @GetMapping
    public List<Quiz> getQuestions() {
        return service.getAllQuestions();
    }

    @PostMapping("/submit")
    public int submitQuiz(@RequestParam String email,
                          @RequestBody List<QuizAnswer> answers) {

        return service.calculateAndSaveScore(email, answers);
    }
}