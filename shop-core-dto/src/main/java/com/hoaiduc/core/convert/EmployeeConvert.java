package com.hoaiduc.core.convert;

import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.dto.RollDTO;
import com.hoaiduc.core.persistence.data.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConvert
{

    private ModelMapper modelMapper=new ModelMapper();
    public EmployeeDTO covertEmployeeDTO(Employee employee)
    {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        RollDTO rollDTO=new RollDTO();
        modelMapper.map(employee.getRoll(),rollDTO);
        employeeDTO.setRollDTO(rollDTO);
        modelMapper.map(employee,employeeDTO);
        return employeeDTO;
    }
}
