package studentManagementSystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewProfileStudentsController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private Button close_btn;
    @FXML
    private Button minimize;
    @FXML
    private TextField addStudents_firstName;
    @FXML
    private TextField addStudents_lastName;
    @FXML
    private ImageView addStudents_imageView;
    @FXML
    private TextField addStudents_middleName;
    @FXML
    private TextField addStudents_studentId;
    @FXML
    private TextField addStudents_year;
    @FXML
    private TextField addStudents_course;
    @FXML
    private TextField addStudents_suffix;
    @FXML
    private TextField addStudents_gender;
    @FXML
    private TextField addStudents_birthdate;
    @FXML
    private TextField addStudents_address;
    @FXML
    private TextField addStudents_contactNumber;
    @FXML
    private TextField addStudents_status;
    @FXML
    private TextField addStudents_religion;
    @FXML
    private TextField addStudents_citizenship;
    @FXML
    private TextField addStudents_motherName;
    @FXML
    private TextField addStudents_motherOccupation;
    @FXML
    private TextField addStudents_motherContactNumber;
    @FXML
    private TextField addStudents_motherAddress;
    @FXML
    private TextField addStudents_fatherName;
    @FXML
    private TextField addStudents_fatherOccupation;
    @FXML
    private TextField addStudents_fatherContactNumber;
    @FXML
    private TextField addStudents_fatherAddress;
    @FXML
    private TextField addStudents_elementary;
    @FXML
    private TextField addStudents_elementaryYearGraduated;
    @FXML
    private TextField addStudents_seniorHigh;
    @FXML
    private TextField addStudents_strand;
    @FXML
    private TextField addStudents_seniorHighYearGraduated;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
  
       disableEditing();

        // Disable focus and set request focus to main_form
        addStudents_firstName.setFocusTraversable(false);
        main_form.requestFocus();

        // Handle mouse click events on main_form
        main_form.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            main_form.requestFocus();
            event.consume();
        });
     
    }

    void showStudentData(studentData selectedStudent) {
        
        
        addStudents_studentId.setText(String.valueOf(selectedStudent.getStudentId()));
        addStudents_year.setText(selectedStudent.getYear());
        addStudents_course.setText(selectedStudent.getCourse());
        addStudents_firstName.setText(selectedStudent.getFirstName());
        addStudents_middleName.setText(selectedStudent.getMiddleName());
        addStudents_lastName.setText(selectedStudent.getLastName());
        addStudents_suffix.setText(selectedStudent.getSuffix());
        addStudents_gender.setText(selectedStudent.getGender());
        addStudents_birthdate.setText(selectedStudent.getBirthdate().toString());
        addStudents_address.setText(selectedStudent.getAddress());
        addStudents_contactNumber.setText(selectedStudent.getContactNumber());
        addStudents_status.setText(selectedStudent.getStatus());
        addStudents_religion.setText(selectedStudent.getReligion());
        addStudents_citizenship.setText(selectedStudent.getCitizenship());
        addStudents_motherName.setText(selectedStudent.getMothersName());
        addStudents_motherOccupation.setText(selectedStudent.getMOccupation());
        addStudents_motherContactNumber.setText(selectedStudent.getMContactNum());
        addStudents_motherAddress.setText(selectedStudent.getMAddress());
        addStudents_fatherName.setText(selectedStudent.getFathersName());
        addStudents_fatherOccupation.setText(selectedStudent.getFOccupation());
        addStudents_fatherContactNumber.setText(selectedStudent.getFContactNum());
        addStudents_fatherAddress.setText(selectedStudent.getFAddress());
        addStudents_elementary.setText(selectedStudent.getElementary());
        addStudents_elementaryYearGraduated.setText(selectedStudent.getEYearGrad());
        addStudents_seniorHigh.setText(selectedStudent.getSeniorHigh());
        addStudents_strand.setText(selectedStudent.getStrand());
        addStudents_seniorHighYearGraduated.setText(selectedStudent.getsSHYearGrad());

        // Set image
        String imagePath = selectedStudent.getImage();
        if (imagePath != null && !imagePath.isEmpty()) {
            String uri = "file:" + imagePath;
            Image image = new Image(uri);
            addStudents_imageView.setImage(image);
        } else {
            // Handle the case where no image path is available
            // For example, set a default image or leave it blank
            addStudents_imageView.setImage(null);
        }
    }
    private void disableEditing() {
    // Disable editing for various fields
    addStudents_studentId.setEditable(false);
    addStudents_year.setEditable(false);
    addStudents_course.setEditable(false);
    addStudents_firstName.setEditable(false);
    addStudents_middleName.setEditable(false);
    addStudents_lastName.setEditable(false);
    addStudents_suffix.setEditable(false);
    addStudents_gender.setEditable(false);
    addStudents_birthdate.setEditable(false);
    addStudents_address.setEditable(false);
    addStudents_contactNumber.setEditable(false);
    addStudents_status.setEditable(false);
    addStudents_religion.setEditable(false);
    addStudents_citizenship.setEditable(false);
    addStudents_motherName.setEditable(false);
    addStudents_motherOccupation.setEditable(false);
    addStudents_motherContactNumber.setEditable(false);
    addStudents_motherAddress.setEditable(false);
    addStudents_fatherName.setEditable(false);
    addStudents_fatherOccupation.setEditable(false);
    addStudents_fatherContactNumber.setEditable(false);
    addStudents_fatherAddress.setEditable(false);
    addStudents_elementary.setEditable(false);
    addStudents_elementaryYearGraduated.setEditable(false);
    addStudents_seniorHigh.setEditable(false);
    addStudents_strand.setEditable(false);
    addStudents_seniorHighYearGraduated.setEditable(false);
}
   @FXML
    public void close() {
       Stage stage = (Stage) close_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
}
