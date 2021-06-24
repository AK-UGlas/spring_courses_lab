package com.example.course.demo.repositories;

import com.example.course.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Get all customers for a given course
    List<Customer> findByBookingsCourseNameIgnoreCase(String course);

    // Get all customers in a given town for a given course
    List<Customer> findByTownAndBookingsCourseNameIgnoreCase(String town, String course);

    List<Customer> findByTownAndAgeGreaterThanAndBookingsCourseNameIgnoreCase(String town, Integer age, String course);
}
