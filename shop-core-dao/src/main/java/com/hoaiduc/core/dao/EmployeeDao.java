package com.hoaiduc.core.dao;


import com.hoaiduc.core.data.dao.GenericDao;
import com.hoaiduc.core.persistence.data.entity.Employee;

public interface EmployeeDao extends GenericDao<String, Employee>
{
        Employee checkLogin(String email,String password);
        boolean isExist(String email);
}
