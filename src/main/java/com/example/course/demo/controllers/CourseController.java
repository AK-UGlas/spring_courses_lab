package com.example.course.demo.controllers;

import com.example.course.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity getByStarRating(
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customer") String customer)
    {
        if (rating != null) {
            return new ResponseEntity(courseRepository.findByStarRating(rating), HttpStatus.OK);
        }

        if (customer != null) {
            return new ResponseEntity(courseRepository.findByBookingsCustomerName(customer), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

}
