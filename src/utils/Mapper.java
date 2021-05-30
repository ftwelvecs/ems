package utils;

import model.dto.EmployeeDTO;

public class Mapper {

    public static EmployeeDTO toEmployeeDTO(String[] employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(Integer.parseInt(employee[0]));
        employeeDTO.setName(employee[1]);
        employeeDTO.setDepartmentName(employee[2]);
        employeeDTO.setAge(Integer.parseInt(employee[3]));
        return employeeDTO;
    }

}
