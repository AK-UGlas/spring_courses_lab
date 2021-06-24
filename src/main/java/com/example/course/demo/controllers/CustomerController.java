package com.example.course.demo.controllers;

import com.example.course.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomersByCourse(
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "course") String course)

    {
        // GET /customers?course=Javascript
        if (town != null && course!= null) {
            return new ResponseEntity((customerRepository.findByTownAndBookingsCourseName(town, course)), HttpStatus.OK);
        }

        // GET /customers?course=Javascript
        if (course != null) {
            return new ResponseEntity(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

}
