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


public class UserData {
    private final SimpleIntegerProperty userId;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty middleName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty suffix;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty username;
    private final SimpleStringProperty email;
    private final SimpleStringProperty password;
    private final SimpleStringProperty privilage;
    private final SimpleStringProperty status;
    private final SimpleStringProperty image;

    public UserData(int userId, String firstName, String middleName, String lastName, String suffix, String gender, String username, String email, String password, String privilage, String status, String image) {
        this.userId = new SimpleIntegerProperty(userId);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.suffix = new SimpleStringProperty(suffix);
        this.gender = new SimpleStringProperty(gender);
        this.username = new SimpleStringProperty(username);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.privilage = new SimpleStringProperty(privilage);
        this.status = new SimpleStringProperty(status);
        this.image = new SimpleStringProperty(image);
    }
    
   

    public int getUserId() {
        return userId.get();
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

    public String getStatus() {
        return status.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getPrivilage() {
        return privilage.get();
    }

    public String getImage() {
        return image.get();
    }

   
    }
