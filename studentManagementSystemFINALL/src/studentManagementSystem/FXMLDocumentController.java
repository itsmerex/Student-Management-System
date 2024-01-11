package studentManagementSystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginBtn;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private double x = 0;
    private double y = 0;
    @FXML
    private BorderPane main_form;
    @FXML
    private ImageView imageView;
    @FXML
    private Button handleClose;
    @FXML
    private CheckBox showpassword;
    @FXML
private TextField temporaryTextField;


    @Override
public void initialize(URL url, ResourceBundle rb) {
    // Add listeners for username, password, and showpassword fields
    addTextFieldListener(username);
    addTextFieldListener(password);
    addTextFieldListener(temporaryTextField);
    // Add a listener to the showPasswordCheckbox
        showpassword.selectedProperty().addListener((observable, oldValue, newValue) -> {
            updatePasswordField();
        });
     // Set focus on the username field using Platform.runLater
    Platform.runLater(() -> {
        username.requestFocus();
    });
    // Add a key event listener to the username field
    username.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.TAB) {
            // If the "tab" key is pressed, set the focus to the password field
            password.requestFocus();
        }
    });
}


 // Add a listener for a TextField to disallow spaces
private void addTextFieldListener(TextField textField) {
    textField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue.contains(" ")) {
            textField.setText(newValue.replaceAll("\\s", "")); // Remove spaces
        }
    });
    temporaryTextField.textProperty().addListener((observable, oldValue, newValue) -> {
    if (showpassword.isSelected()) {
        // If the checkbox is selected, update the password field in real-time
        password.setText(newValue);
    }
});
}

    @FXML
    
    public void loginAdmin() throws IOException {
    String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
    connect = database.connectDb();

    try {
        Alert alert;

        // Check for spaces in username or password
        if (username.getText().contains(" ") || password.getText().contains(" ")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Username and password cannot contain spaces");
            alert.showAndWait();
            return; 
        }

        prepare = connect.prepareStatement(sql);
        prepare.setString(1, username.getText());
        prepare.setString(2, password.getText());

        result = prepare.executeQuery();

        // CHECK IF FIELDS ARE EMPTY
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            if (result.next()) {
                String userPrivilege = result.getString("privilage");

                // Redirect to dashboard
                if ("ADMIN".equals(userPrivilege)) {
                    openDashboard(userPrivilege);
                } else if ("INSTRUCTOR".equals(userPrivilege)) {
                    openDashboard(userPrivilege);
                } else {
                    // Handle other cases
                }

                // Update the password field visibility
                updatePasswordField();
            } else {
                // Handle unsuccessful login
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Username/Password");
                alert.showAndWait();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   private void updatePasswordField() {
    if (showpassword.isSelected()) {
        if (password.getText().isEmpty()){
            password.setText(temporaryTextField.getText());
            temporaryTextField.setVisible(true);
            password.setVisible(false);
        }else{
            // If selected, show the actual text using the temporary TextField
        temporaryTextField.setText(password.getText());
        temporaryTextField.setVisible(true);

        // Hide the actual PasswordField
        password.setVisible(false);
        }

    } else {
        // If not selected, reset the PasswordField to obscured text
        password.setText(temporaryTextField.getText());
        temporaryTextField.setVisible(false);

        // Show the actual PasswordField
        password.setVisible(true);
    }
}
  
    private void openDashboard(String userPrivilege) throws IOException {
        // HIDE THE LOGIN FORM
        loginBtn.getScene().getWindow().hide();

        // LINK TO DASHBOARD
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Parent root = loader.load();

        // Access the controller of the dashboard
        dashboardController dashboardController = loader.getController();
        dashboardController.initData(userPrivilege);

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((javafx.scene.input.MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((javafx.scene.input.MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(javafx.stage.StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }

    
    @FXML
    private void handleClose(ActionEvent event) {
        System.exit(0);
    }

  
}
