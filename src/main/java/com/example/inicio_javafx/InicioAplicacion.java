package com.example.inicio_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioAplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // es una clase en JavaFX que carga un objeto jerárquico a partir de un documento XML (FXML).
        // obtiene la ubicación del archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(InicioAplicacion.class.getResource("ventana1-view.fxml"));

        // qué elementos de la interfaz de usuario deben aparecer en la ventana y cómo deben organizarse.
        // tambien podemos especificar el tamaño de la ventana aunque podemos suprimirlo y especificarlo
        // en el fxml
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");
        // le decimos a la ventana que escena debe cargar
        stage.setScene(scene);
        // esencial el metodo show para que nos salga en pantalla la ventana
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}