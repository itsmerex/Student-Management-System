package studentManagementSystem;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddSubjectsController implements Initializable {

    private TableColumn<?, String> subjectCode;
    private TableColumn<?, String> subjectDesc;
    private TableColumn<?, String> instructor;
    private TableColumn<?, String> schedule;
    private TableColumn<?, String> room;
    private TableColumn<?, String> units;
   
    @FXML
    private Button minimize;
    @FXML
    private Button close_btn;
    @FXML
    private AnchorPane mainform;

  
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
     @FXML
    public void close() {
        
        Stage stage = (Stage) close_btn.getScene().getWindow();
        stage.close();
    }
   @FXML
public void minimize() {
    Stage stage = (Stage) mainform.getScene().getWindow();
    stage.setIconified(true);
}


}
