package com.hoaiduc.core.service;

import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.persistence.data.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> findAll();
    EmployeeDTO checkLogin(String email, String password);
    void save(Employee employee);
    boolean isExist(String email);
}
