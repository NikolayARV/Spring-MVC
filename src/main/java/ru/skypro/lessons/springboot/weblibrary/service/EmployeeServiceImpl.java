package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeReposirory;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeReposirory employeeRepository;

    public EmployeeServiceImpl(EmployeeReposirory employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public int getSumSalary() {
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        int sum = 0;
        for (Employee employee : employeeList) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    @Override
    public Employee getMinSalary() {
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        String name = "";
        int minsalary = getSumSalary();
        for (Employee employee : employeeList) {
            if (employee.getSalary() < minsalary) {
                minsalary = employee.getSalary();
                name = employee.getName();
            }
        }
        return new Employee(name, minsalary);
    }

    @Override
    public Employee getMaxSalary() {
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        String name = "";
        int maxsalary = 0;
        for (Employee employee : employeeList) {
            if (employee.getSalary() > maxsalary) {
                maxsalary = employee.getSalary();
                name = employee.getName();
            }
        }
        return new Employee(name, maxsalary);
    }

    @Override
    public List<Employee> getHighSalaryEmployees() {
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        int count = (int) employeeList.stream().count();
        int avgSalary = getSumSalary() / count;
        List<Employee> highSalaryEmployeeList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getSalary() > avgSalary) {
                highSalaryEmployeeList.add(employee);
            }


        }
        return highSalaryEmployeeList;
    }
}
