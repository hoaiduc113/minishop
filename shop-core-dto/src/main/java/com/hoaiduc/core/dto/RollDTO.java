package com.hoaiduc.core.dto;

import java.util.Set;

public class RollDTO
{
    private int idRoll;
    private String rollName;


    Set<EmployeeDTO> listEmployeeDTO;

    public Set<EmployeeDTO> getListEmployeeDTO() {
        return listEmployeeDTO;
    }

    public void setListEmployeeDTO(Set<EmployeeDTO> listEmployeeDTO) {
        this.listEmployeeDTO = listEmployeeDTO;
    }

    public int getIdRoll() {
        return idRoll;
    }

    public void setIdRoll(int idRoll) {
        this.idRoll = idRoll;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }
}
