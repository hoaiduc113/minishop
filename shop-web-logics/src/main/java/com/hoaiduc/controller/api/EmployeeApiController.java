package com.hoaiduc.controller.api;

import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.persistence.data.entity.Employee;
import com.hoaiduc.core.service.impl.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/ajax/api/",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeApiController
{
    @Autowired
    EmployeeServiceImp employeeServiceImp;

    @PostMapping("login")
    public ResponseEntity<EmployeeDTO> get(@RequestBody EmployeeDTO  dto)
    {
        return ResponseEntity.ok().body(employeeServiceImp.checkLogin(dto.getEmail(),dto.getPassword()));
    }
    @PostMapping("save")
    public ResponseEntity<Void> save(@RequestBody Employee dto, UriComponentsBuilder uriComponentsBuilder)
    {
        if(employeeServiceImp.isExist(dto.getEmail()))
        {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        employeeServiceImp.save(dto);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("save/{id}").buildAndExpand(dto.getIdemployee()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
