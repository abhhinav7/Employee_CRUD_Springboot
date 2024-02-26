package com.employee.details.service;

import com.employee.details.entity.Employee;
import com.employee.details.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
