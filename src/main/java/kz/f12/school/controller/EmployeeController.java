package kz.f12.school.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import kz.f12.school.model.dto.EmployeeDTO;
import kz.f12.school.model.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeController extends AbstractController {

    private EmployeeRepository repository = EmployeeRepository.getInstance();

    private List<EmployeeDTO> filteredList = new ArrayList<>();

    @FXML
    private TableView<EmployeeDTO> empTableView;

    @FXML
    private TableColumn<EmployeeDTO, String> idColumn;

    @FXML
    private TableColumn<EmployeeDTO, String> nameColumn;

    @FXML
    private TableColumn<EmployeeDTO, String> depNameColumn;

    @FXML
    private TableColumn<EmployeeDTO, String> ageColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchTextField;

    @FXML
    void initialize() {
        ObservableList<EmployeeDTO> data = FXCollections.observableList(repository.getEmployeeList());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        depNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        empTableView.setItems(data);

        searchTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String text = searchTextField.getText().trim().toLowerCase();
                filteredList = new ArrayList<>(repository.getEmployeeList());
                if (!"".equals(text)) {
                    filteredList = filteredList.stream() // открываем поток
                            .filter(employeeDTO ->
                                    // по условию ниже фильтруем список
                                    employeeDTO.getName().toLowerCase().startsWith(text) ||
                                    employeeDTO.getDepartmentName().toLowerCase().startsWith(text)
                            ).collect(Collectors.toList()); // преобразуем обратно в список
                }
                ObservableList<EmployeeDTO> filteredData = FXCollections.observableList(filteredList);
                empTableView.setItems(filteredData);
            }
        });

        deleteButton.setOnAction(event -> {
            if (filteredList.size() == 1) {
                EmployeeDTO employeeDTO = filteredList.get(0);
                repository.delete(employeeDTO);
                ObservableList<EmployeeDTO> filteredData = FXCollections.observableList(repository.getEmployeeList());
                empTableView.setItems(filteredData);
                searchTextField.setText("");
            }
        });
    }

}
