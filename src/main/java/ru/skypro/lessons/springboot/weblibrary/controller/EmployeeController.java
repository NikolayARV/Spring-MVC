package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public int showSumSalary() {
        return employeeService.getSumSalary();
    }
    @GetMapping("/salary/min")
    public Employee showMinSalary() {
        return employeeService.getMinSalary();
    }
    @GetMapping("/salary/max")
    public Employee showMaxSalary() {
        return employeeService.getMaxSalary();
    }
    @GetMapping("/high-salary")
    public List<Employee> showHighSalaryEmployee() {
        return employeeService.getHighSalaryEmployees();
    }
}

