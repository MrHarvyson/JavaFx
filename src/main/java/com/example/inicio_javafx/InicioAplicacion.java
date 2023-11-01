package com.example.inicio_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioAplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(InicioAplicacion.class.getResource("ventana1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}