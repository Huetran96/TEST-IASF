package com.springboot.salary_management.service;

import com.springboot.salary_management.entity.Employee;
import com.springboot.salary_management.entity.EmployeeCreation;
import com.springboot.salary_management.entity.EmployeeUpdatetion;
import com.springboot.salary_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public List<Employee> searchEmployee(String key) {
        List<Employee> results = employeeRepository.findAll().stream().map(
                (e) -> e.getName().contains(key) ? e: null
        ).toList();
        return results;
    }
    public Employee createEmployee(EmployeeCreation request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setSalary(request.getSalary());
        return employeeRepository.save(employee);
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public boolean updateEmployee(Long id, EmployeeUpdatetion request) {
        Employee employee = getEmployeeById(id);
        if (employee == null) {
            return false;
        }
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setSalary(request.getSalary());
        employeeRepository.save(employee);
        return true;
    }
    public boolean deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        if (employee == null) {
            return false;
        }
        employeeRepository.delete(employee);
        return true;
    }
}
