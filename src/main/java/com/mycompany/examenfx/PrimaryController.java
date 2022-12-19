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
import javafx.scene.control.TableView;
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
    @FXML
    private TableView<Persona> tabla;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> sexoLista = FXCollections.observableArrayList();
    ObservableList<String> actividadLista = FXCollections.observableArrayList();
    
    sexoLista.addAll("Hombre", "Mujer");
    actividadLista.addAll("Muy ligera", "Ligera", "Moderada", "Intensa");
   
    actividad.setItems(actividadLista);
    sexo.setItems(sexoLista);
    
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
      
         if(nombre.getText() == "")
         {
             mensaje.setText("El nombre esta vacio");
         }
         else if(sexo.valueProperty().get() == null){
             mensaje.setText("El sexo esta vacio");
         }
         else if(edad.valueFactoryProperty().get() == null){
             mensaje.setText("La edad esta vacia");
         }
         else if(peso.valueFactoryProperty().get()==null){
             mensaje.setText("El peso esta vacio");
         }
         else if(altura.valueFactoryProperty().get() == null){
             mensaje.setText("La altura esta vacia");
         }
         else if(actividad.valueProperty().get() == null){
             mensaje.setText("La actividad esta vacia");
         }
         else{
             mensaje.setText("");
             
             Persona paciente = new Persona();
             
             paciente.setNombre(nombre.getText());
             paciente.setSexo(sexo.valueProperty().get());
             paciente.setEdad(edad.getValue());
             paciente.setPeso(peso.getValue());
             paciente.setAltura(altura.getValue());
             paciente.setActividad(actividad.valueProperty().get());
             
             if(paciente.getSexo() == "Hombre" && paciente.getActividad() == "Muy ligera"){
                 paciente.setGet(1.3);
             }
             else if(paciente.getSexo() ==  "Hombre" && paciente.getActividad() == "Ligera")
             {
                 paciente.setGet(1.6);
             }
             else if(paciente.getSexo() == "Hombre" && paciente.getActividad() == "Moderada")
             {
                 paciente.setGet(1.7);
             }
             else if(paciente.getSexo() == "Hombre" && paciente.getActividad() == "Intensa")
             {
                 paciente.setGet(2.1);
             }
             else if(paciente.getSexo() == "Mujer" && paciente.getActividad() == "Muy ligera"){
                 paciente.setGet(1.3);
             }
             else if(paciente.getSexo() ==  "Mujer" && paciente.getActividad() == "Ligera")
             {
                 paciente.setGet(1.5);
             }
             else if(paciente.getSexo() == "Mujer" && paciente.getActividad() == "Moderada")
             {
                 paciente.setGet(1.6);
             }
             else if(paciente.getSexo() == "Mujer" && paciente.getActividad() == "Intensa")
             {
                 paciente.setGet(1.9);
             }
             
             if(paciente.getSexo() == "Hombre"){
                 Double temp;
                 
                temp = 66.473+13.751*paciente.getPeso()+5.0033*paciente.getAltura()-6.755*paciente.getEdad();
                
                paciente.setGer(temp);
             }
             else if(paciente.getSexo() == "Mujer"){
                 Double temp;
                 
                temp = 655.0955+9.463*paciente.getPeso()+1.8496*paciente.getAltura()-4.6756*paciente.getEdad();
                
                paciente.setGer(temp);
             }
             
                ObservableList<Persona> pacientes = FXCollections.observableArrayList();
                
                
                pacientes.addAll(tabla.getItems());
                pacientes.add(paciente);
                
                tabla.setItems(pacientes);
                
             nombre.setText("");
             sexo.valueProperty().set(null);
             edad.getValueFactory().setValue(0);
             peso.getValueFactory().setValue(0.0);
             altura.getValueFactory().setValue(0.0);
             actividad.valueProperty().set(null);
         }
    }

}
