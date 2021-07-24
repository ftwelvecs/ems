package kz.f12.school.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController extends AbstractController {

    @FXML
    private Button addButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button showAllButton;

    @FXML
    private Button deleteButton;

    @FXML
    public void initialize() {
        addButton.setOnAction(event -> {
            openNewWindow("/templates/add.fxml");
        });
    }

}
