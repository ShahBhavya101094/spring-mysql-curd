package com.bitstech.demo.controller;

import com.bitstech.demo.model.Employee;
import com.bitstech.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employee/list")
    public List<Employee> displayAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee displayEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findByEmployeeId(id);
    }

    @PostMapping("/employee")
    public Employee addEmployeeDetails(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployeeDetails(@RequestBody Employee employee) {
        return employeeService.updateByEmployeeId(employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        return employeeService.deleteByEmployeeId(id);
    }

}
