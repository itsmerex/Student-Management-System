package studentManagementSystem;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentData {

    private String year;
    private String course;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String gender;
    private Date birthdate;
    private String status;
    private String image;
    private Double firstSem;
    private Double secondSem;
    private DoubleProperty finals;
    private double finalGrade;
    private IntegerProperty studentId;
    private String studentGrade_col_name;
    private String address;
    private String contactNumber;
    private String religion;
    private String citizenship;
    private String mothersName;
    private String mOccupation;
    private String mContactNum;
    private String mAddress;
    private String fathersName;
    private String fOccupation;
    private String fContactNum;
    private String fAddress;
    private String elementary;
    private String eYearGrad;
    private String seniorHigh;
    private String strand;
    private String shYearGrad;
   
   

    
    public studentData(int studentId, String year, String course, String firstName, String middleName, String lastName, String suffix, String gender, Date birthdate, String address, String contactNumber, String status, String image,
             String religion, String citizenship, String mothersName, String mOccupation, String mContactNum, String mAddress, String fathersName,
            String fOccupation, String fContactNum, String fAddress,String elementary, String eYearGrad, String seniorHigh, String strand, String shYearGrad) {
        
        this.studentId =  new SimpleIntegerProperty(studentId);
        this.year = year;
        this.course = course;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
        this.contactNumber = contactNumber;
        this.status = status;
        this.image = image;
        this.religion = religion;
        this.citizenship = citizenship;
        this.mothersName = mothersName;
        this.mOccupation = mOccupation;
        this.mContactNum = mContactNum;
        this.mAddress = mAddress;
        this.fathersName = fathersName;
        this.fOccupation = fOccupation;
        this.fContactNum = fContactNum;
        this.fAddress = fAddress;
        this.elementary = elementary;
        this.eYearGrad = eYearGrad;
        this.seniorHigh = seniorHigh;
        this.strand = strand;
        this.shYearGrad = shYearGrad;
    }

    public studentData(int studentId, String studentGrade_col_name,  String year, String course, Double firstSem, Double secondSem, Double finals) {
        this.studentId =  new SimpleIntegerProperty(studentId);
        this.studentGrade_col_name = studentGrade_col_name;
        this.year = year;
        this.course = course;
        this.firstSem = firstSem;
        this.secondSem = secondSem;
        this.finals = new SimpleDoubleProperty(finals);
    }


    @FXML
    private TableColumn<studentData, Integer> studentNumColumn;
    @FXML
    private TableColumn<studentData, String> yearColumn;
    @FXML
    private TableColumn<studentData, String> courseColumn;

    @FXML
    public void initialize() {
        studentNumColumn.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
    }

    private int studentGradeId;

    public int getStudentGradeId() {
        return studentGradeId;
    }

    public DoubleProperty finalProperty() {
        return finals;
    }

    public double getFinals() {
        return finals.get();
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinals(double finals) {
        this.finals.set(finals);
    }

    public IntegerProperty studentIdProperty() {
        return studentId;
    }

    public int getStudentId() {
        return studentId.get();
    }

    public void setStudentId(int studentId) {
        this.studentId.set(studentId);
    }

    public String getYear() {
        return year;
    }

    public String getCourse() {
        return course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public Double getFirstSem() {
        return firstSem;
    }

    public Double getSecondSem() {
        return secondSem;
    }
    
    public String getStudentGrade_col_name() {
    return studentGrade_col_name;
    }

    public String getAddress() {
        return address;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public String getReligion() {
        return religion;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getMothersName() {
        return mothersName;
    }
    
    public String getMOccupation() {
        return mOccupation;
    }

    public String getMContactNum() {
        return mContactNum;
    }

    public String getMAddress() {
        return mAddress;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getFOccupation() {
        return fOccupation;
    }

    public String getFContactNum() {
        return fContactNum;
    }

    public String getFAddress() {
        return fAddress;
    }

    public String getElementary() {
        return elementary;
    }

    public String getEYearGrad() {
        return eYearGrad;
    }
    
    public String getSeniorHigh() {
        return seniorHigh;
    }

    public String getStrand() {
        return strand;
    }
    
    public String getsSHYearGrad() {
        return shYearGrad;
    }

}

