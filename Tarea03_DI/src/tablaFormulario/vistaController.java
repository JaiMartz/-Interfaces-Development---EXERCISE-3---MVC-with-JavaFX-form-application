package tablaFormulario;


import notasFormulario.Alumno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Jairo
 */
public class vistaController implements Initializable {
    

    @FXML private TableView tableNotas;
    
    @FXML private TableColumn tbcDNI;
    @FXML private TableColumn tbcModulo;
    @FXML private TableColumn tbcNota;
    @FXML private TableColumn tbcRecu;
    
    public static final ObservableList<Alumno> tablaAlumnos = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    
        tbcDNI.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("DNI"));
        tbcModulo.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("Modulo"));
        tbcNota.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("Nota"));
        tbcRecu.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("Recuperacion"));
        
        tableNotas.setItems(tablaAlumnos);
    }
    
    
    
}
