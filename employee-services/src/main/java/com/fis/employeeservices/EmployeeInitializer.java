package com.fis.employeeservices;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class EmployeeInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    EmployeeInitializer(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Anant", "Gopal", "Shivendra", "Saharsh", "Asha", "Harshita", "Meghana")
                .forEach(employee -> employeeRepository.save(new Employee(employee)));

        employeeRepository.findAll().forEach(System.out::println);
    }
}