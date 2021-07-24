package kz.f12.school.utils;

import kz.f12.school.model.dto.EmployeeDTO;
import org.json.JSONObject;

public class Mapper {

    public static EmployeeDTO toEmployeeDTO(String[] employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(Integer.parseInt(employee[0]));
        employeeDTO.setName(employee[1]);
        employeeDTO.setDepartmentName(employee[2]);
        employeeDTO.setAge(Integer.parseInt(employee[3]));
        return employeeDTO;
    }

    public static EmployeeDTO toEmployeeDTO(JSONObject jsonObject) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(jsonObject.getInt("id"));
        employeeDTO.setName(jsonObject.getString("name"));
        employeeDTO.setDepartmentName(jsonObject.getString("departmentName"));
        employeeDTO.setAge(jsonObject.getInt("age"));
        return employeeDTO;
    }

}
