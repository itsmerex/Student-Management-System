/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManagementSystem;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.StringConverter;
import java.util.function.UnaryOperator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.SelectionModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;




import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;

public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private Button home_btn;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button availableCourse_btn;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private Label home_totalFemale;

    @FXML
    private Label home_totalMale;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private AreaChart<?, ?> home_totalFemaleChart;

    @FXML
    private LineChart<?, ?> home_totalMaleChart;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private TextField addStudents_search;
    
    @FXML
    private TableView<UserData> addUsers_tableView;


    @FXML
    private TableView<studentData> addStudents_tableView;

    private TableColumn<studentData, String> addStudents_col_studentNum;

    @FXML
    private TableColumn<studentData, String> addStudents_col_year;

    @FXML
    private TableColumn<studentData, String> addStudents_col_course;

    @FXML
    private TableColumn<studentData, String> addStudents_col_firstName;
    
    @FXML
    private TableColumn<studentData, String> addStudents_col_middleName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_lastName;
    
    @FXML
    private TableColumn<studentData, String> addStudents_col_suffix;
    
    @FXML
    private TableColumn<studentData, String> addStudents_col_gender;

    @FXML
    private TableColumn<studentData, String> addStudents_col_birth;

    @FXML
    private TableColumn<studentData, String> addStudents_col_status;

    private TextField addStudents_studentNum;

    @FXML
    private ComboBox<String> addStudents_year;

    @FXML
    private ComboBox<String> addStudents_course;

    @FXML
    private TextField addStudents_firstName;
    
    @FXML
    private TextField addStudents_middleName;

    @FXML
    private TextField addStudents_lastName;
    
    @FXML
    private ComboBox<String> addStudents_suffix;

    private DatePicker addStudents_birth;

    @FXML
    private ComboBox<String> addStudents_status;

    @FXML
    private ComboBox<String> addStudents_gender;

    @FXML
    private ImageView addStudents_imageView;

    @FXML
    private Button addStudents_insertBtn;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private AnchorPane availableCourse_form;

    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_description;

    @FXML
    private TextField availableCourse_degree;

    @FXML
    private Button availableCourse_addBtn;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private Button availableCourse_deleteBtn;
    
    
    @FXML
    private TableView<courseData> availableCourse_tableView;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_course;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_description;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_degree;
    
    @FXML
    private AnchorPane studentGrade_form;

    private Label studentGrade_studentNum;

    @FXML
    private Label studentGrade_year;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private TableView<studentData> studentGrade_tableView;

    private TableColumn<studentData, String> studentGrade_col_studentNum;
    
    @FXML
    private TableColumn<studentData, String> studentGrade_col_year;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_course;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_firstSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_secondSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_final;

    @FXML
    private TextField studentGrade_search;
    private Image image;

    @FXML
    private Button studentGrade_updateBtn;
    @FXML
    private Button studentGrade_clearBtn;   
    @FXML
    private Button addUsers_btn;
    @FXML
    private AnchorPane addUsers_form;
    @FXML
    private TextField addUsers_search;
    @FXML
    private TableColumn<?, ?> addUsers_col_firstName;
    @FXML
    private TableColumn<?, ?> addUsers_col_middleName;
    @FXML
    private TableColumn<?, ?> addUsers_col_lastName;
    @FXML
    private TableColumn<?, ?> addUsers_col_suffix;
    @FXML
    private TableColumn<?, ?> addUsers_col_gender;
    @FXML
    private TableColumn<?, ?> addUsers_col_username;
    @FXML
    private TableColumn<?, ?> addUsers_col_email;
    @FXML
    private TableColumn<?, ?> addUsers_col_password;
    @FXML
    private TableColumn<?, ?> addUsers_col_image;
    @FXML
    private TableColumn<?, ?> addUsers_col_privilage;
    @FXML
    private TableColumn<?, ?> addUsers_col_status;
    @FXML
    private Label addUsers_userId;
    @FXML
    private TextField addUsers_firstName;
    @FXML
    private TextField addUsers_lastName;
    @FXML
    private ImageView addUsers_imageView;
    @FXML
    private Button addUsers_insertBtn;
    @FXML
    private Button addUsers_addBtn;
    @FXML
    private Button addUsers_updateBtn;
    @FXML
    private Button addUsers_deleteBtn;
    @FXML
    private Button addUsers_clearBtn;
    @FXML
    private TextField addUsers_middleName;
    @FXML
    private TextField addUsers_username;
    @FXML
    private TextField addUsers_email;
    @FXML
    private TextField addUsers_password;
    @FXML
    private TableColumn<?, ?> addStudents_col_studentId;
    @FXML
    private Label addStudents_studentId;
    @FXML
    private TableColumn<?, ?> availableCourse_col_courseId;
    @FXML
    private Label studentGrade_studentGradeId;
    @FXML
    private TableColumn<?, ?> studentGrade_col_studentGradeId;
    @FXML
    private Label availableCourse_courseId;
    @FXML
    private TableColumn<?, ?> addUsers_col_userId;
    @FXML
    private ComboBox<String> addUsers_suffix;
    @FXML
    private ComboBox<String> addUsers_gender;
    @FXML
    private ComboBox<String> addUsers_privilage;
    @FXML
    private ComboBox<String> addUsers_status;

    
    private double x, y;
    
    private ObservableList<studentData> studentGradesList;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

   @FXML
    private Button addSubject_btn;
    @FXML
    private Button schedule_btn;
    @FXML
    private Button instructor_btn;
    @FXML
    private AnchorPane addInstructors_form;
    @FXML
    private TextField addInstructors_search;
    @FXML
    private TableView<instructorData> addInstructors_TableView;
    @FXML
    private TableColumn<instructorData, Integer> addInstructors_col_instructorsId;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_firstName;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_middleName;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_lastName;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_suffix;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_gender;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_image;
    @FXML
    private TableColumn<instructorData, String> addInstructors_col_status;
    @FXML
    private TextField addInstructors_firstName;
    @FXML
    private TextField addInstructors_lastName;
    @FXML
    private ComboBox<String> addInstructors_gender;
    @FXML
    private ComboBox<String> addInstructors_status;
    @FXML
    private ImageView addInstructors_imageView;
    @FXML
    private Button addInstructors_insertBtn;
    @FXML
    private Button addInstructors_addBtn;
    @FXML
    private Button addInstructors_updateBtn;
    @FXML
    private Button addInstructors_deleteBtn;
    @FXML
    private Button addInstructors_clearBtn;
    @FXML
    private TextField addInstructors_middleName;
    @FXML
    private ComboBox<String> addInstructors_suffix;
    @FXML
    private AnchorPane addSchedule_form;
    @FXML
    private Button addSubjects_btn;
    @FXML
    private AnchorPane addSubjects_form;
    @FXML
    private TextField addSubjects_units;
    @FXML
    private TextField addSubjects_program;
    @FXML
    private Button addSubjects_updateBtn;
    @FXML
    private Button addSubjects_addBtn;
    @FXML
    private TextField addSubjects_subjectCode;
    @FXML
    private TextField addSubjects_description;
    @FXML
    private Label addSubjects_subjectId;
    @FXML
    private Button addSubjects_clearBtn;
    @FXML
    private TextField addSubjects_search;
    @FXML
    private TableView<subjectAdd> addSubjects_tableView;
    @FXML
    private TableColumn<subjectAdd, Integer> addSubjects_col_subjectId;
    @FXML
    private TableColumn<subjectAdd, String> addSubjects_col_subjectCode;
    @FXML
    private TableColumn<subjectAdd, String> addSubjects_col_description;
    @FXML
    private TableColumn<subjectAdd, String> addSubjects_col_units;
    @FXML
    private TableColumn<subjectAdd, String> addSubjects_col_program;
    @FXML
    private TableColumn<subjectAdd, String> addInstructors_col_educationalAtainment;
    @FXML
    private TextField addInstructors_educationalAtainment;
    @FXML
    private Label addInstructors_instructorId;
    @FXML
    private TableColumn<subjectAdd, String> addSubjects_col_status;
    private UserData instructorD;
    private instructorData subjectAdd;
    @FXML
    private Label studentGrade_name;
    @FXML
    private TableColumn<?, ?> studentGrade_col_name;
    @FXML
    private Button addSubject_btn1;
    @FXML
    private TextField addStudents_address;
    @FXML
    private TextField addStudents_motherName;
    @FXML
    private TextField addStudents_contactNumber;
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
    @FXML
    private TextField addStudents_religion;
    @FXML
    private TextField addStudents_citizenship;
    private Date sqlDate;
    @FXML
    private DatePicker addStudents_birthdate;
    @FXML
    private Button addSubjects_deleteBtn;
    @FXML
    private ComboBox<String> addSubjects_status;
    private String status;
 

    
    
    public void initData(String userPrivilege) {
        // Handle the initialization based on userPrivilege
        if ("ADMIN".equals(userPrivilege)) {
            addUsers_btn.setDisable(false);
        } else {
            addUsers_btn.setDisable(true);
            addStudents_btn.setDisable(true);
            availableCourse_btn.setDisable(true);
            instructor_btn.setDisable(true);
            addSubjects_btn.setDisable(true);   
        }
    
    }
    
        
   public void homeDisplayTotalEnrolledStudents() {

//        String sql = "SELECT COUNT(studentId) FROM student";
        String sql = "SELECT total_enrolled FROM student_count";

         connect = database.connectDb();



       int countEnrolled = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countEnrolled = result.getInt("total_enrolled");
            }

            home_totalEnrolled.setText(String.valueOf(countEnrolled));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayFemaleEnrolled() {

//        String sql = "SELECT COUNT(studentId) FROM student WHERE gender = 'Female' and status = 'Enrolled'";
        String sql = "SELECT female_total_enrolled FROM student_count";

      connect = database.connectDb();
        try {
            int countFemale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countFemale = result.getInt("female_total_enrolled");
            }

            home_totalFemale.setText(String.valueOf(countFemale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayMaleEnrolled() {

//        String sql = "SELECT COUNT(studentId) FROM student WHERE gender = 'Male' and status = 'Enrolled'";
        String sql = "SELECT male_total_enrolled FROM student_count";

         connect = database.connectDb();

        try {
            int countMale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countMale = result.getInt("male_total_enrolled");
            }
            home_totalMale.setText(String.valueOf(countMale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayTotalEnrolledChart() {

        home_totalEnrolledChart.getData().clear();

        String sql = "SELECT date, COUNT(studentId) FROM student WHERE status = 'Enrolled' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_totalEnrolledChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayFemaleEnrolledChart() {

        home_totalFemaleChart.getData().clear();

        String sql = "SELECT date, COUNT(studentId) FROM student WHERE status = 'Enrolled' and gender = 'Female' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_totalFemaleChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

     public void homeDisplayEnrolledMaleChart() {

        home_totalMaleChart.getData().clear();

        String sql = "SELECT date, COUNT(studentId) FROM student WHERE status = 'Enrolled' and gender = 'Male' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_totalMaleChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
//pangadd sa user
@FXML
public void addUsersAdd() {
    connect = database.connectDb();

    String insertData = "INSERT INTO user "
            + "(firstName, middleName, lastName, suffix, gender, username, email, password, image, privilage, status,date) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        Alert alert;

        // Check for empty fields
        if (addUsers_firstName.getText().isEmpty()
                || addUsers_middleName.getText().isEmpty()
                || addUsers_lastName.getText().isEmpty()
                || addUsers_suffix.getSelectionModel().getSelectedItem() == null
                || addUsers_gender.getSelectionModel().getSelectedItem() == null
                || addUsers_username.getText().isEmpty()
                || addUsers_email.getText().isEmpty()
                || addUsers_password.getText().isEmpty()
                || getData.path == null || getData.path.isEmpty()
                
                || addUsers_privilage.getSelectionModel().getSelectedItem() == null
                || addUsers_status.getSelectionModel().getSelectedItem() == null) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            String uri = getData.path.replace("\\", "\\\\");

            prepare = connect.prepareStatement(insertData, Statement.RETURN_GENERATED_KEYS);
            prepare.setString(1, addUsers_firstName.getText());
            prepare.setString(2, addUsers_middleName.getText());
            prepare.setString(3, addUsers_lastName.getText());
            prepare.setString(4, addUsers_suffix.getSelectionModel().getSelectedItem());
            prepare.setString(5, addUsers_gender.getSelectionModel().getSelectedItem());
            prepare.setString(6, addUsers_username.getText());
            prepare.setString(7, addUsers_email.getText());
            prepare.setString(8, addUsers_password.getText());
            prepare.setString(9, uri);
            prepare.setString(10, addUsers_privilage.getSelectionModel().getSelectedItem());
            prepare.setString(11, addUsers_status.getSelectionModel().getSelectedItem());

            // Set the registration date
            LocalDate date = LocalDate.now();
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            prepare.setDate(12, sqlDate);

            prepare.executeUpdate();

            ResultSet generatedKeys = prepare.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added! User ID: " + userId);
                alert.showAndWait();
            }

            // TO UPDATE THE TABLEVIEW
            addUsersShowListData();
            // TO CLEAR THE FIELDS
            addUsersClear();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//pang update sa user
@FXML
public void addUsersUpdate() {
    String uri = getData.path;
    if (uri != null && !uri.isEmpty()) {
        uri = uri.replace("\\", "\\\\");
    } else {
        System.err.println("Warning: getData.path is null or empty.");
        uri = "defaultImagePath";
    }

    String updateData = "UPDATE user SET "
            + "firstName = ?, middleName = ?, lastName = ?, suffix = ?, gender = ?, "
            + "username = ?, email = ?, password = ?, image = ?, privilage = ?, status = ? "
            + "WHERE userId = ?";

    connect = database.connectDb();

    try {
        Alert alert;
        if (addUsers_userId.getText().isEmpty()
                || addUsers_firstName.getText().isEmpty()
                || addUsers_middleName.getText().isEmpty()
                || addUsers_lastName.getText().isEmpty()
                || addUsers_suffix.getSelectionModel().getSelectedItem() == null
                || addUsers_gender.getSelectionModel().getSelectedItem() == null
                || addUsers_username.getText().isEmpty()
                || addUsers_email.getText().isEmpty()
                || addUsers_password.getText().isEmpty()
                || addUsers_privilage.getSelectionModel().getSelectedItem() == null
                || addUsers_status.getSelectionModel().getSelectedItem() == null
                || getData.path == null || getData.path.isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE User #" + addUsers_userId.getText() + "?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, addUsers_firstName.getText());
                prepare.setString(2, addUsers_middleName.getText());
                prepare.setString(3, addUsers_lastName.getText());
                prepare.setString(4, addUsers_suffix.getSelectionModel().getSelectedItem());
                prepare.setString(5, addUsers_gender.getSelectionModel().getSelectedItem());
                prepare.setString(6, addUsers_username.getText());
                prepare.setString(7, addUsers_email.getText());
                prepare.setString(8, addUsers_password.getText());
                prepare.setString(9, uri);
                prepare.setString(10, addUsers_privilage.getSelectionModel().getSelectedItem());
                prepare.setString(11, addUsers_status.getSelectionModel().getSelectedItem());

//                LocalDate date = LocalDate.now();
//                java.sql.Date sqlDate = java.sql.Date.valueOf(date);
//                prepare.setDate(12, sqlDate);

                prepare.setInt(12, Integer.parseInt(addUsers_userId.getText()));

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addUsersShowListData();
                // TO CLEAR THE FIELDS
                addUsersClear();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//pang delete/update sa users

@FXML
public void addUsersDelete() {
    String deleteData = "CALL UpdateUserStatus(?);";

    connect = database.connectDb();
    try {
        Alert alert;

        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to DELETE User #" + addUsers_userId.getText() + "?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            prepare = connect.prepareStatement(deleteData);
            prepare.setInt(1, Integer.parseInt(addUsers_userId.getText()));

            prepare.executeUpdate();
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Deleted!");
            alert.showAndWait();

            // TO UPDATE THE TABLEVIEW
            addUsersShowListData();
            // TO CLEAR THE FIELDS
            addUsersClear();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//pang clear sa user
@FXML
public void addUsersClear() {
    addUsers_userId.setText("");
    addUsers_firstName.setText("");
    addUsers_middleName.setText("");
    addUsers_lastName.setText("");
    addUsers_suffix.getSelectionModel().clearSelection();
    addUsers_gender.getSelectionModel().clearSelection();
    addUsers_username.setText("");
    addUsers_email.setText("");
    addUsers_password.setText("");
    addUsers_privilage.getSelectionModel().clearSelection();
    addUsers_status.getSelectionModel().clearSelection();
    addUsers_imageView.setImage(null);

    getData.path = "";
}

// pang insert sa image user
@FXML
public void addUsersInsertImage() {
    FileChooser open = new FileChooser();
    open.setTitle("Open Image File");
    open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

    File file = open.showOpenDialog(main_form.getScene().getWindow());

    if (file != null) {
        image = new Image(file.toURI().toString(), 120, 149, false, true);
        addUsers_imageView.setImage(image);

        getData.path = file.getAbsolutePath();
    }
}

// pang search sa user
@FXML
public void addUsersSearch() {
    FilteredList<UserData> filter = new FilteredList<>(addUsersListD, e -> true);

    addUsers_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate(userD -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            return userDataMatchesSearch(userD, searchKey);
        });
    });

    SortedList<UserData> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(addUsers_tableView.comparatorProperty());
    addUsers_tableView.setItems(sortList);
}

private boolean userDataMatchesSearch(UserData userD, String searchKey) {
    String[] properties = {
            userD.getFirstName(),
            userD.getMiddleName(),
            userD.getLastName(),
            userD.getSuffix(),
            userD.getGender(),
            userD.getUsername(),
            userD.getEmail(),
            userD.getPassword(),
            userD.getPrivilage(),
            userD.getStatus(),
        
    };

    for (String property : properties) {
        String lowercaseProperty = property != null ? property.toLowerCase() : "";
        if (lowercaseProperty.contains(searchKey)) {
            return true;
        }
    }

    return String.valueOf(userD.getUserId()).contains(searchKey);
}


private final String[] suffixList = {"N/A","JR","SR", "II","III","IV"};

public void addUsersSuffixList() {
    List<String> suffixL = new ArrayList<>();

    for (String data : suffixList) {
        suffixL.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(suffixL);
    addUsers_suffix.setItems(ObList);
}

private final String[] privilegeList = {"ADMIN", "INSTRUCTOR"};

public void addUsersPrivilageList() {
    List<String> privilegeL = new ArrayList<>();

    for (String data : privilegeList) {
        privilegeL.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(privilegeL);
    addUsers_privilage.setItems(ObList);
}

private final String[] statusList = {"ACTIVE", "INACTIVE", "SUSPENDED"};

public void addUsersStatusList() {
    List<String> statusL = new ArrayList<>();

    for (String data : statusList) {
        statusL.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(statusL);
    addUsers_status.setItems(ObList);
}

private final String[] genderList = {"MALE", "FEMALE", "LGBTQIA+"};

public void addUsersGenderList() {
    List<String> genderL = new ArrayList<>();

    for (String data : genderList) {
        genderL.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(genderL);
    addUsers_gender.setItems(ObList);
}


public ObservableList<UserData> addUsersListData() {
    ObservableList<UserData> listUsers = FXCollections.observableArrayList();

    String sql = "SELECT * FROM user";

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

            while (result.next()) {
               UserData userD = new UserData(
            result.getInt("userId"),
            result.getString("firstName"),
            result.getString("middleName"),
            result.getString("lastName"),
            result.getString("suffix"),
            result.getString("gender"),
            result.getString("username"),
            result.getString("email"),
            result.getString("password"),
            result.getString("privilage"),
            result.getString("status"),
            result.getString("image")
    );


            listUsers.add(userD);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listUsers;
}

//pang show sa users sa table view
private ObservableList<UserData> addUsersListD;

public void addUsersShowListData() {
    addUsersListD = addUsersListData();

    addUsers_col_userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
    addUsers_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    addUsers_col_middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
    addUsers_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    addUsers_col_suffix.setCellValueFactory(new PropertyValueFactory<>("suffix"));
    addUsers_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    addUsers_col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
    addUsers_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
    addUsers_col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
    addUsers_col_privilage.setCellValueFactory(new PropertyValueFactory<>("privilage"));
    addUsers_col_image.setCellValueFactory(new PropertyValueFactory<>("image"));
    addUsers_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

    addUsers_tableView.setItems(addUsersListD);
}

// pang click sa mga info sa users
@FXML
public void addUsersSelect() {
    UserData userD = addUsers_tableView.getSelectionModel().getSelectedItem();

    if (userD != null) {
        int userId = userD.getUserId();
        addUsers_userId.setText(String.valueOf(userId));
        addUsers_firstName.setText(userD.getFirstName());
        addUsers_middleName.setText(userD.getMiddleName());
        addUsers_lastName.setText(userD.getLastName());
        addUsers_suffix.setValue(userD.getSuffix());
        addUsers_gender.setValue(userD.getGender());
        addUsers_username.setText(userD.getUsername());
        addUsers_email.setText(userD.getEmail());
        addUsers_password.setText(userD.getPassword());
        addUsers_privilage.setValue(userD.getPrivilage());
        addUsers_status.setValue(userD.getStatus());

        String uri = "file:" + userD.getImage();

        Image image = new Image(uri, 120, 149, false, true);
        addUsers_imageView.setImage(image);

        getData.path = userD.getImage();
    }
}

// pang add sa students

@FXML
public void addStudentsAdd() {
    connect = database.connectDb();

    String insertData = "INSERT INTO student "
        + "(year, course, firstName, middleName, lastName, suffix, gender, birthdate,address, contactNumber,status, image, date, "
        + " religion, citizenship, mothersName, mOccupation, mContactNum, mAddress,"
        + "fathersName,fOccupation,fContactNum, fAddress, elementary, eYearGrad, seniorHigh, strand, shYearGrad) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        Alert alert;

        if (addStudents_year.getSelectionModel().getSelectedItem() == null
            || addStudents_course.getSelectionModel().getSelectedItem() == null
            || addStudents_firstName.getText().isEmpty()
            || addStudents_middleName.getText().isEmpty()
            || addStudents_lastName.getText().isEmpty()
            || addStudents_suffix.getSelectionModel().getSelectedItem() == null
            || addStudents_gender.getSelectionModel().getSelectedItem() == null
            || addStudents_birthdate.getValue() == null
            || addStudents_status.getSelectionModel().getSelectedItem() == null
            || addStudents_address.getText().isEmpty()
            || addStudents_contactNumber.getText().isEmpty()
            || addStudents_religion.getText().isEmpty()
            || addStudents_citizenship.getText().isEmpty()
            || addStudents_motherName.getText().isEmpty()
            || addStudents_motherOccupation.getText().isEmpty()
            || addStudents_motherContactNumber.getText().isEmpty()
            || addStudents_motherAddress.getText().isEmpty()
            || addStudents_fatherName.getText().isEmpty()
            || addStudents_fatherOccupation.getText().isEmpty()
            || addStudents_fatherContactNumber.getText().isEmpty()
            || addStudents_fatherAddress.getText().isEmpty()
            || addStudents_elementary.getText().isEmpty()
            || addStudents_elementaryYearGraduated.getText().isEmpty()
            || addStudents_seniorHigh.getText().isEmpty()
            || addStudents_strand.getText().isEmpty()
            || addStudents_seniorHighYearGraduated.getText().isEmpty()
            || getData.path == null || getData.path.isEmpty()) {  // Check for empty path
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String uri = getData.path;
            uri = uri.replace("\\", "\\\\");

            // Insert data into the student table
            prepare = connect.prepareStatement(insertData, Statement.RETURN_GENERATED_KEYS);
            prepare.setString(1, (String) addStudents_year.getSelectionModel().getSelectedItem());
            prepare.setString(2, (String) addStudents_course.getSelectionModel().getSelectedItem());
            prepare.setString(3, addStudents_firstName.getText());
            prepare.setString(4, addStudents_middleName.getText());
            prepare.setString(5, addStudents_lastName.getText());
            prepare.setString(6, (String) addStudents_suffix.getSelectionModel().getSelectedItem());
            prepare.setString(7, (String) addStudents_gender.getSelectionModel().getSelectedItem());
            prepare.setDate(8, java.sql.Date.valueOf(addStudents_birthdate.getValue()));
            prepare.setString(9, addStudents_address.getText());
            prepare.setString(10, addStudents_contactNumber.getText());
            prepare.setString(11, (String) addStudents_status.getSelectionModel().getSelectedItem());
            prepare.setString(12, uri);
            LocalDate date = LocalDate.now();
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            prepare.setDate(13, sqlDate);
            prepare.setString(14, addStudents_religion.getText());
            prepare.setString(15, addStudents_citizenship.getText());
            prepare.setString(16, addStudents_motherName.getText());
            prepare.setString(17, addStudents_motherOccupation.getText());
            prepare.setString(18, addStudents_motherContactNumber.getText());
            prepare.setString(19, addStudents_motherAddress.getText());
            prepare.setString(20, addStudents_fatherName.getText());
            prepare.setString(21, addStudents_fatherOccupation.getText());
            prepare.setString(22, addStudents_fatherContactNumber.getText());
            prepare.setString(23, addStudents_fatherAddress.getText());
            prepare.setString(24, addStudents_elementary.getText());
            prepare.setString(25, addStudents_elementaryYearGraduated.getText());
            prepare.setString(26, addStudents_seniorHigh.getText());
            prepare.setString(27, addStudents_strand.getText());
            prepare.setString(28, addStudents_seniorHighYearGraduated.getText());
        
            prepare.executeUpdate();

            // Get the auto-generated student ID
            ResultSet generatedKeys = prepare.getGeneratedKeys();
            int studentId = -1;
            if (generatedKeys.next()) {
                studentId = generatedKeys.getInt(1);
            }

           // Insert data into the studentgrade table using the retrieved studentId
            String insertStudentGrade = "INSERT INTO studentgrade "
                + "(studentId,studentGrade_col_name, year, course, firstSem, secondSem, final) "
                + "VALUES (?, CONCAT(?, ' ', ?, ' ', ?, ' ', ?), ?, ?, ?, ?, ?)";
            
            prepare = connect.prepareStatement(insertStudentGrade);
            prepare.setInt(1, studentId);
            prepare.setString(2, addStudents_firstName.getText());
            prepare.setString(3, addStudents_middleName.getText());
            prepare.setString(4, addStudents_lastName.getText());
            prepare.setString(5, (String) addStudents_suffix.getSelectionModel().getSelectedItem());
            prepare.setString(6, (String) addStudents_year.getSelectionModel().getSelectedItem());
            prepare.setString(7, (String) addStudents_course.getSelectionModel().getSelectedItem());
            prepare.setString(8, "0");
            prepare.setString(9, "0");
            prepare.setString(10, "0");

            prepare.executeUpdate();
          
            // Show success message
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added! Student ID: " + studentId);
            alert.showAndWait();

            // TO UPDATE THE TABLEVIEW
            addStudentsShowListData();
            // TO CLEAR THE FIELDS
            addStudentsClear();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}
// pang update sa students
    @FXML
    public void addStudentsUpdate() {

        String uri = getData.path;
        if (uri != null && !uri.isEmpty()) {
            uri = uri.replace("\\", "\\\\");
        } else {
            // Handle the case where getData.path is null or empty
            System.err.println("Warning: getData.path is null or empty.");
            uri = "defaultImagePath";
        }
        
        

        String updateData = "UPDATE student SET "
                + "year = '" + addStudents_year.getSelectionModel().getSelectedItem()
                + "', course = '" + addStudents_course.getSelectionModel().getSelectedItem()
                + "', firstName = '" + addStudents_firstName.getText()
                + "', middleName = '" + addStudents_middleName.getText()
                + "', lastName = '" + addStudents_lastName.getText()
                + "', suffix = '" + addStudents_suffix.getSelectionModel().getSelectedItem()
                + "', gender = '" + addStudents_gender.getSelectionModel().getSelectedItem()
                + "', birthdate = '" + addStudents_birthdate.getValue()
                + "', status = '" + addStudents_status.getSelectionModel().getSelectedItem()
                + "', image = '" + uri 
                + "', address = '" + addStudents_address.getText()
                + "', contactNumber = '" + addStudents_contactNumber.getText()
                + "', religion = '" + addStudents_religion.getText()
                + "', citizenship = '" + addStudents_citizenship.getText()
                + "', mothersName = '" + addStudents_motherName.getText()
                + "', mOccupation = '" + addStudents_motherOccupation.getText()
                + "', mContactNum = '" + addStudents_motherContactNumber.getText()
                + "', mAddress = '" + addStudents_motherAddress.getText()
                + "', fathersName = '" + addStudents_fatherName.getText()
                + "', fOccupation = '" + addStudents_fatherOccupation.getText()
                + "', fContactNum = '" + addStudents_fatherContactNumber.getText()
                + "', fAddress = '" + addStudents_fatherAddress.getText()
                + "', elementary = '" + addStudents_elementary.getText()
                + "', eYearGrad = '" + addStudents_elementaryYearGraduated.getText()
                + "', seniorHigh = '" + addStudents_seniorHigh.getText()
                + "', strand = '" + addStudents_strand.getText()
                + "', shYearGrad = '" + addStudents_seniorHighYearGraduated.getText()
                + "' WHERE studentId = '"
                + addStudents_studentId.getText() + "'";
             
              
      connect = database.connectDb();
                            
        try {
            Alert alert;
            if (addStudents_studentId.getText().isEmpty()
                    || addStudents_year.getSelectionModel().getSelectedItem() == null
                    || addStudents_course.getSelectionModel().getSelectedItem() == null
                    || addStudents_firstName.getText().isEmpty()
                    || addStudents_middleName.getText().isEmpty()
                    || addStudents_lastName.getText().isEmpty()
                    || addStudents_suffix.getSelectionModel().getSelectedItem() == null
                    || addStudents_gender.getSelectionModel().getSelectedItem() == null
                    || addStudents_birthdate.getValue() == null
                    || addStudents_status.getSelectionModel().getSelectedItem() == null
                    || addStudents_address.getText().isEmpty()
                    || addStudents_contactNumber.getText().isEmpty()
                    || addStudents_religion.getText().isEmpty()
                    || addStudents_citizenship.getText().isEmpty()
                    || addStudents_motherName.getText().isEmpty()
                    || addStudents_motherOccupation.getText().isEmpty()
                    || addStudents_motherContactNumber.getText().isEmpty()
                    || addStudents_motherAddress.getText().isEmpty()
                    || addStudents_fatherName.getText().isEmpty()
                    || addStudents_fatherOccupation.getText().isEmpty()
                    || addStudents_fatherContactNumber.getText().isEmpty()
                    || addStudents_fatherAddress.getText().isEmpty()
                    || addStudents_elementary.getText().isEmpty()
                    || addStudents_elementaryYearGraduated.getText().isEmpty()
                    || addStudents_seniorHigh.getText().isEmpty()
                    || addStudents_strand.getText().isEmpty()
                    || addStudents_seniorHighYearGraduated.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + addStudents_studentId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();

                } else {
                    return;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    // pang delete/update sa student
    @FXML
    public void addStudentsDelete() {
       String studentIdString = addStudents_studentId.getText();
    // Convert the string representation to an integer
    int studentIdValue = Integer.parseInt(studentIdString);
    String deleteData = "CALL UpdateStudentStatus("+studentIdValue+")";

    connect = database.connectDb();
    try {
        Alert alert;

        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to DELETE Student #" + addStudents_studentId.getText() + "?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {

            statement = connect.createStatement();
            statement.executeUpdate(deleteData);

            String deleteGrade = "DELETE FROM studentgrade WHERE "
                    + "studentId = '" + addStudents_studentId.getText() + "'";

            statement = connect.createStatement();
            statement.executeUpdate(deleteGrade);

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Deleted!");
            alert.showAndWait();

            // TO UPDATE THE TABLEVIEW
            addStudentsShowListData();
            // TO CLEAR THE FIELDS
            addStudentsClear();

        } else {
            return;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}
// pang clear sa students
     @FXML
    public void addStudentsClear() {
        addStudents_studentId.setText("");
        addStudents_year.getSelectionModel().clearSelection();
        addStudents_course.getSelectionModel().clearSelection();
        addStudents_firstName.setText("");
        addStudents_middleName.setText("");
        addStudents_lastName.setText("");
        addStudents_suffix.getSelectionModel().clearSelection();
        addStudents_gender.getSelectionModel().clearSelection();
        addStudents_birthdate.setValue(null);
        addStudents_status.getSelectionModel().clearSelection();
        addStudents_imageView.setImage(null);
        addStudents_address.setText("");
        addStudents_contactNumber.setText("");
        addStudents_religion.setText("");
        addStudents_citizenship.setText("");
        addStudents_motherName.setText("");
        addStudents_motherOccupation.setText("");
        addStudents_motherContactNumber.setText("");
        addStudents_motherAddress.setText("");
        addStudents_fatherName.setText("");
        addStudents_fatherOccupation.setText("");
        addStudents_fatherContactNumber.setText("");
        addStudents_fatherAddress.setText("");
        addStudents_elementary.setText("");
        addStudents_elementaryYearGraduated.setText("");
        addStudents_seniorHigh.setText("");
        addStudents_strand.setText("");
        addStudents_seniorHighYearGraduated.setText("");

        getData.path = "";
    }

    // pang insert sa image sa student
    @FXML
    public void addStudentsInsertImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            image = new Image(file.toURI().toString(), 120, 149, false, true);
            addStudents_imageView.setImage(image);

            getData.path = file.getAbsolutePath();

        }
    } 

    // pang search sa students
    @FXML
    public void addStudentsSearch() {
    FilteredList<studentData> filter = new FilteredList<>(addStudentsListD, e -> true);

    addStudents_search.textProperty().addListener((Observable, oldValue, newValue) -> {
        filter.setPredicate(studentData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            return studentDataMatchesSearch(studentData, searchKey);
        });
    });

    SortedList<studentData> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
    addStudents_tableView.setItems(sortList);
}

    private boolean studentDataMatchesSearch(studentData data, String searchKey) {
    String[] properties = {
            data.getYear(),
            data.getCourse(),
            data.getFirstName(),
            data.getMiddleName(),
            data.getLastName(),
            data.getSuffix(),
            data.getGender(),
            data.getStatus(),
            data.getAddress(),
            data.getContactNumber(),
            data.getReligion(),
            data.getCitizenship(),
            data.getMothersName(),
            data.getMOccupation(),
            data.getMAddress(),
            data.getFathersName(),
            data.getFOccupation(),
            data.getFAddress(),
            data.getElementary(),
            data.getEYearGrad(),
            data.getSeniorHigh(),
            data.getStrand(),
            data.getsSHYearGrad(),
            data.getBirthdate() != null ? data.getBirthdate().toString() : ""
    };

    for (String property : properties) {
        String lowercaseProperty = property != null ? property.toLowerCase() : "";
        if (lowercaseProperty.contains(searchKey)) {
            return true;
        }
    }

    // Check student number separately
  return String.valueOf(data.getStudentId()).contains(searchKey);

}


    private String[] yearList = {"1ST YEAR", "2ND YEAR", "3RD YEAR", "4TH YEAR"};

    
    public void addStudentsYearList() {

        List<String> yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        addStudents_year.setItems(ObList);

    }

    public void addStudentsCourseList() {

        String listCourse = "SELECT * FROM course";

        connect = database.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("course"));
            }
            addStudents_course.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
   private final String[] suffixList1 = {"N/A","JR","SR", "II","III","IV"};
    public void addStudentsSuffixList() {
        List<String> suffixL = new ArrayList<>();

        for (String data : suffixList1) {
            suffixL.add(data);
            
        }

        ObservableList ObList = FXCollections.observableArrayList(suffixL);
        addStudents_suffix.setItems(ObList);
    }
    
 private final String[] genderList1 = {"MALE", "FEMALE", "LGBTQIA+"};
    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList1) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudents_gender.setItems(ObList);
    }
    private String[] statusList1 = {"ENROLLED", "NOT ENROLLED", "INACTIVE"};
    public void addStudentsStatusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : statusList1) {
            statusL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        addStudents_status.setItems(ObList);
    }


    public ObservableList<studentData> addStudentsListData() {

        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student";

        connect = database.connectDb();

        try {
            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                            studentD = new studentData(result.getInt("studentId"),
                    result.getString("year"),
                    result.getString("course"),
                    result.getString("firstName"),
                    result.getString("middleName"),
                    result.getString("lastName"),
                    result.getString("suffix"),
                    result.getString("gender"),
                    result.getDate("birthdate"),  // Corrected column name here
                    result.getString("address"),
                    result.getString("contactNumber"),
                    result.getString("status"),
                    result.getString("image"),
                    result.getString("religion"),
                    result.getString("citizenship"),
                    result.getString("mothersName"),
                    result.getString("mOccupation"),
                    result.getString("mContactNum"),
                    result.getString("mAddress"),
                    result.getString("fathersName"),
                    result.getString("fOccupation"),
                    result.getString("fContactNum"),
                    result.getString("fAddress"),
                    result.getString("elementary"),
                    result.getString("eYearGrad"),
                    result.getString("seniorHigh"),
                    result.getString("strand"),
                    result.getString("shYearGrad"));

                listStudents.add(studentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    private ObservableList<studentData> addStudentsListD;

    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        addStudents_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudents_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_suffix.setCellValueFactory(new PropertyValueFactory<>("suffix"));
        addStudents_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudents_col_birth.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        addStudents_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudents_tableView.setItems(addStudentsListD);

    }

 @FXML
    public void addSubjectsLoader() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("addSubjects.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();

        //addSubject_btn.getScene().getWindow().hide();
 
 }
 private int getSelectedStudentId() {
       
        studentData selectedStudent = addStudents_tableView.getSelectionModel().getSelectedItem();
        return (selectedStudent != null) ? selectedStudent.getStudentId() : -1;
    }

    private studentData getStudentDataFromDatabase(int selectedStudentId) {
        String sql = "SELECT * FROM student where studentId = '+ +'";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                
                return new studentData(selectedStudentId, "Year", "Course", "FirstName", "MiddleName", "LastName", "Suffix", "Gender", new Date(System.currentTimeMillis()), "Address", "ContactNumber", "Status", "Image",
                "Religion", "Citizenship", "MotherName", "MOccupation", "MContactNum", "MAddress", "FathersName",
                "FOccupation", "FContactNum", "FAddress", "Elementary", "EYearGrad", "SeniorHigh", "Strand", "SHYearGrad");
               
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
       
        
    }
    void showStudentData(studentData selectedStudent) {
    // Assuming that your studentData class has a method to get the image path
    String imagePath = selectedStudent.getImage();

    // Check if the image path is not null or empty
    if (imagePath != null && !imagePath.isEmpty()) {
        // Assuming addStudents_imageView is an instance of ImageView
        Image image = new Image("file:" + imagePath);
        addStudents_imageView.setImage(image);
    } else {
        // Set a default image or handle the case when the image path is empty
        // For example, you can set a default image:
        // Image defaultImage = new Image("default_image_path.jpg");
        // addStudents_imageView.setImage(defaultImage);
    }

    // Now you can set other fields in the controller based on the selectedStudent
    addStudents_firstName.setText(selectedStudent.getFirstName());
    addStudents_lastName.setText(selectedStudent.getLastName());
    // Add more fields as needed
}



 @FXML
    public void viewProfileLoader() throws IOException {
        
        int selectedStudentId = getSelectedStudentId();

      
        studentData selectedStudent = getStudentDataFromDatabase(selectedStudentId);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewProfileStudents.fxml"));
        Parent root = loader.load();
        ViewProfileStudentsController viewProfileController = loader.getController();

        // Pass the selected student to the controller
        viewProfileController.showStudentData(selectedStudent);

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        addStudents_firstName.setFocusTraversable(false);
        stage.setScene(scene);
        stage.show();
    }
  
 @FXML
public void addStudentsSelect() {
    studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();

    if (studentD != null) {
        int studentId = studentD.getStudentId();

        addStudents_studentId.setText(String.valueOf(studentId));
        addStudents_year.setValue(studentD.getYear());
        addStudents_course.setValue(studentD.getCourse());
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_middleName.setText(studentD.getMiddleName());
        addStudents_lastName.setText(studentD.getLastName());
        addStudents_suffix.setValue(studentD.getSuffix());
        addStudents_gender.setValue(studentD.getGender());
        addStudents_birthdate.setValue(studentD.getBirthdate().toLocalDate());
        addStudents_address.setText(studentD.getAddress());
        addStudents_contactNumber.setText(studentD.getContactNumber());
        addStudents_status.setValue(studentD.getStatus());
        addStudents_religion.setText(studentD.getReligion());
        addStudents_citizenship.setText(studentD.getCitizenship());
        addStudents_motherName.setText(studentD.getMothersName());
        addStudents_motherOccupation.setText(studentD.getMOccupation());
        addStudents_motherContactNumber.setText(studentD.getMContactNum());
        addStudents_motherAddress.setText(studentD.getMAddress());
        addStudents_fatherName.setText(studentD.getFathersName());
        addStudents_fatherOccupation.setText(studentD.getFOccupation());
        addStudents_fatherContactNumber.setText(studentD.getFContactNum());
        addStudents_fatherAddress.setText(studentD.getFAddress());
        addStudents_elementary.setText(studentD.getElementary());
        addStudents_elementaryYearGraduated.setText(studentD.getEYearGrad());
        addStudents_seniorHigh.setText(studentD.getSeniorHigh());
        addStudents_strand.setText(studentD.getStrand());
        addStudents_seniorHighYearGraduated.setText(studentD.getsSHYearGrad());
           
        
        

        String uri = "file:" + studentD.getImage();
        Image image = new Image(uri, 120, 149, false, true);
        addStudents_imageView.setImage(image);

        getData.path = studentD.getImage();

        // Enable the addSubject_btn
        addSubject_btn.setDisable(false);
        addSubject_btn1.setDisable(false);
    } else {
        // If no row is selected, disable the addSubject_btn
        addSubject_btn.setDisable(true);
        addSubject_btn1.setDisable(true);
    }
}


@FXML
public void addAvailableCourse() {
    connect = database.connectDb();

    String course = availableCourse_course.getText();
    String description = availableCourse_description.getText();
    String degree = availableCourse_degree.getText();

    String checkData = "SELECT * FROM course WHERE course = ? ";
    String insertData = "INSERT INTO course (course, description, degree) VALUES (?, ?, ?)";
    String updateData = "UPDATE course SET description = ?, degree = ? WHERE course = ?";

    try {
        Alert alert;

        if (course.isEmpty() || description.isEmpty() || degree.isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            try (PreparedStatement checkStatement = connect.prepareStatement(checkData)) {
                checkStatement.setString(1, course);

                try (ResultSet result = checkStatement.executeQuery()) {
                    if (result.next()) {
                        alert = new Alert(AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Course " + course + " already exists. Do you want to update?");
                        Optional<ButtonType> option = alert.showAndWait();

                        if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                            try (PreparedStatement updateStatement = connect.prepareStatement(updateData)) {
                                updateStatement.setString(1, description);
                                updateStatement.setString(2, degree);
                                updateStatement.setString(3, course);

                                int rowsAffected = updateStatement.executeUpdate();

                                if (rowsAffected > 0) {
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Information Message");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Successfully Updated!");
                                    alert.showAndWait();

                                    availableCourseShowListData();
                                    availableCourseClear();
                                } else {
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Error Message");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Update failed. No rows affected.");
                                    alert.showAndWait();
                                }
                            }
                        }
                    } else {
                        try (PreparedStatement insertStatement = connect.prepareStatement(insertData)) {
                            insertStatement.setString(1, course);
                            insertStatement.setString(2, description);
                            insertStatement.setString(3, degree);
                            insertStatement.executeUpdate();

                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Successfully Added!");
                            alert.showAndWait();

                            availableCourseShowListData();
                            availableCourseClear();
                        }
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   @FXML
public void availableCourseUpdate() {
    String updateData = "UPDATE course SET course = ?, description = ?, degree = ? WHERE courseId = ?";

    Connection connect = null;
    PreparedStatement prepare = null;

    try {
        Alert alert;

        if (availableCourse_course.getText().isEmpty()
                || availableCourse_description.getText().isEmpty()
                || availableCourse_degree.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Course: " + availableCourse_course.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                try {
                    connect = database.connectDb();

                    // Disable autocommit
                    connect.setAutoCommit(false);

                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, availableCourse_course.getText());
                    prepare.setString(2, availableCourse_description.getText());
                    prepare.setString(3, availableCourse_degree.getText());
                    prepare.setInt(4, Integer.parseInt(availableCourse_courseId.getText()));

                    int affectedRows = prepare.executeUpdate();

                    if (affectedRows > 0) {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();

                        // Commit the transaction
                        connect.commit();

                        // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                        availableCourseShowListData();
                        // TO CLEAR THE TEXT FIELDS
                        availableCourseClear();
                    } else {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Update failed. No rows affected.");
                        alert.showAndWait();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Print the SQL exception message for debugging
                    System.err.println("SQL Exception: " + e.getMessage());
                } finally {
                    try {
                        if (prepare != null) {
                            prepare.close();
                        }
                        // Set autocommit back to true
                        if (connect != null) {
                            connect.setAutoCommit(true);
                            connect.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    @FXML
public void availableCourseDelete() {
    String deleteData = "DELETE FROM course WHERE course = ?";
    connect = database.connectDb();

    try {
        Alert alert;

        if (availableCourse_course.getText().isEmpty()
                || availableCourse_description.getText().isEmpty()
                || availableCourse_degree.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Course: " + availableCourse_course.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                try (PreparedStatement prepare = connect.prepareStatement(deleteData)) {
                    prepare.setString(1, availableCourse_course.getText());
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableCourseShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableCourseClear();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Print the SQL exception message for debugging
                    System.err.println("SQL Exception: " + e.getMessage());
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


    @FXML
    public void availableCourseClear() {
        availableCourse_courseId.setText(String.valueOf(""));
        availableCourse_course.setText("");
        availableCourse_description.setText("");
        availableCourse_degree.setText("");
    }


   private ObservableList<courseData> availableCourseList;

public void availableCourseShowListData() {
    availableCourseList = availableCourseListData();
    
    availableCourse_col_courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
    availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
    availableCourse_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
    availableCourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));

    availableCourse_tableView.setItems(availableCourseList);
}

public ObservableList<courseData> availableCourseListData() {
    ObservableList<courseData> listData = FXCollections.observableArrayList();

    String sql = "SELECT * FROM course_table";

    connect = database.connectDb();

    try {
        courseData courseD;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            courseD = new courseData(result.getInt("courseId"),
                    result.getString("course"),
                    result.getString("description"),
                    result.getString("degree"));

            listData.add(courseD);
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close your resources (PreparedStatement, ResultSet, and Connection)
        try {
            if (result != null) {
                result.close();
            }
            if (prepare != null) {
                prepare.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return listData;
}

    @FXML
    public void availableCourseSelect() {
        courseData courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        availableCourse_courseId.setText(String.valueOf(courseD.getCourseId()));
        availableCourse_course.setText(courseD.getCourse());
        availableCourse_description.setText(courseD.getDescription());
        availableCourse_degree.setText(courseD.getDegree());

    }


    
@FXML
public void addSubjects() {
    connect = database.connectDb();

    String subjectCode = addSubjects_subjectCode.getText();
    String description = addSubjects_description.getText();
    String units = addSubjects_units.getText();
    String program = addSubjects_program.getText();

    String checkData = "SELECT * FROM subject WHERE subjectCode = ?";
    String insertData = "INSERT INTO subject (subjectCode, description, units, program, status) VALUES (?, ?, ?, ?, ?)";
    String updateData = "UPDATE subject SET description = ?, units = ?, program = ? , status = ? WHERE subjectCode = ?";

    try {
        if (subjectCode.isEmpty() || description.isEmpty() || units.isEmpty() || program.isEmpty()) {
            showErrorAlert("Please fill all blank fields");
      } else if (subjectExists(subjectCode, program) != -1 && showConfirmationAlert("Subject - " + subjectCode + " and Program - " + program + " already exists.")) {
   
        } else {
            addNewSubject(subjectCode, description, units, program);
        }
    } catch (Exception e) {
        handleException(e);
    } finally {
        // Close database connections here if necessary
        subjectShowListData();
        subjectClear();
    }
}

private int subjectExists(String subjectCode, String program) throws SQLException {
    String checkData = "SELECT subId FROM subject WHERE subjectCode = ? AND program = ?";
    try (PreparedStatement checkStatement = connect.prepareStatement(checkData)) {
        checkStatement.setString(1, subjectCode);
        checkStatement.setString(2, program);
        try (ResultSet result = checkStatement.executeQuery()) {
            if (result.next()) {
                return result.getInt("subId");
            } else {
                return -1; // Subject does not exist
            }
        }
    }
}


private void addNewSubject(String subjectCode, String description, String units, String program) throws SQLException {
    String insertData = "INSERT INTO subject (subjectCode, description, units, program, status) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement insertStatement = connect.prepareStatement(insertData)) {
        insertStatement.setString(1, subjectCode);
        insertStatement.setString(2, description);
        insertStatement.setString(3, units);
        insertStatement.setString(4, program);
        insertStatement.setString(5, status);
        insertStatement.executeUpdate();

        showInformationAlert("Successfully Added!");
        // Additional actions if needed
         subjectShowListData(); // Assuming this method is called after handling the exception
         subjectClear();        // Assuming this method is called after handling the exception
    }
}

private boolean showConfirmationAlert(String contentText) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Message");
    alert.setHeaderText(null);
    alert.setContentText(contentText);

    Optional<ButtonType> option = alert.showAndWait();
    return option.isPresent() && option.get() == ButtonType.OK;
}

private void showErrorAlert(String contentText) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText(contentText);
    alert.showAndWait();
}

private void showInformationAlert(String contentText) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Message");
    alert.setHeaderText(null);
    alert.setContentText(contentText);
    alert.showAndWait();
}

private void handleException(Exception e) {
    // Log the exception or handle it more gracefully
    e.printStackTrace();
}
 private String[] statusList5 = {"ACTIVE", "INACTIVE"};
    public void addSubjectsStatusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : statusList5) {
            statusL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        addSubjects_status.setItems(ObList);
    }
@FXML
public void subjectsUpdate() {
    String checkExistenceQuery = "SELECT subId FROM subject WHERE subjectCode = ? AND program = ?";
    String updateData = "UPDATE subject SET subjectCode = ?, description = ?, units = ?, program = ? , status = ? WHERE subId = ?";

    Connection connect = null;
    PreparedStatement checkExistencePrepare = null;
    PreparedStatement updatePrepare = null;

    try {
        Alert alert;

        if (addSubjects_subjectCode.getText().isEmpty()
                || addSubjects_description.getText().isEmpty()
                || addSubjects_description.getText().isEmpty()
                || addSubjects_program.getText().isEmpty()
                || addSubjects_status.getValue().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            try {
                connect = database.connectDb();

                // Check if the combination of subjectCode and program already exists
                int subId = subjectExists(addSubjects_subjectCode.getText(), addSubjects_program.getText());

                if (subId != -1) {
                    // The combination already exists, show an error message
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject with the same subjectCode and program already exists. Update failed.");
                    alert.showAndWait();
                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    subjectShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    subjectClear();
                    return;
                }

                // Disable autocommit
                connect.setAutoCommit(false);

                // Proceed with the update since the combination doesn't exist
                updatePrepare = connect.prepareStatement(updateData);
                updatePrepare.setString(1, addSubjects_subjectCode.getText());
                updatePrepare.setString(2, addSubjects_description.getText());
                updatePrepare.setString(3, addSubjects_units.getText());
                updatePrepare.setString(4, addSubjects_program.getText());
                updatePrepare.setString(5, addSubjects_status.getValue());
                updatePrepare.setInt(6, Integer.parseInt(addSubjects_subjectId.getText()));

                int affectedRows = updatePrepare.executeUpdate();

                if (affectedRows > 0) {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // Commit the transaction
                    connect.commit();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    subjectShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    subjectClear();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update failed. No rows affected.");
                    alert.showAndWait();
                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    subjectShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    subjectClear();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Print the SQL exception message for debugging
                System.err.println("SQL Exception: " + e.getMessage());
            } finally {
                try {
                    if (checkExistencePrepare != null) {
                        checkExistencePrepare.close();
                    }
                    if (updatePrepare != null) {
                        updatePrepare.close();
                    }
                    // Set autocommit back to true
                    if (connect != null) {
                        connect.setAutoCommit(true);
                        connect.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML
public void addSubjectsDelete() {
    String deleteData = "CALL UpdateSubjectsStatus(?);";

    connect = database.connectDb();
    try {
        Alert alert;

        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to DELETE User #" + addSubjects_subjectId.getText() + "?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            prepare = connect.prepareStatement(deleteData);
            prepare.setInt(1, Integer.parseInt(addSubjects_subjectId.getText()));

            prepare.executeUpdate();
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Deleted!");
            alert.showAndWait();

            // TO UPDATE THE TABLEVIEW
           addInstructorsShowListData();
            // TO CLEAR THE FIELDS
            addInstrcutorsClear();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML
public void subjectClear() {
    addSubjects_subjectId.setText(String.valueOf(""));
    addSubjects_subjectCode.setText("");
    addSubjects_description.setText("");
    addSubjects_units.setText("");
    addSubjects_program.setText("");
    addSubjects_status.setValue(null);

}


private ObservableList<subjectAdd> subjectList;

  
public void subjectShowListData() {
    subjectList = subjectListData();

    Platform.runLater(() -> {
        addSubjects_col_subjectId.setCellValueFactory(new PropertyValueFactory<>("subId"));
        addSubjects_col_subjectCode.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
        addSubjects_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        addSubjects_col_units.setCellValueFactory(new PropertyValueFactory<>("units"));
        addSubjects_col_program.setCellValueFactory(new PropertyValueFactory<>("program"));
        addSubjects_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addSubjects_tableView.setItems(subjectList);
    });
}



public ObservableList<subjectAdd> subjectListData() {
    ObservableList<subjectAdd> listData = FXCollections.observableArrayList();

    String sql = "SELECT * FROM subject";

    connect = database.connectDb();

    try {
        subjectAdd subD;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            subD = new subjectAdd(result.getInt("subId"),
                    result.getString("subjectCode"),
                    result.getString("description"),
                    result.getString("units"),
                    result.getString("program"),
                    result.getString("status"));
                    

            listData.add(subD);
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close your resources (PreparedStatement, ResultSet, and Connection)
        try {
            if (result != null) {
                result.close();
            }
            if (prepare != null) {
                prepare.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return listData;
}

    @FXML
    public void subjectSelect() {
        subjectAdd subD = addSubjects_tableView.getSelectionModel().getSelectedItem();
        int num = addSubjects_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        addSubjects_subjectId.setText(String.valueOf(subD.getSubId()));
        addSubjects_subjectCode.setText(subD.getSubjectCode());
        addSubjects_description.setText(subD.getDescription());
        addSubjects_units.setText(subD.getUnits());
        addSubjects_program.setText(subD.getProgram());
        addSubjects_status.setValue(subD.getStatus());


    }
    
 @FXML
public void addSubjectsSearch() {
    FilteredList<subjectAdd> filter = new FilteredList<>(subjectList, e -> true);

    addSubjects_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate(subjectAdd -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            return subjectsDataMatchesSearch(subjectAdd, searchKey);
        });
    });

    SortedList<subjectAdd> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(addSubjects_tableView.comparatorProperty());
    addSubjects_tableView.setItems(sortList);
}



private boolean subjectsDataMatchesSearch(subjectAdd subjectAdd, String searchKey) {
    String[] properties = {
            String.valueOf(subjectAdd.getSubId()),
            subjectAdd.getSubjectCode(),
            subjectAdd.getDescription(),
            subjectAdd.getUnits(),
            subjectAdd.getProgram(),
             subjectAdd.getStatus(),
    };

    for (String property : properties) {
        String lowercaseProperty = property != null ? property.toLowerCase() : "";
        if (lowercaseProperty.contains(searchKey)) {
            return true;
        }
    }

    return String.valueOf(subjectAdd.getSubId()).contains(searchKey);
}

@FXML
public void studentGradesUpdate() {
    double finalCheck1 = 0;
    double finalCheck2 = 0;

    String checkData = "SELECT * FROM studentgrade WHERE studentGradeId = '"
            + studentGrade_studentGradeId.getText() + "'";

    connect = database.connectDb();

    double finalResult = 0;

    try {
        prepare = connect.prepareStatement(checkData);
        result = prepare.executeQuery();

        if (result.next()) {
            finalCheck1 = result.getDouble("firstSem");
            finalCheck2 = result.getDouble("secondSem");
        }

        // Check if the text fields are not empty before parsing their values
        if (!studentGrade_firstSem.getText().isEmpty()) {
            double firstSemValue = Double.parseDouble(studentGrade_firstSem.getText());

            // Calculate finalResult only if firstSem is not 0
            if (finalCheck1 != 0) {
                finalResult = firstSemValue;

                // If the second semester grade is provided, update finalResult
                if (!studentGrade_secondSem.getText().isEmpty() && finalCheck2 != 0) {
                    double secondSemValue = Double.parseDouble(studentGrade_secondSem.getText());
                    finalResult = (finalResult + secondSemValue) / 2;
                }
            }
        }

        
        String updateData = "UPDATE studentgrade SET "
                + " year = '" + studentGrade_year.getText()
                + "', course = '" + studentGrade_course.getText()
                + "', firstSem = '" + studentGrade_firstSem.getText()
                + "', secondSem = '" + studentGrade_secondSem.getText()
                + "', final = '" + finalResult + "' WHERE studentGradeId = '"
                + studentGrade_studentGradeId.getText() + "'";

        Alert alert;

        if (studentGrade_studentGradeId.getText().isEmpty()
              ||  studentGrade_year.getText().isEmpty()
                || studentGrade_course.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Student #" + studentGrade_studentGradeId.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(updateData);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                studentGradesShowListData();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}




    @FXML
    public void studentGradesClear() {
        studentGrade_studentGradeId.setText("");
        studentGrade_year.setText("");
        studentGrade_course.setText("");
        studentGrade_firstSem.setText("");
        studentGrade_secondSem.setText("");
    }

        public ObservableList<studentData> studentGradesListData() {

        ObservableList<studentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM studentgrade";

       connect = database.connectDb();
        try {
            studentData studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new studentData(result.getInt("studentId"),
                         result.getString("studentGrade_col_name"),  
                         result.getString("year"),
                         result.getString("course"),
                         result.getDouble("firstSem"),
                         result.getDouble("secondSem"),
                         result.getDouble("final"));

                listData.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void studentGradesShowListData() {
        studentGradesList = studentGradesListData();

        studentGrade_col_studentGradeId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentGrade_col_name.setCellValueFactory(new PropertyValueFactory<>("studentGrade_col_name"));
        studentGrade_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        studentGrade_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        studentGrade_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("firstSem"));
        studentGrade_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("secondSem"));
        studentGrade_col_final.setCellValueFactory(new PropertyValueFactory<>("final"));

        studentGrade_tableView.setItems(studentGradesList);

    }

    @FXML
    public void studentGradesSelect() {

        studentData studentD = studentGrade_tableView.getSelectionModel().getSelectedItem();
        int num = studentGrade_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        studentGrade_studentGradeId.setText(String.valueOf(studentD.getStudentId()));
        studentGrade_name.setText(studentD.getStudentGrade_col_name());
        studentGrade_year.setText(studentD.getYear());
        studentGrade_course.setText(studentD.getCourse());
        studentGrade_firstSem.setText(String.valueOf(studentD.getFirstSem()));
        studentGrade_secondSem.setText(String.valueOf(studentD.getSecondSem()));
        
    }
    @FXML
     public void studentGradesSearch() {
    FilteredList<studentData> filter = new FilteredList<>(studentGradesList, e -> true);

    studentGrade_search.textProperty().addListener((Observable, oldValue, newValue) -> {
        filter.setPredicate(studentData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            return studentGradesDataMatchesSearch(studentData, searchKey);
        });
    });

    SortedList<studentData> sortList = new SortedList<>(filter);

    sortList.comparatorProperty().bind(studentGrade_tableView.comparatorProperty());
    studentGrade_tableView.setItems(sortList);
}

    private boolean studentGradesDataMatchesSearch(studentData data, String searchKey) {
    String[] properties = {
            String.valueOf(data.getStudentId()),
            data.getYear(),
            data.getCourse(),
            String.valueOf(data.getFirstSem()),
            String.valueOf(data.getSecondSem()),
            String.valueOf(data.getFinals())
    };

    for (String property : properties) {
        String lowercaseProperty = property.toLowerCase();
        if (lowercaseProperty.contains(searchKey)) {
            return true;
        }
    }

    return false;
}
 
    @FXML
public void addInstructorsAdd() {
    connect = database.connectDb();

    String insertData = "INSERT INTO instructor "
            + "(firstName, middleName, lastName, suffix, gender, image, educationalAtainment, status) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        Alert alert;

        if (addInstructors_firstName.getText().isEmpty()
                || addInstructors_middleName.getText().isEmpty()
                || addInstructors_lastName.getText().isEmpty()
                || addInstructors_suffix.getSelectionModel().getSelectedItem() == null
                || addInstructors_gender.getSelectionModel().getSelectedItem() == null
                || getData.path == null || getData.path.isEmpty()
                || addInstructors_educationalAtainment.getText().isEmpty()
                || addInstructors_status.getSelectionModel().getSelectedItem() == null) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            String uri = getData.path.replace("\\", "\\\\");

            prepare = connect.prepareStatement(insertData, Statement.RETURN_GENERATED_KEYS);
            prepare.setString(1, addInstructors_firstName.getText());
            prepare.setString(2, addInstructors_middleName.getText());
            prepare.setString(3, addInstructors_lastName.getText());
            prepare.setString(4, (String) addInstructors_suffix.getSelectionModel().getSelectedItem());
            prepare.setString(5, (String) addInstructors_gender.getSelectionModel().getSelectedItem());
            prepare.setString(6, uri);
            prepare.setString(7, addInstructors_educationalAtainment.getText());
            prepare.setString(8, (String) addInstructors_status.getSelectionModel().getSelectedItem());

            prepare.executeUpdate();

            ResultSet generatedKeys = prepare.getGeneratedKeys();
            if (generatedKeys.next()) {
                int instructorId = generatedKeys.getInt(1);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added! Instructor ID: " + instructorId);
                alert.showAndWait();
            }

            // TO UPDATE THE TABLEVIEW
            addInstructorsShowListData();
            // TO CLEAR THE FIELDS
            addInstrcutorsClear();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//pang update sa instrcutor
@FXML
public void addInstructorsUpdate() {
    String uri = getData.path;
    if (uri != null && !uri.isEmpty()) {
        uri = uri.replace("\\", "\\\\");
    } else {
        System.err.println("Warning: getData.path is null or empty.");
        uri = "defaultImagePath";
    }

    String updateData = "UPDATE instructor SET "
            + "firstName = ?, middleName = ?, lastName = ?, suffix = ?, gender = ?, "
            + "image = ?, educationalAtainment = ?, status = ? "
            + "WHERE instructorId = ?";

    connect = database.connectDb();

    try {
        Alert alert;
        if (addInstructors_instructorId.getText().isEmpty()
                || addInstructors_firstName.getText().isEmpty()
                || addInstructors_middleName.getText().isEmpty()
                || addInstructors_lastName.getText().isEmpty()
                || addInstructors_suffix.getSelectionModel().getSelectedItem() == null
                || addInstructors_gender.getSelectionModel().getSelectedItem() == null
                || getData.path == null || getData.path.isEmpty()
                || addInstructors_educationalAtainment.getText().isEmpty()
                || addInstructors_status.getSelectionModel().getSelectedItem() == null) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE User #" + addInstructors_instructorId.getText() + "?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, addInstructors_firstName.getText());
                prepare.setString(2, addInstructors_middleName.getText());
                prepare.setString(3, addInstructors_lastName.getText());
                prepare.setString(4, (String) addInstructors_suffix.getSelectionModel().getSelectedItem());
                prepare.setString(5, (String) addInstructors_gender.getSelectionModel().getSelectedItem());
                prepare.setString(6, uri);
                prepare.setString(7, addInstructors_educationalAtainment.getText());
                prepare.setString(8, (String) addInstructors_status.getSelectionModel().getSelectedItem());
                prepare.setInt(9, Integer.parseInt(addInstructors_instructorId.getText()));

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addInstructorsShowListData();
                // TO CLEAR THE FIELDS
                addInstrcutorsClear();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//pang delete/update sa instrcutor

@FXML
public void addInstructorsDelete() {
    String deleteData = "CALL UpdateInstructorStatus(?);";

    connect = database.connectDb();
    try {
        Alert alert;

        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to DELETE User #" + addInstructors_instructorId.getText() + "?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            prepare = connect.prepareStatement(deleteData);
            prepare.setInt(1, Integer.parseInt(addInstructors_instructorId.getText()));

            prepare.executeUpdate();
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Deleted!");
            alert.showAndWait();

            // TO UPDATE THE TABLEVIEW
           addInstructorsShowListData();
            // TO CLEAR THE FIELDS
            addInstrcutorsClear();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    //pang clear sa instrcutor
@FXML
public void addInstrcutorsClear() {
    addInstructors_instructorId.setText("");
    addInstructors_firstName.setText("");
    addInstructors_middleName.setText("");
    addInstructors_lastName.setText("");
    addInstructors_suffix.getSelectionModel().clearSelection();
    addInstructors_gender.getSelectionModel().clearSelection();
    addInstructors_imageView.setImage(null);
    addInstructors_educationalAtainment.setText("");
    addInstructors_status.getSelectionModel().clearSelection();
    
    getData.path = "";
}

// pang insert sa image isntrcutor
@FXML
public void addInstructorsInsertImage() {
    FileChooser open = new FileChooser();
    open.setTitle("Open Image File");
    open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

    File file = open.showOpenDialog(main_form.getScene().getWindow());

    if (file != null) {
        image = new Image(file.toURI().toString(), 120, 149, false, true);
        addInstructors_imageView.setImage(image);

        getData.path = file.getAbsolutePath();
    }
}

// pang search sa instructor
 @FXML
public void addInstructorsSearch() {
    FilteredList<instructorData> filter = new FilteredList<>(addInstructorsListD, e -> true);

    addUsers_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate(instructorData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            return instructorsDataMatchesSearch(instructorData, searchKey);
        });
    });

    SortedList<instructorData> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(addInstructors_TableView.comparatorProperty());
    addInstructors_TableView.setItems(sortList);
}

private boolean instructorsDataMatchesSearch(instructorData instructorD, String searchKey) {
    String[] properties = {
            instructorD.getFirstName(),
            instructorD.getMiddleName(),
            instructorD.getLastName(),
            instructorD.getSuffix(),
            instructorD.getGender(),
            instructorD.getEducationalAtainment(),
            instructorD.getStatus(),
    };

    for (String property : properties) {
        String lowercaseProperty = property != null ? property.toLowerCase() : "";
        if (lowercaseProperty.contains(searchKey)) {
            return true;
        }
    }

    return String.valueOf(instructorD.getInstructorId()).contains(searchKey);
}


private final String[] suffixList3 = {"N/A","JR","SR", "II","III","IV"};

public void addInstructorsSuffixList() {
    List<String> suffixL1 = new ArrayList<>();

    for (String data : suffixList3) {
        suffixL1.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(suffixL1);
    addInstructors_suffix.setItems(ObList);
}

private final String[] statusList3 = {"ACTIVE", "INACTIVE"};

public void addInstructorsStatusList() {
    List<String> statusL = new ArrayList<>();

    for (String data : statusList3) {
        statusL.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(statusL);
    addInstructors_status.setItems(ObList);
}

private final String[] genderList2 = {"MALE", "FEMALE", "LGBTQIA+"};

public void addInstructorsGenderList() {
    List<String> genderL = new ArrayList<>();

    for (String data : genderList2) {
        genderL.add(data);
    }

    ObservableList<String> ObList = FXCollections.observableArrayList(genderL);
    addInstructors_gender.setItems(ObList);
}

public ObservableList<instructorData> addInstructorsListData() {
    ObservableList<instructorData> listInstructors = FXCollections.observableArrayList();

    String sql = "SELECT * FROM instructor";

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

            while (result.next()) {
               instructorData insctructorD = new instructorData(
            result.getInt("instructorId"),
            result.getString("firstName"),
            result.getString("middleName"),
            result.getString("lastName"),
            result.getString("suffix"),
            result.getString("gender"),
            result.getString("image"),
            result.getString("educationalAtainment"),
            result.getString("status")
           
    );


            listInstructors.add(insctructorD);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listInstructors;
}

//pang show sa instructors sa table view
        
private ObservableList<instructorData> addInstructorsListD;

public void addInstructorsShowListData() {
    addInstructorsListD = addInstructorsListData();

    addInstructors_col_instructorsId.setCellValueFactory(new PropertyValueFactory<>("instructorId"));
    addInstructors_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    addInstructors_col_middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
    addInstructors_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    addInstructors_col_suffix.setCellValueFactory(new PropertyValueFactory<>("suffix"));
    addInstructors_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    addInstructors_col_image.setCellValueFactory(new PropertyValueFactory<>("image"));
    addInstructors_col_educationalAtainment.setCellValueFactory(new PropertyValueFactory<>("educationalAtainment"));  // Corrected
    addInstructors_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));


    addInstructors_TableView.setItems(addInstructorsListD);
}
 
// pang click sa mga info sa instructors
    @FXML
    public void addInstructorsSelect() {
    instructorData instructorD = addInstructors_TableView.getSelectionModel().getSelectedItem();

    if (instructorD != null) {
        int instructorId = instructorD.getInstructorId();
        addInstructors_instructorId.setText(String.valueOf(instructorId));
        addInstructors_firstName.setText(instructorD.getFirstName());
        addInstructors_middleName.setText(instructorD.getMiddleName());
        addInstructors_lastName.setText(instructorD.getLastName());
        addInstructors_suffix.setValue(instructorD.getSuffix());
        addInstructors_gender.setValue(instructorD.getGender());
        addInstructors_educationalAtainment.setText(instructorD.getEducationalAtainment());
        addInstructors_status.setValue(instructorD.getStatus());

        String uri = "file:" + instructorD.getImage();

        Image image = new Image(uri, 120, 149, false, true);
        addInstructors_imageView.setImage(image);

        getData.path = instructorD.getImage();
    }
}


    
    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(false);
            addSubjects_form.setVisible(false); 
            
            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            homeDisplayEnrolledMaleChart();
            homeDisplayFemaleEnrolledChart();
            homeDisplayTotalEnrolledChart();
            
         } else if (event.getSource() == addUsers_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(true);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(false);
            addSubjects_form.setVisible(false); 
            
            addUsersSuffixList();
            addUsersPrivilageList();
            addUsersStatusList();
            addUsersGenderList();
            addUsersShowListData();
            addUsersSearch();        

        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(true);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(false);
            addSubjects_form.setVisible(false); 
            
            addStudentsShowListData();
            addStudentsYearList();
            addStudentsGenderList();
            addStudentsSuffixList();
            addStudentsStatusList();
            addStudentsCourseList();
            addStudentsSearch();

        } else if (event.getSource() == availableCourse_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(true);
            studentGrade_form.setVisible(false);
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(false);
            addSubjects_form.setVisible(false); 
            
            availableCourseShowListData();

        } else if (event.getSource() == studentGrade_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(true);
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(false);
            addSubjects_form.setVisible(false); 
            
            studentGradesShowListData();
            studentGradesSearch();

        }
   
         else if (event.getSource() == instructor_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            addInstructors_form.setVisible(true);
            addSchedule_form.setVisible(false);  
            addSubjects_form.setVisible(false); 
            
          
         
           addInstructorsGenderList();
           addInstructorsSuffixList();
           addInstructorsStatusList();
           addInstructorsSearch();
           addInstructorsShowListData();
           
        }
        
         else if (event.getSource() == schedule_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(true);  
            addSubjects_form.setVisible(false); 
        }
        
        else if (event.getSource() == addSubjects_btn) {
            home_form.setVisible(false);
            addUsers_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            addInstructors_form.setVisible(false);
            addSchedule_form.setVisible(false);  
            addSubjects_form.setVisible(true); 
            
            addSubjectsStatusList();
        }
        
    }
    // pang integer na function
    private TextFormatter<String> createNumericTextFormatter() {
    UnaryOperator<Change> filter = change -> {
        String newText = change.getControlNewText();
        // Allow only numeric input with a maximum length of 11
       if (newText.matches("\\d{0,11}")) {
            return change;
        }
        return null; // Reject the change
    };

    StringConverter<String> converter = new StringConverter<>() {
        @Override
        public String fromString(String string) {
            return string; // No conversion needed
        }

        @Override
        public String toString(String object) {
            return object; // No conversion needed
        }
    };

    return new TextFormatter<>(converter, null, filter);
}
    // pang uppercase sa letter
    private TextFormatter<String> createUppercaseTextFormatter() {
    UnaryOperator<Change> filter = change -> {
        change.setText(change.getText().toUpperCase()); // Convert to uppercase
        return change;
    };

    StringConverter<String> converter = new StringConverter<>() {
        @Override
        public String fromString(String string) {
            return string; // No conversion needed
        }

        @Override
        public String toString(String object) {
            return object != null ? object.toUpperCase() : ""; // Convert to uppercase
        }
    };

    return new TextFormatter<>(converter, null, filter);
}

     @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
   
        
        homeDisplayTotalEnrolledStudents();
        homeDisplayMaleEnrolled();
        homeDisplayFemaleEnrolled();
        homeDisplayEnrolledMaleChart();
        homeDisplayFemaleEnrolledChart();
        homeDisplayTotalEnrolledChart();

        addUsersSuffixList();
        addUsersPrivilageList();
        addUsersStatusList();
        addUsersGenderList();
        addUsersShowListData();
        addUsersSearch();     
        
        
        
        addStudentsYearList();
        addStudentsGenderList();
        addStudentsStatusList();
        addStudentsCourseList();  
        addStudentsSuffixList();
        addStudentsShowListData();

        availableCourseShowListData();

        studentGradesShowListData();
        
        subjectShowListData();
        
        
        addInstructorsGenderList();
        addInstructorsSuffixList();
        addInstructorsStatusList();
        addInstructorsShowListData();
        addInstructorsSearch();
        
         addSubjectsStatusList();
       
        
        
        

        addStudents_tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            // If a student is selected, enable the addSubject_btn
            addSubject_btn.setDisable(false);
        } else {
            // If no selection, disable the addSubject_btn
            addSubject_btn.setDisable(true);
        }
    });
        
       
     //addUsers
     addUsers_firstName.setTextFormatter(createUppercaseTextFormatter());
     addUsers_middleName.setTextFormatter(createUppercaseTextFormatter());
     addUsers_lastName.setTextFormatter(createUppercaseTextFormatter()); 
     //addUsers_username.setTextFormatter(createUppercaseTextFormatter());
     //addUsers_email.setTextFormatter(createUppercaseTextFormatter());   
    // addUsers_password.setTextFormatter(createUppercaseTextFormatter());   

        
     //addstudents
     addStudents_firstName.setTextFormatter(createUppercaseTextFormatter());
     addStudents_middleName.setTextFormatter(createUppercaseTextFormatter());
     addStudents_lastName.setTextFormatter(createUppercaseTextFormatter());  
     addStudents_address.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_contactNumber.setTextFormatter(createNumericTextFormatter());
     addStudents_religion.setTextFormatter(createUppercaseTextFormatter());
     addStudents_citizenship.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_motherName.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_motherOccupation.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_motherContactNumber.setTextFormatter(createNumericTextFormatter());
     addStudents_motherAddress.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_fatherName.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_fatherOccupation.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_fatherContactNumber.setTextFormatter(createNumericTextFormatter());
     addStudents_fatherAddress.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_elementary.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_elementaryYearGraduated.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_seniorHigh.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_strand.setTextFormatter(createUppercaseTextFormatter()); 
     addStudents_seniorHighYearGraduated.setTextFormatter(createUppercaseTextFormatter()); 
     
     
     
     
        
     //availablecourse
     availableCourse_course.setTextFormatter(createUppercaseTextFormatter());
     availableCourse_description.setTextFormatter(createUppercaseTextFormatter());
     availableCourse_degree.setTextFormatter(createUppercaseTextFormatter());    
   
        
  //studentgrades
  
    studentGrade_firstSem.setTextFormatter(createNumericTextFormatter());
   
    studentGrade_secondSem.setTextFormatter(createNumericTextFormatter());      
        
    //subject
    
    addSubjects_subjectCode.setTextFormatter(createUppercaseTextFormatter());
    addSubjects_description.setTextFormatter(createUppercaseTextFormatter());
    addSubjects_units.setTextFormatter(createUppercaseTextFormatter());
    addSubjects_program.setTextFormatter(createUppercaseTextFormatter());

     //instructors
    
    addInstructors_firstName.setTextFormatter(createUppercaseTextFormatter());
    addInstructors_middleName.setTextFormatter(createUppercaseTextFormatter());
    addInstructors_lastName.setTextFormatter(createUppercaseTextFormatter());
    addInstructors_educationalAtainment.setTextFormatter(createUppercaseTextFormatter());


    }
    @FXML
        public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

               //LINK YOUR LOGIN FORM 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show(); 

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
         @FXML
   public void displayUsername() {
    String sql = "SELECT username FROM user ";

    try {
        connect = database.connectDb();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            // Retrieve the username from the result set
            String retrievedUsername = resultSet.getString("username");

            // Set the retrieved username to the UI element
            username.setText(retrievedUsername);
        }

        // Close resources
        resultSet.close();
        statement.close();
        connect.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
 
}

