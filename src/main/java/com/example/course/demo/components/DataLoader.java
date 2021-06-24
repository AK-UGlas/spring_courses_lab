package com.example.course.demo.components;

import com.example.course.demo.models.Booking;
import com.example.course.demo.models.Course;
import com.example.course.demo.models.Customer;
import com.example.course.demo.repositories.BookingRepository;
import com.example.course.demo.repositories.CourseRepository;
import com.example.course.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepo;

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    CustomerRepository customerRepo;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer customer1 = new Customer("Bob", "Glasgow", 18);
        customerRepo.save(customer1);
        Customer customer2 = new Customer("Geraldine", "Glasgow", 21);
        customerRepo.save(customer2);
        Customer customer3 = new Customer("Clive", "Edinburgh", 45);
        customerRepo.save(customer3);

        Course course1 = new Course("Intro to Python", "Glasgow", 4);
        courseRepo.save(course1);
        Course course2 = new Course("Javascript", "Glasgow", 4);
        courseRepo.save(course2);
        Course course3 = new Course("React", "Glasgow", 5);
        courseRepo.save(course3);
        Course course4 = new Course("SQL", "Glasgow", 2);
        courseRepo.save(course4);

        Booking bobs_booking = new Booking("22-07-2021", course1, customer1);
        bookingRepo.save(bobs_booking);
        Booking geraldines_booking = new Booking("23-05-2021", course1, customer2);
        bookingRepo.save(geraldines_booking);
        Booking clive_booking = new Booking("25-04-2021", course2, customer3);
        bookingRepo.save(clive_booking);


    }
}
