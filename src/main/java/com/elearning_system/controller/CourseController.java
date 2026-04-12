package com.elearning_system.controller;

import com.elearning_system.entity.Course;
import com.elearning_system.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public Course addCourse(@RequestBody Course course,
                            @RequestParam String role) {

        if (!role.equals("TEACHER")) {
            throw new RuntimeException("Only teachers can add courses");
        }

        return service.addCourse(course);
    }

    @GetMapping
    public List<Course> getCourses() {
        return service.getAllCourses();
    }
}