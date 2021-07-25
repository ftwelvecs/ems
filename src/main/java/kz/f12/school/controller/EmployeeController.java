package kz.f12.school.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kz.f12.school.model.dto.EmployeeDTO;
import kz.f12.school.model.repository.EmployeeRepository;

public class EmployeeController extends AbstractController {

    private EmployeeRepository repository = EmployeeRepository.getInstance();

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
    private TextField searchTextField;

    @FXML
    void initialize() {
       ObservableList<EmployeeDTO> data = FXCollections.observableList(repository.getEmployeeList());
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
       nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
       depNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
       ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
       empTableView.setItems(data);
    }

}
