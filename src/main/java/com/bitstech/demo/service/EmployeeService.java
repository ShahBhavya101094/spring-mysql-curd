package com.bitstech.demo.service;

import com.bitstech.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployee();

    Employee findByEmployeeId(Long id);

    Employee updateByEmployeeId(Employee employee);

    Employee createEmployee(Employee employee);

    String deleteByEmployeeId(Long id);

}
