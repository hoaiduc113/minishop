package com.hoaiduc.controller.web;

import com.hoaiduc.core.convert.EmployeeConvert;
import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.dto.RollDTO;
import com.hoaiduc.core.persistence.data.entity.Employee;
import com.hoaiduc.core.service.impl.EmployeeServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class EmployeeController
{
    @Autowired
    EmployeeServiceImp employeeServiceImp;


    @GetMapping("product")
    public ResponseEntity<List<EmployeeDTO>> get()
    {
        List<Employee> book;
        book = employeeServiceImp.findAll();
        EmployeeDTO list = (EmployeeDTO) new EmployeeDTO() ;
        ModelMapper modelMapper=new ModelMapper();
        List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
        for(Employee employees: book)
        {
            EmployeeDTO employeeDTO=new EmployeeDTO();

            modelMapper.map(employees,employeeDTO);
            listDTO.add(employeeDTO);
        }
        modelMapper.map(book,list);
        return ResponseEntity.ok().body(listDTO);
    }

}
