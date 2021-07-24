package kz.f12.school.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AbstractController {

    protected FXMLLoader openNewWindow(String templateUrl) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(templateUrl));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        return loader;
    }

}
