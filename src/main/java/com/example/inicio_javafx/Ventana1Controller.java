package com.example.inicio_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Ventana1Controller {

    // declaracion de las variables
    @FXML
    public TextField idNombre;
    @FXML
    public PasswordField idContrasena;
    @FXML
    public Label respuesta;

    // metodo asociado al boton del FXML
    // en este caso hemos añadido ActionEvent actionEvent en el argumento del método, ya que una vez que se crea el
    // método al crear el botón no viene con ese argumento. Con este argumento estamos captando el evento de pulsar
    // el boton que lo usaremos para identificar la ventana y cerrarla cuando se abra la siguiente ventana.
    @FXML
    public void entrar(ActionEvent actionEvent) {

        // obtenemos la información de los TextFiels
        String nombre = idNombre.getText();
        String contrasena = idContrasena.getText();

        // imprimimos en la ventana (en el Label respuesta)
        respuesta.setText(nombre + " " + contrasena);

        // llamamos al método que hemos creado para abrir una nueva ventana y le pasamos el argumento actionEvent
        // que nos servirá para cerrar la ventana.
        abrirNuevaVentana(actionEvent);

    }

    public void abrirNuevaVentana(ActionEvent event){
        try {

            // es una clase en JavaFX que carga un objeto jerárquico a partir de un documento XML (FXML).
            // obtiene la ubicación del archivo FXML
            // procurar crear un try/catch en vez de un throw

            FXMLLoader fxmlLoader = new FXMLLoader(InicioAplicacion.class.getResource("ventana2-view.fxml"));
            // qué elementos de la interfaz de usuario deben aparecer en la ventana y cómo deben organizarse.

            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            //  creando una nueva ventana que puede contener una Scene
            Stage stage = new Stage();
            stage.show();

            // CERRAR VENTANA ------------------------------

            // obtiene la fuente del evento
            Node source = (Node) event.getSource();
            // obtener la ventana actual
            stage = (Stage) source.getScene().getWindow();
            // cierra ventana
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}