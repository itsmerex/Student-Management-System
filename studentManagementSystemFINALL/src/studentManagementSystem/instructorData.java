package studentManagementSystem;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class instructorData {
    private final SimpleIntegerProperty instructorId;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty middleName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty suffix;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty image;
    private final SimpleStringProperty educationalAtainment;
    private final SimpleStringProperty status;
   

    public instructorData(int instructorId, String firstName, String middleName, String lastName, String suffix, String gender, String image, String educationalAtainment, String status) {
        this.instructorId = new SimpleIntegerProperty(instructorId);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.suffix = new SimpleStringProperty(suffix);
        this.gender = new SimpleStringProperty(gender);
        this.image = new SimpleStringProperty(image);
        this.educationalAtainment = new SimpleStringProperty(educationalAtainment);
        this.status = new SimpleStringProperty(status);
  
    }
    
   

    public int getInstructorId() {
        return instructorId.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getSuffix() {
        return suffix.get();
    }

    public String getGender() {
        return gender.get();
    }
    
    public String getImage() {
        return image.get();
    }
  
    public String getEducationalAtainment() {
        return educationalAtainment.get();
    }
     public String getStatus() {
        return status.get();
    }

   
   
    }
