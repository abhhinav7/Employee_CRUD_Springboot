package com.employee.details.controller;

import com.employee.details.entity.Employee;
import com.employee.details.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/details")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/details/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId){
        employeeService.removeEmployeeById(employeeId);
    }

    @PutMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp){
        employeeService.addEmployee(emp);
        return employeeService.getEmployeeById(emp.getId());
    }


}
