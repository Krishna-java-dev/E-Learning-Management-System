package com.elearning_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elearning_system.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}