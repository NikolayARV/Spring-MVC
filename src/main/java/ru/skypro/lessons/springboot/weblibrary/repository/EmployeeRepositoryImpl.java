package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeReposirory{
    private final List<Employee> employeeList = List.of(
            new Employee("Valya", 60000),
            new Employee("Dima", 45000),
            new Employee("Petya", 90000),
            new Employee("Vova", 75000),
            new Employee("Nina", 85000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
    
}
