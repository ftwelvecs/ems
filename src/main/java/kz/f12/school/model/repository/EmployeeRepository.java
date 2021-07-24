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

    private void loadData() {
        JSONTokener tokener = new JSONTokener(getClass().getResourceAsStream("/employee_list.json"));
        JSONArray jsonArray = (JSONArray) tokener.nextValue();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            EmployeeDTO employeeDTO = Mapper.toEmployeeDTO(jsonObject);
            employeeDTOList.add(employeeDTO);
        }
    }

}
