package com.springboot.salary_management.controller;

import com.springboot.salary_management.entity.Employee;
import com.springboot.salary_management.entity.EmployeeCreation;
import com.springboot.salary_management.entity.EmployeeUpdatetion;
import com.springboot.salary_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("search/{key}")
    public List<Employee> search(@PathVariable String key) {
        return employeeService.searchEmployee(key);
    }

    @PostMapping("/create")
    public Employee create(@Valid @RequestBody EmployeeCreation request) {
        return employeeService.createEmployee(request);
    }
    @PutMapping("/update/{id}")
    public boolean update(@Valid @PathVariable Long id, @RequestBody EmployeeUpdatetion request) {
        return  employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

}
