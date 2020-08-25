package com.bitstech.demo.service.impl;

import com.bitstech.demo.model.Employee;
import com.bitstech.demo.repo.EmployeeRepo;
import com.bitstech.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findByEmployeeId(Long id) {
        Optional<Employee> employee=employeeRepo.findById(id);
        if(!employee.isPresent()){
            return null;
        }
        return employee.get();
    }

    @Override
    public Employee updateByEmployeeId(Employee employee) {
        Employee employee1 = findByEmployeeId(employee.getId());
        if(employee != null){
           return null;
        }
        employee1.setName(employee.getName());
        employee1.setDepartmentId(employee.getDepartmentId());
        employee1.setAddress(employee.getAddress());
        employee1.setSalary(employee.getSalary());

        return employeeRepo.save(employee1);

    }

    @Override
    public Employee createEmployee(Employee employee) {
         return employeeRepo.save(employee);
    }

    @Override
    public String deleteByEmployeeId(Long id) {
        Employee employee = findByEmployeeId(id);
        if(employee != null){
            employeeRepo.delete(employee);
            return "Delete Successfully!";
        }
        else{
            return "No record Found";
        }
    }
}
