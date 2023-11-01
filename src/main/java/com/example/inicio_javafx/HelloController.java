package com.example.inicio_javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField idNombre;
    @FXML
    public PasswordField idContrasena;
    @FXML
    public Label respuesta;

    @FXML
    public void entrar(ActionEvent actionEvent) {

        String nombre = idNombre.getText();
        String contrasena = idContrasena.getText();

        respuesta.setText(nombre + " " + contrasena);
        cambiarVentana(actionEvent);

    }

    public void cambiarVentana(ActionEvent event){
        try {
            // es una clase en JavaFX que carga un objeto jerárquico a partir de un documento XML (FXML).
            // obtiene la ubicación del archivo FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ejemplo.fxml"));
            // qué elementos de la interfaz de usuario deben aparecer en la ventana y cómo deben organizarse.
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            //  creando una nueva ventana que puede contener una Scene
            Stage stage = new Stage();
            stage.show();

            // cerrar ventana
            // obtiene la fuente del evento
            Node source = (Node) event.getSource();
            // obtener la ventana actual
            stage = (Stage) source.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}