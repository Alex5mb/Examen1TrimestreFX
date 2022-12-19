package com.mycompany.examenfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private ComboBox<String> sexo;
    @FXML
    private ComboBox<String> actividad;
    @FXML
    private Spinner<Integer> edad;
    @FXML
    private Spinner<Double> peso;
    @FXML
    private Spinner<Double> altura;
    @FXML
    private Button boton;
    @FXML
    private Label mensaje;
    @FXML
    private TableColumn<String, String> tabla_nombre;
    @FXML
    private TableColumn<String, String> tabla_sexo;
    @FXML
    private TableColumn<Integer, Integer> tabla_edad;
    @FXML
    private TableColumn<Double, Double> tabla_peso;
    @FXML
    private TableColumn<Double, Double> tabla_altura;
    @FXML
    private TableColumn<String, String> tabla_Actividad;
    @FXML
    private TableColumn<Double, Double> tabla_Ger;
    @FXML
    private TableColumn<Double, Double> Tabla_Get;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> sexo = FXCollections.observableArrayList();
    ObservableList<String> actividad = FXCollections.observableArrayList();
    sexo.addAll("Hombre", "Mujer");
    actividad.addAll("Ligera", "Muy ligera", "Moderada", "Intensa");
    actividad.setAll(actividad);
    sexo.setAll(sexo);
    edad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
    peso.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 300, 0));
    altura.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 300, 0));

    tabla_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
    tabla_sexo.setCellValueFactory(new PropertyValueFactory("sexo"));
    tabla_edad.setCellValueFactory(new PropertyValueFactory("edad"));
    tabla_peso.setCellValueFactory(new PropertyValueFactory("peso"));
    tabla_altura.setCellValueFactory(new PropertyValueFactory("altura"));
    tabla_Actividad.setCellValueFactory(new PropertyValueFactory("actividad"));
    tabla_Ger.setCellValueFactory(new PropertyValueFactory("ger"));
    Tabla_Get.setCellValueFactory(new PropertyValueFactory("get"));

    }

    @FXML
    private void update(ActionEvent event) {
      
        nombre.setText("");
      
        
        
        
       
       
    }

}
