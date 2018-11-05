package com.hoaiduc.core.service.impl;

import com.hoaiduc.core.convert.EmployeeConvert;
import com.hoaiduc.core.daoimpl.EmployeeDaoImp;
import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.persistence.data.entity.Employee;
import com.hoaiduc.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService
{
    @Autowired
    EmployeeDaoImp employeeDaoImp;
    @Autowired
    EmployeeConvert employeeConvert;
    public List<Employee> findAll()
    {
        return employeeDaoImp.findAll();
    }

    public EmployeeDTO checkLogin(String email, String password)
    {
        Employee employee=new Employee();
        employee= employeeDaoImp.checkLogin(email,password);
        if(employee!=null)
        {
            return employeeConvert.covertEmployeeDTO(employee);

        }
        return null;
    }

    public void save(Employee employee)
    {
        Employee employees=employeeDaoImp.save(employee);

    }

    public boolean isExist(String email)
    {
        return employeeDaoImp.isExist(email);

    }
}
