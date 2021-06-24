package com.example.course.demo.repositories;

import com.example.course.demo.models.Course;
import com.example.course.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // GET all courses with a given rating
    List<Course> findByStarRating(Integer rating);

    // GET all courses with a given customer
    List<Course> findByBookingsCustomerName(String customer);

    // GET all customers
}
