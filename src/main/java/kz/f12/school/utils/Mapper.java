package kz.f12.school.utils;

import kz.f12.school.model.dto.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

    public static AbstractDTO map(ResultSet resultSet, String type) {
        AbstractDTO result = null;
        switch (type) {
            case "users":
                result = toUserDTO(resultSet);
                break;
            case "addresses":
                result = toAddressDTO(resultSet);
                break;
            case "departments":
                result = toDepartmentDTO(resultSet);
                break;
            case "regions":
                result = toRegionDTO(resultSet);
                break;
            case "positions":
                result = toPositionDTO(resultSet);
        }
        return result;
    }

    public static UserDTO toUserDTO(ResultSet resultSet) {
        UserDTO userDTO = new UserDTO();
        try {
            Integer id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String firstName = resultSet.getString("first_name");
            String email = resultSet.getString("email");
            String isActive = resultSet.getString("is_active");
            Date createDate = resultSet.getDate("create_date");
            Date lastUpdateDate = resultSet.getDate("last_update_date");

            userDTO.setId(id);
            userDTO.setUsername(username);
            userDTO.setFirstName(firstName);
            userDTO.setEmail(email);
            userDTO.setIsActive(isActive.charAt(0));
            userDTO.setCreateDate(createDate);
            userDTO.setLastUpdateDate(lastUpdateDate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userDTO;
    }

    public static UserDTO toUserDTO(JSONObject jsonObject) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO.setUsername(jsonObject.getString("username"));
            userDTO.setFirstName(jsonObject.getString("firstName"));
            userDTO.setLastName(jsonObject.getString("lastName"));
            userDTO.setPatronymic(jsonObject.getString("patronymic"));
            userDTO.setEmail(jsonObject.getString("email"));
            userDTO.setPassword(jsonObject.getString("password"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userDTO;
    }

    public static AddressDTO toAddressDTO(ResultSet resultSet) {
        AddressDTO addressDTO = new AddressDTO();
        try {
            Integer id = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String address = resultSet.getString("address");
            Date createDate = resultSet.getDate("create_date");
            Date lastUpdateDate = resultSet.getDate("last_update_date");

            addressDTO.setId(id);
            addressDTO.setCity(city);
            addressDTO.setAddress(address);
            addressDTO.setCreateDate(createDate);
            addressDTO.setLastUpdateDate(lastUpdateDate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addressDTO;
    }

    public static AddressDTO toAddressDTO(JSONObject jsonObject) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress(jsonObject.getString("address"));
        addressDTO.setCity(jsonObject.getString("city"));
        return addressDTO;
    }

    public static DepartmentDTO toDepartmentDTO(ResultSet resultSet) {
        return (DepartmentDTO) toDictDTO(resultSet, new DepartmentDTO());
    }

    public static DepartmentDTO toDepartmentDTO(JSONObject jsonObject) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(jsonObject.getString("name"));
        return departmentDTO;
    }

    public static RegionDTO toRegionDTO(ResultSet resultSet) {
        return (RegionDTO) toDictDTO(resultSet, new RegionDTO());
    }

    public static RegionDTO toRegionDTO(JSONObject jsonObject) {
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setName(jsonObject.getString("name"));
        return regionDTO;
    }

    public static PositionDTO toPositionDTO(ResultSet resultSet) {
        return (PositionDTO) toDictDTO(resultSet, new PositionDTO());
    }

    public static PositionDTO toPositionDTO(JSONObject jsonObject) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setName(jsonObject.getString("name"));
        return positionDTO;
    }

    private static DictDTO toDictDTO(ResultSet resultSet, DictDTO dictDTO) {
        try {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date createDate = resultSet.getDate("create_date");
            Date lastUpdateDate = resultSet.getDate("last_update_date");
            dictDTO.setId(id);
            dictDTO.setName(name);
            dictDTO.setCreateDate(createDate);
            dictDTO.setLastUpdateDate(lastUpdateDate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dictDTO;
    }

}
