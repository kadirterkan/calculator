package com.calculatorapp.view;

import com.calculatorapp.controller.CalculatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorView extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calculator.fxml"));
        Parent parent = fxmlLoader.load();
        CalculatorController controller = fxmlLoader.getController();
        Scene scene = new Scene(parent, 300, 475);
        parent.getStylesheets().add(getClass().getResource("calculator.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOpacity(0.95);

        scene.setOnKeyPressed(controller::keyEvent);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
}
