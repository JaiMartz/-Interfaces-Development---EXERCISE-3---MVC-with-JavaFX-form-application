/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasFormulario;


import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jairo
 */
public class Alumno {
    
    private final SimpleStringProperty DNI;
    private final SimpleStringProperty Nota;
    private final SimpleStringProperty Modulo;
    private final SimpleStringProperty Recuperacion;
    
    /**
     * Constructor de la clase alumno
     * @param DNI
     * @param Nota
     * @param Modulo
     * @param Recuperacion
     */
    public Alumno (String dni, String modulo, String nota, String recuperacion){
        this.DNI = new SimpleStringProperty(dni);
        this.Modulo = new SimpleStringProperty(modulo);
        this.Nota = new SimpleStringProperty(nota);
        this.Recuperacion = new SimpleStringProperty(recuperacion);
    }

    
    public String getDNI(){
        return DNI.get();
    }
    public String getModulo(){
        return Modulo.get();
    }
    public String getNota(){
        return Nota.get();
    }
    public String getRecuperacion(){
        return Recuperacion.get();
    }
    
    //Establecemos métodos set aunque javaFX XML nos proporciona herramientas para realizar la misma función
    public void setDNI(String dni){
        this.DNI.set(dni);
    }
    public void setModulo(String modulo){
        this.Modulo.set(modulo);
    }
    public void setNota(String nota){
        this.Nota.set(nota);
    }
    public void setRecuperacion(String recuperacion){
        this.Recuperacion.set(recuperacion);  
    }
}
