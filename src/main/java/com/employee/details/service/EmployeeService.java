package com.employee.details.service;

import com.employee.details.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void removeEmployeeById(int id);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();
}
