# JAVAFX

- [JAVAFX](#javafx)
    - [Análisis del Main](#análisis-del-main)
    - [Análisis del FXML](#análisis-del-fxml)
    - [Análisis del Controlador](#análisis-del-controlador)
    - [Crear ventana](#crear-ventana)

Como ya hemos visto, la aplicación javafx más simple está formada por un archivo main que será el que inicie la
aplicación y cargue la primera ventana, un archivo fxml (diseño ventana) y su controlador (lógica). Por cada ventana
nueva que creemos tendremos un FXML y un CONTROLLER.

---

## Análisis del Main
Este archivo iniciará nuestra aplicación y será encargada de cargar nuestra primera ventana con el FXMLLoader.

> [!NOTE]
> Nosotros siempre llamamos al archivo fxml (dependiendo de la ventana que queramos abrir) y el propio archivo
> fxml será encargado de buscar su controlador (se verá más adelante).

```java

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // es una clase en JavaFX que carga un objeto jerárquico a partir de un documento XML (FXML).
        // obtiene la ubicación del archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // qué elementos de la interfaz de usuario deben aparecer en la ventana y cómo deben organizarse.
        // tambien podemos especificar el tamaño de la ventana aunque podemos suprimirlo y especificarlo
        // en el fxml
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // stage crea una nueva ventana (nos viene desde el argumento)
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

```

---

## Análisis del FXML

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox alignment="CENTER" prefHeight="148.0" prefWidth="184.0" spacing="20.0" xmlns="http://javafx.com/javafx/11.0.14-internal" 
      xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.inicio_javafx.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>

   <Label text="Nombre base de datos:" />


   <TextField fx:id="idNombre" />

   <Label text="Contraseña:" />

   <PasswordField fx:id="idContrasena" />

    <Button minWidth="300.0" onAction="#entrar" text="ENTRAR" />

   <Label fx:id="respuesta" />
</VBox>


```

En la etiqueta de VBox encontraremos el vínculo entre el FXML y el controlador `<VBox ... fx:controller="com.example.inicio_javafx.HelloController">`

> [!IMPORTANT]
> Si se cambia el nombre del controlador hay que asegurarse que el `fx:controller` es el correcto.

Para relacionar las "etiquetas" como puede ser en el ejemplo `Label`, `TextField` entre otras con el controlador
debemos identificarlas con un id: `fx:id="..."`.

En cuanto a los botones vemos que dentro de la etiqueta tendremos el atributo `onAction="#nombre_del_metodo"` que
servirá de conector con un método que se creará en el controlador.

---

## Análisis del Controlador

```java
public class HelloController {
    @FXML
    public TextField idNombre;
    @FXML
    public PasswordField idContrasena;
    @FXML
    public Label respuesta;

    @FXML
    public void entrar() {

        String nombre = idNombre.getText();
        String contrasena = idContrasena.getText();

        respuesta.setText(nombre + " " + contrasena);
    }

}
```

Este es el archivo que está relacionado con su FXML y en el que pondremos la lógica. En este ejemplo podemos ver como
en primer lugar declaramos las variables que creamos en el FXML.

Seguidamente podemos ver que tenemos un método (entrar) que se ejecutará lo que contiene el método una vez pulsemos el botón.

En este caso al ejecutar el método 'entrar' estamos obteniendo en dos variable diferente los valores tando
del `TextField idNombre` y del `PasswordField idContrasena` mediante un `.getText`.

Por otra parte una vez que hemos obtenido ambos valores los imprimiremos en `Label respuesta` con un `.setText`.

---

## Crear ventana

```java
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
      //
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
```
Analizaremos este código por partes para ver como podemos abrir una nueva ventana y que se cierre la que tenemos abierta.


