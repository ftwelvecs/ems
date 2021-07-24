package kz.f12.school.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kz.f12.school.model.dto.EmployeeDTO;
import kz.f12.school.model.repository.EmployeeRepository;

public class AddController extends AbstractController {

    private EmployeeRepository repository = EmployeeRepository.getInstance();

    @FXML
    private TextField empNameTextField;

    @FXML
    private TextField empDepTextField;

    @FXML
    private TextField empAgeTextField;

    @FXML
    private Button addEmpButton;

    @FXML
    void initialize() {
        addEmpButton.setOnAction(event -> {
            String empName = empNameTextField.getText().trim();
            String empDepName = empDepTextField.getText().trim();
            String empAge = empAgeTextField.getText().trim();
            try {
                int age = Integer.parseInt(empAge);

                if (!empName.equals("") && !empDepName.equals("") && (age > 0 && age < 150)) {
                    /*EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setName(empName);
                    repository.add(employeeDTO);*/
                }

            } catch (Exception e) {
                // do nothing
            }
        });
    }

}

