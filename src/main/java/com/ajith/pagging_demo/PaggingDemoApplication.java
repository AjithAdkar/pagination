package com.ajith.pagging_demo;

import com.ajith.pagging_demo.model.Student;
import com.ajith.pagging_demo.repository.StudentRepo;
import com.ajith.pagging_demo.service.StudentService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@SpringBootApplication
@RestController
public class PaggingDemoApplication implements CommandLineRunner {

    private final Faker faker = new Faker();
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentService studentService;


    public static void main(String[] args) {
        SpringApplication.run(PaggingDemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        AtomicInteger i= new AtomicInteger();

        List<Student> list = IntStream.range(1, 100).mapToObj(Student -> new Student(i.getAndIncrement(),
                faker.name().fullName(), faker.educator().course(), faker.phoneNumber().phoneNumber(),
                faker.gameOfThrones().character() + "@got.com")).toList();
        System.out.println(list);
        studentRepo.saveAll(list);
    }

    @GetMapping("{id}")
    public Page<Student> getAllStudent(@PathVariable("id") int i) {
        return studentService.getAllStudent(i);
    }
}