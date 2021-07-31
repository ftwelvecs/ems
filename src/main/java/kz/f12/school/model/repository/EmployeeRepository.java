package kz.f12.school.model.repository;

import kz.f12.school.model.dto.EmployeeDTO;
import kz.f12.school.utils.Mapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static EmployeeRepository repository;
    private List<EmployeeDTO> employeeDTOList = new ArrayList<>();

    private EmployeeRepository() {
        loadData();
    }

    public static EmployeeRepository getInstance() {
        if (repository == null) {
            repository = new EmployeeRepository();
        }
        return repository;
    }

    public void add(EmployeeDTO employeeDTO) {
        employeeDTO.setId(getNextId());
        employeeDTOList.add(employeeDTO);
    }

    public void delete(EmployeeDTO employeeDTO) {
        employeeDTOList.remove(employeeDTO);
    }

    private void loadData() {
        try {
            String path = System.getenv("APPDATA") + "/employee_list.json";
            JSONTokener tokener = new JSONTokener(path);
            JSONArray jsonArray = (JSONArray) tokener.nextValue();
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                EmployeeDTO employeeDTO = Mapper.toEmployeeDTO(jsonObject);
                employeeDTOList.add(employeeDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getNextId() {
        int maxId = 0;
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            if (employeeDTO.getId() > maxId)
                maxId = employeeDTO.getId();
        }
        return maxId + 1;
    }

    public List<EmployeeDTO> getEmployeeList() {
        return employeeDTOList;
    }
}
