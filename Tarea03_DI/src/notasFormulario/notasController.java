/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasFormulario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import static java.lang.Integer.parseInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static tablaFormulario.vistaController.tablaAlumnos;

/**
 * FXML Controller class
 *
 * @author Jairo
 */
public class notasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TextField tfDNI;
    @FXML private TextField tfModulo;
    @FXML private TextField tfNota;
    @FXML private TextField tfRecu;
    
    /**
     * Method that save the form information when the button is clicked and check
     * all the conditions.
     * @param event 
     */
    public void botonGuardar(ActionEvent event){
        String dni = tfDNI.getText();
        String Modulo = tfModulo.getText();
        String Nota = tfNota.getText();
        String Recuperacion = tfRecu.getText();
        
        //Realizamos comparación del campo DNI
        Pattern patr = Pattern.compile("[0-9]{8}[A-Z]{1}");
        Matcher match = patr.matcher(tfDNI.getText());
    
        if(tfDNI.getText().equals("")|| tfModulo.getText().equals("") 
                || tfNota.getText().equals("") || tfRecu.getText().equals("")){
        
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mensaje de error");
            alert.setContentText("Existen campos en blanco.");
            alert.show();
            
        }else if(!match.matches()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mensaje de error");
            alert.setContentText("El campo de DNI debe contener ocho números y una letra mayúscula.");   
            alert.show();
        }else if(!numeroComparacion(Nota)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mensaje de error");
            alert.setContentText("El campo Nota debe ser un número.");
            alert.show();
        }else if( parseInt(Nota)>10 || parseInt(Nota)<0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mensaje de error");
            alert.setContentText("El campo Nota debe estar entre 0 - 10");
            alert.show();
        }else if(!numeroComparacion(Recuperacion)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mensaje de error");
            alert.setContentText("El campo Recuperacion debe ser un número.");
            alert.show();
        }else if(parseInt(Recuperacion)>5 || parseInt(Recuperacion)<0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mensaje de error");
            alert.setContentText("El campo Recuperación debe estar entre 0 - 5");
            alert.show();
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Mensaje de información");
            alert.setContentText("Se han introducido los datos correctamente.");
            alert.show();
            if(parseInt(Nota)>=5 && parseInt(Nota)<=10){
               Recuperacion=null;
            }
            Alumno alumno = new Alumno(dni,Modulo, Nota, Recuperacion);
            tablaAlumnos.add(alumno);
            limpiarCampos();
           }
    }
    /**
     * Method that clean all the fields.
     */
    public void limpiarCampos(){
        tfDNI.setText("");
        tfModulo.setText("");
        tfNota.setText("");
        tfRecu.setText("");
    }
    /**
     * Method that check if the string passed is compound by integer numbers.
     * @param cadena
     * @return 
     */
    public static boolean numeroComparacion(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }

    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
