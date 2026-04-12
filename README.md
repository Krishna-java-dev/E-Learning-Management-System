# 📚 E-Learning Management System (Backend)

## 🚀 Overview

A secure backend application built using Spring Boot that enables users to register, log in, and access an e-learning platform with course management and quiz functionality. The system implements JWT-based authentication and role-based access control.

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA (Hibernate)
* MySQL
* JWT Authentication
* Maven
* Postman

---

## 🔐 Features

### 👤 User Management

* User Registration & Login
* Password Encryption using BCrypt
* JWT Token Generation for authentication

### 🔒 Security

* JWT-based authentication
* Custom JWT Filter for request validation
* Role-Based Access Control (Student / Teacher)

### 📚 Course Management

* Teachers can add courses
* Students can view available courses

### 📝 Quiz System

* Add quiz questions
* Attempt quizzes
* Automatic scoring system

### 📊 Progress Tracking

* Stores student quiz scores
* Tracks performance

---

## 🧱 Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

---

## 🔌 API Endpoints

### 🔐 Authentication

* `POST /auth/register` → Register user
* `POST /auth/login` → Login and get JWT token

### 📚 Courses

* `POST /courses?role=TEACHER` → Add course
* `GET /courses` → Get all courses (JWT required)

### 📝 Quiz

* `POST /quiz` → Add question
* `GET /quiz` → Get questions
* `POST /quiz/submit?email={email}` → Submit quiz

---

## 🧪 Testing

All APIs are tested using Postman.

---

## ▶️ How to Run

1. Clone the repository
2. Open in Eclipse / IntelliJ
3. Configure MySQL database:

   * Create database: `elearning`
4. Update `application.properties` with your DB credentials
5. Run the application
6. Access APIs using Postman

---

## 💡 Key Concepts Implemented

* RESTful API Development
* Dependency Injection
* JWT Authentication & Authorization
* Role-Based Access Control
* Layered Architecture Design

---

## 📌 Future Enhancements

* Frontend using React
* API documentation using Swagger
* Pagination & Sorting
* Advanced Spring Security

---

## 👨‍💻 Author

Krishna
