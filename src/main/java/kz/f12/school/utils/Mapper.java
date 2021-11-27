package kz.f12.school.utils;

import kz.f12.school.model.dto.*;
import kz.f12.school.model.repository.DepartmentRepository;
import kz.f12.school.model.repository.PositionRepository;
import kz.f12.school.model.repository.RegionRepository;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Mapper {

    private final static RegionRepository regionRepository = new RegionRepository();
    private final static DepartmentRepository departmentRepository = new DepartmentRepository();
    private final static PositionRepository positionRepository = new PositionRepository();

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
    // чтобы отправить данные из базы в фронт
    public static UserDTO toUserDTO(ResultSet resultSet) {
        UserDTO userDTO = new UserDTO();
        try {
            Integer id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String isActive = resultSet.getString("is_active");
            Date createDate = resultSet.getDate("create_date");
            Date lastUpdateDate = resultSet.getDate("last_update_date");

            Integer departmentId = resultSet.getInt("department_id");
            DepartmentDTO department = departmentRepository.findById(departmentId);

            Integer positionId = resultSet.getInt("position_id");
            PositionDTO position = positionRepository.findById(positionId);

            userDTO.setId(id);
            userDTO.setUsername(username);
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            userDTO.setEmail(email);
            userDTO.setIsActive(isActive.charAt(0));
            userDTO.setCreateDate(createDate);
            userDTO.setLastUpdateDate(lastUpdateDate);
            userDTO.setDepartment(department);
            userDTO.setPosition(position);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userDTO;
    }

    // чтобы получать из фронта и сохранять в базе
    public static UserDTO toUserDTO(JSONObject jsonObject) {
        UserDTO userDTO = new UserDTO();
        try {
            Integer id = jsonObject.isNull("id") ? null : jsonObject.getInt("id");
            String username = jsonObject.isNull("username") ? null : jsonObject.getString("username");
            String firstName = jsonObject.isNull("firstName") ? null : jsonObject.getString("firstName");
            String lastName = jsonObject.isNull("lastName") ? null : jsonObject.getString("lastName");
            // String patronymic = jsonObject.isNull("patronymic") ? null : jsonObject.getString("patronymic");
            String email = jsonObject.isNull("email") ? null : jsonObject.getString("email");
            String password = jsonObject.isNull("password") ? null : jsonObject.getString("password");

            userDTO.setId(id);
            userDTO.setUsername(username);
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            // userDTO.setPatronymic(patronymic);
            userDTO.setEmail(email);
            userDTO.setPassword(password);
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
        DepartmentDTO departmentDTO = null;
        try {
            departmentDTO = (DepartmentDTO) toDictDTO(resultSet, new DepartmentDTO());
            Integer regionId = resultSet.getInt("region_id");
            RegionDTO regionDTO = regionRepository.findById(regionId);
            departmentDTO.setRegion(regionDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentDTO;
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
