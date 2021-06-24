package com.example.course.demo.repositories;

import com.example.course.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Get all customers for a given course
    List<Customer> findByBookingsCourseName(String course);
}
