package studentManagementSystem;


public class subjectAdd {
    private final int subId;
    private final String subjectCode;
    private final String description;
    private final String units;
    private final String program;
    private final String status;

    // Adjust the constructor to accept four arguments
    public subjectAdd(int subId, String subjectCode, String description, String units, String program, String status) {
        this.subId = subId;
        this.subjectCode = subjectCode;
        this.description = description;
        this.units = units;
        this.program = program;
        this.status = status;
    }


    public int getSubId() {
        return subId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getDescription() {
        return description;
    }

    public String getUnits() {
        return units;
    }
    
    public String getProgram(){
        return program;
    }
    
     public String getStatus(){
        return status;
    }
   
    }
